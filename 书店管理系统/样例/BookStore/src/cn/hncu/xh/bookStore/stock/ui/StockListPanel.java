package cn.hncu.xh.bookStore.stock.ui;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.stock.business.factory.StockEbiFactory;
import cn.hncu.xh.bookStore.stock.vo.StockModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *<p>Title:StockListPanel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class StockListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JList jList = null;
	private JButton btnQuery = null;

	private JFrame jFrame=null;
	private List<StockModel> list=null;
	private JScrollPane jScrollPane = null;
	
	/**
	 * This is the default constructor
	 */
	public StockListPanel() {
		super();
		initialize();
	}

	public StockListPanel(JFrame frame) {
		jFrame=frame;
		list=StockEbiFactory.getStockEbi().getAll();
		initialize();
	}

	public StockListPanel(JFrame frame, List<StockModel> results) {
		jFrame=frame;
		list=results;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(182, 16, 110, 37));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("ø‚¥Êπ‹¿Ì");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(getBtnQuery(), null);
		this.add(getJScrollPane(), null);
	}

	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		if (jList == null) {
			jList = new JList();
		}
		jList.setListData(list.toArray());
		return jList;
	}

	/**
	 * This method initializes btnQuery	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton();
			btnQuery.setBounds(new Rectangle(180, 285, 110, 38));
			btnQuery.setText("≤È—Ø");
			btnQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new StockQueryPanel(jFrame));
				}
			});
		}
		return btnQuery;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(130, 71, 213, 185));
			jScrollPane.setViewportView(getJList());
		}
		return jScrollPane;
	}
}  //  @jve:decl-index=0:visual-constraint="120,-5"
