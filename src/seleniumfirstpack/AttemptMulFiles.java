package seleniumfirstpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttemptMulFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_multiple2");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[@onclick='myFunction()' and text()='Try it']")).click();
		System.out.println("Before click for choose files");
		driver.findElement(By.xpath("//input[@id='myFile']")).click();
		
		System.out.println("After Click of Choose Files button");
		//String uploadFilePath = "F:/fileupload/Day31";
		//String uploadFilePath2 = "F:/fileupload/Day32";
		//String uploadFilePath3 = "F:/fileupload/Day33";
		//inputElement.sendKeys(uploadFilePath + "\n " + uploadFilePath2 + "\n " + uploadFilePath3);
		driver.switchTo().defaultContent();
		driver.quit();
		
		
	}

}
