package com.qa.Base;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base_Class {
	public static WebDriver driver;
	
	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		String downloadFilepath = "./Download";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		CommonLibrary.Generic_Function.ImplicitWait();
		CommonLibrary.Generic_Function.PageLoad();
		CommonLibrary.Generic_Function.DeleteAllCookies();
		driver.get("https://www.amazon.com/");
	}
}
