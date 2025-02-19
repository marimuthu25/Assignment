package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Helpers.Action;

public class NykaaHomePage {

	
	WebDriver driver;
	Action action;
	
	@FindBy(xpath="//input[@name='search-suggestions-nykaa']")
	private WebElement searchBox;
	
	

	public NykaaHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public void EnterProductName(String productName) {
		action.TypeandEnter(searchBox, productName);
	}

}


