package dao;

import entity.News;
import java.sql.ResultSet;

public class NewsDao extends DBoper
{
  public int addNews(News news)
  {
    String sql = "insert into news (news) values(?)";
    String[] params = { news.getNews() };
    int result = executeUpdate(sql, params);
    return result;
  }
  public int clearNews(News news) {
    String sql = "delete from news where newsid=?";
    String[] params = { news.getNewsid()+"" };
    int result = executeUpdate(sql, params);
    return result;
  }
  public int modifyNews(News news) {
    String sql = "update news set news=? where newsid=?";
    String[] params = { news.getNews(), news.getNewsid()+"" };
    int result = executeUpdate(sql, params);
    return result;
  }
  public ResultSet listNews() {
    String sql = "select * from news";
    String[] params = { "" };
    ResultSet rs = executeQuery(sql, params);
    return rs;
  }
}