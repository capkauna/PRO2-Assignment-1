import Backlog.User;
import Models.*;

public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    Vinyl vinyl = new Vinyl("VinylName1", "VinylArtist1", 2021, 1);

    vinyl.pressReserveButton();
    Thread.sleep(2000);
    vinyl.pressUnreserveButton();
    Thread.sleep(2000);
    vinyl.pressBorrowButton();
    Thread.sleep(2000);
    vinyl.pressReturnButton();
    Thread.sleep(2000);

    vinyl.pressBorrowButton();
    Thread.sleep(2000);
    vinyl.pressReserveButton();
    Thread.sleep(2000);
    vinyl.pressReturnButton();
    Thread.sleep(2000);
    vinyl.pressUnreserveButton();
    Thread.sleep(2000);

// adding example for user being added as listener and triggered through
    // the propertyChange method

    User reservingUser = new Backlog.User("Petrica");
    vinyl.addPropertyChangeListener(reservingUser);
    vinyl.pressReserveButton();
    Thread.sleep(2000);
    vinyl.changeToAvailableAndReservedState();;



  }
}