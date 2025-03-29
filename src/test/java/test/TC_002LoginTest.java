package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.Homepage;
import page.LoginPage;

public class TC_002LoginTest extends ProjectSpecificationMethod {

	@Test
	public void testLoginButton() {

		Homepage homePage = new Homepage(driver);
		Assert.assertTrue(homePage.isLoginButtonDisplayed(), "Login button is not visible.");

		homePage.login("LathaSiva", "testpassword77");

		LoginPage obj = new LoginPage(driver);

		obj.clickLoginConfirm();

	}
}
