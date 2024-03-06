package entity;

public class Entity {
  private String title;
  private int age;
  private float width;
  
  public Entity(String title, int age, float width) {
    super();
    this.title = title;
    this.age = age;
    this.width = width;
  }
  public String getName() {
    return title;
  }
  public void setName(String name) {
    this.title = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public float getWidth() {
    return width;
  }
  public void setWidth(float width) {
    this.width = width;
  }
  @Override
  public String toString() {
    return "{\"title\": \""+title+"\", \"age\":"+age+", \"width\":"+width+"}";
  }
}