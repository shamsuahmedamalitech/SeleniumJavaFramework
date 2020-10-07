package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {
	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browserName")
	@BeforeTest
	public void setUpTest(String browserName) {
		
		System.out.println("Browser name is : " +  browserName);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\Driver\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", projectPath + "\\Driver\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver", projectPath + "\\Driver\\IE\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
	
		

	}

	@Test
	public void googleSearch() {

		// Goto google.com
		driver.get("https://www.google.com");

		// Enter text in search box
		driver.findElement(By.name("q")).sendKeys("A");

		// Click on search button
		// driver.findElement(By.name("btnk")).click();
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();

	}

	@Test
	public void googleSearch3() {

		// Goto google.com
		driver.get("https://www.google.com");

		// Enter text in search box
		driver.findElement(By.name("q")).sendKeys("A");

		// Click on search button
		// driver.findElement(By.name("btnk")).click();
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();

	}
	@AfterTest
	public void tearDownTest() {
		// Close Browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

}
