package com.demoWebShop.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoWebShop.base.TestBase;
import com.demoWebShop.utilities.TestUtil;

public class BooksPage extends TestBase {

	public BooksPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='page-body']//div//div[1]//div[2]//h2[1]")
	List<WebElement> book;
	
	@FindBy(xpath = "//*[@class = 'old-product-price']/span")
	WebElement oldPrice;
	
	@FindBy(xpath = "//*[@class = 'product-price']/span")
	WebElement currentPrice;
	
	@FindBy(xpath = "//input[@id='addtocart_13_EnteredQuantity']")
	WebElement quantity;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button-13']")
	WebElement addCartBtn;
	
	@FindBy(xpath = "//p[@class='content']")
	WebElement cartContentMessage;
	
	@FindBy(xpath = "//li[@id='topcartlink']")
	WebElement cartLink;
	
	
	
	public void selectABook() {
		
		book.get(0).click();
		
		enterQuantityAndChekoutCart();
		
	}
	
	public void enterQuantityAndChekoutCart() {
		
		TestUtil.Wait(currentPrice);
		System.out.println("Old price of the book = "+ oldPrice.getText());
		System.out.println("Current price of the book = "+ currentPrice.getText());
		
		quantity.clear();
		quantity.sendKeys(prop.getProperty("bookQuantity"));
		
		addCartBtn.click();
		
		TestUtil.Wait(cartContentMessage);
		
		System.out.println(cartContentMessage.getText());
		
		cartLink.click();
		
	}
}
