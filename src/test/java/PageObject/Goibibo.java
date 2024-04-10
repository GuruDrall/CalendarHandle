package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class Goibibo extends BaseClass {
	public WebDriver driver;

	public Goibibo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='sc-iGgWBj cZvDPc']/span")
	WebElement crossLogin;

	@FindBy(xpath = "//div[@class='sc-12foipm-16 wRKJm fswFld ']/span[text()='Departure']")
	WebElement calenderBtn;

	@FindBy(xpath = "(//div[@class='DayPicker-Month'])[1]/div/div")
	WebElement actMonthYear;

	@FindBy(xpath = "//div[@class='DayPicker-NavBar']/span[2]")
	WebElement nextBtn;

	@FindBy(xpath = "//div[contains(@class,'DayPicker-Day')]")
	List<WebElement> actListOfDays;

	public void clickOnCalender() {

		crossLogin.click();
		calenderBtn.click();
	}

	public void selectDate(String day, String month, String year) {

		String expMonthYear = month + " " + year;

		while (true) {

			String actMonthYearText = actMonthYear.getText();
			System.out.println(actMonthYearText);

			if (actMonthYearText.equals(expMonthYear)) {
				for (WebElement actDay : actListOfDays) {
					String actDayText = actDay.getText();
					System.out.println(actDayText);

					if (actDayText.equals(day)) {
						System.out.println(actDay.getText());
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
