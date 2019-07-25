package cn.hncu.xh.bookStore.in.vo;

import java.io.Serializable;

import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;

/**
 * <p>
 * Title:InDetailModel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
public class InDetailModel implements Serializable {
	private String uuid; // 进货明细编号,主键
	private String inUuid; // 进货单编号，外键
	private String bookUuid; // 图书编号,外键
	private int sumNum; // 进货数量
	private double sumMoney; // 总金额
	//下面是对应属性的set、get方法
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getInUuid() {
		return inUuid;
	}

	public void setInUuid(String inUuid) {
		this.inUuid = inUuid;
	}

	public String getBookUuid() {
		return bookUuid;
	}

	public void setBookUuid(String bookUuid) {
		this.bookUuid = bookUuid;
	}

	public int getSumNum() {
		return sumNum;
	}

	public void setSumNum(int sumNum) {
		this.sumNum = sumNum;
	}

	public double getSunMoney() {
		return sumMoney;
	}

	public void setSunMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final InDetailModel other = (InDetailModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return (BookEbiFactory.getBookEbi().getSingle(bookUuid).getName()) + "," + sumNum+","+sumMoney;
	}
}
