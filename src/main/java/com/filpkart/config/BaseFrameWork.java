package com.filpkart.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.flipcart.utility.Keyword;


public class BaseFrameWork extends Keyword {
 static RemoteWebDriver driver;
	@BeforeMethod
	public void setUp()  {
	openBrowser("chrome");
	launchUrl("https://www.flipkart.com");
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();	
	}

}
