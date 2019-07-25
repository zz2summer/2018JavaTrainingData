package cn.hncu.xh.bookStore.common.vo;

import java.io.Serializable;

/**
 *<p>Title:UuidModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 24, 2015
 */
//uuidʵ�ֳ�Ʊģʽ
public class UuidModel implements Serializable{//ʵ�ֿ����л�
	private String modelName; //ģ������
	private int currentNum;   //��ǰ��Ʊ�ĺ���
	//���������ǵ�set��get����
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getCurrentNum() {
		return currentNum;
	}
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
		final UuidModel other = (UuidModel) obj;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		return true;
	}
	
}
