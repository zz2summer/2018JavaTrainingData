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
		jLabel6.setText("最小进价：");
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(20, 135, 69, 33));
		jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel5.setText("最大进价：");
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(253, 201, 65, 33));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("最小售价：");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(19, 200, 68, 32));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("最大售价：");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(255, 74, 54, 33));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("图书名：");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(38, 74, 46, 30));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("uuid：");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(169, 16, 145, 41));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("查询图书");
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
			btnQuery.setText("查询");
			btnQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// 收集参数
					String uuid = txtUuid.getText();// 获取编号，在对应的控件中
					String name = txtName.getText();// 获取图书名，在对应的控件中
					// 当用户没有输入价格时，就默认下面的值
					double inPrice = 0; //最小进价
					double inPrice2 = 0; //最大进价
					double salePrice = 0; //最小售价
					double salePrice2 = 0; //最大售价
					try {
						if (txtMinInPrice.getText() != null
								&& txtMinInPrice.getText().trim().length() > 0) { // 防止用户有非空输入，下同
							inPrice = Double.parseDouble(txtMinInPrice.getText()); //把用户输入的最小进价赋值给inPrice
						}
						if (txtMaxInPrice.getText() != null
								&& txtMaxInPrice.getText().trim().length() > 0) {
							inPrice2 = Double.parseDouble(txtMaxInPrice.getText()); //把用户输入的最大进价赋值给inPrice2
						}
						if (txtMinSalePrice.getText() != null
								&& txtMinSalePrice.getText().trim().length() > 0) {
							salePrice = Double.parseDouble(txtMinSalePrice.getText()); //把用户输入的最小售价赋值给salePrice
						}
						if (txtMaxSalePrice.getText() != null
								&& txtMaxSalePrice.getText().trim().length() > 0) {
							salePrice2 = Double.parseDouble(txtMaxSalePrice.getText()); //把用户输入的最大售价赋值给salePrice2
						}
						//如果出现异常了，则说明用户输入的价格是非法的
					} catch (NumberFormatException e1) { 
						JOptionPane.showMessageDialog(null, "输入价格格式出错。");
						return ;
					}

					// 组织参数(封装成BookQueryModel值对象)
					BookQueryModel bqm = new BookQueryModel();
					bqm.setUuid(uuid); //给bqm，设置编号
					bqm.setName(name); //给bqm，设置图书名
					bqm.setInPrice(inPrice); //给bqm，设置最小进价
					bqm.setInPrice2(inPrice2); //给bqm，设置最大进价
					bqm.setSalePrice(salePrice); //给bqm，设置最小售价
					bqm.setSalePrice2(salePrice2); //给bqm，设置最大售价
					
					//调用逻辑层
					BookEbi ebi=BookEbiFactory.getBookEbi(); //调用逻辑层的工厂方法，获得接口
					List<BookModel> list=ebi.getBycondition(bqm);//通过获得的接口实现具体的功能
					
					//根据逻辑层的记过转向不同的界面
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
			btnBack.setText("返回");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new BookListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

} // @jve:decl-index=0:visual-constraint="175,-9"
