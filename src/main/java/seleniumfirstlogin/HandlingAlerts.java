package seleniumfirstlogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAlerts {

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
		eleAvailability(driver, By.xpath("//*[@id=\"ns-header-menu-userrole-item6\"]/a"), 10);
		driver.findElement(By.xpath("//*[@id=\"ns-header-menu-userrole-item6\"]/a")).click();
		
		// Navigating to Lead page
		Thread.sleep(3000);
		eleAvailability(driver, By.xpath("//span[text()='Lists']"), 10);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Lists']"))).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Relationships']"), 20);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Relationships']"))).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Leads']"), 20);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Leads']"))).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='New']"), 5);
		driver.findElement(By.xpath("//span[text()='New']")).click();
		
		eleClickable(driver, By.id("spn_multibutton_submitter"), 20);
		driver.findElement(By.id("spn_multibutton_submitter")).click();
		
		// Handling the Simple alert
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(3000);
		
		// Handling Prompt Alert
		driver.navigate().to("file:///E:/project/reg.html");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		alert.sendKeys("Sravan");
		Thread.sleep(3000);
		System.out.println(alert.getText());
		
		//Accepting the alert
		alert.accept();
		
		// Dismissing the alert
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		alert.dismiss();
		
		// Handling Confirmation Alert
		driver.findElement(By.id("confirmAlert")).click();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		
		// Accepting the alert
		alert.accept();
		
		// Dismissing the Alert
		driver.findElement(By.id("confirmAlert")).click();
		Thread.sleep(3000);
		alert.dismiss();
	}
	
	public static void eleAvailability(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void eleClickable(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
	}

}
