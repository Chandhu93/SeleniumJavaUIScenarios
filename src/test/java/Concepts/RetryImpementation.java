package Concepts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpementation implements IRetryAnalyzer{

	static int count =0;
	static int maxCount = 3;
	@Override
	public boolean retry(ITestResult result) {
		if(count < maxCount) {
			count++;
			System.out.println("Retrying and executing the "+ result.getName()+" "+ count);
			return true;
		}
		return false;
	}
}
