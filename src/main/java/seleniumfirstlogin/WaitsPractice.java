package seleniumfirstlogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsPractice {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
		
		//eleAvailability(driver, By.id("userName"), 5);
		driver.findElement(By.id("username")).sendKeys("sravan.k@tvarana.com");
		
		eleAvailability(driver, By.id("password"), 5);
		driver.findElement(By.id("password")).sendKeys("Tvarana@2020");
		
		eleClickable(driver, By.id("submitButton"), 5);
		driver.findElement(By.id("submitButton")).click();
	   
		WebElement secQuestionEle = driver.findElement(By.xpath("//td[@class='smalltextnolink']//following-sibling::td"));
		String actQuestion = secQuestionEle.getText().trim();
		String question1 = "What was your childhood nickname?", question2 = "What is your oldest sibling's middle name?", question3 = "In what city or town was your first job?", question4 = "What is the middle name of your oldest child?", question5 = "What school did you attend for sixth grade?";
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
		else if(actQuestion.trim().equals(question5)) {
			driver.findElement(By.id("null")).sendKeys("grade");
		}
		driver.findElement(By.name("submitter")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"spn_cRR_d1\"]/a"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"ns-header-menu-userrole-item6\"]/a")).click();
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Transactions']"))).build().perform();
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//			       .withTimeout(Duration.ofSeconds(10))
//			       .pollingEvery(Duration.ofSeconds(1))
//			       .ignoring(JavascriptException.class);
//		WebElement salesLink = wait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.xpath("//span[text()='Sales']"));
//			}
//		});
		eleAvailability(driver, By.xpath("//span[text()='Sales']"), 5); // Explicit Wait
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Sales']"))).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Enter Sales Orders']"), 5); // Explicit Wait
		driver.findElement(By.xpath("//span[text()='Enter Sales Orders']"));
		
	}
	public static void eleAvailability(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void eleClickable(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
	}

}
