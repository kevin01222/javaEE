package entity;

public class Admin
{
  private int id;
  private String admname;
  private String password;

  public int getId()
  {
    return this.id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getAdmname() {
    return this.admname;
  }
  public void setAdmname(String admname) {
    this.admname = admname;
  }
  public String getPassword() {
    return this.password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}