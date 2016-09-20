package servlet.Admin;

import dao.AdminDao;
import entity.Admin;
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

@WebServlet({"/DealAdminServlet"})
public class DealAdminServlet extends HttpServlet
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
      String admname = request.getParameter("admname");
      String password = request.getParameter("password");

      Admin admin = new Admin();
      admin.setAdmname(admname);
      admin.setPassword(password);

      AdminDao adminDao = new AdminDao();
      try {
        AdminDao.getConn();
        if (adminDao.addAdmin(admin) == 1)
          out.print("添加成功！");
        else {
          out.print("添加失败！");
        }
        out.print("<a href='ListAdminServlet'>返回</a>");
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

    }
    else if ((action == "clear") || (action.equals("clear"))) {
      String id = request.getParameter("id");
      int id2 = Integer.parseInt(id);

      Admin adm = new Admin();
      adm.setId(id2);

      AdminDao admDao = new AdminDao();
      try {
        AdminDao.getConn();
        if (admDao.clearAdmin(adm) == 1)
          out.print("编号为" + id + "的删除成功！！");
        else {
          out.print("删除用户失败！！！");
        }
        out.print("<a href='ListAdminServlet'>返回</a>");
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      }

    }
    else if ((action == "modify") || (action.equals("modify"))) {
      String id3 = request.getParameter("admid");
      int id_ = Integer.parseInt(id3);
      String admname3 = request.getParameter("admname");
      String password3 = request.getParameter("password");

      System.out.println(id_ + "   " + admname3 + "  " + password3);
      Admin adm = new Admin();
      adm.setId(id_);
      adm.setAdmname(admname3);
      adm.setPassword(password3);

      AdminDao adminDao = new AdminDao();
      try {
        AdminDao.getConn();
        if (adminDao.modifyAdmin(adm) == 1)
          out.print("编号为" + id3 + "的修改成功！");
        else {
          out.print("修改失败！");
        }
        out.print("<a href='ListAdminServlet'>返回</a>");
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

    }
    else if ((action == "login") || (action.equals("login"))) {
      String admname = request.getParameter("admname");
      String password = request.getParameter("password");

      Admin admin = new Admin();
      admin.setAdmname(admname);
      admin.setPassword(password);

      System.out.println("DealAdmin_login获取的用户和密码" + admname + "  /" + password);
      out.println("用户和密码:" + admname + "  " + password);

      HttpSession session = request.getSession();
      session.setAttribute("admname", admname);

      AdminDao a = new AdminDao();
      try {
        AdminDao.getConn();
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
      try {
        if (a.LoginAdmin(admin).next()) {
          System.out.print("登陆用户为" + admname);
          session.setAttribute("admname", admname);

          response.sendRedirect("backstagemain.jsp");
        } else {
          out.println("<h2 align=center>登录失败!</h2>");
          out.println("<h3 align=center>失败原因:账号不存在或密码错误！</h3>");
          response.setHeader("refresh", "5;url=loginAdmin.jsp");
          out.println("5秒后返回登录界面，如果没有跳转，请点击<a href='loginAdmin.jsp'>这里</a>");
        }
      }
      catch (SQLException e) {
        e.printStackTrace();
      }

    }
    else if ((action == "logout") || (action.equals("logout"))) {
      response.setHeader("refresh", "0;url=index.html");
      request.getSession().invalidate();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}