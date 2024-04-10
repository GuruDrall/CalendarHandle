package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class EaseMyTrip extends BaseClass {
	public WebDriver driver;

	public EaseMyTrip(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='dvfarecal']")
	WebElement calenderBtn;

	@FindBy(xpath = "(//div[@class='month2'])[1]")
	WebElement actMonthYear;

	@FindBy(xpath = "//div[@class='month3']/img")
	WebElement nextBtn;

	@FindBy(xpath = "//li[@onclick='SelectDate(this.id)']")
	List<WebElement> actListOfDays;

	public void clickOnCalender() {
		calenderBtn.click();
	}

	public void selectDate(String day, String month, String year) {

		String expMonthYear = month.substring(0, 3) + " " + year;

		while (true) {

			String actMonthYearText = actMonthYear.getText();
			System.out.println(actMonthYearText);

			if (actMonthYearText.equalsIgnoreCase(expMonthYear)) {
				for (WebElement actDay : actListOfDays) {
					String actDayText = actDay.getText().split("\n")[0];
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
