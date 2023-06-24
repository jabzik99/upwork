package pages;

import enums.dropdowns.TalentItems;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;

import static utils.SeleniumUtils.waitForElement;

/**
 * Class to be extended by all Page Objects Model (POM) classes.
 *
 * <p>Contains common methods to be used by every page.
 *
 * @author a.balyabin
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected String pageLocator;
    protected String name;
    protected static final String DROP_DOWN_LOCATOR =
            "//a[@href='/browse/bench']//span[text()='Talent']";

    protected BasePage(WebDriver driver, String pageLocator, String name) {
        this.driver = driver;
        this.pageLocator = pageLocator;
        this.name = name;
    }

    /**
     * Get the page title
     *
     * @return String This returns the page title
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Waits and check that page is open
     *
     * @return
     */
    public boolean waitForOpened() {
        return waitForElement(this.driver, this.pageLocator).isDisplayed();
    }

    /**
     * Hover over dropdown and clicks on a dropdown item (at this stage of the project it has been
     * implemented only for one dropdown, but in the future the method can be reworked into a common
     * one for all dropdowns)
     *
     * @param item - 'Talent' dropdown item
     */
    public void navigateDropdownItem(TalentItems item) {
        WebElement menu = SeleniumUtils.findElement(driver, DROP_DOWN_LOCATOR);
        String javaScript =
                "var evObj = document.createEvent('MouseEvents');"
                        + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                        + "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(javaScript, menu);
        SeleniumUtils.findElement(
                        driver, String.format("//a[contains(text(), '%s')]", item.getItemName()))
                .click();
    }
}
