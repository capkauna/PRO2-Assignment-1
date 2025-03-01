package Models;

import States.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Vinyl
{
  private VinylState currentState;
  private String name;
  private String artist;
  private int releaseYear;
  private int vinylId;
  private static int nextVinylId = 1;
  private PropertyChangeSupport pcs = new PropertyChangeSupport(this);


public Vinyl(String name, String artist, int releaseYear, int vinylId) {
  this.name = name;
  this.artist = artist;
  this.releaseYear = releaseYear;
  this.vinylId = nextVinylId++; //added this so each new vinyl gets their own id number in order of creation
  currentState = new AvailableState(); //-this line is generate by copilot, but i don t know if it is correct
                                        // yass girl it is <3
}

  public void pressBorrowButton(){
    currentState.onBorrowButtonPress(this);
  }
  public void pressReturnButton(){
    currentState.onReturnButtonPress(this);
  }

  public void pressReserveButton(){
    currentState.onReserveButtonPress(this);
  }
  public void pressUnreserveButton(){
    currentState.onUnreserveButtonPress(this);
  }

  public void pressMarkForRemovalButton(){
    currentState.onMarkForRemovalButtonPress(this);
  }
  public void pressUnmarkForRemovalButton(){
    currentState.onUnmarkForRemovalButtonPress(this);
  }


  public void changeToAvailableState(){
    VinylState oldState = currentState;
    currentState = new AvailableState();
    pcs.firePropertyChange("state", oldState, currentState);
  }
  public void changeToAvailableAndReservedState(){
    VinylState oldState = currentState;
    currentState = new AvailableAndReservedState(this);
    pcs.firePropertyChange("state", oldState, currentState);
  }
  public void changeToBorrowedState(){
    VinylState oldState = currentState;
    currentState = new BorrowedState();
    pcs.firePropertyChange("state", oldState, currentState);
  }
  public void changeToBorrowedAndReservedState(){
    VinylState oldState = currentState;
    currentState = new BorrowedAndReservedState(this);
    pcs.firePropertyChange("state", oldState, currentState);
  }


//
// Getters and Setters:
//

  public VinylState getState() {
    return currentState;
  }

  public String getName() {
    return name;
  }

  public String getArtist() {
    return artist;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public int getVinylId() {
    return vinylId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
  //no setter for vinylId, so it can't be changed outside the constructor

  //
  // Methods for adding and removing listeners:
  //

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    pcs.removePropertyChangeListener(listener);
  }


  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Vinyl vinyl = (Vinyl) obj;
    return vinylId == vinyl.vinylId;
  }

  public String toString() {
    return "Models.Vinyl = " + getName() + '\'' + getArtist() + '\'' + getReleaseYear() +  getVinylId() + currentState.getClass().getSimpleName() ;
  }

  public void returnVinyl()
  {
    currentState = new AvailableState();
  }

  public void reserve()
  {
    if (currentState instanceof  AvailableState){
      currentState = new AvailableAndReservedState();
    }else if (currentState instanceof BorrowedState){
      currentState = new BorrowedAndReservedState();
    }
  }

  public void borrow()
  {if (currentState instanceof AvailableState){
    currentState = new  BorrowedState();
  }
  }
}


