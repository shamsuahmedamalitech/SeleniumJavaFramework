package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_GoogleSearch_TestNG_Demo {

	WebDriver driver = null;

	
	@BeforeTest
	public void setUpTest() {
		
		

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\Driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void googleSearch() {

		// Goto google.com
		driver.get("https://www.google.com");

		// Enter text in search box
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		// Click on search button
		// driver.findElement(By.name("btnk")).click();
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();

	}

	@Test
	public void googleSearch3() {

		// Goto google.com
		driver.get("https://www.google.com");

		// Enter text in search box
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

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
