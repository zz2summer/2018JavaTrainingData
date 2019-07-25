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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import data.BaseDao;
import data.ReaderDao;
import entity.Reader;

public class ReaderDelete extends JFrame {
	private JPanel dialogPane;

	private JPanel contentPanel;

	private JLabel label1;

	private JTextField tf_cx_id;

	private JButton button1;

	private JTextField textField2;

	private JLabel lb_id;

	private JTextField tf_id;

	private JLabel lb_name;

	private JTextField tf_name;

	private JLabel lb_type;

	private JComboBox cb_type;

	private JLabel lb_sex;

	private JComboBox cb_sex;

	private JLabel lb_max_num;

	private JTextField tf_max_num;

	private JLabel lb_dars;

	private JTextField tf_days;

	private JPanel buttonBar;

	private JButton btn_del;

	private JButton btn_close;

	public ReaderDelete() {
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		label1 = new JLabel();
		tf_cx_id = new JTextField();
		button1 = new JButton();
		textField2 = new JTextField();
		lb_id = new JLabel();
		tf_id = new JTextField();
		lb_name = new JLabel();
		tf_name = new JTextField();
		lb_type = new JLabel();
		cb_type = new JComboBox();
		lb_sex = new JLabel();
		cb_sex = new JComboBox();
		lb_max_num = new JLabel();
		tf_max_num = new JTextField();
		lb_dars = new JLabel();
		tf_days = new JTextField();
		buttonBar = new JPanel();
		btn_del = new JButton();
		btn_close = new JButton();

		setTitle("删除用户信息");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			{
				contentPanel.setLayout(new GridLayout(4, 4, 6, 6));

				label1.setText("用户编号：");
				label1.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(label1);
				contentPanel.add(tf_cx_id);

				button1.setText("查询");
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						button1ActionPerformed(e);
					}
				});
				contentPanel.add(button1);

				textField2.setVisible(false);
				contentPanel.add(textField2);

				lb_id.setText("用户编号：");
				lb_id.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_id);
				contentPanel.add(tf_id);

				lb_name.setText("用户姓名：");
				lb_name.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_name);
				contentPanel.add(tf_name);

				lb_type.setText("用户类型:");
				lb_type.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_type);
				contentPanel.add(cb_type);

				lb_sex.setText("性别：");
				lb_sex.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_sex);
				contentPanel.add(cb_sex);

				lb_max_num.setText("可借数量");
				lb_max_num.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_max_num);
				contentPanel.add(tf_max_num);

				lb_dars.setText("可借天数");
				lb_dars.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_dars);
				contentPanel.add(tf_days);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[] {
						0, 85, 80 };
				((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[] {
						1.0, 0.0, 0.0 };

				btn_del.setText("删除");
				btn_del.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_saveActionPerformed(e);
					}
				});
				buttonBar.add(btn_del, new GridBagConstraints(1, 0, 1, 1, 0.0,
						0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));

				btn_close.setText("关闭");
				btn_close.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_closeActionPerformed(e);
					}
				});
				buttonBar.add(btn_close, new GridBagConstraints(2, 0, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize(450, 200);
		setLocationRelativeTo(getOwner());
		show();
	}

	private void button1ActionPerformed(ActionEvent e) {
		String id = tf_cx_id.getText();
		Reader reader = ReaderDao.selectReader(id);

		if (reader != null) {
			tf_id.setText(reader.getId());
			tf_name.setText(reader.getName());
			cb_type.setSelectedItem(reader.getType());
			cb_sex.setSelectedItem(reader.getSex());
			tf_max_num.setText(reader.getMax_num());
			tf_days.setText(String.valueOf(reader.getDays_num()));
		}
	}

	private void btn_saveActionPerformed(ActionEvent e) {
		String id = tf_id.getText(); // 获取图书编号
		String sql = "delete from reader  where id='" + id + "'"; // 删除指定编号的图书

		// 执行数据库操作
		int i = BaseDao.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "删除成功");
			dispose();
		}
	}

	private void btn_closeActionPerformed(ActionEvent e) {
		dispose();
	}
}
