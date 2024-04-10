package BaseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.Booking;
import PageObject.ClearTrip;
import PageObject.EaseMyTrip;
import PageObject.GoIndigo;
import PageObject.Goibibo;

public class BaseClass {
	
	public static WebDriver driver = null;
	public WebDriverWait wait;
	ClearTrip ct;
	Goibibo gi;
	EaseMyTrip emt;
	GoIndigo ind;
	Booking bk;
	
	public void launchBrower(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void waitElementToAppear(WebElement ele, WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void clickOnElement(WebElement ele, WebDriver driver) {
		Actions ac = new Actions(driver);
		ac.click(ele);
	}
	
	public void waitElementToClickable(WebElement ele, WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	

}
