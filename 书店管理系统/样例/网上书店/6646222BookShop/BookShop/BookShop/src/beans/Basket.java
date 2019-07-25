package beans;
import java.sql.*;
/**
 * ���ﳵ��
 * 
 * @author Cute Code
 *
 */
public class Basket {
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
	private float unitPrice;
	/**
	 *  ����
	 */
	private int number;
	/**
	 * �ܼ�
	 */ 
	private float totalPrice;
	
	/**
	 * �������
	 */
	private Date addDate;
	
	/**
	 * ͼ����
	 */ 
	private int bookId;
	/**
	 * �û�����
	 */
	private String userName;
	
	/**
	 * ���ͼ����
	 * @return
	 */
	public int getBookId() {
		return bookId;
	}
	/**
	 * ����ͼ����
	 * @param bookId
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	/**
	 * �޲ι��캯��
	 *
	 */
	public Basket() {
	// TODO Auto-generated constructor stub
	}
	/**
	 * ���ι��캯��
	 * @param id
	 * @param name
	 * @param unitPrice
	 * @param number
	 * @param totalPrice
	 * @param addDate
	 * @param bookId
	 * @param userName
	 */
	public Basket(int id, String name, float unitPrice, int number, float totalPrice, Date addDate, int bookId, String userName) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.number = number;
		this.totalPrice = totalPrice;
		this.addDate = addDate;
		this.bookId = bookId;
		this.userName = userName;
	}
	/**
	 * ����������
	 */ 
	public Date getAddDate() {
		return addDate;
	}
	/**
	 * �����������
	 * @param addDate
	 */
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	/**
	 *  ��ñ��
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
	/**
	 * �������
	 * @return
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * ��������
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * ����ܼ�
	 * @return
	 */
	public float getTotalPrice() {
		return totalPrice;
	}
	/**
	 * �����ܼ�
	 * @param totalPrice
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * ��õ���
	 * @return
	 */
	public float getUnitPrice() {
		return unitPrice;
	}
	/**
	 * ���õ���
	 * @param unitPrice
	 */
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * �������
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
	 * ����û���
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * �����û���
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
