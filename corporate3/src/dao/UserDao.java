package dao;

import entity.User;
import java.sql.ResultSet;

public class UserDao extends DBoper
{
  public int addUser(User user)
  {
    String sql = "insert into users (username,password,phone,address)values(?,?,?,?)";
    String[] params = { user.getUsername(), user.getPassword(), user.getPhone(), user.getAddress() };
    int result = executeUpdate(sql, params);
    return result;
  }

  public int clearUser(User user) {
    String sql = "DELETE FROM users where userid=?";
    String[] params = { user.getUserid()+"" };
    int result = executeUpdate(sql, params);
    return result;
  }

  public int ModifyUser(User user) {
    String sql = "UPDATE users set username=? ,password=?,phone=?,address=? where userid=?";
    String[] params = { user.getUsername(), user.getPassword(), user.getPhone(), user.getAddress(), user.getUserid()+"" };
    int result = executeUpdate(sql, params);
    return result;
  }

  public ResultSet ListUser() {
    String sql = "select * from users";
    String[] params = { "" };
    ResultSet rs = executeQuery(sql, params);
    return rs;
  }
  public ResultSet LoginUser(User user) {
    String sql = "select * from users where username=? AND password=?";
    String[] params = { user.getUsername(), user.getPassword() };
    ResultSet rs = executeQuery(sql, params);
    return rs;
  }
}