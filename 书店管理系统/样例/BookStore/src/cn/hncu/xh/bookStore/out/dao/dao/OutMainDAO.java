package cn.hncu.xh.bookStore.out.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.out.vo.OutMainModel;
import cn.hncu.xh.bookStore.out.vo.OutMainQueryModel;

/**
 * <p>
 * Title:OutMainDAO
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public interface OutMainDAO {
	public boolean create(OutMainModel OutMain); // �������۵�

	public boolean update(OutMainModel OutMain); // �޸����۵�

	public boolean delete(String uuid); // ɾ����Ӧuuid�����۵�

	public List<OutMainModel> getAll(); // ��ȡ���е����۵�

	public OutMainModel getSingle(String uuid); // ��ȡ����uuid�ĵ������۵�

	public List<OutMainModel> getByCondition(OutMainQueryModel omqm); // ��ѯ����omqm�����۵�
}
