package com.qa.seleniumdockerintegration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxStandAloneTest {

	public static void main(String[] args) throws MalformedURLException {
		
		// to run our test using docker we need to use RemoteWebDriver
		URL url = new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());

	}

}
