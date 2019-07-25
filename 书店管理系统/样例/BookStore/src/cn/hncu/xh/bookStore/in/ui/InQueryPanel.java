package cn.hncu.xh.bookStore.in.ui;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;
import java.util.Map;

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
import cn.hncu.xh.bookStore.in.business.factory.InMainEbiFctory;
import cn.hncu.xh.bookStore.in.vo.InDetailModel;
import cn.hncu.xh.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.xh.bookStore.in.vo.InMainModel;
import cn.hncu.xh.bookStore.in.vo.InMainQueryModel;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.util.DateUtil;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 * <p>
 * Title:InQueryPanel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 26, 2015
 */
public class InQueryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame jFrame = null;
	private JLabel jLabel = null;
	private JComboBox cmbUser = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JComboBox cmbBook = null;
	private JLabel jLabel3 = null;
	private JTextField txtUuid = null;
	private JLabel jLabel4 = null;
	private JTextField txtDateBegain = null;
	private JLabel jLabel5 = null;
	private JTextField txtDateEnd = null;
	private JLabel jLabel6 = null;
	private JTextField txtInMinNum = null;
	private JLabel jLabel7 = null;
	private JTextField txtInMaxNum = null;
	private JLabel jLabel8 = null;
	private JTextField txtMinMoney = null;
	private JLabel jLabel9 = null;
	private JTextField txtMaxMoney = null;
	private JLabel jLabel10 = null;
	private JButton btnQuery = null;
	private JButton btnBack = null;
	private JLabel jLabel11 = null;
	private JTextField txtInDetailUuid = null;

	/**
	 * This is the default constructor
	 */
	public InQueryPanel() {
		initialize();
	}

	public InQueryPanel(JFrame frame) {
		jFrame = frame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel11 = new JLabel();
		jLabel11.setBounds(new Rectangle(18, 208, 68, 30));
		jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel11.setText("明细uuid:");
		jLabel10 = new JLabel();
		jLabel10.setBounds(new Rectangle(109, 130, 169, 23));
		jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel10.setText("时间格式：1990年01月01日");
		jLabel9 = new JLabel();
		jLabel9.setBounds(new Rectangle(252, 165, 81, 32));
		jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel9.setText("最大总金额:");
		jLabel8 = new JLabel();
		jLabel8.setBounds(new Rectangle(15, 165, 77, 35));
		jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel8.setText("最小总金额:");
		jLabel7 = new JLabel();
		jLabel7.setBounds(new Rectangle(254, 254, 79, 33));
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setText("最大进货数:");
		jLabel6 = new JLabel();
		jLabel6.setBounds(new Rectangle(15, 255, 81, 33));
		jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel6.setText("最小进货数:");
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(241, 88, 89, 36));
		jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel5.setText("进货时间结束:");
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(13, 90, 89, 36));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("进货时间开始:");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(29, 44, 49, 33));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("uuid:");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(254, 208, 57, 32));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("图书:");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(248, 44, 49, 32));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("进货人:");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(200, 6, 82, 31));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("进货查询");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(getCmbUser(), null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(getCmbBook(), null);
		this.add(jLabel3, null);
		this.add(getTxtUuid(), null);
		this.add(jLabel4, null);
		this.add(getTxtDateBegain(), null);
		this.add(jLabel5, null);
		this.add(getTxtDateEnd(), null);
		this.add(jLabel6, null);
		this.add(getTxtInMinNum(), null);
		this.add(jLabel7, null);
		this.add(getTxtInMaxNum(), null);
		this.add(jLabel8, null);
		this.add(getTxtMinMoney(), null);
		this.add(jLabel9, null);
		this.add(getTxtMaxMoney(), null);
		this.add(jLabel10, null);
		this.add(getBtnQuery(), null);
		this.add(getBtnBack(), null);
		this.add(jLabel11, null);
		this.add(getTxtInDetailUuid(), null);
	}

	/**
	 * This method initializes cmbUser
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbUser() {
		if (cmbUser == null) {
			cmbUser = new JComboBox();
			cmbUser.setBounds(new Rectangle(316, 44, 134, 32));
			cmbUser.addItem("请选择...");
			List<UserModel> list = UserEbiFactory.getUserEbi().getAll();
			for (UserModel user : list) {
				cmbUser.addItem(user.getName());
			}
		}
		return cmbUser;
	}

	/**
	 * This method initializes cmbBook
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbBook() {
		if (cmbBook == null) {
			cmbBook = new JComboBox();
			cmbBook.setBounds(new Rectangle(331, 210, 134, 32));
			cmbBook.addItem("请选择...");
			List<BookModel> list = BookEbiFactory.getBookEbi().getAll();
			for (BookModel book : list) {
				cmbBook.addItem(book.getName());
			}

		}
		return cmbBook;
	}

	/**
	 * This method initializes txtUuid
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtUuid() {
		if (txtUuid == null) {
			txtUuid = new JTextField();
			txtUuid.setBounds(new Rectangle(105, 45, 74, 32));
		}
		return txtUuid;
	}

	/**
	 * This method initializes txtDateBegain
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtDateBegain() {
		if (txtDateBegain == null) {
			txtDateBegain = new JTextField();
			txtDateBegain.setBounds(new Rectangle(109, 90, 126, 35));
		}
		return txtDateBegain;
	}

	/**
	 * This method initializes txtDateEnd
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtDateEnd() {
		if (txtDateEnd == null) {
			txtDateEnd = new JTextField();
			txtDateEnd.setBounds(new Rectangle(338, 88, 127, 38));
		}
		return txtDateEnd;
	}

	/**
	 * This method initializes txtInMinNum
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtInMinNum() {
		if (txtInMinNum == null) {
			txtInMinNum = new JTextField();
			txtInMinNum.setBounds(new Rectangle(105, 254, 99, 33));
		}
		return txtInMinNum;
	}

	/**
	 * This method initializes txtInMaxNum
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtInMaxNum() {
		if (txtInMaxNum == null) {
			txtInMaxNum = new JTextField();
			txtInMaxNum.setBounds(new Rectangle(355, 255, 107, 31));
		}
		return txtInMaxNum;
	}

	/**
	 * This method initializes txtMinMoney
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtMinMoney() {
		if (txtMinMoney == null) {
			txtMinMoney = new JTextField();
			txtMinMoney.setBounds(new Rectangle(102, 165, 99, 33));
		}
		return txtMinMoney;
	}

	/**
	 * This method initializes txtMaxMoney
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtMaxMoney() {
		if (txtMaxMoney == null) {
			txtMaxMoney = new JTextField();
			txtMaxMoney.setBounds(new Rectangle(348, 165, 107, 31));
		}
		return txtMaxMoney;
	}

	/**
	 * This method initializes btnQuery
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton();
			btnQuery.setBounds(new Rectangle(103, 299, 106, 36));
			btnQuery.setText("确认查询");
			btnQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// 收集参数
					// 订单号的uuid
					String uuid = txtUuid.getText();
					// 进货人的uuid
					String inUserUuid = null;
					if (cmbUser.getSelectedIndex() > 0) {
						String name = cmbUser.getSelectedItem().toString(); // 从cmbUser中获取选中的userName
						inUserUuid = UserEbiFactory.getUserEbi()
								.getsingle(name).getUuid(); // 通过userName找到对应的UserModel，从而获得进货人的uuid
					}
					// 进货开始时间
					long inDate = 0;
					String str = txtDateBegain.getText();// 从对应的组件中获得进货开始日期
					if (str != null && str.trim().length() > 0) {// 判断获得的消息是否合法
						try {
							inDate = DateUtil.StringToLong(str + "00:00:00");// 把获得的字符串日期，转换成long型，并把时分秒初始化为一天的开始
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "进货开始时间格式错误！");
							return;
						}
					}
					// 进货结束时间
					long inDate2 = 0;
					String str2 = txtDateEnd.getText();// 从对应的组件中获得进货结束日期
					if (str2 != null && str2.trim().length() > 0) {// 判断获得的消息是否合法
						try {
							inDate2 = DateUtil.StringToLong(str2 + "23:59:59");// 把获得的字符串日期，转换成long型，并把时分秒初始化为一天的结束
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "进货结束时间格式错误！");
							return;
						}
					}
					// 以下是收集订单明细信息
					// 订单明细的uuid
					String detailUuid = txtInDetailUuid.getText();// 从对应的组件中获得订单明细uuid
					// 图书的uuid
					String bookUuid = null;
					if (cmbBook.getSelectedIndex() > 0) {// 如果用户没有选，则默认全部都需要查询到
						String bookName = cmbBook.getSelectedItem().toString();// 从cmbBook中获得选中该的bookName
						bookUuid = BookEbiFactory.getBookEbi().getsingle(
								bookName).getUuid(); // //通过bookName找到对应的UBookModel，从而获得图书的uuid
					}
					// 总价最小值
					double sumMoney = 0;
					String strM = txtMinMoney.getText();// 从对应的组件中获得最小总金额
					if (strM != null && strM.trim().length() > 0) {// 判断strM的合法性
						try {
							sumMoney = Double.parseDouble(strM); // 把字符串转换成double型
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "最小总金额格式输入错误！");
							return;
						}
					}
					// 总价最大值
					double sumMoney2 = 0;
					String strM2 = txtMaxMoney.getText();// 从对应的组件中获得最大总金额
					if (strM2 != null && strM2.trim().length() > 0) {// 判断strM2的合法性
						try {
							sumMoney2 = Double.parseDouble(strM2);// 把字符串转换成double型
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "最大总金额格式输入错误！");
							return;
						}
					}
					// 最小进货数量
					int sumNum = 0;
					if (txtInMinNum.getText() != null
							&& txtInMinNum.getText().trim().length() > 0) {// 判断最小进货数的合法性
						try {
							sumNum = Integer.parseInt(txtInMinNum.getText());// 把字符串转换成整型
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "最小进货数格式输入错误！");
							return;
						}
					}
					// 最大进货数量
					int sumNum2 = 0;
					if (txtInMaxNum.getText() != null
							&& txtInMaxNum.getText().trim().length() > 0) {// 判断最小进货数的合法性
						try {
							sumNum2 = Integer.parseInt(txtInMaxNum.getText());// 把字符串转换成整型
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "最大进货数格式输入错误！");
							return;
						}
					}
					// 组织参数
					InMainQueryModel imqm = new InMainQueryModel();// 封装查询订单值对象
					imqm.setUuid(uuid); //设置订单号uuid
					imqm.setInUserUuid(inUserUuid); //设置进货人uuid
					imqm.setInDate(inDate);//设置开始日期
					imqm.setInDate2(inDate2);//设置结束日期
					
					InDetailQueryModel idqm=new InDetailQueryModel();// 封装查询订单值对象
					idqm.setUuid(detailUuid);//设置订单明细uuid
					idqm.setBookUuid(bookUuid); //设置图书uuid
					idqm.setSunMoney(sumMoney);  //设置最小总金额
					idqm.setSumMoney2(sumMoney2); //设置最大总金额
					idqm.setSumNum(sumNum);    //设置最小图书数量
					idqm.setSumNum2(sumNum2);  //设置最大图书数量
					
					//调用逻辑层
					Map<InMainModel,List<InDetailModel>> map=InMainEbiFctory.getInMainEbi().getByCondition(imqm,idqm);
					JPanleUtil.changePanel(jFrame, new InListPanel(jFrame,map));
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
			btnBack.setBounds(new Rectangle(288, 299, 106, 36));
			btnBack.setText("返回");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new InListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

	/**
	 * This method initializes txtInDetailUuid
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtInDetailUuid() {
		if (txtInDetailUuid == null) {
			txtInDetailUuid = new JTextField();
			txtInDetailUuid.setBounds(new Rectangle(105, 210, 99, 33));
		}
		return txtInDetailUuid;
	}

} // @jve:decl-index=0:visual-constraint="150,-4"
