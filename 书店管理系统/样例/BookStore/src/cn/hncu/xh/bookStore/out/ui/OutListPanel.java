package cn.hncu.xh.bookStore.out.ui;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.out.business.factory.OutMainEbiFactory;
import cn.hncu.xh.bookStore.out.vo.OutDetailModel;
import cn.hncu.xh.bookStore.out.vo.OutMainModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 *<p>Title:OutListPanel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JList jList = null;
	private JList jList1 = null;
	private JButton btnAdd = null;
	private JButton btnQuery = null;
	private JScrollPane jScrollPane = null;
	private JScrollPane jScrollPane1 = null;
	
	private JFrame jFrame=null;
	private Map<OutMainModel,List<OutDetailModel>> map=null;
	/**
	 * This is the default constructor
	 */
	public OutListPanel() {
		initialize();
	}

	public OutListPanel(JFrame frame) {
		jFrame=frame;
		map=OutMainEbiFactory.getOutMainEbi().getAll();
		initialize();
	}

	public OutListPanel(JFrame frame,
			Map<OutMainModel, List<OutDetailModel>> map2) {
		jFrame=frame;
		map=map2;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(198, 15, 98, 40));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("销售管理");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(getBtnAdd(), null);
		this.add(getBtnQuery(), null);
		this.add(getJScrollPane(), null);
		this.add(getJScrollPane1(), null);
	}

	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		if (jList == null) {
			jList = new JList();
			jList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
				public void valueChanged(javax.swing.event.ListSelectionEvent e) {
					OutMainModel main=(OutMainModel)jList.getSelectedValue();
					List<OutDetailModel> details=map.get(main);
					jList1.setListData(details.toArray());
				}
			});
			jList.setListData(map.keySet().toArray());
		}
		return jList;
	}

	/**
	 * This method initializes jList1	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList1() {
		if (jList1 == null) {
			jList1 = new JList();
		}
		return jList1;
	}

	/**
	 * This method initializes btnAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton();
			btnAdd.setBounds(new Rectangle(75, 285, 105, 45));
			btnAdd.setText("转到添加");
			btnAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new OutAddPanel(jFrame));
				}
			});
		}
		return btnAdd;
	}

	/**
	 * This method initializes btnQuery	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton();
			btnQuery.setBounds(new Rectangle(307, 285, 105, 45));
			btnQuery.setText("查询");
			btnQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new OutQueryPanel(jFrame));
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
			jScrollPane.setBounds(new Rectangle(44, 75, 182, 191));
			jScrollPane.setViewportView(getJList());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(267, 75, 181, 191));
			jScrollPane1.setViewportView(getJList1());
		}
		return jScrollPane1;
	}


}  //  @jve:decl-index=0:visual-constraint="222,19"
