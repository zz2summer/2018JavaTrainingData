package cn.hncu.xh.bookStore.stock.ui;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.stock.business.factory.StockEbiFactory;
import cn.hncu.xh.bookStore.stock.vo.StockModel;
import cn.hncu.xh.bookStore.stock.vo.StockQueryModel;
import cn.hncu.xh.bookStore.user.ui.ListPanel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 *<p>Title:StockQueryPanel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class StockQueryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField txtUuid = null;
	private JLabel jLabel2 = null;
	private JComboBox cmbBook = null;
	private JLabel jLabel3 = null;
	private JTextField txtNum = null;
	private JLabel jLabel4 = null;
	private JTextField txtNum2 = null;
	private JButton btnQuery = null;
	private JButton btnBack = null;

	private JFrame jFrame=null;
	/**
	 * This is the default constructor
	 */
	public StockQueryPanel() {
		super();
		initialize();
	}

	public StockQueryPanel(JFrame frame) {
		jFrame=frame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(255, 165, 69, 33));
		jLabel4.setText("�������");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(45, 165, 69, 33));
		jLabel3.setText("��С�����");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(255, 85, 49, 33));
		jLabel2.setText("ͼ��");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(45, 85, 49, 33));
		jLabel1.setText("uuid");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(182, 19, 113, 37));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("����ѯ");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getTxtUuid(), null);
		this.add(jLabel2, null);
		this.add(getCmbBook(), null);
		this.add(jLabel3, null);
		this.add(getTxtNum(), null);
		this.add(jLabel4, null);
		this.add(getTxtNum2(), null);
		this.add(getBtnQuery(), null);
		this.add(getBtnBack(), null);
	}

	/**
	 * This method initializes txtUuid	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtUuid() {
		if (txtUuid == null) {
			txtUuid = new JTextField();
			txtUuid.setBounds(new Rectangle(130, 85, 85, 33));
		}
		return txtUuid;
	}

	/**
	 * This method initializes cmbBook	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbBook() {
		if (cmbBook == null) {
			cmbBook = new JComboBox();
			cmbBook.setBounds(new Rectangle(340, 85, 111, 33));
			
			//��ʼ����������ʾ
			cmbBook.addItem("��ѡ��...");
			List<BookModel> books=BookEbiFactory.getBookEbi().getAll();
			for(BookModel book:books){
				cmbBook.addItem(book.getName());
			}
			
		}
		return cmbBook;
	}

	/**
	 * This method initializes txtNum	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNum() {
		if (txtNum == null) {
			txtNum = new JTextField();
			txtNum.setBounds(new Rectangle(130, 165, 85, 33));
		}
		return txtNum;
	}

	/**
	 * This method initializes txtNum2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNum2() {
		if (txtNum2 == null) {
			txtNum2 = new JTextField();
			txtNum2.setBounds(new Rectangle(340, 165, 111, 33));
		}
		return txtNum2;
	}

	/**
	 * This method initializes btnQuery	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton();
			btnQuery.setBounds(new Rectangle(89, 240, 90, 45));
			btnQuery.setText("��ѯ");
			btnQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//�ռ�����
					final String uuid = txtUuid.getText(); //��ȡ��Ҫ��ѯ��uuid
					String bookUuid = null;
					if(cmbBook.getSelectedIndex()>0){//����û�û��ѡ��Ĭ��ȫ����Ҫ
						bookUuid = BookEbiFactory.getBookEbi().getsingle(cmbBook.getSelectedItem().toString()).getUuid(); //���ݻ�õ�bookName������book���߼��㣬���bookUuid
					}
					//�����С��
					int sumNum =0;
					if(txtNum.getText()!=null && txtNum.getText().trim().length()>0){ //�ж����ݵĺϷ���
						try {
							sumNum = Integer.parseInt(txtNum.getText());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "�����С�����ݸ�ʽ����");
							return;
						}
					}
					//��������
					int sumNum2 =0;
					if(txtNum2.getText()!=null && txtNum2.getText().trim().length()>0){//�ж����ݵĺϷ���
						try {
							sumNum2 = Integer.parseInt(txtNum2.getText());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "�����������ݸ�ʽ����");
							return;
						}
					}
					//��֯����
					StockQueryModel sqm = new StockQueryModel(); //new ����ѯֵ����
					sqm.setUuid(uuid); //���ÿ��uuid
					sqm.setBookUuid(bookUuid); //����ͼ��uuid
					sqm.setSumNum(sumNum); //������С�������
					sqm.setSumNum2(sumNum2); //�������������
					//�����߼��㣬���ݷ��ؽ��������ҳ��
					List<StockModel> results = StockEbiFactory.getStockEbi().getByCondition(sqm);
					JPanleUtil.changePanel(jFrame, new StockListPanel(jFrame,results));
				}
			});
		}
		return btnQuery;
	}

	/**
	 * This method initializes btnBack	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setBounds(new Rectangle(300, 240, 90, 45));
			btnBack.setText("����");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new StockListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

}  //  @jve:decl-index=0:visual-constraint="151,13"
