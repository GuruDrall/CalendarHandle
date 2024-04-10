package PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class ClearTrip extends BaseClass {
	public WebDriver driver;

	public ClearTrip(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='fs-4 fw-500 c-inherit flex flex-nowrap ml-4']")
	WebElement calenderBtn;

	@FindBy(css = ".nmx-1")
	WebElement crossMobileEnter;

	@FindBy(xpath = "(//div[@class='DayPicker-Caption'])[1]")
	WebElement actMonthYear;

	@FindBy(css = ".flex-1.ta-right g")
	WebElement nextBtn;
					
	@FindBy(xpath = "//div[contains(@class,'DayPicker-Day')]")
	List<WebElement> actListOfDays;
	
	@FindBy (xpath = "//div[@class='bg-white br-4 elevation-5 p-1 p-absolute mt-1 z-50 l-0 t-48 br-12']")
	WebElement calender;

	public void clickOnCalender() {
		crossMobileEnter.click();
		calenderBtn.click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 250);");
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calender);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectDate(String day, String month, String year) {

		String expMonthYear = month + " " + year;

		while (true) {

			String actMonthYearText = actMonthYear.getText();
			System.out.println(actMonthYearText);

			if (actMonthYearText.equals(expMonthYear)) {
				for (WebElement actDay : actListOfDays) {
					String actDayText = actDay.getText().split("\n")[0];
					System.out.println(actDayText);
					
					
					if (actDayText.equals(day)) {
						actDay.click();
						((JavascriptExecutor)driver).executeScript("window.scrollBy(0, -250);");
						break;
					}
				}
				break;
			} else {
				nextBtn.click();
			}
		}

	}

}
