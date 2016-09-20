package servlet.News;

import dao.NewsDao;
import entity.News;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/DealNewsServlet"})
public class DealNewsServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    String action = request.getParameter("action");

    if ((action == "newsadd") || (action.equals("newsadd")))
    {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");

      String news = request.getParameter("mytextarea");
      System.out.print(news);
      News nes = new News();
      nes.setNews(news);
      NewsDao newsDao = new NewsDao();
      try {
        NewsDao.getConn();
        if (newsDao.addNews(nes) == 1)
          out.println("添加成功！");
        else {
          out.print("添加失败");
        }
        out.print("<a href='ListNewsServlet'>返回</a>");
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
    else if ((action == "newsclear") || (action.equals("newsclear"))) {
      String id = request.getParameter("id");
      int id2 = Integer.parseInt(id);

      News nes = new News();
      nes.setNewsid(id2);

      NewsDao newsDao = new NewsDao();

      if (newsDao.clearNews(nes) == 1)
        out.print("编号为" + id + "的删除成功！！");
      else {
        out.print("删除失败！！");
      }
      out.print("<a href='ListNewsServlet'>返回</a>");
    }
    else if ((action == "newsmodify") || (action.equals("newsmodify"))) {
      String num = request.getParameter("id3");
      int a = Integer.parseInt(num);
      String b = request.getParameter("news3");
      out.print("id=" + a + "的新闻");
      out.print("内容改为" + b);

      News nes = new News();
      nes.setNewsid(a);
      nes.setNews(b);
      NewsDao newsDao = new NewsDao();

      if (newsDao.modifyNews(nes) == 1)
        out.println("修改成功！");
      else {
        out.print("修改失败");
      }
      out.print("<a href='ListNewsServlet'>返回</a>");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}