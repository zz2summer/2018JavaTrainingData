package cn.hncu.xh.bookStore.user.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import cn.hncu.xh.bookStore.user.business.ebi.UserEbi;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.constance.UserTypeEnum;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.user.vo.UserQueryModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 * <p>
 * Title:SreachPanel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
public class QueryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;

	private JFrame jFrame = null;
	private JLabel jLabel1 = null;
	private JTextField txtUuid = null;
	private JLabel jLabel2 = null;
	private JTextField txtName = null;
	private JLabel jLabel3 = null;
	private JComboBox cmbType = null;
	private JButton QueryBtn = null;
	private JButton backBtn = null;

	/**
	 * This is the default constructor
	 */
	public QueryPanel() {
		initialize();
	}

	public QueryPanel(JFrame jFrame) {
		this.jFrame = jFrame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(28, 148, 71, 33));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("�û����ͣ�");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(256, 76, 59, 34));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("������");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(31, 77, 70, 29));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("uuid:");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(164, 15, 137, 34));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("��ѯ����");
		this.setSize(500, 370);
		this.setLayout(null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getTxtUuid(), null);
		this.add(jLabel2, null);
		this.add(getTxtName(), null);
		this.add(jLabel3, null);
		this.add(getCmbType(), null);
		this.add(getQueryBtn(), null);
		this.add(getBackBtn(), null);
	}

	/**
	 * This method initializes txtUuid
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtUuid() {
		if (txtUuid == null) {
			txtUuid = new JTextField();
			txtUuid.setBounds(new Rectangle(120, 75, 108, 32));
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
			txtName.setBounds(new Rectangle(335, 76, 102, 32));
		}
		return txtName;
	}

	/**
	 * This method initializes cmbType
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbType() {
		if (cmbType == null) {
			cmbType = new JComboBox();
			cmbType.setBounds(new Rectangle(120, 149, 121, 33));
			// ��ö�ٶ����аѸ����û�������ӵ�����Ͽ�ؼ���
			cmbType.addItem("��ѡ��...");// �൱�ڸ���type��Ĭ��ֵ�������ʱ��ͨ����һ���Ǳ���ģ���Ϊ�û���ѡʱĬ��ѡ�е�һ��
			for (UserTypeEnum type : UserTypeEnum.values()) {
				cmbType.addItem(type.getName());
			}
		}
		return cmbType;
	}

	/**
	 * This method initializes QueryBtn
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getQueryBtn() {
		if (QueryBtn == null) {
			QueryBtn = new JButton();
			QueryBtn.setBounds(new Rectangle(86, 238, 90, 40));
			QueryBtn.setText("��ѯ");
			QueryBtn.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// �ռ�����
					String uuid = txtUuid.getText(); // ��ȡ��ţ��ڶ�Ӧ�Ŀؼ���
					String name = txtName.getText(); // ��ȡ�������ڶ�Ӧ�Ŀؼ���
					// �û�����
					int type = 0;
					if (cmbType.getSelectedIndex() > 0) {
						String selStr = cmbType.getSelectedItem().toString(); // ��ȡ����Ȩ�������ڶ�Ӧ�Ŀؼ���
						type=UserTypeEnum.getTypeByName(selStr); // ���ݹ���Ȩ������getTypeByNameͨ����ö�Ӧ�Ĺ���Ȩ������
					}
					// ��֯����(��װ��ѯ������ֵ����)
					UserQueryModel uqm = new UserQueryModel(); // newһ���յ�UserModel
					uqm.setUuid(uuid);// ��user���ñ��
					uqm.setName(name);// ��user��������
					uqm.setType(type);// ��user���ù���Ȩ������

					// �����߼���ebi
					UserEbi ebi = UserEbiFactory.getUserEbi();
					List<UserModel> ret = ebi.getBycondition(uqm);
					// �����߼���ķ��ؽ����ѡ��ת����Ӧ�ý���
						JPanleUtil.changePanel(jFrame, new ListPanel(jFrame,ret));
				}
			});
		}
		return QueryBtn;
	}

	/**
	 * This method initializes backBtn
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBackBtn() {
		if (backBtn == null) {
			backBtn = new JButton();
			backBtn.setBounds(new Rectangle(285, 238, 90, 40));
			backBtn.setText("����");
			backBtn.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new ListPanel(jFrame));
				}
			});
		}
		return backBtn;
	}

} // @jve:decl-index=0:visual-constraint="101,1"
