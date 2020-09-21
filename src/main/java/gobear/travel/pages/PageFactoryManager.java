package gobear.travel.pages;

import org.openqa.selenium.WebDriver;

import gobear.travel.pages.InsuranceTravelPagePO;
import gobear.travel.pages.TravelSearchPagePO;

public class PageFactoryManager {

	private static InsuranceTravelPagePO insuranceTravelPage;
	private static TravelSearchPagePO travelSearchPage;
	
	public static InsuranceTravelPagePO getInsuranceTravelPage(WebDriver driver_) {
		if (insuranceTravelPage == null) {
			return new InsuranceTravelPagePO(driver_);
		}
		return insuranceTravelPage;
	}

	public static TravelSearchPagePO getTravelSearchPage(WebDriver driver_) {
		if (travelSearchPage == null) {
			return new TravelSearchPagePO(driver_);
		}
		return travelSearchPage;
	}
	
}
