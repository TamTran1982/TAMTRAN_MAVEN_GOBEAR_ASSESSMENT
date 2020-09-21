package gobear.travel.search;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import gobear.travel.pages.InsuranceTravelPagePO;
import gobear.travel.pages.PageFactoryManager;
import gobear.travel.pages.TravelSearchPagePO;

public class TestScript extends AbstractTest{
	private WebDriver driver;
	private InsuranceTravelPagePO insuranceTravelPage;
	private TravelSearchPagePO travelSearchPage;
	private String startDate, endDate;
	
	@Parameters({ "browser", "url", "version" })
	@BeforeClass
	public void beforeClass(String browser, String url, String version) {
		driver = openMultiBrowser(browser, url, version);
		insuranceTravelPage = PageFactoryManager.getInsuranceTravelPage(driver);
		startDate="01 Apr 2020";
		endDate="30 Apr 2020";
		insuranceTravelPage.sleepInSeconds(2);
	}

	@Test
	public void TC_01_CheckGoToTravelResultsPage() throws Exception {
		log.info("TC_01 - Step 01: Click on Insurance section");
		insuranceTravelPage.clickToInsuranceSection();		
		
		log.info("TC_01 - Step 02: Click on Travel tab");
		insuranceTravelPage.clickToTravelTab();		
		
		log.info("TC_01 - Step 03: Click on Show Results button");
		travelSearchPage = insuranceTravelPage.clickToShowMyResultsButton();		
	}
	
	@Test
	public void TC_02_CheckAtLeastThreeCardsDisplayed() throws Exception {	
		log.info("TC_02 - Step 01: Verify at least three Cards displayed");
		verifyTrue(travelSearchPage.areCardGreaterThanNumber(3));	
	}
	
	@Test
	public void TC_03_CheckSearchTravelByFilterOption() throws Exception {	
		log.info("TC_03 - Step 01: Click on See More link");
		travelSearchPage.clickToSeeMoreLink();	
		
		log.info("TC_03 - Step 02: Search by Filter section : Promotions");
		travelSearchPage.searchByFilterWithRadioButton();
		
		log.info("TC_03 - Step 03: Search by Filter section : Insurers");
		travelSearchPage.searchByFilterWithCheckbox();
		travelSearchPage.sleepInSeconds(3);
		
		log.info("TC_03 - Step 04: Search by Filter section : Personal Accident");
		travelSearchPage.selectRangeSelector("1240000");
	}
	
	@Test
	public void TC_04_CheckSearchTravelBySortOption() throws Exception {		
		log.info("TC_04 - Step 01: Search by Ascending Sort section");
		travelSearchPage.searchByAscendingSort();			
	}
	
	@Test
	public void TC_05_CheckSearchTravelByDetailsOption() throws Exception {		
		log.info("TC_05 - Step 01: Search by Details section : Destination is 'Thailand' ");
		travelSearchPage.selectDestinationDropdown("Thailand");	
		travelSearchPage.sleepInSeconds(2);
		
		log.info("TC_05 - Step 02: Search by Details section : Travel Start Date ");		
		travelSearchPage.selectStartDateDatePicker(startDate);
		insuranceTravelPage.sleepInSeconds(2);
		
		log.info("TC_05 - Step 03: Search by Details section : Travel End Date ");		
		travelSearchPage.selectEndDateDatePicker(endDate);
		travelSearchPage.sleepInSeconds(2);
	}
	
	@Test
	public void TC_06_VerifySearchMenuIsFunctional() throws Exception {		
		log.info("TC_06 - Step 01: Verify to ensure the left side menu is functional : 'INSURERS' checkbox");
		travelSearchPage.searchByFilterWithCheckbox();	
		travelSearchPage.sleepInSeconds(2);
		verifyTrue(travelSearchPage.checkLeftMenuCheckBoxIsFunctional());
		travelSearchPage.sleepInSeconds(2);
		
		log.info("TC_06 - Step 02: Verify to ensure the left side menu is functional : 'Price: Low to high' radio button");		
		travelSearchPage.searchByAscendingSort();	
		verifyTrue(travelSearchPage.checkLeftMenuSortAscendingRadioButtonIsFunctional());
		travelSearchPage.sleepInSeconds(2);
		
		log.info("TC_06 - Step 03: Verify to ensure the left side menu is functional : Destination is 'Japan' ");
		travelSearchPage.selectDestinationDropdown("Japan");	
		travelSearchPage.areCardGreaterThanZero();
		travelSearchPage.sleepInSeconds(2);		
	}	
	
	@Parameters({ "browser" })
	@AfterClass
	public void afterClass(String browser) {
		closeBrowser(driver, browser);
	}

}
