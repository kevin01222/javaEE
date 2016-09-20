package servlet.Product;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet({"/FileUpload"})
public class FileUpload extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    try
    {
      DiskFileItemFactory factory = new DiskFileItemFactory();

      ServletFileUpload upload = new ServletFileUpload(factory);

      upload.setFileSizeMax(31457280L);

      upload.setSizeMax(83886080L);

      upload.setHeaderEncoding("UTF-8");

      if (ServletFileUpload.isMultipartContent(request))
      {
        List<FileItem> list = upload.parseRequest(request);

        for (FileItem item : list)
        {
          if (item.isFormField())
          {
            String fieldName = item.getFieldName();
            String content = item.getString();

            System.out.println(fieldName + " " + content);
          }
          else
          {
            String fieldName = item.getFieldName();
            String name = item.getName();
            String content = item.getString();
            String type = item.getContentType();
            InputStream in = item.getInputStream();

            String id = UUID.randomUUID().toString();

            name = id + "#" + name;

            String path = getServletContext().getRealPath("/upload");

            File file = new File(path, name);

            item.write(file);
            item.delete();
            System.out.println("表单元素名称" + fieldName + "文件名" + name + "表单元素名称， 对应的数据 " + content + "类型" + type + "文件流" + in + "位置" + path);
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
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}