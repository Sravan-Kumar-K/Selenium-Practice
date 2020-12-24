package seleniumfirstlogin;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchWindowExceptionPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
			//String netsuiteHandle = driver.getWindowHandle();
			//driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get("https://facebook.com");
			String fbHandle = driver.getWindowHandle();
			
			driver.close();
			driver.switchTo().window(fbHandle);
		}
		catch(NoSuchWindowException e) {
			System.out.println("No Such Window Exception occured");
			throw(e);
		}
		
	}

}
