package mybook.book;

import java.awt.*;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Dimension;
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
//该类用于图书续借
public class FrKeep extends JFrame {
    public FrKeep() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(null);
        setSize(new Dimension(351, 300));
        this.setTitle("续借登记");
        lblUid.setText("续借人编号：");
        lblUid.setBounds(new Rectangle(67, 75, 76, 15));
        lblTime.setText("续借时间：");
        lblTime.setBounds(new Rectangle(67, 170, 72, 15));
        btnCancel.setBounds(new Rectangle(203, 224, 81, 28));
        btnCancel.setToolTipText("");
        btnCancel.setText("取消");
        btnCancel.addActionListener(new FrKeep_btnCancel_actionAdapter(this));
        btnSubmit.setBounds(new Rectangle(63, 226, 81, 26));
        btnSubmit.setToolTipText("");
        btnSubmit.setText("提交");
        btnSubmit.addActionListener(new FrKeep_btnSubmit_actionAdapter(this));
        txtTime.setBounds(new Rectangle(171, 165, 110, 20));
        txtBid.setBounds(new Rectangle(171, 120, 109, 22));
        txtUid.setBounds(new Rectangle(171, 73, 111, 23));
        this.getContentPane().add(txtUid);
        lblKeep.setFont(new java.awt.Font("宋体", Font.BOLD, 20));
        lblKeep.setText("续借登记");
        lblKeep.setBounds(new Rectangle(131, 12, 89, 45));
        this.getContentPane().add(lblUid);
        this.getContentPane().add(lblBid);
        this.getContentPane().add(lblTime);
        this.getContentPane().add(txtTime);
        this.getContentPane().add(txtBid);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnSubmit);
        this.getContentPane().add(lblKeep);
        lblBid.setText("续借书编号：");
        lblBid.setBounds(new Rectangle(67, 123, 78, 15));
    }

    JLabel lblUid = new JLabel();
    JLabel lblBid = new JLabel();
    JLabel lblTime = new JLabel();
    JTextField txtUid = new JTextField();
    JTextField txtBid = new JTextField();
    JTextField txtTime = new JTextField();
    JButton btnSubmit = new JButton();
    JButton btnCancel = new JButton();
    JLabel lblKeep = new JLabel();
    //该方法用于提交续借信息
    public void btnSubmit_actionPerformed(ActionEvent e) {
        //栏位判断
        if (txtUid.getText().equals("") || txtBid.getText().equals("") ||
            txtTime.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "各栏位不能为空！");
            return;
        } else {
            try {
                //判断是否为数字型
                Integer.parseInt(txtUid.getText());
                Integer.parseInt(txtBid.getText());
                Integer.parseInt(txtTime.getText());
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "各栏位必须为数字！请重填！");
                return;
            }
            //查询并判断是否有该读者的借书信息
            DBC dbc = DBC.getInstance();
            ResultSet rs = dbc.executeQuery(
                    "SELECT TOP 1 * FROM Outbooks WHERE Ouid =" +
                    Integer.parseInt(txtUid.getText()) + "AND Obid=" +
                    Integer.parseInt(txtBid.getText()) +
                    "ORDER BY Obotime DESC");
            String keep = "";
            String state = "";
            String time = "";
            try {
                rs.next();
                time = rs.getString("Obotime");
                state = rs.getString("Obstate");
                keep = rs.getString("Obkeep");
            } catch (SQLException ex1) {
                javax.swing.JOptionPane.showMessageDialog(this, "无该读者信息，不可续借！");
                return;
            }
            if (keep.equals("是") && state.equals("否")) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "已在续借中，不可再续借！");
                return;
            } else if (keep.equals("否") && state.equals("是")) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "该书已退还，不可再续借！");
            } else if (keep.equals("是") && state.equals("是")) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "错误状态！");
            } else {
                if(Integer.parseInt(txtTime.getText()) < 0){
                    javax.swing.JOptionPane.showMessageDialog(this,"时间不能为负数！");
                    return;
                }

                if (dbc.executeUpdate(
                        "UPDATE Outbooks SET Obkeep = '是',ObRenttime=ObRenttime+" +
                        Integer.parseInt(txtTime.getText()) + " WHERE Obid =" +
                        Integer.parseInt(txtBid.getText()) + " AND Ouid =" +
                        Integer.parseInt(txtUid.getText()) + "AND Obotime='" +
                        time + "'")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "续借成功！");
                }
            }

        }
    }
    //该方法用于退出当前Frame
    public void btnCancel_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}


class FrKeep_btnCancel_actionAdapter implements ActionListener {
    private FrKeep adaptee;
    FrKeep_btnCancel_actionAdapter(FrKeep adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class FrKeep_btnSubmit_actionAdapter implements ActionListener {
    private FrKeep adaptee;
    FrKeep_btnSubmit_actionAdapter(FrKeep adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSubmit_actionPerformed(e);
    }
}
