package cn.hncu.xh.bookStore.book.vo;

import cn.hncu.xh.bookStore.user.vo.UserModel;

/**
 *<p>Title:BookQueryModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
//比较值对象
@SuppressWarnings("serial")
public class BookQueryModel extends BookModel{
	private double inPrice2; //用来比较的一个进货价
	private double salePrice2;//用来比较的一个出售价
	//下面是他们对应的set、get方法
	public double getInPrice2() {
		return inPrice2;
	}
	public void setInPrice2(double inPrice2) {
		this.inPrice2 = inPrice2;
	}
	public double getSalePrice2() {
		return salePrice2;
	}
	public void setSalePrice2(double salePrice2) {
		this.salePrice2 = salePrice2;
	}
}
