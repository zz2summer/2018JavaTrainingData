package cn.hncu.xh.bookStore.in.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.in.dao.dao.InMainDao;
import cn.hncu.xh.bookStore.in.vo.InMainModel;
import cn.hncu.xh.bookStore.in.vo.InMainQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:InMainDaoserImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
// ʵ����
public class InMainDaoserImpl implements InMainDao {// ʵ��InMainDao�ӿ�
	private static final String FILE_NAME = "inMain.txt";

	public boolean create(InMainModel inMain) {
		List<InMainModel> list = getAll(); // ���ȫ���Ѵ���Ԫ��
		// ����list���ж��Ƿ��Ѿ���ͬ��uuid��Ԫ�أ�����ֱ���˳�����֮�����ȥ
		for (InMainModel model : list) {
			if (model.getUuid().equals(inMain.getUuid())) {
				return false;
			}
		}
		list.add(inMain); // ��inMian����list��
		FileIOUtil.writeToFile(FILE_NAME, list); // д�뵽��Ӧ�ļ���
		return true;
	}

	public boolean delete(String uuid) {
		List<InMainModel> list = getAll(); // ���ȫ���Ѵ���Ԫ��
		// ����list���ж��Ƿ��Ѿ���ͬ��uuid��Ԫ�أ�����ֱ��ɾ��
		for (InMainModel model : list) {
			if (model.getUuid().equals(uuid)) {
				list.remove(model);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}

	public List<InMainModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME);
	}

	public List<InMainModel> getBycondition(InMainQueryModel imqm) {
		List<InMainModel> list = getAll(); // �Ӻ�̨�����е����ݼ���ȡ����
		List<InMainModel> ret = new ArrayList<InMainModel>();// ��Ž����
		if (imqm == null) {
			return list;
		}
		// Ȼ����������������ɸѡ��ɸѡʣ�µľ��ǲ�ѯ���
		for (InMainModel inMain : list) {
			// ���߼������������ж�uuid
			if (imqm.getUuid() != null && imqm.getUuid().trim().length() > 0) {// ����֤��ѯ������Ч
				if (!imqm.getUuid().equals(inMain.getUuid())) { // ���˵�uuid��ƥ���
					continue;
				}
			}
			// ��������inUseruuid������
			if (imqm.getInUserUuid() != null
					&& imqm.getInUserUuid().trim().length() > 0) {// ����֤��ѯ������Ч
				if (!imqm.getInUserUuid().contains(inMain.getInUserUuid())) { // ���˵�uuid��ƥ���
					continue;
				}
			}
			// ��������inDate��ʼ����ʱ�䣨С��С�ģ����ˣ�
			if (imqm.getInDate() > 0) { // ����û�û��ѡ�û����ͣ���ô��Ĭ��ȫ������Ҫ�鵽
				if (imqm.getInDate() > inMain.getInDate()) { 
					continue;
				}
			}
			// ��������inDate2��������ʱ�䣨���ڴ�ģ����ˣ�
			if (imqm.getInDate2() > 0) { // ����û�û��ѡ�û����ͣ���ô��Ĭ��ȫ������Ҫ�鵽
				if (imqm.getInDate2()< inMain.getInDate()) { 
					continue;
				}
			}
			ret.add(inMain);
		}
		return ret;

	}

	public InMainModel getSingle(String uuid) {
		List<InMainModel> list = getAll();
		for (int i = 0; i < list.size(); i++) {
			InMainModel model = list.get(i);
			if (model.getUuid().equals(uuid)) {
				return list.get(i);
			}
		}
		return null;
	}

	public boolean update(InMainModel inMain) {
		List<InMainModel> list = getAll();
		for (int i = 0; i < list.size(); i++) {
			InMainModel model = list.get(i);
			if (model.getUuid().equals(inMain.getUuid())) {
				list.set(i, inMain);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}

}
