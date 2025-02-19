package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Helpers.Action;

public class ProductPage {

	WebDriver driver;
	Action action;
	@FindBy(id = "add-to-cart-button")
	WebElement addToCartButton;

	@FindBy(xpath = "//span[@id='buyBackApplyButton-announce']")
	WebElement cardButton;

	@FindBy(xpath = "//div[@class='a-box-group sc-buy-box-group']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	WebElement cardSubtotal;

	@FindBy(xpath = "//span[@class='a-truncate-cut']")
	WebElement productTitle;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickaddToCardButton() {
		action.Click(addToCartButton);
	}

	public void clickCardButton() {
		action.Click(cardButton);
		System.out.println("Add to Card Button is Clicked");
	}

	public String getCardSubTotal() {
		return cardSubtotal.getText();
	}
	
	public String getProductTitle(){
		return productTitle.getText();
		
	}

}
