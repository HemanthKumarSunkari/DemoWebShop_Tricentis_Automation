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

	@FindBy(xpath = "//span[@class='product-price']")
	List<WebElement> productPrices;

	@FindBy(xpath = "//span[@class='product-unit-price']")
	WebElement unitPrice;

	@FindBy(className = "qty-input")
	WebElement units;

	@FindBy(xpath = "//input[@id='termsofservice']")
	WebElement termsCheck;

	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkOutBtn;

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

	public void validateSubTotalPrice() {
		System.out.println("Going to check subTotalPrice");
		float subtotalPrice = Float.parseFloat(productPrices.get(0).getText());
		System.out.println("Sub total price : " + subtotalPrice);
		float up = Float.parseFloat(unitPrice.getText());
		float qty = Float.parseFloat(units.getAttribute("value"));
		float expsub = up*qty;
		Assert.assertEquals(subtotalPrice,expsub);
	}

	public void checkOut() {
		validateSubTotalPrice();
		termsCheck.click();
		checkOutBtn.click();
	}

}
