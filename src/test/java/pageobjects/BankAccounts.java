package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.TestUtilities;

public class BankAccounts
{
  WebDriver webDriver;
  WebDriverWait wait;
  private static final By ADD_BANK_ACCOUNT = By.cssSelector("*[data-automationid='Add Bank Account-button']");
  private static final By BANKS_LIST = By.cssSelector(".ba-banklist");
  private static final By ANZ_BANK = By.cssSelector("*[data-automationid='popularBanksList'] ul li:nth-of-type(1)");
  private static final By USER_ACCOUNT_NAME = By.cssSelector("*[data-automationid='accountName'] input");
  private static final By USER_ACCOUNT_TYPE = By.cssSelector("*[data-automationid='accountType'] input");
  private static final By ACCOUNT_TYPES = By.cssSelector(".ba-combo-list ul li");
  private static final By ACCOUNT_NUMBER = By.cssSelector("#accountnumber-1068-inputEl");
  private static final By CONTINUE_BUTTON = By.cssSelector(".x-container a[data-automationid='continueButton']");
  private static final By XERO_PARTNER_LOGO = By.cssSelector("*[data-automationid='xeroAndPartnersLogos']");
  private static final By ACCOUNTS_ADDED = By.cssSelector("div[data-automationid='account-list']");
  private static final By NAME_OF_ACCOUNT_ADDED = By.cssSelector(".bankaccounts-account--details .bankaccounts-account--name");
  String actualAccountName = "";

  TestUtilities testUtilities = new TestUtilities();

  public BankAccounts(WebDriver driver)
  {
    this.webDriver = driver;
  }

  public void addBankAccount()
  {
    wait = new WebDriverWait(webDriver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_BANK_ACCOUNT));
    webDriver.findElement(ADD_BANK_ACCOUNT).click();
  }

  public void selectANZBank()
  {
    wait = new WebDriverWait(webDriver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(BANKS_LIST));
    webDriver.findElement(ANZ_BANK).click();
  }

  public void enterAccountName(String accname)
  {
    wait = new WebDriverWait(webDriver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(USER_ACCOUNT_NAME));
    webDriver.findElement(USER_ACCOUNT_NAME).sendKeys(accname);
  }

  public void enterBankType(String accountType)
  {
    wait = new WebDriverWait(webDriver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(USER_ACCOUNT_TYPE));
    webDriver.findElement(USER_ACCOUNT_TYPE).click();
    List<WebElement> elementList = webDriver.findElements(ACCOUNT_TYPES);
    for (WebElement acctype : elementList)
    {
      String typename = acctype.getText();
      if (typename.equals(accountType))
        acctype.click();
      else
      {
        new Exception("Selected account type does not exist");
      }
    }
  }

  public void enterBankAccNumber(String bAccountNumber)
  {
    WebElement accountNumber = webDriver.findElement(ACCOUNT_NUMBER);
    wait.until(ExpectedConditions.elementToBeClickable(accountNumber));
    accountNumber.click();
    accountNumber.sendKeys(bAccountNumber);
    testUtilities.pleaseWait(300);
  }

  public void enterDetails(String acName, String acType, String acNumber)
  {
    enterAccountName(acName);
    enterBankType(acType);
    enterBankAccNumber(acNumber);
    webDriver.findElement(CONTINUE_BUTTON).click();
    testUtilities.pleaseWait(10000);
  }

  public boolean verifyBankAccountIsAdded(String accName)
  {
    assert (webDriver.findElement(XERO_PARTNER_LOGO).isDisplayed());
    if (webDriver.findElement(ACCOUNTS_ADDED).isDisplayed())
    {
      List<WebElement> listOfAccounts = webDriver.findElements(NAME_OF_ACCOUNT_ADDED);
        for (WebElement expectedaccname : listOfAccounts)
        {
           actualAccountName = expectedaccname.getText();
          if (actualAccountName.equalsIgnoreCase(accName))
            return true;
        }
      }
    return false;
  }
}
