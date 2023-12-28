package AdvanceConceptsSeleniumpack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnMallTabel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://omayo.blogspot.com/");
		List<WebElement> listNum = driver.findElements(By.xpath("//tbody/tr//td[2]"));//number list
		List<WebElement> names = driver.findElements(By.xpath("//tbody/tr//td[1]"));//name list
		/*
		 * for(WebElement eachNum : listNum) { String numss = eachNum.getText(); //int
		 * age = Integer.parseInt(numss); System.out.println(numss); for(WebElement
		 * eachname : names) { System.out.println(eachname); if(numss.contains("31")) {
		 * System.out.println("My age is greater than 30"+eachname.getText()); } }
		 * 
		 * }
		 */
		for(int row =0;row<listNum.size();row++) {
			Strings nums = listNum.get(row).getText();
			System.out.println(nums);
			//int conv = Integer.parseInt(nums);
			
			System.out.println(conv);
		}
		
		driver.quit();	
				
	}
		
		
	
		
}



