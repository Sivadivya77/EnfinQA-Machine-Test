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

	@FindBy(css = ".name")
	private WebElement productName;
	@FindBy(css = ".price-container")
	private WebElement productPrice;
	@FindBy(xpath = "//div[@id='more-information']/p")
	private WebElement productDescription;
	@FindBy(linkText = "Add to cart")
	private WebElement addToCartButton;
	@FindBy(id = "cartur") // Ensure correct locator
	WebElement cartButton;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProductName() {
		return productName.getText();
	}

	public String getProductPrice() {
		return productPrice.getText().split(" ")[0]; // Extract "$360" before comparing
	}

	public String getProductDescription() {
		return productDescription.getText();
	}

	public void addToCart() {
		addToCartButton.click();

		try {
			// Wait for alert and accept it
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			System.out.println("Alert Message: " + alert.getText()); // Print alert message
			alert.accept(); // Click "OK" to dismiss the alert
		} catch (NoAlertPresentException e) {
			System.out.println("No alert appeared.");
		}

	}

	public void clickCartButton() {
		cartButton.click();

	}
}
