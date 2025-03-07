package Models;

public class User
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

  public void reserveVinyl(Vinyl vinyl)
  {
    vinyl.pressReserveButton();
  }
  public void borrowVinyl(Vinyl vinyl)
  {
    vinyl.pressBorrowButton();
  }

}
