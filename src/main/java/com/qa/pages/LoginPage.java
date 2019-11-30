package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.baseclass.BaseClass;

public class LoginPage extends BaseClass{
	
//	@FindBy(xpath="//a[contains(text(),'Login')]")
//	WebElement loginlink;
	@FindBy(css="input[name='email']" )
	WebElement enterusername;
	@FindBy(css="input[name='password']")
	WebElement enterpassword;
	@FindBy(xpath="//div[text()='Login']")
	WebElement clickonlogin;
	@FindBy(css=".img-responsive")
	WebElement crmimage;
	
	//Actions / methods
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmimage.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
//		loginlink.click();
		enterusername.sendKeys(un);
		enterpassword.sendKeys(pwd);
		clickonlogin.click();
		return new HomePage();
	}

}
