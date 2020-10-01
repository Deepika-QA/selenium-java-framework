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

  LoginPage login;
  UserDashboard userDashboard;
  BankAccounts bankAccounts;


  @Before
  public void setUpDriver()
  {
    System.setProperty("webdriver.chrome.driver","/Users/sachdd/working/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }


  @Given("^User signed in xero account$")
  public void loginToXeroAccount()
  {
    login = new LoginPage(driver);
    login.loginXeroAccount();
  }

  @When("^User tries to add an ANZ bank account$")
  public void addANZBankAccount()
  {
    clickAccountingMenuAndSelectBanking();
    addBankAccount(ACC_NAME, ACC_TYPE, ACC_NUMBER);
  }

  @Then("^Bank Account is added$")
  public void checkAccountAdded()
  {
    verifyBankAccountIsAdded(ACC_NAME);
  }

  private void clickAccountingMenuAndSelectBanking()
  {
    userDashboard = new UserDashboard(driver);
    userDashboard.clickAccountingMenu();
    userDashboard.selectBankAccountsOption();
  }

  private void addBankAccount(String bname, String acctype, String accnumber)
  {
    bankAccounts = new BankAccounts(driver);
    bankAccounts.addBankAccount();
    bankAccounts.selectANZBank();
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
