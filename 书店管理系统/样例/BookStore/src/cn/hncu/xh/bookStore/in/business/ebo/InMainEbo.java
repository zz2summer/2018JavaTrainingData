package cn.hncu.xh.bookStore.in.business.ebo;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.dao.factory.BookDaoFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.common.constance.UuidModelConstance;
import cn.hncu.xh.bookStore.common.dao.dao.UuidDao;
import cn.hncu.xh.bookStore.common.dao.factory.UuidDaoFactory;
import cn.hncu.xh.bookStore.in.business.ebi.InMainEbi;
import cn.hncu.xh.bookStore.in.dao.factory.InDetailDAOFactory;
import cn.hncu.xh.bookStore.in.dao.factory.InMainDaoFactory;
import cn.hncu.xh.bookStore.in.vo.InDetailModel;
import cn.hncu.xh.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.xh.bookStore.in.vo.InMainModel;
import cn.hncu.xh.bookStore.in.vo.InMainQueryModel;
import cn.hncu.xh.bookStore.stock.dao.factory.StockDAOFactory;
import cn.hncu.xh.bookStore.stock.vo.StockModel;
import cn.hncu.xh.bookStore.stock.vo.StockQueryModel;
import cn.hncu.xh.bookStore.user.dao.factory.UserDaoFactory;

/**
 * <p>
 * Title:InMainEbo
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
// 实现类
public class InMainEbo implements InMainEbi {
	// 创建订单
	public boolean create(InMainModel inMain, List<InDetailModel> list) {
		// 为inMainModel补信息（除表现层没有收集的所有其他信息）
		UuidDao uuidDao = UuidDaoFactory.getUuidDao();
		String inMainUuid = uuidDao.getNextNum(UuidModelConstance.IN_MAIN);
		inMain.setUuid(inMainUuid);
		inMain.setInDate(System.currentTimeMillis()); // 设置时间，这里是获取的系统的时间，返回一个long型的值
		
		//为外键补信息
		String name=UserDaoFactory.getUserDao().getSingle(inMain.getInUserUuid()).getName();
		inMain.setInUserName(name);
		// inMain数据已经收集完成，存储
		boolean isSuccess = InMainDaoFactory.getInMainDao().create(inMain);
		if (!isSuccess) { // 如果失败，那么明细就不用再添加（存储）
			return false;
		}
		
		
		// 为inDetailModel补信息（除表现层没有收集的所有其他信息）
		for (InDetailModel inDetail : list) {
			// 补uuid
			inDetail.setUuid(UuidDaoFactory.getUuidDao().getNextNum(
					UuidModelConstance.IN_DETAIL));// 设置inDetail的uuid（唱票模式）
			// 补inMainUuid
			inDetail.setInUuid(inMainUuid); // 设置订单明细的订单号
			// 补sumMoney
			double sum = inDetail.getSumNum()
					* getInPriceByBookUuid(inDetail.getBookUuid());
			inDetail.setSunMoney(sum); // 设置总金额
			// 调订单明细的Dao的工厂方法，创建订单明细
			InDetailDAOFactory.getInDetailDao().create(inDetail);
			
			//入库操作（把书的uuid和数量传入我们自己定义的方法中）
			putInSock(inDetail.getBookUuid(),inDetail.getSumNum());
		}
		return true;
	}
	//把库存模块的增和改合在一起
	private void putInSock(String bookUuid, int sumNum) {
		//思路：先要把库中的所有图书遍历出来，看看该书是否已经存在，若存在则修改数量，否则新加一条记录
		//由于dao中有条件查询，因此可直接用bookUuid封装成条件来查询，这样就不用自己遍历
		StockQueryModel sqm = new StockQueryModel();
		sqm.setBookUuid(bookUuid);
		List<StockModel> list = StockDAOFactory.getStockDAO().getBycondition(sqm);
		if(list==null || list.size()==0){//库中不存在该图书
			//新增，要补一个uuid数据。还要另加一个为显示给用户看的数据bookName
			String uuid = UuidDaoFactory.getUuidDao().getNextNum(UuidModelConstance.STOCK);
			String bookName = BookDaoFactory.getBookDao().getSingle(bookUuid).getName();
			
			//组织
			StockModel stock = new StockModel();
			stock.setUuid(uuid);
			stock.setBookUuid(bookUuid);
			stock.setSumNum(sumNum);
			stock.setBookName(bookName);//补的
			
			//调用数据层进行新增create()
			StockDAOFactory.getStockDAO().create(stock);
		}else{//存在，则是修改
			StockModel stock = list.get(0);
			//stock.setBookUuid(bookUuid);//只要修改数量sumNum就可以了
			stock.setSumNum( stock.getSumNum()+sumNum );//修改库存数量
			//调用数据层进行修改：update
			StockDAOFactory.getStockDAO().update(stock);
		}
		
	}

	// 获取指定图书uuid图书的价格
	private double getInPriceByBookUuid(String bookUuid) {
		// 调用图书类business层的工厂方法根据指定的bookUuid获得BookModel
		BookModel book = BookEbiFactory.getBookEbi().getSingle(bookUuid);
		return book.getInPrice();
	}
   //把订单和订单明细封装，用map装好
	public Map<InMainModel, List<InDetailModel>> getAll() {
		Map<InMainModel, List<InDetailModel>> map=new TreeMap<InMainModel, List<InDetailModel>>(); //使用TreeMap,可以实现排序 
		List<InMainModel> inMainList = InMainDaoFactory.getInMainDao().getAll(); //获取所有的InMainModel
		//遍历所有的InMainModel，匹配对应InMainModel的InDetailModel，并装到inDetaiList中，最后加入到map中
		for (InMainModel inMain : inMainList) {
			InDetailQueryModel idqm = new InDetailQueryModel();
			idqm.setInUuid(inMain.getUuid());
			List<InDetailModel> inDetaiList = InDetailDAOFactory.getInDetailDao().getBycondition(idqm);
			map.put(inMain,inDetaiList);
			
		}
		return map;
	}
	//查询
	public Map<InMainModel, List<InDetailModel>> getByCondition(InMainQueryModel imqm, InDetailQueryModel idqm) {
		Map<InMainModel,List<InDetailModel>> map=new TreeMap<InMainModel, List<InDetailModel>>();//使用TreeMap,可以实现排序
		List<InMainModel> inMainList=InMainDaoFactory.getInMainDao().getBycondition(imqm);//找到满足imqm值对象的所有的InMainModel，并装入inMainList中
		//遍历inMainList，匹配对应的订单明细，并且满足idqm值对象
		for(InMainModel inMain:inMainList){
			idqm.setInUuid(inMain.getUuid());//匹配同一个订单的订单明细
			List<InDetailModel> inDetailList =InDetailDAOFactory.getInDetailDao().getBycondition(idqm);//找到所有满足idqm值对象的订单明细
			if(inDetailList!=null&&inDetailList.size()>0){
				map.put(inMain, inDetailList);
			}
			
		}
		return map;
	}
	
}
