package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITDemo {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception {
		test();
	}

	
	public static void test() throws Exception {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.file.io/");
		driver.findElement(By.xpath("//header/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/input[1]")).click();
		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\Users\\USER\\Documents\\FileUploadScript.exe");
		
		Thread.sleep(3000);
		
		//driver.close();
	}

}
