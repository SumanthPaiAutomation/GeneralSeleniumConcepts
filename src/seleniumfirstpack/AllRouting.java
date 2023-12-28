package seleniumfirstpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PagesPack.RouteShettyPage;
public class AllRouting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//will demonstrate navigate and drag and drop , also double click using a mouse 
		//WebElement ele=driver.switchTo().activeElement(); for Modals
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		RouteShettyPage rp = new RouteShettyPage(driver);
		//driver.get("http://spicejet.com"); // URL in the browser
		driver.get("https://www.rahulshettyacademy.com/#/index");
		rp.courseLink().click();
		String heading = driver.findElement(By.xpath("//h2[1]")).getText();
		Assert.assertEquals(heading,"Coaching");
		Thread.sleep(4000);
		driver.navigate().to("https://www.rahulshettyacademy.com/#/index");
		String homeHandle = driver.getWindowHandle();
		Thread.sleep(3000);
		System.out.println("Start window handle concept");
		rp.courseLink().click();
		Thread.sleep(4000);
		String courseHandle = driver.getWindowHandle();
		driver.switchTo().window(homeHandle);
		Thread.sleep(3000);
		driver.switchTo().window(courseHandle);
		Thread.sleep(3000);
		driver.switchTo().window(homeHandle);

	}

}
