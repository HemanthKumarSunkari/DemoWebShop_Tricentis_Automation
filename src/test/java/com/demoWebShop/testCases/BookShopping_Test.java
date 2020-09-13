package com.demoWebShop.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoWebShop.base.TestBase;
import com.demoWebShop.pages.BooksPage;
import com.demoWebShop.pages.LoginScreen;
import com.demoWebShop.pages.MainPage;
import com.demoWebShop.pages.ShoppingCartPage;
import com.demoWebShop.pages.checkOutPage;

public class BookShopping_Test extends TestBase {

	@Test
	public void completeBookShopping() {
		MainPage mp = new MainPage();
		LoginScreen ls = new LoginScreen();
		BooksPage bp = new BooksPage();
		ShoppingCartPage scp = new ShoppingCartPage();
		checkOutPage cp = new checkOutPage();

		mp.login();
		Assert.assertEquals(ls.verifyWelcomeMessage(), "Welcome, Please Sign In!");
		ls.enterLoginCred();
		Assert.assertEquals(mp.verifyAccountName(), prop.getProperty("uname"));
		mp.verifyShoppingCartItems();
		mp.selectBooksfromCategories();
		bp.selectABook();
		scp.validateSubTotalPrice();
		scp.checkOut();
		String orderNo = cp.NewAddress();
		System.out.println(orderNo);
		mp.logout();

	}

}
