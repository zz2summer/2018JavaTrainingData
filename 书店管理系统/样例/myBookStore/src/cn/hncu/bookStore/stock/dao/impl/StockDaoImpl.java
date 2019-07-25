package cn.hncu.bookStore.stock.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.bookStore.stock.dao.dao.StockDao;
import cn.hncu.bookStore.stock.vo.StockModel;
import cn.hncu.bookStore.stock.vo.StockQueryModel;
import cn.hncu.bookStore.util.FileIoUtil;
import cn.hncu.bookStore.util.StringComparison;

/**
 * ���ģ�����ݲ��ʵ����  
 * @author �º���
 *
 * @version 1.0  2016-4-20
 */
public class StockDaoImpl implements StockDao{
	private final String FILE_NAME = "Stock.txt";
	
	@Override
	public boolean create(StockModel stock) {
		List<StockModel> lists = FileIoUtil.readFormFile(FILE_NAME);
		for(StockModel model :lists){
			if(model.getUuid().equals(stock.getUuid())){
				return false;
			}
		}
		lists.add(stock);
		FileIoUtil.write2file(lists, FILE_NAME);
		return true;
	}

	@Override
	public List<StockModel> getAl() {
		return FileIoUtil.readFormFile(FILE_NAME);
	}

	@Override
	public boolean update(StockModel stock) {
		List<StockModel> lists = FileIoUtil.readFormFile(FILE_NAME);
		for(int i=0;i<lists.size();i++){
			if(lists.get(i).getUuid().equals(stock.getUuid())){
				lists.set(i, stock);
				FileIoUtil.write2file(lists, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<StockModel> getByCondition(StockQueryModel sqm) {
		List<StockModel> lists = FileIoUtil.readFormFile(FILE_NAME);
		List<StockModel> results = new ArrayList<StockModel>();
		
		for(StockModel model : lists){
			//������
			
			//�ȽϿ��ID
			if(!StringComparison.stringEquals(model.getUuid(), sqm.getUuid())){
				continue;
			}
			
			//�Ƚ�ͼ��ID
			if(!StringComparison.stringEquals(model.getBookUuid(), sqm.getBookUuid())){
				continue;
			}
			
			//����ѯ��С����
			if(sqm.getSumNum()>0){
				if(sqm.getSumNum()>model.getSumNum()){
					continue;
				}
			}
			
			//����ѯ�������
			if(sqm.getSumNum2()>0){
				if(sqm.getSumNum2()<model.getSumNum()){
					continue;
				}
			}
			
			results.add(model);
		}
		return results;
	}

	@Override
	public StockModel getSingle(String uuid) {
		List<StockModel> lists = FileIoUtil.readFormFile(FILE_NAME);
		for(StockModel model : lists){
			if(model.getUuid().equals(uuid)){
				//�ҵ�uuid��ͬ��ֱ�ӷ��ؿ�����
				return model;
			}
		}
		return null;
	}

}
