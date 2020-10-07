package demo;


import java.net.URL;
import java.util.Arrays;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsDemo {

	private static WebDriver driver;
	
	public static void main(String[] args) throws Exception{
			
		String sauceUserName = System.getenv("shamsuahmed");
		String sauceAccessKey = System.getenv("2fc0fe05-88aa-45a6-8359-eb9da9b5295d");
		String sauceURL = "https://ondemand.saucelabs.com/wd/hub";

		
		MutableCapabilities sauceOpts = new MutableCapabilities();
		sauceOpts.setCapability("username", sauceUserName);
		sauceOpts.setCapability("accessKey", sauceAccessKey);
		/** In order to use w3c you must set the seleniumVersion **/
		sauceOpts.setCapability("seleniumVersion", "3.141.59");
		sauceOpts.setCapability("name", "4-best-practices");

		
		java.util.List<String> tags = Arrays.asList("sauceDemo", "demoTest", "module4");
		sauceOpts.setCapability("tags", tags);

	
		sauceOpts.setCapability("maxDuration", 3600);
		
		sauceOpts.setCapability("commandTimeout", 600);
		/** How long can the browser wait for a new command */
		sauceOpts.setCapability("idleTimeout", 1000);

		
		sauceOpts.setCapability("build", "Onboarding Sample App - Java-TestNG");

		/** Required to set w3c protoccol **/
		ChromeOptions chromeOpts = new ChromeOptions();
		chromeOpts.setExperimentalOption("w3c", true);

		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("sauce:options", sauceOpts);
		capabilities.setCapability("goog:chromeOptions", chromeOpts);
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("platformVersion", "Windows 10");
		capabilities.setCapability("browserVersion", "latest");

		
		driver = new RemoteWebDriver(new URL(sauceURL), capabilities);
	

	
	
		
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());

		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		
		System.out.println(driver.getTitle());

		Assert.assertTrue(true);

	

	
	
		System.out.println("Test Completed");
	}
}
