package cn.hncu.xh.bookStore.in.vo;

/**
 *<p>Title:InDetailQueryModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
public class InDetailQueryModel extends InDetailModel {
	private int sumNum2;  //图书数量范围的一个限定
	private double sumMoney2; //图书总金额的一个限定
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
