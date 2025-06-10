package test;

import org.testng.annotations.Test;
import org.testng.Assert;

import base.ProjectSpecificationMethod;
import page.SignUpPage;

public class TC_001_SignUpTest extends ProjectSpecificationMethod {

	@Test(priority = 1)
	public void testValidSignUp() throws InterruptedException {
	    SignUpPage signUp = new SignUpPage(driver);

	    // Generate unique username
	    String uniqueUsername = "User" + System.currentTimeMillis();
	    String password = "Test123";

	    signUp.signUp(uniqueUsername, password);
	    
	    String alert = signUp.getAlertTextIfPresent();  // Updated line

	    System.out.println("Valid SignUp Alert: " + alert);
	    Assert.assertTrue(alert.contains("Sign up successful"), "Valid signup failed or alert not found!");
	    
	    
	    
	}

        
    

    @Test(priority = 2,groups = "Smoke")
    public void testBlankUsername() throws InterruptedException {
        SignUpPage signUp = new SignUpPage(driver);
        signUp.signUp("", "somePas");
        String alert = signUp.getAlertTextIfPresent();

        System.out.println("Blank Username Alert: " + alert);
        Assert.assertEquals(alert, "Please fill out Username and Password.", "Blank username test failed.");
    }


    @Test(priority = 3,groups = "Smoke")
    public void testBlankPassword() throws InterruptedException {
        SignUpPage signUp = new SignUpPage(driver);
        signUp.signUp("SomeUser", "");
        String alert = signUp.getAlertTextIfPresent();

        System.out.println("Blank Password Alert: " + alert);
        Assert.assertEquals(alert, "Please fill out Username and Password.", "Blank password test failed.");
    }


    @Test(priority = 4,groups = "Smoke")
    public void testExistingUser() throws InterruptedException {
        SignUpPage signUp = new SignUpPage(driver);

        // Use an already registered user
        String existingUser = "testuser123";
        String password = "test123";

        signUp.signUp(existingUser, password);
        String alert = signUp.getAlertTextIfPresent();

        System.out.println("Existing User Alert: " + alert);
        Assert.assertTrue(alert.contains("This user already exist"), "Existing user check failed.");
    }
}
