package cn.hncu.xh.bookStore.user.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import cn.hncu.xh.bookStore.user.business.ebi.UserEbi;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.constance.UserTypeEnum;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;
import javax.swing.JComboBox;

/**
 * <p>
 * Title:Update
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
public class UpdatePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField updateUuid = null;
	private JLabel jLabel2 = null;
	private JTextField updateName = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JTextField updatePwd = null;
	private JLabel jLabel5 = null;
	private JTextField updatePwd2 = null;
	private JButton btnUpdate = null;
	private JButton updateBack = null;
	private JComboBox cmbType = null;
	
	private JFrame jFrame = null;
	private UserModel initUser=null;

	/**
	 * This is the default constructor
	 */
	public UpdatePanel() {
		initialize();
	}

	public UpdatePanel(JFrame jFrame, String uuid) {
		this.jFrame=jFrame;
		this.initUser=UserEbiFactory.getUserEbi().getSingle(uuid);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(267, 190, 67, 35));
		jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel5.setText("ȷ�����룺");
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(270, 137, 59, 32));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("���룺");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(43, 139, 63, 31));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("���ͣ�");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(271, 75, 60, 33));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("������");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(46, 76, 61, 32));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("uuid:");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(175, 14, 126, 35));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("�޸Ľ���");
		this.setSize(500, 370);
		this.setLayout(null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getUpdateUuid(), null);
		this.add(jLabel2, null);
		this.add(getUpdateName(), null);
		this.add(jLabel3, null);
		this.add(jLabel4, null);
		this.add(getUpdatePwd(), null);
		this.add(jLabel5, null);
		this.add(getUpdatePwd2(), null);
		this.add(getBtnUpdate(), null);
		this.add(getUpdateBack(), null);
		this.add(getCmbType(), null);
	}

	/**
	 * This method initializes updateUuid	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getUpdateUuid() {
		if (updateUuid == null) {
			updateUuid = new JTextField();
			updateUuid.setBounds(new Rectangle(120, 76, 107, 33));
			updateUuid.setEditable(false);
			updateUuid.setText(initUser.getUuid());
		}
		return updateUuid;
	}

	/**
	 * This method initializes updateName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getUpdateName() {
		if (updateName == null) {
			updateName = new JTextField();
			updateName.setBounds(new Rectangle(344, 74, 107, 33));
			updateName.setText(initUser.getName());
		}
		return updateName;
	}

	/**
	 * This method initializes updatePwd	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getUpdatePwd() {
		if (updatePwd == null) {
			updatePwd = new JTextField();
			updatePwd.setBounds(new Rectangle(343, 137, 112, 34));
			updatePwd.setText(initUser.getPwd());
		}
		return updatePwd;
	}

	/**
	 * This method initializes updatePwd2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getUpdatePwd2() {
		if (updatePwd2 == null) {
			updatePwd2 = new JTextField();
			updatePwd2.setBounds(new Rectangle(344, 188, 114, 33));
			updatePwd2.setText(initUser.getPwd());
		}
		return updatePwd2;
	}

	/**
	 * This method initializes btnUpdate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton();
			btnUpdate.setBounds(new Rectangle(45, 255, 107, 41));
			btnUpdate.setText("ȷ���޸�");
			btnUpdate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//�ռ�����
					String uuid=updateUuid.getText(); //��ȡ��ţ��ڶ�Ӧ�Ŀؼ���
					String name=updateName.getText(); //��ȡ�������ڶ�Ӧ�Ŀؼ���
					//����ҪΪ�����£���֤������û�����Ϊ��
					if(name.trim().length()<=0){
						JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
						return;
					}
					String pwd=updatePwd.getText(); //��ȡ���룬�ڶ�Ӧ�Ŀؼ���
					String pwd2=updatePwd2.getText(); //��ȡȷ�����룬�ڶ�Ӧ�Ŀؼ���
					//��Ҫ�ж���������������Ƿ�һ��
					if(!pwd.equals(pwd2)){
						JOptionPane.showMessageDialog(null, "�����������벻�Ǻϣ�");
						return;
					}
					String selStr=cmbType.getSelectedItem().toString(); //��ȡ����Ȩ�������ڶ�Ӧ�Ŀؼ���
					int type =UserTypeEnum.getTypeByName(selStr); //���ݹ���Ȩ������getTypeByNameͨ����ö�Ӧ�Ĺ���Ȩ������
					//��֯����
					UserModel user=new UserModel(); //newһ���յ�UserModel
					user.setUuid(uuid);//��user���ñ��
					user.setName(name);//��user��������
					user.setPwd(pwd);//��user��������
					user.setType(type);//��user���ù���Ȩ������
					
					//�����߼���ebi
					UserEbi ebi=UserEbiFactory.getUserEbi();
					boolean success=ebi.update(user);
					//�����߼���ķ��ؽ����ѡ��ת����Ӧ�ý���
					if(success){
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
						JPanleUtil.changePanel(jFrame, new ListPanel(jFrame));
					}else{
						JOptionPane.showMessageDialog(null, "���û��������ڣ�");
					}
				}
			});
		}
		return btnUpdate;
	}

	/**
	 * This method initializes updateBack	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getUpdateBack() {
		if (updateBack == null) {
			updateBack = new JButton();
			updateBack.setBounds(new Rectangle(314, 252, 104, 42));
			updateBack.setText("����");
			updateBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new ListPanel(jFrame));
				}
			});
		}
		return updateBack;
	}

	/**
	 * This method initializes cmbType	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbType() {
		if (cmbType == null) {
			cmbType = new JComboBox();
			cmbType.setBounds(new Rectangle(118, 138, 136, 34));
			for(UserTypeEnum type:UserTypeEnum.values()){
				cmbType.addItem(type.getName());
				if(type.getType()==initUser.getType()){
					cmbType.setSelectedItem(type.getName());
				}
			}
		}
		return cmbType;
	}

} // @jve:decl-index=0:visual-constraint="127,0"
