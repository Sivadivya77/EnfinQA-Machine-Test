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

	@FindBy(id = "totalp")
	WebElement totalPrice;
	@FindBy(xpath = "//a[text()='Delete']")
	List<WebElement> deleteButtons;
	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> cartProducts;
	@FindBy(id = "cartur") // Update if needed
	WebElement cartButton;
	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement clickplaceorder;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isProductInCart(String productName) {
		driver.navigate().refresh(); // Refresh to get updated cart
		List<WebElement> updatedCartProducts = driver.findElements(By.xpath("//tr/td[2]")); // Re-fetch elements
		System.out.println("Updated Cart Count: " + updatedCartProducts.size()); // Debugging log

		for (WebElement product : updatedCartProducts) {
			System.out.println("Product in Updated Cart: " + product.getText());
			if (product.getText().trim().equalsIgnoreCase(productName)) {
				return true;
			}
		}
		return false;
	}

	public void deleteProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		if (!deleteButtons.isEmpty()) {
			deleteButtons.get(0).click(); // Delete first item
			wait.until(ExpectedConditions.invisibilityOf(deleteButtons.get(0))); // Wait for item to disappear
		}
	}

	public String getTotalPrice() {
		try {
			if (totalPrice.isDisplayed()) {
				return totalPrice.getText();
			}
		} catch (Exception e) {
			System.out.println("Total price element not found. Cart might be empty.");
		}
		return "0"; // Default return if total price is missing
	}

	public void clearCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		while (!deleteButtons.isEmpty()) {
			deleteButtons.get(0).click();
			wait.until(ExpectedConditions.stalenessOf(deleteButtons.get(0))); // Wait for deletion
		}

		driver.navigate().refresh(); // Ensure UI updates
	}

	public void clickPlaceOrder() {

		clickplaceorder.click();
		// TODO Auto-generated method stub

	}
}
