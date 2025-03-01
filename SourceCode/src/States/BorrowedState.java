package States;

import Models.Vinyl;

public class BorrowedState implements VinylState
{
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
    // { ... more code ... maybe ... }
    System.out.println(" Reserving vinyl ... "); // testing purposes
    vinyl.changeToBorrowedAndReservedState();
  }
  @Override public void onUnreserveButtonPress(Vinyl vinyl){

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
