package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.availableContacts;
import com.qa.utilities.TestUtiles;

public class ContactsReportPageTest extends BaseClass {

	LoginPage login;
	HomePage homepage;
	availableContacts SelectContacts;
	
	ContactsReportPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		log.info("Initialized with config parameter ");
		login = new LoginPage();
		homepage = login.login(propertie.getProperty("UN"), propertie.getProperty("PWD"));
		homepage.clickOnContacts();
	}
	@Test
	public void isSelectContacts() throws Exception {
//		Method 1
		/*
		 * SelectContacts = new availableContacts(); String[] xpaths =
		 * TestUtiles.Xpath(SelectContacts.selectContacts()); int number_Of_Records =
		 * SelectContacts.countNumberContacts().size(); for(int i = 1; i <=
		 * number_Of_Records; i++) { String customXpath = xpaths[0] + i + xpaths[1];
		 * String contactName = driver.findElement(By.xpath(customXpath)).getText();
		 * if(contactName.contains("Mahesh")) { String[] checkboxXpaths =
		 * TestUtiles.Xpath(SelectContacts.getName()); String customXpath1 =
		 * checkboxXpaths[0] + i + checkboxXpaths[1];
		 * driver.findElement(By.xpath(customXpath1)).click(); } }
		 */
//		Method 2
		driver.navigate().refresh();
		Thread.sleep(2000);
		String[] contactName = {"Siddesh Prakash Biradar", "Mahesh Prakash Biradar", "Ramesh Prakash Biradar"};
		for(String name : contactName) {
//		String xpath1 = "//td[contains(text(), "+name +")]/parent::tr//td/div[@class='ui fitted read-only checkbox']";		
		String xpath = "//td[text()='"+name+"']/parent::tr//td/div[@class='ui fitted read-only checkbox']";
		driver.findElement(By.xpath(xpath)).click();
		}
	}
	
}
