package cn.hncu.bookStore.in.business.ebi;

import java.util.List;
import java.util.Map;

import cn.hncu.bookStore.in.vo.InDetailModel;
import cn.hncu.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.bookStore.in.vo.InMainModel;
import cn.hncu.bookStore.in.vo.InMainQueryModel;

/**
 * 
 * @author �º���
 * @version 1.0
 */
public interface InMainEbi {
	
	/**
	 * ����һ������ģ������-
	 * @param inMain---��������
	 * @param inDetails---������ϸ����
	 * @return---����true��ʾ�����ɹ���false��ʾ����ʧ��
	 */
	public abstract boolean create(InMainModel inMain,List<InDetailModel> inDetails);
	
	/**
	 * 
	 * @return---�������еĽ���ģ�飨����������ϸ���ļ���
	 */
	public abstract Map<InMainModel, List<InDetailModel>> getAll();
	
	/**
	 * 
	 * @param imqm---����������Ҫ���ҵ�����
	 * @param idqm---������ϸ��Ҫ���ҵ�����
	 * @return---�������������н������ݵ�Map����
	 */
	public abstract Map<InMainModel, List<InDetailModel>> getByCondition(InMainQueryModel imqm,InDetailQueryModel idqm);
	
}
