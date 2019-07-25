package cn.hncu.xh.bookStore.user.ui;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.user.business.ebi.UserEbi;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 * <p>
 * Title:listPanel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
public class ListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JList jList = null;
	private JFrame jFrame = null;
	private JButton jButton = null;
	private JScrollPane jScrollPane = null;

	private List<UserModel> list = null; // @jve:decl-index=0:
	private JButton btnDelete = null;
	private JButton btnUpdate = null;
	private JButton btnQuery = null;

	/**
	 * This is the default constructor
	 */
	public ListPanel(JFrame jf) {
		// �����߼��㣬��ԭ�е��û��ص�list����
		UserEbi ebi = UserEbiFactory.getUserEbi(); // ����ebi����
		list = ebi.getAll(); // �����ݿ����û�����list��
		this.jFrame = jf;
		initialize();
	}

	public ListPanel() {
		initialize();
	}

	public ListPanel(JFrame frame, List<UserModel> ret) {// רҵ��ʾ��ѯ���
		this.list = ret;
		this.jFrame = frame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(118, 5, 234, 27));
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setText("�û��б�");
		this.setLayout(null);
		this.setFont(new Font("Dialog", Font.PLAIN, 24));
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(getJButton(), null);

		this.add(getJScrollPane(), null);
		this.add(getBtnDelete(), null);
		this.add(getBtnUpdate(), null);
		this.add(getBtnQuery(), null);
	}

	/**
	 * This method initializes jList
	 * 
	 * @return javax.swing.JList
	 */
	@SuppressWarnings("unchecked")
	private JList getJList() {
		if (jList == null) {
			jList = new JList();
			if (jList != null) {
				jList.setListData(list.toArray()); // �Ѵ��߼������������list����
			}
		}
		return jList;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(15, 268, 90, 40));
			jButton.setText("����");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new AddPanel(jFrame)); // ת����Ӧ����������
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(112, 40, 251, 187));
			jScrollPane.setViewportView(getJList());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes btnDelete
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setBounds(new Rectangle(128, 268, 90, 40));
			btnDelete.setText("ɾ��");
			btnDelete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (!jList.isSelectionEmpty()) {
						JPanleUtil.changePanel(jFrame, new DeletePanel(jFrame,
								((UserModel) jList.getSelectedValue())
										.getUuid())); // ת����Ӧ��ɾ������
					}
				}
			});
		}
		return btnDelete;
	}

	/**
	 * This method initializes btnUpdate
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton();
			btnUpdate.setBounds(new Rectangle(253, 268, 90, 40));
			btnUpdate.setText("�޸�");
			btnUpdate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (!jList.isSelectionEmpty()) {
						JPanleUtil.changePanel(jFrame, new UpdatePanel(jFrame,
								((UserModel) jList.getSelectedValue())
										.getUuid()));// ת����Ӧ���޸Ľ���
					}
				}
			});
		}
		return btnUpdate;
	}

	/**
	 * This method initializes btnQuery
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton();
			btnQuery.setBounds(new Rectangle(376, 268, 90, 40));
			btnQuery.setText("��ѯ");
			btnQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new QueryPanel(jFrame));// ת����Ӧ�Ĳ�ѯ����
				}
			});
		}
		return btnQuery;
	}

} // @jve:decl-index=0:visual-constraint="113,36"
