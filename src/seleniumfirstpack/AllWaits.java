package seleniumfirstpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AllWaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    WebDriver driver= new ChromeDriver();
	public static void getImplicitWait(){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		public static WebElement getExplicitWait(WebElement webelement){
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(webelement));
			return webelement;
		}

		public static WebElement getFluentWait(By Locator){
			Wait wait = new FluentWait(WebDriver reference)
					.withTimeout(timeout, SECONDS)
					.pollingEvery(timeout, SECONDS)
					.ignoring(Exception.class);

			WebElement foo=wait.until(new Function<WebDriver, WebElement>() {
				public WebElement applyy(WebDriver driver) {
					return driver.findElement(Locator);
				}
			});
		}

	}

}
