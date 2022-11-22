/**
 * rsr
 * <p>
 * Aug 5, 2016
 */
package com.cucumber.framework.configuration.browser;

import com.cucumber.framework.utility.DateTimeHelper;
import com.cucumber.framework.utility.ResourceHelper;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * @author rsr
 *
 *         Aug 5, 2016
 */
public class ChromeBrowser {

    public MutableCapabilities getBrowserOptions() {
        //setting options
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        if (Boolean.parseBoolean(System.getProperty("headlessMode"))) {
            options.setHeadless(true);
        }
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        options.setAcceptInsecureCerts(true);
        options.setCapability("profile.password_manager_enabled", "false");
        return options;
    }

    public WebDriver getChromeDriver(MutableCapabilities options) {
        System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("driver/chromedriver"));
        System.setProperty("webdriver.chrome.logfile",
                ResourceHelper.getResourcePath("logs/chromelogs/")
                        + "chromelog" + DateTimeHelper.getCurrentDateTime()
                        + ".log");
        return new ChromeDriver((ChromeOptions) options);
    }

    public WebDriver getChromeDriver(String hubUrl, Capabilities cap) throws MalformedURLException {
        return new RemoteWebDriver(new URL(hubUrl), cap);
    }
}
