package mydbc.dbc;

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
//数据库连接公共类
public class DBC {
    //数据源
    public String url = "jdbc:odbc:test";
    //创建connection对象
    public Connection conn;

    public static DBC only;
    //创建DBC对象
    public static DBC getInstance() {

        if (only == null) {
            return new DBC();
        } else {
            return only;
        }
    }
    //创建数据库连接
    public void getConnection() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    ex.getMessage().toString());
        } catch (ClassNotFoundException ex) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    ex.getMessage().toString());
        }
    }
    //数据库查询方法
    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    ex.getMessage().toString());
        }
        return rs;
    }
    //更新,插入数据并返回是否成功
    public boolean executeUpdate(String sql) {
        getConnection();
        int i = 0;
        try {
            Statement stmt = conn.createStatement();
            i = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    ex.getMessage().toString());
            return false;
        }
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }
}
