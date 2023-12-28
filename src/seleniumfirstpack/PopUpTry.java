package seleniumfirstpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PopUpTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//a[@id='get_sign_up']")).click();
		////input[@id='authMobile']
		//in some application pop is a frame then swtich to frame or else just continue
		//driver.switchTo.activeElement();
		//driver.switchTo().activeElement();
		driver.switchTo().frame("authiframe");
		driver.findElement(By.xpath("//input[@id='authMobile']")).click();
		driver.findElement(By.xpath("//input[@id='authMobile']")).sendKeys("123456");
		//iframe[@id='authiframe']
		driver.findElement(By.xpath("//button[@id='mobileSubmitBtn']")).click();
		boolean checkred = driver.findElement(By.xpath("//span[@id='authMobileErrorMsg']")).isDisplayed();
		System.out.println("Is the text for validation for Mobile number present?: ");
		Assert.assertTrue(checkred);
		
		//System.out.println(Assert.assertEquals(checkred,"Please enter a valid mobile"));
		//Assert.assertEquals(checkred,"Please enter a valid mobile");
		driver.quit();
	}

}
