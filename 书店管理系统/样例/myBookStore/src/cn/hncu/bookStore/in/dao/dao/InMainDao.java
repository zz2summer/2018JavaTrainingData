package cn.hncu.bookStore.in.dao.dao;

import java.util.List;

import cn.hncu.bookStore.in.vo.InMainModel;
import cn.hncu.bookStore.in.vo.InMainQueryModel;

/**
 * �����������ݲ�ӿ�
 * 
 * @author �º���
 * 
 * @version 1.0
 */
public interface InMainDao {
	
	/**
	 * ����һ���������ݶ���
	 * @param inMain---��Ҫ�����Ľ������ݶ���
	 * @return---true ��ʾ�����ɹ���false ��ʾ����ʧ��
	 */
	public boolean create(InMainModel inMain);
	
	/**
	 * ɾ��һ���������ݶ���
	 * @param uuid---�������ı��-Ψһ��
	 * @return---true��ʾɾ���ɹ��� false��ʾɾ��ʧ��
	 */
	public boolean delete(String uuid);
	
	/**
	 * �޸�һ���������ݵĶ���
	 * @param inMain---��Ҫ�޸ĵĽ����������
	 * @return---true��ʾ�޸ĳɹ���false��ʾ�޸�ʧ��
	 */
	public boolean update(InMainModel inMain);
	
	/**
	 * ���ݽ�������ţ��õ����������������Ϣ����
	 * @param uuid---���������
	 * @return---�ö��������������Ϣ����
	 */
	public InMainModel getSingle(String uuid);
	
	/**
	 * 
	 * @return---���еĽ������������Ϣ
	 */
	public List<InMainModel> getAll();
	
	/**
	 * ���ҽ����������
	 * @param imqm---����������
	 * @return---�����������������INMainModel����
	 */
	public List<InMainModel> getbyCondition(InMainQueryModel imqm);
}
