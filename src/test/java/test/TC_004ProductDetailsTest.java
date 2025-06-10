package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.CartPage;
import page.Homepage;
import page.ProductPage;

public class TC_004ProductDetailsTest extends ProjectSpecificationMethod {

    @Test
    public void testAddProductToCart() {

        // Step 1: Navigate to homepage and click on the product
        Homepage homePage = new Homepage(driver);
        homePage.clickProduct("Samsung galaxy s6");

        // Step 2: On product detail page - fetch details
        ProductPage productPage = new ProductPage(driver);

        // Step 3: Assert the product name is as expected
        Assert.assertEquals(productPage.getProductName(), "Samsung galaxy s6", "Product name mismatch!");

        // Step 4: Assert the product price
        Assert.assertEquals(productPage.getProductPrice(), "$360", "Product price mismatch!");

        // Step 5: Print and validate the product description
        String actualDescription = productPage.getProductDescription();
        System.out.println("Product Description: " + actualDescription);

        String expectedDescription = "The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.";
        Assert.assertEquals(actualDescription, expectedDescription, "Product description mismatch!");

        // Step 6: Add product to cart
        productPage.addToCart();

        
    }
}
