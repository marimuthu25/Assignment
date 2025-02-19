package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Helpers.Action;
import com.base.Baseclass;
import com.pages.NykaaHomePage;
import com.pages.NykaaLorealPage;
import com.pages.NykaaProductPage;
import com.utils.UtilityClass;

public class NykaaTest extends Baseclass {

	NykaaHomePage nykaahomePage;
	NykaaLorealPage nykaaloreaPage;
	UtilityClass utility;
	Action action;
	TestData testData;
	NykaaProductPage nykaaProductPage;

	@BeforeMethod
	public void setupTest() {
		SetUP("edge", testData.NYKAA_URL);
		utility = new UtilityClass(driver);
		nykaahomePage = new NykaaHomePage(driver);
		nykaaloreaPage = new NykaaLorealPage(driver);
		nykaaProductPage = new NykaaProductPage(driver);
	}

	@Test
	public void NykaaTestFlow() {
		nykaahomePage.EnterProductName(testData.NYKAA_PRODUCT_NAME);
		Assert.assertTrue(nykaaloreaPage.getPageTitle().contains("L'Oreal Paris"), "Page Title Does Not Matched ");
		nykaaloreaPage.ClicksortButton();
		nykaaloreaPage.SortedByCustomerRated();
		nykaaloreaPage.ClickCategory();
		nykaaloreaPage.ClicksortButton();
		nykaaloreaPage.SortedByCustomerRated();
		nykaaloreaPage.ClickCategory();
		nykaaloreaPage.ClickHairCategory();
		nykaaloreaPage.ClickHairCareCategory();
		nykaaloreaPage.ClickShampooCategory();
		nykaaloreaPage.ClickConcern();
		nykaaloreaPage.ClickColourProduction();
		Assert.assertTrue(nykaaloreaPage.isShapmpooFilterApplied(), "Shampoo Filter Not Applied Correctly");
		nykaaloreaPage.Click_LOreal_Paris_Colour_Protect_Shampoo();
		action.switchToNewWindow();
		System.out.println("MRP:  " + nykaaProductPage.getProductMRP());
		nykaaProductPage.ClickAddToBag();
		nykaaProductPage.ClickShoppingBag();
		String GrantTotal = nykaaProductPage.getGrantTotal();
		System.out.println("Grand Total:  " + GrantTotal);
		nykaaProductPage.ClickProceedButton();
		nykaaProductPage.ClickContinueGuestButton();
		Assert.assertEquals(GrantTotal, nykaaProductPage.getFinalPriceDetails(), "Total Amount is mismatched");

	}

	@AfterMethod
	public void tearDown() {
		QuitBrowser();
	}

}
