package AdvanceConceptsSeleniumpack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShettyTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List <WebElement> priceList = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[3]"));
		List<WebElement> courses = driver.findElements(By.xpath("//tbody/tr/td[2]"));
	    int sum =0;
	    for(WebElement eachPrice : priceList) {
	    	//System.out.println(eachPrice.getText());
	    	String str = eachPrice.getText();
	    	//System.out.println(str);
	    	int eachp = Integer.parseInt(str);
	    	//System.out.println(eachp);
	    	sum+=eachp;
	    	//System.out.println(sum);
	    }
	    //driver.quit();
	    System.out.println("Total price in the table is "+sum);
	    
	    
	    for(int row =0;row<priceList.size();row++) {
	    	String str2 = priceList.get(row).getText();
	    	int eachprice = Integer.parseInt(str2);
	    	if(eachprice>28) {
	    		System.out.println("I am greater than 30 dollars : "+courses.get(row).getText());
	    	}
	    }
	    driver.quit();

	}

}
