package States;

import Models.*;

public class AvailableState implements VinylState
{
  private User user;

  public AvailableState()
  {
    System.out.println(" Vinyl is Available ");
  }

  @Override
  public void onBorrowButtonPress(Vinyl vinyl)
    {
      if (!vinyl.isMarkedForRemoval())
      {
        vinyl.borrow(user);
        vinyl.changeToBorrowedState();
        System.out.println("Borrowing available vinyl ...");
      }
        System.out.println("Cannot borrow vinyl: It is marked for removal.");
    }

  @Override
  public void onReturnButtonPress(Vinyl vinyl)
    {
      System.out.println("Cannot return vinyl: It is not currently borrowed.");
    }

  @Override public void onReserveButtonPress(Vinyl vinyl)
    {
      vinyl.reserve(user);//checks for markedforremoval and adds the flag
      System.out.println(" Reserving available vinyl ... " + " to " + user.getName() + user.getUserId()); // testing purposes
      vinyl.changeToAvailableAndReservedState();
    }
  @Override public void onUnreserveButtonPress(Vinyl vinyl)
    {
      vinyl.unreserve(user);//checks for reservinguserid and removes the flag
      System.out.println("Reservation cancelled");
    }

  @Override public void onMarkForRemovalButtonPress(Vinyl vinyl)
    {
    if (!vinyl.isMarkedForRemoval()) {
      vinyl.setMarkedForRemoval(true);
      System.out.println("Changing flag to -> For REMOVAL");
    }
      System.out.println("Vinyl is already marked for removal.");
    }
  @Override public void onUnmarkForRemovalButtonPress(Vinyl vinyl)
    {
      if (vinyl.isMarkedForRemoval()) {
        vinyl.setMarkedForRemoval(false);
        System.out.println("Removing removal flag");
      }
        System.out.println("Vinyl is not marked for removal.");
    }

}
