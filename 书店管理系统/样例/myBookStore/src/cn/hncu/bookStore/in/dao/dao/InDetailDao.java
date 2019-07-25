package cn.hncu.bookStore.in.dao.dao;

import java.util.List;

import cn.hncu.bookStore.in.vo.InDetailModel;
import cn.hncu.bookStore.in.vo.InDetailQueryModel;

/**
 * ������ϸ�������ݲ�ӿ�
 * @author �º���
 *
 * @version 1.0
 */
public interface InDetailDao {
	/**
	 * ����һ��������ϸ���ݶ���
	 * @param inMain---��Ҫ�����Ľ�����ϸ���ݶ���
	 * @return---true ��ʾ�����ɹ���false ��ʾ����ʧ��
	 */
	public boolean create(InDetailModel inDetail);
	
	/**
	 * ɾ��һ��������ϸ���ݶ���
	 * @param uuid---������ϸ���ı��-Ψһ��
	 * @return---true��ʾɾ���ɹ��� false��ʾɾ��ʧ��
	 */
	public boolean delete(String uuid);
	
	/**
	 * �޸�һ��������ϸ���ݵĶ���
	 * @param inMain---��Ҫ�޸ĵĽ���������ϸ����
	 * @return---true��ʾ�޸ĳɹ���false��ʾ�޸�ʧ��
	 */
	public boolean update(InDetailModel inDetail);
	
	/**
	 * ���ݽ�����ϸ����ţ��õ�������ϸ�����������Ϣ����
	 * @param uuid---������ϸ�����
	 * @return---�ö��������������Ϣ����
	 */
	public InDetailModel getSingle(String uuid);
	
	/**
	 * 
	 * @return---���еĽ�����ϸ���������Ϣ
	 */
	public List<InDetailModel> getAll();
	
	/**
	 * ���ҽ�����ϸ�������
	 * @param imqm---����������
	 * @return---�����������������InDetailModel����
	 */
	public List<InDetailModel> getbyCondition(InDetailQueryModel idqm);
}
