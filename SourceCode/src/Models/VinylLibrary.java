package Models;
import States.*;

import java.util.ArrayList;

public class VinylLibrary
{
  private ArrayList<Vinyl> vinyls;

      public VinylLibrary()
      {
        vinyls = new ArrayList<>();
      }


  public void addVinyl(Vinyl vinyl)
    {
      if (vinyl == null)
      {throw new IllegalArgumentException("Vinyl cannot be null");}
      vinyls.add(vinyl);
    }

  public void removeVinyl(Vinyl vinyl)
    {
      if (!vinyls.contains(vinyl))
      {
      throw new IllegalArgumentException("Vinyl not found in the library");
      }
      vinyls.remove(vinyl);
    }

  public ArrayList<Vinyl> getAllVinyls()
    {
      return new ArrayList<>(vinyls); // return copy to avoid corruption
    }

//
//search methods
//

  public ArrayList<Vinyl> getAvailableVinyls()
    {
      ArrayList<Vinyl> availableVinyls = new ArrayList<>();
      for (Vinyl vinyl : vinyls)
      {
        if (vinyl.getCurrentState() instanceof AvailableState)
        {
          availableVinyls.add(vinyl);
        }
      }
      return availableVinyls;
    }

  public ArrayList<Vinyl> getBorrowedVinyls()
    {
      ArrayList<Vinyl> borrowedVinyls = new ArrayList<>();
      for (Vinyl vinyl : vinyls)
      {
        if (vinyl.getCurrentState() instanceof BorrowedState)
        {
          borrowedVinyls.add(vinyl);
        }
      }
      return borrowedVinyls;
    }

  public ArrayList<Vinyl> getReservedVinyls()
    {
      ArrayList<Vinyl> reservedVinyls = new ArrayList<>();
      for (Vinyl vinyl : vinyls)
      {
        if (vinyl.getCurrentState() instanceof AvailableAndReservedState || vinyl.getCurrentState() instanceof BorrowedAndReservedState)
        {
          reservedVinyls.add(vinyl);
        }
      }
      return reservedVinyls;
    }

  public ArrayList<Vinyl> getMarkedForRemovalVinyls()
    {
      ArrayList<Vinyl> markedForRemovalVinyls = new ArrayList<>();
      for (Vinyl vinyl : vinyls)
      {
        if (vinyl.isMarkedForRemoval())
        {
          markedForRemovalVinyls.add(vinyl);
        }
      }
      return markedForRemovalVinyls;
    }

  public ArrayList<Vinyl> getVinylByName(String name)
    {
      ArrayList<Vinyl> vinylsByName = new ArrayList<>();
      for (Vinyl vinyl : vinyls)
      {
        if (vinyl.getName().contains(name)) //allows partial matches because name is a string
        {
          vinylsByName.add(vinyl);
        }
      }
      return vinylsByName;
    }

  public ArrayList<Vinyl> getVinylByArtist(String artist)
    {
      ArrayList<Vinyl> vinylsByArtist = new ArrayList<>();
      for (Vinyl vinyl : vinyls)
      {
        if (vinyl.getArtist().contains(artist)) //allows partial matches because artist is a string
        {
          vinylsByArtist.add(vinyl);
        }
      }
      return vinylsByArtist;
    }
    
  //more search methods can be added, but they are not necessary for the assignment
}
