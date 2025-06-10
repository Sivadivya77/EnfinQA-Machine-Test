package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class PlaceOrderPage extends ProjectSpecificationMethod {

	// === Locators for "Place Order" modal fields ===

	@FindBy(id = "name")
	private WebElement nameField;

	@FindBy(id = "country")
	private WebElement countryField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "card")
	private WebElement creditCardField;

	@FindBy(id = "month")
	private WebElement monthField;

	@FindBy(id = "year")
	private WebElement yearField;

	@FindBy(xpath = "//button[text()='Purchase']")
	private WebElement purchaseButton;

	@FindBy(className = "sweet-alert")
	private WebElement successMessage; // Confirmation dialog container

	@FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
	private WebElement confirmationMessage; // Actual message inside confirmation dialog

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okButton;

	@FindBy(id = "orderModal")
	private WebElement orderModal; // The popup/modal for placing order

	// === Constructor: Initializes the PageFactory with WebDriver instance ===
	public PlaceOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// === Checks if the Place Order form/modal is visible ===
	public boolean isOrderFormDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOf(orderModal)); // Waits until modal is visible
			return orderModal.isDisplayed();
		} catch (Exception e) {
			return false; // If modal is not displayed
		}
	}

	// === Form field methods: Inputs user details ===
	public void enterName(String name) {
		nameField.sendKeys(name);
	}

	public void enterCountry(String country) {
		countryField.sendKeys(country);
	}

	public void enterCity(String city) {
		cityField.sendKeys(city);
	}

	public void enterCreditCard(String card) {
		creditCardField.sendKeys(card);
	}

	public void enterMonth(String month) {
		monthField.sendKeys(month);
	}

	public void enterYear(String year) {
		yearField.sendKeys(year);
	}

	// === Clicks the Purchase button to submit the order ===
	public void clickPurchase() {
		purchaseButton.click();
	}

	// === Verifies whether the purchase was successful by checking confirmation message ===
	public boolean isPurchaseSuccessful() {
		return confirmationMessage.isDisplayed();
	}

	// === Clicks the OK button on the confirmation dialog ===
	public void clickOkButton() {
		okButton.click();
	}
}
