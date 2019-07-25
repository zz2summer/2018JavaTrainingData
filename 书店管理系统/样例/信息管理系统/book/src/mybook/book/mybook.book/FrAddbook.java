package mybook.book;

import java.awt.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mydbc.dbc.DBC;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
//������������������
public class FrAddbook extends JFrame {
    public FrAddbook() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(null);
        setSize(new Dimension(372, 500));
        this.setTitle("�������");
        lblName.setText("������");
        lblName.setBounds(new Rectangle(67, 62, 42, 15));
        lblAuthor.setText("���ߣ�");
        lblSum.setToolTipText("");
        lblSum.setText("���������");
        lblPrice.setText("���ۣ�");
        btnSubmit.setBounds(new Rectangle(54, 438, 101, 27));
        btnSubmit.setText("�ύ");
        btnSubmit.addActionListener(new FrAddbook_btnSubmit_actionAdapter(this));
        btnExit.setBounds(new Rectangle(197, 438, 101, 27));
        btnExit.setText("�˳�");
        btnExit.addActionListener(new FrAddbook_btnExit_actionAdapter(this));
        lblNewbook.setFont(new java.awt.Font("����", Font.BOLD, 18));
        lblNewbook.setText("�������");
        lblNewbook.setBounds(new Rectangle(134, 16, 104, 30));
        txtPreview.setBorder(BorderFactory.createLineBorder(Color.black));
        txtPreview.setBounds(new Rectangle(133, 361, 203, 58));
        cbSort.setBounds(new Rectangle(133, 309, 120, 23));
        txtPrice.setBounds(new Rectangle(133, 259, 57, 20));
        txtSum.setBounds(new Rectangle(133, 210, 57, 20));
        txtPublisher.setBounds(new Rectangle(133, 160, 119, 20));
        txtAuthor.setBounds(new Rectangle(133, 111, 119, 20));
        txtName.setBounds(new Rectangle(133, 61, 119, 20));
        lblPreview.setText("��飺");
        lblPreview.setBounds(new Rectangle(67, 369, 42, 15));
        lblSort.setText("���");
        lblSort.setBounds(new Rectangle(67, 318, 42, 15));
        lblPrice.setBounds(new Rectangle(67, 267, 42, 15));
        lblSum.setBounds(new Rectangle(67, 216, 72, 15));
        lblPublisher.setText("�����磺");
        lblPublisher.setBounds(new Rectangle(67, 164, 59, 15));
        this.getContentPane().add(lblAuthor);
        this.getContentPane().add(lblPublisher);
        this.getContentPane().add(lblSum);
        this.getContentPane().add(lblPrice);
        this.getContentPane().add(lblSort);
        this.getContentPane().add(lblPreview);
        this.getContentPane().add(txtAuthor);
        this.getContentPane().add(txtPublisher);
        this.getContentPane().add(txtSum);
        this.getContentPane().add(cbSort);
        this.getContentPane().add(txtPreview);
        this.getContentPane().add(txtPrice);
        this.getContentPane().add(lblNewbook);
        this.getContentPane().add(txtName);
        this.getContentPane().add(lblName);
        this.getContentPane().add(btnSubmit);
        this.getContentPane().add(btnExit);
        cbSort.addItem("����");
        cbSort.addItem("����");
        cbSort.addItem("����");
        cbSort.addItem("���");
        cbSort.addItem("�Ƽ�");
        cbSort.addItem("�ֲ�");
        lblAuthor.setBounds(new Rectangle(67, 113, 42, 15));
    }

    JLabel lblName = new JLabel();
    JLabel lblAuthor = new JLabel();
    JLabel lblPublisher = new JLabel();
    JLabel lblSum = new JLabel();
    JLabel lblPrice = new JLabel();
    JLabel lblSort = new JLabel();
    JLabel lblPreview = new JLabel();
    JTextField txtName = new JTextField();
    JTextField txtAuthor = new JTextField();
    JTextField txtPublisher = new JTextField();
    JTextField txtSum = new JTextField();
    JTextField txtPrice = new JTextField();
    JComboBox cbSort = new JComboBox();
    JEditorPane txtPreview = new JEditorPane();
    JButton btnSubmit = new JButton();
    JButton btnExit = new JButton();
    JLabel lblNewbook = new JLabel();
    //�÷��������˳���ǰFrame
    public void btnExit_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
    //�÷���������Ӷ�����Ϣ
    public void btnSubmit_actionPerformed(ActionEvent e) {
        //��λ�ж�
        if (txtName.getText().equals("") || txtAuthor.getText().equals("") ||
            txtPublisher.getText().equals("")
            || txtSum.getText().equals("") || txtPrice.getText().equals("") ||
            txtPreview.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "����λ����Ϊ�գ������");
        } else {
            //�ж��Ƿ�Ϊ����
            try {
                Integer.parseInt(txtSum.getText());
               Integer.parseInt(txtPrice.getText());
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "��ȷ����������������Ϊ���֣�");
                return;
            }
            if(Integer.parseInt(txtSum.getText()) < 0 || Integer.parseInt(txtPrice.getText()) < 0){
                    javax.swing.JOptionPane.showMessageDialog(this,"�����и�����");
                    return;
                }

            //���������֤��ͨ����ʼ���������
            DBC dbc = DBC.getInstance();
            if (dbc.executeUpdate("INSERT Books VALUES ('" + txtName.getText() +
                                  "','" + txtPreview.getText() + "','" +
                                  (String) cbSort.getSelectedItem() + "','" +
                                  txtPublisher.getText() + "'," +
                                  Integer.parseInt(txtSum.getText()) + "," +
                                  Integer.parseInt(txtPrice.getText())+ ",'" +
                                  txtAuthor.getText() + "',DEFAULT)")) {
                javax.swing.JOptionPane.showMessageDialog(this, "�������ɹ���");
                txtName.setText("");
                txtAuthor.setText("");
                txtPreview.setText("");
                txtPrice.setText("");
                txtPublisher.setText("");
                txtSum.setText("");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "�������ʧ�ܣ��������ԡ�");
            }
        }
    }
}


class FrAddbook_btnSubmit_actionAdapter implements ActionListener {
    private FrAddbook adaptee;
    FrAddbook_btnSubmit_actionAdapter(FrAddbook adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSubmit_actionPerformed(e);
    }
}


class FrAddbook_btnExit_actionAdapter implements ActionListener {
    private FrAddbook adaptee;
    FrAddbook_btnExit_actionAdapter(FrAddbook adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnExit_actionPerformed(e);
    }
}
