package seleniumfirstlogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownsWithSelectTag {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		Select month = new Select(driver.findElement(By.id("month")));
		List<WebElement> monthValues = month.getOptions();
		
		// Print all the options
		System.out.println("------List of Months available------");
		for(int i=1;i<monthValues.size();i++) {
			System.out.println(monthValues.get(i).getText());
		}
		
		// Select an option
		month.selectByVisibleText("Jan");
		
		List<WebElement> selectedOption = month.getAllSelectedOptions();
		// Print the selected Option
		System.out.println("\n------Selected Month------");
		for(int i=0;i<selectedOption.size();i++) {
			System.out.println(selectedOption.get(i).getText());
		}
		//driver.quit();
	}

}
