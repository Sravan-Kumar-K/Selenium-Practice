package seleniumfirstlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassPractice {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravan Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://system.netsuite.com/pages/customerlogin.jsp");
		WebElement username = driver.findElement(By.id("userName"));
		WebElement password = driver.findElement(By.id("password"));
		username.sendKeys("sravan.k@tvarana.com");
		
		Actions actions = new Actions(driver);
		actions.doubleClick(username).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		actions.keyDown(password, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		
		Thread.sleep(3000);
		
		actions.contextClick(driver.findElement(By.linkText("Go to the visitor home page"))).sendKeys(Keys.ESCAPE).build().perform();
		actions.keyDown(password, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(3000);
		password.sendKeys("Tvarana@2020");
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
		
		eleAvailability(driver, By.xpath("//div[@aria-label='Custom Content']//h2"), 15);
		eleAvailability(driver, By.xpath("//div[@aria-label='New Release']//h2"), 15);
		WebElement source = driver.findElement(By.xpath("//div[@aria-label='Custom Content']//h2"));
		WebElement target = driver.findElement(By.xpath("//div[@aria-label='New Release']//h2"));
		System.out.println("Before drag & drop: "+source.getLocation()+" "+target.getLocation());
		Thread.sleep(2000);
		action.clickAndHold(source).build().perform();
		Thread.sleep(3000);
		action.moveByOffset(10,130).build().perform();
		action.release().build().perform();
		System.out.println("After drag & drop: "+driver.findElement(By.xpath("//div[@aria-label='Custom Content']//h2")).getLocation()+" "+driver.findElement(By.xpath("//div[@aria-label='New Release']//h2")).getLocation());
		
	}
	public static void eleAvailability(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
