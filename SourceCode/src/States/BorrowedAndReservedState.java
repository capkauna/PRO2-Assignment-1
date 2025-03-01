package States;

import Models.Vinyl;

public class BorrowedAndReservedState implements VinylState
{
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

  @Override public void onReserveButtonPress(Vinyl vinyl){

  }
  @Override public void onUnreserveButtonPress(Vinyl vinyl){
    // { ... }
    System.out.println(" Models.Vinyl has been Unreserved ... "); //test purposes
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
