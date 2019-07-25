package cn.hncu.bookStore.out.vo;

import java.io.Serializable;

import cn.hncu.bookStore.util.DateUtil;

/**
 * ���۹���ֵ�����װ
 * @author �º���
 *
 * @version 1.0
 */
public class OutMainModel implements Serializable, Comparable<OutMainModel>{
	//���۵����
	private String uuid;
	//����ʱ��
	private long outDate;
	//������Ա���
	private String outUserId;
	
	/* 
	   ���ĳ���ֶ��������ͬʱ����Ҫ�ڵ�ǰ������Ӧ���ֲ���ʾ���û��ܿ��ö�
	 ����Ϣ,����Ҫ��һ��ר������Ϣ��ʾ(���û���)���ֶΡ�
	 */
	private String outUserName;
	
	public String getOutUserName() {
		return outUserName;
	}
	
	public void setOutUserName(String outUserName) {
		this.outUserName = outUserName;
	}

	/**
	 * 
	 * @return ---�������۵����(String��)
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * 
	 * @param uuid---�������۵����(String��)
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * 
	 * @return---��������ʱ��(long��)
	 */
	public long getOutDate() {
		return outDate;
	}
	
	/**
	 * 
	 * @param outDate---��������ʱ��(long��)
	 */
	public void setOutDate(long outDate) {
		this.outDate = outDate;
	}
	
	/**
	 * 
	 * @return---����������Ա���(String��)
	 */
	public String getOutUserId() {
		return outUserId;
	}
	
	/**
	 * 
	 * @param outUserId---����������Ա���(String��)
	 */
	public void setOutUserId(String outUserId) {
		this.outUserId = outUserId;
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
		OutMainModel other = (OutMainModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return uuid + ", " + outUserName
				+ ", " + DateUtil.long2String(outDate);
	}

	@Override
	public int compareTo(OutMainModel o) {
		return Integer.parseInt(uuid)-Integer.parseInt(o.uuid);
	}
}
