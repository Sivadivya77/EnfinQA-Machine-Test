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
		Homepage homePage = new Homepage(driver);
		homePage.clickProduct("Samsung galaxy s6");

		ProductPage productPage = new ProductPage(driver);
		Assert.assertEquals(productPage.getProductName(), "Samsung galaxy s6");
		Assert.assertEquals(productPage.getProductPrice(), "$360");
		System.out.println(productPage.getProductDescription());
		Assert.assertEquals(productPage.getProductDescription(),"The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.");
		// Assert.assertEquals(productPage.getProductDescription().replaceAll("\\s+", "
		// ").trim(), "Product description", "Product description mismatch!");
		productPage.addToCart();

	}

}
