package com.org.pages;

import org.openqa.selenium.By;

import com.org.test.BaseTest;


public class LoginPage extends BaseTest{

	
	static String  usernameField="//input[@id='user-name']";
	static String  Password="//input[@id='password']";
	static String  loginButton="//input[@id='login-button']";
	

	public static void inputUsername(String username) {
		
		driver.findElement(By.xpath(usernameField)).sendKeys(username);
	}

	public static void inputPawssword(String password) {

		driver.findElement(By.xpath(Password)).sendKeys(password);
	}

	public static void clickLoginButton() {

		driver.findElement(By.xpath(loginButton)).click();	
	}

}
