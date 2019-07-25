package entity;

import java.sql.Date;

public class Book {
	private String id;	//ͼ����
	private String name;	//ͼ������
	private String type;	//ͼ�����
	private String author;	//����
	private String translator;	//����
	private String publisher;	//������
	private Date publish_time;	//����ʱ��
	private int stock;	//�������
	private double price;	//�۸�
	
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * @return the publish_time
	 */
	public Date getPublish_time() {
		return publish_time;
	}
	
	/**
	 * @param publish_time the publish_time to set
	 */
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}
	
	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	/**
	 * @return the translator
	 */
	public String getTranslator() {
		return translator;
	}
	
	/**
	 * @param translator the translator to set
	 */
	public void setTranslator(String translator) {
		this.translator = translator;
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
