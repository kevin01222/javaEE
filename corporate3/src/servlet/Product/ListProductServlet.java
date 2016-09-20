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

@WebServlet({"/ListProductServlet"})
public class ListProductServlet extends HttpServlet
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
    out.print("\t<div align='center'><font size='6'>产品管理</font></div><a href='addProduct1.jsp'><font color='red'>添加产品</font></a>");
    out.print("<table bgcolor='#cccccc' width=100% align=center> ");
    out.print("<tr>");
    out.print("<th width=50>编号</th>");
    out.print("<th>产品</th>");
    out.print("<th width=100>价格</th>");
    out.print("<th>图片</th>");
    out.print("<th>介绍</th>");
    out.print("<th>操作</th>");
    out.print("</tr>");

    System.out.println("第一个：" + rs);
    try {
      while (rs.next()) {
        String proid = rs.getString(1);
        String proname = rs.getString(2);
        String price = rs.getString(3);
        String image = rs.getString(4);
        String introduce = rs.getString(5);

        out.print("<tr align=center bgcolor=#ffffff>");
        out.print("<td>&nbsp;&nbsp;" + proid + "&nbsp;&nbsp;</td>");
        out.print("<td>" + proname + "</td>");
        out.print("<td>" + price + "</td>");
        out.print("<td><img src=" + image + " widht=150 height=150></td>");
        out.print("<td>" + introduce + "</td>");

        out.print("<td width=100><a href='DealProductServlet?action=productclear&id=" + proid + "' onclick='return confirm(\"确定删除？\")'>删除</a>");
        out.print("&nbsp;&nbsp;<a href='modifyProduct.jsp?id=" + proid + "&name=" + proname + "&price=" + price + "&introduce=" + introduce + "'>修改</a>");
        out.print("</td>");
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