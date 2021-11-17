package generic_Library;

import java.util.Set;

import org.openqa.selenium.WebDriver;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class WebDriverUtil {
	
	/**
	 * This method is used to close all the child browsers of a Webpage and switch back to the control of Parent Window
	 * @param driver (It accepts the driver as an Argument of WebDriver type)
	 */
	public void closeChildBrowsers(WebDriver driver) {
		String parentWinodwId = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWinodwId);
		for(String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			driver.close();
		}
		driver.switchTo().window(parentWinodwId);
	}

	/**
	 * This method is used to switchTo a particular window based on title and the control is present on the switched window.
	 * @param driver  (It accepts the driver as an Argument of WebDriver type)
	 * @param title	  (It accepts the title of the window as a String Argument)
	 */
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWid = driver.getWindowHandles();
		for( String wid: allWid) {
			driver.switchTo().window(wid);
			String currentTitle = driver.getTitle();
			if(currentTitle.equals(title)) {
				break;
			}
		}
	}
}
