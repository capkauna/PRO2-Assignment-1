package Models;

import java.util.ArrayList;

public class UserList
{
  private ArrayList<User> users;

  public UserList()
  {
    users = new ArrayList<>();
  }
  public void addUser(User user)
  {
    users.add(user);
  }
  public ArrayList<User> getUsers()
  {
    return users;
  }

  public void removeUser(User user)
  {
    users.remove(user);
  }


  public User getUser(int index)//get user by index
  {
    return users.get(index);
  }


  public void clear()
  {
    users.clear();
  }

  public void printUsers()
  {
    for (User user : users)
    {
      System.out.println(user);
    }
  }


  public User getUser(String name) //get user by name
  {
    for (User user : users)
    {
      if (user.getName().equals(name))
      {
        return user;
      }
    }
    return null;
  }

}
