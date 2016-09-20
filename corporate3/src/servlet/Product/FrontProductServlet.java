package servlet.Product;

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

@WebServlet({"/FrontProductServlet"})
public class FrontProductServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    out.print("\t<div align='center'><font size='5' color='blue'>产品展示</font></div>");

    ResultSet rs = null;
    try
    {
      Connection con = UserDao.getConn();
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery("select * from product");
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

    out.print("<table width=100% align=center >");

    System.out.println("第一个：" + rs);
    int count = 0;
    out.print("<tr>");
    try {
      while (rs.next()) {
        String proid = rs.getString(1);
        String proname = rs.getString(2);
        String image = rs.getString(4);

        out.print("<td width=200 align=center><a href='#?id=" + proid + "'><img src=" + image + " widht=150 height=150></a><br>&nbsp;" + proname + "</td>");
        count++;
        if (count % 4 == 0) {
          out.print("</tr>");
          out.print("<tr>");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    out.print("<tr>");
    out.print(" </table>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}