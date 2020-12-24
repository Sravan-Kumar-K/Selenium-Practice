package seleniumfirstlogin;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchFrameExceptionPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
		
		try {
			driver.switchTo().frame(0);
		}
		catch(NoSuchFrameException e) {
			System.out.println("No Such Frame Exception occured");
			throw(e);
		}
		finally {
			driver.close();
		}
		
	}

}
