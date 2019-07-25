package cn.hncu.xh.bookStore.out.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.out.vo.OutDetailModel;
import cn.hncu.xh.bookStore.out.vo.OutDetailQueryModel;


/**
 *<p>Title:OutDetailDAO</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public interface OutDetailDAO {
	public boolean create(OutDetailModel OutDetail); // ����������ϸ

	public boolean update(OutDetailModel OutDetail); // �޸�������ϸ

	public boolean delete(String uuid); // ɾ����Ӧuuid��������ϸ

	public List<OutDetailModel> getAll(); // ��ȡ���е�������ϸ

	public OutDetailModel getSingle(String uuid); // ��ȡ����uuid�ĵ���������ϸ

	public List<OutDetailModel> getByCondition(OutDetailQueryModel odqm); // ��ѯ����omqm��������ϸ
}
