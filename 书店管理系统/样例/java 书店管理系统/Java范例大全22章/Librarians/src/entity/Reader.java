package entity;

import java.sql.Date;

public class Reader {
	private String id;	//读者编号
	private String name;	//读者姓名
	private String sex;	//性别
	private String type;	//读者类别
	private String max_num;	//最多可借数量
	private int days_num;	//最大可借天数
	
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
