package cn.hncu.xh.bookStore.book.ui;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 *<p>Title:BookDeletePanel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
public class BookDeletePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField txtUuid = null;
	private JLabel jLabel2 = null;
	private JTextField txtName = null;
	private JLabel jLabel3 = null;
	private JTextField txtInPrice = null;
	private JLabel jLabel4 = null;
	private JTextField txtSalePrice = null;
	private JButton btnDelete = null;
	private JButton btnBack = null;

	
	private JFrame jFrame=null;
	private BookModel book=null;
	/**
	 * This is the default constructor
	 */
	public BookDeletePanel() {
		initialize();
	}

	public BookDeletePanel(JFrame frame, String uuid) {
		this.jFrame=frame;
		this.book=BookEbiFactory.getBookEbi().getSingle(uuid);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(248, 171, 55, 31));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("售价：");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(42, 173, 39, 30));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("进价：");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(256, 90, 54, 31));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("图书名：");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(43, 85, 41, 34));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("uuid：");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(174, 15, 138, 40));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("删除图书");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getTxtUuid(), null);
		this.add(jLabel2, null);
		this.add(getTxtName(), null);
		this.add(jLabel3, null);
		this.add(getTxtInPrice(), null);
		this.add(jLabel4, null);
		this.add(getTxtSalePrice(), null);
		this.add(getBtnDelete(), null);
		this.add(getBtnBack(), null);
	}

	/**
	 * This method initializes txtUuid	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtUuid() {
		if (txtUuid == null) {
			txtUuid = new JTextField();
			txtUuid.setBounds(new Rectangle(102, 86, 112, 35));
			txtUuid.setEditable(false);
			txtUuid.setText(book.getUuid());
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
			txtName.setBounds(new Rectangle(324, 90, 132, 36));
			txtName.setEditable(false);
			txtName.setText(book.getName());
		}
		return txtName;
	}

	/**
	 * This method initializes txtInPrice	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtInPrice() {
		if (txtInPrice == null) {
			txtInPrice = new JTextField();
			txtInPrice.setBounds(new Rectangle(103, 169, 115, 35));
			txtInPrice.setEditable(false);
			txtInPrice.setText(String.valueOf(book.getInPrice()));
		}
		return txtInPrice;
	}

	/**
	 * This method initializes txtSalePrice	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtSalePrice() {
		if (txtSalePrice == null) {
			txtSalePrice = new JTextField();
			txtSalePrice.setBounds(new Rectangle(324, 171, 128, 33));
			txtSalePrice.setEditable(false);
			txtSalePrice.setText(""+book.getSalePrice());
		}
		return txtSalePrice;
	}

	/**
	 * This method initializes btnDelete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setBounds(new Rectangle(65, 240, 100, 50));
			btnDelete.setText("删除");
			btnDelete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					boolean isSuccess=BookEbiFactory.getBookEbi().delete(book.getUuid());
					if(isSuccess){
						JOptionPane.showMessageDialog(null, "删除成功！");
						JPanleUtil.changePanel(jFrame, new BookListPanel(jFrame));
					}else{
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				}
			});
		}
		return btnDelete;
	}

	/**
	 * This method initializes btnBack	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setBounds(new Rectangle(296, 240, 100, 50));
			btnBack.setText("返回");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new BookListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

}  //  @jve:decl-index=0:visual-constraint="150,8"
