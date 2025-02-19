package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	private static final long Timeouts = 30;

	public WebDriverWait wait;
	protected static RemoteWebDriver driver;

	@SuppressWarnings("deprecation")
	public void SetUP(String browsername, String url) {

		switch (browsername.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firebox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().clearResolutionCache().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("Driver is not Defined");
			break;

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Timeouts, TimeUnit.SECONDS);
		driver.get(url);

	}

	public void closeTab() {
		driver.close();

	}

	public void QuitBrowser() {
		driver.quit();
	}
}
