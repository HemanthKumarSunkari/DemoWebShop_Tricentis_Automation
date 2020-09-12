package com.demoWebShop.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.demoWebShop.base.TestBase;
import com.demoWebShop.utilities.TestUtil;

public class ShoppingCartPage extends TestBase {

	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='header-logo']//a//img")
	WebElement header;

	@FindBy(xpath = "//tr//td[1]//input[1]")
	List<WebElement> removeCheck;
	
	@FindBy(xpath = "//input[@name='updatecart']")
	WebElement updateShoppingCartLink;
	
	@FindBy(xpath = "//*[@class='order-summary-content']")
	WebElement orderContentMsg;

	public void removeCartItems() {

		TestUtil.Wait(updateShoppingCartLink);
		
		for (WebElement i : removeCheck) {

			i.click();

		}
		
		updateShoppingCartLink.click();
		
		System.out.println("All added items are removed from cart list");
		
		TestUtil.Wait(orderContentMsg);
		
		Assert.assertEquals(orderContentMsg.getText(), "Your Shopping Cart is empty!");
		
		header.click();

	}



}
