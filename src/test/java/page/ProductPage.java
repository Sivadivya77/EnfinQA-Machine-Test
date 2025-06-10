package page;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class ProductPage extends ProjectSpecificationMethod {

	// === Web elements on Product Detail Page ===

	@FindBy(css = ".name") // Product name (e.g., "Samsung galaxy s6")
	private WebElement productName;

	@FindBy(css = ".price-container") // Price container (e.g., "$360 *includes tax")
	private WebElement productPrice;

	@FindBy(xpath = "//div[@id='more-information']/p") // Product description
	private WebElement productDescription;

	@FindBy(linkText = "Add to cart") // "Add to cart" button
	private WebElement addToCartButton;

	@FindBy(id = "cartur") // Cart button (top nav)
	WebElement cartButton;

	// === Constructor to initialize the page factory ===
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// === Get the product name from product details page ===
	public String getProductName() {
		return productName.getText();
	}

	// === Get product price. Only the numeric value (e.g., "$360") is extracted ===
	public String getProductPrice() {
		return productPrice.getText().split(" ")[0];
	}

	// === Get full product description ===
	public String getProductDescription() {
		return productDescription.getText();
	}

	// === Click on "Add to cart" and handle confirmation alert ===
	public void addToCart() {
		addToCartButton.click();

		try {
			// Wait until alert appears and accept it
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			System.out.println("Alert Message: " + alert.getText());
			alert.accept(); // Dismiss the alert
		} catch (NoAlertPresentException e) {
			System.out.println("No alert appeared.");
		}
	}

	// === Navigate to Cart page ===
	public void clickCartButton() {
		cartButton.click();
	}
}
