package com.org.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.org.test.BaseTest;

public class CheckoutPage extends BaseTest {
	
    static String firstNameField="//input[@id='first-name']";
    static String lastNameField="//input[@id='last-name']";
    static String postalCodeField="//input[@id='postal-code']";
    static String continueButton ="//input[@id='continue']";
    static String finishButton ="//button[@id='finish']";
    static String orderConfirmationMessage="//h2[@class='complete-header']";
    
	public static void inputFirstNameField(String firstName) {
		
		driver.findElement(By.xpath(firstNameField)).sendKeys(firstName);
	}
	
	public static void inputLastNameField(String lastName) {
		
		driver.findElement(By.xpath(lastNameField)).sendKeys(lastName);
	}
	
	public static void inputPostalCodeField(String postalCode) {
		
		driver.findElement(By.xpath(postalCodeField)).sendKeys(postalCode);
	}


    
public static void clickContinueButton() {

	driver.findElement(By.xpath(continueButton)).click();	
}

public static void clickFinishButton() {

	driver.findElement(By.xpath(finishButton)).click();	
}

public static void verifyOrderConfirmationMessage(String expectedMessage) {

	String actualMessage=driver.findElement(By.xpath(orderConfirmationMessage)).getText();	
	assertEquals(actualMessage, expectedMessage, "Expected is not available");
}
}
