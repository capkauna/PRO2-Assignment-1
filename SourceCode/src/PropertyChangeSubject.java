public interface PropertyChangeSubject
{
  void addPropertyChangeListener(PropertyChangeListener listener);
  void removePropertyChangeListener(PropertyChangeListener listener);
  void firePropertyChange(String propertyName, Object oldValue, Object newValue);
}
