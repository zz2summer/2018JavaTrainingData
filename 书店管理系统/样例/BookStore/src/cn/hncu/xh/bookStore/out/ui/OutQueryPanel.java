package cn.hncu.xh.bookStore.out.ui;

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
import cn.hncu.xh.bookStore.out.business.factory.OutMainEbiFactory;
import cn.hncu.xh.bookStore.out.vo.OutDetailModel;
import cn.hncu.xh.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.xh.bookStore.out.vo.OutMainModel;
import cn.hncu.xh.bookStore.out.vo.OutMainQueryModel;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.util.DateUtil;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 *<p>Title:OutQueryPanel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutQueryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField txtUuid = null;
	private JLabel jLabel2 = null;
	private JComboBox cmbOutUser = null;
	private JLabel jLabel3 = null;
	private JTextField txtDate = null;
	private JLabel jLabel4 = null;
	private JTextField txtDate2 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JTextField tetMoney = null;
	private JLabel jLabel7 = null;
	private JTextField txtMoney2 = null;
	private JLabel jLabel8 = null;
	private JTextField txtOutDetailUuid = null;
	private JLabel jLabel9 = null;
	private JComboBox comBook = null;
	private JLabel jLabel10 = null;
	private JTextField txtOutNum = null;
	private JLabel jLabel11 = null;
	private JTextField txtOutNum2 = null;
	private JButton btnQuery = null;
	private JButton btnBack = null;

	private JFrame jFrame=null;
	/**
	 * This is the default constructor
	 */
	public OutQueryPanel() {
		super();
		initialize();
	}

	public OutQueryPanel(JFrame frame) {
		jFrame=frame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel11 = new JLabel();
		jLabel11.setBounds(new Rectangle(256, 254, 85, 27));
		jLabel11.setText("最大销售数量");
		jLabel10 = new JLabel();
		jLabel10.setBounds(new Rectangle(15, 254, 85, 27));
		jLabel10.setText("最小销售数量");
		jLabel9 = new JLabel();
		jLabel9.setBounds(new Rectangle(256, 211, 85, 27));
		jLabel9.setText("图书");
		jLabel8 = new JLabel();
		jLabel8.setBounds(new Rectangle(15, 211, 85, 27));
		jLabel8.setText("明细uuid");
		jLabel7 = new JLabel();
		jLabel7.setBounds(new Rectangle(256, 170, 85, 27));
		jLabel7.setText("最大总金额");
		jLabel6 = new JLabel();
		jLabel6.setBounds(new Rectangle(15, 170, 85, 27));
		jLabel6.setText("最小总金额");
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(100, 136, 195, 27));
		jLabel5.setText("时间格式示例：2015年01月01日");
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(256, 105, 85, 27));
		jLabel4.setText("销售结束时间");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(15, 105, 85, 27));
		jLabel3.setText("销售开始时间");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(256, 55, 45, 27));
		jLabel2.setText("销售人");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(16, 55, 60, 27));
		jLabel1.setText("uuid");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(195, 9, 96, 33));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("销售查询");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getTxtUuid(), null);
		this.add(jLabel2, null);
		this.add(getCmbOutUser(), null);
		this.add(jLabel3, null);
		this.add(getTxtDate(), null);
		this.add(jLabel4, null);
		this.add(getTxtDate2(), null);
		this.add(jLabel5, null);
		this.add(jLabel6, null);
		this.add(getTetMoney(), null);
		this.add(jLabel7, null);
		this.add(getTxtMoney2(), null);
		this.add(jLabel8, null);
		this.add(getTxtOutDetailUuid(), null);
		this.add(jLabel9, null);
		this.add(getComBook(), null);
		this.add(jLabel10, null);
		this.add(getTxtOutNum(), null);
		this.add(jLabel11, null);
		this.add(getTxtOutNum2(), null);
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
			txtUuid.setBounds(new Rectangle(106, 55, 100, 27));
		}
		return txtUuid;
	}

	/**
	 * This method initializes cmbOutUser	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbOutUser() {
		if (cmbOutUser == null) {
			cmbOutUser = new JComboBox();
			cmbOutUser.setBounds(new Rectangle(345, 55, 120, 27));
			
			cmbOutUser.addItem("请选择。。。");
			List<UserModel> users =UserEbiFactory.getUserEbi().getAllOut();
			for(UserModel user:users){
				cmbOutUser.addItem(user.getName());
			}
		}
		return cmbOutUser;
	}

	/**
	 * This method initializes txtDate	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDate() {
		if (txtDate == null) {
			txtDate = new JTextField();
			txtDate.setBounds(new Rectangle(106, 105, 120, 27));
		}
		return txtDate;
	}

	/**
	 * This method initializes txtDate2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDate2() {
		if (txtDate2 == null) {
			txtDate2 = new JTextField();
			txtDate2.setBounds(new Rectangle(347, 104, 120, 27));
		}
		return txtDate2;
	}

	/**
	 * This method initializes tetMoney	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTetMoney() {
		if (tetMoney == null) {
			tetMoney = new JTextField();
			tetMoney.setBounds(new Rectangle(106, 170, 110, 27));
		}
		return tetMoney;
	}

	/**
	 * This method initializes txtMoney2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtMoney2() {
		if (txtMoney2 == null) {
			txtMoney2 = new JTextField();
			txtMoney2.setBounds(new Rectangle(347, 170, 110, 27));
		}
		return txtMoney2;
	}

	/**
	 * This method initializes txtOutDetailUuid	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOutDetailUuid() {
		if (txtOutDetailUuid == null) {
			txtOutDetailUuid = new JTextField();
			txtOutDetailUuid.setBounds(new Rectangle(106, 211, 110, 27));
		}
		return txtOutDetailUuid;
	}

	/**
	 * This method initializes comBook	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComBook() {
		if (comBook == null) {
			comBook = new JComboBox();
			comBook.setBounds(new Rectangle(348, 211, 120, 27));
			
			comBook.addItem("请选择。。。");
			List<BookModel> books =BookEbiFactory.getBookEbi().getAll();
			for(BookModel book:books){
				comBook.addItem(book.getName());
			}
		}
		return comBook;
	}

	/**
	 * This method initializes txtOutNum	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOutNum() {
		if (txtOutNum == null) {
			txtOutNum = new JTextField();
			txtOutNum.setBounds(new Rectangle(106, 254, 110, 27));
		}
		return txtOutNum;
	}

	/**
	 * This method initializes txtOutNum2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOutNum2() {
		if (txtOutNum2 == null) {
			txtOutNum2 = new JTextField();
			txtOutNum2.setBounds(new Rectangle(348, 254, 110, 27));
		}
		return txtOutNum2;
	}

	/**
	 * This method initializes btnQuery	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton();
			btnQuery.setBounds(new Rectangle(62, 292, 102, 41));
			btnQuery.setText("查询");
			btnQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//收集参数
					String outMainUuid=txtUuid.getText();
					String outUserUuid=null;
					if(cmbOutUser.getSelectedIndex()>0){
						outUserUuid=UserEbiFactory.getUserEbi().getsingle(cmbOutUser.getSelectedItem().toString()).getUuid();
					}
					long outDate=0;
					if(txtDate.getText()!=null&&txtDate.getText().trim().length()>0){
						try {
							outDate=DateUtil.StringToLong(txtDate.getText().trim()+"00:00:00");
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "销售时间开始-->格式错误");
							return;
						}
					}
					long outDate2=0;
					if(txtDate2.getText()!=null&&txtDate2.getText().trim().length()>0){
						try {
							outDate2=DateUtil.StringToLong(txtDate2.getText().trim()+"23:59:59");
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "销售时间结束-->格式错误");
							return;
						}
					}
					double sumMoney=0;
					if(tetMoney.getText()!=null&&tetMoney.getText().trim().length()>0){
						try {
							sumMoney=Double.parseDouble(tetMoney.getText());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "总价最小值输入格式错误");
							return;
						}
					}
					double sumMoney2=0;
					if(txtMoney2.getText()!=null&&txtMoney2.getText().trim().length()>0){
						try {
							sumMoney2=Double.parseDouble(txtMoney2.getText());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "总价最大值输入格式错误");
							return;
						}
					}
					
					String detailUuid=txtOutDetailUuid.getText();
					String bookUuid=null;
					if(comBook.getSelectedIndex()>0){
						bookUuid=BookEbiFactory.getBookEbi().getsingle(comBook.getSelectedItem().toString()).getUuid();
					}
					
					int sumNum=0;
					if(txtOutNum.getText()!=null&&txtOutNum.getText().trim().length()>0){
						try {
							sumNum=Integer.parseInt(txtOutNum.getText().trim());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "销售数量最小值输入格式错误");
							return;
						}
					}
					int sumNum2=0;
					if(txtOutNum2.getText()!=null&&txtOutNum2.getText().trim().length()>0){
						try {
							sumNum2=Integer.parseInt(txtOutNum2.getText().trim());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "销售数量最大值输入格式错误");
							return;
						}
					}
					
					//组织参数
					OutMainQueryModel omqm=new OutMainQueryModel(); //销售单查询值对象
					omqm.setUuid(outMainUuid); //设置销售单Uuid
					omqm.setOutUserUuid(outUserUuid); //设置销售人Uuid
					omqm.setOutDate(outDate);
					omqm.setOutDate(outDate2);
					
					OutDetailQueryModel odqm=new OutDetailQueryModel(); //销售明细查询值对象
					odqm.setUuid(detailUuid); //设置销售明细uuid
					odqm.setBookUuid(bookUuid); //设置图书uuid
					odqm.setSumMoney(sumMoney);  //设置最小总金额
					odqm.setSumMoney2(sumMoney2);//设置最大总金额
					odqm.setSumNum(sumNum);//设置最小销售图书数量
					odqm.setSumNum2(sumNum2);//设置最大销售图书数量
					//调用逻辑层 ，根据结果导向不同页面
					Map<OutMainModel, List<OutDetailModel>> map = OutMainEbiFactory.getOutMainEbi().getByCondition(omqm,odqm);
					JPanleUtil.changePanel(jFrame, new OutListPanel(jFrame,map));
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
			btnBack.setBounds(new Rectangle(300, 292, 102, 41));
			btnBack.setText("返回");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new OutListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

}  //  @jve:decl-index=0:visual-constraint="116,9"
