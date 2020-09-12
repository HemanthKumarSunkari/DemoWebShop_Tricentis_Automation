package com.demoWebShop.base;

import java.util.Arrays;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browser extends TestBase {

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();

		}
	}
}
