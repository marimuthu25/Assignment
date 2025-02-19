package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass {

	WebDriver driver;

	public UtilityClass(WebDriver driver) {
		this.driver = driver;
	}

	public void takescreenshot(String screenshotName) throws IOException {
		try {
			TakesScreenshot scr = (TakesScreenshot) driver;

			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			File SrcFile = scr.getScreenshotAs(OutputType.FILE);

			File directory = new File("screenshots");
			if (!directory.exists()) {
				directory.mkdir();
			}
			File dest = new File("Screenshots/" + screenshotName + "_" + timestamp + ".png");
			FileUtils.copyFile(SrcFile, dest);
			System.out.println("Screen shot is Saved:  " + dest.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Failed to take screen shot:  " + e.getMessage());
		}
	}

}
