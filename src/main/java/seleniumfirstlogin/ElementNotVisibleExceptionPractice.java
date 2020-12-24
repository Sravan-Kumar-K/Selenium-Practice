package seleniumfirstlogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotVisibleExceptionPractice {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("file:///E:/project/reg.html");
		try {
			Thread.sleep(5000);
			WebElement textbox = driver.findElement(By.id("hiddenBox"));
			System.out.println(textbox.getAttribute("value"));
			//driver.findElement(By.id("submit")).click();
		}
		catch(ElementNotVisibleException e) {
			System.out.println("Element Not Visible Exception occured");
			throw(e);
		}
		finally {
			driver.close();
		}
		
	}

}
