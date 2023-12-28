package seleniumfirstpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import  seleniumfirstpack.RahulShettyHome.*;
public class RahulShettyCourses{
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://courses.rahulshettyacademy.com/courses");
		String courseTitle=driver.getTitle();
		System.out.println("In course page");
		System.out.println(courseTitle);
		
		
		String homeURi=RahulShettyHome.getHomeURL();
		System.out.println(homeURi);
		
		Thread.sleep(5000);
		driver.get("https://www.rahulshettyacademy.com/#/index");
		driver.quit();
	}

}
