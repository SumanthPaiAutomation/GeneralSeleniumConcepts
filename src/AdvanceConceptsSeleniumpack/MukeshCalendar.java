package AdvanceConceptsSeleniumpack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MukeshCalendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		//in order to handle notifications paste the below code
		/*
		 * ChromeOptions options=new ChromeOptions(); Map prefs=new HashMap();
		 * prefs.put(“profile.default_content_setting_values.notifications”, 2);
		 * options.setExperimentalOption(“prefs”,prefs); ChromeDriver driver=new
		 * ChromeDriver(options);
		 */
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		//Thread.sleep(3000);
		//driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		
		//date to be picked up is 15 january 2021
		// //td[@class='monthTitle'] date header Jan 2021
		//  //td[@class='wd day'] for a list of wd day
		// //td[@class='we day'] for a list of we day
		// forward button //td[@class='next']//button
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		WebElement monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']"));
		while(!monthYear.getText().contains("Jan 2021")) {
			
			// click on forward button
			driver.findElement(By.xpath("//td[@class='next']//button")).click();
			}
		
		// get a list of dates to compare it with our date and click
		
		List <WebElement> dates = driver.findElements(By.xpath("//td[@class='wd day']"));
		for(WebElement day : dates) {
			String dayText = day.getText();
			if(dayText.contains("15")) {
				day.click();
				// after selecting this date need not iterate further so break
				break;
			}
		}
		
		
		
		
		
		
		
		}
		
	

	

}
