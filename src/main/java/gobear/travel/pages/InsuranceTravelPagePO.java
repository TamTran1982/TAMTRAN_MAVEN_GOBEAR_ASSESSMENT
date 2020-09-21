package gobear.travel.pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import gobear.travel.interfaces.TravelInsurancePageUI;

public class InsuranceTravelPagePO extends AbstractPage{
	WebDriver driver;

	public InsuranceTravelPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void clickToInsuranceSection() {		
		waitForControlClickable(driver, TravelInsurancePageUI.INSURANCE_SECTION);
		clickToElement(driver, TravelInsurancePageUI.INSURANCE_SECTION);		
	}
	
	public void clickToTravelTab() {
		waitForControlClickable(driver, TravelInsurancePageUI.TRAVEL_TAB);	
		clickToElement(driver, TravelInsurancePageUI.TRAVEL_TAB);		
	}
	
	public TravelSearchPagePO clickToShowMyResultsButton() {
		waitForControlClickable(driver, TravelInsurancePageUI.SHOW_MY_RESULTS_BUTTON);	
		clickToElement(driver, TravelInsurancePageUI.SHOW_MY_RESULTS_BUTTON);		
		return PageFactoryManager.getTravelSearchPage(driver);		
	}	
	
}
