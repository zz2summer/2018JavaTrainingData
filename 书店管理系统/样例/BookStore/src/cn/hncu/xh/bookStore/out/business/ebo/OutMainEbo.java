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
		// ������������棬�����ô������ܷ���м���������Ƿ��㹻
		for (OutDetailModel detail : details) {
			StockQueryModel sqm = new StockQueryModel();
			sqm.setBookUuid(detail.getBookUuid());
			List<StockModel> list = StockDAOFactory.getStockDAO()
					.getBycondition(sqm);
			if (list == null || list.size() == 0) {// �����޻�(û�и�ͼ��Ŀ����Ϣ)
				return false;
			} else {// ���������п����Ϣ
				StockModel stock = list.get(0);
				if (stock.getSumNum() < detail.getSumNum()) {
					return false;// ���������
				}
			}
		}
		// �������������ܹ��ߵ����˵���ô������ܹ�����

		// 1��дOutMainModelֵ����
		// �ܹ���Ҫuuid��inUserUuid��inDate��3�����ݣ�
		// ����inUserUuid�Ѿ��ڱ��ֲ㸳ֵ,���ʣ�µ�2��Ҫ�������ռ�
		// uuid
		UuidDao uuidDao = UuidDaoFactory.getUuidDao();
		String outMainUuid = uuidDao.getNextNum(UuidModelConstance.OUT_MAIN);
		// ����ʱ��inDate
		long date = new Date().getTime();

		// ����
		outMain.setUuid(outMainUuid);
		outMain.setOutDate(date);

		// ����
		OutMainDAOFactory.getOutMainDAO().create(outMain);

		// ////////////////////////////////////////
		// 2��дOutDetailModelֵ����
		for (OutDetailModel detail : details) {

			// �ܹ���Ҫuuid��OutMainUuid��bookUuid��sumNum��sumMoney��5�����ݣ����⻹�貹һ��רΪ��ʾ���û�����bookName
			// ����bookUuid��sumNum�Ѿ��ڱ��ֲ㸳ֵ,OutMainUuid�����Ѿ�����,���ʣ�µ�4��Ҫ�������ռ�
			// uuid
			UuidDao uuidDao2 = UuidDaoFactory.getUuidDao();
			String inDetailUuid = uuidDao2
					.getNextNum(UuidModelConstance.IN_DETAIL);
			// sumMoney = ����*�۸�
			double sumMoney = detail.getSumNum()
					* this.getPriceByBookUuid(detail.getBookUuid());
			// ��һ��רΪ��ʾ���û�����bookName
			String bookName = BookEbiFactory.getBookEbi().getSingle(
					detail.getBookUuid()).getName();
			// ����
			detail.setUuid(inDetailUuid);
			detail.setOutUuid(outMainUuid);
			detail.setSumMoney(sumMoney);
			detail.setBookName(bookName);

			// ����
			OutDetailDAOFactory.getOutDetailDAO().create(detail);

			// ���¿��
			 StockQueryModel sqm = new StockQueryModel();
			 sqm.setBookUuid(detail.getBookUuid());
			 List<StockModel> list =
			 StockDAOFactory.getStockDAO().getBycondition(sqm);
			 StockModel stock = list.get(0);
			 stock.setSumNum(stock.getSumNum()-detail.getSumNum());//��������
			 StockDAOFactory.getStockDAO().update(stock);//�������ݿ�
		}

		return true;
	}

	public Map<OutMainModel, List<OutDetailModel>> getAll() {
		 Map<OutMainModel, List<OutDetailModel>> map = new TreeMap<OutMainModel, List<OutDetailModel>>(); //����TreeMap��ʵ������
		 //��outMain
		 List<OutMainModel> mains = OutMainDAOFactory.getOutMainDAO().getAll(); //DAO�л�ȡ���е�Ԫ��
		 //����list���ҵ�ƥ���Ӧ���۵���������ϸ
		 for(OutMainModel outMain: mains){
			 String outMainUuid = outMain.getUuid();
			 OutDetailQueryModel odqm = new OutDetailQueryModel();
			 odqm.setOutUuid(outMainUuid); 
			 List<OutDetailModel> details = OutDetailDAOFactory.getOutDetailDAO().getByCondition(odqm); //ƥ��������ϸ
			 map.put(outMain, details); //д��map��
		 }
		
		return map;
	}

	public Map<OutMainModel, List<OutDetailModel>> getByCondition(
			OutMainQueryModel omqm, OutDetailQueryModel odqm) {
		Map<OutMainModel, List<OutDetailModel>> map = new TreeMap<OutMainModel, List<OutDetailModel>>();
		//ͨ������dao�㣬�����������ѯ������OutMainModel�б��ҳ���
		OutMainDAO outMainDAO = OutMainDAOFactory.getOutMainDAO();
		List<OutMainModel> mains =  outMainDAO.getByCondition(omqm);
		for(OutMainModel main : mains){
			//ͨ������dao�㣬��������ϸ��ѯ����ֵ����odqm��details��main�����map��һ����¼����map
			odqm.setOutUuid(main.getUuid());
			List<OutDetailModel> details = OutDetailDAOFactory.getOutDetailDAO().getByCondition(odqm);
			if(details!=null && details.size()>0 ){
				map.put(main, details);
			}
		}
		
		return map;
	}

}
