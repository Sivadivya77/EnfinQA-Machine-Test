package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class LoginPage extends ProjectSpecificationMethod {

    // ========== WebElements ==========

    @FindBy(id = "loginusername") // Username input field in login modal
    private WebElement usernameField;

    @FindBy(id = "loginpassword") // Password input field in login modal
    private WebElement passwordField;

    @FindBy(css = "button[onclick='logIn()']") // Login confirmation button in modal
    private WebElement loginConfirmButton;

    // ========== Constructor ==========

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }

    // ========== Actions/Methods ==========

    /**
     * Enter the username in the login field.
     * @param username The username to be entered.
     */
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    /**
     * Enter the password in the login field.
     * @param password The password to be entered.
     */
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    /**
     * Click the login confirmation button. 
     * If an alert appears before or after clicking, handle it by dismissing.
     */
    public void clickLoginConfirm() {
        try {
            // Try switching to an alert and print the alert message (if present)
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Message: " + alert.getText());

            // Choose to dismiss the alert instead of accepting
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            // No alert present – continue to click login button
            System.out.println("No alert present");
        }

        // Click the actual login button
        loginConfirmButton.click();
    }
}
