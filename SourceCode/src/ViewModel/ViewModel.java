package ViewModel;


import Models.User;
import Models.Vinyl;
import States.AvailableState;
import States.BorrowedState;
import States.BorrowedAndReservedState;
import States.AvailableAndReservedState;
import States.VinylState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


public class ViewModel implements PropertyChangeListener
{
  private Vinyl vinyl;

  public ViewModel(Vinyl vinyl)
  {
    this.vinyl = vinyl;
    vinyl.addPropertyChangeListener (this);
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt)
  {
    System.out.println("State changed: " + evt.getOldValue() + " -> " + evt.getNewValue());
  }

  public void borrowVinyl()
  {
    if (vinyl.getCurrentState() instanceof AvailableState) {
      vinyl.setState(new BorrowedState(vinyl));
    }
  }

  public void reserveVinyl(User user) {
    if (!(vinyl.getCurrentState() instanceof BorrowedAndReservedState)) {
      if (vinyl.getCurrentState() instanceof BorrowedState) {
        vinyl.setState(new BorrowedAndReservedState(vinyl, user));
      } else {
        vinyl.setState(new AvailableAndReservedState(vinyl, user));
      }
    }
  }



}
