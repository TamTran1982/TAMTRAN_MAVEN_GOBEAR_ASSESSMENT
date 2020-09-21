package gobear.travel.interfaces;

public class TravelSearchPageUI {
	
	public static final String NUMBER_OF_CARD = "//div[contains(@class,'card-full')]";	
	public static final String FILTER_SEE_MORE_LINK = "//a[contains(text(), 'SEE MORE')]";
	public static final String FILTER_PROMOTIONS_SHOW_ALL_RADIO_BUTTON = "//label[contains(text(), 'Show all')]";
	public static final String FILTER_INSURERS_PRUDENTIAL_CHECKBOX = "//label[contains(text(), 'Prudential Guarantee')]";
	public static final String FILTER_INSURERS_STANDARD_CHECKBOX = "//label[contains(text(), 'Standard Insurance')]";
	public static final String FILTER_PERSONAL_ACCIDENT_RANGE_SELECTOR = "//input[@id='gb-slider-1']/following-sibling::b";	
	public static final String SORT_PRICE_ASCENDING_RADIO_BUTTON = "//label[contains(text(), 'Price: Low to high')]";
	public static final String DETAILS_POLICY_SINGLE_RADIO_BUTTON = "//label[contains(text(), 'single trip')]";
	public static final String DETAILS_WHO_FAMILY_RADIO_BUTTON = "//label[contains(text(), 'my family')]";
	public static final String DETAIL_COLLAPSE = "//div[@id='detailCollapse']";
	public static final String DESTINATION_DROPDOWN = "//div[@class='select-component']";
	public static final String DESTINATION_DROPDOWN_ITEMS = "//div[@class='dropdown-menu open']//li[not(contains(@class,'disabled'))]//span";
	public static final String DETAILS_START_DATE_CALENDAR = "//input[@name='dates-startdate']";
	public static final String DETAILS_END_DATE_CALENDAR = "//input[@name='dates-enddate']";	
	public static final String VERIFY_INSURERS_CHECKBOX = "//h4[contains(@class,'name')]";
	public static final String VERIFY_ASCENDING_RADIO_BUTTON = "//span[contains(@class,'value')]";	
	
}
