package window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
	private JMenuBar menuBar1;

	private JMenu menu5;

	private JMenu menu6;

	private JMenuItem mi_book_add;

	private JMenuItem mi_book_update;

	private JMenuItem mi_book_delete;

	private JMenu menu7;

	private JMenuItem mi_reader_add;

	private JMenuItem mi_reader_update;

	private JMenuItem mi_reader_delete;

	private JMenu menu1;

	private JMenuItem mi_borrow;

	private JMenuItem mi_back;

	private JMenu menu2;

	private JMenuItem mi_query_book;

	private JMenuItem mi_query_reader;

	private JMenu menu3;

	private JMenuItem mi_update_pass;

	private JMenuItem mi_exit;

	public Main() {
		initComponents();
	}

	private void initComponents() {
		menuBar1 = new JMenuBar();
		menu5 = new JMenu(); // 基础维护菜单项
		menu6 = new JMenu(); // 图书维护菜单项
		mi_book_add = new JMenuItem(); // 添加图书菜单项
		mi_book_update = new JMenuItem(); // 修改图书菜单项
		mi_book_delete = new JMenuItem(); // 删除图书菜单项
		menu7 = new JMenu(); // 用户维护菜单项
		mi_reader_add = new JMenuItem(); // 添加读者菜单项
		mi_reader_update = new JMenuItem(); // 修改读者菜单项
		mi_reader_delete = new JMenuItem(); // 删除读者菜单项
		menu1 = new JMenu(); // 借阅管理菜单项
		mi_borrow = new JMenuItem(); // 借书管理菜单项
		mi_back = new JMenuItem(); // 还书管理菜单项
		menu2 = new JMenu(); // 查询管理菜单项
		mi_query_book = new JMenuItem(); // 图书查询菜单项
		mi_query_reader = new JMenuItem(); // 读者查询菜单项
		menu3 = new JMenu(); // 系统管理菜单项
		mi_update_pass = new JMenuItem(); // 修改密码菜单项
		mi_exit = new JMenuItem(); // 退出系统菜单项

		setTitle("书店管理系统");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		// 设置主菜单
		{
			// 设置基础维护菜单
			{
				menu5.setText("基础维护菜单");

				// 设置图书维护菜单
				{
					menu6.setText("图书维护");

					mi_book_add.setText("添加");
					mi_book_add.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_book_addActionPerformed(e);
						}
					});
					menu6.add(mi_book_add);

					mi_book_update.setText("修改");
					mi_book_update.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_book_updateActionPerformed(e);
						}
					});
					menu6.add(mi_book_update);

					mi_book_delete.setText("删除");
					mi_book_delete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_book_deleteActionPerformed(e);
						}
					});
					menu6.add(mi_book_delete);
				}
				menu5.add(menu6);

				// ======== menu7 ========
				{
					menu7.setText("用户维护");

					// ---- mi_reader_add ----
					mi_reader_add.setText("添加");
					mi_reader_add.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_reader_addActionPerformed(e);
						}
					});
					menu7.add(mi_reader_add);

					// ---- mi_reader_update ----
					mi_reader_update.setText("修改");
					mi_reader_update.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_reader_updateActionPerformed(e);
						}
					});
					menu7.add(mi_reader_update);

					// ---- mi_reader_delete ----
					mi_reader_delete.setText("删除");
					mi_reader_delete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_reader_deleteActionPerformed(e);
						}
					});
					menu7.add(mi_reader_delete);
				}
				menu5.add(menu7);
			}
			menuBar1.add(menu5);

			{
				menu1.setText("借还管理");

				mi_borrow.setText("借书");
				mi_borrow.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_borrowActionPerformed(e);
					}
				});
				menu1.add(mi_borrow);

				mi_back.setText("还书");
				mi_back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_backActionPerformed(e);
					}
				});
				menu1.add(mi_back);
			}
			menuBar1.add(menu1);

			{
				menu2.setText("查询管理");

				mi_query_book.setText("图书查询");
				mi_query_book.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_query_bookActionPerformed(e);
					}
				});
				menu2.add(mi_query_book);

				mi_query_reader.setText("用户查询");
				mi_query_reader.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_query_readerActionPerformed(e);
					}
				});
				menu2.add(mi_query_reader);
			}
			menuBar1.add(menu2);

			{
				menu3.setText("系统管理");

				mi_update_pass.setText("密码更改");
				mi_update_pass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_update_passActionPerformed(e);
					}
				});
				menu3.add(mi_update_pass);

				mi_exit.setText("退出系统");
				mi_exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_exitActionPerformed(e);
					}
				});
				menu3.add(mi_exit);
			}
			menuBar1.add(menu3);
		}
		setJMenuBar(menuBar1);
		setSize(500, 400);
		setLocationRelativeTo(getOwner());
		show();
	}

	private void mi_book_addActionPerformed(ActionEvent e) {
		new BookAdd();
	}

	private void mi_book_updateActionPerformed(ActionEvent e) {
		new BookUpdate();
	}

	private void mi_book_deleteActionPerformed(ActionEvent e) {
		new BookDelete();
	}

	private void mi_reader_addActionPerformed(ActionEvent e) {
		new ReaderAdd();
	}

	private void mi_reader_updateActionPerformed(ActionEvent e) {
		new ReaderUpdate();
	}

	private void mi_reader_deleteActionPerformed(ActionEvent e) {
		new ReaderDelete();
	}

	private void mi_borrowActionPerformed(ActionEvent e) {
		new Borrow();
	}

	private void mi_backActionPerformed(ActionEvent e) {
		new Back();
	}

	private void mi_query_bookActionPerformed(ActionEvent e) {
		new BookQuery();
	}

	private void mi_query_readerActionPerformed(ActionEvent e) {
		new ReaderQuery();
	}

	private void mi_update_passActionPerformed(ActionEvent e) {
		new UpdatePassword();
	}

	private void mi_exitActionPerformed(ActionEvent e) {
		dispose();
	}

	public void setPurView(byte purview) {
		switch (purview) {
		// 一般用户登录
		case 0:
			menu1.setEnabled(false);
			menu5.setEnabled(false);
			break;
		// 管理员登录
		case 1:
			break;
		default:
			break;
		}
	}

}
