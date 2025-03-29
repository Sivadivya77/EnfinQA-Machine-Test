package page;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class LogoutPage extends ProjectSpecificationMethod {

	@FindBy(id = "logout2") // "Log out" button
	private WebElement logoutButton;

	@FindBy(id = "signin2") // "Sign up" button (appears after logout)
	private WebElement signUpButton;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Wait for and return Logout button
	public WebElement getLogoutButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(logoutButton));
	}

	// Check if Logout button is displayed
	public boolean isLogoutButtonDisplayed() {
		try {
			return logoutButton.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Click Logout
	public void clickLogout() {
		try {
			logoutButton.click();
			// handleUnexpectedAlert(); // Handle alert after clicking logout
		} catch (Exception e) {
			System.out.println("Exception while clicking logout: " + e.getMessage());
		}
	}

	// Verify redirection to Home Page after logout
	public boolean isRedirectedToHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(signUpButton)).isDisplayed();
	}

	// Handle unexpected alerts

}