package cn.hncu.xh.bookStore.out.ui;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.book.business.ebi.BookEbi;
import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.out.business.ebi.OutMainEbi;
import cn.hncu.xh.bookStore.out.business.factory.OutMainEbiFactory;
import cn.hncu.xh.bookStore.out.vo.OutDetailModel;
import cn.hncu.xh.bookStore.out.vo.OutMainModel;
import cn.hncu.xh.bookStore.user.business.ebi.UserEbi;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 *<p>Title:OutAddPanel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutAddPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JComboBox cmbBook = null;
	private JLabel jLabel2 = null;
	private JTextField txtNum = null;
	private JButton btnAddOutDetail = null;
	private JList jList = null;
	private JLabel jLabel3 = null;
	private JComboBox cmbOutUser = null;
	private JButton btnAdd = null;
	private JButton btnBack = null;
	private JFrame jFrame=null;
	
	private List<OutDetailModel> details=new ArrayList<OutDetailModel>();  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public OutAddPanel() {
		initialize();
	}

	public OutAddPanel(JFrame frame) {
		jFrame=frame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(255, 175, 50, 35));
		jLabel3.setText("������");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(224, 70, 60, 35));
		jLabel2.setText("��������");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(30, 70, 35, 35));
		jLabel1.setText("ͼ��");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(180, 11, 125, 39));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("���������Ϣ");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getCmbBook(), null);
		this.add(jLabel2, null);
		this.add(getTxtNum(), null);
		this.add(getBtnAddOutDetail(), null);
		this.add(getJList(), null);
		this.add(jLabel3, null);
		this.add(getCmbOutUser(), null);
		this.add(getBtnAdd(), null);
		this.add(getBtnBack(), null);
	}

	/**
	 * This method initializes cmbBook	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbBook() {
		if (cmbBook == null) {
			cmbBook = new JComboBox();
			cmbBook.setBounds(new Rectangle(84, 70, 115, 35));
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
	 * This method initializes txtNum	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNum() {
		if (txtNum == null) {
			txtNum = new JTextField();
			txtNum.setBounds(new Rectangle(299, 70, 55, 35));
		}
		return txtNum;
	}

	/**
	 * This method initializes btnAddOutDetail	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAddOutDetail() {
		if (btnAddOutDetail == null) {
			btnAddOutDetail = new JButton();
			btnAddOutDetail.setBounds(new Rectangle(366, 70, 88, 35));
			btnAddOutDetail.setText("�����ϸ");
			btnAddOutDetail.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//�ռ�����
					String bookName =cmbBook.getSelectedItem().toString();
					String bookUuid=BookEbiFactory.getBookEbi().getsingle(bookName).getUuid();//��bookģ����߼�����ݶӶ�Ӧ��bookName���bookUuid
					int sumNum=Integer.parseInt(txtNum.getText()); //�Ӷ�Ӧ�ؼ��л�ȡ��������
					
					//��֯����
					OutDetailModel detail=new OutDetailModel(); //new ������ϸ
					detail.setBookUuid(bookUuid); //����bookUuid
					detail.setSumNum(sumNum);
					 //��������ϸ�ŵ�list��
					details.add(detail);
					jList.setListData(details.toArray());
				}
			});
		}
		return btnAddOutDetail;
	}

	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		if (jList == null) {
			jList = new JList();
			jList.setBounds(new Rectangle(30, 135, 197, 197));
		}
		return jList;
	}

	/**
	 * This method initializes cmbOutUser	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbOutUser() {
		if (cmbOutUser == null) {
			cmbOutUser = new JComboBox();
			cmbOutUser.setBounds(new Rectangle(330, 175, 135, 35));
			
			//���߼���
			UserEbi ebi=UserEbiFactory.getUserEbi();
			List<UserModel> users=ebi.getAllOut();
			for(UserModel user:users){
				cmbOutUser.addItem(user.getName());
			}
		}
		return cmbOutUser;
	}

	/**
	 * This method initializes btnAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton();
			btnAdd.setBounds(new Rectangle(255, 268, 90, 45));
			btnAdd.setText("���");
			btnAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//�ռ�����
					String outUserName =cmbOutUser.getSelectedItem().toString();
					String outUserUuid=UserEbiFactory.getUserEbi().getsingle(outUserName).getUuid();//��userģ����߼�����ݶӶ�Ӧ��userName���userUuid
					//��֯����
					OutMainModel outMain=new OutMainModel(); //new ���۵�
					outMain.setOutUserUuid(outUserUuid);
					outMain.setOutUserName(outUserName);
					//�����߼��㣬���ݽ������ͬҳ��
					OutMainEbi ebi =OutMainEbiFactory.getOutMainEbi();
					if(ebi.create(outMain, details)){
						JPanleUtil.changePanel(jFrame, new OutListPanel(jFrame));
					}else{
						JOptionPane.showMessageDialog(null, "��治�㣬���۵�����ʧ�ܣ�");
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
			btnBack.setBounds(new Rectangle(376, 268, 90, 45));
			btnBack.setText("����");
			btnBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPanleUtil.changePanel(jFrame, new OutListPanel(jFrame));
				}
			});
		}
		return btnBack;
	}

}  //  @jve:decl-index=0:visual-constraint="140,7"
