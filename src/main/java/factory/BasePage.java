package factory;

import org.openqa.selenium.WebDriver;

import static utils.SeleniumUtils.waitForElement;

/**
 * Class to be extended by all Page Objects Model (POM) classes.
 * <p>
 * Contains common methods to be used by every page.
 *
 * @author a.balyabin
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected String pageLocator;
    protected String name;

    protected BasePage(WebDriver driver, String pageLocator, String name) {
        this.driver = driver;
        this.pageLocator = pageLocator;
        this.name = name;
    }


    /**
     * Get the page title
     *
     * @return
     */
    public String getTitle() {
        return driver.getTitle();
    }


    public boolean waitForOpened() {
        return waitForElement(this.driver, this.pageLocator).isDisplayed();
    }
}
