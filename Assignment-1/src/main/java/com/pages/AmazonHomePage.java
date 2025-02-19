package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Helpers.Action;

public class AmazonHomePage  {
	
	WebDriver driver;
	Action action;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public void EnterProductName(String ProductName) {
		action.TypeandEnter(searchBox, ProductName);
	}

}
