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

@WebServlet({"/Order2Servlet"})
public class Order2Servlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String proid = request.getParameter("proid");
    String number = request.getParameter("number");
    int n = Integer.parseInt(number);

    String username = "qiang";

    username = (String)request.getSession().getAttribute("username");

    out.print("尊敬的用户 ：" + username + "，您的选择的产品ID为：" + proid);

    String sql = "select * FROM users,product WHERE username='" + username + "' AND proid='" + proid + "'";
    System.out.print(sql);

    if ((username != null) && (username.length() > 0))
    {
      ResultSet rs = null;
      try
      {
        Connection con = UserDao.getConn();
        Statement stmt = con.createStatement();

        rs = stmt.executeQuery(sql);
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
      System.out.println("order2de 第一个：" + rs);

      String userid = "99999";
      String phone = "99999";
      String address = "肇庆学院";

      String proname = "卤水蛋";
      String price = "123";
      try
      {
        while (rs.next()) {
          phone = rs.getString("phone");
          address = rs.getString("address");
          userid = rs.getString("userid");
          proname = rs.getString("proname");
          price = rs.getString("price");
          System.out.print("phone=" + phone + "address=" + address + "userid=" + userid + "proname=" + proname + 
            "price=" + price);
        }
      }
      catch (SQLException e) {
        e.printStackTrace();
      }

      double pricedou = Double.parseDouble(price);

      double total = pricedou * n;

      out.print(
        "<script >function check(){alert('下单成功！将前往支付页面');}                                                                 ");
      out.print(
        "</script>                                                                                                                     ");
      out.print(
        "<div align='center'><font size='5'>订单确认</font></div><br>                                                                  ");
      out.print(
        "<form name='form_order' method='post' action='DealOrderServlet' >                                                             ");
      out.print(
        "\t \t<input type='hidden' readonly='readonly' value=" + proid + " name='proid' >                                       ");
      out.print(
        "\t \t<input type='hidden' readonly='readonly' value=" + userid + " name='userid' >                                    ");
      out.print(
        "\t \t<input type='hidden' readonly='readonly' value='useradd' name='action' >                                                 ");
      out.print(
        " \t<table align='center'>                                                                                                   ");
      out.print(
        " \t<tr>                                                                                                                     ");
      out.print(
        " \t<td>名称:</td>                                                                                                           ");
      out.print(
        " \t<td><input type='hidden' readonly='readonly' value=" + proname + " name='proname2' id='1'>" + proname + " </td>                ");
      out.print(
        " \t</tr>                                                                                                                    ");
      out.print(
        " \t<tr>                                                                                                                     ");
      out.print(
        " \t<td><br>数量:</td>                                                                                                       ");
      out.print(
        " \t<td><br><input type='hidden' readonly='readonly' value=" + number + " name='number2' id='2'>" + number + "</td>                ");
      out.print(
        " \t</tr>                                                                                                                    ");
      out.print(
        " \t<tr>                                                                                                                     ");
      out.print(
        " \t<td><br>总价格：</td>                                                                                                    ");
      out.print(
        " \t<td><br><input type='hidden' readonly='readonly' value=" + total + " name='total2' id='3'>" + total + "</td>                   ");
      out.print(
        " \t</tr>                                                                                                                    ");
      out.print(
        " \t<tr>                                                                                                                     ");
      out.print(
        " \t<td><br>收货人：</td>                                                                                                    ");
      out.print(
        " \t<td><br><input type='hidden' readonly='readonly' value=" + username + " name='username2' id='4'>" + username + "</td>          ");
      out.print(
        " \t</tr>                                                                                                                    ");
      out.print(
        " \t<tr>                                                                                                                     ");
      out.print(
        " \t<td><br>电话：</td>                                                                                                      ");
      out.print(
        " \t<td><br><input type='hidden' readonly='readonly' value=" + phone + " name='phone2' id='5'>" + phone + "</td>                   ");
      out.print(
        " \t</tr>                                                                                                                    ");
      out.print(
        " \t<tr>                                                                                                                     ");
      out.print(
        " \t<td><br>收货地址</td>                                                                                                    ");
      out.print(
        " \t<td><br><input type='hidden' readonly='readonly' value=" + address + " name='address2' id='6'>" + address + "</td>             ");
      out.print(
        " \t</tr>                                                                                                                    ");
      out.print(
        " \t<tr>                                                                                                                     ");
      out.print(
        " \t<td><br>商家电话：</td>                                                                                                  ");
      out.print(
        " \t<td><br>5498732131</td>                                                                                                  ");
      out.print(
        " \t</tr>                                                                                                                    ");
      out.print(
        " \t<tr>                                                                                                                     ");
      out.print(
        " \t<td colspan='2' align='center'>                                                                                          ");
      out.print(
        " \t<br/>                                                                                                                    ");
      out.print(
        " \t<input type='submit' value='确认订单' onclick='check()' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;               ");
      out.print(
        " \t<a href='FrontBuyOnlineServlet'><font color='blue'>取消订单</font></a>                                                   ");
      out.print(
        " \t</td>                                                                                                                    ");
      out.print(
        " \t</tr>                                                                                                                    ");
      out.print(
        " \t</table>                                                                                                                 ");
      out.print(
        "</form>                                                                                                                       ");
    }
    else
    {
      out.print("请登陆后才可以订购！请登录!");
      out.print("<a href='FrontBuyOnlineServlet'>返回</a>");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}