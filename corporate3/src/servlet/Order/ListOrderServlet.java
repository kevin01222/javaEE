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

@WebServlet({"/ListOrderServlet"})
public class ListOrderServlet extends HttpServlet
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
      rs = stmt.executeQuery("\tSELECT orderid, proname,number,total,username,phone,address,state from orderlist\tINNER JOIN users on orderlist.userid=users.userid INNER JOIN product on product.proid=orderlist.proid ORDER BY orderid");
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
    out.print("<form action='DealOrderServlet' method=get>");
    out.print(" <table bgcolor='#cccccc' cellspacing=1 cellpadding =5 width=100% align=center> ");
    out.print(" <tr>");
    out.print(" <th></th>");
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
        String state = rs.getString("state");

        out.print("<tr align=center bgcolor=#ffffff>");
        out.print("<td><input type=checkbox name=id value=" + orderid + "></td>");
        out.print("<td>" + orderid + "</td>");
        out.print("<td>" + proname + "</td>");
        out.print("<td>" + number + "</td>");
        out.print("<td>" + total + "</td>");
        out.print("<td>" + username + "</td>");
        out.print("<td>" + phone + "</td>");
        out.print("<td>" + address + "</td>");
        out.print("<td>" + state + "</td>");

        out.print("<td width=100><a href='DealOrderServlet?action=del&id=" + orderid + "' onclick='return confirm(\"确定删除？\")'>删除</a>");
        out.print("&nbsp;&nbsp;<a href='modifyorder.jsp?orderid=" + orderid + "&state=" + state + "' onclick='return confirm(\"确定修改\")'>修改</a>");
        out.print("</td>");
        out.print("</tr>");
      }
      out.print(" </table>");
      out.print("<table align=left>");
      out.print("<tr><td>");
      out.print("<input type='hidden' value='del' name='action'><a href='#' onclick='var array=document.getElementsByName(\"id\");for(var i=0;i<array.length;i++){array[i].checked=true;}'>全 选</a>");
      out.print("<a href='#' onclick='var array=document.getElementsByName(\"id\");for(var i=0;i<array.length;i++){array[i].checked=false;}'>取消全选</a>");
      out.print("<input type='submit' onclick='return confirm(\"即将删除所选的记录。是否删除？\");' value='删除'>");
      out.print("</td></tr>");
      out.print("</table></form>");
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