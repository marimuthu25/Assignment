package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Helpers.Action;

public class NykaaLorealPage {

	WebDriver driver;
	Action action;
	
	@FindBy(xpath = "///h1[@class='css-c0pzm0']")
	private WebElement pageTitle;

	@FindBy(xpath = "//span[@class='sort-name']")
	private WebElement sortByButton;

	@FindBy(xpath = "//input[@id='radio_customer top rated_undefined' and @type='radio']")
	private WebElement CustomerTopRatedRadioButton;

	@FindBy(xpath = "//div[@class='filter-open css-1gdff5r']/child::span[contains(text(),'Category')]")
	private WebElement Category;

	@FindBy(xpath = "//ul[@id='custom-scroll']/child::ul/child::li/child::div/child::span[contains(text(),'Hair')]")
	private WebElement Hair_Category;

	@FindBy(xpath = "//span[contains(text(),'Hair Care')]")
	private WebElement Hair_Care_Category;

	@FindBy(xpath = "//input[@id='checkbox_Shampoo_316' and @type='checkbox']")
	private WebElement Shampoo_Category;

	@FindBy(xpath = "//div[@class='filter-open css-1gdff5r']/child::span[contains(text(),'Concern')]")
	private WebElement concern;

	@FindBy(xpath = "///input[@id ='checkbox_Colour Protection_229250' and @type='checkbox']")
	private WebElement colourProduction;

	@FindBy(xpath = "//span[contains(@class, 'filter-value') and text()='Shampoo']")
	private WebElement filters;

	@FindBy(xpath = "//div[@class='css-xrzmfa' ]")
	private WebElement pariscolourShampoo;

	public NykaaLorealPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public String getPageTitle() {
		return action.getText(pageTitle);
	}

	public void ClicksortButton() {
		action.ScrollToElement(sortByButton);
		action.Click(sortByButton);

	}

	public void SortedByCustomerRated() {
		CustomerTopRatedRadioButton.isSelected();
		String radioattr = CustomerTopRatedRadioButton.getAttribute("checked");
		if (radioattr.equalsIgnoreCase("true")) {
			System.out.println("Sorted by Customer Top Rated");
		} else {
			System.out.println("Not Sorted");
		}

	}

	public void ClickCategory() {
		action.Click(Category);
		System.out.println("Clicked Categories");

	}

	public void ClickHairCategory() {
		action.Click(Hair_Category);
		System.out.println("Clicked Hair Categories");
	}

	public void ClickHairCareCategory() {
		action.Click(Hair_Care_Category);
		System.out.println("Clicked Hair Care Categories");
	}

	public void ClickShampooCategory() {
		action.Click(Shampoo_Category);
		System.out.println("Clicked Shampoo Categories");
	}

	public void ClickConcern() {
		action.Click(concern);
		System.out.println("Clicked Concern");
	}

	public void ClickColourProduction() {
		action.Click(colourProduction);
		System.out.println("Clicked COlour Production");

	}
	
	public boolean isShapmpooFilterApplied() {
		return filters.isDisplayed();
	}

	public String VerifyFilters() {
		return filters.getText();

	}

	public void Click_LOreal_Paris_Colour_Protect_Shampoo() {
		action.Click(pariscolourShampoo);
		System.out.println("Clicked L'Oreal Paris Colour Protect Shampoo");

	}

	

}
