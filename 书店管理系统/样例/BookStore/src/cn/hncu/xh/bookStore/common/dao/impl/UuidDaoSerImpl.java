package cn.hncu.xh.bookStore.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.common.constance.UuidModelConstance;
import cn.hncu.xh.bookStore.common.dao.dao.UuidDao;
import cn.hncu.xh.bookStore.common.vo.UuidModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:UuidDaoSerImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 24, 2015
 */
// ʵ����
public class UuidDaoSerImpl implements UuidDao { // ʵ��UuidDao�ӿ�
	private static final String FILE_NAME = "Uuid.txt";

	public String getNextNum(UuidModelConstance model) {
		String modelName = model.getName();
		// 1.���ļ��ж�ȡ���еı��
		// ��HashMap���ܸ��ã�����Ҫ����дһ��FileIOUtil���ߣ���Ϊԭ����ֻ�ܶ�дList,�����Ϊ���ܼ򵥣�����ֱ����List��������
		List<UuidModel> list = FileIOUtil.readFromFile(FILE_NAME);
		// 2.������ڱ�ţ���һ���洢��������ֵ
		// �ȱ���list���ҵ���Ӧ��ģ�����ֵ�λ��
		if (list == null) {
			list = new ArrayList<UuidModel>();
		} else {
			for (UuidModel uuid : list) {
				if (uuid.getModelName().equals(modelName)) {
					final int result = uuid.getCurrentNum();// ���result��������ºţ�֮ǰû���ù��ģ���һ������ʹ�ã�
					uuid.setCurrentNum(uuid.getCurrentNum() + 1);
					FileIOUtil.writeToFile(FILE_NAME, list);
					return String.valueOf(result);
				}
			}
		}
		// 3.��������ڱ�ţ���1���洢������1
		final int result = 1;// ���resule��������ºţ�֮ǰû���ù��ģ���һ������ʹ�ã�
		UuidModel uuid = new UuidModel();
		uuid.setModelName(modelName);
		uuid.setCurrentNum(2);
		list.add(uuid);
		FileIOUtil.writeToFile(FILE_NAME, list);
		return String.valueOf(result);
	}

}
