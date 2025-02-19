package com.Helpers;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.base.Baseclass;

public class Action extends Baseclass {

	public void Click(WebElement element) {
		WebElement ELEMENT = wait.withMessage("Element is Not Clickble")
				.until(ExpectedConditions.elementToBeClickable(element));
		ELEMENT.click();
	}

	public void Type(WebElement element, String TestData) {
		try {
			WebElement ELEMENT = wait.until(ExpectedConditions.visibilityOf(element));
			ELEMENT.clear();
			ELEMENT.sendKeys(TestData);
		} catch (NullPointerException e) {
			System.err.println("Element is Null" + e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void TypeandEnter(WebElement element, String TestData) {
		WebElement ELEMENT = wait.until(ExpectedConditions.visibilityOf(element));
		ELEMENT.clear();
		ELEMENT.sendKeys(TestData);
		ELEMENT.sendKeys(Keys.ENTER);

	}

	public void ScrollToElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public void switchToNewWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			break;
		}
	}

}
