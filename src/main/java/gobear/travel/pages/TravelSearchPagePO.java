package gobear.travel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import gobear.travel.interfaces.TravelSearchPageUI;

public class TravelSearchPagePO extends AbstractPage {
	WebDriver driver;

	public TravelSearchPagePO(WebDriver driver_) {
		this.driver = driver_;
	}	

	public boolean areCardGreaterThanNumber(int expectedNumber) {
		waitForAllControlVisible(driver, TravelSearchPageUI.NUMBER_OF_CARD);
		int actualNumber = getSizeElements(driver, TravelSearchPageUI.NUMBER_OF_CARD);
		if (actualNumber >= expectedNumber) {
			return true;
		} 
		return false;
	}
	
	public boolean areCardGreaterThanZero() {
		waitForAllControlVisible(driver, TravelSearchPageUI.NUMBER_OF_CARD);
		int actualNumber = getSizeElements(driver, TravelSearchPageUI.NUMBER_OF_CARD);		
		if (actualNumber >= 1) {
			return true;
		} 
		return false;		
	}
	
	public void removeAttributeOfStartDate(String type) {
		waitForControlClickable(driver, TravelSearchPageUI.DETAILS_START_DATE_CALENDAR);
		WebElement element = driver.findElement(By.xpath(TravelSearchPageUI.DETAILS_START_DATE_CALENDAR));
		removeAttributeOfElement(driver, element, type);
	}

	public void removeAttributeOfEndDate(String type) {
		waitForControlClickable(driver, TravelSearchPageUI.DETAILS_END_DATE_CALENDAR);
		WebElement element = driver.findElement(By.xpath(TravelSearchPageUI.DETAILS_END_DATE_CALENDAR));
		removeAttributeOfElement(driver, element, type);
	}

	public void clickToSeeMoreLink() {
		waitForControlClickable(driver, TravelSearchPageUI.FILTER_SEE_MORE_LINK);
		clickToElement(driver, TravelSearchPageUI.FILTER_SEE_MORE_LINK);
	}

	public void searchByFilterWithRadioButton() {
		waitForControlClickable(driver, TravelSearchPageUI.FILTER_PROMOTIONS_SHOW_ALL_RADIO_BUTTON);
		clickToElement(driver, TravelSearchPageUI.FILTER_PROMOTIONS_SHOW_ALL_RADIO_BUTTON);		
	}
	
	public void searchByFilterWithCheckbox() {		
		waitForControlClickable(driver, TravelSearchPageUI.FILTER_INSURERS_PRUDENTIAL_CHECKBOX);
		checkTheCheckbox(driver, TravelSearchPageUI.FILTER_INSURERS_PRUDENTIAL_CHECKBOX);
		waitForControlClickable(driver, TravelSearchPageUI.FILTER_INSURERS_STANDARD_CHECKBOX);
		checkTheCheckbox(driver, TravelSearchPageUI.FILTER_INSURERS_STANDARD_CHECKBOX);
	}

	public void searchByAscendingSort() {
		waitForControlClickable(driver, TravelSearchPageUI.SORT_PRICE_ASCENDING_RADIO_BUTTON);
		clickToElement(driver, TravelSearchPageUI.SORT_PRICE_ASCENDING_RADIO_BUTTON);
	}

	public void selectDestinationDropdown(String expectedValueItem) {
		waitForControlClickable(driver, TravelSearchPageUI.DESTINATION_DROPDOWN);
		selectItemInCustomDropdown(driver, TravelSearchPageUI.DETAIL_COLLAPSE,TravelSearchPageUI.DESTINATION_DROPDOWN, TravelSearchPageUI.DESTINATION_DROPDOWN_ITEMS, expectedValueItem);
	}
	
	public void selectStartDateDatePicker(String startDatePicker) {
		waitForControlClickable(driver, TravelSearchPageUI.DETAILS_START_DATE_CALENDAR);
		selectOnCalendarByJS(driver, TravelSearchPageUI.DETAILS_START_DATE_CALENDAR, startDatePicker);		
	}
	
	public void selectEndDateDatePicker(String endDatePicker) {
		waitForControlClickable(driver, TravelSearchPageUI.DETAILS_END_DATE_CALENDAR);
		selectOnCalendarByJS(driver, TravelSearchPageUI.DETAILS_END_DATE_CALENDAR, endDatePicker);
	}
	
	public void selectRangeSelector(String value) {
		waitForControlClickable(driver, TravelSearchPageUI.FILTER_PERSONAL_ACCIDENT_RANGE_SELECTOR);
		sleepInSeconds(2);
		selectOnCalendarByJS(driver, TravelSearchPageUI.FILTER_PERSONAL_ACCIDENT_RANGE_SELECTOR, value);
	}
	
	public boolean checkLeftMenuCheckBoxIsFunctional() {
		waitForControlClickable(driver, TravelSearchPageUI.VERIFY_INSURERS_CHECKBOX);		
		return isDataList(driver, TravelSearchPageUI.VERIFY_INSURERS_CHECKBOX);
	}
	
	public boolean checkLeftMenuSortAscendingRadioButtonIsFunctional() {
		waitForControlClickable(driver, TravelSearchPageUI.VERIFY_ASCENDING_RADIO_BUTTON);		
		return isPriceSortedAscending(driver, TravelSearchPageUI.VERIFY_ASCENDING_RADIO_BUTTON);
	}
}
