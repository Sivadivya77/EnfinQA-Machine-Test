package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import base.ProjectSpecificationMethod;

public class SignUpPage extends ProjectSpecificationMethod {

    @FindBy(id = "signin2")
    private WebElement signUpNavButton;

    @FindBy(id = "sign-username")
    private WebElement usernameField;

    @FindBy(id = "sign-password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUpConfirmButton;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openSignUpModal() {
        signUpNavButton.click();
    }

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignUpConfirm() {
        signUpConfirmButton.click();
    }

    public void signUp(String username, String password) throws InterruptedException {
        openSignUpModal();
        Thread.sleep(1000);
        enterUsername(username);
        enterPassword(password);
        clickSignUpConfirm();
    }

    public String getAlertTextIfPresent() throws InterruptedException {
        try {
            Thread.sleep(2000); // wait for alert to appear
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            alert.accept(); // dismiss the alert
            return text;
        } catch (NoAlertPresentException e) {
            return "No alert present.";
        }
}}