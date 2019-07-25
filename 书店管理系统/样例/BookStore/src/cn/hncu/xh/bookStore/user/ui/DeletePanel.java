package cn.hncu.xh.bookStore.user.ui;

import javax.swing.JPanel;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import cn.hncu.xh.bookStore.user.business.ebi.UserEbi;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.constance.UserTypeEnum;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 * <p>
 * Title:DeletePanel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
public class DeletePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField deleteUuid = null;
	private JLabel jLabel2 = null;
	private JTextField deleteName = null;
	private JLabel jLabel3 = null;
	private JTextField userType = null;
	private JLabel jLabel4 = null;
	private JTextField deletePwd = null;
	private JButton btnDelete = null;
	private JButton btnBack = null;

	private JFrame jFrame = null;
	private UserModel user = null;

	/**
	 * This is the default constructor
	 */
	public DeletePanel() {
		initialize();
	}

	public DeletePanel(JFrame jFrame, String uuid) {
		this.user = UserEbiFactory.getUserEbi().getSingle(uuid);
		this.jFrame = jFrame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(254, 151, 64, 32));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("密码：");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(43, 148, 60, 33));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("类型：");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(254, 77, 62, 32));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("姓名：");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(42, 72, 62, 32));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("uuid：");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(194, 14, 100, 34));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setText("删除界面");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getDeleteUuid(), null);
		this.add(jLabel2, null);
		this.add(getDeleteName(), null);
		this.add(jLabel3, null);
		this.add(getUserType(), null);
		this.add(jLabel4, null);
		this.add(getDeletePwd(), null);
		this.add(getBtnDelete(), null);
		this.add(getBtnBack(), null);
	}

	/**
	 * This method initializes deleteUuid
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getDeleteUuid() {
		if (deleteUuid == null) {
			deleteUuid = new JTextField();
			deleteUuid.setBounds(new Rectangle(123, 75, 91, 33));
			deleteUuid.setEditable(false);
			deleteUuid.setText(user.getUuid());
		}
		return deleteUuid;
	}

	/**
	 * This method initializes deleteName
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getDeleteName() {
		if (deleteName == null) {
			deleteName = new JTextField();
			deleteName.setBounds(new Rectangle(332, 77, 105, 32));
			deleteName.setEditable(false);
			deleteName.setText(user.getName());
		}
		return deleteName;
	}

	/**
	 * This method initializes userType
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getUserType() {
		if (userType == null) {
			userType = new JTextField();
			userType.setBounds(new Rectangle(127, 148, 92, 34));
			userType.setEditable(false);
			userType.setText(UserTypeEnum.getNameByType(user.getType()));
		}
		return userType;
	}

	/**
	 * This method initializes deletePwd
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getDeletePwd() {
		if (deletePwd == null) {
			deletePwd = new JTextField();
			deletePwd.setBounds(new Rectangle(336, 150, 106, 34));
			deletePwd.setEditable(false);
			deletePwd.setText(user.getPwd());
		}
		return deletePwd;
	}

	/**
	 * This method initializes btnDelete
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setBounds(new Rectangle(62, 240, 92, 41));
			btnDelete.setText("确认删除");
			btnDelete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					UserEbi ebi=UserEbiFactory.getUserEbi();
					boolean success=ebi.delete(user.getUuid());
					if(success){
						JOptionPane.showMessageDialog(null, "删除成功！");
						JPanleUtil.changePanel(jFrame, new ListPanel(jFrame));
					}else{
						JOptionPane.showMessageDialog(null, "删除用户不存在！");
					}
				}
			});
		}
		return btnDelete;
	}

	/**
	 * This method initializes btnBack
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setBounds(new Rectangle(324, 238, 95, 42));
			btnBack.setText("返回");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new ListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

} // @jve:decl-index=0:visual-constraint="118,-1"
