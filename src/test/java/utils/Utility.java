package utils;

// Required imports
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Ignore;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * Utility class providing reusable functions like launching browser,
 * taking screenshots, reading property files, and more.
 */
public class Utility {

    // Global WebDriver instance
    public static WebDriver driver;

    // Properties object to read data from .properties file
    public static Properties prop;

    // Variable to store path to the property file or any required file
    public static String filepath;

    // Placeholder for sheet name if reading Excel files
    public String sheetname;

    // ExtentReports and ExtentTest objects for reporting
    public static ExtentReports extents;
    public static ExtentTest test;

    /**
     * Launches the browser and opens the given URL.
     * Supports cross-browser testing for Chrome and Edge.
     * 
     * @param url     The URL to open
     * @param browser The browser to use (chrome/edge)
     */
    public static void LunchURL(String url, String browser) {

        // Browser selection logic
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            // Default to Chrome if unknown browser is provided
            driver = new ChromeDriver();
        }

        // Open the URL
        driver.get(url);

        // Maximize browser window
        driver.manage().window().maximize();

        // Set implicit wait of 15 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    
     // Closes the browser window.
   @Ignore  
    public static void closingBrowser() {
        driver.close();  // Only closes the current window
    }

    /**
     * Reads key-value pairs from a .properties file.
     * 
     * @param filepath Full path to the .properties file
     * @throws IOException if the file is not found or unreadable
     */
    public static void readFromPropFile(String filepath) throws IOException {

        FileReader file = new FileReader(filepath); // Open file stream
        prop = new Properties();                   // Initialize Properties object
        prop.load(file);                           // Load key-value pairs
    }

    /**
     * Takes a screenshot of the current browser window.
     * Saves it to the specified location and returns the path.
     * 
     * @param name Filename to save the screenshot as (without extension)
     * @return String Full path to the saved screenshot
     * @throws IOException if the file operation fails
     */
    public static String screenshot(String name) throws IOException {

        // Set screenshot save location
        String path = "D:\\Eclipes\\MiniProject1\\screenshot\\" + name + ".png";

        // Capture screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Create destination file object
        File dest = new File(path);

        // Copy screenshot file to destination
        FileUtils.copyFile(src, dest);

        return path;
    }

}
