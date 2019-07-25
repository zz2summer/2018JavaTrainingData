package cn.hncu.xh.bookStore.in.ui;

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

import cn.hncu.xh.bookStore.in.business.factory.InMainEbiFctory;
import cn.hncu.xh.bookStore.in.vo.InDetailModel;
import cn.hncu.xh.bookStore.in.vo.InMainModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 * <p>
 * Title:InListPanel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
public class InListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JButton btnAdd = null;
	private JButton btnBack = null;
	private JFrame jFrame = null;
	private JList jList = null;
	private JList jList1 = null;
	private JScrollPane jScrollPane = null;
	private JScrollPane jScrollPane1 = null;

	private Map<InMainModel, List<InDetailModel>> map=null; // new 一个map用来装封装好的订单和订单明细,并把他们加入到jLIst列表中

	/**
	 * This is the default constructor
	 */
	public InListPanel() {
		initialize();
	}

	public InListPanel(JFrame frame) {
		map = InMainEbiFctory.getInMainEbi().getAll(); // 通过逻辑层从数据层获得所有的InMainModel元素
		jFrame = frame;
		initialize();
	}

	public InListPanel(JFrame frame, Map<InMainModel, List<InDetailModel>> map) {
		this.jFrame=frame;
		this.map=map;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(168, 15, 125, 36));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setText("进货管理");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(getBtnAdd(), null);
		this.add(getBtnBack(), null);

		this.add(getJScrollPane(), null);
		this.add(getJScrollPane1(), null);

	}

	/**
	 * This method initializes btnAdd
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton();
			btnAdd.setBounds(new Rectangle(87, 270, 107, 45));
			btnAdd.setText("转到添加");
			btnAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new InAddPanel(jFrame));
				}
			});
		}
		return btnAdd;
	}

	/**
	 * This method initializes btnBack
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setBounds(new Rectangle(289, 270, 107, 45));
			btnBack.setText("查询");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new InQueryPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

	/**
	 * This method initializes jList
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJList() {
		if (jList == null) {
			jList = new JList();
			if (jList != null) {
				jList.setListData(map.keySet().toArray());
			}
			jList.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					InMainModel main=(InMainModel)jList.getSelectedValue();
					List<InDetailModel> detail=map.get(main);
					jList1.setListData(detail.toArray());
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
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
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(46, 60, 177, 182));
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
			jScrollPane1.setBounds(new Rectangle(240, 60, 177, 182));
			jScrollPane1.setViewportView(getJList1());
		}
		return jScrollPane1;
	}

} // @jve:decl-index=0:visual-constraint="179,6"
