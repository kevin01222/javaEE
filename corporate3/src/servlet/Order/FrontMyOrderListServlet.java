package servlet.Order;

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
import javax.servlet.http.HttpSession;

@WebServlet({"/FrontMyOrderListServlet"})
public class FrontMyOrderListServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    out.print("<a href='FrontBuyOnlineServlet'><font color='red'>返回</font></a> ");
    out.print("<div align='center'><font size='6'>我的订单</font></div> ");

    String username_login = (String)request.getSession().getAttribute("username");
    if ((username_login == null) || (username_login.equals(""))) {
      out.print("<div align='right'>你还没有登录，请先登录!</div> ");
    } else {
      Connection conn = null;
      Statement statement = null;
      ResultSet rs = null;
      try
      {
        conn = UserDao.getConn();
        statement = conn.createStatement();
        String sql = "SELECT orderid,proname,number,total,username,phone,address,state from orderlist\tINNER JOIN users on orderlist.userid=users.userid  INNER JOIN product\ton product.proid=orderlist.proid where username='" + 
          username_login + "' order by orderid";
        System.out.println("我的订单" + sql);
        rs = statement.executeQuery(sql);
      }
      catch (ClassNotFoundException e1) {
        e1.printStackTrace();
      }
      catch (InstantiationException e1) {
        e1.printStackTrace();
      }
      catch (IllegalAccessException e1) {
        e1.printStackTrace();
      }
      catch (SQLException e1) {
        e1.printStackTrace();
      }

      out.print("<table bgcolor='#cccccc' width=100% align=center> ");
      out.print("<tr>");
      out.print("<th width=100>订单编号</th>");
      out.print("<th>产品名称</th>");
      out.print("<th>数量</th>");
      out.print("<th>总价</th>");
      out.print("<th>用户名</th>");
      out.print("<th>电话</th>");
      out.print("<th>地址</th>");
      out.print("<th>状态</th>");
      out.print("</tr>");

      System.out.println("第一个：" + rs);
      try {
        while (rs.next()) {
          String orderid = rs.getString(1);
          String proname = rs.getString(2);
          String number = rs.getString(3);
          String total = rs.getString(4);
          String username = rs.getString(5);
          String phone = rs.getString(6);
          String address = rs.getString(7);
          String state = rs.getString(8);

          out.print("<tr align=center bgcolor=#ffffff>");
          out.print("<td>" + orderid + "</td>");
          out.print("<td>" + proname + "</td>");
          out.print("<td>" + number + "</td>");
          out.print("<td>" + total + "</td>");
          out.print("<td>" + username + "</td>");
          out.print("<td>" + phone + "</td>");
          out.print("<td>" + address + "</td>");
          out.print("<td>" + state + "</td>");
          out.print("</tr>");
        }
      }
      catch (SQLException e) {
        e.printStackTrace();
      }
      out.print(" </table>");

      System.out.println("第二个：" + rs);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}