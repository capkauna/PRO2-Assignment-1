package ViewModel;


import Models.User;
import Models.Vinyl;
import States.AvailableState;
import States.BorrowedState;
import States.BorrowedAndReservedState;
import States.AvailableAndReservedState;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


public class VinylViewModel implements PropertyChangeListener
{
  private Vinyl vinyl;

  public VinylViewModel(Vinyl vinyl)
  {
    this.vinyl = vinyl;
    vinyl.addPropertyChangeListener (this);
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt)
  {
    System.out.println("State changed: " + evt.getOldValue() + " -> " + evt.getNewValue());
  }

  public void borrowVinyl(int vinylId)
  {
    if (vinyl.getCurrentState() instanceof AvailableState) {
      vinyl.setState(new BorrowedState(vinyl));
    }
  }

  public void reserveVinyl(int vinylId, User user) {
    if (!(vinyl.getCurrentState() instanceof BorrowedAndReservedState)) {
      if (vinyl.getCurrentState() instanceof BorrowedState) {
        vinyl.setState(new BorrowedAndReservedState(vinyl, user));
      } else {
        vinyl.setState(new AvailableAndReservedState(vinyl, user));
      }
    }
  }

  public void returnVinyl(int vinylId)
  {
  }

  public ObservableList<Vinyl> getVinyls()
  {
    return null;
  }
}
