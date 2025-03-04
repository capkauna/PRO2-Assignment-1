import java.beans.PropertyChangeEvent;

public class VinylObserver implements PropertyChangeListener
{
  @Override public void propertyChange(
      PropertyChangeEvent evt) // called whenever a property changes and a listener is registered
  {
    System.out.println(" ");
    System.out.println(" VinylObserver: Property has changed ");
    System.out.println(" Old Value: " + evt.getOldValue());
    System.out.println(" New Value: " + evt.getNewValue());
  }
}
