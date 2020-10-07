package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		// Create ExtentReport and attach reporter(s)
		ExtentReports extent = new ExtentReports();

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extentReport.html");
		extent.attachReporter(htmlReporter);

		// create a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("Google Search Test One",
				"This test is to validate google search functionality");

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\Driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com");
		test1.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		test1.pass("Entered Text in Searchbox");

		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		test1.pass("Clicked the Search Button");

		// Close Browser
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");

		test1.pass("Test Completed Successfully");

		// create a toggle for the given test, adds all log events under it
		ExtentTest test2 = extent.createTest("Google Search Test Two",
				"This test is to validate google search functionality");
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\Driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		test2.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com");
		test2.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		test2.pass("Entered Text in Searchbox");

		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		test2.fail("Clicked the Search Button");

		// Close Browser
		driver.close();
		driver.quit();
		test2.pass("Closed the browser");

		test2.pass("Test Completed Successfully");

		// Calling flush writes everything to the log file
		extent.flush();

	}
}
