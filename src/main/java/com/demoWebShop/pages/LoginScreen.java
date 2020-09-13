package com.demoWebShop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoWebShop.base.TestBase;

public class LoginScreen extends TestBase {

	public LoginScreen() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//*[contains(text(),'Welcome')]")
	WebElement WelMes;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement pass;
	
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement loginBtn;
	
	public String verifyWelcomeMessage()
	{
		return WelMes.getText();
		
	}
	
	public void enterLoginCred() {
		
		email.sendKeys(prop.getProperty("uname"));
		pass.sendKeys(prop.getProperty("pass"));
		
		loginBtn.click();
		
	}
	

}
