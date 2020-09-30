package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {
    WebDriver driver;

    public void onTestStart(ITestResult iTestResult) {
        System.out.println((String.format("======================================== STARTING TEST %s ========================================", iTestResult.getName())));

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.printf("=======================================FINISHED TEST %s Duration: %ss ========================================%n", iTestResult.getName(),
                getExecutionTime(iTestResult));

    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.printf("======================================== FAILED TEST %s Duration: %ss ========================================%n", iTestResult.getName(),
                getExecutionTime(iTestResult));
        takeScreenshot(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.printf("======================================== SKIPPING TEST %s ========================================%n", iTestResult.getName());
        takeScreenshot(iTestResult);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();

        try {
            return ((TakesScreenshot) context.getAttribute("driver")).getScreenshotAs(OutputType.BYTES);
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return null;
        }
    }


    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
