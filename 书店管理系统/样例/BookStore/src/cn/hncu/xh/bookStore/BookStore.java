package cn.hncu.xh.bookStore;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import cn.hncu.xh.bookStore.book.ui.BookListPanel;
import cn.hncu.xh.bookStore.in.ui.InListPanel;
import cn.hncu.xh.bookStore.login.ui.LoginPanel;
import cn.hncu.xh.bookStore.out.ui.OutListPanel;
import cn.hncu.xh.bookStore.stock.ui.StockListPanel;
import cn.hncu.xh.bookStore.user.ui.ListPanel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 *<p>Title:bookStore</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
public class BookStore {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="91,11"
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu editMenu = null;
	private JMenu helpMenu = null;
	private JMenuItem exitMenuItem = null;
	private JMenuItem aboutMenuItem = null;
	private JMenuItem cutMenuItem = null;
	private JMenuItem copyMenuItem = null;
	private JMenuItem pasteMenuItem = null;
	private JMenuItem saveMenuItem = null;
	private JDialog aboutDialog = null;
	private JPanel aboutContentPane = null;
	private JLabel aboutVersionLabel = null;
	
	private JMenu jMenuModel =null;
	private JMenuItem jMenuItemUser = null;
	private JMenuItem jMenuItemBook = null;
	private JMenuItem jMenuItemIn = null;
	private JMenuItem jMenuItemOut = null;
	private JMenuItem jMenuItemStock = null;
	private JMenuItem jMenuItemLogout = null;


	/**
	 * This method initializes jMenuModel1	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuModel() {
		if (jMenuModel == null) {
			jMenuModel = new JMenu();
			jMenuModel.setText("模块");
			jMenuModel.add(getJMenuItemUser());
			jMenuModel.add(getJMenuItemBook());
			jMenuModel.add(getJMenuItemIn());
			jMenuModel.add(getJMenuItemOut());
			jMenuModel.add(getJMenuItemStock());
			jMenuModel.add(jMenuItemLogout());
		}
		return jMenuModel;
	}


	/**
	 * This method initializes jMenuItemUser	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getJMenuItemUser() {
		if (jMenuItemUser == null) {
			jMenuItemUser = new JMenuItem();
			jMenuItemUser.setText("用户");
			jMenuItemUser.setEnabled(false);
			jMenuItemUser.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new ListPanel(jFrame));
				}
				
			});
		}
		return jMenuItemUser;
	}

	/**
	 * This method initializes jMenuItemBook	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getJMenuItemBook() {
		if (jMenuItemBook == null) {
			jMenuItemBook = new JMenuItem();
			jMenuItemBook.setText("图书");
			jMenuItemBook.setEnabled(false);
			jMenuItemBook.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new BookListPanel(jFrame));
				}
				
			});
		}
		return jMenuItemBook;
	}


	/**
	 * This method initializes jMenuItemIn	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getJMenuItemIn() {
		if (jMenuItemIn == null) {
			jMenuItemIn = new JMenuItem();
			jMenuItemIn.setText("进货");
			jMenuItemIn.setEnabled(false);
			jMenuItemIn.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new InListPanel(jFrame));
				}
				
			});
		}
		return jMenuItemIn;
	}

	/**
	 * This method initializes jMenuItemOut	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getJMenuItemOut() {
		if (jMenuItemOut == null) {
			jMenuItemOut = new JMenuItem();
			jMenuItemOut.setText("销售");
			jMenuItemOut.setEnabled(false);
			jMenuItemOut.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new OutListPanel(jFrame));
				}
			});
		}
		return jMenuItemOut;
	}


	/**
	 * This method initializes jMenuItemStock	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getJMenuItemStock() {
		if (jMenuItemStock == null) {
			jMenuItemStock = new JMenuItem();
			jMenuItemStock.setText("库存");
			jMenuItemStock.setEnabled(false);
			jMenuItemStock.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new StockListPanel(jFrame));
				}
			});
		}
		return jMenuItemStock;
	}


	/**
	 * This method initializes jMenuItemExit	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem jMenuItemLogout() {
		if (jMenuItemLogout == null) {
			jMenuItemLogout = new JMenuItem();
			jMenuItemLogout.setText("注销");
			jMenuItemLogout.setEnabled(true);
			jMenuItemLogout.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new LoginPanel(jFrame));
					getJMenuItemUser().setEnabled(false);
					getJMenuItemBook().setEnabled(false);
					getJMenuItemIn().setEnabled(false);
					getJMenuItemOut().setEnabled(false);
					getJMenuItemStock().setEnabled(false);
				}
			});
		}
		return jMenuItemLogout;
	}


	/**
	 * This method initializes listPanel	
	 * 	
	 * @return cn.hncu.xh.bookStore.user.ui.listPanel	
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BookStore application = new BookStore();
				application.getJFrame().setVisible(true);
			}
		});
	}

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    jFrame.setSize(500, 420);
		    jFrame.setLocation(new Point(200, 100));
			jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("Application");
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			jContentPane.add(new LoginPanel(jFrame,this));
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getEditMenu());
			jJMenuBar.add(getJMenuModel());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getEditMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			editMenu.setText("Edit");
			editMenu.add(getCutMenuItem());
			editMenu.add(getCopyMenuItem());
			editMenu.add(getPasteMenuItem());
		}
		return editMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Help");
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("About");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getAboutDialog();
					aboutDialog.pack();
					Point loc = getJFrame().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}

	/**
	 * This method initializes aboutDialog	
	 * 	
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(getJFrame(), true);
			aboutDialog.setTitle("About");
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	/**
	 * This method initializes aboutContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	/**
	 * This method initializes aboutVersionLabel	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getAboutVersionLabel() {
		if (aboutVersionLabel == null) {
			aboutVersionLabel = new JLabel();
			aboutVersionLabel.setText("Version 1.0");
			aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return aboutVersionLabel;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCutMenuItem() {
		if (cutMenuItem == null) {
			cutMenuItem = new JMenuItem();
			cutMenuItem.setText("Cut");
			cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					Event.CTRL_MASK, true));
		}
		return cutMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCopyMenuItem() {
		if (copyMenuItem == null) {
			copyMenuItem = new JMenuItem();
			copyMenuItem.setText("Copy");
			copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					Event.CTRL_MASK, true));
		}
		return copyMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getPasteMenuItem() {
		if (pasteMenuItem == null) {
			pasteMenuItem = new JMenuItem();
			pasteMenuItem.setText("Paste");
			pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
					Event.CTRL_MASK, true));
		}
		return pasteMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText("Save");
			saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
		}
		return saveMenuItem;
	}

}
