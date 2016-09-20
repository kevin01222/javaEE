package servlet.News;

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

@WebServlet({"/FrontNewsServlet"})
public class FrontNewsServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    out.print("\t<div align='center'><font size='5' color='blue'>企业新闻</font></div>");

    ResultSet rs = null;
    try
    {
      Connection con = UserDao.getConn();
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery("select * from news");
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
    out.print("\t<th>编号</th>");
    out.print("<th>内容</th>");
    out.print("</tr>");

    System.out.println("第一个：" + rs);
    try {
      while (rs.next()) {
        String newsid = rs.getString(1);
        String news = rs.getString(2);

        out.print("<tr align=center bgcolor=#ffffff>");
        out.print("<td>&nbsp;&nbsp;" + newsid + "&nbsp;&nbsp;</td>");
        out.print("<td>" + news + "</td>");
        out.print("</tr>");
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    out.print(" </table>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}