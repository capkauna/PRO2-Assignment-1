package Models;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class User implements PropertyChangeListener
{
  private String name;
  private static int nextUserId = 1;
  private int userId;


  public User(String name)
  {
    this.name = name;
    this.userId = nextUserId++;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getUserId()
  {
    return userId;
  }

  //no setter for userId, so it can't be changed outside the constructor

  @Override
  public String toString()

    {
      return "User " + getName() + " id " + getUserId();
     }
  public void propertyChange(PropertyChangeEvent e)
  {
    if ("state".equals(e.getPropertyName()))
    {
      System.out.println("User " + getName() + " is notified that "
          + e.getOldValue().getClass().getSimpleName() + " changed to "
          + e.getNewValue().getClass().getSimpleName());

      //add more logic here
    }
  }
}
