package States;

import Models.Vinyl;

public interface VinylState
{
  void onBorrowButtonPress(Vinyl vinyl);
  void onReturnButtonPress(Vinyl vinyl);

  void onReserveButtonPress(Vinyl vinyl);
  void onUnreserveButtonPress(Vinyl vinyl);

  void onMarkForRemovalButtonPress(Vinyl vinyl);
  void onUnmarkForRemovalButtonPress(Vinyl vinyl);
}
