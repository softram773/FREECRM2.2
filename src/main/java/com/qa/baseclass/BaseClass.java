package com.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.utilities.TestUtiles;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties propertie;
	public static Logger log;
	
	public BaseClass() {
		try {
			propertie = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\ramesh.biradar\\eclipse-workspace\\FreeCRM\\src\\main\\java\\com\\qa\\config\\config.properties");
			propertie.load(file);
			log = Logger.getLogger(BaseClass.class);
			PropertyConfigurator.configure("C:\\Users\\ramesh.biradar\\eclipse-workspace\\FreeCRM\\src\\main\\java\\com\\qa\\resources\\log4j.properties");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		}
	
	public static void initialization() {
			if(propertie.getProperty("browser").equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ramesh.biradar\\eclipse-workspace\\FreeCRM\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(propertie.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\ramesh.biradar\\eclipse-workspace\\FreeCRM\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().pageLoadTimeout(TestUtiles.PAGE_LOAD_TIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtiles.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			driver.navigate().to(propertie.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			
	}

}
