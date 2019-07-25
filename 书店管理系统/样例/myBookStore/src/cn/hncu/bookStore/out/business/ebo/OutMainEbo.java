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
 * @author �º���
 *
 * @version 1.0
 */
public class OutMainEbo implements OutMainEbi{
	//ע��dao
	
	OutMainDao outMainDao = OutMainDaoFactory.getOutMainDao();
	OutDetailDao outDetailDao = OutDetailDaoFactory.getOutDetailDao();
	UuidDao uuidDao = UuidDaoFactory.getUuidDao();
	BookEbi bookEbi = BookEbiFactory.getBookEbi();
	
	@Override
	public boolean create(OutMainModel outMain, List<OutDetailModel> outDetails) {
		//������������1�������������Ϣ֮ǰҪ���з���:����棬���Ƿ���ܿ�治��������������������ֱ��ʧ��,���������ݴ洢---return false;
		//�����----����ϸ��(outDetail)�е�bookUuid
		//ע��Stockģ���dao
		StockDao stockDao = StockDaoFactory.getStockDao();
		for(OutDetailModel detail : outDetails){
			StockQueryModel sqm = new StockQueryModel();
			sqm.setBookUuid(detail.getBookId());
			List<StockModel> lists = stockDao.getByCondition(sqm);
			if(lists==null||lists.size()==0){//�����û�и�ͼ����Ϣ
				JOptionPane.showMessageDialog(null, "����в����ڡ�"+detail.getBookName()+"��,�����������ʧ��!");
				return false;
			}else {
				StockModel sm = lists.get(0);
				if(sm.getSumNum()<detail.getSumNum()){
					JOptionPane.showMessageDialog(null, "����С�"+detail.getBookName()+"����������,�����������ʧ��!");
					return false;
				}
			}
			
		}
		
		
		
		//////////1�洢outMain��Ϣ///////////
		//��ȫoutMain�е�����
		//��Ҫ:inUuid,inDate,inUserUuid   ����֯:inUserUuid
		//��ȱ(�貹):inUuid,inDate
		String outUuid = uuidDao.getNextUuid(UuidModelConstance.OUT_MAIN);
		outMain.setUuid(outUuid);
		outMain.setOutDate(System.currentTimeMillis());
		outMainDao.create(outMain);
		
		 //////////2�洢inDetail��Ϣ///////////
		for(OutDetailModel model:outDetails){
			//��ȫÿһ��inDetail�е�����
			//��Ҫ:inDetailUuid,outMainUuid,bookUuid,sumNum,sumMoney   ����֯:bookUuid,sumNum
	        //��ȱ(�貹):inDetailUuid,outMainUuid,sumMoney
			model.setUuid(uuidDao.getNextUuid(UuidModelConstance.OUT_DETAIL));
			model.setOutId(outUuid);
			
			double sumMoney = model.getSumNum() * bookEbi.getSingle(model.getBookId()).getSalePrice();
			model.setSumMoney(sumMoney);
			outDetailDao.create(model);
			
			
			//������������2�����¿��---�Ѷ�Ӧ��ÿ��ͼ�������  ��ȥ  ������۵�����
			StockQueryModel sqm = new StockQueryModel();
			sqm.setBookUuid(model.getBookId());
			List<StockModel> stocks = StockEbiFactory.getStockEbi().getByCondition(sqm);
			//����֮ǰ�ķ�����list����һ����һ��ֵ�����ҿ��һ�����Ը��³ɹ�
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
			//��ѯ����ֵ����Ĵ���
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
