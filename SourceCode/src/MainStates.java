public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    Vinyl vinyl = new Vinyl();

    vinyl.pressReserveButton();
    Thread.sleep(2000);
    vinyl.pressUnreserveButton();
    Thread.sleep(2000);
    vinyl.pressBorrowButton();
    Thread.sleep(2000);
    vinyl.pressReturnButton();
    Thread.sleep(2000);

    vinyl.pressBorrowButton();
    Thread.sleep(2000);
    vinyl.pressReserveButton();
    Thread.sleep(2000);
    vinyl.pressReturnButton();
    Thread.sleep(2000);
    vinyl.pressUnreserveButton();
    Thread.sleep(2000);




  }
}