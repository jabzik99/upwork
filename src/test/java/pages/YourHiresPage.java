package pages;

import factory.BasePage;
import org.openqa.selenium.WebDriver;
import utils.SeleniumUtils;

public class YourHiresPage extends BasePage {
    private final WebDriver driver;

    private static final String PAGE_LOCATOR = "//main";
    private static final String FIND_TALENT = "//*[text()='Find Talent']";

    public YourHiresPage(WebDriver driver) {
        super(driver, PAGE_LOCATOR, "Your Hires page");
        this.driver = driver;
    }

    public void clickFindTalent() {
        SeleniumUtils.findElement(driver, FIND_TALENT).click();
    }
}
