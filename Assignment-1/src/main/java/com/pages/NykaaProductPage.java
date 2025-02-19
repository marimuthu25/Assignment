package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Helpers.Action;

public class NykaaProductPage {
	WebDriver driver;
	Action action;

	@FindBy(xpath = "//div[@class='css-1d0jf8e']/child::span[@class='css-1jczs19']")
	private WebElement productMRP;

	@FindBy(xpath = "//div[@class='css-vp18r8']/child::button[@class=' css-13zjqg6' and @type='button']")
	private WebElement addToBag;

	@FindBy(xpath = "//button[@id='header-bag-icon']")
	private WebElement shoppingBag;

	@FindBy(xpath = "//span[@class='css-1um1mkq e171rb9k3']")
	private WebElement grandTotal;

	@FindBy(xpath = "//button[@class='css-f1qhpj e8tshxd0']/child::div/child::div")
	private WebElement proceedButton;

	@FindBy(xpath = "//button[@data-testid='button_continueAsGuest']")
	private WebElement continueGuestButton;

	@FindBy(xpath = "//div[@class='css-46b9vi efuv1qx0']/following-sibling::p[@class='css-1e59vjt eka6zu20']")
	private WebElement pricedetails;

	public NykaaProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getProductMRP() {
		return action.getText(productMRP);
	}

	public void ClickAddToBag() {
		action.Click(addToBag);
		System.out.println("Add To Bag is Clicked");
	}

	public void ClickShoppingBag() {
		action.Click(shoppingBag);
		System.out.println("Shopping Bag is Clicked");
	}

	public String getGrantTotal() {
		return action.getText(grandTotal);
	}

	public void ClickProceedButton() {
		action.Click(proceedButton);
		System.out.println("Proceed Button is Clicked");
	}

	public void ClickContinueGuestButton() {
		action.Click(continueGuestButton);
		System.out.println("Continue Guest Button is CLicked");
	}
	
	public String getFinalPriceDetails() {
		return action.getText(pricedetails);
	}
}
