package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.Homepage;
import page.LoginPage;
import page.LogoutPage;

public class TC_007LogoutTest extends ProjectSpecificationMethod {
	@Test
	public void testLogoutFunctionality() throws InterruptedException {
		Homepage homePage = new Homepage(driver);
		LoginPage loginPage = new LoginPage(driver);
		LogoutPage logoutPage = new LogoutPage(driver);

		// Step 1: Log in with valid credentials
		homePage.login("Divyasiva00", "Divyasiva");
		loginPage.clickLoginConfirm();
		Thread.sleep(10000);

		// Step 2: Wait for Login Page to load fully before proceeding
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOf(homePage.getWelcomeMessage())); //
		// Ensure login is successful

		// Step 3: Ensure "Log out" button is visible before clicking
		wait.until(ExpectedConditions.elementToBeClickable(logoutPage.getLogoutButton()));

		// Step 4: Verify "Log out" button is displayed
		Assert.assertTrue(logoutPage.isLogoutButtonDisplayed(), "Log out button is not visible!");

		// Step 5: Click "Log out" button (handles unexpected alerts)
		logoutPage.clickLogout();

		// Step 6: Verify user is redirected to Home Page after logout
		Assert.assertTrue(logoutPage.isRedirectedToHomePage(), "Redirection to home page failed after logout!");
	}
}