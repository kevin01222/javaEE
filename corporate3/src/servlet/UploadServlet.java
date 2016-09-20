package servlet;

import dao.UserDao;
import entity.Product;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet({"/UploadServlet"})
public class UploadServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    Product pro = new Product();
    try
    {
      DiskFileItemFactory factory = new DiskFileItemFactory();

      ServletFileUpload upload = new ServletFileUpload(factory);

      if (ServletFileUpload.isMultipartContent(request))
      {
        List<FileItem> list = upload.parseRequest(request);

        for (FileItem item : list)
        {
          if (item.isFormField())
          {
            if ("proname".equals(item.getFieldName())) {
              String proname = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
              pro.setProname(proname);
            }
            if ("price".equals(item.getFieldName())) {
              String price = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
              double price2 = Double.parseDouble(price);
              pro.setPrice(price2);
            }
            if ("introduce".equals(item.getFieldName())) {
              String introduce = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
              pro.setIntroduce(introduce);
            }

          }
          else if ("image".equals(item.getFieldName())) {
            String image2 = "picture/" + item.getName();
            System.out.println("--------image2=" + image2);
            pro.setImage(image2);

            String name = item.getName();

            String path = getServletContext().getRealPath("/picture/");

            File file = new File(path, name);

            item.write(file);
            item.delete();
            System.out.println("存入数据库的image2:" + image2 + "文件名name:" + name + "位置:" + path);
          }
        }

      }
      else
      {
        System.out.println("当前表单不是文件上传表单，处理失败！");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    String proname = pro.getProname();
    double price = pro.getPrice();
    String introduce = pro.getIntroduce();
    String image = pro.getImage();

    System.out.print("javabean中的，也是要存入数据库总的：image：" + image + "价格：" + price + "介绍" + introduce + "产品名" + proname);

    int rs = 100;
    try
    {
      Connection con = UserDao.getConn();
      Statement stmt = con.createStatement();
      rs = stmt.executeUpdate("insert into product(proname,price,image,introduce) values ('" + proname + "' , '" + price + "' , '" + image + "' , '" + introduce + "')");
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

    System.out.println("第一个rs：" + rs);

    if (rs == 1)
      out.print("产品为：“" + proname + "”的提交成功");
    else {
      out.print("提交失败！！");
    }
    out.print("<a href='addProduct1.jsp'>返回</a>");
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}