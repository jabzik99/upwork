package factory;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Class responsible to handle the WebDrivers
 *
 * @author a.balyabin
 */
public class BrowserProvider {
    /**
     * Create a driver with the given capabilities.
     *
     * @param browser
     * @param capabilities
     * @return
     */
    public static WebDriver createDriver(Browser browser, DesiredCapabilities capabilities) {
        capabilities.setBrowserName(browser.toString().toLowerCase());
        return browser.initialize(capabilities);
    }

    /**
     * Create a driver with default capabilities.
     *
     * @param browser
     * @return
     */
    public static WebDriver createDriver(Browser browser) {
        return createDriver(browser, new DesiredCapabilities());
    }
}
