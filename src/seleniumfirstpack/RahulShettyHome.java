package seleniumfirstpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RahulShettyHome {
	public static String homeURL;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/#/index");
		homeURL = driver.getCurrentUrl();
		System.out.println(homeURL);
		String getPageValidation = driver.getTitle();
		System.out.println(getPageValidation);
		Thread.sleep(3000);
		driver.get("https://courses.rahulshettyacademy.com/courses");
		String courseTitle=driver.getTitle();
		System.out.println("In course page");
		System.out.println(courseTitle);
		
		
		String homeURi=RahulShettyHome.getHomeURL();
		System.out.println(homeURi);
		
		Thread.sleep(5000);
		driver.navigate().to(homeURi);
		driver.quit();
		//driver.quit();
	}
	public static String getHomeURL() {
		//System.out.println(homeURL);
		return homeURL;
	}
}
