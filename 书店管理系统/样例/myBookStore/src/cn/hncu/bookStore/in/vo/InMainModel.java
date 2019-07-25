package cn.hncu.bookStore.in.vo;

import java.io.Serializable;

import cn.hncu.bookStore.util.DateUtil;

/**
 * ��������ֵ�����װ
 * @author �º���
 *
 * @version 1.0
 */
public class InMainModel implements Serializable, Comparable<InMainModel>{
	//���������
	private String uuid;
	//����ʱ��
	private long inDate;
	//������Ա���
	private String inUserId;
	
	/* 
	   ���ĳ���ֶ��������ͬʱ����Ҫ�ڵ�ǰ������Ӧ���ֲ���ʾ���û��ܿ��ö�
	 ����Ϣ,����Ҫ��һ��ר������Ϣ��ʾ(���û���)���ֶΡ�
	 */
	private String inUserName;
	
	public String getInUserName() {
		return inUserName;
	}
	
	public void setInUserName(String inUserName) {
		this.inUserName = inUserName;
	}

	/**
	 * 
	 * @return ---���ؽ��������(String��)
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * 
	 * @param uuid---���ý��������(String��)
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * 
	 * @return---���ؽ���ʱ��(long��)
	 */
	public long getInDate() {
		return inDate;
	}
	
	/**
	 * 
	 * @param inDate---���ý���ʱ��(long��)
	 */
	public void setInDate(long inDate) {
		this.inDate = inDate;
	}
	
	/**
	 * 
	 * @return---���ؽ�����Ա���(String��)
	 */
	public String getInUserId() {
		return inUserId;
	}
	
	/**
	 * 
	 * @param inUserId---���ý�����Ա���(String��)
	 */
	public void setInUserId(String inUserId) {
		this.inUserId = inUserId;
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
		InMainModel other = (InMainModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return uuid + ", " + inUserName
				+ ", " + DateUtil.long2String(inDate);
	}

	@Override
	public int compareTo(InMainModel o) {
		return Integer.parseInt(uuid)-Integer.parseInt(o.uuid);
	}
	
	
	
}
