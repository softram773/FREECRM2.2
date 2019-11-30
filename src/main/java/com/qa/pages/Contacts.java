package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.qa.baseclass.BaseClass;
import com.qa.utilities.CustomListener;


public class Contacts extends BaseClass{
	
	@FindBy(xpath="//button[text()='New']")
	WebElement newbutton;
	@FindBy(xpath="//div[text()='Create New Contact']")
	WebElement formname;
	@FindBy(name="first_name")
	WebElement firstname;
	@FindBy(name="last_name")
	WebElement lastname;
	@FindBy(xpath="//div[@name='channel_type']")
	WebElement channeltype;
	@FindBy(name="hint")
	WebElement selectcountry;
	@FindBy(name="day")
	WebElement enterday;
	@FindBy(name="month")
	WebElement entermonth;
	@FindBy(name="year")
	WebElement enteryear;
	@FindBy(xpath="//button[contains(text(), 'Save')]")
	WebElement savebutton;
	
	public Contacts() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonNew() {
		newbutton.click();
	}
	public String formTitle() {
		return formname.getText();
	}
	public void fillNewForm(String Fname, String Lname, String ChannelType, String country, String day, String month, String year) {
		firstname.sendKeys(Fname);
		lastname.sendKeys(Lname);
		if(channeltype.isDisplayed() && selectcountry.isDisplayed()) {
			channeltype.click();
			String fullxpath = String.format("//span[text()='"+ChannelType+"']");
			driver.findElement(By.xpath(fullxpath)).click();
			selectcountry.click();
			driver.findElement(By.xpath("//div[@name='hint']//input[@class='search']")).sendKeys(country);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='visible menu transition']//div/descendant::span[@class='text']"));

			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getText());
				if(list.get(i).getText().equals(country)) {
					list.get(i).click();
					break;
				}
			}
		}	
		enterday.sendKeys(day);
		entermonth.sendKeys(month);
		enteryear.sendKeys(year);
		savebutton.click();	
	}
}
