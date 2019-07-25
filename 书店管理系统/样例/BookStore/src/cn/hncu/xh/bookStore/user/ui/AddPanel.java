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
		jLabel4.setText("���ͣ�");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(239, 149, 66, 32));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("ȷ�����룺");
		txtpwd = new JLabel();
		txtpwd.setBounds(new Rectangle(30, 150, 46, 31));
		txtpwd.setHorizontalAlignment(SwingConstants.CENTER);
		txtpwd.setText("���룺");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(146, 88, 41, 31));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel2.setText("������");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(158, 14, 169, 38));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setText("��������");
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
			//��ö�ٶ����аѸ����û�������ӵ�����Ͽ�ؼ���
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
			btnAdd.setText("ȷ������");
			btnAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//�ռ�����
					String name=txtName.getText(); //��ȡ�������ڶ�Ӧ�Ŀؼ���
					//����ҪΪ�����£���֤������û�����Ϊ��
					if(name.trim().length()<=0){
						JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
						return;
					}
					String pwd=new String(txtPwd.getPassword()); //��ȡ���룬�ڶ�Ӧ�Ŀؼ���
					String pwd2=new String(txtPwd2.getPassword()); //��ȡȷ�����룬�ڶ�Ӧ�Ŀؼ���
					//��Ҫ�ж���������������Ƿ�һ��
					if(!pwd.equals(pwd2)){
						JOptionPane.showMessageDialog(null, "�����������벻�Ǻϣ�");
						return;
					}
					String selStr=cmbUser.getSelectedItem().toString(); //��ȡ����Ȩ�������ڶ�Ӧ�Ŀؼ���
					int type =UserTypeEnum.getTypeByName(selStr); //���ݹ���Ȩ������getTypeByNameͨ����ö�Ӧ�Ĺ���Ȩ������
					//��֯����
					UserModel user=new UserModel(); //newһ���յ�UserModel
					user.setName(name);//��user��������
					user.setPwd(pwd);//��user��������
					user.setType(type);//��user���ù���Ȩ������
					
					//�����߼���ebi
					UserEbi ebi=UserEbiFactory.getUserEbi();
					boolean success=ebi.create(user);
					//�����߼���ķ��ؽ����ѡ��ת����Ӧ�ý���
					if(success){
						JOptionPane.showMessageDialog(null, "��ӳɹ���");
						JPanleUtil.changePanel(jFrame, new ListPanel(jFrame));
					}else{
						JOptionPane.showMessageDialog(null, "���û����Ѵ��ڣ�");
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
			btnBack.setText("����");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new ListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

}  //  @jve:decl-index=0:visual-constraint="154,18"
