package iRetry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryLogic implements IRetryAnalyzer{

	int initialCount = 0;
	int retryTimes = 3;
	public boolean retry(ITestResult result) {
		if(initialCount < retryTimes) {
			initialCount++;
			return true;
		}
		return false;
	}

}
