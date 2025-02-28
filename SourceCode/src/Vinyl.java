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
 // this.currentState = new Available(); -this line is generate by copilot, but i don t know if it is correct

}

  public VinylState getState() {
    return currentState;
  }

  public void setState(VinylState state) {
    this.currentState = state;
  }

  public void borrow() {
    currentState.borrow(this);
  }

  public void reserve() {
    currentState.reserve(this);
  }

  public void returnVinyl() {
    currentState.returnVinyl(this);
  }
/* i don t know if i need this methods, but i write them because copilot suggest me to write them :))
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
  */

  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Vinyl vinyl = (Vinyl) obj;
    return vinylId == vinyl.vinylId;
  }

  public String toString() {
    return "Vinyl = " + name + '\'' + artist + '\'' + + releaseYear + + vinylId + currentState.getClass().getSimpleName() ;
  }
}


