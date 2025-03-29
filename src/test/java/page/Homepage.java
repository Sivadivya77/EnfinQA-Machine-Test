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
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class Homepage extends ProjectSpecificationMethod {

	@FindBy(id = "signin2")
	WebElement signUpButton;

	@FindBy(id = "login2")
	WebElement loginButton;

	@FindBy(id = "nameofuser")
	WebElement welcomeUser;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeMenu;

	@FindBy(id = "nameofuser") // Welcome message shown after login
	private WebElement welcomeMessage;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contactMenu;

	@FindBy(xpath = "//a[contains(text(),'About us')]")
	WebElement aboutUsMenu;

	@FindBy(xpath = "//a[contains(text(),'Phones')]")
	WebElement phonesCategory;

	@FindBy(xpath = "//a[contains(text(),'Laptops')]")
	WebElement laptopsCategory;

	@FindBy(xpath = "//a[contains(text(),'Monitors')]")
	WebElement monitorsCategory;

	@FindBy(id = "nava") // Application logo
	WebElement appLogo;

	@FindBy(xpath = "//a[text()='Samsung galaxy s6']")
	WebElement ClickProduct;

	@FindBy(css = ".btn.btn-success.btn-lg")
	WebElement ClickAddCartButton;

	@FindBy(id = "login2") // Login button on homepage
	private WebElement login;

	@FindBy(id = "loginusername") // Username input field
	private WebElement usernameField;

	@FindBy(id = "loginpassword") // Password input field
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Log in']") // Log in button in modal
	private WebElement submitLoginButton;

	public Homepage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isSignUpButtonDisplayed() {
		return signUpButton.isDisplayed();
	}

	public Homepage isSignUpButtonEnabled() {
		signUpButton.isEnabled();
		return this;
	}

	public void clickSignUpButton() {
		signUpButton.click();
	}

	public boolean isLoginButtonDisplayed() {
		return loginButton.isDisplayed();
	}

	public boolean isLoginButtonEnabled() {
		return loginButton.isEnabled();
	}

	public WebElement getWelcomeMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
	}

	public void login(String username, String password) {
		loginButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(usernameField));

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		submitLoginButton.click(); // Click login button
	}
	// Handle unexpected alert

	/*
	 * if( wait.until(ExpectedConditions.alertIsPresent())==null){ Alert alert =
	 * driver.switchTo().alert(); System.out.println("Alert Message: " +
	 * alert.getText()); alert.accept(); // Click "OK" to dismiss alert } else{
	 * System.out.println("No alert appeared."); } }
	 */
	public boolean isWelcomeUserDisplayed() {
		return welcomeUser.isDisplayed();
	}

	public boolean isAppLogoDisplayed() {
		return appLogo.isDisplayed();
	}

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

	public void clickProduct(String productName) {
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
	}

	public void CartPage() {
		ClickAddCartButton.click();
	}

}
