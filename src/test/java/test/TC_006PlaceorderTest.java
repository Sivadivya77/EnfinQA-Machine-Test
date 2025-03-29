package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.CartPage;
import page.Homepage;
import page.PlaceOrderPage;
import page.ProductPage;

public class TC_006PlaceorderTest extends ProjectSpecificationMethod {

	@Test
	public void testPurchaseFunction() {
		Homepage homePage = new Homepage(driver);
		homePage.clickProduct("Samsung galaxy s6"); // Click product

		ProductPage productPage = new ProductPage(driver);
		productPage.addToCart(); // Add to cart
		productPage.clickCartButton(); // Navigate to cart

		CartPage cartPage = new CartPage(driver);
		Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s6"), "Product is not in cart!");

		cartPage.clickPlaceOrder(); // Click Place Order

		PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
		Assert.assertTrue(placeOrderPage.isOrderFormDisplayed(), "Place Order window not displayed!");

		// Fill in user details
		placeOrderPage.enterName("Sivachandran");
		placeOrderPage.enterCountry("India");
		placeOrderPage.enterCity("Coimbatore");
		placeOrderPage.enterCreditCard("4111111111111111");
		placeOrderPage.enterMonth("03");
		placeOrderPage.enterYear("2026");

		placeOrderPage.clickPurchase(); // Complete the order

		Assert.assertTrue(placeOrderPage.isPurchaseSuccessful(), "Order was not successful!");
	}
}
