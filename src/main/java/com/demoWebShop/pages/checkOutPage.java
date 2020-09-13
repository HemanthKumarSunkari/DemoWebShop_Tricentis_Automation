package com.demoWebShop.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.demoWebShop.base.TestBase;
import com.demoWebShop.utilities.TestUtil;

public class checkOutPage extends TestBase {

	public checkOutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='billing-address-select']")
	WebElement selectBillAddress;

	@FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
	WebElement selectCountry;

	@FindBy(xpath = "//input[@id='BillingNewAddress_City']")
	WebElement city;

	@FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
	WebElement add1;

	@FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement zipCode;

	@FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement mobile;

	@FindBy(xpath = "//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']")
	WebElement newAddContinueBtn;

	@FindBy(xpath = "//*[@id='checkout-step-shipping']")
	WebElement shipping;

	@FindBy(xpath = "//*[@id='shipping-address-select']")
	WebElement shippingAdd;

	@FindBy(xpath = "//*[@id=\"shipping-buttons-container\"]/input")
	WebElement ShipAddContinueBtn;

	@FindBy(xpath = "//*[@id='checkout-step-shipping-method']")
	WebElement shippingMethod;

	@FindBy(xpath = "//*[@id='shippingoption_1']")
	WebElement nextDayRadioBtn;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement ShipMethodContinueBtn;

	@FindBy(xpath = "//*[@id='checkout-step-payment-method']")
	WebElement paymentMethod;

	@FindBy(xpath = "//*[@id='paymentmethod_0']")
	WebElement COD;

	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement paymentMethodContinueBtn;

	@FindBy(xpath = "//*[@id='checkout-step-payment-info']")
	WebElement paymentInfo;

	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement paymentInfoContinueBtn;

	@FindBy(xpath = "//*[@id='checkout-step-confirm-order']")
	WebElement confirmOrder;

	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement confirmBtn;

	@FindBy(xpath = "//strong[contains(text(),'Your order')]")
	WebElement confirmMsg;

	@FindBy(xpath = "//li[contains(text(),'Order number')]")
	WebElement orderno;

	@FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']")
	WebElement confirmOrderBtn;

	public String NewAddress() {
	
	Select billAdd = new Select(selectBillAddress);
	billAdd.selectByVisibleText("New Address");
	TestUtil.Wait(selectCountry);
	Select country = new Select(selectCountry);
	country.selectByValue("41");
	city.sendKeys(prop.getProperty("city"));
	add1.sendKeys(prop.getProperty("add1"));
	zipCode.sendKeys(prop.getProperty("zip"));
	mobile.sendKeys(prop.getProperty("mobile"));
	newAddContinueBtn.click();
	
	TestUtil.Wait(shipping);
	Select shipAdd = new Select(shippingAdd);
	List<WebElement> ls= shipAdd.getOptions();
	int len = ls.size();
	shipAdd.selectByIndex(len-2);
	ShipAddContinueBtn.click();
	
	TestUtil.Wait(shippingMethod);
	nextDayRadioBtn.click();
	ShipMethodContinueBtn.click();
	
	TestUtil.Wait(paymentMethod);
	COD.click();
	paymentMethodContinueBtn.click();
	
	TestUtil.Wait(paymentInfo);
	paymentInfoContinueBtn.click();
	
	TestUtil.Wait(confirmOrder);
	confirmBtn.click();
	
	TestUtil.Wait(confirmMsg);
	Assert.assertEquals(confirmMsg.getText(), "Your order has been successfully processed!");
	
	String orderNo = orderno.getText();
	confirmOrderBtn.click();
	
	
	return orderNo;
	
	}

}
