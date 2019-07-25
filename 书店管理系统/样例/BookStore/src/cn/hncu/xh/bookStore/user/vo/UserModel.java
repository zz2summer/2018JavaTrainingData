package cn.hncu.xh.bookStore.user.vo;
import java.io.Serializable;

import cn.hncu.xh.bookStore.user.constance.UserTypeEnum;
/**
 *<p>Title:UserModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 21, 2015
 */
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;//ʵ�ֿ����л�
	private String uuid; //���
	private String name; //���� 
	private int type;    //����Ȩ��
	private String pwd;  //����
	//���췽��
	public UserModel(String uuid, String name, int type, String pwd) {
		this.uuid = uuid;
		this.name = name;
		this.type = type;
		this.pwd = pwd;
	}
	//�չ��췽��
	public UserModel() {
	}
	//���Ե�set��get����
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	//hashCode��equals����
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final UserModel other = (UserModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	//toString����
	public String toString() {
		return "{"+uuid+","+name+","+UserTypeEnum.getNameByType(type)+"}";
	}

}
