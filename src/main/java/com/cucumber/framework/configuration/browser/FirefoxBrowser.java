/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.cucumber.framework.configuration.browser;

import com.cucumber.framework.utility.ResourceHelper;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author rsr
 *
 * Aug 6, 2016
 */
public class FirefoxBrowser {
	
//	public Capabilities getFirefoxCapabilities() {
//		DesiredCapabilities firefox = new DesiredCapabilities();
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setAcceptUntrustedCertificates(true);
//		profile.setAssumeUntrustedCertificateIssuer(true);
////		firefox.setCapability(FirefoxDriver.PROFILE, profile);
//		firefox.setCapability("marionette", true);
//		return firefox;
//	}

	public MutableCapabilities getBrowserOptions() {
		//setting custom profile
		FirefoxProfile profile = new FirefoxProfile();
		//setting options
		FirefoxOptions options = new FirefoxOptions();
		//options.addPreference("network.proxy.type", 0);
		options.setProfile(profile);
		if (Boolean.parseBoolean(System.getProperty("headlessMode"))) {
			options.setHeadless(true);
		}
		return options;
	}

	public WebDriver getFirefoxDriver(MutableCapabilities options) {
//		System.setProperty("webdriver.gecko.driver", BINARY_BROWSER_DRIVER_PATH + "/geckodriver");
//		System.setProperty("webdriver.gecko.driver","G:\\Selenium\\Firefox driver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.marionette",ResourceHelper.getResourcePath("driver/geckodriver"));
		System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("driver/geckodriver"));
		return new FirefoxDriver((FirefoxOptions) options);
	}
	
//	public WebDriver getFirefoxDriver(Capabilities cap) {
//		System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("driver/geckodriver.exe"));
//		return new FirefoxDriver((FirefoxOptions) cap);
//	}
	
//	public WebDriver getFirefoxDriver(String hubUrl,Capabilities cap) throws MalformedURLException {
//		return new RemoteWebDriver(new URL(hubUrl),cap);
//	}

}
