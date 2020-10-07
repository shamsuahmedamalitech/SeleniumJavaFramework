import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DesiredCapabilities_Demo {

	public static void main(String[] args) {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : " + projectPath);

		System.setProperty("webdriver.ie.driver", projectPath + "\\Driver\\IE\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver(caps);

		driver.get("https://www.google.com");

		// Enter text in search box
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		// Click on search button
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();

		// Close Browser
		driver.close();

		System.out.println("Test Completed Successfully");

	}

}
