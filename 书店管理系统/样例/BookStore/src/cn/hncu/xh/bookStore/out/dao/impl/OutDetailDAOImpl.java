package cn.hncu.xh.bookStore.out.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.out.dao.dao.OutDetailDAO;
import cn.hncu.xh.bookStore.out.vo.OutDetailModel;
import cn.hncu.xh.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:OutDetailDAOImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutDetailDAOImpl implements OutDetailDAO {
	private final static String FILE_NAME = "OutDetail.txt";// ������ϸ�洢���ļ�λ��

	// ������ϸ
	public boolean create(OutDetailModel OutDetail) {
		List<OutDetailModel> list = getAll(); // ���ȫ���Ѵ���Ԫ��
		// ����list���ж��Ƿ��Ѿ���ͬ��uuid��Ԫ�أ�����ֱ���˳�����֮�����ȥ
		for (OutDetailModel model : list) {
			if (model.getUuid().equals(OutDetail.getUuid())) {
				return false;
			}
		}
		list.add(OutDetail); // ��OutDetail����list��
		FileIOUtil.writeToFile(FILE_NAME, list); // д�뵽��Ӧ�ļ���
		return true;
	}

	public boolean delete(String uuid) {
		List<OutDetailModel> list = getAll(); // ���ȫ���Ѵ���Ԫ��
		// ����list���ж��Ƿ��Ѿ���ͬ��uuid��Ԫ�أ�����ֱ��ɾ��
		for (OutDetailModel model : list) {
			if (model.getUuid().equals(uuid)) {
				list.remove(model);
				FileIOUtil.writeToFile(FILE_NAME, list);// д�뵽��Ӧ�ļ���
				return true;
			}
		}
		return false;
	}

	public boolean update(OutDetailModel OutDetail) {
		List<OutDetailModel> list = getAll(); // ���ȫ���Ѵ���Ԫ��
		// ����list��ƥ��uuid����list���ҵ���Ӧλ�ã����滻����Ȼ��д���Ӧ�ļ�
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(OutDetail)) {
				list.set(i, OutDetail);
				return FileIOUtil.writeToFile(FILE_NAME, list);// д�뵽��Ӧ�ļ���
			}
		}
		return false;
	}

	public List<OutDetailModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME); // ֱ�Ӵ��ڴ��ж�Ӧ�ļ��ж�ȡ����
	}

	public List<OutDetailModel> getByCondition(OutDetailQueryModel odqm) {
		List<OutDetailModel> list = getAll();// ���ȫ���Ѵ���Ԫ��
  		List<OutDetailModel> result = new ArrayList<OutDetailModel>();//�����������odqmҪ���Ԫ��
  		
  		for(OutDetailModel model : list){
  			if(odqm.getUuid()!=null && odqm.getUuid().trim().length()>0){ ////�ж��Ƿ�Ϸ�
  				if(!odqm.getUuid().equals(model.getUuid())){ //���˲�ƥ���
  					continue;
  				}
  			}
  			if(odqm.getOutUuid()!=null && odqm.getOutUuid().trim().length()>0){//�ж��Ƿ�Ϸ�
  				if(!odqm.getOutUuid().equals(model.getOutUuid())){//���˲�ƥ���
  					continue;
  				}
  			}
  			if(odqm.getBookUuid()!=null && odqm.getBookUuid().trim().length()>0){//�ж��Ƿ�Ϸ�
  				if(!odqm.getBookUuid().equals(model.getBookUuid())){//���˲�ƥ���
  					continue;
  				}
  			}
  			
  			
  			if(odqm.getSumNum()>0){//����СֵС�ģ����˵�
  				if(odqm.getSumNum()>model.getSumNum()){
  					continue;
  				}
  			}
  			if(odqm.getSumNum2()>0){//���ֵ��ģ����˵�
  				if(odqm.getSumNum2()<model.getSumNum()){
  					continue;
  				}
  			}
  			if(odqm.getSumMoney()>0){//����СֵС�ģ����˵�
  				if(odqm.getSumMoney()>model.getSumMoney()){
  					continue;
  				}
  			}
  			if(odqm.getSumMoney2()>0){//���ֵ��ģ����˵�
  				if(odqm.getSumMoney2()<model.getSumMoney()){
  					continue;
  				}
  			}
  			result.add(model);
  		}
  		return result;
	}

	public OutDetailModel getSingle(String uuid) {
		List<OutDetailModel> list = getAll(); //��ȡȫ����������ϸ
		//�������е�������ϸ���ж��Ƿ����ƥ����ָ��uuid��������ϸ
		for (int i = 0; i < list.size(); i++) {
			OutDetailModel model = list.get(i);
			if (model.getUuid().equals(uuid)) {//��ƥ�䵽��ֱ�ӷ���������ϸ
				return model; 
			}
		}
		return null;
	}

}
