package mybook.book;

import java.awt.*;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Rectangle;
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
//该类用于修改管理密码
public class FrChange extends JFrame {
    public FrChange() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(null);
        setSize(new Dimension(362, 287));
        this.setTitle("更改密码");
        lblName.setText("管理员名：");
        lblName.setBounds(new Rectangle(76, 32, 64, 15));
        btnSure.setBounds(new Rectangle(58, 164, 83, 25));
        btnSure.setText("确认修改");
        btnSure.addActionListener(new FrChange_btnSure_actionAdapter(this));
        btnCancel.setBounds(new Rectangle(185, 164, 83, 25));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new FrChange_btnCancel_actionAdapter(this));
        this.getContentPane().add(lblName);
        txtNewpwd.setBounds(new Rectangle(155, 115, 72, 21));
        txtOldpwd.setBounds(new Rectangle(155, 71, 72, 21));
        txtName.setBounds(new Rectangle(155, 26, 72, 21));
        lblNewpwd.setText("新密码：");
        lblNewpwd.setBounds(new Rectangle(76, 121, 50, 15));
        this.getContentPane().add(lblOldpwd);
        this.getContentPane().add(lblNewpwd);
        this.getContentPane().add(txtName);
        this.getContentPane().add(txtOldpwd);
        this.getContentPane().add(txtNewpwd);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnSure);
        lblOldpwd.setText("原密码：");
        lblOldpwd.setBounds(new Rectangle(76, 77, 50, 15));
    }

    JLabel lblName = new JLabel();
    JLabel lblOldpwd = new JLabel();
    JLabel lblNewpwd = new JLabel();
    JTextField txtName = new JTextField();
    JTextField txtOldpwd = new JTextField();
    JTextField txtNewpwd = new JTextField();
    JButton btnSure = new JButton();
    JButton btnCancel = new JButton();
    //该方法用于退出修改
    public void btnCancel_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
    //该方法用于提交修改
    public void btnSure_actionPerformed(ActionEvent e) {
        //栏位判断
        if (txtName.getText().equals("") || txtOldpwd.getText().equals("") ||
            txtNewpwd.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "任何一栏不能为空！");
        } else {
            DBC dbc = DBC.getInstance();
            boolean success = false;
            ResultSet rs = dbc.executeQuery("SELECT * FROM Admin");
            //查询并判断原始信息是否匹配
            try {
                while (rs.next()) {
                    if (txtName.getText().equals(rs.getString("Aname")) &&
                        txtOldpwd.getText().equals(rs.getString("Apwd"))) {
                        success = true;
                    }
                }
                //匹配则容许修改
                if (success) {
                    if (dbc.executeUpdate("UPDATE Admin SET Apwd = '" +
                                          txtNewpwd.getText() + "' where Aname='"+txtName.getText()+"'")) {
                        javax.swing.JOptionPane.showMessageDialog(this,
                                "密码修改成功。");
                        this.setVisible(false);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this,
                                "密码修改失败，请重试。");
                    }
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "用户名或原始密码错误！请重新确认！");
                    return;
                }
            } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        ex.getMessage().toString());
                return;
            }
        }
    }
}


class FrChange_btnSure_actionAdapter implements ActionListener {
    private FrChange adaptee;
    FrChange_btnSure_actionAdapter(FrChange adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSure_actionPerformed(e);
    }
}


class FrChange_btnCancel_actionAdapter implements ActionListener {
    private FrChange adaptee;
    FrChange_btnCancel_actionAdapter(FrChange adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}
