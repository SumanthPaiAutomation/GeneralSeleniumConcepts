package AdvanceConceptsSeleniumpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFilesAutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("file:///E:/multipleuplaods.html");
		driver.findElement(By.xpath("//input[@type='File']")).click();
		Runtime.getRuntime().exec("E:\\autoitfiles\\fileuploadmulti.exe"+" "+"F:\\multifiles\\one.txt");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='File']")).click();
		Runtime.getRuntime().exec("E:\\autoitfiles\\fileuploadmulti.exe"+" "+"F:\\multifiles\\two.txt");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='File']")).click();
		Runtime.getRuntime().exec("E:\\autoitfiles\\fileuploadmulti.exe"+" "+"F:\\multifiles\\three.txt");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='File']")).click();
		Runtime.getRuntime().exec("E:\\autoitfiles\\fileuploadmulti.exe"+" "+"F:\\multifiles\\four.txt");
		Thread.sleep(3000);
		
	}

}
