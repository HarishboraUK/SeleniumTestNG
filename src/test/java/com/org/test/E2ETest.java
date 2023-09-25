package com.org.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.org.pages.CheckoutPage;
import com.org.pages.HomePage;
import com.org.pages.LoginPage;
import com.org.utility.ReadData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2ETest extends BaseTest {

	@DataProvider(name= "testData")
	public static Object[][] getTestDataFromDataProvider(){
		return new Object[][] {{"standard_user", "secret_sauce", "Harish", "Bora", "UB1", "Thank you for your order!"}};		
	}
	
	@Test(dataProvider="testData")
	public void checkoutE2E(String username_val, String password, String firstName, String secondName, String postalCode, String orderConfirmationMessage) throws IOException
	{
		driver.get(ReadData.getValueFromPropertyFile("url"));
		LoginPage.inputUsername(username_val);
		LoginPage.inputPawssword(password);
		LoginPage.clickLoginButton();
		HomePage.clickProductAddToCart("Sauce Labs Backpack");
		HomePage.clickProductAddToCart("Sauce Labs Bike Light"); //can add multiple product, just pass product name
		HomePage.clickCartButton();
		HomePage.clickCheckoutButton();
		CheckoutPage.inputFirstNameField(firstName);
		CheckoutPage.inputLastNameField(secondName);
		CheckoutPage.inputPostalCodeField(postalCode);
		CheckoutPage.clickContinueButton();
		CheckoutPage.clickFinishButton();
		CheckoutPage.verifyOrderConfirmationMessage(orderConfirmationMessage);
		
	}

}
