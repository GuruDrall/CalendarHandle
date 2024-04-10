package BaseClass;

import org.testng.annotations.Test;

import PageObject.Booking;
import PageObject.ClearTrip;
import PageObject.EaseMyTrip;
import PageObject.GoIndigo;
import PageObject.Goibibo;

public class TestClass extends BaseClass {
	
	String day = "31";
	String month = "October";
	String year = "2024";
	
	@Test
	public void clearTrip() throws InterruptedException {
		
		launchBrower("https://www.cleartrip.com/flights");
		ct = new ClearTrip(driver);
		ct.clickOnCalender();
		ct.selectDate(day, month, year);	
	}
	
	@Test
	public void goibibo() {
		
		launchBrower("https://www.goibibo.com/flights/");
		gi = new Goibibo(driver);
		gi.clickOnCalender();
		gi.selectDate(day, month, year); // Check for Weekdays, Weekends, Past dates, Future dates	
	}
	
	@Test
	public void easeMyTrip() {
		
		launchBrower("https://www.easemytrip.com/flights.html");
		emt = new EaseMyTrip(driver);
		emt.clickOnCalender();
		emt.selectDate(day, month, year); // Check for Weekdays, Weekends, Past dates, Future dates	
	}
	
	@Test
	public void goIndigo() throws InterruptedException {
		
		launchBrower("https://www.goindigo.in/flight-booking.html");
		ind = new GoIndigo(driver);
		ind.clickOnCalender();
		ind.minimizeFrame();
		ind.selectDate(day, month, year); // Check for Weekdays, Weekends, Past dates, Future dates	
	}
	
	@Test
	public void booking() {
		
		launchBrower("https://www.booking.com/flights/index.en-gb.html");
		bk = new Booking(driver);
		bk.clickOnCalender();
		bk.selectDate(day, month, year); // Check for Weekdays, Weekends, Past dates, Future dates	
		bk.selectDate("2", "November", year);
	}

}
