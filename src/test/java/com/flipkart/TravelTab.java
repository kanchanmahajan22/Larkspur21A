package com.flipkart;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static com.flipcart.utility.Keyword.*;
import com.flipcart.utility.Keyword;
import com.flipcart.utility.Locator;
public class TravelTab {
	private static final Logger LOG=Logger.getLogger(Keyword.class);
	@Test
	public void verifyErrorOnSelectingSameCitiesAsSourceAndDestination() {
		openBrowser("chrome");
		launchUrl("https://www.flipkart.com");
		waitFor(3000);
		click(Locator.homeScreen_closePopUpBtn);
		click(Locator.homeScreen_travelLink);
		waitFor(5000);
		click(Locator.homeScreen_fromCity);
		waitFor(2000);
		click(Locator.homeScreen_frmCity_BOM);
	}
	@Test
	public void searchResultsForShoes() {
		enterText(Locator.homeScreen_srchTxtBx , "Shoes");
	}
}
