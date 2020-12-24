package seleniumfirstlogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeoutExceptionPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
			//eleAvailability(driver, By.id("username"), 5);
			driver.findElement(By.id("username"));
		}
		catch(Exception e) {
			System.out.println("Timeout Exception occured:");
			throw(e);
		}
		finally {
			driver.close();
		}
		
	}
	public static void eleAvailability(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
