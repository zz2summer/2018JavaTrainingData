package beans;

import java.sql.Date;
/**
 * �û���
 * �汾 1.0
 * @author Cute Code
 *
 */
public class User {
	
	/**
	 * ӵ�����
	 */
	private int id;
	
	/**
	 * �û�����
	 */
	private String name;
	
	/**
	 * �û�����
	 */
	private String pass;
	
	/**
	 * �û��Ա�
	 */
	private String sex;
	
	/**
	 * �û�����
	 */
	private int age;
	
	/**
	 * �û�����ݣ�����Ա������ͨ�û�
	 */
	private int role;
	
	/**
	 * ��ʵ����
	 */
	private String realName;
	
	/**
	 * ��ϵ�绰
	 */
	private String phone;
	
	/**
	 * �����ʼ�
	 */
	private String email;
	
	/**
	 * ��ϵ��ַ
	 */
	private String address;
	
	/**
	 * ע������
	 */
	private Date registerDate;

	/**
	 * �޲ι��캯��
	 */
	public User() {
	}
	
	/**
	 * ���ι��캯��
	 * @param id
	 * @param name
	 * @param pass
	 * @param sex
	 * @param age
	 * @param role
	 * @param realName
	 * @param phone
	 * @param email
	 * @param address
	 * @param postcode
	 * @param registerDate
	 */
	public User(int id, String name, String pass, String sex, int age, int role, String realName, String phone, String email, String address, Date registerDate) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.age = age;
		this.role = role;
		this.realName = realName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.registerDate = registerDate;
	}
	/**
	 * �����ϵ��ַ
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * ������ϵ��ַ
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 *  �������
	 * @return
	 */
	public int getAge() {
		return age;
	}
	/**
	 * ��������
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 *  ��õ��ʵ�ַ
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * ���õ��ʵ�ַ
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * ��ñ��
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * ���ñ��
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	// ����û���
	public String getName() {
		return name;
	}
	/**
	 * �����û���
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * �������
	 * @return
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * ��������
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	 * �����ϵ�绰
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * ������ϵ�绰
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * �����ʵ����
	 * @return
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * ������ʵ����
	 * @param realName
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 *  ���ע������
	 * @return
	 */
	public Date getRegisterDate() {
		return registerDate;
	}
	/**
	 *  ����ע������
	 * @param registerDate
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * ����û����
	 * @return
	 */
	public int getRole() {
		return role;
	}
	/**
	 * �����û����
	 * @param role
	 */
	public void setRole(int role) {
		this.role = role;
	}
	/**
	 * ����Ա�
	 * @return
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * �����Ա�
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

}
