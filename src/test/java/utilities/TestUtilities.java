package utilities;

public class TestUtilities
{
  public void pleaseWait(int timeInMills)
  {
    try
    {
      Thread.sleep(timeInMills);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
