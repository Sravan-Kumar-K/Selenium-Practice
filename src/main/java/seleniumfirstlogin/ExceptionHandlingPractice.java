package seleniumfirstlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionHandlingPractice {

	public static void main(String[] args) throws InterruptedException,NoSuchElementException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
		Thread.sleep(3000);
		try {
			driver.findElement(By.id("userName"));
			try {
				driver.switchTo().alert();
			}
			catch(NoAlertPresentException e) {
				System.out.println("No Alert Present Exception occured");
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("No Such Element Exception occured");
			throw(e);
		}
		
		finally {
			driver.close();
		}
		
	}

}
