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

import util.Constant;
import data.BaseDao;

public class ReaderAdd extends JFrame {
	private JPanel dialogPane;

	private JPanel contentPanel;

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

	private JButton btn_save;

	private JButton btn_close;

	public ReaderAdd() {
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		lb_id = new JLabel();
		tf_id = new JTextField();
		lb_name = new JLabel();
		tf_name = new JTextField();
		lb_type = new JLabel();
		cb_type = new JComboBox(Constant.READER_TYPES);
		lb_sex = new JLabel();
		cb_sex = new JComboBox(Constant.SEX);
		lb_max_num = new JLabel();
		tf_max_num = new JTextField("3");
		lb_dars = new JLabel();
		tf_days = new JTextField("60");
		buttonBar = new JPanel();
		btn_save = new JButton();
		btn_close = new JButton();

		setTitle("添加新用户");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			{
				contentPanel.setLayout(new GridLayout(3, 4, 6, 6));

				lb_id.setText("用户编号：");
				lb_id.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_id);
				contentPanel.add(tf_id);

				lb_name.setText("用户姓名：");
				lb_name.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_name);
				contentPanel.add(tf_name);

				lb_type.setText("用户级别:");
				lb_type.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_type);
				contentPanel.add(cb_type);

				lb_sex.setText("性别：");
				lb_sex.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_sex);
				contentPanel.add(cb_sex);

				lb_max_num.setText("可借数量：");
				lb_max_num.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_max_num);
				contentPanel.add(tf_max_num);

				lb_dars.setText("可借天数：");
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

				btn_save.setText("保存");
				btn_save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_saveActionPerformed(e);
					}
				});
				buttonBar.add(btn_save, new GridBagConstraints(1, 0, 1, 1, 0.0,
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
		setSize(450, 175);
		setLocationRelativeTo(getOwner());
		show();
	}

	private void btn_saveActionPerformed(ActionEvent e) {
		// 获取用户输入信息
		String id = tf_id.getText();
		String name = tf_name.getText();
		String type = cb_type.getSelectedItem().toString();
		String sex = cb_sex.getSelectedItem().toString();
		String max_num = tf_max_num.getText();
		String days = tf_days.getText();

		// 拼接sql
		String sql = "insert into reader(id,name,type,sex,max_num,days_num) values('"
				+ id
				+ "','"
				+ name
				+ "','"
				+ type
				+ "','"
				+ sex
				+ "',"
				+ max_num + "," + days + ")";

		// 执行数据库操作
		int i = BaseDao.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "添加成功");
			dispose();
		}
	}

	private void btn_closeActionPerformed(ActionEvent e) {
		dispose();
	}

}
