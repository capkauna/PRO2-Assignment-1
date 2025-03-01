package Models;

import java.util.ArrayList;

public class UserList
{
  private ArrayList<User> users;

  public UserList()
  {
    users = new ArrayList<>();
  }
  public void addUser(String name)
  {
    users.add(new User(name));
  }
  public ArrayList<User> getUsers()
  {
    return users;
  }
}
