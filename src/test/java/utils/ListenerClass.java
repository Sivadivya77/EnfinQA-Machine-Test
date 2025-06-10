package utils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.ProjectSpecificationMethod;

/**
 * ListenerClass is used to capture events during test execution such as
 * onTestSuccess and onTestFailure. It logs the result and captures screenshots
 * accordingly using ExtentReports.
 * 
 * It extends ProjectSpecificationMethod to access shared WebDriver and utility methods.
 */
public class ListenerClass extends ProjectSpecificationMethod implements ITestListener {

    /**
     * This method is called when a test case passes successfully.
     * 
     * @param result The result object of the executed test method
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        // Log the test as passed in ExtentReport
        test.log(Status.PASS, "Test Passed");

        String screenShotPath = null;

        try {
            // Capture screenshot with test method name + " pass"
            screenShotPath = screenshot(result.getMethod().getMethodName() + " pass");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Attach screenshot to the report
		test.addScreenCaptureFromPath(screenShotPath, "Passed Test Screenshot");
    }

    /**
     * This method is called when a test case fails.
     */
    
    @Override
    public void onTestFailure(ITestResult result) {
        // Log the exception/throwable that caused the failure
        test.fail(result.getThrowable());

        String screenShotPath = null;

        try {
            // Capture screenshot with test method name + " fail"
            screenShotPath = screenshot(result.getMethod().getMethodName() + " fail");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Attach screenshot to the report
		test.addScreenCaptureFromPath(screenShotPath, "Failed Test Screenshot");
    }

}
