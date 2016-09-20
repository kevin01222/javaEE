package servlet.User;

import dao.UserDao;
import entity.User;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/AddUserServlet"})
public class AddUserServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String phone = request.getParameter("phone");
    String address = request.getParameter("address");

    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setPhone(phone);
    user.setAddress(address);
    System.out.println(username + "  " + password + "     " + phone + "      " + address);

    UserDao userDao = new UserDao();
    try {
      UserDao.getConn();
      if (userDao.addUser(user) == 1)
        out.print("添加成功！！");
      else {
        out.print("添加新用户失败！！！该用户名已被注册");
      }
      if ((request.getSession().getAttribute("admname").equals(null)) || (request.getSession().getAttribute("admname").toString() == ""))
      {
        out.print("<a href='front_main.jsp' target='_black'>返回</a>");
      } else {
        out.print("此操作管理员：" + request.getSession().getAttribute("admname"));
        out.print("&nbsp;&nbsp;<a href='ListContactServlet'>返回</a>");
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}