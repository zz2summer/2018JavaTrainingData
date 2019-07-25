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
//���ݿ����ӹ�����
public class DBC {
    //����Դ
    public String url = "jdbc:odbc:test";
    //����connection����
    public Connection conn;

    public static DBC only;
    //����DBC����
    public static DBC getInstance() {

        if (only == null) {
            return new DBC();
        } else {
            return only;
        }
    }
    //�������ݿ�����
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
    //���ݿ��ѯ����
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
    //����,�������ݲ������Ƿ�ɹ�
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
