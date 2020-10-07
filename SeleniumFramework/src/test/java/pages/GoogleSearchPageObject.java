package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObject {
	
	WebDriver driver = null;
	
	By textbox_search = By.name("q");
	
	By textbox_button = By.xpath("(//input[@name='btnK'])[2]");
	
	public GoogleSearchPageObject(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void setTextInSearchBox(String text) {
		
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		
		driver.findElement(textbox_button).click();
	}
			

}
