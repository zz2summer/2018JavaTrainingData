package cn.hncu.xh.bookStore.book.ui;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.book.business.ebi.BookEbi;
import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 * <p>
 * Title:BookAddPanel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
public class BookAddPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JTextField txtName = null;
	private JLabel jLabel3 = null;
	private JTextField txtInPrice = null;
	private JLabel jLabel4 = null;
	private JTextField txtSalePrice = null;
	private JButton btnAdd = null;
	private JButton btnBack = null;

	private JFrame jFrame = null;

	/**
	 * This is the default constructor
	 */
	public BookAddPanel() {
		initialize();
	}

	public BookAddPanel(JFrame frame) {
		this.jFrame = frame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(235, 179, 65, 30));
		jLabel4.setText("���ۼ۸�");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(28, 178, 66, 34));
		jLabel3.setText("�����۸�");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(132, 91, 67, 33));
		jLabel2.setText("ͼ������");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(180, 16, 141, 44));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setText("����ͼ��");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(jLabel2, null);
		this.add(getTxtName(), null);
		this.add(jLabel3, null);
		this.add(getTxtInPrice(), null);
		this.add(jLabel4, null);
		this.add(getTxtSalePrice(), null);
		this.add(getBtnAdd(), null);
		this.add(getBtnBack(), null);
	}

	/**
	 * This method initializes txtName
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(new Rectangle(235, 91, 142, 33));
		}
		return txtName;
	}

	/**
	 * This method initializes txtInPrice
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtInPrice() {
		if (txtInPrice == null) {
			txtInPrice = new JTextField();
			txtInPrice.setBounds(new Rectangle(106, 179, 108, 32));
		}
		return txtInPrice;
	}

	/**
	 * This method initializes txtSalePrice
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtSalePrice() {
		if (txtSalePrice == null) {
			txtSalePrice = new JTextField();
			txtSalePrice.setBounds(new Rectangle(316, 179, 134, 33));
		}
		return txtSalePrice;
	}

	/**
	 * This method initializes btnAdd
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton();
			btnAdd.setBounds(new Rectangle(92, 255, 100, 45));
			btnAdd.setText("ȷ������");
			btnAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// �ռ�����
					String name = txtName.getText(); // ��ȡ�������ڶ�Ӧ�Ŀؼ���
					// ����ҪΪ�����£���֤������û�����Ϊ��
					if (name.trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
						return;
					}
					double inPrice = 0;
					double salePrice = 0;
					// ��ֹ�������ݲ��Ϸ�
					try {
						inPrice = Double.parseDouble(txtInPrice.getText());
						salePrice = Double.parseDouble(txtSalePrice.getText());
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "�۸����벻�Ϸ���");
						return;
					}
					// �жϼ۸���Ϊ����
					if (inPrice < 0 || salePrice < 0) {
						JOptionPane.showMessageDialog(null, "�۸���Ϊ������");
						return;
					}
					// ��֯����
					BookModel book = new BookModel();// newһ���յ�BookModel
					book.setName(name);// ��book��������
					book.setInPrice(inPrice);// ��book���ý�����
					book.setSalePrice(salePrice);// ��book���ó��ۼ۸�
					// �����߼���
					BookEbi ebi = BookEbiFactory.getBookEbi();
					boolean success = ebi.create(book);

					// �����߼���ķ��ؽ��������������ͬ�Ľ���
					if (success) {
						JOptionPane.showMessageDialog(null, "��ӳɹ���");
						JPanleUtil.changePanel(jFrame,
								new BookListPanel(jFrame));
					} else {
						JOptionPane.showMessageDialog(null, "�������Ѵ��ڣ�");
					}
				}
			});
		}
		return btnAdd;
	}

	/**
	 * This method initializes btnBack
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setBounds(new Rectangle(285, 255, 100, 45));
			btnBack.setText("����");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new BookListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

} // @jve:decl-index=0:visual-constraint="161,18"
