package com.qa.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.baseclass.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utilities.CustomListener;


@Listeners(CustomListener.class)
public class HomePageTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() {
		super();

		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Lauching Chrome Browser");
		loginpage = new LoginPage();
		homepage = loginpage.login(propertie.getProperty("UN"), propertie.getProperty("PWD"));
	}
	@Test(priority=1)
	public void validateHomePageTitle() {
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("****************************** freeCrmHomepagetitleTest *****************************************");
		try {
			log.info("validating Home Page title : " + homepage.getTitle());
		Assert.assertEquals(homepage.getTitle(), "Cogmento CRM");
		log.info("validated Home Page title as expected");
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Homepage title is not same as expected-->" +homepage.getTitle());
		}
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmHomepagetitleTest  *****************************************");
		
	}
	@Test(priority=2)
	public void validateLoginusername() {
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("****************************** freeCrmLogin UserName *****************************************");
		try {
			log.info("Validating login user name :" + homepage.loginusername());
			Assert.assertEquals(homepage.loginusername(), "ramesh Biradar");
			log.info("Validated login user name and accessed:");
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Login user name is not met expected name -->" + homepage.loginusername());
		}
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmLogin UserName  *****************************************");
	}
	@Test(priority=3)
	public void validatecogmentologo() {
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("****************************** freeCrmLogin Logo *****************************************");
		try {
		Assert.assertTrue(homepage.homepagecogmentologo());
		log.info("Home page icon showing as expected ");
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Home page icon showing wrong --> " + homepage.homepagecogmentologo() );
		}
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrm image *****************************************");
	}
	@Test(priority=4)
	public void validateSettingicon() {
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("****************************** freeCrmSetting Icon *****************************************");
		try {
		Assert.assertTrue(homepage.settingicon());
		log.info("Displayed setting icon in correct place");
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Setting icon is not displayed -->"+homepage.settingicon());
		}
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmSetting Icon *****************************************");
	}
	
	@AfterMethod
	public void tearDown() {
		log.info("Quit the browser");
		driver.quit();
	}
}
	