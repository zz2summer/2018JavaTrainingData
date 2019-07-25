package cn.hncu.bookStore.common.uuid.vo;

import java.io.Serializable;

/**
 * Uuid��ֵ�����װ
 * һ��ģ�����ƺ�һ��uuid
 * @author �º���
 *
 * @version 1.0
 */
public class UuidModel implements Serializable{//�ö�������ȡ������ʵ�ֵĽӿ�
	private String modelName;
	private int currentNum;
	
	/**
	 * 
	 * @return ����ģ�������
	 */
	public String getModelName() {
		return modelName;
	}
	
	/**
	 * 
	 * @param modelName---Ҫ���õ�ģ�������
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	/**
	 * 
	 * @return ---���ص�ǰ��ֵ
	 */
	public int getCurrentNum() {
		return currentNum;
	}
	
	/**
	 * 
	 * @param currentNum--���õ�ǰ��ֵ
	 */
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((modelName == null) ? 0 : modelName.hashCode());
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
		UuidModel other = (UuidModel) obj;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		return true;
	}
	
	
}
