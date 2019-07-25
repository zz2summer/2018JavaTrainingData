package cn.hncu.xh.bookStore.book.vo;

import java.io.Serializable;

/**
 *<p>Title:BookModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
//书本，值对象
@SuppressWarnings("serial")
public class BookModel implements Serializable{ //实现序列化
	private String uuid;  //书的编号
	private String name;  //书名
	private double inPrice; //书的进货价
	private double salePrice;//书的出售价
	//构造函数
	public BookModel(String uuid, String name, double inPrice, double salePrice) {
		this.uuid = uuid;
		this.name = name;
		this.inPrice = inPrice;
		this.salePrice = salePrice;
	}
	public BookModel() {
	}
	//下面是属性的对应的set，get方法
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getInPrice() {
		return inPrice;
	}
	public void setInPrice(double inPrice) {
		this.inPrice = inPrice;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	//hashCode和equals方法
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
		final BookModel other = (BookModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	//toString方法
	@Override
	public String toString() {
		return "{"+uuid+","+name+","+inPrice+","+salePrice+"}";
	}
	
}
