package servlet.User;

import dao.DBoper;
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

@WebServlet({"/ListContactServlet"})
public class ListContactServlet extends HttpServlet
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
      Connection con = DBoper.getConn();
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery("select * from users");
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
    out.print("<th>编号</th>");
    out.print("<th>用户名</th>");
    out.print("<th>密码</th>");
    out.print("<th>手机</th>");
    out.print("<th>地址</th>");
    out.print("<th>操作</th>");
    out.print("</tr>");

    System.out.println("第一个：" + rs);
    try {
      while (rs.next()) {
        String id = rs.getString(1);
        String name = rs.getString(2);
        String password = rs.getString(3);
        String phone = rs.getString(4);
        String address = rs.getString(5);

        out.print("<tr align=center bgcolor=#ffffff>");
        out.print("<td>" + id + "</td>");
        out.print("<td>" + name + "</td>");
        out.print("<td>" + password + "</td>");
        out.print("<td>" + phone + "</td>");
        out.print("<td>" + address + "</td>");

        out.print("<td><a href='ClearUserServlet?action=del&id=" + id + "' onclick='return confirm(\"确定删除？\")'>删除</a>&nbsp;&nbsp;");
        out.print("<a href='modifyUser.jsp?action=edit&id=" + id + "'>修改</a>");
        out.print("</td>");
        out.print("</tr>");
      }

      out.print("<tr>");
      out.print("<td colspan='6' align='center'><a href='addUser.jsp'>[添加用户]</a></td>");
      out.print("</tr>");
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    out.print(" </table>");

    System.out.println("第二个：" + rs);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}