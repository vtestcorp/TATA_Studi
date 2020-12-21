package studi.co.Base;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener extends Keyword implements ITestListener {
	public TestListener() throws MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
	}



	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start : " + result.getName());
		test.log(Status.INFO, "On Test Start : " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure : " + result.getName());
		test.log(Status.FAIL, "On Test Failure : " + result.getName());
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		test.log(Status.INFO, "Fails Test");
		test.log(Status.FAIL, result.getThrowable());
		
		
		try {
			test.fail("Test Failed", MediaEntityBuilder
					.createScreenCaptureFromPath(Keyword.takeScreenshotUsingRobot(result.getName())).build());
		} catch (IOException | HeadlessException | AWTException e) {
			System.out.println("File not found" + e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

	}


	@Override
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss").format(new Date());
		String reportName = "Test-Report- " + timeStamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/" + reportName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extents-config.xml");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester", "Author");
		test = extent.createTest("Tata Studi");
		test.log(Status.INFO, "Tata Studi");
		htmlReporter.config().setReportName("Tata Studi Automation Report");
		htmlReporter.config().setDocumentTitle("E-Learning");// Title of Report
		htmlReporter.config().setTheme(Theme.DARK);

	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}