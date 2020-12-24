package seleniumfirstlogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiSelectWithoutSelectTag {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
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
		eleAvailability(driver, By.xpath("//*[@id=\"ns-header-menu-userrole-item6\"]/a"), 5);
		
		// Handling Roles Dropdown without Select tag
		List<WebElement> rolesDropdown = driver.findElements(By.xpath("//ul[@class='ns-menu ns-active']//li[contains(@id,'ns-header-menu-userrole-item')]//a//span"));
		
		// Printing all the Roles
		System.out.println("-------Roles Dropdown Values-------");
		for(int i=0;i<rolesDropdown.size();i++) {
			WebElement roleListElement = rolesDropdown.get(i);
			System.out.println(roleListElement.getText());
		}
		
		//Selecting Micron Optics Role from the Dropdown
		System.out.println("\n-------Role Selected-------");
		for(int i=0;i<rolesDropdown.size();i++) {
			WebElement roleListElement = rolesDropdown.get(i);
			String roleValue = roleListElement.getText().trim();
			if(roleValue.equals("Micron Optics - Administrator")) {
				System.out.println(roleListElement.getText()+" Role Selected");
				roleListElement.click();
				break;
			}
		}
		
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
		
		//Multiselect dropdown List
		List<WebElement> multiSelectList = driver.findElements(By.xpath("//table[@nlmultidropdown='audgroup25']//tr"));
		
		//Printing Multiselect Dropdown Values
		System.out.println("\n-------Multi-Select Dropdown Values-------");
		for(int i=0;i<multiSelectList.size();i++) {
			WebElement listElement = multiSelectList.get(i);
			System.out.println(listElement.getText());
		}
		
		//Selecting multiple values
		System.out.println("\n-------Values Selected-------");
		action.keyDown(Keys.CONTROL).build().perform();
		for(int i=0;i<multiSelectList.size();i++) {
			WebElement listElement = multiSelectList.get(i);
			String listValue = listElement.getText().trim();
			if(listValue.equals("3D Printer") || listValue.equals("WO group")) {
				System.out.println(listElement.getText()+" Option Selected");
				listElement.click();
			}
		}
		action.keyUp(Keys.CONTROL).build().perform();
	}

	public static void eleAvailability(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
