package entity;

import java.sql.Date;

public class Book {
	private String id;	//图书编号
	private String name;	//图书名称
	private String type;	//图书类别
	private String author;	//作者
	private String translator;	//译者
	private String publisher;	//出版社
	private Date publish_time;	//出版时间
	private int stock;	//库存数量
	private double price;	//价格
	
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
