package entity;

public class Product
{
  private int proid;
  private String proname;
  private String image;
  private double price;
  private String introduce;

  public int getProid()
  {
    return this.proid;
  }
  public void setProid(int proid) {
    this.proid = proid;
  }
  public String getProname() {
    return this.proname;
  }
  public void setProname(String proname) {
    this.proname = proname;
  }
  public String getImage() {
    return this.image;
  }
  public void setImage(String image) {
    this.image = image;
  }
  public double getPrice() {
    return this.price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public String getIntroduce() {
    return this.introduce;
  }
  public void setIntroduce(String introduce) {
    this.introduce = introduce;
  }
}