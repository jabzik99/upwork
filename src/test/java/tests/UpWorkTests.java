package tests;

import enums.Browser;
import enums.dropdowns.TalentItems;
import factory.BrowserProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UpWorkLoginPage;
import pages.YourHiresPage;

import static enums.dropdowns.TalentItems.YOUR_HIRES;
import static org.testng.Assert.assertTrue;

/**
 * Example of a test case using TestNG
 *
 * @author ejunior
 */
@Test
public class UpWorkTests {
    private WebDriver driver;

    /**
     * This method will be executed before the test start.
     */
    @BeforeSuite
    public void initalize() {
        driver = BrowserProvider.createDriver(Browser.CHROME);
        driver.manage().window().maximize();
    }

    /**
     * This method perform a google search test. We can have multiple @Test methods inside this class.
     */
//    @Test
//    public void googleSearchTest() {
//        driver.get("http://www.google.com");
//
//        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
//        GoogleResultsPage googleResultsPage = googleHomePage.searchFor("Selenium with java");
//
//        assertTrue(googleResultsPage.getTitle().equals("Selenium with java - Pesquisa Google"));
//        assertTrue(googleResultsPage.isResultPresent("Selenium Tutorial"));
//    }

    @Test
    public void filterTalentsTest() {
        //Navigate to login page
        driver.get("https://www.upwork.com/ab/account-security/login");
        UpWorkLoginPage upWorkLoginPage = new UpWorkLoginPage(driver);
        Assert.assertTrue(upWorkLoginPage.waitForOpened(), "Login page should be opened");

        // login
        upWorkLoginPage.loginAs("tt5758606@gmail.com", "tt57586061414");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.waitForOpened(), "Home page should be opened");


        //navigate to talent page
        homePage.navigateDropdownItem(YOUR_HIRES);

        YourHiresPage yourHiresPage = new YourHiresPage(driver);


    }

    /**
     * This method will be executed at the end of the test.
     */
    //  @AfterSuite
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
