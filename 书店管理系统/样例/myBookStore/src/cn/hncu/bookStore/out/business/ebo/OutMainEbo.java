package cn.hncu.bookStore.out.business.ebo;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import cn.hncu.bookStore.book.business.ebi.BookEbi;
import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.common.UuidModelConstance;
import cn.hncu.bookStore.common.uuid.dao.dao.UuidDao;
import cn.hncu.bookStore.common.uuid.dao.factory.UuidDaoFactory;
import cn.hncu.bookStore.out.business.ebi.OutMainEbi;
import cn.hncu.bookStore.out.dao.dao.OutDetailDao;
import cn.hncu.bookStore.out.dao.dao.OutMainDao;
import cn.hncu.bookStore.out.dao.factory.OutDetailDaoFactory;
import cn.hncu.bookStore.out.dao.factory.OutMainDaoFactory;
import cn.hncu.bookStore.out.vo.OutDetailModel;
import cn.hncu.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.bookStore.out.vo.OutMainModel;
import cn.hncu.bookStore.out.vo.OutMainQueryModel;
import cn.hncu.bookStore.stock.business.factory.StockEbiFactory;
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
public class OutMainEbo implements OutMainEbi{
	//注入dao
	
	OutMainDao outMainDao = OutMainDaoFactory.getOutMainDao();
	OutDetailDao outDetailDao = OutDetailDaoFactory.getOutDetailDao();
	UuidDao uuidDao = UuidDaoFactory.getUuidDao();
	BookEbi bookEbi = BookEbiFactory.getBookEbi();
	
	@Override
	public boolean create(OutMainModel outMain, List<OutDetailModel> outDetails) {
		//※※※库存操作1：在添加销售信息之前要进行防护:检查库存，看是否可能库存不够。如果不够，本次添加直接失败,不进行数据存储---return false;
		//检查库存----用明细单(outDetail)中的bookUuid
		//注入Stock模块的dao
		StockDao stockDao = StockDaoFactory.getStockDao();
		for(OutDetailModel detail : outDetails){
			StockQueryModel sqm = new StockQueryModel();
			sqm.setBookUuid(detail.getBookId());
			List<StockModel> lists = stockDao.getByCondition(sqm);
			if(lists==null||lists.size()==0){//库存中没有该图书信息
				JOptionPane.showMessageDialog(null, "库存中不存在《"+detail.getBookName()+"》,本次销售添加失败!");
				return false;
			}else {
				StockModel sm = lists.get(0);
				if(sm.getSumNum()<detail.getSumNum()){
					JOptionPane.showMessageDialog(null, "库存中《"+detail.getBookName()+"》数量不足,本次销售添加失败!");
					return false;
				}
			}
			
		}
		
		
		
		//////////1存储outMain信息///////////
		//补全outMain中的数据
		//需要:inUuid,inDate,inUserUuid   已组织:inUserUuid
		//还缺(需补):inUuid,inDate
		String outUuid = uuidDao.getNextUuid(UuidModelConstance.OUT_MAIN);
		outMain.setUuid(outUuid);
		outMain.setOutDate(System.currentTimeMillis());
		outMainDao.create(outMain);
		
		 //////////2存储inDetail信息///////////
		for(OutDetailModel model:outDetails){
			//补全每一个inDetail中的数据
			//需要:inDetailUuid,outMainUuid,bookUuid,sumNum,sumMoney   已组织:bookUuid,sumNum
	        //还缺(需补):inDetailUuid,outMainUuid,sumMoney
			model.setUuid(uuidDao.getNextUuid(UuidModelConstance.OUT_DETAIL));
			model.setOutId(outUuid);
			
			double sumMoney = model.getSumNum() * bookEbi.getSingle(model.getBookId()).getSalePrice();
			model.setSumMoney(sumMoney);
			outDetailDao.create(model);
			
			
			//※※※库存操作2：更新库存---把对应的每种图书的数量  减去  这次销售的数量
			StockQueryModel sqm = new StockQueryModel();
			sqm.setBookUuid(model.getBookId());
			List<StockModel> stocks = StockEbiFactory.getStockEbi().getByCondition(sqm);
			//经过之前的防护，list里面一定有一个值，而且库存一定可以更新成功
			StockModel stock = stocks.get(0);
			stock.setSumNum(stock.getSumNum()-model.getSumNum());
			StockDaoFactory.getStockDao().update(stock);
			
		}
		return true;
	}

	@Override
	public Map<OutMainModel, List<OutDetailModel>> getAll() {
		Map<OutMainModel,List<OutDetailModel>> map = new TreeMap<OutMainModel, List<OutDetailModel>>();
		
		List<OutMainModel> outMains = outMainDao.getAll();
		
		for(OutMainModel outMain: outMains ){
			//查询条件值对象的创建
			OutDetailQueryModel odqm = new OutDetailQueryModel();
			String inUuid = outMain.getUuid();
			odqm.setOutId(inUuid);

			List<OutDetailModel> details = outDetailDao.getbyCondition(odqm);
			
			map.put(outMain, details);
		}
		
		return map;
	}

	@Override
	public Map<OutMainModel, List<OutDetailModel>> getByCondition(
			OutMainQueryModel imqm, OutDetailQueryModel odqm) {
		Map<OutMainModel, List<OutDetailModel>> map = new TreeMap<OutMainModel, List<OutDetailModel>>();
		
		List<OutMainModel> list = outMainDao.getbyCondition(imqm);
		
		for(OutMainModel outMain : list){
			odqm.setOutId(outMain.getUuid());
			
			List<OutDetailModel> details = outDetailDao.getbyCondition(odqm);
			if(details.size()!=0){
				map.put(outMain, details);
			}
		}
		
		return map;
	}

}
