package seleniumfirstlogin;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdownWithSelectTag {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("file:///E:/project/reg.html");
		
		Select district = new Select(driver.findElement(By.xpath("//select")));
		List<WebElement> districtOptions = district.getOptions();
		
		// Print all the options of District
		System.out.println("------District Multi-Select Dropdown Values------");
		for(int i=0;i<districtOptions.size();i++) {
			System.out.println(districtOptions.get(i).getText());
		}
		
		// Select multiple options
		System.out.println("\n------Options Selected------");
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		district.selectByVisibleText("Ananthapur");
		district.selectByVisibleText("Vizianagaram");
		action.keyUp(Keys.CONTROL).build().perform();
		
		// Print all the selected options
		List<WebElement> selectedOptions = district.getAllSelectedOptions();
		for(int i=0;i<selectedOptions.size();i++) {
			System.out.println(selectedOptions.get(i).getText());
		}
		
		//driver.quit();
	}
}
