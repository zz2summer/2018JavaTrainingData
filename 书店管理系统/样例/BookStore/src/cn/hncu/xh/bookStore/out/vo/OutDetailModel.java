package cn.hncu.xh.bookStore.out.vo;

import java.io.Serializable;

import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;

/**
 *<p>Title:OutDetailModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutDetailModel implements Serializable{
	private String uuid; //销售明细uuid
	private String outUuid; //销售单uuid 
	private String bookUuid;  //图书uuid
	private int sumNum;     //销售数量
	private double SumMoney; //销售总金额
	
	private String bookName;  //为了显示书名，补的属性

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOutUuid() {
		return outUuid;
	}

	public void setOutUuid(String outUuid) {
		this.outUuid = outUuid;
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

	public Double getSumMoney() {
		return SumMoney;
	}

	public void setSumMoney(Double sumMoney) {
		SumMoney = sumMoney;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
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
		final OutDetailModel other = (OutDetailModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(bookUuid!=null&&bookName==null){
			bookName=BookEbiFactory.getBookEbi().getSingle(bookUuid).getName();//如果没有书名，则从book模块中根据bookUuid调用对应的bookName
		}
		return bookName+","+sumNum;
	}
	
	
}
