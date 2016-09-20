package dao;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBoper
{
  static Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  public static Connection getConn() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
    String driver = "com.mysql.jdbc.Driver";

    String url = "jdbc:mysql://localhost:3306/corporate?user=root&password=123456&useUnicode=true&characterEncoding=utf8";

    System.out.println("——DBopre的url:" + url);

    Class.forName(driver).newInstance();
    conn = DriverManager.getConnection(url);
    return conn;
  }

  public ResultSet executeQuery(String sql, String[] params) {
    try {
      this.pstmt = conn.prepareStatement(sql);

      if (params != null) {
        for (int i = 0; i < params.length; i++) {
          this.pstmt.setString(i + 1, params[i]);
        }
      }

      this.rs = this.pstmt.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return this.rs;
  }

  public int executeUpdate(String sql, String[] params) {
    int n = 0;
    try {
      this.pstmt = conn.prepareStatement(sql);
      if (params != null) {
        for (int i = 0; i < params.length; i++) {
          this.pstmt.setString(i + 1, params[i]);
        }
      }
      n = this.pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return n;
  }

  public void closeAll() {
    if (this.rs != null) {
      try {
        this.rs.close();
      }
      catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (this.pstmt != null) {
      try {
        this.pstmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (conn != null)
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
  }
}