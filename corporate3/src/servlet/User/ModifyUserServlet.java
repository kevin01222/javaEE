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

@WebServlet({"/ModifyUserServlet"})
public class ModifyUserServlet extends HttpServlet
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

    String userid1 = request.getParameter("userid");
    int userid2 = Integer.parseInt(userid1);
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String phone = request.getParameter("phone");
    String address = request.getParameter("address");

    User user = new User();
    user.setUserid(userid2);
    user.setUsername(username);
    user.setPassword(password);
    user.setPhone(phone);
    user.setAddress(address);
    System.out.println(userid2 + "   " + username + "  " + password + "     " + phone + "      " + address);

    UserDao userDao = new UserDao();
    try {
      UserDao.getConn();
      if (userDao.ModifyUser(user) == 1)
        out.print("修改成功！！");
      else {
        out.print("修改用户失败！！！");
      }
      out.print("<a href='ListContactServlet'>返回</a>");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}