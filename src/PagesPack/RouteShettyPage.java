package PagesPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RouteShettyPage {

	WebDriver driver = new ChromeDriver();
	public RouteShettyPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By courseLink = By.xpath("//a[@href='https://courses.rahulshettyacademy.com/courses'][contains(normalize-space(),'Courses')]");
	
	public WebElement courseLink() {
		return driver.findElement(courseLink);
	}
}
