package States;

import Models.*;

public class BorrowedState implements VinylState
{
  private User user;

  public BorrowedState(Vinyl vinyl)
  {
    System.out.println(" ");
    System.out.println(" Models.Vinyl is Borrowed ");
  }

  @Override public void onBorrowButtonPress(Vinyl vinyl){

  }
  @Override public void onReturnButtonPress(Vinyl vinyl){
    // { ... code code <3 ...}
    System.out.println(" Returning vinyl ..."); // testing purposes
    vinyl.changeToAvailableState();
  }

  @Override public void onReserveButtonPress(Vinyl vinyl){
    System.out.println(" Reserving vinyl ... ");
    vinyl.reserve(user);
    if (!vinyl.isMarkedForRemoval())
    {
      vinyl.changeToBorrowedAndReservedState();
      System.out.println("Vinyl reserved by " + user.getName() + ".");
    }
  }
  @Override public void onUnreserveButtonPress(Vinyl vinyl)
  {
    vinyl.unreserve(user);
    vinyl.changeToBorrowedState();
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
