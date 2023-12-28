package seleniumfirstpack;
import PagesPack.ShettyPageObjectFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class ShettyPracticePage {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		ShettyPageObjectFactory obje = new ShettyPageObjectFactory(driver);
		// check for 2nd radio button selected , click second radio button
		//boolean flagRadio = driver.findElement(By.xpath("(//input[@type='radio'])[2]")).isSelected();
		boolean flagRadio = obje.getRadioTwo().isSelected(); // used page factory here

		if (!flagRadio) {

			driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		}

		// check for autosuggestive dropdown

		driver.findElement(By.xpath("//input[@id='autocomplete']")).click();
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("IND");

		List<WebElement> opList = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

		for (WebElement eachOp : opList) {

			String listStr = eachOp.getText();

			if (listStr.equalsIgnoreCase("India")) {
				eachOp.click();
			}
		}
		System.out.println(driver.findElement(By.xpath("//input[@id='autocomplete']")).getText());
		//driver.close();
		//select drop down
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
		//sel.click(); // no need to click on deafult select dropdown
		sel.selectByVisibleText("Option2");
		
		//select for checkboxes
		
		 boolean checkFlag = driver.findElement(By.xpath("//label[@for='bmw']/child::input[@id='checkBoxOption1']")).isSelected();
		 if(!checkFlag) {
			 driver.findElement(By.xpath("//label[@for='bmw']/child::input[@id='checkBoxOption1']")).click();
		 }
		// going to child windows 
		 driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		 Set<String> linkSet = driver.getWindowHandles();
		 String Parent_Window = driver.getWindowHandle();  
		 Iterator<String> it = linkSet.iterator();
		 int count =0;
		 while(it.hasNext()) {
			 driver.switchTo().window(it.next());
			 System.out.println(driver.getTitle());
			 count++;
			 //driver.close();
		 }
		 System.out.println(count);
		   

		

		 //Switching back to Parent Window  
		 driver.switchTo().window(Parent_Window);
		 
		 //handling tabs in selenium
		 	driver.findElement(By.xpath("//a[@id='opentab']")).click();
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));//child tab
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));//back to parent tab
		    
		 //alerts alert and confirm
		    driver.findElement(By.xpath("//input[@id='name']")).click();
		    driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Sumanth Pai");
		    driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		    Thread.sleep(5000);
		    Alert al = driver.switchTo().alert();
		    al.accept();
		    Thread.sleep(5000);

		    driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		    Alert b2 = driver.switchTo().alert();
		    b2.accept();

		    //check for total price  in a table 
		    //i will first scroll
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,1000)");
		    List <WebElement> priceList = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[3]"));
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
		    // using streams 
		    //List<>
		    
		    // Move hover acctions class
		    Actions ac = new Actions(driver);
		    ////div[@class='block large-row-spacer']//a[2]
		    WebElement hover = driver.findElement(By.xpath("//button[@id='mousehover']"));
		    
		    ac.moveToElement(hover).build().perform();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//a[contains(normalize-space(),'Top')]")).click();
		    
		    //frames 
		    js.executeScript("window.scrollBy(0,1200)");

		    driver.switchTo().frame("courses-iframe");
		    //click on mentorship 
		    //driver.findElement(By.xpath("//iframe[@id='courses-iframe']/a[text()='Mentorship']")).click();
		    //return to parent frame
		    //	    driver.switchTo().parentFrame();
		    driver.switchTo().defaultContent();
		    
		    //show and hide elements
		    js.executeScript("window.scrollBy(0,600)");
		    driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		    ////input[@id='show-textbox']
		    driver.findElement(By.xpath("//input[@id='show-textbox']")).click();
		    ////input[@id='displayed-text']
		    driver.findElement(By.xpath("//input[@id='displayed-text']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys(Keys.SHIFT,"Hello Hidden in caps");
		    Thread.sleep(3000);

		    driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();

		    //screen shot 
		    
		    TakesScreenshot scrshot = ((TakesScreenshot)driver);
		    File SrcFile=scrshot.getScreenshotAs(OutputType.FILE);
		    FileHandler.copy(SrcFile,new File("F://screenshotsselenium/firstshot.png"));
		    
		    //broken links
		    
		    
	}

}
