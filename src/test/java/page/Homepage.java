package page;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class Homepage extends ProjectSpecificationMethod {

	// ========== Element Locators ==========

	@FindBy(id = "signin2")  // Sign Up button
	WebElement signUpButton;

	@FindBy(id = "login2")  // Login button
	WebElement loginButton;

	@FindBy(id = "nameofuser")  // "Welcome [user]" text after login
	WebElement welcomeUser;

	@FindBy(xpath = "//a[contains(text(),'Home')]")  // Home tab in menu
	WebElement homeMenu;

	@FindBy(id = "nameofuser")  // Welcome text (same as above, used again privately)
	private WebElement welcomeMessage;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")  // Contact tab
	WebElement contactMenu;

	@FindBy(xpath = "//a[contains(text(),'About us')]")  // About Us tab
	WebElement aboutUsMenu;

	@FindBy(xpath = "//a[contains(text(),'Phones')]")  // Phones category
	WebElement phonesCategory;

	@FindBy(xpath = "//a[contains(text(),'Laptops')]")  // Laptops category
	WebElement laptopsCategory;

	@FindBy(xpath = "//a[contains(text(),'Monitors')]")  // Monitors category
	WebElement monitorsCategory;

	@FindBy(id = "nava")  // Application logo
	WebElement appLogo;

	@FindBy(xpath = "//a[text()='Samsung galaxy s6']")  // Specific product
	WebElement ClickProduct;

	@FindBy(css = ".btn.btn-success.btn-lg")  // "Add to cart" button
	WebElement ClickAddCartButton;

	// Login modal elements
	@FindBy(id = "login2") 
	private WebElement login;

	@FindBy(id = "loginusername")
	private WebElement usernameField;

	@FindBy(id = "loginpassword")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement submitLoginButton;

	// ========== Constructor ==========

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ========== Functional Methods ==========

	public boolean isSignUpButtonDisplayed() {
		return signUpButton.isDisplayed();  // Check visibility of Sign Up button
	}

	public Homepage isSignUpButtonEnabled() {
		signUpButton.isEnabled();  // Check if Sign Up button is enabled (UI state)
		return this;
	}

	public void clickSignUpButton() {
		signUpButton.click();  // Click the Sign Up button
	}

	public boolean isLoginButtonDisplayed() {
		return loginButton.isDisplayed();  // Check if Login button is visible
	}

	public boolean isLoginButtonEnabled() {
		return loginButton.isEnabled();  // Check if Login button is enabled
	}

	public WebElement getWelcomeMessage() {
		// Wait for welcome message (after login)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
	}

	// ✅ Handles login functionality with modal popup
	public void login(String username, String password) {
		loginButton.click();  // Open login modal

		// Wait for username field to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(usernameField));

		usernameField.sendKeys(username);  // Enter username
		passwordField.sendKeys(password);  // Enter password
		submitLoginButton.click();         // Submit login
	}

	// ✅ Verify if welcome message is displayed after login
	public boolean isWelcomeUserDisplayed() {
		return welcomeUser.isDisplayed();
	}

	// ✅ Check if application logo is displayed
	public boolean isAppLogoDisplayed() {
		return appLogo.isDisplayed();
	}

	// ✅ Check visibility of navigation/menu items
	public boolean isHomeMenuDisplayed() {
		return homeMenu.isDisplayed();
	}

	public boolean isContactMenuDisplayed() {
		return contactMenu.isDisplayed();
	}

	public boolean isAboutUsMenuDisplayed() {
		return aboutUsMenu.isDisplayed();
	}

	public boolean isPhonesCategoryDisplayed() {
		return phonesCategory.isDisplayed();
	}

	public boolean isLaptopsCategoryDisplayed() {
		return laptopsCategory.isDisplayed();
	}

	public boolean isMonitorsCategoryDisplayed() {
		return monitorsCategory.isDisplayed();
	}

	// ✅ Click a product dynamically by name
	public void clickProduct(String productName) {
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
	}

	// ✅ Click "Add to Cart" button (after product page loads)
	public void CartPage() {
		ClickAddCartButton.click();
	}

	// Optional: You can add alert handling here if needed
	/*
	public void handleAlertIfPresent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				Alert alert = driver.switchTo().alert();
				System.out.println("Alert Message: " + alert.getText());
				alert.accept(); // Accept the alert
			}
		} catch (NoAlertPresentException e) {
			System.out.println("No alert appeared.");
		}
	}
	*/
}
