package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class Booking extends BaseClass {
	public WebDriver driver;

	public Booking(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@placeholder='Depart - Return']")
	WebElement calenderBtn;

	@FindBy(xpath = "//div[@class='Calendar-module__monthWrapper___n+yfx']/h3")
	WebElement actMonthYear;

	@FindBy(xpath = "//button[contains(@class,'control--next___j')]")
	WebElement nextBtn;

	@FindBy(xpath = "//td[@class='Calendar-module__cell___GxOyY']")
	List<WebElement> actListOfDays;

	public void clickOnCalender() {
		calenderBtn.click();
	}

	public void selectDate(String day, String month, String year) {

		String expMonthYear = month + " " + year;

		while (true) {

			String actMonthYearText = actMonthYear.getText();
			System.out.println(actMonthYearText);

			if (actMonthYearText.equalsIgnoreCase(expMonthYear)) {
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

}
