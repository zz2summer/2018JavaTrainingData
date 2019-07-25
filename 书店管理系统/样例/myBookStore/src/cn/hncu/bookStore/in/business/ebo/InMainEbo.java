package cn.hncu.bookStore.in.business.ebo;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.hncu.bookStore.book.business.ebi.BookEbi;
import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.common.UuidModelConstance;
import cn.hncu.bookStore.common.uuid.dao.dao.UuidDao;
import cn.hncu.bookStore.common.uuid.dao.factory.UuidDaoFactory;
import cn.hncu.bookStore.in.business.ebi.InMainEbi;
import cn.hncu.bookStore.in.business.factory.InMainEbiFactory;
import cn.hncu.bookStore.in.dao.dao.InDetailDao;
import cn.hncu.bookStore.in.dao.dao.InMainDao;
import cn.hncu.bookStore.in.dao.factory.InDetailDaoFactory;
import cn.hncu.bookStore.in.dao.factory.InMainDaoFactory;
import cn.hncu.bookStore.in.vo.InDetailModel;
import cn.hncu.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.bookStore.in.vo.InMainModel;
import cn.hncu.bookStore.in.vo.InMainQueryModel;
import cn.hncu.bookStore.stock.dao.dao.StockDao;
import cn.hncu.bookStore.stock.dao.factory.StockDaoFactory;
import cn.hncu.bookStore.stock.vo.StockModel;
import cn.hncu.bookStore.stock.vo.StockQueryModel;

/**
 * 
 * @author 陈浩翔
 *
 * @version 1.0
 */
public class InMainEbo implements InMainEbi{
	//注入dao
	
	InMainDao inMainDao = InMainDaoFactory.getInMainDao();
	InDetailDao inDetailDao = InDetailDaoFactory.getInDetailDao();
	UuidDao uuidDao = UuidDaoFactory.getUuidDao();
	BookEbi bookEbi = BookEbiFactory.getBookEbi();
	
	@Override
	public boolean create(InMainModel inMain, List<InDetailModel> inDetails) {
		//////////1存储inMain信息///////////
		//补全inMain中的数据
		//需要:inUuid,inDate,inUserUuid   已组织:inUserUuid
		//还缺(需补):inUuid,inDate
		String inUuid = uuidDao.getNextUuid(UuidModelConstance.IN_MAIN);
		inMain.setUuid(inUuid);
		inMain.setInDate(System.currentTimeMillis());
		inMainDao.create(inMain);
		
		 //////////2存储inDetail信息///////////
		for(InDetailModel model:inDetails){
			//补全每一个inDetail中的数据
			//需要:inDetailUuid,inMainUuid,bookUuid,sumNum,sumMoney   已组织:bookUuid,sumNum
	        //还缺(需补):inDetailUuid,inMainUuid,sumMoney
			model.setUuid(uuidDao.getNextUuid(UuidModelConstance.IN_DETAIL));
			model.setInId(inUuid);
			
			double sumMoney = model.getSumNum() * bookEbi.getSingle(model.getBookId()).getInPrice();
			model.setSumMoney(sumMoney);
			inDetailDao.create(model);
			
			//////////※※※3 图书入库--到库存表格///////////
			putInStock(model.getBookId(),model.getSumNum());
			
		}
		return true;
	}
	
	/**
	 * 入库动作
	 * @param bookId
	 * @param bookName
	 */
	private void putInStock(String bookId, int sumNum) {
		//注入Stock模块的dao
		StockDao dao = StockDaoFactory.getStockDao();
		
		//查询库存，看看是否已经存在该bookUuid所对应的书，如果没有则库存数据为sumNum，否则为在原有基础上再加上sumNum
		StockQueryModel sqm = new StockQueryModel();
		sqm.setBookUuid(bookId);
		List<StockModel> lists = dao.getByCondition(sqm);
		
		//库存中没有这种书
		if(lists==null||lists.size()==0){
			//表现层只负责组织进货模块的值对象，库存模块我们在逻辑层自己补
			StockModel stock = new StockModel();
			
			//补:库存编号 uuid
			stock.setUuid(UuidDaoFactory.getUuidDao().getNextUuid(UuidModelConstance.STOCK));
			
			//补: bookName 专为显示给用户看的书名
			stock.setBookName(BookEbiFactory.getBookEbi().getSingle(bookId).getName());
			stock.setBookUuid(bookId);
			
			stock.setSumNum(sumNum);
			
			dao.create(stock);
			
		}else{//库存中已经存在该图书对应的库存记录
			StockModel stock = lists.get(0);
			stock.setSumNum( stock.getSumNum()+sumNum );
			dao.update(stock);
		}
		
	}

	@Override
	public Map<InMainModel, List<InDetailModel>> getAll() {
		Map<InMainModel,List<InDetailModel>> map = new TreeMap<InMainModel, List<InDetailModel>>();
		
		List<InMainModel> inMains = inMainDao.getAll();
		
		for(InMainModel inMain: inMains ){
			//查询条件值对象的创建
			InDetailQueryModel idqm = new InDetailQueryModel();
			String inUuid = inMain.getUuid();
			idqm.setInId(inUuid);

			List<InDetailModel> details = inDetailDao.getbyCondition(idqm);
			
			map.put(inMain, details);
		}
		
		return map;
	}

	@Override
	public Map<InMainModel, List<InDetailModel>> getByCondition(
			InMainQueryModel imqm, InDetailQueryModel idqm) {
		Map<InMainModel, List<InDetailModel>> map = new TreeMap<InMainModel, List<InDetailModel>>();
		
		List<InMainModel> list = inMainDao.getbyCondition(imqm);
		
		for(InMainModel inMain : list){
			idqm.setInId(inMain.getUuid());
			
			List<InDetailModel> details = inDetailDao.getbyCondition(idqm);
			if(details.size()!=0){
				map.put(inMain, details);
			}
		}
		
		return map;
	}

}
