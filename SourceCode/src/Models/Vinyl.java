package Models;

import States.*;

public class Vinyl
{
  private VinylState currentState;
  private String name;
  private String artist;
  private int releaseYear;
  private int vinylId;


public Vinyl(String name, String artist, int releaseYear, int vinylId) {
  this.name = name;
  this.artist = artist;
  this.releaseYear = releaseYear;
  this.vinylId = vinylId;
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
    currentState = new AvailableState();
  }
  public void changeToAvailableAndReservedState(){
    currentState = new AvailableAndReservedState(this);
  }
  public void changeToBorrowedState(){
    currentState = new BorrowedState(this);
  }
  public void changeToBorrowedAndReservedState(){
    currentState = new BorrowedAndReservedState(this);
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

  public void setVinylId(int vinylId) {
    this.vinylId = vinylId;
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
}


