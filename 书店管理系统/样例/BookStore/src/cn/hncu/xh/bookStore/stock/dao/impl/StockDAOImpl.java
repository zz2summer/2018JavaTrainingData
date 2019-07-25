package cn.hncu.xh.bookStore.stock.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.stock.dao.dao.StockDAO;
import cn.hncu.xh.bookStore.stock.vo.StockModel;
import cn.hncu.xh.bookStore.stock.vo.StockQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:StockDAOImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class StockDAOImpl implements StockDAO {
	private final String FILE_NAME = "Stock.txt"; // ������ݴ洢��λ��

	// ����
	public boolean create(StockModel stock) {
		List<StockModel> list = getAll(); // ������п������
		// ����list��ƥ��uuid�����û��ƥ��ɹ���˵��û���ظ��ģ�����������ȥ
		for (StockModel model : list) {
			if (model.getUuid().equals(stock.getUuid())) {
				return false;
			}
		}
		list.add(stock);
		FileIOUtil.writeToFile(FILE_NAME, list);// д���Ӧ�ļ�
		return true;
	}
	//�޸�
	public boolean update(StockModel stock) {
		List<StockModel> list = getAll();// ������п������
		// ����list��ƥ����Ҫ�޸ĵĿ���uuid��ƥ��ɹ����滻��
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUuid().equals(stock.getUuid())){
				list.set(i, stock);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}
	//ɾ��
	public boolean delete(String uuid) {
		List<StockModel> list = getAll();// ������п������
		// ����list��ƥ��uuid��ƥ�䵽�˾�ɾ������Ӧ�Ŀ������
		for (StockModel model : list) {
			if (model.getUuid().equals(uuid)) {
				list.remove(model);
				FileIOUtil.writeToFile(FILE_NAME, list);// д���Ӧ�ļ�
				return true;
			}
		}
		return false;
	}
	//�������
	public List<StockModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME);// �Ӷ�Ӧ�ļ��ж�ȡ�������
	}
	//��ѯ
	public List<StockModel> getBycondition(StockQueryModel sqm) {
		List<StockModel> stocks = getAll();// ������п������
		List<StockModel> ret = new ArrayList<StockModel>(); //����װ���������Ŀ�����ݣ���󷵻س�ȥ
		//������������
		for(StockModel stock: stocks){
			//4���������� uuid, bookUuid, (sumNum, sumNum2)
			if(sqm.getUuid()!=null && sqm.getUuid().trim().length()>0){ //�ж��Ƿ�Ϸ�
				if(!sqm.getUuid().equals(stock.getUuid())){ //���˲�ƥ���
					continue;
				}
			}
			
			if(sqm.getBookUuid()!=null && sqm.getBookUuid().trim().length()>0){ //�ж��Ƿ�Ϸ�
				if(!sqm.getBookUuid().equals(stock.getBookUuid())){ //���˲�ƥ���
					continue;
				}
			}
			
			if(sqm.getSumNum()>0){ //���˱���С��ѯ������С��
				if(stock.getSumNum() < sqm.getSumNum() ){
					continue;
				}
			}
			if(sqm.getSumNum2()>0){//���˱�����ѯ���������
				if(stock.getSumNum() > sqm.getSumNum2() ){
					continue;
				}
			}
			ret.add(stock);//���뵽list��
		}
		return ret;
		
		
	}
	//��õ���
	public StockModel getSingle(String uuid) {
		List<StockModel> list = getAll();// ������п������
		// ����list��ƥ��uuid��ƥ�䵽�ˣ�ֱ�ӷ��ض�Ӧ�������
		for(StockModel model: list){
			if(model.getUuid().equals(uuid)){
				return model;
			}
		}
		return null;
	}
}
