package mybook.book;

import java.awt.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.Box;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
//������������¹���Ա
public class FrAddmanager extends JFrame {
    public FrAddmanager() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(null);
        setSize(new Dimension(300, 200));
        this.setTitle("���/ɾ������Ա");
        lblName.setText("����Ա����");
        lblName.setBounds(new Rectangle(26, 27, 60, 15));
        jLabel1.setText("���룺");
        jLabel1.setBounds(new Rectangle(26, 55, 60, 15));
        txtName.setBounds(new Rectangle(99, 21, 103, 21));
        txtPwd.setBounds(new Rectangle(99, 49, 103, 21));
        btnAdd.setBounds(new Rectangle(48, 91, 83, 25));
        btnAdd.setText("���");
        btnAdd.addActionListener(new FrAddmanager_btnAdd_actionAdapter(this));
        btnCancel.setBounds(new Rectangle(102, 129, 83, 25));
        btnCancel.setText("ȡ��");
        btnCancel.addActionListener(new FrAddmanager_btnCancel_actionAdapter(this));
        btnDelete.setBounds(new Rectangle(160, 91, 83, 25));
        btnDelete.setText("ɾ��");
        btnDelete.addActionListener(new FrAddmanager_btnDelete_actionAdapter(this));
        this.getContentPane().add(lblName);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtName);
        this.getContentPane().add(txtPwd);
        this.getContentPane().add(btnAdd);
        this.getContentPane().add(btnDelete);
        this.getContentPane().add(btnCancel);
    }

    JLabel lblName = new JLabel();
    JLabel jLabel1 = new JLabel();
    JTextField txtName = new JTextField();
    JTextField txtPwd = new JTextField();
    JButton btnAdd = new JButton();
    JButton btnCancel = new JButton();
    JButton btnDelete = new JButton();
    //�÷�����������¹���Ա
    public void btnAdd_actionPerformed(ActionEvent e) {
        //��λ�ж�
        if (txtName.getText().equals("") || txtPwd.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "����Ա�������벻��Ϊ�գ����������롣");
            txtName.setText("");
            txtPwd.setText("");
        } else {
            //��ѯ�Ƿ��Ѿ���ͬ������Ա
            DBC dbc = DBC.getInstance();
            boolean success = false;
            ResultSet rs = dbc.executeQuery("SELECT * FROM Admin");
            try {
                while (rs.next()) {
                    if (txtName.getText().equals(rs.getString("Aname"))) {
                        success = true;
                    }
                }
                if (success) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "�ù���Ա�Ѵ��ڣ�");
                    txtName.setText("");
                    txtPwd.setText("");
                    return;
                } else {
                    //���޸ù���Ա�����
                    if (dbc.executeUpdate("INSERT Admin VALUES('" +
                                          txtName.getText() + "','" +
                                          txtPwd.getText() + "')")) {
                        javax.swing.JOptionPane.showMessageDialog(this,
                                "��ӳɹ�");
                        this.setVisible(false);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this,
                                "���ʧ�ܣ������ԡ�");
                        txtName.setText("");
                        txtPwd.setText("");
                        return;
                    }

                }

            } catch (HeadlessException ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        ex.getMessage().toString());
            } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        ex.getMessage().toString());
            }

        }
    }
    //�÷�������ɾ������Ա
    public void btnDelete_actionPerformed(ActionEvent e) {
        //��λ�ж�
        if (txtName.getText().equals("") || txtPwd.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "����Ա�������벻��Ϊ�գ����������롣");
            txtName.setText("");
            txtPwd.setText("");
        } else {
            //����λ��֤ͨ��,��ִ��ɾ������
            DBC dbc = DBC.getInstance();
            if (dbc.executeUpdate("DELETE FROM Admin WHERE Aname = '" +
                                  txtName.getText() + "' AND Apwd = '" +
                                  txtPwd.getText() + "'")) {
                javax.swing.JOptionPane.showMessageDialog(this, "ɾ���ɹ�");
                this.setVisible(false);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ������ԡ�");
                txtName.setText("");
                txtPwd.setText("");
                return;
            }
        }

    }
    //�÷��������˳���ǰFrame
    public void btnCancel_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}


class FrAddmanager_btnCancel_actionAdapter implements ActionListener {
    private FrAddmanager adaptee;
    FrAddmanager_btnCancel_actionAdapter(FrAddmanager adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class FrAddmanager_btnDelete_actionAdapter implements ActionListener {
    private FrAddmanager adaptee;
    FrAddmanager_btnDelete_actionAdapter(FrAddmanager adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnDelete_actionPerformed(e);
    }
}


class FrAddmanager_btnAdd_actionAdapter implements ActionListener {
    private FrAddmanager adaptee;
    FrAddmanager_btnAdd_actionAdapter(FrAddmanager adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAdd_actionPerformed(e);
    }
}
