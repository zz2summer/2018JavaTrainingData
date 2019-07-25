package cn.hncu.bookStore.out.dao.dao;

import java.util.List;

import cn.hncu.bookStore.out.vo.OutMainModel;
import cn.hncu.bookStore.out.vo.OutMainQueryModel;

/**
 * ���۹������ݲ�ӿ�
 * 
 * @author �º���
 * 
 * @version 1.0
 */
public interface OutMainDao {
	
	/**
	 * ����һ���������ݶ���
	 * @param outMain---��Ҫ�������������ݶ���
	 * @return---true ��ʾ�����ɹ���false ��ʾ����ʧ��
	 */
	public boolean create(OutMainModel outMain);
	
	/**
	 * ɾ��һ���������ݶ���
	 * @param uuid---���۵��ı��-Ψһ��
	 * @return---true��ʾɾ���ɹ��� false��ʾɾ��ʧ��
	 */
	public boolean delete(String uuid);
	
	/**
	 * �޸�һ���������ݵĶ���
	 * @param outMain---��Ҫ�޸ĵ����۹������
	 * @return---true��ʾ�޸ĳɹ���false��ʾ�޸�ʧ��
	 */
	public boolean update(OutMainModel outMain);
	
	/**
	 * �������۵���ţ��õ����۶����������Ϣ����
	 * @param uuid---���۵����
	 * @return---�ö��������������Ϣ����
	 */
	public OutMainModel getSingle(String uuid);
	
	/**
	 * 
	 * @return---���е����۹��������Ϣ
	 */
	public List<OutMainModel> getAll();
	
	/**
	 * �������۹������
	 * @param imqm---����������
	 * @return---�����������������OutMainModel����
	 */
	public List<OutMainModel> getbyCondition(OutMainQueryModel omqm);
}
