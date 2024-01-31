package rahulShettyAcademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ExtentReportDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void initializeExtentReport() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";		
		// configuring report settings
		ExtentSparkReporter reporter =new ExtentSparkReporter(path); // setting path 
		reporter.config().setDocumentTitle("Test Results"); // setting document title
		reporter.config().setReportName("Web Automation Results"); // setting report name
		
		extent = new ExtentReports(); // creating new object
		extent.attachReporter(reporter); // attaching reporter 
		extent.setSystemInfo("Tester", "Megha");// setting tester name in system info
	}
	
	@Test
	public void initialDemo() {
		
		// for every test case we need to call following method to set listener for result 
		ExtentTest test = extent.createTest("Initial Demo");
		
		WebDriverManager.chromedriver().setup();
		/*System.setProperty("webDriver.chrome.driver",
				"C:\\Users\\Shalin\\Downloads\\chromedriver-win64\\chromedriver-win64.exe");*/
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		//test.fail("results do not match");// it will not fail the testcase, it only reports failure for report
		extent.flush();// this indicates that test is completed and it should stop listening for result
		
	}
	@AfterTest
	public void print() {
		System.out.println("Test Completed.");
		System.out.println("Test Completed1.");
		System.out.println("Test Completed2.");
		System.out.println("Test Completed3.");
		
	}
	
	public void newMethod() {
		System.out.println("new changes.");
		System.out.println("new changes.");
		System.out.println("new changes.");
		System.out.println("new changes.");
		
	}

}
