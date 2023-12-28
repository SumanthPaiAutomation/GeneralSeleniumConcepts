package AdvanceConceptsSeleniumpack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffMoney {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://money.rediff.com/gainers");
		String Company ="Reliance Capital";
		List<WebElement> comp = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr/td[1]"));////table[@class='dataTable']//tbody/tr/td[1]
		List<WebElement> current = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr/td[4]"));
		List<WebElement> change = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr/td[5]"));
		for(int row = 0;row<comp.size();row++) {
			String compName = comp.get(row).getText().trim();
			if(compName.contains(Company)) {
				System.out.println("Current price of " +Company+" share is :"+current.get(row).getText());
				System.out.println("Change for this company is : "+ change.get(row).getText());
			}
		}
		
		driver.close();
	}

}
