package seleniumfirstpack;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://goo.gl/RVdKM9");
		//maximize window
		driver.manage().window().maximize();
		
		//select the checkbox
		
		//driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-9']"));
		
		// cant do above statement in single line
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-9']")));
		
		//get all of options
		System.out.println("all options are "+dropdown.getOptions());
		//get number of options
		System.out.println("number of options are "+dropdown.getOptions().size());
		
		//selecting by visible test, by index , by
		dropdown.selectByIndex(1);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dropdown.selectByVisibleText("Morning");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dropdown.selectByValue("Evening");
		driver.close();
		
	}

}
