public class User
{
  private String name;
  private int userId;

  public User(String name){
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public int getUserId()
  {
    return userId;
  }

  @Override public String toString()
  {
    return "User: name= " + name + ", userId= " + userId + ".";
  }

  public boolean equals(Object obj){
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    User user = (User) obj;
    return userId == user.userId && name.equals(user.name);
  }
}
