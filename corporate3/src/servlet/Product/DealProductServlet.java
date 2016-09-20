package servlet.Product;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/DealProductServlet"})
public class DealProductServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    String action = request.getParameter("action");

    if ((action == "productadd") || (action.equals("productadd"))) {
      String proname = request.getParameter("proname");
      String price = request.getParameter("price");
      String image = "picture/" + request.getParameter("image");
      String introduce = request.getParameter("introduce");

      double price2 = Double.parseDouble(price);

      out.print("图片：" + image);

      int rs = 100;
      try
      {
        Connection con = UserDao.getConn();
        Statement stmt = con.createStatement();
        rs = stmt.executeUpdate("insert into product(proname,price,image,introduce) values ('" + proname + "' , '" + price2 + "' , '" + image + "' , '" + introduce + "')");
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

      System.out.println("第一个rs：" + rs);

      if (rs == 1)
        out.print("产品为：“" + proname + "”的提交成功");
      else {
        out.print("提交失败！！");
      }

      out.print("<a href='addProduct1.jsp'>返回</a>");
    }
    else if ((action == "productclear") || (action.equals("productclear"))) {
      String id = request.getParameter("id");
      int id2 = Integer.parseInt(id);

      int rs = 100;
      try
      {
        Connection con = UserDao.getConn();
        Statement stmt = con.createStatement();
        rs = stmt.executeUpdate("delete from product where proid='" + id2 + "' ");
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
      System.out.println("第一个rs：" + rs);

      if (rs == 1)
        out.print("编号为" + id2 + "的删除成功");
      else {
        out.print("删除失败！！");
      }
      out.print("<a href='ListProductServlet'>返回</a>");
    }
    else if ((action == "productmodify") || (action.equals("productmodify"))) {
      String id4 = request.getParameter("id3");
      String name4 = request.getParameter("name3");
      String price4 = request.getParameter("price3");
      String introduce4 = request.getParameter("introduce3");

      System.out.print(id4 + name4 + price4 + introduce4);

      String sql = "update product set proname='" + name4 + "',price='" + price4 + "',introduce='" + introduce4 + "' where  proid='" + id4 + "'";
      System.out.print(sql);

      int rs = 100;
      try
      {
        Connection con = UserDao.getConn();
        Statement stmt = con.createStatement();
        rs = stmt.executeUpdate(sql);
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
      if (rs == 1)
        out.print("产品为：“" + name4 + "”修改成功");
      else {
        out.print("提交失败！！");
      }
      out.print("<a href='ListProductServlet'>返回</a>");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}