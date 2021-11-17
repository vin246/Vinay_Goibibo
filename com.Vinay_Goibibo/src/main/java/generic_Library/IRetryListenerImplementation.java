package generic_Library;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class IRetryListenerImplementation implements IRetryAnalyzer{

	int count =  1;
	int retryCount = 3;
//	@Override
	public boolean retry(ITestResult result) {
		if(count <= retryCount) {
			System.out.println("Retrying for "+count+" time");
			count++;
			return true;
		}else {
			return false;	
		}
	}

}
