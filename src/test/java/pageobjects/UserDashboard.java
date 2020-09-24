package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDashboard
{
  WebDriver webDriver;
  private static final By ACCOUNTING_MENU = By.cssSelector(".xrh-header--main ol li button[name='navigation-menu/accounting']");
  private static final By BANK_ACCOUNTS = By.cssSelector(".xrh-dropdown--body a[data-name='navigation-menu/accounting/bank-accounts']");

  public UserDashboard(WebDriver driver)
  {
    this.webDriver = driver;
  }

  public void clickAccountingMenu()
  {
    WebDriverWait wait = new WebDriverWait(webDriver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNTING_MENU));
    webDriver.findElement(ACCOUNTING_MENU).click();
  }

  public void selectBankAccountsOption()
  {
    webDriver.findElement(BANK_ACCOUNTS).click();
  }

}
