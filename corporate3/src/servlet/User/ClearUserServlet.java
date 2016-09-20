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

@WebServlet({"/ClearUserServlet"})
public class ClearUserServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String id = request.getParameter("id");
    int userid2 = Integer.parseInt(id);

    User user = new User();
    user.setUserid(userid2);

    System.out.println(userid2);

    UserDao userDao = new UserDao();
    try {
      UserDao.getConn();
      if (userDao.clearUser(user) == 1)
        out.print("编号为" + id + "的删除成功！！！");
      else {
        out.print("删除用户失败！！！");
      }
      out.print("<a href='ListContactServlet'>返回</a>");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}