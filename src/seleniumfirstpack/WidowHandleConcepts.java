package seleniumfirstpack;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PagesPack.RouteShettyPage;
public class WidowHandleConcepts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		RouteShettyPage rp = new RouteShettyPage(driver);
		driver.get("https://www.rahulshettyacademy.com/#/index");
		String homeHandle = driver.getWindowHandle();
		rp.courseLink().click();
		Thread.sleep(3000);
		String courseWindowHandle = driver.getWindowHandle();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='fedora-navbar-link navbar-link'][contains(normalize-space(),'Mentorship')]")).click();
		String mentorHan = driver.getWindowHandle();
		Thread.sleep(3000);
		// from mentor -->go to home and then go to course and to mentor
		System.out.println("Switching starts");
		driver.switchTo().window(homeHandle);
		Thread.sleep(3000);
		driver.switchTo().window(courseWindowHandle);
		Thread.sleep(3000);
		driver.switchTo().window(mentorHan);
		System.out.println("Switching ends");
		driver.quit();
		
		// handling all windows/ particular tab
		// fist thing is you need to get all your window handles 
		Set<String> allHandles = driver.getWindowHandles();
		int TotalSize = allHandles.size();
		for(String child : allHandles) {
			driver.switchTo().window(child);
			System.out.println("My window title is "+ driver.getTitle());
			System.out.println("my id is :"+child);
		}
		
		//from above mechanism you get all windows/tabs with ids and title for your reference 
		//then you can target specific windows/tabs using arraylist for windows
		//important thing is you will need to know the sequence of opening of  tabs or windows
		ArrayList<String> allWindowList = new ArrayList(allHandles);
		//if i want to switch to 2 tab i.e indeex 1
		driver.switchTo().window(allWindowList.get(1));
		//if i want to switch to 12th tab i.e index is 11
		driver.switchTo().window(allWindowList.get(11));
		//now back to parent i.e index 0
		driver.switchTo().window(allWindowList.get(0));
		
		// please note window switching is for new tabs or new windows 
		//in same application if u need to navigate the use driver.navigate().to("value/url");
	}
	

}
