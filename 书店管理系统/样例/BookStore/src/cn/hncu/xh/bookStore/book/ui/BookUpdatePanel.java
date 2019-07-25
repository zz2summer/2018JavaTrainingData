package cn.hncu.xh.bookStore.book.ui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import cn.hncu.xh.bookStore.book.business.ebi.BookEbi;
import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 * <p>
 * Title:BookUpdatePanel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
public class BookUpdatePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField txtUuid = null;
	private JLabel jLabel2 = null;
	private JTextField txtName = null;
	private JLabel jLabel3 = null;
	private JTextField txtInPrice = null;
	private JLabel jLabel4 = null;
	private JTextField txtSalePrice = null;
	private JButton btnUpdate = null;
	private JButton btnBack = null;

	private JFrame jFrame = null;
	private BookModel book = null;

	/**
	 * This is the default constructor
	 */
	public BookUpdatePanel() {
		initialize();
	}

	public BookUpdatePanel(JFrame frame, String uuid) {
		this.jFrame = frame;
		this.book = BookEbiFactory.getBookEbi().getSingle(uuid);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(254, 165, 63, 31));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("售价：");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(44, 165, 48, 32));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("进价：");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(256, 89, 59, 32));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("图书名：");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(45, 89, 46, 32));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("uuid：");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(171, 16, 145, 38));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("修改图书");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getTxtUuid(), null);
		this.add(jLabel2, null);
		this.add(getTxtName(), null);
		this.add(jLabel3, null);
		this.add(getTxtInPrice(), null);
		this.add(jLabel4, null);
		this.add(getTxtSalePrice(), null);
		this.add(getBtnUpdate(), null);
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
			txtUuid.setBounds(new Rectangle(105, 91, 122, 30));
			txtUuid.setText(book.getUuid());
			txtUuid.setEditable(false);
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
			txtName.setBounds(new Rectangle(324, 90, 130, 33));
			txtName.setText(book.getName());
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
			txtInPrice.setBounds(new Rectangle(105, 164, 123, 32));
			txtInPrice.setText("" + book.getInPrice());
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
			txtSalePrice.setBounds(new Rectangle(332, 164, 127, 34));
			txtSalePrice.setText("" + book.getSalePrice());
		}
		return txtSalePrice;
	}

	/**
	 * This method initializes btnUpdate
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton();
			btnUpdate.setBounds(new Rectangle(74, 240, 93, 47));
			btnUpdate.setText("修改");
			btnUpdate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// 收集参数
					String uuid = txtUuid.getText(); // 获取编号，在对应的控件中
					String name = txtName.getText(); // 获取书名，在对应的控件中
					// 这里要为条件下，保证输入的用户名不为空
					if (name.trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "书名不能为空！");
						return;
					}
					double inPrice = 0;
					double salePrice = 0;
					// 防止输入数据不合法
					try {
						inPrice = Double.parseDouble(txtInPrice.getText());
						salePrice = Double.parseDouble(txtSalePrice.getText());
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "价格输入不合法！");
						return;
					}
					// 判断价格不能为负数
					if (inPrice < 0 || salePrice < 0) {
						JOptionPane.showMessageDialog(null, "价格不能为负数！");
						return;
					}
					// 组织参数
					BookModel book = new BookModel();// new一个空的BookModel
					book.setUuid(uuid); // 给book设置编号
					book.setName(name);// 给book设置书名
					book.setInPrice(inPrice);// 给book设置进货价
					book.setSalePrice(salePrice);// 给book设置出售价格
					// 调用逻辑层
					BookEbi ebi = BookEbiFactory.getBookEbi();
					boolean success = ebi.update(book);

					// 根据逻辑层的返回结果，跳到跳到不同的界面
					if (success) {
						JOptionPane.showMessageDialog(null, "修改成功。");
						JPanleUtil.changePanel(jFrame,
								new BookListPanel(jFrame));
					} else {
						JOptionPane.showMessageDialog(null, "该图书不存在！");
					}
				}
			});
		}
		return btnUpdate;
	}

	/**
	 * This method initializes btnBack
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setBounds(new Rectangle(270, 240, 93, 47));
			btnBack.setText("返回");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new BookListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

} // @jve:decl-index=0:visual-constraint="158,9"
