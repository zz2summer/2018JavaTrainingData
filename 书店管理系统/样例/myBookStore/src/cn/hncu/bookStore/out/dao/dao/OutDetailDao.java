package cn.hncu.bookStore.out.dao.dao;

import java.util.List;

import cn.hncu.bookStore.out.vo.OutDetailModel;
import cn.hncu.bookStore.out.vo.OutDetailQueryModel;

/**
 * ������ϸ�������ݲ�ӿ�
 * @author �º���
 *
 * @version 1.0
 */
public interface OutDetailDao {
	/**
	 * ����һ��������ϸ���ݶ���
	 * @param outMain---��Ҫ������������ϸ���ݶ���
	 * @return---true ��ʾ�����ɹ���false ��ʾ����ʧ��
	 */
	public boolean create(OutDetailModel outDetail);
	
	/**
	 * ɾ��һ��������ϸ���ݶ���
	 * @param uuid---������ϸ���ı��-Ψһ��
	 * @return---true��ʾɾ���ɹ��� false��ʾɾ��ʧ��
	 */
	public boolean delete(String uuid);
	
	/**
	 * �޸�һ��������ϸ���ݵĶ���
	 * @param outMain---��Ҫ�޸ĵ����۹�����ϸ����
	 * @return---true��ʾ�޸ĳɹ���false��ʾ�޸�ʧ��
	 */
	public boolean update(OutDetailModel outDetail);
	
	/**
	 * ����������ϸ����ţ��õ�������ϸ�����������Ϣ����
	 * @param uuid---������ϸ�����
	 * @return---�ö��������������Ϣ����
	 */
	public OutDetailModel getSingle(String uuid);
	
	/**
	 * 
	 * @return---���е�������ϸ���������Ϣ
	 */
	public List<OutDetailModel> getAll();
	
	/**
	 * ����������ϸ�������
	 * @param omqm---����������
	 * @return---�����������������OutDetailModel����
	 */
	public List<OutDetailModel> getbyCondition(OutDetailQueryModel odqm);
}
