package com.org.test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public final static int TIMEOUT=10;
	
	@BeforeTest
	@Parameters({"browser"})
	public void initilizeDriver(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) //can initialize multiple browser based on browser values from Testng
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
