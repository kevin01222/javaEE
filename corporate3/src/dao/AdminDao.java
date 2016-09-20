package dao;

import entity.Admin;
import java.sql.ResultSet;

public class AdminDao extends DBoper
{
  public int addAdmin(Admin admin)
  {
    String sql = "Insert into admin (admname,password) values(?,?)";
    String[] params = { admin.getAdmname(), admin.getPassword() };
    int result = executeUpdate(sql, params);
    return result;
  }
  public int clearAdmin(Admin adm) {
    String sql = "DELETE FROM admin where admid=?";
    String[] params = { adm.getId()+"" };
    int result = executeUpdate(sql, params);
    return result;
  }
  public int modifyAdmin(Admin adm) {
    String sql = "UPDATE admin set admname=? ,password=? where admid=?";
    String[] params = { adm.getAdmname(), adm.getPassword(), adm.getId()+"" };
    int result = executeUpdate(sql, params);
    return result;
  }
  public ResultSet LoginAdmin(Admin admin) { String sql = "select * from admin where admname=? AND password=?";
    String[] params = { admin.getAdmname(), admin.getPassword() };
    ResultSet rs = executeQuery(sql, params);
    return rs;
  }
}