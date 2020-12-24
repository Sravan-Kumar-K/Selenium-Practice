package seleniumfirstlogin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RolesDropdownTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
		WebElement username = driver.findElement(By.id("userName"));
		username.sendKeys("sravan.k@tvarana.com");
		driver.findElement(By.id("password")).sendKeys("Tvarana@2020");
		driver.findElement(By.id("submitButton")).click();
		
		WebElement secQuestionEle = driver.findElement(By.xpath("//td[@class='smalltextnolink']//following-sibling::td"));
		String actQuestion = secQuestionEle.getText();
		String question1 = "What was your childhood nickname?", question2 = "What is your oldest sibling's middle name?", question3 = "In what city or town was your first job?", question4 = "What is the middle name of your oldest child?";
		if(actQuestion.trim().equals(question1)) {
			driver.findElement(By.id("null")).sendKeys("nickname");
		}
		else if(actQuestion.trim().equals(question2)) {
			driver.findElement(By.id("null")).sendKeys("name");
		}
		else if(actQuestion.trim().equals(question3)) {
			driver.findElement(By.id("null")).sendKeys("job");
		}
		else if(actQuestion.trim().equals(question4)) {
			driver.findElement(By.id("null")).sendKeys("child");
		}
		
		driver.findElement(By.name("submitter")).click();
		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"spn_cRR_d1\"]/a"))).build().perform();
		eleAvailability(driver, By.xpath("//*[@id=\"ns-header-menu-userrole-item6\"]/a"), 10);
		driver.findElement(By.xpath("//*[@id=\"ns-header-menu-userrole-item6\"]/a")).click();
		
		// Navigating to New Saved Search Page
		Thread.sleep(3000);
		eleAvailability(driver, By.xpath("//span[text()='Lists']"), 10);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Lists']"))).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Search']"), 20);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Search']"))).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Saved Searches']"), 5);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Saved Searches']"))).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='New']"), 5);
		driver.findElement(By.xpath("//span[text()='New']")).click();
		driver.findElement(By.xpath("//a[text()='Account']")).click();
		driver.findElement(By.xpath("//a[@id='audiencetxt']")).click();
		
		// Handling Roles Dropdown
		driver.findElement(By.id("audslctrole_popup_list")).click();
		eleAvailability(driver, By.id("psls"), 8);
		List<WebElement> topDropdown = driver.findElements(By.xpath("//select[@id='psls']//option"));
		for(int i=0;i<topDropdown.size();i++) {
			eleAvailability(driver, By.id("psls"), 8);
			eleClickable(driver, By.id("psls"), 8);
			Select top = new Select(driver.findElement(By.id("psls")));
			top.selectByIndex(i);
			Thread.sleep(5000);
			List<WebElement> roleHierarchyOptionsValues = driver.findElements(By.xpath("//div[@id='inner_popup_div']//table//tr//td//following-sibling::td//a"));
			for(int j=0;j<roleHierarchyOptionsValues.size();j++) {
				String text = roleHierarchyOptionsValues.get(j).getText().trim();
				if(text.equals("CEO | Dashboard") || text.equals("DEMO ROLE") || text.equals("Executive Incharge") || text.equals("Netsuite Consultant") || text.equals("Sr. Executive") || text.equals("Z - Senior Executive")) {
					roleHierarchyOptionsValues.get(j).click();
					System.out.println("Options Selected: "+text);
				}
			}
		}
		driver.findElement(By.id("update")).click();
	}
	
	public static void eleAvailability(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void eleClickable(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
	}

}
