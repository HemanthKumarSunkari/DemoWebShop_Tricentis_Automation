package com.demoWebShop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoWebShop.base.TestBase;
import com.demoWebShop.utilities.TestUtil;

public class MainPage extends TestBase {

	public MainPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginLink;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;

	@FindBy(xpath = "//div[@class='header-logo']//a//img")
	WebElement titleImg;

	@FindBy(xpath = "//a[contains(@class,'account')]")
	WebElement accName;

	@FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
	WebElement cartLink;

	@FindBy(xpath = "//span[@class='cart-qty']")
	WebElement cartItems;

	@FindBy(xpath = "//li[@class='inactive']//a[contains(text(),'Books')]")
	WebElement bookLink;

	public void login() {
		loginLink.click();

	}

	public String verifyAccountName() {

		return accName.getText();
	}

	public void verifyShoppingCartItems() {
		int val = Integer.parseInt(cartItems.getText());

		if (val != 0) {
			System.out.println("Items are already added in the cart. Trying to remove the items");
			cartLink.click();
			new ShoppingCartPage().removeCartItems();
		} else {
			System.out.println(" No items are present in the cart");
		}

	}

	public void selectBooksfromCategories() {
		bookLink.click();

	}
	
	public void logout() {
		TestUtil.Wait(logoutLink);
		logoutLink.click();
	}

}
