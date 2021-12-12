package pages;

import enums.dropdowns.TalentItems;
import factory.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;

public class HomePage extends BasePage {

    private final WebDriver driver;

    private static final String PAGE_LOCATOR = "//*[@class='layout-page-content']";
    private static final String DROP_DOWN_LOCATOR = "//a[@href='/browse/bench']//span[text()='Talent']";

    public HomePage(WebDriver driver) {
        super(driver, PAGE_LOCATOR, "My Jobs page");
        this.driver = driver;
    }

    public void navigateDropdownItem(TalentItems item) {
        WebElement menu = SeleniumUtils.findElement(driver, DROP_DOWN_LOCATOR);
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor)driver).executeScript(javaScript, menu);
        SeleniumUtils.findElement(driver, String.format("//a[contains(text(), '%s')]", item.getItemName())).click();
    }
}
