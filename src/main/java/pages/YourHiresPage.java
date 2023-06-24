package pages;

import org.openqa.selenium.WebDriver;
import utils.SeleniumUtils;

/**
 * Page Object Model (POM) of the Your Hires page.
 *
 * <p>Contains a navigation method
 *
 * @author a.balyabin
 */
public class YourHiresPage extends BasePage {
    private final WebDriver driver;

    private static final String PAGE_LOCATOR = "//main";
    private static final String FIND_TALENT = "//*[text()='Find Talent']";

    public YourHiresPage(WebDriver driver) {
        super(driver, PAGE_LOCATOR, "Your Hires page");
        this.driver = driver;
    }

    /**
     * Clicks on 'Find talent' button
     */
    public void clickFindTalent() {
        SeleniumUtils.findElement(driver, FIND_TALENT).click();
    }
}
