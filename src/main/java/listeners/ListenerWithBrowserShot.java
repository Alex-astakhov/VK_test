package listeners;


import core.MethodsFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by Alex Astakhov on 12.06.2016.
 */
public class ListenerWithBrowserShot implements ITestListener {
   // Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
       // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm");
       // Date resultdate = new Date(iTestResult.getEndMillis());
       // pngAttachment(iTestResult.getMethod().getMethodName() +  "_failed_" + sdf.format(resultdate));
        MethodsFactory.pngAttachment(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
