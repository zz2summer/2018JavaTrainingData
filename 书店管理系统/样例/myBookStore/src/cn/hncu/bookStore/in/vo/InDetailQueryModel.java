package cn.hncu.bookStore.in.vo;

/**
 * ������ϸ��ѯֵ�����װ
 * @author �º���
 *
 * @version 1.0
 */
public class InDetailQueryModel extends InDetailModel {
	
	//��Ҫ��ѯ������������
	private int sumNum2;
	//��Ҫ��ѯ�����������
	private double sumMoney2;
	
	/**
	 * 
	 * @return---������Ҫ��ѯ������������
	 */
	public int getSumNum2() {
		return sumNum2;
	}
	/**
	 * 
	 * @param sumNum2---������Ҫ��ѯ������������
	 */
	public void setSumNum2(int sumNum2) {
		this.sumNum2 = sumNum2;
	}
	
	/**
	 * 
	 * @return---������Ҫ��ѯ�����������
	 */
	public double getSumMoney2() {
		return sumMoney2;
	}
	
	/**
	 * 
	 * @param sumMoney2---������Ҫ��ѯ�����������
	 */
	public void setSumMoney2(double sumMoney2) {
		this.sumMoney2 = sumMoney2;
	}

}
