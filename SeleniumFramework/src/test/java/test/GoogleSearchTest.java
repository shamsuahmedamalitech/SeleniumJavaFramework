package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Goto google.com
		driver.get("https://www.google.com");
		
		//Enter text in search box
		//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		GoogleSearchPage.textbox_Search(driver).sendKeys("Automation Step by Step");

		//Click on search button
		//driver.findElement(By.name("btnk")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		GoogleSearchPage.button_search(driver).click();
		
		//Close Browser
		driver.close();
		
		System.out.println("Test Completed Successfully");
	}
	
}
