package servlet.User;

import dao.UserDao;
import entity.User;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/LoginUserServlet"})
public class LoginUserServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String action = request.getParameter("action");

    User user = new User();
    user.setUsername(username);
    user.setPassword(password);

    System.out.println("获取的用户和密码" + username + "  " + password);

    UserDao a = new UserDao();
    try {
      UserDao.getConn();
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
    try {
      if (a.LoginUser(user).next()) {
        System.out.print("登陆用户为" + username);

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        if ((action == "head") || (action.equals("head")))
        {
          response.sendRedirect("front_head.jsp");
        }
        else {
          response.sendRedirect("front_top1.jsp");
        }
      }
      else if ((action == "head") || (action.equals("head"))) {
        out.println("<h2 align=center>登录失败!</h2>");
        out.println("<h3 align=center>失败原因:账号不存在或密码错误！</h3>");
        response.setHeader("refresh", "1;url=front_head.jsp");
      }
      else {
        out.println("<h2 align=center>登录失败!</h2>");
        out.println("<h3 align=center>失败原因:账号不存在或密码错误！</h3>");
        response.setHeader("refresh", "2;url=front_top1.jsp");
        out.println("3秒后返回首页，如果没有跳转，请点击<a href='front_top1.jsp'>这里</a>");
      }

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}