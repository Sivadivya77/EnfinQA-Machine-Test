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
        // Step 1: Navigate to home and select a product
        Homepage homePage = new Homepage(driver);
        homePage.clickProduct("Samsung galaxy s6");

        // Step 2: Add product to cart (with alert handling)
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        // Step 3: Go to cart page
        productPage.clickCartButton();

        // Step 4: Initialize CartPage and validate product is in cart
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s6"),
                "❌ Product is not present in the cart!");

        // Step 5: Delete the product and verify removal
        cartPage.deleteProduct();
        Assert.assertFalse(cartPage.isProductInCart("Samsung galaxy s6"),
                "❌ Product was not removed from cart!");

        // Step 6: Clear cart to remove leftovers (if any)
        cartPage.clearCart();

        // Step 7: Ensure total price becomes 0
        Assert.assertEquals(cartPage.getTotalPrice(), "0", "❌ Cart is not empty after clearing!");
    }
}
