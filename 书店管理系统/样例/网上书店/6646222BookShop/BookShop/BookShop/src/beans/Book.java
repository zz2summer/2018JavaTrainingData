package beans;

import java.sql.Date;

/**
 * 版本 1.0
 * 作者：CuteCode
 * 
 */
public class Book {
	
	/**
	 * 编号
	 */
	private int id;
	
	/**
	 * 书名
	 */
	private String name;
	
	/**
	 * 作者
	 */
	private String author;
	
	/**
	 * 出版商
	 */
	private String bookman;
	
	/**
	 * 价格
	 */
	private float price;
	
	/**
	 * 这种书当前剩余的本数
	 */
	private  int remainNum;
	
	/**
	 * 所属的目录编号
	 */
	private int categoryId;
	
	/**
	 * 内容简介
	 */
	private String introduction;
	
	/**
	 * 上架本数
	 */
	private  int onSaleNum;
	
	/**
	 * 上架日期
	 */
	private Date onSaleDate;

	public Book(int id, String name, String author, String bookman, float price, int remainNum, int categoryId, String introduction, int onSaleNum, Date onSaleDate) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.bookman = bookman;
		this.price = price;
		this.remainNum = remainNum;
		this.categoryId = categoryId;
		this.introduction = introduction;
		this.onSaleNum = onSaleNum;
		this.onSaleDate = onSaleDate;
	}
	
	/**
	 * 构造函数
	 *
	 */
	public Book() {
		super();
	}
	/**
	 * 获得入库数量
	 * @return
	 */
	public int getOnSaleNum() {
		return onSaleNum;
	}
	/**
	 * 设置入库数量
	 * @param onSaleNum
	 */
	public  void setOnSaleNum(int onSaleNum) {
		this.onSaleNum = onSaleNum;
	}
	
	/**
	 * 获得现有库存数量
	 * @return
	 */
	public  int getRemainNum() {
		return remainNum;
	}
	
	/**
	 * 设置库存数量
	 * @param remainNum
	 */
	public  void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
	}

	/**
	 * 得到作者
	 * @return
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置作者
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * 得到出版社
	 * @return
	 */
	public String getBookman() {
		return bookman;
	}
	
	/**
	 * 设置出版社
	 * @param bookman
	 */
	public void setBookman(String bookman) {
		this.bookman = bookman;
	}
	/**
	 * 得到类别ID
	 * @return
	 */
	public int getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置类别ID
	 * @param categoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
	 * 得到ID
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 设置ID
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 得到介绍
	 * @return
	 */
	public String getIntroduction() {
		return introduction;
	}
	
	/**
	 * 设置图书介绍
	 * @param introduction
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	/**
	 * 得到书名
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置书名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 得到入库日期
	 * @return
	 */
	public Date getOnSaleDate() {
		return onSaleDate;
	}
	
	/**
	 * 设置入库日期
	 * @param onSaleDate
	 */
	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}
	
	/**
	 * 得到单价
	 * @return
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * 设置单价
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
