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
 * @author �º���
 *
 * @version 1.0
 */
public class InMainEbo implements InMainEbi{
	//ע��dao
	
	InMainDao inMainDao = InMainDaoFactory.getInMainDao();
	InDetailDao inDetailDao = InDetailDaoFactory.getInDetailDao();
	UuidDao uuidDao = UuidDaoFactory.getUuidDao();
	BookEbi bookEbi = BookEbiFactory.getBookEbi();
	
	@Override
	public boolean create(InMainModel inMain, List<InDetailModel> inDetails) {
		//////////1�洢inMain��Ϣ///////////
		//��ȫinMain�е�����
		//��Ҫ:inUuid,inDate,inUserUuid   ����֯:inUserUuid
		//��ȱ(�貹):inUuid,inDate
		String inUuid = uuidDao.getNextUuid(UuidModelConstance.IN_MAIN);
		inMain.setUuid(inUuid);
		inMain.setInDate(System.currentTimeMillis());
		inMainDao.create(inMain);
		
		 //////////2�洢inDetail��Ϣ///////////
		for(InDetailModel model:inDetails){
			//��ȫÿһ��inDetail�е�����
			//��Ҫ:inDetailUuid,inMainUuid,bookUuid,sumNum,sumMoney   ����֯:bookUuid,sumNum
	        //��ȱ(�貹):inDetailUuid,inMainUuid,sumMoney
			model.setUuid(uuidDao.getNextUuid(UuidModelConstance.IN_DETAIL));
			model.setInId(inUuid);
			
			double sumMoney = model.getSumNum() * bookEbi.getSingle(model.getBookId()).getInPrice();
			model.setSumMoney(sumMoney);
			inDetailDao.create(model);
			
			//////////������3 ͼ�����--�������///////////
			putInStock(model.getBookId(),model.getSumNum());
			
		}
		return true;
	}
	
	/**
	 * ��⶯��
	 * @param bookId
	 * @param bookName
	 */
	private void putInStock(String bookId, int sumNum) {
		//ע��Stockģ���dao
		StockDao dao = StockDaoFactory.getStockDao();
		
		//��ѯ��棬�����Ƿ��Ѿ����ڸ�bookUuid����Ӧ���飬���û����������ΪsumNum������Ϊ��ԭ�л������ټ���sumNum
		StockQueryModel sqm = new StockQueryModel();
		sqm.setBookUuid(bookId);
		List<StockModel> lists = dao.getByCondition(sqm);
		
		//�����û��������
		if(lists==null||lists.size()==0){
			//���ֲ�ֻ������֯����ģ���ֵ���󣬿��ģ���������߼����Լ���
			StockModel stock = new StockModel();
			
			//��:����� uuid
			stock.setUuid(UuidDaoFactory.getUuidDao().getNextUuid(UuidModelConstance.STOCK));
			
			//��: bookName רΪ��ʾ���û���������
			stock.setBookName(BookEbiFactory.getBookEbi().getSingle(bookId).getName());
			stock.setBookUuid(bookId);
			
			stock.setSumNum(sumNum);
			
			dao.create(stock);
			
		}else{//������Ѿ����ڸ�ͼ���Ӧ�Ŀ���¼
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
			//��ѯ����ֵ����Ĵ���
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
