package cn.hncu.bookStore.out.business.ebi;

import java.util.List;
import java.util.Map;

import cn.hncu.bookStore.out.vo.OutMainQueryModel;
import cn.hncu.bookStore.out.vo.OutDetailModel;
import cn.hncu.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.bookStore.out.vo.OutMainModel;

/**
 * 
 * @author �º���
 * @version 1.0
 */
public interface OutMainEbi {
	
	/**
	 * ����һ������ģ������-
	 * @param inMain---��������
	 * @param outDetails---������ϸ����
	 * @return---����true��ʾ�����ɹ���false��ʾ����ʧ��
	 */
	public abstract boolean create(OutMainModel inMain,List<OutDetailModel> outDetails);
	
	/**
	 * 
	 * @return---�������е�����ģ�飨����������ϸ���ļ���
	 */
	public abstract Map<OutMainModel, List<OutDetailModel>> getAll();
	
	/**
	 * 
	 * @param omqm---���۹�����Ҫ���ҵ�����
	 * @param idqm---������ϸ��Ҫ���ҵ�����
	 * @return---���������������������ݵ�Map����
	 */
	public abstract Map<OutMainModel, List<OutDetailModel>> getByCondition(OutMainQueryModel omqm,OutDetailQueryModel odqm);
	
}
