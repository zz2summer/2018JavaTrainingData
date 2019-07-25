package mybook.book;

import java.awt.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;
import mydbc.dbc.DBC;
import java.sql.ResultSet;
import java.sql.*;

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
//������������¶���
public class FrAddreader extends JFrame {
    public FrAddreader() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(null);
        setSize(new Dimension(342, 408));
        this.setTitle("����¶���");
        lblCash.setText("��");
        lblCash.setBounds(new Rectangle(55, 272, 42, 15));
        jLabel8.setBounds(new Rectangle(45, 326, 42, 15));
        txtName.setBounds(new Rectangle(129, 56, 92, 20));
        txtSex.setBounds(new Rectangle(129, 110, 51, 20));
        txtPhone.setBounds(new Rectangle(129, 164, 150, 20));
        txtAddress.setBounds(new Rectangle(129, 217, 150, 20));
        txtCash.setBounds(new Rectangle(129, 271, 45, 20));
        btnSubmit.setBounds(new Rectangle(52, 332, 81, 23));
        btnSubmit.setText("�ύ");
        btnSubmit.addActionListener(new FrAddreader_btnSub_actionAdapter(this));
        btnBack.setBounds(new Rectangle(200, 332, 81, 23));
        btnBack.setText("����");
        btnBack.addActionListener(new FrAddreader_btnBack_actionAdapter(this));
        lblAddress.setText("��ַ:");
        lblAddress.setBounds(new Rectangle(55, 219, 42, 15));
        lblPhone.setText("��ϵ�绰:");
        lblPhone.setBounds(new Rectangle(55, 167, 65, 15));
        lblSex.setText("�Ա�:");
        lblSex.setBounds(new Rectangle(55, 114, 42, 15));
        jLabel1.setFont(new java.awt.Font("����", Font.BOLD, 16));
        jLabel1.setText("����¶���");
        jLabel1.setBounds(new Rectangle(127, 8, 88, 30));
        lblRmb.setText("Ԫ");
        lblRmb.setBounds(new Rectangle(184, 272, 42, 15));
        this.getContentPane().add(lblSex);
        this.getContentPane().add(lblPhone);
        this.getContentPane().add(txtPhone);
        this.getContentPane().add(jLabel8);
        this.getContentPane().add(txtCash);
        this.getContentPane().add(txtAddress);
        this.getContentPane().add(lblAddress);
        this.getContentPane().add(lblCash);
        this.getContentPane().add(txtName);
        this.getContentPane().add(txtSex);
        this.getContentPane().add(btnBack);
        this.getContentPane().add(btnSubmit);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(lblName);
        this.getContentPane().add(lblRmb);
        lblName.setText("����:");
        lblName.setBounds(new Rectangle(55, 61, 42, 15));
    }

    JLabel lblName = new JLabel();
    JLabel lblSex = new JLabel();
    JLabel lblPhone = new JLabel();
    JLabel lblAddress = new JLabel();
    JLabel lblCash = new JLabel();
    JLabel jLabel8 = new JLabel();
    JTextField txtName = new JTextField();
    JTextField txtSex = new JTextField();
    JTextField txtPhone = new JTextField();
    JTextField txtAddress = new JTextField();
    JTextField txtCash = new JTextField();
    JButton btnSubmit = new JButton();
    JButton btnBack = new JButton();
    JLabel jLabel1 = new JLabel();
    JLabel lblRmb = new JLabel();
    //�÷�����������¶���
    public void btnSub_actionPerformed(ActionEvent e) {
        //��λ�ж�
        if (txtName.getText().equals("") || txtSex.getText().equals("") ||
            txtPhone.getText().equals("")
            || txtAddress.getText().equals("") || txtCash.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "����λ����Ϊ�գ������");
        } else {
            //��֤�Ƿ�Ϊ������
            try {
                Integer.parseInt(txtCash.getText());
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "�ֽ����Ϊ���֣������");
                return;
            }
            //�����Ͼ���֤ͨ����ʼ���������
                if (Integer.parseInt(txtCash.getText()) < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "�����и�����");
                    return;
                }


            DBC dbc = DBC.getInstance();
            if (dbc.executeUpdate("INSERT Users VALUES ('" + txtName.getText() +
                                  "','" + txtSex.getText() + "','" +
                                  txtPhone.getText() + "','" +
                                  txtAddress.getText() + "'," +
                                  Math.abs(Integer.parseInt(txtCash.getText())) +
                                  ",DEFAULT,DEFAULT)")) {
                //ȡ�����һ����ӽ�ȥ�Ķ��ߵ�Ψһ��ʶID
                ResultSet rs = dbc.executeQuery(
                        "SELECT Uid FROM Users WHERE Uname = '" +
                        txtName.getText() + "'" + "ORDER BY Uregtime DESC");
                String id = null;
                try {
                    rs.next();
                    id = rs.getString("Uid");
                } catch (SQLException ex1) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            ex1.getMessage().toString());
                }
                //��ID��ʾ������
                javax.swing.JOptionPane.showMessageDialog(this,
                        "�¶�����ӳɹ������߱��Ϊ��" + id + "������μǣ�");
                txtName.setText("");
                txtSex.setText("");
                txtPhone.setText("");
                txtCash.setText("");
                txtAddress.setText("");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "�¶������ʧ�ܣ������ԡ�");
            }
        }
    }
    //�÷��������˳���ǰFrame
    public void btnBack_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

}


class FrAddreader_btnBack_actionAdapter implements ActionListener {
    private FrAddreader adaptee;
    FrAddreader_btnBack_actionAdapter(FrAddreader adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnBack_actionPerformed(e);
    }
}


class FrAddreader_btnSub_actionAdapter implements ActionListener {
    private FrAddreader adaptee;
    FrAddreader_btnSub_actionAdapter(FrAddreader adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSub_actionPerformed(e);
    }
}
