package test_Scripts;
//validate_Whether_User_Should_Be_Able_To_Add_The_Passengers_As_Adult_Child_Infant
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic_Library.BaseClass;
import pom_Object_Repository.HomePage;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class TC_Flights_13Test extends BaseClass{
	@Test(dataProvider="goibiboData", groups= {"smoke", "regression"})
	public void validate_Whether_User_Should_Be_Able_To_Add_The_Passengers_As_Adult_Child_Infant (String[] arr) {
		//Precondition
		String url = "https://www.goibibo.com/";
		String homepageTitle = "Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off";
		HomePage homepage = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions actions = new Actions(driver);
		String   actualFromData =arr[0];
		String   actualToData =arr[1];
		String Date = arr[2];

		//==============================================================================================================================================
		//Step -1 Validate URL
		String currentUrl = driver.getCurrentUrl();
		assertEquals(url, currentUrl, "URL is not entered properly");

		//==============================================================================================================================================
		//Step-2 Validate Homepage is displayed or not
		String actualhomepageTitle = driver.getTitle();
		assertEquals(actualhomepageTitle, homepageTitle , "HomePage is not displayed");

		//==============================================================================================================================================
		//Step3: Validate From Text field	
		WebElement fromTextField = homepage.getFromTextField();
		fromTextField.clear();
		fromTextField.sendKeys(actualFromData);
		String fromTextFieldData = fromTextField.getAttribute("value");
		WebElement ele = homepage.getAutoSuggestions();
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		actions.sendKeys(Keys.ARROW_DOWN).perform();;
		actions.sendKeys(Keys.ENTER).perform();
		assertEquals(actualFromData, fromTextFieldData, "From Data is not entered properly");
		//==============================================================================================================================================
		//Step4: Validate Destination Text Field
		WebElement destinationTextField = homepage.getDestTextField();
		destinationTextField.clear();
		destinationTextField.sendKeys(actualToData);
		String destinationTextFieldData = destinationTextField.getAttribute("value");
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();
		assertEquals(actualToData, destinationTextFieldData, "Destination Data is not entered properly");
		//==============================================================================================================================================
		//Step5: Validate Departure Date Text Field
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[contains(@aria-label, '"+Date+"')]")).click();
				break;
			}
			catch(NoSuchElementException e) {
				homepage.getNextMonthArrow().click();
			}			
		}
		String actualDate = homepage.getDepartureDate().getAttribute("value");
		String date1 = Date.substring(4, 6);
		if(actualDate.contains(date1)) {
			//System.out.println("Departure Date Field Entered Properly");
		}else {
			System.out.println("Departure Date Field Entered Properly");
		}
		//==============================================================================================================================================
		//Step6: Validate Adult, Child, Infant is able to add as a Passenger

		homepage.getTravellers().click();
		int adultCountValue=2;
		homepage.getAdultPlusIcon().click();
		int actualAdultCountValue = Integer.parseInt(homepage.getAdultPaxBox().getAttribute("value"));
		assertEquals(adultCountValue, actualAdultCountValue, "Adult is not added as a Passenger");


		int childCountValue=1;
		homepage.getChildPlusIcon().click();
		int actualChildCountValue = Integer.parseInt(homepage.getChildPaxBox().getAttribute("value"));
		assertEquals(childCountValue, actualChildCountValue ,"Child is not added as a Passenger");

		int infantCountValue=1;
		homepage.getInfantPlusIcon().click();
		int actualInfantCountValue = Integer.parseInt(homepage.getInfantPaxBox().getAttribute("value"));
		assertEquals(infantCountValue, actualInfantCountValue ,"Infant is not added as a Passenger");

		//==============================================================================================================================================
		//Step7: Search for Flights
		homepage.getSearchBtn().click();

		homepage.getGoibiboLogo().click();
	}
}
