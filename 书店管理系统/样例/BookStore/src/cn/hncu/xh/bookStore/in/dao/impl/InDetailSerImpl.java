package cn.hncu.xh.bookStore.in.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.in.dao.dao.InDtailDao;
import cn.hncu.xh.bookStore.in.vo.InDetailModel;
import cn.hncu.xh.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 *<p>Title:InDetailSerImpl</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
//ʵ����
public class InDetailSerImpl implements InDtailDao {

	private static final String FILE_NAME = "inDetail.txt";

	public boolean create(InDetailModel inDetail) {
		List<InDetailModel> list = getAll(); // ���ȫ���Ѵ���Ԫ��
		// ����list���ж��Ƿ��Ѿ���ͬ��uuid��Ԫ�أ�����ֱ���˳�����֮�����ȥ
		for (InDetailModel model : list) {
			if (model.getUuid().equals(inDetail.getUuid())) {
				return false;
			}
		}
		list.add(inDetail); // ��inDetail����list��
		FileIOUtil.writeToFile(FILE_NAME, list); // д�뵽��Ӧ�ļ���
		return true;
	}

	public boolean delete(String uuid) {
		List<InDetailModel> list = getAll(); // ���ȫ���Ѵ���Ԫ��
		// ����list���ж��Ƿ��Ѿ���ͬ��uuid��Ԫ�أ�����ֱ��ɾ��
		for (InDetailModel model : list) {
			if (model.getUuid().equals(uuid)) {
				list.remove(model);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}
	//�����ڴ������еĶ�����ϸ
	public List<InDetailModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME);
	}

	public List<InDetailModel> getBycondition(InDetailQueryModel idqm) {
		List<InDetailModel> list = getAll();		// �Ӻ�̨�����е����ݼ���ȡ����
		List<InDetailModel> ret = new ArrayList<InDetailModel>();// ��Ž����
		if (idqm == null) {
			return list;
		}
		// Ȼ����������������ɸѡ��ɸѡʣ�µľ��ǲ�ѯ���
		for (InDetailModel inDetail : list) {
			// ���������ж�uuid
			if (idqm.getUuid() != null && idqm.getUuid().trim().length() > 0) {// ����֤��ѯ������Ч
				if (!idqm.getUuid().equals(inDetail.getUuid())) { //���˵�uuid��ƥ���
					continue;
				}
			}
			// ���������ж�inUuid
			if (idqm.getInUuid() != null && idqm.getInUuid().trim().length() > 0) {// ����֤��ѯ������Ч
				if (!idqm.getInUuid().equals(inDetail.getInUuid())) { //���˵�inUuid��ƥ���
					continue;
				}
			}
			// ���������ж�bookUuid
			if (idqm.getBookUuid() != null && idqm.getBookUuid().trim().length() > 0) {// ����֤��ѯ������Ч
				if (!idqm.getBookUuid().equals(inDetail.getBookUuid())) { //���˵�bookUuid��ƥ���
					continue;
				}
			}
			//���߼���������,����������Сֵ
			if(idqm.getSumNum()>0){
				if(idqm.getSumNum()>inDetail.getSumNum()){ //���˱���С����С��
					continue;
				}
			}
			//���߼���������,�����������ֵ
			if(idqm.getSumNum2()>0){
				if(idqm.getSumNum2()<inDetail.getSumNum()){ //���˱�����������
					continue;
				}
			}
			//���߼���������,�ܽ�����Сֵ
			if(idqm.getSumNum()>0){
				if(idqm.getSumNum()>inDetail.getSumNum()){ //���˱���С�ܽ��С��
					continue;
				}
			}
			//���߼���������,�ܽ������ֵ
			if(idqm.getSumNum2()>0){
				if(idqm.getSumNum2()<inDetail.getSumNum()){ //���˱�����ܽ����
					continue;
				}
			}
			ret.add(inDetail);
		}
		return ret;
		
	}
	//���ָ��uuid�Ķ�����ϸ
	public InDetailModel getSingle(String uuid) {
		List<InDetailModel> list = getAll(); //��ȡȫ���Ķ�����ϸ
		//�������еĶ�����ϸ���ж��Ƿ����ƥ����ָ��uuid�Ķ�����ϸ
		for (int i = 0; i < list.size(); i++) {
			InDetailModel model = list.get(i);
			if (model.getUuid().equals(uuid)) {//��ƥ�䵽��ֱ�ӷ��ض�����ϸ
				return model; 
			}
		}
		return null;
	}
	
	public boolean update(InDetailModel inMain) {
		List<InDetailModel> list = getAll();
		for (int i = 0; i < list.size(); i++) {
			InDetailModel model = list.get(i);
			if (model.getUuid().equals(inMain.getUuid())) {
				list.set(i, inMain);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}

}
