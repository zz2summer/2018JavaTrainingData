package cn.hncu.bookStore.book.vo;

import java.io.Serializable;

/**
 * ֵ�����װ
 * 
 * @author �º���
 * @version 1.0
 */
public class BookModel implements Serializable{//����ʵ������ӿ�
	private String uuid;//ͼ��ID
	private String name;//ͼ������
	private double inPrice;//ͼ��Ľ���
	private double salePrice;//ͼ����ۼ�
	
	/**
	 * 
	 * @return ͼ���ID
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * 
	 * @param uuid ---����ͼ���ID
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * 
	 * @return ͼ�������
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name--����ͼ�������
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return �õ�ͼ��Ľ���
	 */
	public double getInPrice() {
		return inPrice;
	}
	
	/**
	 * 
	 * @param inPrice---����ͼ��Ľ���
	 */
	public void setInPrice(double inPrice) {
		this.inPrice = inPrice;
	}
	
	/**
	 * 
	 * @return ---����ͼ����ۼ�
	 */
	public double getSalePrice() {
		return salePrice;
	}
	
	/**
	 * 
	 * @param outPrice---����ͼ����ۼ�
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
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
		BookModel other = (BookModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return uuid + ", " + name + ", ����="
				+ inPrice + ", �ۼ�" + salePrice;
	}
	
}
