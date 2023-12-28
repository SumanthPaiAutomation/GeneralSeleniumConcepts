package seleniumfirstpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShettyStaticDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		//same xpath but distinguishing is done here
		System.out.println("step 1");
		driver.findElement(By.id("ctl00_mainContent_HolidayPackages_DropDownListPackage_CTXT")).click();
		System.out.println("step 2");

		driver.findElement(By.xpath("//a[@text='Haridwar/Rishikesh']")).click();
		System.out.println("step 3");

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_HolidayPackages_DropDownListFrom_CTXT']")).click();
		System.out.println("step 4");

		driver.findElement(By.xpath("(//a[@text=' Chennai '])[2]")).click();//same expath distinguished with index number
		System.out.println("step 5");

		driver.close();
		
		
	
	}

}
