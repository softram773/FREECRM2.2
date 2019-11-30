package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(css="span[class='user-display']")
	WebElement checkloginuser;
	@FindBy(xpath="//div[@class='header item']")
	WebElement cogmentologo;
	@FindBy(xpath="//div[@class='ui basic button floating item dropdown']")
	WebElement settingsbutton;
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactslink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	public String loginusername() {
		return checkloginuser.getText();
}
	public boolean homepagecogmentologo() {
		return cogmentologo.isDisplayed();
	}
	public boolean settingicon() {
		return settingsbutton.isDisplayed();
	}
	public void clickOnContacts() {
		contactslink.click();
	}
}