package States;

import Models.Vinyl;

public class BorrowedState implements VinylState
{
  public BorrowedState(Vinyl vinyl)
  {
    System.out.println(" ");
    System.out.println(" Models.Vinyl is Borrowed ");
  }
  @Override
  public void onBorrowButtonPress(Vinyl vinyl) {
    System.out.println("Cannot borrow vinyl: It is already borrowed.");
  }

  @Override
  public void onReturnButtonPress(Vinyl vinyl) {
    System.out.println("Returning vinyl ..."); // Testing purposes
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
    System.out.println("Vinyl is currently borrowed but marked for removal after return.");
    vinyl.setMarkedForRemoval(true);
  }
  @Override public void onUnmarkForRemovalButtonPress(Vinyl vinyl){
    // change flag
    vinyl.setMarkedForRemoval(false);
    System.out.println("Vinyl is no longer marked for removal.");
  }
}
