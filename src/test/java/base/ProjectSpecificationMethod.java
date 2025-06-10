package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utility;

public class ProjectSpecificationMethod extends Utility {

	@BeforeSuite
	public void reportiniatialization() {
		ExtentSparkReporter reports = new ExtentSparkReporter("D:\\Eclipes\\MiniProject1\\reports\\MiniProject1.html");
		reports.config().setReportName("Projectone");

		extents = new ExtentReports();
		extents.attachReporter(reports);
	}

	@BeforeClass
	public void testDetails() {
		test = extents.createTest("ApplicationTest", "");
		test.assignCategory("E-commerce Website");
		test.assignAuthor("siva");
	}

	@Parameters({ "url", "browser" })
	@BeforeMethod
	public void lunchbrowser(String url, String browser) {

		LunchURL(url, browser);

	}
@Ignore
	@AfterMethod
	public void browserclose() {

		closingBrowser();
	}

	

	@AfterSuite
	public void reportclose() {
		extents.flush();

	}

}
