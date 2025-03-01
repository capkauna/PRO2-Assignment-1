package Models;

import States.AvailableState;
import States.AvailableAndReservedState;
import States.BorrowedAndReservedState;
import States.BorrowedState;

class VinylShop {
  private VinylLibrary vinylLibrary;
  private UserList userList;

  public VinylShop() {
    this.vinylLibrary = new VinylLibrary();
    this.userList = new UserList();
  }

  public void addUser(User user) {
    userList.addUser(user);
  }

  public void removeUser(User user) {
    userList.removeUser(user);
  }

  public void addVinyl(Vinyl vinyl) {
    vinylLibrary.addVinyl(vinyl);
  }

  public void removeVinyl(Vinyl vinyl) {
    vinylLibrary.removeVinyl(vinyl);
  }

  public boolean borrowVinyl(User user, Vinyl vinyl) {
    if (vinyl.getState() instanceof AvailableState) {
      vinyl.borrow();
      return true;
    }
    return false;
  }

  public boolean reserveVinyl(User user, Vinyl vinyl) {
    if (!(vinyl.getState() instanceof BorrowedAndReservedState)) {
      vinyl.reserve();
      return true;
    }
    return false;
  }

  public void returnVinyl(User user, Vinyl vinyl) {
    vinyl.returnVinyl();
  }
}
