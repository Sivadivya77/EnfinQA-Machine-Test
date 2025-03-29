package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class LoginPage extends ProjectSpecificationMethod {
	
	@FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(css =  "button[onclick='logIn()']")
    private WebElement loginConfirmButton;

    public LoginPage(WebDriver driver) {
       this.driver=driver;
       PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) { usernameField.sendKeys(username); }
    public void enterPassword(String password) { passwordField.sendKeys(password); }
    public void clickLoginConfirm() {
    	try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Message: " + alert.getText());
           // alert.accept(); 
             alert.dismiss() ;
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present");
            
        }
    	
    	loginConfirmButton.click(); }
  
        
     
    
    
}


