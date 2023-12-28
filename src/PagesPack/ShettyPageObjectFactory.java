package PagesPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShettyPageObjectFactory {
	
	public WebDriver driver;

	public ShettyPageObjectFactory(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//input[@type='radio'])[2]")
	WebElement radio2;
	
	public WebElement getRadioTwo() {
		return radio2;
	}

	

}
