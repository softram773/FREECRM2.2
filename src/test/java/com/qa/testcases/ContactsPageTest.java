package com.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.baseclass.BaseClass;
import com.qa.pages.Contacts;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utilities.CustomListener;
import com.qa.utilities.ReadExcel;


@Listeners(CustomListener.class)
public class ContactsPageTest extends BaseClass{
	
	LoginPage login;
	HomePage homepage;
	Contacts conpage;
	
	public ContactsPageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Lauching Chrome Browser");
		login = new LoginPage();
		conpage = new Contacts();
		homepage = login.login(propertie.getProperty("UN"), propertie.getProperty("PWD"));
		homepage.clickOnContacts();
	}
	
	@Test(priority=1)
	public void validateFormTitle() throws InterruptedException {
		log.info("****************************** Starting test cases execution   *****************************************");
		log.info("****************************** freeCrmContactsFormTitle*****************************************");
		String title = "";
		try {
		conpage.clickonNew();
		title = conpage.formTitle();
		Assert.assertEquals(title, "Create New Contact");
		}catch(Exception e) {
			log.error("Validated form title is not expected --> " + title);
		}
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmFormTitle *****************************************");
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object[][] data = ReadExcel.getExcelData("UserCreation");
		log.info("Read data from Excel file");
		return data;
		
	}
	@Test(priority=2, dataProvider="getCRMTestData")
	public void createNewContacts(String FirstName, String LastName, String SocialMedia, String Country, String Day, String Month, String Year) {
		log.info("****************************** Starting test cases execution   *****************************************");
		log.info("****************************** Create New Contact*****************************************");
		try {
		log.info("Creating new contact");
		conpage.clickonNew();
		conpage.fillNewForm(FirstName,  LastName,  SocialMedia, Country, Day, Month, Year);
		log.info("Creating new contact --> " + "FirstName : " + FirstName + "Last Name : " + LastName + "SocialMedia : " + SocialMedia + "Country : " + Country + "Day : " + Day + "Month : " + Month + "Year :" + Year);
		}catch(Exception e) {
			log.error("Unable to enter contact info");
		}
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** End creating New Contact*****************************************");
	}
	@AfterMethod(enabled=true)
	public void tearDown(){
		log.info("Browser closed");
		driver.quit();
	}
	

}
