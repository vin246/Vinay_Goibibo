package generic_Library;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public interface IAutoConstants {
	
	String CHROME_KEY ="webdriver.chrome.driver";
	String CHROME_VALUE ="./src/main/resources/chromedriver.exe";
	
	String FIREFOX_KEY ="webdriver.gecko.driver";
	String FIREFOX_VALUE="./src/main/resources/geckodriver.exe";
	
	String RESOURCE_PATH="./src/test/resources/goibiboData.xlsx";
	String ERROR_SHOTS_PATH="./errorshots";
	
	String URL ="https://www.goibibo.com/";
}
