package com.qa.Test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.Base_Class;
import com.qa.page.Home_Page;
import com.qa.page.Login_Page;

public class LoginPageTest extends Base_Class{
	Login_Page login_page;
	Home_Page home_Page;
	
	@BeforeClass
	public void Start() {
		initialization();
	}
	
	@BeforeMethod
	public void Setup() {
		login_page=new Login_Page();
	}
	
	@Test
	public void LoginPage_Title_Test() throws Exception {
		Thread.sleep(400);
		String title=login_page.ValidateLoginPage_Title();
		System.out.println(title);
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}
	@AfterMethod
	public void screenShot(ITestResult result) {
		// using ITestResult.FAILURE is equals to result.getStatus then it enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location
				// result.getName() will return name of test case so that screenshot name will
				// be same as test case name
				FileUtils.copyFile(src, new File("./Screenshot" + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}

	
}
