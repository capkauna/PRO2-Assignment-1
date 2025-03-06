package Models;

import java.util.ArrayList;

    public class VinylLibrary
    {
      private ArrayList<Vinyl> vinyls;

<<<<<<< HEAD
      public VinylLibrary()
      {
        vinyls = new ArrayList<>();
      }
      public void addVinyl(String title, String artist, int releaseYear, int vinylId)
      {
        vinyls.add(new Vinyl(title, artist, releaseYear, vinylId));
      }
=======
  public VinylLibrary()
  {
    vinyls = new ArrayList<>();
  }
  public void addVinyl(String title, String artist, int releaseYear)
  {
    vinyls.add(new Vinyl(title, artist, releaseYear));
  }
>>>>>>> 24ab121871b42a4d368c3f8661a408be96cbe3bc

      public void addVinyl(Vinyl vinyl)
      { if (vinyl == null) {
        throw new IllegalArgumentException("Vinyl cannot be null");
      }
  vinyls.add(vinyl);
  }

  public void removeVinyl(Vinyl vinyl)
  { if (!vinyls.contains(vinyl)) {
    throw new IllegalArgumentException("Vinyl not found in the library");
  }
  vinyls.remove(vinyl);
  }

  public ArrayList<Vinyl> getAllVinyls() {
    return new ArrayList<>(vinyls); // return copy to avoid some corruption by chatgpt
}
}
