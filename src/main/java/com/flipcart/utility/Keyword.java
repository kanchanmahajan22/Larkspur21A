package com.flipcart.utility;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	static RemoteWebDriver driver;
	private static WebDriverWait wait;
	private static final Logger LOG=Logger.getLogger(Keyword.class);
	/**
	 * This method will launch specified browser in maximize mode
	 * @param browserName must be one of the following
	 * <ul>
	 * <li>chrome</li>
	 * <li>firefox</li>
	 * <li>edge</li>
	 * </ul>
	 */
	public static void openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
		}else {
			LOG.error("Invalid browserName "+browserName);
		}
			LOG.info("browser launch succesfully");
			wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
	}
	/**
	 * This method will launch the Specified url in currently opened browser
	 * @param url
	 */
	public static void launchUrl(String url) {
		driver.get(url);
	}
	/**
	 * This method will click on element describe by {@code locatorType} and {@codelocatorValue}
	 * locatorType must be one of the following:
	 * <ul>
	 * <li>xpath</li>
	 * <li>css</li>
	 * <li>id</li>
	 * <li>name</li>
	 * </ul>
	 * @param element
	 */
	public static void click(String locatorType, String locatorValue) {
		if(locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("css")){
			driver.findElement(By.xpath(locatorValue)).click();
		}else {
			System.err.println("Invalid locatortype "+locatorType);
		}
			
	}
	@Deprecated
	public static void click(By by) {
		driver.findElement(by).click();
	}
	public static void click(String locator) {
		String parts[]=locator.split("##");
		getWebElement(parts[0],parts[1]).click();
	}
	@Deprecated
	public static void enterText(String locatorType,String locatorValue,String textToEnter) {
	getWebElement(locatorType,locatorValue).sendKeys(textToEnter);	
	}
	public static void enterText(String locator, String textToEnter) {
		String parts[]=locator.split("##");
		getWebElement(parts[0],parts[1]).sendKeys(textToEnter);
	}
	
	public static WebElement getWebElement(String locatorType,String locatorValue) {
		if(locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		}else if(locatorType.equalsIgnoreCase("css")){
			return driver.findElement(By.xpath(locatorValue));
		}else {
			System.err.println("Invalid locatortype "+locatorType);
			return null;
		}	
	}
	public static void waitFor(long duration) {
		try {
			wait.wait(duration);
		} catch (InterruptedException e) {
			System.out.println("wait is interrupted");
			e.printStackTrace();
		}
	}
}
