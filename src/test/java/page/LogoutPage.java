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

	// Locate the "Log out" button by its ID
	@FindBy(id = "logout2")
	private WebElement logoutButton;

	// Locate the "Sign up" button (which reappears after successful logout)
	@FindBy(id = "signin2")
	private WebElement signUpButton;

	// Constructor: initializes elements using PageFactory
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Waits for the logout button to be visible and returns it.
	 * Helps ensure the element is interactable before use.
	 */
	public WebElement getLogoutButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(logoutButton));
	}

	/**
	 * Checks whether the logout button is currently displayed on the page.
	 * Useful to validate if the user is logged in.
	 */
	public boolean isLogoutButtonDisplayed() {
		try {
			return logoutButton.isDisplayed();
		} catch (Exception e) {
			// Handles situations where the element is not present
			return false;
		}
	}

	/**
	 * Attempts to click the logout button.
	 * Includes try-catch block for safe interaction and logging in case of failure.
	 */
	public void clickLogout() {
		try {
			logoutButton.click();
			// Optional: handle unexpected alert if logout triggers one
			// handleUnexpectedAlert(); 
		} catch (Exception e) {
			System.out.println("Exception while clicking logout: " + e.getMessage());
		}
	}

	/**
	 * Validates whether the user is redirected to the homepage after logout.
	 * It does this by checking the visibility of the Sign Up button.
	 */
	public boolean isRedirectedToHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(signUpButton)).isDisplayed();
	}

	
}
