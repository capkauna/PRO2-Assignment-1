package States;

import Models.Vinyl;

public class AvailableState implements VinylState
{
  public AvailableState()
  {
    System.out.println(" ");
    System.out.println(" Models.Vinyl is Available ");
  }

  @Override public void onBorrowButtonPress(Vinyl vinyl){
    // { ... check conditions + change flags ... }
    // (if it's not flagged for removal etc ...)
    System.out.println(" Borrowing available vinyl ... "); //testing purposes
    vinyl.changeToBorrowedState();
  }
  @Override public void onReturnButtonPress(Vinyl vinyl){
    // do nothing
  }

  @Override public void onReserveButtonPress(Vinyl vinyl){
    // { ... if it's not marked for removal ... }
    System.out.println(" Reserving available vinyl ... "); // testing purposes
    vinyl.changeToAvailableAndReservedState();
  }
  @Override public void onUnreserveButtonPress(Vinyl vinyl){
    // { ... change flag ... }
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
