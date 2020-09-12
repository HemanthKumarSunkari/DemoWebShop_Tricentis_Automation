package com.demoWebShop.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	
	@FindBy(xpath = "//div[@id='checkout-step-shipping']")
	WebElement shipping;
	
	
	@FindBy(xpath = "//div[@id='checkout-step-shipping']")
	WebElement shippingAdd;
	
	@FindBy(xpath = "//div[@id='checkout-step-shipping-method']")
	WebElement shippingMethod;
	
	@FindBy(xpath = "//input[@id='shippingoption_1']")
	WebElement nextDayRadioBtn;
	
	@FindBy(xpath = "//div[@id='checkout-step-payment-method']")
	WebElement paymentMethod;
	
	@FindBy(xpath = "//input[@id='paymentmethod_0']")
	WebElement COD;
	
	@FindBy(xpath = "//div[@id='checkout-step-payment-info']")
	WebElement paymentInfo;
	
	@FindBy(xpath = "//div[@id='checkout-step-confirm-order']")
	WebElement confirmOrder;
	
	@FindBy(xpath = "//input[@class='button-1 confirm-order-next-step-button']")
	WebElement confirmBtn;
	
	@FindBy(xpath = "//strong[contains(text(),'Your order')]")
	WebElement confirmMsg;
	
	@FindBy(xpath = "//li[contains(text(),'Order number')]")
	WebElement orderno;
	
	@FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']")
	WebElement confirmMsgBtn;
	
	public void NewAddress() {
	
	Select billAdd = new Select(selectBillAddress);
	billAdd.selectByVisibleText("selectByVisibleText");
	TestUtil.Wait(selectCountry);
	Select country = new Select(selectCountry);
	country.selectByValue("41");
	newAddContinueBtn.click();
	
	TestUtil.Wait(shipping);
	Select shipAdd = new Select(shippingAdd);
	List<WebElement> ls= shipAdd.getOptions();
	int len = ls.size();
	shipAdd.selectByIndex(len-2);
	newAddContinueBtn.click();
	
	TestUtil.Wait(shippingMethod);
	nextDayRadioBtn.click();
	newAddContinueBtn.click();
	
	TestUtil.Wait(paymentMethod);
	COD.click();
	newAddContinueBtn.click();
	
	TestUtil.Wait(paymentInfo);
	newAddContinueBtn.click();

	
	
	}

}
