package servlet.Apprise;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/ListAppriseServlet"})
public class ListAppriseServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    ResultSet rs = null;
    try
    {
      Connection con = UserDao.getConn();
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery("\tSELECT  id,username,appriseInfo  FROM apprise INNER JOIN users on  users.userid=apprise.userid");
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    catch (InstantiationException e) {
      e.printStackTrace();
    }
    catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    out.print(" <table bgcolor='#cccccc' cellspacing=1 cellpadding =5 width=100% align=center> ");
    out.print(" <tr>");
    out.print("\t<th width=100>编号</th>");
    out.print("<th width=100>用户</th>");
    out.print("<th>留言</th>");
    out.print("</tr>");

    System.out.println("ListAppriseServlet第一个：" + rs);
    try {
      while (rs.next()) {
        String id = rs.getString(1);
        String userid = rs.getString(2);
        String appriseInfo = rs.getString(3);

        out.print("<tr align=center bgcolor=#ffffff>");
        out.print("<td>" + id + "</td>");
        out.print("<td>&nbsp;&nbsp;" + userid + "&nbsp;&nbsp;</td>");
        out.print("<td>" + appriseInfo + "</td>");

        out.print("<td width=100><a href='DealAppriseServlet?action=clear&id=" + id + "' onclick='return confirm(\"确定删除？\")'>删除</a>");
        out.print("</td>");
        out.print("</tr>");
      }
      out.print(" </table>");
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}