package servlet.Order;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/DealOrderServlet"})
public class DealOrderServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String action = request.getParameter("action");

    if ((action == "useradd") || (action.equals("useradd"))) {
      String proid = request.getParameter("proid");

      String number = request.getParameter("number2");

      String userid = request.getParameter("userid");

      String total = request.getParameter("total2");

      String username = "qiang";

      username = (String)request.getSession().getAttribute("username");

      if ((username == null) || (username.equals(""))) {
        out.print("请登陆后才可以订购！请登录!<a href='FrontBuyOnlineServlet'>返回</a>");
      }
      else
      {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderidlong = sdf.format(date);
        String orderid = orderidlong.substring(4);
        int orderidint = Integer.parseInt(orderid);
        System.out.println("datetime_sdf=" + orderid);

        int rs = 100;
        try {
          Connection con = UserDao.getConn();
          Statement stmt = con.createStatement();

          String sql = "insert into orderlist(orderid,proid,number,total,state,userid) values ('" + orderidint + "','" + proid + "' , '" + 
            number + "','" + total + "','未付款','" + userid + "')";
          System.out.println("useradd_sql=" + sql);
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

        System.out.println("order3_useradd第一个rs：" + rs);

        if (rs == 1) {
          out.print("尊敬的用户：“" + username + "”您好，您的账单一共需要支付" + total + "元，请您尽快支付！");

          out.print("&nbsp;&nbsp;<a href='DealOrderServlet?action=modify&state=1&orderid=" + orderid + 
            "'>支付</a>");
        }
        else {
          out.print("订单提交失败！！");
        }
      }

      out.print("&nbsp;&nbsp;<a href='FrontBuyOnlineServlet'>返回</a>");
    }
    else if ((action == "del") || (action.equals("del")))
    {
      String[] id1 = request.getParameterValues("id");
      if ((id1 == null) || (id1.length == 0)) { out.print("没有选中任何行"); return; }
      String condition = "";
      for (int i = 0; i < id1.length; i++) {
        if (i == 0) condition = id1[i]; else
          condition = condition + "," + id1[i];
      }
      String sql = "delete from orderlist where orderid in (" + condition + ")";
      System.out.println("DealOrder_del:" + sql);

      int rs = 100;
      try
      {
        Connection con = UserDao.getConn();
        Statement stmt = con.createStatement();
        rs = stmt.executeUpdate(sql);
        out.println("<html><style>body{front-size:12px;line-height:25px;</style><body>");
        out.println(rs + "条记录被删除.");
        out.print("<a href='ListOrderServlet'>返回</a>");
      }
      catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      catch (InstantiationException e) {
        e.printStackTrace();
      }
      catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (SQLException e) {
        out.println("执行SQL：\"" + sql + "\"时发生异常:" + e.getMessage());

        e.printStackTrace();
      }
      System.out.println("order3_del第一个rs：" + rs);
    }
    else if ((action == "modify") || (action.equals("modify")))
    {
      String id4 = request.getParameter("orderid");
      String state = request.getParameter("state");
      if (state.trim().equals("1")) state = "用户已付款";

      System.out.println("要修改的订单编号：" + id4 + "状态改为：" + state);

      String sql = "update orderlist set state='" + state + "' where  orderid='" + id4 + "'";
      System.out.println("modify_sql=" + state);

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

      System.out.println("order3_modify第一个rs：" + rs);
      if (rs == 1)
      {
        String admname = "";
        admname = (String)request.getSession().getAttribute("admname");
        String username = "";
        username = (String)request.getSession().getAttribute("username");
        if ((admname != null) && (admname.length() > 0))
        {
          out.print("操作成功！");
          out.print("此操作管理员：" + request.getSession().getAttribute("admname"));
          out.print("&nbsp;&nbsp;<a href='ListOrderServlet'>返回</a>");
        }
        else if ((username != null) && (username.length() > 0))
        {
          out.print("支付成功！");
          out.print("    <a href='FrontBuyOnlineServlet?'>返回查看订单</a>");
        }
        else
        {
          out.print("测试成功！登录吧！少年！");
        }
      }
      else
      {
        out.print("提交失败！！" + rs);
      }
    } else {
      out.print("500错误！未接收到数据！");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}