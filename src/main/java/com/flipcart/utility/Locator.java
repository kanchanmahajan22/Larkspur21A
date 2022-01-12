package com.flipcart.utility;

public interface Locator {
	public String homeScreen_closePopUpBtn="XPATH##//button[contains(text(),'x')]";
	public String homeScreen_travelLink ="XPATH##//a[contains(@href,'travel/fli')]";
	String homeScreen_fromCity="XPATH##//label[contains(text(),'From')/parent::div]";
	String homeScreen_srchTxtBx="XPATH##input[placeholder='Search for products,brands and more']";
	String homeScreen_frmCity_BOM="XPATH##//label[contains(text(),\"Popular cities\")]/parent::div/descendant::div[contains(text(),'BOM')]";

}
