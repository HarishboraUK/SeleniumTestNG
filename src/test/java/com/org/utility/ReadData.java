package com.org.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class ReadData {

	@DataProvider(name= "testData")
	public static Object[][] getTestDataFromDataProvider(){
		return new Object[][] {{"standard_user","secret_sauce"}};
		
	}
	
	public static String getValueFromPropertyFile(String key) throws IOException
	{	
		InputStream input =new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		Properties prop=new Properties();
		prop.load(input);
		return prop.getProperty(key);
	
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
}
