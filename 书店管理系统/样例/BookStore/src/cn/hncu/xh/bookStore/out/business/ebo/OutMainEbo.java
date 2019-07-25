package cn.hncu.xh.bookStore.out.business.ebo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.common.constance.UuidModelConstance;
import cn.hncu.xh.bookStore.common.dao.dao.UuidDao;
import cn.hncu.xh.bookStore.common.dao.factory.UuidDaoFactory;
import cn.hncu.xh.bookStore.out.business.ebi.OutMainEbi;
import cn.hncu.xh.bookStore.out.dao.dao.OutMainDAO;
import cn.hncu.xh.bookStore.out.dao.factory.OutDetailDAOFactory;
import cn.hncu.xh.bookStore.out.dao.factory.OutMainDAOFactory;
import cn.hncu.xh.bookStore.out.vo.OutDetailModel;
import cn.hncu.xh.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.xh.bookStore.out.vo.OutMainModel;
import cn.hncu.xh.bookStore.out.vo.OutMainQueryModel;
import cn.hncu.xh.bookStore.stock.dao.factory.StockDAOFactory;
import cn.hncu.xh.bookStore.stock.vo.StockModel;
import cn.hncu.xh.bookStore.stock.vo.StockQueryModel;

/**
 * <p>
 * Title:OutMainEbo
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutMainEbo implements OutMainEbi {
	private double getPriceByBookUuid(String bookUuid) {
		BookModel book = BookEbiFactory.getBookEbi().getSingle(bookUuid);
		return book.getSalePrice();
	}

	public boolean create(OutMainModel outMain, List<OutDetailModel> details) {
		// 卫条件：检查库存，看看该次销售能否进行即库存数量是否足够
		for (OutDetailModel detail : details) {
			StockQueryModel sqm = new StockQueryModel();
			sqm.setBookUuid(detail.getBookUuid());
			List<StockModel> list = StockDAOFactory.getStockDAO()
					.getBycondition(sqm);
			if (list == null || list.size() == 0) {// 库中无货(没有该图书的库存信息)
				return false;
			} else {// 进过货，有库存信息
				StockModel stock = list.get(0);
				if (stock.getSumNum() < detail.getSumNum()) {
					return false;// 库存量不够
				}
			}
		}
		// 经过卫条件，能够走到这里，说明该次销售能够进行

		// 1、写OutMainModel值对象
		// 总共需要uuid、inUserUuid、inDate这3个数据，
		// 现在inUserUuid已经在表现层赋值,因此剩下的2个要在这里收集
		// uuid
		UuidDao uuidDao = UuidDaoFactory.getUuidDao();
		String outMainUuid = uuidDao.getNextNum(UuidModelConstance.OUT_MAIN);
		// 日期时间inDate
		long date = new Date().getTime();

		// 设置
		outMain.setUuid(outMainUuid);
		outMain.setOutDate(date);

		// 创建
		OutMainDAOFactory.getOutMainDAO().create(outMain);

		// ////////////////////////////////////////
		// 2、写OutDetailModel值对象
		for (OutDetailModel detail : details) {

			// 总共需要uuid、OutMainUuid、bookUuid、sumNum、sumMoney这5个数据，另外还需补一个专为显示给用户看的bookName
			// 现在bookUuid、sumNum已经在表现层赋值,OutMainUuid上面已经有了,因此剩下的4个要在这里收集
			// uuid
			UuidDao uuidDao2 = UuidDaoFactory.getUuidDao();
			String inDetailUuid = uuidDao2
					.getNextNum(UuidModelConstance.IN_DETAIL);
			// sumMoney = 数量*价格
			double sumMoney = detail.getSumNum()
					* this.getPriceByBookUuid(detail.getBookUuid());
			// 补一个专为显示给用户看的bookName
			String bookName = BookEbiFactory.getBookEbi().getSingle(
					detail.getBookUuid()).getName();
			// 设置
			detail.setUuid(inDetailUuid);
			detail.setOutUuid(outMainUuid);
			detail.setSumMoney(sumMoney);
			detail.setBookName(bookName);

			// 创建
			OutDetailDAOFactory.getOutDetailDAO().create(detail);

			// 更新库存
			 StockQueryModel sqm = new StockQueryModel();
			 sqm.setBookUuid(detail.getBookUuid());
			 List<StockModel> list =
			 StockDAOFactory.getStockDAO().getBycondition(sqm);
			 StockModel stock = list.get(0);
			 stock.setSumNum(stock.getSumNum()-detail.getSumNum());//更新数量
			 StockDAOFactory.getStockDAO().update(stock);//更新数据库
		}

		return true;
	}

	public Map<OutMainModel, List<OutDetailModel>> getAll() {
		 Map<OutMainModel, List<OutDetailModel>> map = new TreeMap<OutMainModel, List<OutDetailModel>>(); //利用TreeMap可实现排序
		 //读outMain
		 List<OutMainModel> mains = OutMainDAOFactory.getOutMainDAO().getAll(); //DAO中获取所有的元素
		 //遍历list，找到匹配对应销售单的销售明细
		 for(OutMainModel outMain: mains){
			 String outMainUuid = outMain.getUuid();
			 OutDetailQueryModel odqm = new OutDetailQueryModel();
			 odqm.setOutUuid(outMainUuid); 
			 List<OutDetailModel> details = OutDetailDAOFactory.getOutDetailDAO().getByCondition(odqm); //匹配销售明细
			 map.put(outMain, details); //写入map中
		 }
		
		return map;
	}

	public Map<OutMainModel, List<OutDetailModel>> getByCondition(
			OutMainQueryModel omqm, OutDetailQueryModel odqm) {
		Map<OutMainModel, List<OutDetailModel>> map = new TreeMap<OutMainModel, List<OutDetailModel>>();
		//通过调用dao层，把所有满足查询条件的OutMainModel列表找出来
		OutMainDAO outMainDAO = OutMainDAOFactory.getOutMainDAO();
		List<OutMainModel> mains =  outMainDAO.getByCondition(omqm);
		for(OutMainModel main : mains){
			//通过调用dao层，把满足明细查询条件值对象odqm的details和main打包成map的一条记录存入map
			odqm.setOutUuid(main.getUuid());
			List<OutDetailModel> details = OutDetailDAOFactory.getOutDetailDAO().getByCondition(odqm);
			if(details!=null && details.size()>0 ){
				map.put(main, details);
			}
		}
		
		return map;
	}

}
