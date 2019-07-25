package beans;

/**
 * �汾1.0
 * ���ߣ�CuteCode
 *
 */
public class BookCategory {
	
	/**
	 * ���ID
	 */
	private int id;
	
	/**
	 * �����
	 */
	private String name;
	
	/**
	 * ���캯��
	 *
	 */
	public BookCategory() {
		super();
	}
	
	/**
	 * ������ID
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * �������ID
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * ��������
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ���������
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ���ι��캯��
	 * @param id
	 * @param name
	 */
	public BookCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
