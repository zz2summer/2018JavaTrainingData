package mybook.book;

import java.awt.*;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mydbc.dbc.DBC;
import java.sql.ResultSet;
import java.sql.*;

//该类用于读者信息编辑
public class FrRedit extends JFrame {
    int id = 0;
    //构造方法接收读者管理界面的读者ID参数
    public FrRedit(int x) {
        id = x;
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(null);
        setSize(new Dimension(309, 412));
        this.setTitle("读者信息修改");
        lblUid.setText("编号：");
        lblUid.setBounds(new Rectangle(41, 63, 42, 15));
        lblRegtime.setText("注册时间：");
        lblRegtime.setBounds(new Rectangle(41, 284, 61, 15));
        lblCash.setText("余额：");
        lblCash.setBounds(new Rectangle(41, 247, 42, 15));
        lblAddress.setText("住址：");
        lblAddress.setBounds(new Rectangle(41, 210, 42, 15));
        lblPhone.setText("电话：");
        lblPhone.setBounds(new Rectangle(41, 174, 42, 15));
        lblUsex.setText("性别：");
        lblUsex.setBounds(new Rectangle(41, 137, 42, 15));
        lblUname.setText("姓名：");
        lblUname.setBounds(new Rectangle(41, 100, 42, 15));
        txtUid.setEnabled(false);
        txtUid.setBounds(new Rectangle(105, 57, 72, 21));
        txtUname.setEnabled(false);
        txtUname.setBounds(new Rectangle(105, 94, 72, 21));
        txtUsex.setEnabled(false);
        txtUsex.setText("");
        txtUsex.setBounds(new Rectangle(105, 131, 72, 21));
        txtUphone.setText("");
        txtUphone.setBounds(new Rectangle(106, 168, 72, 21));
        txtUaddress.setText("");
        txtUaddress.setBounds(new Rectangle(105, 204, 155, 21));
        txtUcash.setText("");
        txtUcash.setBounds(new Rectangle(105, 241, 72, 21));
        txtUregtime.setEnabled(false);
        txtUregtime.setText("");
        txtUregtime.setBounds(new Rectangle(105, 278, 151, 21));
        lblUedit.setFont(new java.awt.Font("宋体", Font.BOLD, 16));
        lblUedit.setText("读者信息修改");
        lblUedit.setBounds(new Rectangle(101, 11, 107, 28));
        btnSure.setBounds(new Rectangle(31, 321, 83, 25));
        btnSure.setText("确定");
        btnSure.addActionListener(new FrRedit_btnSure_actionAdapter(this));
        btnCancel.setBounds(new Rectangle(161, 321, 83, 25));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new FrRedit_btnCancel_actionAdapter(this));
        this.getContentPane().add(lblRegtime);
        this.getContentPane().add(lblCash);
        this.getContentPane().add(lblAddress);
        this.getContentPane().add(lblPhone);
        this.getContentPane().add(lblUsex);
        this.getContentPane().add(lblUname);
        this.getContentPane().add(lblUid);
        this.getContentPane().add(txtUid);
        this.getContentPane().add(txtUname);
        this.getContentPane().add(txtUsex);
        this.getContentPane().add(txtUaddress);
        this.getContentPane().add(txtUcash);
        this.getContentPane().add(txtUregtime);
        this.getContentPane().add(txtUphone);
        this.getContentPane().add(lblUedit);
        this.getContentPane().add(btnSure);
        this.getContentPane().add(btnCancel);
        display();
    }

    JLabel lblUid = new JLabel();
    JLabel lblUname = new JLabel();
    JLabel lblUsex = new JLabel();
    JLabel lblPhone = new JLabel();
    JLabel lblAddress = new JLabel();
    JLabel lblCash = new JLabel();
    JLabel lblRegtime = new JLabel();
    JTextField txtUid = new JTextField();
    JTextField txtUname = new JTextField();
    JTextField txtUsex = new JTextField();
    JTextField txtUphone = new JTextField();
    JTextField txtUaddress = new JTextField();
    JTextField txtUcash = new JTextField();
    JTextField txtUregtime = new JTextField();
    JLabel lblUedit = new JLabel();
    JButton btnSure = new JButton();
    JButton btnCancel = new JButton();
    //该方法用于初始化时显示选中的读者信息
    public void display() {
        DBC dbc = DBC.getInstance();
        ResultSet rs = dbc.executeQuery("SELECT * FROM Users WHERE Uid =" + id);
        try {
            rs.next();
            txtUid.setText(id + "");
            txtUname.setText(rs.getString(2));
            txtUsex.setText(rs.getString(3));
            txtUphone.setText(rs.getString(4));
            txtUaddress.setText(rs.getString(5));
            txtUcash.setText(rs.getInt(6) + "");
            txtUregtime.setText(rs.getString(7));
            rs.close();
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    ex.getMessage().toString());
        }
    }

    //该方法用于退出当前Frame
    public void btnCancel_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    //该方法用于提交修改
    public void btnSure_actionPerformed(ActionEvent e) {
        DBC dbc = DBC.getInstance();
        int cash = 0;
        try {
            cash = Integer.parseInt(txtUcash.getText());
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,"格式错误！");
            return;
        }
        if(cash < 0){
                    javax.swing.JOptionPane.showMessageDialog(this,"不能有负数！");
                    return;
                }
        if (dbc.executeUpdate("UPDATE Users SET Uphone='" + txtUphone.getText() +
                              "',Uaddress='" + txtUaddress.getText() +
                              "',Uyue=" + cash + " WHERE Uid =" + id)) {
            javax.swing.JOptionPane.showMessageDialog(this, "信息修改成功！");
            this.setVisible(false);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "修改失败！请重试。");
        }
    }
}


class FrRedit_btnSure_actionAdapter implements ActionListener {
    private FrRedit adaptee;
    FrRedit_btnSure_actionAdapter(FrRedit adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSure_actionPerformed(e);
    }
}


class FrRedit_btnCancel_actionAdapter implements ActionListener {
    private FrRedit adaptee;
    FrRedit_btnCancel_actionAdapter(FrRedit adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}
