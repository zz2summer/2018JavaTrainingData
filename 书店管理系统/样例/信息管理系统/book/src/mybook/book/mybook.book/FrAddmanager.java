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
//该类用于添加新管理员
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
        this.setTitle("添加/删除管理员");
        lblName.setText("管理员名：");
        lblName.setBounds(new Rectangle(26, 27, 60, 15));
        jLabel1.setText("密码：");
        jLabel1.setBounds(new Rectangle(26, 55, 60, 15));
        txtName.setBounds(new Rectangle(99, 21, 103, 21));
        txtPwd.setBounds(new Rectangle(99, 49, 103, 21));
        btnAdd.setBounds(new Rectangle(48, 91, 83, 25));
        btnAdd.setText("添加");
        btnAdd.addActionListener(new FrAddmanager_btnAdd_actionAdapter(this));
        btnCancel.setBounds(new Rectangle(102, 129, 83, 25));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new FrAddmanager_btnCancel_actionAdapter(this));
        btnDelete.setBounds(new Rectangle(160, 91, 83, 25));
        btnDelete.setText("删除");
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
    //该方法用于添加新管理员
    public void btnAdd_actionPerformed(ActionEvent e) {
        //栏位判断
        if (txtName.getText().equals("") || txtPwd.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "管理员名及密码不能为空！请重新输入。");
            txtName.setText("");
            txtPwd.setText("");
        } else {
            //查询是否已经有同名管理员
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
                            "该管理员已存在！");
                    txtName.setText("");
                    txtPwd.setText("");
                    return;
                } else {
                    //若无该管理员则添加
                    if (dbc.executeUpdate("INSERT Admin VALUES('" +
                                          txtName.getText() + "','" +
                                          txtPwd.getText() + "')")) {
                        javax.swing.JOptionPane.showMessageDialog(this,
                                "添加成功");
                        this.setVisible(false);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this,
                                "添加失败，请重试。");
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
    //该方法用于删除管理员
    public void btnDelete_actionPerformed(ActionEvent e) {
        //栏位判断
        if (txtName.getText().equals("") || txtPwd.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "管理员名及密码不能为空！请重新输入。");
            txtName.setText("");
            txtPwd.setText("");
        } else {
            //若栏位验证通过,则执行删除操作
            DBC dbc = DBC.getInstance();
            if (dbc.executeUpdate("DELETE FROM Admin WHERE Aname = '" +
                                  txtName.getText() + "' AND Apwd = '" +
                                  txtPwd.getText() + "'")) {
                javax.swing.JOptionPane.showMessageDialog(this, "删除成功");
                this.setVisible(false);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "删除失败，请重试。");
                txtName.setText("");
                txtPwd.setText("");
                return;
            }
        }

    }
    //该方法用于退出当前Frame
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
