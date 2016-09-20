package entity;

public class News
{
  private int newsid;
  private String news;

  public void setNewsid(int newsid)
  {
    this.newsid = newsid;
  }
  public void setNews(String news) {
    this.news = news;
  }
  public int getNewsid() {
    return this.newsid;
  }
  public String getNews() {
    return this.news;
  }
}