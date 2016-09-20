package servlet.Apprise;

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

@WebServlet({"/DealAppriseServlet"})
public class DealAppriseServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    String action = request.getParameter("action");

    if ((action == "add") || (action.equals("add"))) {
      String appriseInfo = request.getParameter("info");
      System.out.println(appriseInfo);
      String username = "qiang";

      username = (String)request.getSession().getAttribute("username");
      System.out.println(username);

      if ((username == null) || (username.equals(""))) {
        out.print("请登陆后才可以留言！请登录!");
      }
      else
      {
        int rs = 100;

        int uid = 99999;
        ResultSet result = null;
        try {
          Connection con = UserDao.getConn();
          Statement stmt = con.createStatement();
          result = stmt.executeQuery("select userid from users where username='" + username + "'");

          if (result.next()) {
            String userid = result.getString(1);
            uid = Integer.parseInt(userid);
          }

          rs = stmt.executeUpdate("insert into apprise(userid,appriseInfo) values ('" + uid + "' , '" + appriseInfo + "')");
          System.out.println("第一个rs：" + rs);

          if (rs == 1)
            out.print("用户名为：“" + username + "”的评论：“" + appriseInfo + "”提交成功");
          else {
            out.print("提交失败！！");
          }
        }
        catch (ClassNotFoundException e)
        {
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
      }

      out.print("<a href='addapprise1.jsp'>返回</a>");
    }
    else if ((action == "clear") || (action.equals("clear"))) {
      String id = request.getParameter("id");
      int id2 = Integer.parseInt(id);

      int rs = 100;
      try
      {
        Connection con = UserDao.getConn();
        Statement stmt = con.createStatement();
        rs = stmt.executeUpdate("delete from apprise where id='" + id2 + "' ");
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

      System.out.println("DealApprise_clear第一个rs：" + rs);

      if (rs == 1)
        out.print("编号为" + id2 + "的删除成功");
      else {
        out.print("删除失败！！");
      }
      out.print("<a href='ListAppriseServlet'>返回</a>");
    }
    else if (action != "modify") { action.equals("modify"); }

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}