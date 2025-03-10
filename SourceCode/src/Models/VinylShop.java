package Models;

import States.*;

public class VinylShop {
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
   if (vinyl.getCurrentState() instanceof AvailableState) {
      vinyl.setState(new BorrowedState(vinyl));
      return true;
    }
    return false;
  }
    /*if (vinyl.getState() instanceof AvailableState) { // is not accessible method getState(), maybe do you mean getCurrentState()
      vinyl.borrow();
      return true;
    }
    return false;
  }*/

  public boolean reserveVinyl(User user, Vinyl vinyl) {

    VinylState currentState = vinyl.getCurrentState();

    if (currentState instanceof BorrowedAndReservedState || currentState instanceof AvailableAndReservedState) {
      return false; // is already reserved
    }

    if (currentState instanceof BorrowedState) {
      vinyl.setState(new BorrowedAndReservedState(vinyl, user));
    } else if (currentState instanceof AvailableState) {
      vinyl.setState(new AvailableAndReservedState(vinyl, user));
    } else {
      return false;
    }
    return true;
  }
   /* if (!(vinyl.getState() instanceof BorrowedAndReservedState)) { //check method getState() maybe do you mean getCurrentState()
      vinyl.reserve();
      return true;
    }
    return false;
  }*/

  public void returnVinyl(User user, Vinyl vinyl) {
    vinyl.returnVinyl();
  }
}
