import Models.User;
import Models.*;
import View.VinylView;
import ViewModel.ViewModel;

public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    Vinyl vinyl = new Vinyl("VinylName1", "VinylArtist1", 2021, 1);
    ViewModel viewModel = new ViewModel(vinyl);
    VinylView view = new VinylView(viewModel);

    view.showMenu();

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

    vinyl.getCurrentState().toString();

    User reservingUser = new Models.User("Petrica", 1);
    vinyl.addPropertyChangeListener(reservingUser);
    vinyl.pressReserveButton();
    Thread.sleep(2000);
    vinyl.changeToAvailableAndReservedState();

  }
}

