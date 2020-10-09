package test;


import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DockerSelenium {

	WebDriver driver;
    
    @BeforeTest
      public void Driver() throws MalformedURLException {
          
        String Browser ="Chrome";
           
            if (Browser.equals("Firefox")){
              DesiredCapabilities dcap = DesiredCapabilities.firefox();
              //driver = new RemoteWebDriver(new URL("http://localhost:172.17.03:5555/wd/hub"),dcap);
            }
            else if (Browser.equals("Chrome")){
                String exePath = "/Users/saraddhungel/Downloads/chromedriver";
                System.setProperty("webdriver.chrome.driver", exePath);
                DesiredCapabilities dcap = DesiredCapabilities.chrome();
                //driver = new RemoteWebDriver(new URL("http://localhost:172.17.04:5555/wd/hub"),dcap);
            }     
      }

	

	@Test
	public void googleSearch2() {

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
