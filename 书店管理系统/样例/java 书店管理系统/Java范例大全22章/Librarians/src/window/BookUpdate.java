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
import data.BookDao;
import entity.Book;

public class BookUpdate extends JFrame {
	private JPanel dialogPane;

	private JPanel contentPanel;

	private JLabel lb_cx_id;

	private JTextField tf_cx_id;

	private JButton btn_query;

	private JLabel label12;

	private JLabel lb_id;

	private JTextField tf_id;

	private JLabel lb_name;

	private JTextField tf_name;

	private JLabel lb_type;

	private JComboBox cb_type;

	private JLabel lb_author;

	private JTextField tf_author;

	private JLabel lb_translator;

	private JTextField tf_translator;

	private JLabel lb_publisher;

	private JTextField tf_publisher;

	private JLabel lb_publish_time;

	private JTextField tf_publish_time;

	private JLabel lb_price;

	private JTextField tf_price;

	private JLabel lb_stock;

	private JTextField tf_stock;

	private JPanel buttonBar;

	private JButton btn_save;

	private JButton btn_close;

	public BookUpdate() {
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		lb_cx_id = new JLabel();
		tf_cx_id = new JTextField();
		btn_query = new JButton();
		label12 = new JLabel();
		lb_id = new JLabel();
		tf_id = new JTextField();
		lb_name = new JLabel();
		tf_name = new JTextField();
		lb_type = new JLabel();
		cb_type = new JComboBox(Constant.BOOK_TYPES);
		lb_author = new JLabel();
		tf_author = new JTextField();
		lb_translator = new JLabel();
		tf_translator = new JTextField();
		lb_publisher = new JLabel();
		tf_publisher = new JTextField();
		lb_publish_time = new JLabel();
		tf_publish_time = new JTextField();
		lb_price = new JLabel();
		tf_price = new JTextField();
		lb_stock = new JLabel();
		tf_stock = new JTextField();
		buttonBar = new JPanel();
		btn_save = new JButton();
		btn_close = new JButton();

		setTitle("修改图书信息");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			{
				contentPanel.setLayout(new GridLayout(6, 4, 6, 6));

				lb_cx_id.setText("图书编号：");
				lb_cx_id.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_cx_id);
				contentPanel.add(tf_cx_id);

				btn_query.setText("查询");
				btn_query.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_queryActionPerformed(e);
					}
				});
				contentPanel.add(btn_query);

				label12.setText("text");
				label12.setVisible(false);
				contentPanel.add(label12);

				lb_id.setText("图书编号：");
				lb_id.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_id);

				tf_id.setEditable(false);
				contentPanel.add(tf_id);

				lb_name.setText("图书名称：");
				lb_name.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_name);
				contentPanel.add(tf_name);

				lb_type.setText("图书类别：");
				lb_type.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_type);
				contentPanel.add(cb_type);

				lb_author.setText("作者：");
				lb_author.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_author);
				contentPanel.add(tf_author);

				lb_translator.setText("译者：");
				lb_translator.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_translator);
				contentPanel.add(tf_translator);

				lb_publisher.setText("出版社：");
				lb_publisher.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_publisher);
				contentPanel.add(tf_publisher);

				lb_publish_time.setText("出版时间：");
				lb_publish_time.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_publish_time);
				contentPanel.add(tf_publish_time);

				lb_price.setText("价格：");
				lb_price.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_price);
				contentPanel.add(tf_price);

				lb_stock.setText("库存数量：");
				lb_stock.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_stock);
				contentPanel.add(tf_stock);
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
		setSize(625, 260);
		setLocationRelativeTo(getOwner());
		show();
	}

	private void btn_saveActionPerformed(ActionEvent e) {
		// 获取用户输入信息
		String id = tf_id.getText();
		String name = tf_name.getText();
		String type = cb_type.getSelectedItem().toString();
		String author = tf_author.getText();
		String translator = tf_translator.getText();
		String publisher = tf_publisher.getText();
		String publish_time = tf_publish_time.getText();
		String price = tf_price.getText();
		String stock = tf_stock.getText();

		// 拼接sql
		String sql = "update book set name='" + name + "',type='" + type
				+ "',author='" + author + "',translator='" + translator
				+ "',publisher='" + publisher + "',publish_time='"
				+ java.sql.Date.valueOf(publish_time) + "',price="
				+ Double.parseDouble(price) + ",stock=" + stock + " where id='"
				+ id + "'";

		// 执行数据库操作
		int i = BaseDao.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "修改成功");
			dispose();
		}
	}

	private void btn_queryActionPerformed(ActionEvent e) {
		String id = tf_cx_id.getText(); // 图书编号
		Book book = BookDao.selectBook(id); // 根据编号查询图书信息

		// 设置图书信息
		if (book != null) {
			tf_id.setText(book.getId());
			tf_name.setText(book.getName());
			cb_type.setSelectedItem(book.getType());
			tf_author.setText(book.getAuthor());
			tf_translator.setText(book.getTranslator());
			tf_publisher.setText(book.getPublisher());
			tf_publish_time.setText(book.getPublish_time().toString());
			tf_price.setText(String.valueOf(book.getPrice()));
			tf_stock.setText(String.valueOf(book.getStock()));
		}
	}

	private void btn_closeActionPerformed(ActionEvent e) {
		dispose();
	}

}
