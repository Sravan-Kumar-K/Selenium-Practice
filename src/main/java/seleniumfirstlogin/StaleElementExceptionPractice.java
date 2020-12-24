package seleniumfirstlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaleElementExceptionPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
		WebElement username = driver.findElement(By.id("userName"));
		username.sendKeys("sravan.k@tvarana.com");
		driver.findElement(By.id("password")).sendKeys("Tvarana@2020");
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
		eleAvailability(driver, By.xpath("//*[@id=\"ns-header-menu-userrole-item6\"]/a"), 10);
		driver.findElement(By.xpath("//*[@id=\"ns-header-menu-userrole-item6\"]/a")).click();
		
		try {
			Select list = new Select(driver.findElement(By.id("ns-bankrec-view-filter")));
			driver.navigate().refresh();
			list.selectByIndex(0);
		}
		catch(StaleElementReferenceException e) {
			System.out.println("Stale Element Reference Exception occured");
			throw(e);
		}
		finally {
			driver.close();
		}
	}
	
	public static void eleAvailability(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
