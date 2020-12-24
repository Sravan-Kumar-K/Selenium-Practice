package seleniumfirstlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidSelectorExceptionPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
		try {
			driver.findElement(By.cssSelector("a:contains('Forgot')"));
		}
		catch(InvalidSelectorException e){
			System.out.println("Invalid Selector Exception occured");
			throw(e);
		}
		finally {
			driver.close();
		}
		
	}

}
