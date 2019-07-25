package cn.hncu.xh.bookStore.user.ui;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.user.business.ebi.UserEbi;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.constance.UserTypeEnum;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 *<p>Title:AddPanel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
public class AddPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JTextField txtName = null;
	private JLabel txtpwd = null;
	private JPasswordField txtPwd = null;
	private JLabel jLabel3 = null;
	private JPasswordField txtPwd2 = null;
	private JLabel jLabel4 = null;
	private JComboBox cmbUser = null;
	private JButton btnAdd = null;
	private JButton btnBack = null;
	
	private JFrame jFrame=null;
	/**
	 * This is the default constructor
	 */
	public AddPanel() {
		initialize();
	}

	public AddPanel(JFrame jFrame) {
		this.jFrame=jFrame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(28, 208, 50, 33));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("类型：");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(239, 149, 66, 32));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("确认密码：");
		txtpwd = new JLabel();
		txtpwd.setBounds(new Rectangle(30, 150, 46, 31));
		txtpwd.setHorizontalAlignment(SwingConstants.CENTER);
		txtpwd.setText("密码：");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(146, 88, 41, 31));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel2.setText("姓名：");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(158, 14, 169, 38));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setText("新增界面");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(jLabel2, null);
		this.add(getTxtName(), null);
		this.add(txtpwd, null);
		this.add(getTxtPwd(), null);
		this.add(jLabel3, null);
		this.add(getTxtPwd2(), null);
		this.add(jLabel4, null);
		this.add(getCmbUser(), null);
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
			txtName.setBounds(new Rectangle(208, 87, 124, 33));
		}
		return txtName;
	}

	/**
	 * This method initializes txtPwd	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxtPwd() {
		if (txtPwd == null) {
			txtPwd = new JPasswordField();
			txtPwd.setBounds(new Rectangle(90, 149, 121, 33));
		}
		return txtPwd;
	}

	/**
	 * This method initializes txtPwd2	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxtPwd2() {
		if (txtPwd2 == null) {
			txtPwd2 = new JPasswordField();
			txtPwd2.setBounds(new Rectangle(314, 150, 141, 32));
		}
		return txtPwd2;
	}

	/**
	 * This method initializes cmbUser	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbUser() {
		if (cmbUser == null) {
			cmbUser = new JComboBox();
			cmbUser.setBounds(new Rectangle(89, 209, 125, 34));
			//从枚举对象中把各种用户类型添加到该组合框控件中
			for(UserTypeEnum type:UserTypeEnum.values()){
				cmbUser.addItem(type.getName());
			}
		}
		return cmbUser;
	}

	/**
	 * This method initializes btnAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton();
			btnAdd.setBounds(new Rectangle(46, 270, 106, 36));
			btnAdd.setText("确认新增");
			btnAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//收集参数
					String name=txtName.getText(); //获取姓名，在对应的控件中
					//这里要为条件下，保证输入的用户名不为空
					if(name.trim().length()<=0){
						JOptionPane.showMessageDialog(null, "用户名不能为空！");
						return;
					}
					String pwd=new String(txtPwd.getPassword()); //获取密码，在对应的控件中
					String pwd2=new String(txtPwd2.getPassword()); //获取确认密码，在对应的控件中
					//需要判断两次输入的密码是否一致
					if(!pwd.equals(pwd2)){
						JOptionPane.showMessageDialog(null, "两次输入密码不吻合！");
						return;
					}
					String selStr=cmbUser.getSelectedItem().toString(); //获取管理权限名，在对应的控件中
					int type =UserTypeEnum.getTypeByName(selStr); //根据管理权限名，getTypeByName通过获得对应的管理权限类型
					//组织参数
					UserModel user=new UserModel(); //new一个空的UserModel
					user.setName(name);//给user设置姓名
					user.setPwd(pwd);//给user设置密码
					user.setType(type);//给user设置管理权限类型
					
					//调用逻辑层ebi
					UserEbi ebi=UserEbiFactory.getUserEbi();
					boolean success=ebi.create(user);
					//根据逻辑层的返回结果，选择转到对应得界面
					if(success){
						JOptionPane.showMessageDialog(null, "添加成功。");
						JPanleUtil.changePanel(jFrame, new ListPanel(jFrame));
					}else{
						JOptionPane.showMessageDialog(null, "该用户名已存在！");
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
			btnBack.setBounds(new Rectangle(347, 269, 103, 35));
			btnBack.setText("返回");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new ListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

}  //  @jve:decl-index=0:visual-constraint="154,18"
