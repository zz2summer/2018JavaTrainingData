/*
 * DeletePanel.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.user.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.common.UserTypeEnum;
import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.util.FileIoUtil;

/**
 * 
 * @author �º���
 *
 * @version 1.0
 */
public class DeletePanel extends javax.swing.JPanel {
	private JFrame mainFrame = null;
	private String uuid = null;

	/** Creates new form DeletePanel 
	 * @param uuid */
	public DeletePanel(JFrame mainFrame, String uuid) {
		this.mainFrame = mainFrame;
		this.uuid = uuid;
		initComponents();
		myInitData();
	}

	private void myInitData() {
		UserEbi user = UserEbiFactory.getUserEbi();
		UserModel userModel = user.getSingle(uuid);
		tfdName.setText(userModel.getName());
		tfdUuid.setText(userModel.getUuid());
		tfdPwd.setText(userModel.getPwd());
		tfdType.setText(UserTypeEnum.getNameByType(userModel.getType()));

		tfdName.setEditable(false);
		tfdPwd.setEditable(false);
		tfdType.setEditable(false);
		tfdUuid.setEditable(false);

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		tfdName = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		tfdUuid = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		tfdPwd = new javax.swing.JTextField();
		tfdType = new javax.swing.JTextField();
		btnBack = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("΢���ź�", 1, 48));
		jLabel1.setForeground(new java.awt.Color(204, 0, 0));
		jLabel1.setText("\u5220\u9664\u7528\u6237");
		add(jLabel1);
		jLabel1.setBounds(260, 30, 230, 80);

		jLabel2.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel2.setText("\u7528\u6237\u7c7b\u578b:");
		add(jLabel2);
		jLabel2.setBounds(100, 310, 90, 30);

		tfdName.setFont(new java.awt.Font("Dialog", 1, 18));
		tfdName.setAutoscrolls(false);
		add(tfdName);
		tfdName.setBounds(480, 160, 120, 30);

		jLabel3.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel3.setText("uuid:");
		add(jLabel3);
		jLabel3.setBounds(130, 160, 50, 30);

		tfdUuid.setFont(new java.awt.Font("Dialog", 0, 11));
		add(tfdUuid);
		tfdUuid.setBounds(200, 160, 110, 30);

		jLabel4.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel4.setText("\u59d3\u540d:");
		add(jLabel4);
		jLabel4.setBounds(420, 160, 50, 30);

		jLabel5.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel5.setText("\u5bc6\u7801:");
		add(jLabel5);
		jLabel5.setBounds(130, 240, 50, 30);

		tfdPwd.setFont(new java.awt.Font("Tahoma", 1, 12));
		add(tfdPwd);
		tfdPwd.setBounds(200, 240, 160, 30);

		tfdType.setFont(new java.awt.Font("Dialog", 1, 12));
		add(tfdType);
		tfdType.setBounds(200, 310, 160, 30);

		btnBack.setFont(new java.awt.Font("Dialog", 1, 24));
		btnBack.setForeground(new java.awt.Color(0, 204, 204));
		btnBack.setText("\u8fd4\u56de");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});
		add(btnBack);
		btnBack.setBounds(540, 450, 120, 60);

		btnDelete.setFont(new java.awt.Font("Dialog", 1, 24));
		btnDelete.setForeground(new java.awt.Color(0, 204, 204));
		btnDelete.setText("\u5220\u9664");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});
		add(btnDelete);
		btnDelete.setBounds(210, 450, 120, 60);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		//3�����߼���
		if (UserEbiFactory.getUserEbi().delete(uuid)) {
			back();
		} else {
			JOptionPane.showMessageDialog(mainFrame, "���û��Ѿ�������!");
		}

		//4���ݵ��÷��ؽ������ͬҳ��

	}

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		back();
	}

	private void back() {
		mainFrame.setContentPane(new ListPanel(mainFrame));
		mainFrame.validate();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnDelete;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JTextField tfdName;
	private javax.swing.JTextField tfdPwd;
	private javax.swing.JTextField tfdType;
	private javax.swing.JTextField tfdUuid;
	// End of variables declaration//GEN-END:variables

}