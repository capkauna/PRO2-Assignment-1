package Models;

import java.util.ArrayList;

public class UserList
{
  private ArrayList<User> users;

  public UserList()
  {
    users = new ArrayList<>();
  }
  public void addUser(User name)
  {
    users.add(name);
  }
  public ArrayList<User> getUsers()
  {
    return users;
  }

  public void removeUser(User user)
  {

  }
}
