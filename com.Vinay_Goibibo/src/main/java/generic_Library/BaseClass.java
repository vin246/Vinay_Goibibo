package generic_Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;

/***
 * 
 * @author Vinay_Dasari
 *
 */
public class BaseClass {
	public static WebDriver driver;
	//public static WebDriverWait wait;

	@DataProvider(name="goibiboData")
	public String[][] multipleData() {
		FileUtil util = new FileUtil();
		return util.readMultipleDataFromExcel(IAutoConstants.RESOURCE_PATH, "Sheet1");
	}
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void launchingBrowser_NavigateToUrl(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(IAutoConstants.CHROME_KEY, IAutoConstants.CHROME_VALUE);
//			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
//			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else  {
			System.setProperty(IAutoConstants.FIREFOX_KEY, IAutoConstants.FIREFOX_VALUE);
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//wait = new WebDriverWait(driver, 10);
		driver.get(IAutoConstants.URL);
	}
	@AfterClass(alwaysRun=true)
	public void quittingTheSeleniumSession() {
		driver.quit();
	}
}
