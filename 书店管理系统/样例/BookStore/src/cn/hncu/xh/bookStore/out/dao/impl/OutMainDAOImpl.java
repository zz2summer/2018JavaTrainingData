package cn.hncu.xh.bookStore.out.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.out.dao.dao.OutMainDAO;
import cn.hncu.xh.bookStore.out.vo.OutMainModel;
import cn.hncu.xh.bookStore.out.vo.OutMainQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:OutMainDAOImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutMainDAOImpl implements OutMainDAO {
	private final static String FILE_NAME = "OutMian.txt"; // ���۵��洢���ļ�λ��

	// �������۵�
	public boolean create(OutMainModel OutMain) {
		List<OutMainModel> list = getAll(); // ���ȫ���Ѵ���Ԫ��
		// ����list���ж��Ƿ��Ѿ���ͬ��uuid��Ԫ�أ�����ֱ���˳�����֮�����ȥ
		for (OutMainModel model : list) {
			if (model.getUuid().equals(OutMain.getUuid())) {
				return false;
			}
		}
		list.add(OutMain); // ��inMian����list��
		FileIOUtil.writeToFile(FILE_NAME, list); // д�뵽��Ӧ�ļ���
		return true;
	}

	public boolean delete(String uuid) {
		List<OutMainModel> list = getAll(); // ���ȫ���Ѵ���Ԫ��
		// ����list���ж��Ƿ��Ѿ���ͬ��uuid��Ԫ�أ�����ֱ��ɾ��
		for (OutMainModel model : list) {
			if (model.getUuid().equals(uuid)) {
				list.remove(model);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}

	public boolean update(OutMainModel OutMain) {
		List<OutMainModel> list = getAll(); // ���ȫ���Ѵ���Ԫ��
		// ����list��ƥ��uuid����list���ҵ���Ӧλ�ã����滻����Ȼ��д���Ӧ�ļ�
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(OutMain)) {
				list.set(i, OutMain);
				return FileIOUtil.writeToFile(FILE_NAME, list);
			}
		}
		return false;
	}

	public List<OutMainModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME); //ֱ�Ӵ��ڴ��ж�Ӧ�ļ��ж�ȡ����
	}

	public List<OutMainModel> getByCondition(OutMainQueryModel omqm) {
		List<OutMainModel> list = getAll();// ���ȫ���Ѵ���Ԫ��
  		List<OutMainModel> result = new ArrayList<OutMainModel>(); //�����������omqmҪ���Ԫ��
  		//������ǿforѭ������list��ɸѡ��������������
  		for(OutMainModel model : list){
  			if(omqm.getUuid()!=null && omqm.getUuid().trim().length()>0){ //�ж��Ƿ�Ϸ�
  				if(!omqm.getUuid().equals(model.getUuid())){ //���˵�����ƥ���
  					continue;
  				}
  			}
  			if(omqm.getOutUserUuid()!=null && omqm.getOutUserUuid().trim().length()>0){//�ж��Ƿ�Ϸ�
  				if(!omqm.getOutUserUuid().equals(model.getOutUserUuid())){ //���˵�����ƥ���
  					continue;
  				}
  			}
  			if(omqm.getOutDate()>0){//����СֵС�ģ����˵�
  				if(omqm.getOutDate()>model.getOutDate()){
  					continue;
  				}
  			}
  			if(omqm.getOutDate2()>0){//���ֵ��ģ����˵�
  				if(omqm.getOutDate2()<model.getOutDate()){
  					continue;
  				}
  			}
  			result.add(model);
  		}
  		return result;
	}

	public OutMainModel getSingle(String uuid) {
		List<OutMainModel> list = getAll();// ���ȫ���Ѵ���Ԫ��
		//������ǿforѭ������list��ƥ���Ӧuuid��OutMainModel���������
		for(OutMainModel model : list){
			if(model.getUuid().equals(uuid)){
				return model;
			}
		}
		return null;
	}

}
