package cn.hncu.xh.bookStore.book.ui;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import cn.hncu.xh.bookStore.book.business.ebi.BookEbi;
import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.book.vo.BookQueryModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 * <p>
 * Title:BookQueryPanel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
public class BookQueryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField txtUuid = null;
	private JLabel jLabel2 = null;
	private JTextField txtName = null;
	private JLabel jLabel3 = null;
	private JTextField txtMaxSalePrice = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JTextField txtMaxInPrice = null;
	private JTextField txtMinSalePrice = null;
	private JTextField txtMinInPrice = null;
	private JLabel jLabel6 = null;
	private JButton btnQuery = null;
	private JButton btnBack = null;

	private JFrame jFrame = null;

	/**
	 * This is the default constructor
	 */
	public BookQueryPanel() {
		initialize();
	}

	public BookQueryPanel(JFrame frame) {
		this.jFrame = frame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel6 = new JLabel();
		jLabel6.setBounds(new Rectangle(245, 138, 68, 30));
		jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel6.setText("��С���ۣ�");
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(20, 135, 69, 33));
		jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel5.setText("�����ۣ�");
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(253, 201, 65, 33));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("��С�ۼۣ�");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(19, 200, 68, 32));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("����ۼۣ�");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(255, 74, 54, 33));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("ͼ������");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(38, 74, 46, 30));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("uuid��");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(169, 16, 145, 41));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("��ѯͼ��");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getTxtUuid(), null);
		this.add(jLabel2, null);
		this.add(getTxtName(), null);
		this.add(jLabel3, null);
		this.add(getTxtMaxSalePrice(), null);
		this.add(jLabel4, null);
		this.add(jLabel5, null);
		this.add(getTxtMaxInPrice(), null);
		this.add(getTxtMinSalePrice(), null);
		this.add(getTxtMinInPrice(), null);
		this.add(jLabel6, null);
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
			txtUuid.setBounds(new Rectangle(101, 75, 112, 34));
		}
		return txtUuid;
	}

	/**
	 * This method initializes txtName
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(new Rectangle(330, 74, 127, 35));
		}
		return txtName;
	}

	/**
	 * This method initializes txtMaxSalePrice
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtMaxSalePrice() {
		if (txtMaxSalePrice == null) {
			txtMaxSalePrice = new JTextField();
			txtMaxSalePrice.setBounds(new Rectangle(104, 200, 111, 32));
		}
		return txtMaxSalePrice;
	}

	/**
	 * This method initializes txtMaxInPrice
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtMaxInPrice() {
		if (txtMaxInPrice == null) {
			txtMaxInPrice = new JTextField();
			txtMaxInPrice.setBounds(new Rectangle(100, 135, 111, 35));
		}
		return txtMaxInPrice;
	}

	/**
	 * This method initializes txtMinSalePrice
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtMinSalePrice() {
		if (txtMinSalePrice == null) {
			txtMinSalePrice = new JTextField();
			txtMinSalePrice.setBounds(new Rectangle(333, 200, 130, 34));
		}
		return txtMinSalePrice;
	}

	/**
	 * This method initializes txtMinInPrice
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtMinInPrice() {
		if (txtMinInPrice == null) {
			txtMinInPrice = new JTextField();
			txtMinInPrice.setBounds(new Rectangle(331, 139, 129, 31));
		}
		return txtMinInPrice;
	}

	/**
	 * This method initializes btnQuery
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton();
			btnQuery.setBounds(new Rectangle(84, 263, 103, 49));
			btnQuery.setText("��ѯ");
			btnQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// �ռ�����
					String uuid = txtUuid.getText();// ��ȡ��ţ��ڶ�Ӧ�Ŀؼ���
					String name = txtName.getText();// ��ȡͼ�������ڶ�Ӧ�Ŀؼ���
					// ���û�û������۸�ʱ����Ĭ�������ֵ
					double inPrice = 0; //��С����
					double inPrice2 = 0; //������
					double salePrice = 0; //��С�ۼ�
					double salePrice2 = 0; //����ۼ�
					try {
						if (txtMinInPrice.getText() != null
								&& txtMinInPrice.getText().trim().length() > 0) { // ��ֹ�û��зǿ����룬��ͬ
							inPrice = Double.parseDouble(txtMinInPrice.getText()); //���û��������С���۸�ֵ��inPrice
						}
						if (txtMaxInPrice.getText() != null
								&& txtMaxInPrice.getText().trim().length() > 0) {
							inPrice2 = Double.parseDouble(txtMaxInPrice.getText()); //���û�����������۸�ֵ��inPrice2
						}
						if (txtMinSalePrice.getText() != null
								&& txtMinSalePrice.getText().trim().length() > 0) {
							salePrice = Double.parseDouble(txtMinSalePrice.getText()); //���û��������С�ۼ۸�ֵ��salePrice
						}
						if (txtMaxSalePrice.getText() != null
								&& txtMaxSalePrice.getText().trim().length() > 0) {
							salePrice2 = Double.parseDouble(txtMaxSalePrice.getText()); //���û����������ۼ۸�ֵ��salePrice2
						}
						//��������쳣�ˣ���˵���û�����ļ۸��ǷǷ���
					} catch (NumberFormatException e1) { 
						JOptionPane.showMessageDialog(null, "����۸��ʽ����");
						return ;
					}

					// ��֯����(��װ��BookQueryModelֵ����)
					BookQueryModel bqm = new BookQueryModel();
					bqm.setUuid(uuid); //��bqm�����ñ��
					bqm.setName(name); //��bqm������ͼ����
					bqm.setInPrice(inPrice); //��bqm��������С����
					bqm.setInPrice2(inPrice2); //��bqm������������
					bqm.setSalePrice(salePrice); //��bqm��������С�ۼ�
					bqm.setSalePrice2(salePrice2); //��bqm����������ۼ�
					
					//�����߼���
					BookEbi ebi=BookEbiFactory.getBookEbi(); //�����߼���Ĺ�����������ýӿ�
					List<BookModel> list=ebi.getBycondition(bqm);//ͨ����õĽӿ�ʵ�־���Ĺ���
					
					//�����߼���ļǹ�ת��ͬ�Ľ���
					JPanleUtil.changePanel(jFrame, new BookListPanel(jFrame,list));
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
			btnBack.setBounds(new Rectangle(296, 263, 103, 49));
			btnBack.setText("����");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new BookListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

} // @jve:decl-index=0:visual-constraint="175,-9"
