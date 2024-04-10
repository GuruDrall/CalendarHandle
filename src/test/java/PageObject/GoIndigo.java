package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class GoIndigo extends BaseClass {
	public WebDriver driver;

	public GoIndigo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[1]")
	WebElement calenderBtn;

	@FindBy(xpath = "(//div[@class='react-datepicker__current-month'])[1]")
	WebElement actMonthYear;

	@FindBy(xpath = "//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")
	WebElement nextBtn;

	@FindBy(xpath = "//div[contains(@class,'react-datepicker__day react-datepicker__day')]")
	List<WebElement> actListOfDays;

	@FindBy(xpath = "//iframe[@id='cx-iframe']")
	WebElement frame;

	@FindBy(xpath = "//i[@class='ri-subtract-line']")
	WebElement frameMinimize;

	public void clickOnCalender() {
		calenderBtn.click();
	}

	public void selectDate(String day, String month, String year) throws InterruptedException {

		String expMonthYear = month + " " + year;

		while (true) {

			String actMonthYearText = actMonthYear.getText();
			System.out.println(actMonthYearText);

			if (actMonthYearText.equals(expMonthYear)) {
				for (WebElement actDay : actListOfDays) {
					String actDayText = actDay.getText();
					System.out.println(actDayText);

					if (actDayText.equals(day)) {
						actDay.click();
						break;
					}
				}
				break;
			} else {
				nextBtn.click();
			}

		}
	}
	
	public void minimizeFrame() {
		driver.switchTo().frame(frame);
		frameMinimize.click();
		driver.switchTo().defaultContent();
	}
}
