package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.Homepage;

public class TC_003HomePageTest extends ProjectSpecificationMethod {
	@Test
	public void testApplicationLogoVisibility() {
		Homepage homePage = new Homepage(driver);
		Assert.assertTrue(homePage.isAppLogoDisplayed(), "Application logo is not displayed.");

		Assert.assertTrue(homePage.isHomeMenuDisplayed(), "Home menu is missing.");
		Assert.assertTrue(homePage.isContactMenuDisplayed(), "Contact menu is missing.");

		Assert.assertTrue(homePage.isPhonesCategoryDisplayed(), "Phones category is missing.");
		Assert.assertTrue(homePage.isLaptopsCategoryDisplayed(), "Laptops category is missing.");

	}

}
