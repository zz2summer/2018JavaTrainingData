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
// ʵ����
public class InMainEbo implements InMainEbi {
	// ��������
	public boolean create(InMainModel inMain, List<InDetailModel> list) {
		// ΪinMainModel����Ϣ�������ֲ�û���ռ�������������Ϣ��
		UuidDao uuidDao = UuidDaoFactory.getUuidDao();
		String inMainUuid = uuidDao.getNextNum(UuidModelConstance.IN_MAIN);
		inMain.setUuid(inMainUuid);
		inMain.setInDate(System.currentTimeMillis()); // ����ʱ�䣬�����ǻ�ȡ��ϵͳ��ʱ�䣬����һ��long�͵�ֵ
		
		//Ϊ�������Ϣ
		String name=UserDaoFactory.getUserDao().getSingle(inMain.getInUserUuid()).getName();
		inMain.setInUserName(name);
		// inMain�����Ѿ��ռ���ɣ��洢
		boolean isSuccess = InMainDaoFactory.getInMainDao().create(inMain);
		if (!isSuccess) { // ���ʧ�ܣ���ô��ϸ�Ͳ�������ӣ��洢��
			return false;
		}
		
		
		// ΪinDetailModel����Ϣ�������ֲ�û���ռ�������������Ϣ��
		for (InDetailModel inDetail : list) {
			// ��uuid
			inDetail.setUuid(UuidDaoFactory.getUuidDao().getNextNum(
					UuidModelConstance.IN_DETAIL));// ����inDetail��uuid����Ʊģʽ��
			// ��inMainUuid
			inDetail.setInUuid(inMainUuid); // ���ö�����ϸ�Ķ�����
			// ��sumMoney
			double sum = inDetail.getSumNum()
					* getInPriceByBookUuid(inDetail.getBookUuid());
			inDetail.setSunMoney(sum); // �����ܽ��
			// ��������ϸ��Dao�Ĺ�������������������ϸ
			InDetailDAOFactory.getInDetailDao().create(inDetail);
			
			//�������������uuid���������������Լ�����ķ����У�
			putInSock(inDetail.getBookUuid(),inDetail.getSumNum());
		}
		return true;
	}
	//�ѿ��ģ������͸ĺ���һ��
	private void putInSock(String bookUuid, int sumNum) {
		//˼·����Ҫ�ѿ��е�����ͼ��������������������Ƿ��Ѿ����ڣ����������޸������������¼�һ����¼
		//����dao����������ѯ����˿�ֱ����bookUuid��װ����������ѯ�������Ͳ����Լ�����
		StockQueryModel sqm = new StockQueryModel();
		sqm.setBookUuid(bookUuid);
		List<StockModel> list = StockDAOFactory.getStockDAO().getBycondition(sqm);
		if(list==null || list.size()==0){//���в����ڸ�ͼ��
			//������Ҫ��һ��uuid���ݡ���Ҫ���һ��Ϊ��ʾ���û���������bookName
			String uuid = UuidDaoFactory.getUuidDao().getNextNum(UuidModelConstance.STOCK);
			String bookName = BookDaoFactory.getBookDao().getSingle(bookUuid).getName();
			
			//��֯
			StockModel stock = new StockModel();
			stock.setUuid(uuid);
			stock.setBookUuid(bookUuid);
			stock.setSumNum(sumNum);
			stock.setBookName(bookName);//����
			
			//�������ݲ��������create()
			StockDAOFactory.getStockDAO().create(stock);
		}else{//���ڣ������޸�
			StockModel stock = list.get(0);
			//stock.setBookUuid(bookUuid);//ֻҪ�޸�����sumNum�Ϳ�����
			stock.setSumNum( stock.getSumNum()+sumNum );//�޸Ŀ������
			//�������ݲ�����޸ģ�update
			StockDAOFactory.getStockDAO().update(stock);
		}
		
	}

	// ��ȡָ��ͼ��uuidͼ��ļ۸�
	private double getInPriceByBookUuid(String bookUuid) {
		// ����ͼ����business��Ĺ�����������ָ����bookUuid���BookModel
		BookModel book = BookEbiFactory.getBookEbi().getSingle(bookUuid);
		return book.getInPrice();
	}
   //�Ѷ����Ͷ�����ϸ��װ����mapװ��
	public Map<InMainModel, List<InDetailModel>> getAll() {
		Map<InMainModel, List<InDetailModel>> map=new TreeMap<InMainModel, List<InDetailModel>>(); //ʹ��TreeMap,����ʵ������ 
		List<InMainModel> inMainList = InMainDaoFactory.getInMainDao().getAll(); //��ȡ���е�InMainModel
		//�������е�InMainModel��ƥ���ӦInMainModel��InDetailModel����װ��inDetaiList�У������뵽map��
		for (InMainModel inMain : inMainList) {
			InDetailQueryModel idqm = new InDetailQueryModel();
			idqm.setInUuid(inMain.getUuid());
			List<InDetailModel> inDetaiList = InDetailDAOFactory.getInDetailDao().getBycondition(idqm);
			map.put(inMain,inDetaiList);
			
		}
		return map;
	}
	//��ѯ
	public Map<InMainModel, List<InDetailModel>> getByCondition(InMainQueryModel imqm, InDetailQueryModel idqm) {
		Map<InMainModel,List<InDetailModel>> map=new TreeMap<InMainModel, List<InDetailModel>>();//ʹ��TreeMap,����ʵ������
		List<InMainModel> inMainList=InMainDaoFactory.getInMainDao().getBycondition(imqm);//�ҵ�����imqmֵ��������е�InMainModel����װ��inMainList��
		//����inMainList��ƥ���Ӧ�Ķ�����ϸ����������idqmֵ����
		for(InMainModel inMain:inMainList){
			idqm.setInUuid(inMain.getUuid());//ƥ��ͬһ�������Ķ�����ϸ
			List<InDetailModel> inDetailList =InDetailDAOFactory.getInDetailDao().getBycondition(idqm);//�ҵ���������idqmֵ����Ķ�����ϸ
			if(inDetailList!=null&&inDetailList.size()>0){
				map.put(inMain, inDetailList);
			}
			
		}
		return map;
	}
	
}
