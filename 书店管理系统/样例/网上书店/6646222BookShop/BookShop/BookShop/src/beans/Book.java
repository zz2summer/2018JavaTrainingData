package beans;

import java.sql.Date;

/**
 * �汾 1.0
 * ���ߣ�CuteCode
 * 
 */
public class Book {
	
	/**
	 * ���
	 */
	private int id;
	
	/**
	 * ����
	 */
	private String name;
	
	/**
	 * ����
	 */
	private String author;
	
	/**
	 * ������
	 */
	private String bookman;
	
	/**
	 * �۸�
	 */
	private float price;
	
	/**
	 * �����鵱ǰʣ��ı���
	 */
	private  int remainNum;
	
	/**
	 * ������Ŀ¼���
	 */
	private int categoryId;
	
	/**
	 * ���ݼ��
	 */
	private String introduction;
	
	/**
	 * �ϼܱ���
	 */
	private  int onSaleNum;
	
	/**
	 * �ϼ�����
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
	 * ���캯��
	 *
	 */
	public Book() {
		super();
	}
	/**
	 * ����������
	 * @return
	 */
	public int getOnSaleNum() {
		return onSaleNum;
	}
	/**
	 * �����������
	 * @param onSaleNum
	 */
	public  void setOnSaleNum(int onSaleNum) {
		this.onSaleNum = onSaleNum;
	}
	
	/**
	 * ������п������
	 * @return
	 */
	public  int getRemainNum() {
		return remainNum;
	}
	
	/**
	 * ���ÿ������
	 * @param remainNum
	 */
	public  void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
	}

	/**
	 * �õ�����
	 * @return
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * ��������
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * �õ�������
	 * @return
	 */
	public String getBookman() {
		return bookman;
	}
	
	/**
	 * ���ó�����
	 * @param bookman
	 */
	public void setBookman(String bookman) {
		this.bookman = bookman;
	}
	/**
	 * �õ����ID
	 * @return
	 */
	public int getCategoryId() {
		return categoryId;
	}
	
	/**
	 * �������ID
	 * @param categoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
	 * �õ�ID
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * ����ID
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * �õ�����
	 * @return
	 */
	public String getIntroduction() {
		return introduction;
	}
	
	/**
	 * ����ͼ�����
	 * @param introduction
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	/**
	 * �õ�����
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ��������
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * �õ��������
	 * @return
	 */
	public Date getOnSaleDate() {
		return onSaleDate;
	}
	
	/**
	 * �����������
	 * @param onSaleDate
	 */
	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}
	
	/**
	 * �õ�����
	 * @return
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * ���õ���
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
