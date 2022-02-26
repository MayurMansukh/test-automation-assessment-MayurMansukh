package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.TakeScreenshot;

public class CustomListener extends TakeScreenshot implements ITestListener
{

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName()+" Testcase test Started ");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of test cases and its details are : "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of test cases and its details are : "+result.getName());
        takeScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skip of test cases and its details are : "+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Failure of test cases and its details are : "+result.getName());
    }

}