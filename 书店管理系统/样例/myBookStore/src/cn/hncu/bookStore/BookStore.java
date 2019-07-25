/*
 * BookStore.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import cn.hncu.bookStore.book.ui.BookListPanel;
import cn.hncu.bookStore.in.ui.InListPanel;
import cn.hncu.bookStore.login.ui.LoginPanel;
import cn.hncu.bookStore.out.ui.OutListPanel;
import cn.hncu.bookStore.stock.ui.StockListPanel;
import cn.hncu.bookStore.user.ui.ListPanel;

/**
 * 
 * @author 陈浩翔
 * @version 1.0  2016-4-20
 */
public class BookStore extends javax.swing.JFrame {

	/** Creates new form BookStore */
	public BookStore() {
		super("书店管理系统---CHX---联系QQ——619699629");
		initComponents();
		this.setContentPane(new LoginPanel(this));
		this.setResizable(false);//不能缩放
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(scr.width / 5, scr.height / 5);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		openMenuItem = new javax.swing.JMenuItem();
		saveMenuItem = new javax.swing.JMenuItem();
		saveAsMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		editMenu = new javax.swing.JMenu();
		cutMenuItem = new javax.swing.JMenuItem();
		copyMenuItem = new javax.swing.JMenuItem();
		pasteMenuItem = new javax.swing.JMenuItem();
		deleteMenuItem = new javax.swing.JMenuItem();
		helpMenu = new javax.swing.JMenu();
		contentsMenuItem = new javax.swing.JMenuItem();
		aboutMenuItem = new javax.swing.JMenuItem();
		jMenu1 = new javax.swing.JMenu();
		jMenuItemUser = new javax.swing.JMenuItem();
		jMenuItemBook = new javax.swing.JMenuItem();
		jMenuItemIn = new javax.swing.JMenuItem();
		jMenuItemOut = new javax.swing.JMenuItem();
		jMenuItemStock = new javax.swing.JMenuItem();
		jMenuItem1 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(800, 600));
		getContentPane().setLayout(null);
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 0, 0);

		fileMenu.setText("File");

		openMenuItem.setText("Open");
		fileMenu.add(openMenuItem);

		saveMenuItem.setText("Save");
		fileMenu.add(saveMenuItem);

		saveAsMenuItem.setText("Save As ...");
		fileMenu.add(saveAsMenuItem);

		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		editMenu.setText("Edit");

		cutMenuItem.setText("Cut");
		editMenu.add(cutMenuItem);

		copyMenuItem.setText("Copy");
		editMenu.add(copyMenuItem);

		pasteMenuItem.setText("Paste");
		editMenu.add(pasteMenuItem);

		deleteMenuItem.setText("Delete");
		editMenu.add(deleteMenuItem);

		menuBar.add(editMenu);

		helpMenu.setText("Help");

		contentsMenuItem.setText("Contents");
		helpMenu.add(contentsMenuItem);

		aboutMenuItem.setText("About");
		helpMenu.add(aboutMenuItem);

		menuBar.add(helpMenu);

		jMenu1.setForeground(new java.awt.Color(204, 0, 0));
		jMenu1.setText("\u6a21\u5757");
		jMenu1.setFont(new java.awt.Font("Dialog", 1, 14));

		jMenuItemUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_U,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItemUser.setFont(new java.awt.Font("Dialog", 1, 14));
		jMenuItemUser.setForeground(new java.awt.Color(0, 204, 0));
		jMenuItemUser.setText("\u7528\u6237");
		jMenuItemUser.setEnabled(false);
		jMenuItemUser.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemUserActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItemUser);

		jMenuItemBook.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_B,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItemBook.setFont(new java.awt.Font("Dialog", 1, 14));
		jMenuItemBook.setForeground(new java.awt.Color(0, 204, 51));
		jMenuItemBook.setText("\u56fe\u4e66");
		jMenuItemBook.setEnabled(false);
		jMenuItemBook.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemBookActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItemBook);

		jMenuItemIn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_I,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItemIn.setFont(new java.awt.Font("Dialog", 1, 14));
		jMenuItemIn.setForeground(new java.awt.Color(0, 204, 0));
		jMenuItemIn.setText("\u8fdb\u8d27");
		jMenuItemIn.setEnabled(false);
		jMenuItemIn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemInActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItemIn);

		jMenuItemOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_O,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItemOut.setFont(new java.awt.Font("Dialog", 1, 14));
		jMenuItemOut.setForeground(new java.awt.Color(0, 204, 0));
		jMenuItemOut.setText("\u9500\u552e");
		jMenuItemOut.setEnabled(false);
		jMenuItemOut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemOutActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItemOut);

		jMenuItemStock.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItemStock.setFont(new java.awt.Font("Dialog", 1, 14));
		jMenuItemStock.setForeground(new java.awt.Color(0, 204, 0));
		jMenuItemStock.setText("\u5e93\u5b58");
		jMenuItemStock.setEnabled(false);
		jMenuItemStock.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemStockActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItemStock);

		jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_DELETE,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 14));
		jMenuItem1.setForeground(new java.awt.Color(0, 204, 0));
		jMenuItem1.setText("\u6ce8\u9500");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		menuBar.add(jMenu1);

		setJMenuBar(menuBar);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * 进入销售模块
	 * @param evt
	 */
	protected void jMenuItemOutActionPerformed(ActionEvent evt) {
		this.setContentPane(new OutListPanel(this));
		this.validate();
	}

	/**
	 * 进入库存模块
	 * @param evt
	 */
	protected void jMenuItemStockActionPerformed(ActionEvent evt) {
		this.setContentPane(new StockListPanel(this));
		this.validate();
	}

	/**
	 * 监听进入进货列表
	 * @param evt
	 */
	private void jMenuItemInActionPerformed(java.awt.event.ActionEvent evt) {
		this.setContentPane(new InListPanel(this));
		this.validate();
	}

	/**
	 * 注销菜单项
	 * @param evt
	 */
	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setContentPane(new LoginPanel(this));
		this.validate();
		jMenuItemUser.setEnabled(false);
		jMenuItemBook.setEnabled(false);
		jMenuItemIn.setEnabled(false);
		jMenuItemOut.setEnabled(false);
		jMenuItemStock.setEnabled(false);
	}

	/**
	 * 监听进入图书模块
	 * @param evt
	 */
	private void jMenuItemBookActionPerformed(java.awt.event.ActionEvent evt) {
		this.setContentPane(new BookListPanel(this));
		this.validate();
	}

	/**
	 * 监听进入用户模块
	 * @param evt
	 */
	private void jMenuItemUserActionPerformed(java.awt.event.ActionEvent evt) {
		this.setContentPane(new ListPanel(this));
		this.validate();

	}

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
		System.exit(0);
	}//GEN-LAST:event_exitMenuItemActionPerformed

	/**
	 * @param 主函数 args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BookStore().setVisible(true);
			}
		});
	}

	public javax.swing.JMenuItem getjMenuItemBook() {
		return jMenuItemBook;
	}

	public javax.swing.JMenuItem getjMenuItemIn() {
		return jMenuItemIn;
	}

	public javax.swing.JMenuItem getjMenuItemOut() {
		return jMenuItemOut;
	}

	public javax.swing.JMenuItem getjMenuItemStock() {
		return jMenuItemStock;
	}

	public javax.swing.JMenuItem getjMenuItemUser() {
		return jMenuItemUser;
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JMenuItem contentsMenuItem;
	private javax.swing.JMenuItem copyMenuItem;
	private javax.swing.JMenuItem cutMenuItem;
	private javax.swing.JMenuItem deleteMenuItem;
	private javax.swing.JMenu editMenu;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JMenu helpMenu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItemBook;
	private javax.swing.JMenuItem jMenuItemIn;
	private javax.swing.JMenuItem jMenuItemOut;
	private javax.swing.JMenuItem jMenuItemStock;
	private javax.swing.JMenuItem jMenuItemUser;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuItem openMenuItem;
	private javax.swing.JMenuItem pasteMenuItem;
	private javax.swing.JMenuItem saveAsMenuItem;
	private javax.swing.JMenuItem saveMenuItem;
	// End of variables declaration//GEN-END:variables

}