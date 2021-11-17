package generic_Library;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class ITestListenerImplementation implements ITestListener {
//	@Override  
	public void onTestStart(ITestResult result) {  
	}  

//	@Override  
	public void onTestSuccess(ITestResult result) {   
	}  

//	@Override  
	public void onTestFailure(ITestResult result) {  
		String methodName = result.getMethod().getMethodName();
		String localDateTime = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts =  (TakesScreenshot) BaseClass.driver;
		File tempScreenshot = ts.getScreenshotAs(OutputType.FILE);
		File screenshot1 = new File("./errorshots/"+methodName+localDateTime+".png");
		try {
			FileUtils.copyFile(tempScreenshot, screenshot1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Inside the onTestFailure : "+result.getName()); 	 
	}  

//	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}  

//	@Override  
	public void onStart(ITestContext context) {
	}  

//	@Override  
	public void onFinish(ITestContext context) {   
	}
}
