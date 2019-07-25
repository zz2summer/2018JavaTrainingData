package cn.hncu.bookStore.common.uuid.dao.impl;

import java.util.List;

import cn.hncu.bookStore.common.UuidModelConstance;
import cn.hncu.bookStore.common.uuid.dao.dao.UuidDao;
import cn.hncu.bookStore.common.uuid.vo.UuidModel;
import cn.hncu.bookStore.util.FileIoUtil;
/**
 * uuid�ľ���ʵ���ࣺ���ó�Ʊģʽ
 * @author �º���
 *
 * @version 1.0
 */
public class UuidDaoSerImpl implements UuidDao {
	
	private final String FILE_NAME = "Uuid.txt";
	
	@Override
	public String getNextUuid(UuidModelConstance uuidEnum) {
		String modelName = uuidEnum.getName();
		
		//1�����л��������еļ�¼��ȡ����
		List<UuidModel> lists = FileIoUtil.readFormFile(FILE_NAME);
		
		//2�������ҵ�ǰmodelName����Ӧ�� uuid
		for(UuidModel list : lists){
			if(list.getModelName().equals(modelName)){
				//3�ѵ�ǰ��uuid���س�ȥ��ͬʱ��uuid+1�洢�����ݿ���
				int result = list.getCurrentNum();
				list.setCurrentNum(list.getCurrentNum()+1);
				FileIoUtil.write2file(lists, FILE_NAME);
				return String.valueOf(result);
			}
		}
		//4�����ݿ��в����ڸ�modelName����Ӧ��uuid�����½�һ����¼(�������ģ��Ĺ���),�洢�ҷ���1
		int result =1;
		UuidModel uuid = new UuidModel();
		uuid.setModelName(modelName);
		uuid.setCurrentNum(result+1);
		lists.add(uuid);
		FileIoUtil.write2file(lists, FILE_NAME);
		return String.valueOf(result);
	}

}
