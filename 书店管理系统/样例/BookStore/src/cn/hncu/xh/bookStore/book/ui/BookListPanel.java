package cn.hncu.xh.bookStore.book.ui;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.book.business.ebi.BookEbi;
import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 * <p>
 * Title:BookListPanel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
public class BookListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JButton btnAdd = null;
	private JList jList = null;
	private JScrollPane jScrollPane = null;
	private JButton btnDelete = null;
	private JButton btnUpdeate = null;
	private JButton btnQuery = null;

	private JFrame jFrame = null;
	private List<BookModel> list = null;

	/**
	 * This is the default constructor
	 */
	public BookListPanel() {
		initialize();
	}

	public BookListPanel(JFrame frame) {
		// �����߼��㣬��ԭ�е��û��ص�list����
		BookEbi ebi = BookEbiFactory.getBookEbi();
		list = ebi.getAll();
		this.jFrame = frame;
		initialize();
	}

	public BookListPanel(JFrame frame, List<BookModel> list) {
		this.jFrame=frame;
		this.list=list;
		initialize();
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(178, 13, 126, 49));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel.setText("ͼ�����");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(getBtnAdd(), null);

		this.add(getJScrollPane(), null);
		this.add(getBtnDelete(), null);
		this.add(getBtnUpdeate(), null);
		this.add(getBtnQuery(), null);

	}

	/**
	 * This method initializes btnAdd
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton();
			btnAdd.setBounds(new Rectangle(17, 276, 90, 40));
			btnAdd.setText("ת������");
			btnAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new BookAddPanel(jFrame));
				}
			});
		}
		return btnAdd;
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
				jList.setListData(list.toArray()); // �Ѵ��߼������������list����
			}
		}
		return jList;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(120, 75, 244, 186));
			jScrollPane.setViewportView(getJList());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes btnDelete
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setBounds(new Rectangle(133, 276, 90, 40));
			btnDelete.setText("ת��ɾ��");
			btnDelete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					BookModel book = (BookModel) (jList.getSelectedValue());
					if (book != null) {
						JPanleUtil.changePanel(jFrame, new BookDeletePanel(
								jFrame, book.getUuid()));
					} else {
						JOptionPane.showMessageDialog(null, "��ѡ����Ҫ��ɾ����ѡ�");
					}
				}
			});
		}
		return btnDelete;
	}

	/**
	 * This method initializes btnUpdeate
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnUpdeate() {
		if (btnUpdeate == null) {
			btnUpdeate = new JButton();
			btnUpdeate.setBounds(new Rectangle(247, 276, 90, 40));
			btnUpdeate.setText("ת���޸�");
			btnUpdeate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					BookModel book = (BookModel) (jList.getSelectedValue());
					if (book != null) {
						JPanleUtil.changePanel(jFrame, new BookUpdatePanel(
								jFrame, book.getUuid()));
					} else {
						JOptionPane.showMessageDialog(null, "��ѡ����Ҫ���޸ĵ�ѡ�");
					}
				}
			});
		}
		return btnUpdeate;
	}

	/**
	 * This method initializes btnQuery
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton();
			btnQuery.setBounds(new Rectangle(362, 276, 90, 40));
			btnQuery.setText("��ѯ");
			btnQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new BookQueryPanel(jFrame));
				}
			});
		}
		return btnQuery;
	}

} // @jve:decl-index=0:visual-constraint="145,25"
