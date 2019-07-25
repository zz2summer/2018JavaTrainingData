package cn.hncu.bookStore.user.vo;

import java.io.Serializable;

import cn.hncu.bookStore.common.UserTypeEnum;

/**
 * @author �º���
 * @version 1.0
 * 
 * <br/>
 * ���ڱ����û���Ϣ��ֵ����<br/>
 * 1�������л�<br/>
 * 2��˽�л����б�����Ա����setter-getters����<br/>
 * 3��дequals��hashCode����----������(uuid)Ψһ��ʶ��<br/>
 * 4��toString����<br/>
 * 5,�ղι��췽��<br/>
 */

public class UserModel implements Serializable{
	private String uuid;//�û�Ψһ��ʶ��
	private String name;//�û���
	private int type;//�û�����
	private String pwd;//�û�����
	public UserModel() {
	}
	
	/**
	 * ���ܣ��õ�uuid-�û�Ψһ�ı�ʶ��
	 * 
	 * @return ����uuid-�û�Ψһ�ı�ʶ��
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * ���ܣ�����uuid-�û�Ψһ�ı�ʶ��
	 * @param uuid-�û�Ψһ�ı�ʶ��-String�Ͳ���
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * ���ܣ��õ��û����û���
	 * @return---name-�û���
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ���ܣ������û����û���
	 * 
	 * @param name--�û����õ��û�����String�Ͳ���
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * ���ܣ��õ��û������ͣ�
	 *  1������ʾΪadmin�����Խ���ȫ������
     *	2������ʾΪ�ܲ���ͼ��ģ�����Ա
	 *	3������ʾΪ�ܲ�������ģ�����Ա
	 *	4������ʾΪ�ܲ�������ģ�����Ա
	 *	5������ʾΪ�ܲ������ģ�����Ա
	 * @return �û�������
	 */
	public int getType() {
		return type;
	}
	
	/**
	 *  ���ܣ������û������ͣ�
	 *  1������ʾΪadmin�����Խ���ȫ������
     *	2������ʾΪ�ܲ���ͼ��ģ�����Ա
	 *	3������ʾΪ�ܲ�������ģ�����Ա
	 *	4������ʾΪ�ܲ�������ģ�����Ա
	 *	5������ʾΪ�ܲ������ģ�����Ա
	 * @param type--�û�������-int�Ͳ���
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 *���ܣ��õ��û�������
	 * @return String�ͣ��û�������
	 */
	public String getPwd() {
		return pwd;
	}
	
	/**
	 * ���ܣ������û�������
	 * @param pwd--String�Ͳ���
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
		UserModel other = (UserModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return uuid + "," + name + "," + UserTypeEnum.getNameByType(type);
	}
	
}
