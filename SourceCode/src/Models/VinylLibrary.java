package Models;

import java.util.ArrayList;

public class VinylLibrary
{
  private ArrayList<Vinyl> vinyls;

  public VinylLibrary()
  {
    vinyls = new ArrayList<>();
  }
  public void addVinyl(String title, String artist, int releaseYear, int vinylId)
  {
    vinyls.add(new Vinyl(title, artist, releaseYear, vinylId));
  }
}
