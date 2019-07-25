package cn.hncu.bookStore.out.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.bookStore.out.dao.dao.OutDetailDao;
import cn.hncu.bookStore.out.dao.factory.OutDetailDaoFactory;
import cn.hncu.bookStore.out.vo.OutDetailModel;
import cn.hncu.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.bookStore.util.FileIoUtil;
import cn.hncu.bookStore.util.StringComparison;

/**
 * ������ϸ��ʵ����
 * @author �º���
 *
 * @version 1.0
 */
public class OutDetailDaoSerImpl implements OutDetailDao{
	//������ϸ���ݵĴ洢���ļ���
	private final String FILE_NAME = "OutDetail.txt";
	
	@Override
	public boolean create(OutDetailModel outDetail) {
		List<OutDetailModel> lists = FileIoUtil.readFormFile(FILE_NAME);
		
		for(OutDetailModel model: lists){
			//�Ѿ��������Uuid���������
			if(model.getUuid().equals(outDetail.getUuid())){
				return false;
			}
		}
		
		lists.add(outDetail);
		FileIoUtil.write2file(lists, FILE_NAME);
		return true;
	}

	@Override
	public boolean delete(String uuid) {
		List<OutDetailModel> list = FileIoUtil.readFormFile(FILE_NAME);
		for(OutDetailModel model: list){
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
	public boolean update(OutDetailModel outDetail) {
		List<OutDetailModel> list  = FileIoUtil.readFormFile(FILE_NAME);
		for(int i=0;i<list.size();i++){
			//�ҵ��ˣ����޸�
			if(list.get(i).getUuid().equals(outDetail.getUuid())){
				list.set(i, outDetail);
				FileIoUtil.write2file(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public OutDetailModel getSingle(String uuid) {
		List<OutDetailModel> list = FileIoUtil.readFormFile(FILE_NAME);
		for(OutDetailModel model : list){
			//�ҵ��ˣ��ͷ���
			if(model.getUuid().equals(uuid)){
				return model;
			}
		}
		return null;
	}

	@Override
	public List<OutDetailModel> getAll() {
		return FileIoUtil.readFormFile(FILE_NAME);
	}

	@Override
	public List<OutDetailModel> getbyCondition(OutDetailQueryModel odqm) {
		List<OutDetailModel> lists = getAll();
		List<OutDetailModel> resulits = new ArrayList<OutDetailModel>();
		for(OutDetailModel model:lists){
			
			if(!StringComparison.stringEquals(model.getUuid(), odqm.getUuid())){
				continue;
			}
			
			if(!StringComparison.stringEquals(model.getOutId(), odqm.getOutId())){
				continue;
			}
			
			if(!StringComparison.stringEquals(model.getBookId(), odqm.getBookId())){
				continue;
			}
			
			if(odqm.getSumNum()>0){
				if(model.getSumNum()<odqm.getSumNum()){
					continue;
				}
			}
			if(odqm.getSumNum2()>0){
				if(model.getSumNum()>odqm.getSumNum2()){
					continue;
				}
			}
			
			if(odqm.getSumMoney()>0){
				if(model.getSumMoney()<odqm.getSumMoney()){
					continue;
				}
			}
			if(odqm.getSumMoney2()>0){
				if(model.getSumMoney()>odqm.getSumMoney2()){
					continue;
				}
			}
			
			resulits.add(model);
		}
		return resulits;
	}

}
