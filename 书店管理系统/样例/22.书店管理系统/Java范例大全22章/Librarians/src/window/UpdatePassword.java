package window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.GlobalVar;
import data.BaseDao;

public class UpdatePassword extends JFrame {
	public UpdatePassword() {
		initComponents();
	}

	public static void main(String[] args) {
		new UpdatePassword();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		label2 = new JLabel();
		tf_pass1 = new JPasswordField();
		label1 = new JLabel();
		tf_pass2 = new JPasswordField();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		setResizable(false);
		setTitle("�޸�����");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			{
				contentPanel.setLayout(new GridLayout(2, 2));

				label2.setText("�����������룺");
				label2.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(label2);
				contentPanel.add(tf_pass1);

				label1.setText("���ٴ����������룺");
				label1.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(label1);
				contentPanel.add(tf_pass2);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[] {
						0, 85, 80 };
				((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[] {
						1.0, 0.0, 0.0 };

				okButton.setText("ȷ��");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButtonActionPerformed(e);
					}
				});
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0,
						0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));

				cancelButton.setText("ȡ��");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelButtonActionPerformed(e);
					}
				});
				buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize(350, 155);
		setLocationRelativeTo(getOwner());
		show();
	}

	private JPanel dialogPane;

	private JPanel contentPanel;

	private JLabel label2;

	private JPasswordField tf_pass1;

	private JLabel label1;

	private JPasswordField tf_pass2;

	private JPanel buttonBar;

	private JButton okButton;

	private JButton cancelButton;

	private void okButtonActionPerformed(ActionEvent e) {
		String pass1 = tf_pass1.getText(); // ��ȡ��һ����������
		String pass2 = tf_pass2.getText(); // ��ȡ�ڶ�����������

		// �����������벻һ��
		if (!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(this, "�������벻һ�£����������룡");
			tf_pass1.setText("");
			tf_pass2.setText("");
			return;
		}

		// ִ�����ݿ��������������
		String sql = "update user set pass='" + pass1 + "' where name='"
				+ GlobalVar.login_user + "'";
		int i = BaseDao.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "�����޸ĳɹ�");
			dispose();
		}
	}

	private void cancelButtonActionPerformed(ActionEvent e) {
		dispose();
	}
}
