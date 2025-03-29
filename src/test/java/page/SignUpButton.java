package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SignUpButton extends ProjectSpecificationMethod {
	@FindBy(id = "sign-username")
	private WebElement usernameField;

	@FindBy(id = "sign-password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign up']")
	private WebElement signUpConfirmButton;

	public SignUpButton(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickSignUpConfirm() {
		signUpConfirmButton.click();
	}

}
