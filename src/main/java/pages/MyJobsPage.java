package pages;

import org.openqa.selenium.WebDriver;

/**
 * Page Object Model (POM) of My Jobs Page
 *
 * <p>Used to check that the current page is open
 *
 * @author a.balyabin
 */
public class MyJobsPage extends BasePage {

    private final WebDriver driver;

    private static final String PAGE_LOCATOR = "//*[@class='layout-page-content']";

    public MyJobsPage(WebDriver driver) {
        super(driver, PAGE_LOCATOR, "My Jobs page");
        this.driver = driver;
    }
}
