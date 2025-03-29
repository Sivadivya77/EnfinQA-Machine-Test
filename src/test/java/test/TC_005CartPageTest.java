package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.CartPage;
import page.Homepage;
import page.ProductPage;

public class TC_005CartPageTest extends ProjectSpecificationMethod {
	@Test
	public void testCartFunctionality() {
		Homepage homePage = new Homepage(driver);
		homePage.clickProduct("Samsung galaxy s6"); // Click product

		ProductPage productPage = new ProductPage(driver);
		productPage.addToCart(); // Add to cart (handles alert)

		productPage.clickCartButton(); // Navigate to cart page

		CartPage cartPage = new CartPage(driver);
		Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s6"), "Product is not in cart!"); // Verify product
																										// in cart

		cartPage.deleteProduct();
		Assert.assertFalse(cartPage.isProductInCart("Samsung galaxy s6"), "Product was not deleted from cart!");

		cartPage.clearCart(); // Ensure cart is empty
		Assert.assertEquals(cartPage.getTotalPrice(), "0", "Cart is not cleared!"); // Verify cart total reset
	}
}
