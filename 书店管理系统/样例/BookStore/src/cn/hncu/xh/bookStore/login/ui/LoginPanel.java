package cn.hncu.xh.bookStore.login.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.BookStore;
import cn.hncu.xh.bookStore.login.business.factory.LoginEbiFactory;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.constance.UserTypeEnum;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 *<p>Title:LoginPanel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextField txtName = null;
	private JPasswordField pwd = null;
	private JButton btnLogin = null;

	private JFrame jFrame=null;
	private BookStore store=null;
	/**
	 * This is the default constructor
	 */
	public LoginPanel() {
		super();
		initialize();
	}

	public LoginPanel(JFrame frame, BookStore bookStore) {
		store=bookStore;
		jFrame=frame;
		initialize();
	}

	public LoginPanel(JFrame frame) {
		jFrame=frame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(92, 194, 96, 46));
		jLabel2.setFont(new Font("\u6977\u4f53", Font.BOLD, 24));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setForeground(new Color(71, 28, 214));
		jLabel2.setText("密码");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(90, 120, 96, 46));
		jLabel1.setFont(new Font("\u6977\u4f53", Font.BOLD, 24));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setForeground(new Color(74, 25, 187));
		jLabel1.setText("用户名");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(142, 32, 152, 60));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 36));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setForeground(new Color(123, 210, 204));
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel.setText("登录");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 480, 370));
		this.setForeground(new Color(148, 191, 208));
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(getTxtName(), null);
		this.add(getPwd(), null);
		this.add(getBtnLogin(), null);
	}

	/**
	 * This method initializes txtName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(new Rectangle(218, 119, 150, 50));
			txtName.setFont(new Font("Dialog", Font.PLAIN, 18));
		}
		return txtName;
	}

	/**
	 * This method initializes pwd	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPwd() {
		if (pwd == null) {
			pwd = new JPasswordField();
			pwd.setBounds(new Rectangle(220, 196, 150, 50));
			pwd.setFont(new Font("Dialog", Font.PLAIN, 18));
		}
		return pwd;
	}

	/**
	 * This method initializes btnLogin	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton();
			btnLogin.setBounds(new Rectangle(157, 269, 121, 44));
			btnLogin.setForeground(new Color(51, 107, 30));
			btnLogin.setFont(new Font("\u6977\u4f53", Font.BOLD, 24));
			btnLogin.setText("登录");
			btnLogin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//1 收集 name pwd
					String name = txtName.getText();
					String Pwd = new String(pwd.getPassword());
					
					//2 组织
					//3 调用，4 导向结果页面
					String result = LoginEbiFactory.getLoginEbi().login(name, Pwd);
					if(result==null){//登录成功
						UserModel user = UserEbiFactory.getUserEbi().getsingle(name);
						if(user.getType()==UserTypeEnum.ADMIN.getType()){
							store.getJMenuItemUser().setEnabled(true);
							store.getJMenuItemBook().setEnabled(true);
							store.getJMenuItemIn().setEnabled(true);
							store.getJMenuItemOut().setEnabled(true);
							store.getJMenuItemStock().setEnabled(true);
							
						}else if(user.getType()==UserTypeEnum.BOOK.getType()){
							store.getJMenuItemBook().setEnabled(true);
						}else if(user.getType()==UserTypeEnum.IN.getType()){
							store.getJMenuItemIn().setEnabled(true);
						}else if(user.getType()==UserTypeEnum.OUT.getType()){
							store.getJMenuItemOut().setEnabled(true);
						}else if(user.getType()==UserTypeEnum.STOCK.getType()){
							store.getJMenuItemStock().setEnabled(true);
						}
						
						JPanleUtil.changePanel(jFrame, new WelcomePanel());
					}else{
						JOptionPane.showMessageDialog(null, result);
					}
				}
			});
		}
		return btnLogin;
	}

}  //  @jve:decl-index=0:visual-constraint="154,14"
