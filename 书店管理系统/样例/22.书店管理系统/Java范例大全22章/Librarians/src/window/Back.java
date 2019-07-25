package window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.DateUtils;
import data.BaseDao;
import data.BookDao;
import data.ReaderDao;
import entity.Book;
import entity.Reader;

public class Back extends JFrame {
	private JPanel dialogPane;

	private JPanel contentPanel;

	private JLabel lb_book_id;

	private JTextField tf_book_id;

	private JLabel lb_reader_id;

	private JTextField tf_reader_id;

	private JLabel lb_book_name;

	private JTextField tf_book_name;

	private JLabel lb_reader_name;

	private JTextField tf_reader_name;

	private JLabel lb_book_publisher;

	private JTextField tf_book_publisher;

	private JLabel lb_reader_type;

	private JTextField tf_reader_type;

	private JLabel lb_book_publish_time;

	private JTextField tf_book_publish_time;

	private JLabel lb_reader_sex;

	private JTextField tf_reader_sex;

	private JLabel lb_borrow;

	private JLabel lb_borrow_date;

	private JLabel lb_back;

	private JLabel lb_back_date;

	private JPanel buttonBar;

	private JButton btn_back;

	private JButton btn_close;

	public Back() {
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		lb_book_id = new JLabel();
		tf_book_id = new JTextField();
		lb_reader_id = new JLabel();
		tf_reader_id = new JTextField();
		lb_book_name = new JLabel();
		tf_book_name = new JTextField();
		lb_reader_name = new JLabel();
		tf_reader_name = new JTextField();
		lb_book_publisher = new JLabel();
		tf_book_publisher = new JTextField();
		lb_reader_type = new JLabel();
		tf_reader_type = new JTextField();
		lb_book_publish_time = new JLabel();
		tf_book_publish_time = new JTextField();
		lb_reader_sex = new JLabel();
		tf_reader_sex = new JTextField();
		lb_borrow = new JLabel();
		lb_borrow_date = new JLabel();
		lb_back = new JLabel();
		lb_back_date = new JLabel();
		buttonBar = new JPanel();
		btn_back = new JButton();
		btn_close = new JButton();

		setTitle("还书");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			{
				contentPanel.setLayout(new GridLayout(5, 4, 6, 6));

				lb_book_id.setText("图书编号：");
				lb_book_id.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_book_id);

				tf_book_id.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						tf_book_idKeyTyped(e);
					}
				});
				contentPanel.add(tf_book_id);

				lb_reader_id.setText("用户编号：");
				lb_reader_id.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_reader_id);

				tf_reader_id.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						tf_reader_idKeyTyped(e);
					}
				});
				contentPanel.add(tf_reader_id);

				lb_book_name.setText("图书名称：");
				lb_book_name.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_book_name);

				tf_book_name.setEnabled(false);
				contentPanel.add(tf_book_name);

				lb_reader_name.setText("用户姓名：");
				lb_reader_name.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_reader_name);

				tf_reader_name.setEnabled(false);
				contentPanel.add(tf_reader_name);

				lb_book_publisher.setText("出版社：");
				lb_book_publisher.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_book_publisher);

				tf_book_publisher.setEnabled(false);
				contentPanel.add(tf_book_publisher);

				lb_reader_type.setText("用户类别：");
				lb_reader_type.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_reader_type);

				tf_reader_type.setEnabled(false);
				contentPanel.add(tf_reader_type);

				lb_book_publish_time.setText("出版时间：");
				lb_book_publish_time
						.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_book_publish_time);

				tf_book_publish_time.setEnabled(false);
				contentPanel.add(tf_book_publish_time);

				lb_reader_sex.setText("性别：");
				lb_reader_sex.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_reader_sex);

				tf_reader_sex.setEnabled(false);
				contentPanel.add(tf_reader_sex);

				lb_borrow.setText("借书时间：");
				lb_borrow.setHorizontalAlignment(SwingConstants.RIGHT);
				lb_borrow.setForeground(SystemColor.blue);
				contentPanel.add(lb_borrow);

				lb_borrow_date.setHorizontalAlignment(SwingConstants.CENTER);
				lb_borrow_date.setForeground(SystemColor.desktop);
				contentPanel.add(lb_borrow_date);

				lb_back.setText("还书时间：");
				lb_back.setHorizontalAlignment(SwingConstants.RIGHT);
				lb_back.setForeground(SystemColor.blue);
				contentPanel.add(lb_back);

				lb_back_date.setHorizontalAlignment(SwingConstants.CENTER);
				lb_back_date.setForeground(SystemColor.desktop);
				contentPanel.add(lb_back_date);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[] {
						0, 85, 80 };
				((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[] {
						1.0, 0.0, 0.0 };

				btn_back.setText("确定");
				btn_back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_backActionPerformed(e);
					}
				});
				buttonBar.add(btn_back, new GridBagConstraints(1, 0, 1, 1, 0.0,
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
		setSize(625, 260);
		setLocationRelativeTo(getOwner());
		show();
	}

	private void tf_book_idKeyTyped(KeyEvent e) {
		// 响应回车键
		if (e.getKeyChar() == '\n') {
			String id = tf_book_id.getText(); // 获取图书编号
			Book book = BookDao.selectBook(id); // 提取指定编号的图书信息

			// 在界面上显示图书信息
			if (book != null) {
				tf_book_name.setText(book.getName());
				tf_book_publisher.setText(book.getPublisher());
				tf_book_publish_time.setText(book.getPublish_time().toString());
			}
		}
	}

	private void tf_reader_idKeyTyped(KeyEvent e) {
		// 响应回车键
		if (e.getKeyChar() == '\n') {
			String id = tf_reader_id.getText(); // 获取读者编号
			Reader reader = ReaderDao.selectReader(id); // 提取指定编号的读者信息

			// 在界面上显示读者信息
			if (reader != null) {
				tf_reader_name.setText(reader.getName());
				tf_reader_type.setText(reader.getType());
				tf_reader_sex.setText(reader.getSex());

				// 设置借书日期、还书日期
				int days = reader.getDays_num();
				String today = DateUtils.getDate();
				lb_borrow_date.setText(today);
				lb_back_date.setText(DateUtils.getAfterDay(today, days));
			}
		}
	}

	private void btn_backActionPerformed(ActionEvent e) {
		String book_id = tf_book_id.getText(); // 获取图书编号
		String reader_id = tf_reader_id.getText(); // 删除指定编号的图书

		// 拼sql语句
		String sql = "update borrow set is_back=1 where book_id='" + book_id
				+ "' and reader_id='" + reader_id + "'";

		// 执行数据库操作
		int i = BaseDao.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "还书成功");
			dispose();
		}
	}

	private void btn_closeActionPerformed(ActionEvent e) {
		dispose();
	}

}
