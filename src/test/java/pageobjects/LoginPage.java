package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
  WebDriver webDriver;
  private static final By EMAIL = By.cssSelector("#email");
  private static final By PASSWORD = By.cssSelector("#password");
  private static final By SUBMIT_BUTTON = By.cssSelector("#submitButton");

  public LoginPage(WebDriver driver)
  {
    this.webDriver = driver;
  }

  public void loginXeroAccount()
  {
    webDriver.get("https://login.xero.com/");
    webDriver.findElement(EMAIL).sendKeys("sachdeva.deepika90@gmail.com");
    webDriver.findElement(PASSWORD).sendKeys("dummy123");
    webDriver.findElement(SUBMIT_BUTTON).click();
  }
}
