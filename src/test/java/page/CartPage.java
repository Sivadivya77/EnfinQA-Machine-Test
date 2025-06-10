package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class CartPage extends ProjectSpecificationMethod {

	// Total price element in the cart
	@FindBy(id = "totalp")
	WebElement totalPrice;

	// List of all 'Delete' buttons to remove items from cart
	@FindBy(xpath = "//a[text()='Delete']")
	List<WebElement> deleteButtons;

	// List of all product names in the cart table (2nd column of each row)
	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> cartProducts;

	// Cart navigation button (optional, used to go to cart)
	@FindBy(id = "cartur")
	WebElement cartButton;

	// Button to place order from the cart page
	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement clickplaceorder;

	// Constructor to initialize web elements using PageFactory
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Checks if a specific product is available in the cart
	public boolean isProductInCart(String productName) {
		driver.navigate().refresh(); // Refresh to ensure latest cart state

		// Re-fetch product elements after refresh
		List<WebElement> updatedCartProducts = driver.findElements(By.xpath("//tr/td[2]"));
		System.out.println("Updated Cart Count: " + updatedCartProducts.size());

		for (WebElement product : updatedCartProducts) {
			System.out.println("Product in Updated Cart: " + product.getText());
			// Compare product name (case insensitive and trimmed)
			if (product.getText().trim().equalsIgnoreCase(productName)) {
				return true;
			}
		}
		return false;
	}

	//  Deletes the first product in the cart
	public void deleteProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		if (!deleteButtons.isEmpty()) {
			deleteButtons.get(0).click(); // Click the first delete button
			wait.until(ExpectedConditions.invisibilityOf(deleteButtons.get(0))); // Wait until it's removed from DOM
		}
	}

	//  Returns the total cart price as a string
	public String getTotalPrice() {
		try {
			if (totalPrice.isDisplayed()) {
				return totalPrice.getText(); // Return price value if visible
			}
		} catch (Exception e) {
			System.out.println("Total price element not found. Cart might be empty.");
		}
		return "0"; // Return 0 if price not found or exception occurs
	}

	// Clears the cart by deleting all items one by one
	public void clearCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		while (!deleteButtons.isEmpty()) {
			deleteButtons.get(0).click(); // Click delete
			wait.until(ExpectedConditions.stalenessOf(deleteButtons.get(0))); // Wait until element disappears
		}

		driver.navigate().refresh(); // Refresh UI to reflect empty cart
	}

	// Clicks the "Place Order" button on the cart page
	public void clickPlaceOrder() {
		clickplaceorder.click(); // Triggers navigation to order form
	}
}
