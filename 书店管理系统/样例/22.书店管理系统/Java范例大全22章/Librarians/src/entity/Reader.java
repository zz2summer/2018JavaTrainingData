package entity;

import java.sql.Date;

public class Reader {
	private String id;	//���߱��
	private String name;	//��������
	private String sex;	//�Ա�
	private String type;	//�������
	private String max_num;	//���ɽ�����
	private int days_num;	//���ɽ�����
	
	/**
	 * @return the days_num
	 */
	public int getDays_num() {
		return days_num;
	}
	/**
	 * @param days_num the days_num to set
	 */
	public void setDays_num(int days_num) {
		this.days_num = days_num;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * @return the max_num
	 */
	public String getMax_num() {
		return max_num;
	}
	
	/**
	 * @param max_num the max_num to set
	 */
	public void setMax_num(String max_num) {
		this.max_num = max_num;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
