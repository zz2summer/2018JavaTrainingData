package cn.hncu.xh.bookStore.in.ui;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.hncu.xh.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.in.business.factory.InMainEbiFctory;
import cn.hncu.xh.bookStore.in.vo.InDetailModel;
import cn.hncu.xh.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.xh.bookStore.in.vo.InMainModel;
import cn.hncu.xh.bookStore.in.vo.InMainQueryModel;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.util.DateUtil;
import cn.hncu.xh.bookStore.util.JPanleUtil;

/**
 * <p>
 * Title:InQueryPanel
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 26, 2015
 */
public class InQueryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame jFrame = null;
	private JLabel jLabel = null;
	private JComboBox cmbUser = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JComboBox cmbBook = null;
	private JLabel jLabel3 = null;
	private JTextField txtUuid = null;
	private JLabel jLabel4 = null;
	private JTextField txtDateBegain = null;
	private JLabel jLabel5 = null;
	private JTextField txtDateEnd = null;
	private JLabel jLabel6 = null;
	private JTextField txtInMinNum = null;
	private JLabel jLabel7 = null;
	private JTextField txtInMaxNum = null;
	private JLabel jLabel8 = null;
	private JTextField txtMinMoney = null;
	private JLabel jLabel9 = null;
	private JTextField txtMaxMoney = null;
	private JLabel jLabel10 = null;
	private JButton btnQuery = null;
	private JButton btnBack = null;
	private JLabel jLabel11 = null;
	private JTextField txtInDetailUuid = null;

	/**
	 * This is the default constructor
	 */
	public InQueryPanel() {
		initialize();
	}

	public InQueryPanel(JFrame frame) {
		jFrame = frame;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel11 = new JLabel();
		jLabel11.setBounds(new Rectangle(18, 208, 68, 30));
		jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel11.setText("��ϸuuid:");
		jLabel10 = new JLabel();
		jLabel10.setBounds(new Rectangle(109, 130, 169, 23));
		jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel10.setText("ʱ���ʽ��1990��01��01��");
		jLabel9 = new JLabel();
		jLabel9.setBounds(new Rectangle(252, 165, 81, 32));
		jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel9.setText("����ܽ��:");
		jLabel8 = new JLabel();
		jLabel8.setBounds(new Rectangle(15, 165, 77, 35));
		jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel8.setText("��С�ܽ��:");
		jLabel7 = new JLabel();
		jLabel7.setBounds(new Rectangle(254, 254, 79, 33));
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setText("��������:");
		jLabel6 = new JLabel();
		jLabel6.setBounds(new Rectangle(15, 255, 81, 33));
		jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel6.setText("��С������:");
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(241, 88, 89, 36));
		jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel5.setText("����ʱ�����:");
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(13, 90, 89, 36));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("����ʱ�俪ʼ:");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(29, 44, 49, 33));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("uuid:");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(254, 208, 57, 32));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("ͼ��:");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(248, 44, 49, 32));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("������:");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(200, 6, 82, 31));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setText("������ѯ");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.add(jLabel, null);
		this.add(getCmbUser(), null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(getCmbBook(), null);
		this.add(jLabel3, null);
		this.add(getTxtUuid(), null);
		this.add(jLabel4, null);
		this.add(getTxtDateBegain(), null);
		this.add(jLabel5, null);
		this.add(getTxtDateEnd(), null);
		this.add(jLabel6, null);
		this.add(getTxtInMinNum(), null);
		this.add(jLabel7, null);
		this.add(getTxtInMaxNum(), null);
		this.add(jLabel8, null);
		this.add(getTxtMinMoney(), null);
		this.add(jLabel9, null);
		this.add(getTxtMaxMoney(), null);
		this.add(jLabel10, null);
		this.add(getBtnQuery(), null);
		this.add(getBtnBack(), null);
		this.add(jLabel11, null);
		this.add(getTxtInDetailUuid(), null);
	}

	/**
	 * This method initializes cmbUser
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbUser() {
		if (cmbUser == null) {
			cmbUser = new JComboBox();
			cmbUser.setBounds(new Rectangle(316, 44, 134, 32));
			cmbUser.addItem("��ѡ��...");
			List<UserModel> list = UserEbiFactory.getUserEbi().getAll();
			for (UserModel user : list) {
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
			cmbBook.setBounds(new Rectangle(331, 210, 134, 32));
			cmbBook.addItem("��ѡ��...");
			List<BookModel> list = BookEbiFactory.getBookEbi().getAll();
			for (BookModel book : list) {
				cmbBook.addItem(book.getName());
			}

		}
		return cmbBook;
	}

	/**
	 * This method initializes txtUuid
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtUuid() {
		if (txtUuid == null) {
			txtUuid = new JTextField();
			txtUuid.setBounds(new Rectangle(105, 45, 74, 32));
		}
		return txtUuid;
	}

	/**
	 * This method initializes txtDateBegain
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtDateBegain() {
		if (txtDateBegain == null) {
			txtDateBegain = new JTextField();
			txtDateBegain.setBounds(new Rectangle(109, 90, 126, 35));
		}
		return txtDateBegain;
	}

	/**
	 * This method initializes txtDateEnd
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtDateEnd() {
		if (txtDateEnd == null) {
			txtDateEnd = new JTextField();
			txtDateEnd.setBounds(new Rectangle(338, 88, 127, 38));
		}
		return txtDateEnd;
	}

	/**
	 * This method initializes txtInMinNum
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtInMinNum() {
		if (txtInMinNum == null) {
			txtInMinNum = new JTextField();
			txtInMinNum.setBounds(new Rectangle(105, 254, 99, 33));
		}
		return txtInMinNum;
	}

	/**
	 * This method initializes txtInMaxNum
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtInMaxNum() {
		if (txtInMaxNum == null) {
			txtInMaxNum = new JTextField();
			txtInMaxNum.setBounds(new Rectangle(355, 255, 107, 31));
		}
		return txtInMaxNum;
	}

	/**
	 * This method initializes txtMinMoney
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtMinMoney() {
		if (txtMinMoney == null) {
			txtMinMoney = new JTextField();
			txtMinMoney.setBounds(new Rectangle(102, 165, 99, 33));
		}
		return txtMinMoney;
	}

	/**
	 * This method initializes txtMaxMoney
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtMaxMoney() {
		if (txtMaxMoney == null) {
			txtMaxMoney = new JTextField();
			txtMaxMoney.setBounds(new Rectangle(348, 165, 107, 31));
		}
		return txtMaxMoney;
	}

	/**
	 * This method initializes btnQuery
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton();
			btnQuery.setBounds(new Rectangle(103, 299, 106, 36));
			btnQuery.setText("ȷ�ϲ�ѯ");
			btnQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// �ռ�����
					// �����ŵ�uuid
					String uuid = txtUuid.getText();
					// �����˵�uuid
					String inUserUuid = null;
					if (cmbUser.getSelectedIndex() > 0) {
						String name = cmbUser.getSelectedItem().toString(); // ��cmbUser�л�ȡѡ�е�userName
						inUserUuid = UserEbiFactory.getUserEbi()
								.getsingle(name).getUuid(); // ͨ��userName�ҵ���Ӧ��UserModel���Ӷ���ý����˵�uuid
					}
					// ������ʼʱ��
					long inDate = 0;
					String str = txtDateBegain.getText();// �Ӷ�Ӧ������л�ý�����ʼ����
					if (str != null && str.trim().length() > 0) {// �жϻ�õ���Ϣ�Ƿ�Ϸ�
						try {
							inDate = DateUtil.StringToLong(str + "00:00:00");// �ѻ�õ��ַ������ڣ�ת����long�ͣ�����ʱ�����ʼ��Ϊһ��Ŀ�ʼ
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "������ʼʱ���ʽ����");
							return;
						}
					}
					// ��������ʱ��
					long inDate2 = 0;
					String str2 = txtDateEnd.getText();// �Ӷ�Ӧ������л�ý�����������
					if (str2 != null && str2.trim().length() > 0) {// �жϻ�õ���Ϣ�Ƿ�Ϸ�
						try {
							inDate2 = DateUtil.StringToLong(str2 + "23:59:59");// �ѻ�õ��ַ������ڣ�ת����long�ͣ�����ʱ�����ʼ��Ϊһ��Ľ���
						} catch (RuntimeException e1) {
							JOptionPane.showMessageDialog(null, "��������ʱ���ʽ����");
							return;
						}
					}
					// �������ռ�������ϸ��Ϣ
					// ������ϸ��uuid
					String detailUuid = txtInDetailUuid.getText();// �Ӷ�Ӧ������л�ö�����ϸuuid
					// ͼ���uuid
					String bookUuid = null;
					if (cmbBook.getSelectedIndex() > 0) {// ����û�û��ѡ����Ĭ��ȫ������Ҫ��ѯ��
						String bookName = cmbBook.getSelectedItem().toString();// ��cmbBook�л��ѡ�иõ�bookName
						bookUuid = BookEbiFactory.getBookEbi().getsingle(
								bookName).getUuid(); // //ͨ��bookName�ҵ���Ӧ��UBookModel���Ӷ����ͼ���uuid
					}
					// �ܼ���Сֵ
					double sumMoney = 0;
					String strM = txtMinMoney.getText();// �Ӷ�Ӧ������л����С�ܽ��
					if (strM != null && strM.trim().length() > 0) {// �ж�strM�ĺϷ���
						try {
							sumMoney = Double.parseDouble(strM); // ���ַ���ת����double��
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "��С�ܽ���ʽ�������");
							return;
						}
					}
					// �ܼ����ֵ
					double sumMoney2 = 0;
					String strM2 = txtMaxMoney.getText();// �Ӷ�Ӧ������л������ܽ��
					if (strM2 != null && strM2.trim().length() > 0) {// �ж�strM2�ĺϷ���
						try {
							sumMoney2 = Double.parseDouble(strM2);// ���ַ���ת����double��
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "����ܽ���ʽ�������");
							return;
						}
					}
					// ��С��������
					int sumNum = 0;
					if (txtInMinNum.getText() != null
							&& txtInMinNum.getText().trim().length() > 0) {// �ж���С�������ĺϷ���
						try {
							sumNum = Integer.parseInt(txtInMinNum.getText());// ���ַ���ת��������
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "��С��������ʽ�������");
							return;
						}
					}
					// ����������
					int sumNum2 = 0;
					if (txtInMaxNum.getText() != null
							&& txtInMaxNum.getText().trim().length() > 0) {// �ж���С�������ĺϷ���
						try {
							sumNum2 = Integer.parseInt(txtInMaxNum.getText());// ���ַ���ת��������
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "����������ʽ�������");
							return;
						}
					}
					// ��֯����
					InMainQueryModel imqm = new InMainQueryModel();// ��װ��ѯ����ֵ����
					imqm.setUuid(uuid); //���ö�����uuid
					imqm.setInUserUuid(inUserUuid); //���ý�����uuid
					imqm.setInDate(inDate);//���ÿ�ʼ����
					imqm.setInDate2(inDate2);//���ý�������
					
					InDetailQueryModel idqm=new InDetailQueryModel();// ��װ��ѯ����ֵ����
					idqm.setUuid(detailUuid);//���ö�����ϸuuid
					idqm.setBookUuid(bookUuid); //����ͼ��uuid
					idqm.setSunMoney(sumMoney);  //������С�ܽ��
					idqm.setSumMoney2(sumMoney2); //��������ܽ��
					idqm.setSumNum(sumNum);    //������Сͼ������
					idqm.setSumNum2(sumNum2);  //�������ͼ������
					
					//�����߼���
					Map<InMainModel,List<InDetailModel>> map=InMainEbiFctory.getInMainEbi().getByCondition(imqm,idqm);
					JPanleUtil.changePanel(jFrame, new InListPanel(jFrame,map));
				}
			});
		}
		return btnQuery;
	}

	/**
	 * This method initializes btnBack
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setBounds(new Rectangle(288, 299, 106, 36));
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
	 * This method initializes txtInDetailUuid
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtInDetailUuid() {
		if (txtInDetailUuid == null) {
			txtInDetailUuid = new JTextField();
			txtInDetailUuid.setBounds(new Rectangle(105, 210, 99, 33));
		}
		return txtInDetailUuid;
	}

} // @jve:decl-index=0:visual-constraint="150,-4"
