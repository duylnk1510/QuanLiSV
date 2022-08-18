package utils;

import entity.NhanVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XJdbc {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=PolyAP";
    static String user = "sa";
    static String pass = "songlong";

    static {//nạp driver
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {        
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt;
        if (sql.trim().startsWith("{")) {
            stmt = con.prepareCall(sql);
        } else {
            stmt = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {//select
        PreparedStatement stmt = XJdbc.getStmt(sql, args);//= con.prepareStatement(sql) con.prepareCall(sql)
        return stmt.executeQuery();
    }

//    public static Object value(String sql, Object... args) {          //dùng để lấy 1 đối tượng dùng cho tìm kiếm 1 obj
//        try {
//            ResultSet rs = XJdbc.query(sql, args);                       //= stmt.executeQuery()
//            if (rs.next()) {
//                return rs.getObject(0);
//            }
//            rs.getStatement().getConnection().close();
//            return null;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static int update(String sql, Object... args) {//insert update delete
        try {
            PreparedStatement stmt = XJdbc.getStmt(sql, args);//= con.prepareStatement(sql) con.prepareCall(sql)
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
