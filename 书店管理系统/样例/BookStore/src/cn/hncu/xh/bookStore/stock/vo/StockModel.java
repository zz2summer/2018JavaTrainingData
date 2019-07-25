package cn.hncu.xh.bookStore.stock.vo;

import java.io.Serializable;

/**
 *<p>Title:StockModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class StockModel implements Serializable{
	private String uuid; //库存uuid
	private String bookUuid; //图书uuid
	private int sumNum;  //库存数量
	private String bookName; //外键，为显示给用户看而补上的
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
		final StockModel other = (StockModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return bookName+","+sumNum;
	}
}
