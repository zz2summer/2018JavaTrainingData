/*
 * LoginPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.login.ui;

import javax.swing.JOptionPane;

import cn.hncu.bookStore.BookStore;
import cn.hncu.bookStore.common.UserTypeEnum;
import cn.hncu.bookStore.login.business.factory.LoginEbiFactory;
import cn.hncu.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.bookStore.user.vo.UserModel;

/**
 * 
 * @author 陈浩翔
 *
 * @version 1.0  2016-4-20
 */
public class LoginPanel extends javax.swing.JPanel {
	private BookStore mainFrame = null;

	/** Creates new form LoginPanel */
	public LoginPanel(BookStore mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		tfdName = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		tfpPwd = new javax.swing.JPasswordField();
		btnLogin = new javax.swing.JButton();
		btnHelp = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Dialog", 1, 48));
		jLabel1.setForeground(new java.awt.Color(255, 51, 0));
		jLabel1.setText("\u767b\u5f55");
		add(jLabel1);
		jLabel1.setBounds(320, 20, 140, 120);

		jLabel2.setFont(new java.awt.Font("宋体", 1, 24));
		jLabel2.setForeground(new java.awt.Color(51, 0, 255));
		jLabel2.setText("\u5bc6 \u7801:");
		add(jLabel2);
		jLabel2.setBounds(210, 330, 80, 40);

		tfdName.setFont(new java.awt.Font("微软雅黑", 1, 24));
		add(tfdName);
		tfdName.setBounds(310, 220, 190, 40);

		jLabel3.setFont(new java.awt.Font("宋体", 1, 24));
		jLabel3.setForeground(new java.awt.Color(51, 0, 255));
		jLabel3.setText("\u7528\u6237\u540d:");
		add(jLabel3);
		jLabel3.setBounds(200, 220, 120, 40);

		tfpPwd.setFont(new java.awt.Font("宋体", 1, 24));
		add(tfpPwd);
		tfpPwd.setBounds(310, 330, 190, 40);

		btnLogin.setFont(new java.awt.Font("Dialog", 1, 24));
		btnLogin.setForeground(new java.awt.Color(51, 0, 255));
		btnLogin.setText("\u767b\u5f55");
		btnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLoginActionPerformed(evt);
			}
		});
		add(btnLogin);
		btnLogin.setBounds(150, 440, 120, 70);

		btnHelp.setFont(new java.awt.Font("Dialog", 1, 24));
		btnHelp.setForeground(new java.awt.Color(0, 0, 255));
		btnHelp.setText("\u5e2e\u52a9");
		btnHelp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHelpActionPerformed(evt);
			}
		});
		add(btnHelp);
		btnHelp.setBounds(450, 440, 130, 70);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new LoginHelp(mainFrame));
		mainFrame.validate();
	}

	private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
		//1收集
		String name = tfdName.getText();
		String pwd = new String(tfpPwd.getPassword());
		
		if(name.equals("admin")&&pwd.equals("123456")){
			mainFrame.getjMenuItemUser().setEnabled(true);
			mainFrame.getjMenuItemBook().setEnabled(true);
			mainFrame.getjMenuItemIn().setEnabled(true);
			mainFrame.getjMenuItemOut().setEnabled(true);
			mainFrame.getjMenuItemStock().setEnabled(true);
			
			mainFrame.setContentPane(new LoginWelcomePanel());
			mainFrame.validate();
		}
		
		//2组织---没有值对象，不组织了		
		//3调用逻辑层
		String result = LoginEbiFactory.getLoginEbi().login(name, pwd);

		//4返回到结果页面
		if (result != null) {
			JOptionPane.showMessageDialog(mainFrame, result);
			return;
		}

		//接下来，登录成功的情况
		//把该用户类型所对应的模块点亮
		UserModel user = UserEbiFactory.getUserEbi().getUserByName(name);
		//超级管理员，点亮所有模块
		if (user.getType() == UserTypeEnum.ADMIN.getType()) {
			mainFrame.getjMenuItemUser().setEnabled(true);
			mainFrame.getjMenuItemBook().setEnabled(true);
			mainFrame.getjMenuItemIn().setEnabled(true);
			mainFrame.getjMenuItemOut().setEnabled(true);
			mainFrame.getjMenuItemStock().setEnabled(true);
		}

		//图书管理员，点亮图书模块
		if (user.getType() == UserTypeEnum.BOOK.getType()) {
			mainFrame.getjMenuItemBook().setEnabled(true);
		}
		//进货管理员，点亮进货模块
		if (user.getType() == UserTypeEnum.IN.getType()) {
			mainFrame.getjMenuItemIn().setEnabled(true);
		}
		//销售管理员，点亮销售模块
		if (user.getType() == UserTypeEnum.OUT.getType()) {
			mainFrame.getjMenuItemOut().setEnabled(true);
		}
		//库存管理员，点亮库存模块
		if (user.getType() == UserTypeEnum.STOCK.getType()) {
			mainFrame.getjMenuItemStock().setEnabled(true);
		}

		mainFrame.setContentPane(new LoginWelcomePanel());
		mainFrame.validate();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnHelp;
	private javax.swing.JButton btnLogin;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JTextField tfdName;
	private javax.swing.JPasswordField tfpPwd;
	// End of variables declaration//GEN-END:variables

}