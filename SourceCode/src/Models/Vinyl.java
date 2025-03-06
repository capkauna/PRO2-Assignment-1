package Models;

import States.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Vinyl
{
  private VinylState currentState;
  private String state; //optional, descriptive text for UI purposes
  private String name;
  private String artist;
  private int releaseYear;
  private int vinylId;
  private static int nextVinylId = 1;
  private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  private boolean reservedFlag;
  private boolean removeFlag;
  private Integer reservingUserId; //Integer can be set to null too, unlike int
  private Integer borrowedByUserId = null; //check borrowing user


public Vinyl(String name, String artist, int releaseYear) {
  this.name = name;
  this.artist = artist;
  this.releaseYear = releaseYear;
  this.vinylId = nextVinylId++; //added this so each new vinyl gets their own id number in order of creation
  currentState = new AvailableState(); //-this line is generate by copilot, but i don t know if it is correct
                                        // yass girl it is <3
  reservedFlag = false;
  removeFlag = false;

}

///
//  Methods for changing the state of the vinyl
//


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
    currentState = new AvailableAndReservedState(this, null);
    pcs.firePropertyChange("state", oldState, currentState);
  }
  public void changeToBorrowedState(){
    VinylState oldState = currentState;
    currentState = new BorrowedState(this);
    pcs.firePropertyChange("state", oldState, currentState);
  }
  public void changeToBorrowedAndReservedState(){
    VinylState oldState = currentState;
    currentState = new BorrowedAndReservedState(this, null);
    pcs.firePropertyChange("state", oldState, currentState);
  }

    //
   //Flag specific methods
  //

  public void reserve (User user)
  {
    if (user == null || getReservingUserId() != null || isMarkedForRemoval())
    {
      throw new IllegalArgumentException("Can not reserve at this time.");
    }
    reservingUserId = user.getUserId();
    reservedFlag = true;
  }
  public void unreserve(User user)
  {
    if (user==null || user.getUserId() != getReservingUserId())
    {
      throw new IllegalArgumentException("Only the user who reserved can cancel this reservation.");
    }
    reservingUserId = null;
    reservedFlag = false;
  }

//
// Getters and Setters:
//

  public VinylState getCurrentState() {
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
String oldName = this.name;
    this.name = name;
    pcs.firePropertyChange("name", oldName, name); // Notify listeners about the change
  }

  public void setArtist(String artist) {
  String oldArtist = this.artist;
    this.artist = artist;
    pcs.firePropertyChange("artist", oldArtist, artist);
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
  //no setter for vinylId, so it can't be changed outside the constructor

  public Integer getReservingUserId() {
    return reservingUserId;
  }
  public boolean isReserved() {
    return reservedFlag;
  }
  public boolean isMarkedForRemoval() {
    return removeFlag;
  }

  public void setMarkedForRemoval(boolean removeFlag) {
    this.removeFlag = removeFlag;
  }

  private void checkMarkedForRemoval() {
    if (removeFlag && currentState instanceof AvailableState) {
      System.out.println("Vinyl is available and marked for removal. Consider removing it!");
    }
  }

  public void setState(VinylState newState) {
    VinylState oldState = this.currentState;
    this.currentState = newState;
    this.state = newState.toString(); // actual state name for UI purposes
    //notify listeners
    firePropertyChange("state", oldState, newState);
  }



  public void getVinylState() {
    System.out.println("Vinyl is in state: " + currentState);
  }

  //
  // Methods for adding and removing listeners:
  //

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    pcs.removePropertyChangeListener(listener);
  }

  // Notify listeners about the change
  public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
    pcs.firePropertyChange(propertyName, oldValue, newValue);
  } //allows us to implement the Observer Pattern and separate the application logic from the graphical interface.

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
      // setState(new AvailableAndReservedState()); ??
      currentState = new AvailableAndReservedState(this, null);
    }else if (currentState instanceof BorrowedState){
      //setState(new BorrowedAndReservedState());??
      currentState = new BorrowedAndReservedState(this, null);
    }
  }

  //this is also updated code, it may prevent from inconsistence behavior in system
  /*public void reserve(User user) {
    if (user == null || reservingUserId != null || isMarkedForRemoval()) {
        throw new IllegalArgumentException("Cannot reserve this vinyl.");
    }
    reservingUserId = user.getUserId();
    reservedFlag = true;
}
 */


  public void borrow()
  {

    if (currentState instanceof AvailableState){
    currentState = new  BorrowedState(this);  // ??it would only change the internal state of a vinyl,
      // but the interface would not be notified of this change.???

      //?? because have implemented the firePropertyChange method, we can use it to notify listeners --
      // VinylState oldState = currentState;
      //        setState(new BorrowedState());  // change currentState to BorrowedState and notify listeners/ui
      //        firePropertyChange("state", oldState, currentState);
      //    }//notify listeners

    }
  }
  /* belove is updated version of this code *somebody check if this is correct
  public void borrow(User user) {
    if (borrowedByUserId != null) {
      throw new IllegalStateException("Vinyl is already borrowed by another user.");
    }
    borrowedByUserId = user.getUserId();
    currentState = new BorrowedState(this);
  }

  public void returnVinyl(User user) {
    if (borrowedByUserId == null || !borrowedByUserId.equals(user.getUserId())) {
      throw new IllegalArgumentException("Only the borrowing user can return this vinyl.");
    }
    borrowedByUserId = null; // Reset borrower
    currentState = new AvailableState();
  }
  */

}


