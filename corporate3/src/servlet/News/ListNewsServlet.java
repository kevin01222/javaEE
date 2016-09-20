package servlet.News;

import dao.NewsDao;
import java.io.IOException;
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

@WebServlet({"/ListNewsServlet"})
public class ListNewsServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    ResultSet rs = null;

    NewsDao newsDao = new NewsDao();
    try {
      Connection con = NewsDao.getConn();
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
    out.print("<th width=100>操作</th>");
    out.print("</tr>");
    try {
      while (rs.next()) {
        String newsid = rs.getString(1);
        String news = rs.getString(2);
        out.print("<form id='_form' method='post' action='modifyNews.jsp'>");
        out.print("<tr align=center bgcolor=#ffffff>");
        out.print("<td>&nbsp;&nbsp;" + newsid + "&nbsp;&nbsp;</td>");
        out.print("<td>" + news + "</td>");
        out.print("<td ><a href='DealNewsServlet?action=newsclear&id=" + newsid + "' onclick='return confirm(\"确定删除吗？\")'>删除</a>");
        out.print("&nbsp;&nbsp;<a href='modifyNews.jsp?action=edit&id=" + newsid + "&news=" + news + " ' >修改</a>");

        out.print("</td>");
        out.print("</tr>");
      }
      out.print("<tr>");
      out.print("<td colspan='2' align='center'><a href='addnews.jsp'>[添加新闻]</a></td>");
      out.print("</tr>");
      out.print("</form>");
      out.print(" </table>");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}