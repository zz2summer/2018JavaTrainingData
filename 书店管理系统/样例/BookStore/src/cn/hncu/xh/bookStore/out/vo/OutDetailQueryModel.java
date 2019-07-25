package cn.hncu.xh.bookStore.out.vo;

/**
 *<p>Title:OutDetailQueryModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutDetailQueryModel extends OutDetailModel {
	private int sumNum2;  //方便查询销售数量范围
	private double sumMoney2;  //方便查询销售总金额范围
	public int getSumNum2() {
		return sumNum2;
	}
	public void setSumNum2(int sumNum2) {
		this.sumNum2 = sumNum2;
	}
	public double getSumMoney2() {
		return sumMoney2;
	}
	public void setSumMoney2(double sumMoney2) {
		this.sumMoney2 = sumMoney2;
	}
	
}
