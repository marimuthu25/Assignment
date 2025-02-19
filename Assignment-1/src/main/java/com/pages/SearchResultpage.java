package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Helpers.Action;

public class SearchResultpage {
	WebDriver driver;
	Action action;
	
	@FindBy(xpath ="//div[@data-component-type='s-search-result'][1]//h2")
	WebElement firstProduct;
	
	@FindBy(xpath ="//div[@id='centerCol']//span[@class='a-price-whole']")
	WebElement firstProductPrice;
	
	@FindBy(xpath=" //div[@id='centerCol']//span[@class='a-size-base a-color-base']")
	WebElement firstProductRating;
	
	public SearchResultpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickFirstProduct() {
		action.Click(firstProduct);

	}
	
	public String getFirstProductPrice() {
		return firstProductPrice.getText();

	}
	public String getFirstproductRating(){
		return firstProductRating.getText();
	
}

}
