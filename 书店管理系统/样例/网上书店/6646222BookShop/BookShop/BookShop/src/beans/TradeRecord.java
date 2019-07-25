package beans;

/**
 * ͼ�����ۼ�¼��
 * �汾 1.0
 * @author Cute Code
 * 
 */
public class TradeRecord {

	/**
	 * ���
	 */
	private int id;

	/**
	 * �û����
	 */
	private int userId;
	

	/**
	 * ͼ����
	 */
	private int bookId;
	
	/**
	 * ��������
	 */
	private int tradeNum;
	/**
	 * �����ܶ�
	 */
	private double sum;
	
	/**
	 * �޲ι��캯��
	 */
	public TradeRecord() {

	}

	/**
	 * ���ι��캯��
	 * @param id
	 * @param userId
	 * @param bookId
	 * @param tradeNum
	 * @param sum
	 */
	public TradeRecord(int id, int userId, int bookId, int tradeNum, double sum) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.tradeNum = tradeNum;
		this.sum = sum;
	}
	
	/**
	 * ���ͼ������Ϣ
	 * @return
	 */
	public int getBookId() {
		return bookId;
	}
	
	/**
	 * �޸�ͼ������Ϣ
	 * @param bookId
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	/**
	 * ��ý��ױ��
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * �޸Ľ��ױ��
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * ��ý����ܶ�
	 * @return
	 */
	public double getSum() {
		return sum;
	}
	/**
	 * �޸Ľ����ܶ�
	 * @param sum
	 */
	public void setSum(double sum) {
		this.sum = sum;
	}

	/**
	 * ��ý�������
	 * @return
	 */
	public int getTradeNum() {
		return tradeNum;
	}
	/**
	 * �޸Ľ�������
	 * @param tradeNum
	 */
	public void setTradeNum(int tradeNum) {
		this.tradeNum = tradeNum;
	}
	/**
	 * ����û�ID
	 * @return
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * �޸��û�ID
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
