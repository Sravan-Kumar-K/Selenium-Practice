package seleniumfirstlogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NetsuiteLogin {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
		driver.findElement(By.id("userName")).sendKeys("sravan.k@tvarana.com");
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
		//eleAvailability(driver, By.xpath("//*[@id=\"ns-header-menu-userrole-item6\"]/a"), 10);
		driver.findElement(By.xpath("//*[@id=\"ns-header-menu-userrole-item6\"]/a")).click();
		
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Transactions']"))).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Sales']"), 5); // Explicit Wait
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Sales']"))).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Enter Sales Orders']"), 5); // Explicit Wait
		driver.findElement(By.xpath("//span[text()='Enter Sales Orders']")).click(); 
		
		eleClickable(driver, By.xpath("//input[@name='inpt_customform']"), 20);
		Thread.sleep(15000);
		driver.findElement(By.xpath("//input[@name='inpt_customform']")).click();
		List<WebElement> customFormList = driver.findElements(By.xpath("//div[@class='dropdownDiv']//div"));
		System.out.println(customFormList.size());
		for(int i=0;i<customFormList.size();i++) {
			WebElement formEle = customFormList.get(i);
			String formEleValue = formEle.getText();
			if(formEleValue.equals("Standard Sales Order")) {
				formEle.click();
			}
		}
		
		
		//driver.quit();
	}
	
	public static void eleAvailability(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void eleClickable(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
	}

}