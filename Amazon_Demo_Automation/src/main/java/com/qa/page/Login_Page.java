package com.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.Base_Class;

public class Login_Page extends Base_Class{
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement Nav_AccountList;
	
	@FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[1]/div[1]/a[1]")
	WebElement Signin;
	
	public Login_Page() {
		PageFactory.initElements(driver, this);	
	}
	// Action on different Element whose available on web_page
	public String ValidateLoginPage_Title() {
		return driver.getTitle();
	}

}

