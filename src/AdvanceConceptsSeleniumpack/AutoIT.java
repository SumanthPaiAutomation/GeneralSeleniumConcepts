package AdvanceConceptsSeleniumpack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * alertIsPresent() elementSelectionStateToBe() elementToBeClickable()
		 * elementToBeSelected() frameToBeAvaliableAndSwitchToIt()
		 * invisibilityOfTheElementLocated() invisibilityOfElementWithText()
		 * presenceOfAllElementsLocatedBy() presenceOfElementLocated()
		 * textToBePresentInElement() textToBePresentInElementLocated()
		 * textToBePresentInElementValue() titleIs() titleContains() visibilityOf()
		 * visibilityOfAllElements() visibilityOfAllElementsLocatedBy()
		 * visibilityOfElementLocated()
		 */
		//main concept in auto it :
		/*
		 * ControlFocus("Open","","Edit1") for input box
		 * ControlSetText("Open","",
		 *"Edit1","F:\rahul shetty notes\Interview+Questions.docx") for file path
		 * ControlClick("Open","","Button1") for click of button
		 */
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://smallpdf.com/word-to-pdf");
		driver.findElement(By.xpath("//button[@class='l3tlg0-0 hrcxSS']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\autoitfiles\\fileupload.exe");
		Thread.sleep(3000);
		System.out.println("File is uploaded");
		System.out.println("Start download and verify");
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[@class='l3tlg0-0 eqlXyA']")).click();
		Thread.sleep(10000);
		File file = new File("F:\\rahul shetty notes\\Interview+Questions-converted.pdf");
		if(file.exists()) {
			System.out.println("File downloaded and exists");
		}
		
	}

}
