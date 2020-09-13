package com.demoWebShop.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demoWebShop.utilities.TestUtil;
import com.demoWebShop.utilities.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	/*
	 * constructor that intialises confiq.properties file
	 */
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\demoWebShop\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * setups a browser using param from properties file and also intialises the
	 * eventListener before every test case
	 */

	@BeforeMethod
	public static void setUp() {

		browser.initialization(prop.getProperty("browser"));

		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		driver = e_driver.register(eventListener);

		driver.get(prop.getProperty("url"));

	}

	/*
	 * quits and closes the browser after every test case
	 */
	@AfterMethod
	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}

	}

}
