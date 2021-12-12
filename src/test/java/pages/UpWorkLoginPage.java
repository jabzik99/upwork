package pages;

import factory.BasePage;
import org.openqa.selenium.WebDriver;
import utils.SeleniumUtils;

/**
 * Page Object Model (POM) of the Up Work login page.
 * <p>
 * All elements of the page that will be used must be instantiated with their respectives xpath.
 *
 * @author abalyabin
 */
public class UpWorkLoginPage extends BasePage {
    private WebDriver driver;

    private static final String PAGE_LOCATOR = "//form[@id='login']";

    private static final String USERNAME_FIELD = "//input[@id='login_username']";
    private static final String PASSWORD_FIELD = "//input[@id='login_password']";
    private static final String CONTINUE_BUTTON = "//button[@id='login_password_continue']";
    private static final String LOGIN_BUTTON = "//button[@id='login_control_continue']";

    public UpWorkLoginPage(WebDriver driver) {
        super(driver, PAGE_LOCATOR, "Login page");
        this.driver = driver;
    }


    /**
     * Performs a simple google search and return the next page.
     *
     * @param username - Username or email
     * @param password - password
     */
    public void loginAs(String username, String password) {
        SeleniumUtils.waitForElement(driver, USERNAME_FIELD).sendKeys(username);
        SeleniumUtils.waitForElement(driver, CONTINUE_BUTTON).click();
        SeleniumUtils.waitForElementToBeVisible(driver, PASSWORD_FIELD).sendKeys(password);
        SeleniumUtils.waitForElement(driver, LOGIN_BUTTON).click();
    }
}
