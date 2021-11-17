package pom_Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class HomePage {

	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//span[@class='header-sprite logo']")
	private WebElement goibiboLogo;
	
	@FindBy (id="get_sign_in")
	private WebElement loginBtn;
	
	@FindBy (name="phone")
	private WebElement PhoneNoTextField;
	
	@FindBy(id="gosuggest_inputSrc")
	private WebElement fromTextField;
	
	@FindBy(id="react-autosuggest-1")
	private WebElement autoSuggestions;

	@FindBy(id="gosuggest_inputDest")
	private WebElement destTextField;

	@FindBy (id="departureCalendar")
	private WebElement departureDate;

	@FindBy (id="returnCalendar")
	private WebElement returnDate;
	
	@FindBy (xpath= "//span[@aria-label='Previous Month']")
	private WebElement previousMonthArrow;
	
	@FindBy (xpath= "//span[@aria-label='Next Month']")
	private WebElement nextMonthArrow;

	@FindBy (id="pax_label")
	private WebElement Travellers;
	
	@FindBy(id="adultPaxBox")
	private WebElement adultPaxBox;
	
	@FindBy (id="adultPaxPlus")
	private WebElement adultPlusIcon;
	
	@FindBy (id="adultPaxMinus")
	private WebElement adultMinusIcon;
	
	@FindBy(id="childPaxBox")
	private WebElement childPaxBox;
	
	@FindBy (id="childPaxPlus")
	private WebElement childPlusIcon;
	
	@FindBy (id="childPaxMinus")
	private WebElement childMinusIcon;
	
	@FindBy(id="infantPaxBox")
	private WebElement infantPaxBox;
	
	@FindBy (id="infantPaxPlus")
	private WebElement infantPlusIcon;
	
	@FindBy (id="infantPaxMinus")
	private WebElement infantMinusIcon;
	
	@FindBy (id="gi_class")
	private WebElement travelClassDropdown;
	
	@FindBy(id="gi_search_btn")
	private WebElement searchBtn;
	
	/* Select by Index 
	 * Index 0 = "Economy"
	 * Index 1 = "Business"
	 * Index 2 = "First class"
	 * Index 3 = "Premium Economy"
	 */


	public WebElement getGoibiboLogo() {
		return goibiboLogo;
	}
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getPhoneNoTextField() {
		return PhoneNoTextField;
	}

	public WebElement getFromTextField() {
		return fromTextField;
	}
	
	public WebElement getAutoSuggestions() {
		return autoSuggestions;
	}

	public WebElement getDestTextField() {
		return destTextField;
	}

	public WebElement getDepartureDate() {
		return departureDate;
	}

	public WebElement getReturnDate() {
		return returnDate;
	}
	
	public WebElement getPreviousMonthArrow() {
		return previousMonthArrow;
	}

	public WebElement getNextMonthArrow() {
		return nextMonthArrow;
	}
	
	public WebElement getTravellers() {
		return Travellers;
	}
	
	public WebElement getAdultPaxBox() {
		return adultPaxBox;
	}

	public WebElement getAdultPlusIcon() {
		return adultPlusIcon;
	}

	public WebElement getAdultMinusIcon() {
		return adultMinusIcon;
	}
	
	public WebElement getChildPaxBox() {
		return childPaxBox;
	}

	public WebElement getChildPlusIcon() {
		return childPlusIcon;
	}

	public WebElement getChildMinusIcon() {
		return childMinusIcon;
	}
	
	public WebElement getInfantPaxBox() {
		return infantPaxBox;
	}

	public WebElement getInfantPlusIcon() {
		return infantPlusIcon;
	}

	public WebElement getInfantMinusIcon() {
		return infantMinusIcon;
	}

	public WebElement getTravelClassDropdown() {
		return travelClassDropdown;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
}
