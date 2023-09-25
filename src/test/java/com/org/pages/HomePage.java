package com.org.pages;

import org.openqa.selenium.By;

import com.org.test.BaseTest;

public class HomePage extends BaseTest {
	
	static String productAddtoCartButton="//div[text()='dynamic']/parent::a/parent::div/following-sibling::div//button";
    static String cartButton="//a[@class='shopping_cart_link']";
    static String checkoutButton="//button[@id='checkout']";

public static void clickProductAddToCart(String productName) {

	driver.findElement(By.xpath(productAddtoCartButton.replace("dynamic",productName))).click();	
}

public static void clickCartButton() {

	driver.findElement(By.xpath(cartButton)).click();	
}

public static void clickCheckoutButton() {

	driver.findElement(By.xpath(checkoutButton)).click();	
}
}
