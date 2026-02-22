package Concepts;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryDemo {

    @Test(retryAnalyzer = RetryImpementation.class)
    public void retryDemo() throws Exception {
    	//System.out.println("Using IRetryAnalyzer");
    	//Thread.sleep(3000);
        Assert.assertTrue(false); 
    }
}



