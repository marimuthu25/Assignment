package com.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Helpers.Action;
import com.base.Baseclass;
import com.pages.AmazonHomePage;
import com.pages.AmazonProductPage;
import com.pages.AmazonSearchResultpage;
import com.utils.UtilityClass;

public class AmazonTest extends Baseclass {
	AmazonHomePage amazonHomepage;
	AmazonSearchResultpage searchresultPage;
	AmazonProductPage productPage;
	UtilityClass utility;
	Action action;
	TestData testData;

	@BeforeMethod
	public void setupTest() {
		SetUP("edge",TestData.AMAZON_URL);
		amazonHomepage = new AmazonHomePage(driver);
		searchresultPage = new AmazonSearchResultpage(driver);
		productPage = new AmazonProductPage(driver);
		utility = new UtilityClass(driver);

	}

	@Test
	public void AmazonFullFlow() {
		amazonHomepage.EnterProductName(TestData.AMAZON_PRODUCT_NAME);
		searchresultPage.ClickFirstProduct();

		System.out.println("First Product Price is   " + searchresultPage.getFirstProductPrice());

		System.out.println("First Product Rating is   " + searchresultPage.getFirstproductRating());
		
		try {
			utility.takescreenshot("First_product");
		} catch (IOException e) {
			System.out.println("Failed to take screen shot:  " + e.getMessage());
		}

		productPage.ClickaddToCardButton();
		productPage.clickCardButton();

		System.out.println("The Card subTotal Amount is   " + productPage.getCardSubTotal());

		String GetProductTitle = productPage.getProductTitle();
		System.out.println("Product Title is   " + GetProductTitle);

		Assert.assertEquals(GetProductTitle.contains("onplus"), "Test verification Failed");

	}

	@AfterMethod
	public void tearDown() {
		QuitBrowser();
	}

}
