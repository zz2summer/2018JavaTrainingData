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
		jLabel4.setText("出售价格：");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(28, 178, 66, 34));
		jLabel3.setText("进货价格：");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(132, 91, 67, 33));
		jLabel2.setText("图书名：");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(180, 16, 141, 44));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setText("新增图书");
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
			btnAdd.setText("确认新增");
			btnAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// 收集参数
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
					book.setName(name);// 给book设置书名
					book.setInPrice(inPrice);// 给book设置进货价
					book.setSalePrice(salePrice);// 给book设置出售价格
					// 调用逻辑层
					BookEbi ebi = BookEbiFactory.getBookEbi();
					boolean success = ebi.create(book);

					// 根据逻辑层的返回结果，跳到跳到不同的界面
					if (success) {
						JOptionPane.showMessageDialog(null, "添加成功。");
						JPanleUtil.changePanel(jFrame,
								new BookListPanel(jFrame));
					} else {
						JOptionPane.showMessageDialog(null, "该书名已存在！");
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
			btnBack.setText("返回");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new BookListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

} // @jve:decl-index=0:visual-constraint="161,18"
