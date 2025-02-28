public class AvailableAndReservedState implements VinylState
{
  public AvailableAndReservedState(Vinyl vinyl)
  {
    System.out.println(" ");
    System.out.println(" Vinyl is Available" + " and reserved by _");
  }

  @Override public void onBorrowButtonPress(Vinyl vinyl){
    // { ... code ... }
    // if its the person that reserved it
    System.out.println(" Borrowing vinyl ..."); //testing purposes
    vinyl.changeToBorrowedState();
    // else
    // do nothing / display Cant be borrowed
  }
  @Override public void onReturnButtonPress(Vinyl vinyl){

  }

  @Override public void onReserveButtonPress(Vinyl vinyl){

  }
  @Override public void onUnreserveButtonPress(Vinyl vinyl){
    // { ... code ... }
    System.out.println(" Unreserving vinyl ... "); // testing purposes
    vinyl.changeToAvailableState();
  }

  @Override public void onMarkForRemovalButtonPress(Vinyl vinyl){
    // change flags
    System.out.println("Changing flag to -> For REMOVAL "); // testing
  }
  @Override public void onUnmarkForRemovalButtonPress(Vinyl vinyl){
    // change flags
    System.out.println(" Removing removal flag "); // testing
  }
}
