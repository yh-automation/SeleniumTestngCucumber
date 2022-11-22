/**
 * rsr
 * <p>
 * Aug 5, 2016
 */
package com.cucumber.framework.configuration.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumber.framework.utility.DateTimeHelper;
import com.cucumber.framework.utility.ResourceHelper;


/**
 * @author rsr
 *
 *         Aug 5, 2016
 */
public class ChromeBrowser {

    public Capabilities getChromeCapabilities() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        DesiredCapabilities chrome = new DesiredCapabilities();
        chrome.setJavascriptEnabled(true);
        chrome.setCapability(ChromeOptions.CAPABILITY, option);
        return chrome;
    }

    public WebDriver getChromeDriver(Capabilities cap) {
        System.setProperty("webdriver.chrome.driver",
                ResourceHelper.getResourcePath("driver/chromedriver"));
        System.setProperty("webdriver.chrome.logfile",
                ResourceHelper.getResourcePath("logs/chromelogs/")
                        + "chromelog" + DateTimeHelper.getCurrentDateTime()
                        + ".log");
        ChromeOptions options = new ChromeOptions();
        // Proxy proxy = new Proxy();
        // proxy.setHttpProxy("myhttpproxy:3337");
        // options.setCapability("proxy", proxy);
        // options.addArguments("--headless");
        // options.addArguments("--disable-gpu");
        // options.setAcceptInsecureCerts(true);
        // options.addArguments("--allow-insecure-localhost");
        // options.addArguments("--lang=fr-CA");
        options.addArguments("--start-maximized");
        //setting options
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        if (Boolean.parseBoolean(System.getProperty("headlessMode"))) {
            options.setHeadless(false);
        }
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        options.setAcceptInsecureCerts(true);
        options.setCapability("profile.password_manager_enabled", "false");
        return new ChromeDriver(options);
    }

    public WebDriver getChromeDriver(String hubUrl, Capabilities cap) throws MalformedURLException {
        return new RemoteWebDriver(new URL(hubUrl), cap);
    }

}
