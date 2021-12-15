package pages;

import org.openqa.selenium.WebDriver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Page Object Model (POM) of the Search Results Page.
 *
 * <p> Contains the methods for work with filters
 *
 * @author a.balyabin
 */
public class SearchResultsPage extends BasePage {
  private final WebDriver driver;

  private static final String PAGE_LOCATOR = "//main";
  private static final String LOCATION = "//input[@placeholder='Search locations']";
  private static final String SEARCHED_LOCATION_LOCATOR =
      LOCATION + "/ancestor::div[@class='mt-10']//li[@role='option'][2]";
  private static final String TALENT_LOCATIONS =
      "//*[contains(@class, 'up-card-section')]//span[@itemprop='country-name']";

  public SearchResultsPage(WebDriver driver) {
    super(driver, PAGE_LOCATOR, "Your Hires page");
    this.driver = driver;
  }

  /**
   * Filters by location
   *
   * @param location - "location" by which the filter will be applied
   */
  public void applyLocationFilter(String location) {
    SeleniumUtils.findElement(driver, LOCATION).sendKeys(location);
    SeleniumUtils.waitForElement(driver, SEARCHED_LOCATION_LOCATOR).click();
  }

  /**
   * Gets a list of location for all talents on the page
   *
   * @return List<String> This returns a list of Strings of all talent countries
   */
  public List<String> getAllTalentLocationNames() {
    List<String> list = new ArrayList<>();
    SeleniumUtils.waitForElements(driver, TALENT_LOCATIONS)
        .forEach(location -> list.add(location.getText()));
    return list;
  }
}
