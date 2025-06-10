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
        // Step 1: Navigate to the homepage and click on a product
        Homepage homePage = new Homepage(driver);
        homePage.clickProduct("Samsung galaxy s6");

        // Step 2: Add the product to cart and handle alert
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.clickCartButton(); // Navigate to Cart Page

        // Step 3: Verify the product is added to cart
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s6"), "❌ Product is not in cart!");

        // Step 4: Click on 'Place Order'
        cartPage.clickPlaceOrder();

        // Step 5: Fill the order form
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        Assert.assertTrue(placeOrderPage.isOrderFormDisplayed(), "❌ Place Order form not displayed!");

        placeOrderPage.enterName("Sivachandran");
        placeOrderPage.enterCountry("India");
        placeOrderPage.enterCity("Coimbatore");
        placeOrderPage.enterCreditCard("4111111111111111");
        placeOrderPage.enterMonth("03");
        placeOrderPage.enterYear("2026");

        // Step 6: Submit the purchase
        placeOrderPage.clickPurchase();

        // Step 7: Confirm the purchase success
        Assert.assertTrue(placeOrderPage.isPurchaseSuccessful(), "❌ Order was not successful!");

        // Optional: Click OK to close confirmation dialog
        placeOrderPage.clickOkButton(); // Recommended to complete flow cleanly
    }
}
