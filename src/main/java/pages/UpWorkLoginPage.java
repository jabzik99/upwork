package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.SeleniumUtils;

/**
 * Page Object Model (POM) of the Up Work login page.
 *
 * <p>Contains the method for login
 *
 * @author a.balyabin
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
     * Enters Username or email address and password and logs in
     *
     * @param username - Username or email
     * @param password - password
     */
    public void loginAs(String username, String password) {
        SeleniumUtils.waitForElement(driver, USERNAME_FIELD)
                .sendKeys(Keys.LEFT_CONTROL + "A" + Keys.BACK_SPACE);
        SeleniumUtils.findElement(driver, USERNAME_FIELD).sendKeys(username);
        SeleniumUtils.findElement(driver, CONTINUE_BUTTON).click();
        SeleniumUtils.waitForElementToBeVisible(driver, PASSWORD_FIELD)
                .sendKeys(Keys.LEFT_CONTROL + "A" + Keys.BACK_SPACE);
        SeleniumUtils.findElement(driver, PASSWORD_FIELD).sendKeys(password);
        SeleniumUtils.findElement(driver, LOGIN_BUTTON).click();
    }
}
