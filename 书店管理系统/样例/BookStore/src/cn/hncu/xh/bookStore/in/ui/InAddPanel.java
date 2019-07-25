package cn.hncu.xh.bookStore.in.ui;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.book.business.ebi.BookEbi;
import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.in.business.factory.InMainEbiFctory;
import cn.hncu.xh.bookStore.in.vo.InDetailModel;
import cn.hncu.xh.bookStore.in.vo.InMainModel;
import cn.hncu.xh.bookStore.user.business.ebi.UserEbi;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.dao.factory.UserDaoFactory;
import cn.hncu.xh.bookStore.user.ui.AddPanel;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.user.vo.UserQueryModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 *<p>Title:InAddPanel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
public class InAddPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JComboBox cmbUser = null;
	private JLabel jLabel1 = null;

	private JFrame jFrame=null;
	private JComboBox cmbBook = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextField jtfNum = null;
	private JButton btnAddDetail = null;
	private JList jList = null;
	private JButton btnAdd = null;
	private JButton btnBack = null;
	private JScrollPane jScrollPane = null;
	private List<InDetailModel> detailes=new ArrayList<InDetailModel>();  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public InAddPanel() {
		initialize();
	}

	public InAddPanel(JFrame frame) {
		this.jFrame=frame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(213, 70, 51, 36));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("������");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(15, 70, 55, 37));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("ͼ�飺");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(247, 174, 52, 36));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("�����ˣ�");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(182, 15, 137, 42));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("��ӽ�����Ϣ");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(getCmbUser(), null);
		this.add(jLabel1, null);
		this.add(getCmbBook(), null);
		this.add(jLabel2, null);
		this.add(jLabel3, null);
		this.add(getJtfNum(), null);
		this.add(getBtnAddDetail(), null);
		this.add(getBtnAdd(), null);
		this.add(getBtnBack(), null);
		
		this.add(getJScrollPane(), null);
	}

	/**
	 * This method initializes cmbUser	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbUser() {
		if (cmbUser == null) {
			cmbUser = new JComboBox();
			cmbUser.setBounds(new Rectangle(316, 174, 115, 32));
			
			//���߼���
			UserEbi ebi=UserEbiFactory.getUserEbi();
			List<UserModel> users=ebi.getAllIn();
			for(UserModel user:users){
				cmbUser.addItem(user.getName());
			}
		}
		return cmbUser;
	}

	/**
	 * This method initializes cmbBook	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbBook() {
		if (cmbBook == null) {
			cmbBook = new JComboBox();
			cmbBook.setBounds(new Rectangle(81, 72, 110, 35));
			//����book���߼���
			BookEbi ebi=BookEbiFactory.getBookEbi();
			List<BookModel> books=ebi.getAll();
			for(BookModel book:books){
				cmbBook.addItem(book.getName());
			}
		}
		return cmbBook;
	}

	/**
	 * This method initializes jtfNum	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfNum() {
		if (jtfNum == null) {
			jtfNum = new JTextField();
			jtfNum.setBounds(new Rectangle(274, 71, 81, 33));
		}
		return jtfNum;
	}

	/**
	 * This method initializes btnAddDetail	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAddDetail() {
		if (btnAddDetail == null) {
			btnAddDetail = new JButton();
			btnAddDetail.setBounds(new Rectangle(375, 65, 89, 38));
			btnAddDetail.setText("�����ϸ");
			btnAddDetail.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//�ռ�����
					String bookName=cmbBook.getSelectedItem().toString();//��ȡͼ����
					String bookUuid=BookEbiFactory.getBookEbi().getsingle(bookName).getUuid();
					int sumNum=0;
					try {
						sumNum=Integer.parseInt(jtfNum.getText());
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "����������ʽ����");
						return;
					}
					//��֯
					InDetailModel indetail=new InDetailModel(); //newһ��������ϸ
					indetail.setBookUuid(bookUuid); //����ͼ����
					indetail.setSumNum(sumNum);   //����ͼ������
					
					//�ŵ�details�б���
					detailes.add(indetail);
					jList.setListData(detailes.toArray());
				}
			});
		}
		return btnAddDetail;
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
		return jList;
	}

	/**
	 * This method initializes btnAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton();
			btnAdd.setBounds(new Rectangle(259, 263, 97, 42));
			btnAdd.setText("���");
			btnAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//1���ռ�����
					String inUserName=cmbUser.getSelectedItem().toString(); //��ý���������
					String inUserUuid=UserEbiFactory.getUserEbi().getsingle(inUserName).getUuid();//ͨ��������������ý�����uuid
					
					//2����֯����
					InMainModel inMain=new InMainModel();
					inMain.setInUserUuid(inUserUuid);
					
					//3�������߼���
					boolean isSuccess=InMainEbiFctory.getInMainEbi().create(inMain, detailes);
					
					//4�������߼���Ľ��������ͬҳ��
					if(isSuccess){
						JPanleUtil.changePanel(jFrame, new InListPanel(jFrame));
					}else{
						JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
					}
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
			btnBack.setBounds(new Rectangle(376, 263, 97, 42));
			btnBack.setText("����");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new InListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(29, 131, 199, 197));
			jScrollPane.setViewportView(getJList());
		}
		return jScrollPane;
	}

}  //  @jve:decl-index=0:visual-constraint="142,4"
