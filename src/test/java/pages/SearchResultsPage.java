package pages;

import factory.BasePage;
import org.openqa.selenium.WebDriver;
import utils.SeleniumUtils;

public class SearchResultsPage extends BasePage {
    private final WebDriver driver;

    private static final String PAGE_LOCATOR = "//main";
    private static final String FIND_TALENT = "//*[@class= 'up-user-search']";

    public SearchResultsPage(WebDriver driver) {
        super(driver, PAGE_LOCATOR, "Your Hires page");
        this.driver = driver;
    }

    public void applyFilter() {
       // SeleniumUtils.findElement()
    }
}
