package States;

import Models.*;

public class BorrowedAndReservedState implements VinylState
{
  private User user;

  public BorrowedAndReservedState(Vinyl vinyl)
  {
    System.out.println(" ");
    System.out.println(" Models.Vinyl is Borrowed by _" + " and reserved by _");
  }

  @Override public void onBorrowButtonPress(Vinyl vinyl){

  }
  @Override public void onReturnButtonPress(Vinyl vinyl){
    // { ... }
    System.out.println(" Returning vinyl ..."); // testing purposes
    vinyl.changeToAvailableAndReservedState();
  }

  @Override public void onReserveButtonPress(Vinyl vinyl)
  {
    if (user.getUserId() == vinyl.getReservingUserId())
    {
      System.out.println(user.getName() + " already reserved this vinyl.");
      return;
    }
    System.out.println(" Vinyl is already reserved.");

  }
  @Override public void onUnreserveButtonPress(Vinyl vinyl){
    // { ... }
    System.out.println(" Removing reservation... ");
    vinyl.unreserve(user);
    if (!vinyl.isReserved())
    {
      vinyl.changeToBorrowedState();
    }
  }

  @Override public void onMarkForRemovalButtonPress(Vinyl vinyl){
    // change flag
    System.out.println("Changing flag to -> For REMOVAL "); // testing
  }
  @Override public void onUnmarkForRemovalButtonPress(Vinyl vinyl){
    // change flag
    System.out.println(" Removing removal flag "); // testing
  }
}
