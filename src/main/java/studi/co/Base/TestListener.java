package studi.co.Base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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

public class TestListener extends BaseClass implements ITestListener {
	public TestListener() throws MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		System.out.println("On Test Start : " + result.getName());
		test.log(Status.INFO, "On Test Start : " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.INFO, "On Test Success : " + result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		String passedTCScreenshotPath = screenshotforExtentReport(getDriver(), result.getName());
		try {
			test.pass(result.getName() + " Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(passedTCScreenshotPath).build());
		} catch (IOException e) {
			System.out.println("File not not found");
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getName().equals("TC_18_Verify_Behaviour_In_Sleep_Mode")) {
		} else {
			System.out.println("On Test Failure : " + result.getName());
			test.log(Status.FAIL, "On Test Failure : " + result.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			test.log(Status.INFO, "Fails Test");
			test.log(Status.FAIL, result.getThrowable());

			String failedTCScreenshotPath = screenshotforExtentReport(getDriver(), result.getName());
			try {
				test.fail(result.getThrowable().getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(failedTCScreenshotPath).build());
			} catch (IOException e) {
				System.out.println("File not not found");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

	}

	@Override
	public void onStart(ITestContext context) {
		// String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss").format(new
		// Date());
		// String reportName = "Test-Report- " + timeStamp + ".html";
		String reportName = "Test-Report.html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/" + reportName);
		// htmlReporter.setAppendExisting(true);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extents-config.xml");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester", "Author");
		temptest = extent.createTest("Tata Studi");
		temptest.log(Status.INFO, "Tata Studi");
		htmlReporter.config().setReportName("Tata Studi Automation Report");
		htmlReporter.config().setDocumentTitle("E-Learning");// Title of Report
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.removeTest(temptest);
		extent.flush();

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public String screenshotforExtentReport(WebDriver driver, String tcName) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY hh-mm-ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);

		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tcName + " ExtendReport "
				+ datetime + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotPath;

	}

}