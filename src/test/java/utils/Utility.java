package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

public class Utility {

	public static WebDriver driver;
	public static Properties prop;
	public static String filepath;
	public String sheetname;
	public static ExtentReports extents;
	public static ExtentTest test;

	public static void LunchURL(String url, String browser) {

		// cross browser Test
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();

		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public static void closingBrowser() {

		driver.close();
	}

	public static void readFromPropFile(String filepath) throws IOException {

		FileReader file = new FileReader(filepath);
		prop = new Properties();
		prop.load(file);
	}

	public static String screenshot(String name) throws IOException {

		String path = "D:\\Eclipes\\MiniProject1\\screenshot\\" + name + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}

}
