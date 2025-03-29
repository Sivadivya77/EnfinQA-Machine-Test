package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.Homepage;

public class TC_001SignUpTest extends ProjectSpecificationMethod {
	@Test
	public void testSignUpButtonVisibility() {
		Homepage homePage = new Homepage(driver);
		Assert.assertTrue(homePage.isSignUpButtonDisplayed(), "Sign Up button is not visible.");

		homePage.isSignUpButtonEnabled().clickSignUpButton();

	}

}
