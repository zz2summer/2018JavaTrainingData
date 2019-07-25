package cn.hncu.bookStore.in.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.bookStore.in.dao.dao.InDetailDao;
import cn.hncu.bookStore.in.dao.factory.InDetailDaoFactory;
import cn.hncu.bookStore.in.vo.InDetailModel;
import cn.hncu.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.bookStore.util.FileIoUtil;
import cn.hncu.bookStore.util.StringComparison;

/**
 * ������ϸ��ʵ����
 * @author �º���
 *
 * @version 1.0
 */
public class InDetailDaoSerImpl implements InDetailDao{
	//������ϸ���ݵĴ洢���ļ���
	private final String FILE_NAME = "InDetail.txt";
	
	@Override
	public boolean create(InDetailModel inDetail) {
		List<InDetailModel> lists = FileIoUtil.readFormFile(FILE_NAME);
		
		for(InDetailModel model: lists){
			//�Ѿ��������Uuid���������
			if(model.getUuid().equals(inDetail.getUuid())){
				return false;
			}
		}
		
		lists.add(inDetail);
		FileIoUtil.write2file(lists, FILE_NAME);
		return true;
	}

	@Override
	public boolean delete(String uuid) {
		List<InDetailModel> list = FileIoUtil.readFormFile(FILE_NAME);
		for(InDetailModel model: list){
			//���ڣ���ɾ��
			if(model.getUuid().equals(uuid)){
				list.remove(model);
				FileIoUtil.write2file(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(InDetailModel inDetail) {
		List<InDetailModel> list  = FileIoUtil.readFormFile(FILE_NAME);
		for(int i=0;i<list.size();i++){
			//�ҵ��ˣ����޸�
			if(list.get(i).getUuid().equals(inDetail.getUuid())){
				list.set(i, inDetail);
				FileIoUtil.write2file(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public InDetailModel getSingle(String uuid) {
		List<InDetailModel> list = FileIoUtil.readFormFile(FILE_NAME);
		for(InDetailModel model : list){
			//�ҵ��ˣ��ͷ���
			if(model.getUuid().equals(uuid)){
				return model;
			}
		}
		return null;
	}

	@Override
	public List<InDetailModel> getAll() {
		return FileIoUtil.readFormFile(FILE_NAME);
	}

	@Override
	public List<InDetailModel> getbyCondition(InDetailQueryModel idqm) {
		List<InDetailModel> lists = getAll();
		List<InDetailModel> resulits = new ArrayList<InDetailModel>();
		for(InDetailModel model:lists){
			
			if(!StringComparison.stringEquals(model.getUuid(), idqm.getUuid())){
				continue;
			}
			
			if(!StringComparison.stringEquals(model.getInId(), idqm.getInId())){
				continue;
			}
			
			if(!StringComparison.stringEquals(model.getBookId(), idqm.getBookId())){
				continue;
			}
			
			if(idqm.getSumNum()>0){
				if(model.getSumNum()<idqm.getSumNum()){
					continue;
				}
			}
			if(idqm.getSumNum2()>0){
				if(model.getSumNum()>idqm.getSumNum2()){
					continue;
				}
			}
			
			if(idqm.getSumMoney()>0){
				if(model.getSumMoney()<idqm.getSumMoney()){
					continue;
				}
			}
			if(idqm.getSumMoney2()>0){
				if(model.getSumMoney()>idqm.getSumMoney2()){
					continue;
				}
			}
			
			resulits.add(model);
		}
		return resulits;
	}

}
