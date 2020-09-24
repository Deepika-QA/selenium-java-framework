package definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.BankAccounts;
import pageobjects.LoginPage;
import pageobjects.UserDashboard;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserStepsDefinition
{
  WebDriver driver;

  private static final String ACC_NAME = "RANDOM" + RandomStringUtils.randomAlphabetic(3);
  private static final String ACC_TYPE = "Everyday (day-to-day)";
  private static final String ACC_NUMBER = "00-0000-0000000-000";


  @Before
  public void setUpDriver()
  {
    System.setProperty("webdriver.chrome.driver","/Users/sachdd/working/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  LoginPage login;
  UserDashboard userDashboard;
  BankAccounts bankAccounts;

  @Given("^User signed in xero account$")
  public void loginToXeroAccount()
  {
    login = new LoginPage(driver);
    login.loginXeroAccount();
  }

  @When("^User tries to add an ANZ bank account$")
  public void addANZBankAccount()
  {
    clickAccountingMenu();
    selectBankAccountsOption();
    clickAddBankAccount();
    selectANZBank();
    enterAccountDetails(ACC_NAME, ACC_TYPE, ACC_NUMBER);
  }

  @Then("^Bank Account is added$")
  public void checkAccountAdded()
  {
    verifyBankAccountIsAdded(ACC_NAME);
  }

  private void clickAccountingMenu()
  {
    userDashboard = new UserDashboard(driver);
    userDashboard.clickAccountingMenu();
  }

  private void selectBankAccountsOption()
  {
   userDashboard = new UserDashboard(driver);
   userDashboard.selectBankAccountsOption();
  }

  private void clickAddBankAccount()
  {
    bankAccounts = new BankAccounts(driver);
    bankAccounts.addBankAccount();
  }

  private void selectANZBank()
  {
    bankAccounts = new BankAccounts(driver);
    bankAccounts.selectANZBank();
  }

  private void enterAccountDetails(String bname, String acctype, String accnumber)
  {
    bankAccounts = new BankAccounts(driver);
    bankAccounts.enterDetails(bname, acctype, accnumber);
  }

  private void verifyBankAccountIsAdded(String bankAccName)
  {
    bankAccounts = new BankAccounts(driver);
    bankAccounts.verifyBankAccountIsAdded(bankAccName);
  }

  @After
  public void quitDriver()
  {
    driver.quit();
  }

}
