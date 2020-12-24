package seleniumfirstlogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioAndCheckbox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///E:/project/reg.html");
		List<WebElement> radio = driver.findElements(By.name("gender"));
		
		for(int i=0;i<radio.size();i++) {
			
			WebElement ele = radio.get(i);
			String ele_value = ele.getAttribute("value");
			if(ele_value.equals("Female")) {
				ele.click();
			}
		}
		
		Thread.sleep(10000);
		List<WebElement> district = driver.findElements(By.tagName("option"));
		for(int i=0;i<district.size();i++) {
			System.out.println(i);
			WebElement element = district.get(i);
			String value = element.getText();
			System.out.println(value);
			if(value.equals("Guntur")) {
				element.click();
				break;
			}
		}
		
	}

}
