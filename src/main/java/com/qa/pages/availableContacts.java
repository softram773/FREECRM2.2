package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

import Inheritance.baseclass;

public class availableContacts extends BaseClass{
	

	@FindBy(xpath="//tr[4]//td[2]")
	WebElement selectCheckbox;
	@FindBy(xpath="//input[@name='id']")
	WebElement numberOfContacts;
	By numberOfCounts = By.xpath("//input[@name='id']");
	By contactName = By.xpath("//tr[1]//td[1]");
	
	public availableContacts() {
		PageFactory.initElements(driver, this);
	}
	
	public String selectContacts() {
		return "//tr[4]//td[2]";
	}
	public List countNumberContacts() {
		driver.navigate().refresh();
		return (driver.findElements(numberOfCounts));
	}
	public String getName() {		
		return ("//tr[1]//td[1]");
	}
}
