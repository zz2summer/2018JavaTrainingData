package cn.hncu.xh.bookStore.out.vo;

import java.io.Serializable;

import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;

/**
 *<p>Title:OutDetailModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutDetailModel implements Serializable{
	private String uuid; //������ϸuuid
	private String outUuid; //���۵�uuid 
	private String bookUuid;  //ͼ��uuid
	private int sumNum;     //��������
	private double SumMoney; //�����ܽ��
	
	private String bookName;  //Ϊ����ʾ��������������

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
			bookName=BookEbiFactory.getBookEbi().getSingle(bookUuid).getName();//���û�����������bookģ���и���bookUuid���ö�Ӧ��bookName
		}
		return bookName+","+sumNum;
	}
	
	
}
