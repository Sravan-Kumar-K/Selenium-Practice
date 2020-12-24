package seleniumfirstlogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchSessionExceptionPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
			String netsuiteHandle = driver.getWindowHandle();
			driver.close();
			driver.switchTo().window(netsuiteHandle);
		}
		catch(Exception e) {
			System.out.println("No Such Session Exception occured");
			throw(e);
		}
	}

}
