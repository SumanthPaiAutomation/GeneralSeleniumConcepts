package seleniumfirstpack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//limiting he scope of driver to footer
		WebElement latnews = driver.findElement(By.xpath("//div[@id='gf-BIG']//tbody/tr/td[2]/ul[1]"));
		//collect all a tags or links from latnews one of which is broken
		List<WebElement> listLink = latnews.findElements(By.tagName("a"));
		Iterator<WebElement> it = listLink.iterator();
		String homePage ="https://rahulshettyacademy.com/";
		String url = "";
		HttpURLConnection huc = null;// for links
		int respCode = 200;
		//now iterrate trhough all links and click and check for http response
		while(it.hasNext()) {
			
			url = it.next().getAttribute("href");

			System.out.println(url);

			if(url == null || url.isEmpty()){
			System.out.println("URL is either not configured for anchor tag or it is empty");
			continue;
			}

			if(!url.startsWith(homePage)){
			System.out.println("URL belongs to another domain, skipping it.");
			continue;
			}
			
			//main logic for broken links is below

			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if(respCode >= 400){
				System.out.println(url+" is a broken link");
				}
				else{
				System.out.println(url+" is a valid link");
				}
			}catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
		}
		
	}

}
