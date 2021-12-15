package tests;

import enums.Browser;
import factory.BrowserProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.MyJobsPage;
import pages.SearchResultsPage;
import pages.UpWorkLoginPage;
import pages.YourHiresPage;
import utils.PropertiesUtil;
import utils.SoftAssert;

import static enums.dropdowns.TalentItems.YOUR_HIRES;

/**
 * Test case with TestNG
 *
 * @author a.balyabin
 */
@Test
public class UpWorkTests {
  private WebDriver driver;

  private static final String TESTED_LOCATION = "Russia";

  /** This method will be executed before the test start. */
  @BeforeSuite
  public void initialize() {
    driver = BrowserProvider.createDriver(Browser.CHROME);
    driver.manage().window().maximize();
  }

  /** This method perform a filter talents test. */
  @Test
  public void filterTalentsTest() throws InterruptedException {
    // Navigate to login page
    driver.get(PropertiesUtil.getProperty("environment.url"));
    UpWorkLoginPage upWorkLoginPage = new UpWorkLoginPage(driver);
    Assert.assertTrue(upWorkLoginPage.waitForOpened(), "Login page should be opened");

    // login
    upWorkLoginPage.loginAs(
        PropertiesUtil.getProperty("environment.username"), "environment.password");
    MyJobsPage myJobsPage = new MyJobsPage(driver);
    Assert.assertTrue(myJobsPage.waitForOpened(), "Home page should be opened");

    // navigate to talent page
    myJobsPage.navigateDropdownItem(YOUR_HIRES);
    YourHiresPage yourHiresPage = new YourHiresPage(driver);
    yourHiresPage.clickFindTalent();

    // filter location
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    searchResultsPage.applyLocationFilter(TESTED_LOCATION);

    // check all talents location
    for (String location : searchResultsPage.getAllTalentLocationNames()) {
      SoftAssert.getInstance()
          .assertTrue(
              location.equals(TESTED_LOCATION),
              String.format("All talents should have %s location", TESTED_LOCATION));
    }
  }

  /** This method will be executed at the end of the test. */
  @AfterSuite
  public void quitDriver() {
    driver.quit();
    driver = null;
  }
}

