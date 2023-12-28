package seleniumfirstpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathExperiment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://freecrm.co.in/#");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//li[@class='rd-navbar--has-dropdown rd-navbar-submenu focus']//span[@class='rd-navbar-submenu-toggle']")).click();
		driver.findElement(By.xpath("//li[@class='rd-navbar--has-dropdown rd-navbar-submenu']//a[text()='CRM']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//ul[contains(text(),'')]//li//a[@href='hipaa.html'][contains(text(),'HIPAA CRM')]")).click();
		Thread.sleep(10000);

		//li[@class='rd-navbar--has-dropdown rd-navbar-submenu']//a[text()='CRM']
		String expurl = "https://freecrm.co.in/hipaa.html" ;
		String acturl = driver.getCurrentUrl();
		Thread.sleep(10000);

		if(expurl.equalsIgnoreCase(acturl)) {
			System.out.println("Test case is passed");
		}

		driver.close();
	}

}
