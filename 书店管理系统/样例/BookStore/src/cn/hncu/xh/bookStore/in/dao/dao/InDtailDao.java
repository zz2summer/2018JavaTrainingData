package cn.hncu.xh.bookStore.in.dao.dao;


import java.util.List;

import cn.hncu.xh.bookStore.in.vo.InDetailModel;
import cn.hncu.xh.bookStore.in.vo.InDetailQueryModel;

/**
 * <p>
 * Title:InDtailDao
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
//�ӿ���
public interface InDtailDao {
	public boolean create(InDetailModel inDetail); // �����ӿ�

	public List<InDetailModel> getAll(); // ����ȫ������ӿ�

	public InDetailModel getSingle(String uuid);// ��ȡ��Žӿ�

	public List<InDetailModel> getBycondition(InDetailQueryModel idqm);// ��ѯ�ӿ�
}
