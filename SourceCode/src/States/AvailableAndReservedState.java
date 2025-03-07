package States;

import Models.*;

public class AvailableAndReservedState implements VinylState
{
  private User user;

  public AvailableAndReservedState(Vinyl vinyl, User reservingUser)
    {
      this.user = reservingUser;
      System.out.println("Vinyl " + vinyl.getName() + "is Available" + " and reserved by" + reservingUser.getName());
    }

  @Override   public void onBorrowButtonPress(Vinyl vinyl) {
    if (user.getUserId() == vinyl.getReservingUserId()) {
      System.out.println("Borrowing vinyl ..."); // Testing purposes
      vinyl.changeToBorrowedState();
    } else {
      System.out.println("Cannot borrow vinyl: Reserved by another user.");
    }
  }
  @Override
  public void onReturnButtonPress(Vinyl vinyl) {
    System.out.println("Cannot return vinyl: It is not currently borrowed.");
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
  @Override public void onUnreserveButtonPress(Vinyl vinyl)
  {
    System.out.println(" Removing reservation on vinyl ... " + vinyl.getName() + " for " + user.getName()); // testing purposes
    vinyl.unreserve(user);
    if (!vinyl.isReserved())
    {
      vinyl.changeToAvailableState();
    }
  }

  @Override public void onMarkForRemovalButtonPress(Vinyl vinyl){
    // change flags
    System.out.println("Vinyl is reserved but marked for removal after reservation ends.");
    vinyl.setMarkedForRemoval(true);
  }
  @Override public void onUnmarkForRemovalButtonPress(Vinyl vinyl){
    vinyl.setMarkedForRemoval(false);
    System.out.println("Vinyl is no longer marked for removal.");
  }
}
