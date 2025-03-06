package View;

import Models.User;
import ViewModel.ViewModel;

import java.util.Scanner;

public class VinylView
{
  private ViewModel viewModel;

  public VinylView(ViewModel viewModel)
  {
    this.viewModel = viewModel;
  }

  public void showMenu(){
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("1. Borrow Vinyl");
      System.out.println("2. Reserve Vinyl");
      System.out.println("3. Exit");
      int status = scanner.nextInt();

      switch (status) {
        case 1:
          viewModel.borrowVinyl();
          break;
        case 2:
          System.out.println("Enter user ID:");
          int userId = scanner.nextInt();
          System.out.println("Enter user name:");
          String userName = scanner.next();
          User user = new User(userName, userId);
          viewModel.reserveVinyl(user);
          break;
        case 3:
          System.out.println("Exiting...");
          return;
        default:
          System.out.println("Invalid option!");
      }
    }
  }
}
