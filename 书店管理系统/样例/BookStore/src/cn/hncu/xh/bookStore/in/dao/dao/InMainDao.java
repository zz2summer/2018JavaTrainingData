package cn.hncu.xh.bookStore.in.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.in.vo.InMainModel;
import cn.hncu.xh.bookStore.in.vo.InMainQueryModel;



/**
 *<p>Title:InMainDao</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
//�ӿ���
public interface InMainDao {
	public boolean create(InMainModel inMain); // �����ӿ�

	public boolean delete(String uuid); // ɾ���ӿ�

	public boolean update(InMainModel inMain); // �޸Ľӿ�

	public List<InMainModel> getAll(); // ����ȫ������ӿ�

	public InMainModel getSingle(String uuid);// ��ȡ��Žӿ�

	public List<InMainModel> getBycondition(InMainQueryModel imqm);// ��ѯ�ӿ�
}
