package com.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.baseclass.BaseClass;
import com.qa.pages.availableContacts;

public class TestUtiles extends BaseClass{
		public static long PAGE_LOAD_TIME = 30;
		public static long IMPLICIT_WAIT_TIME = 30;
		
		public static void screenCaptureonfailedTest(String testmathodName) {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String spath = "C:\\Users\\ramesh.biradar\\eclipse-workspace\\FreeCRM\\Resource\\Screenshots\\" + testmathodName + ".png";
			try {
				FileUtils.copyFile(srcFile, new File(spath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static String[] Xpath(String fullpath) {
			String[] xpathArray = new String[2];
			xpathArray[0] = fullpath.substring(0, 5);			
			xpathArray[1]  = fullpath.substring(6);
			return xpathArray;
		}
}
