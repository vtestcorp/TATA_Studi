/*
 * Project Name : demo Demo Framework
* Author : vTESTcorp
* Version : V1.0.demo
* Reviewed By : Manjeet
* Date of Creation : Feb 7, 2019
* Modification History :
* Date of change : Feb 15, 2019
* Version : V1.1.demo
* changed function : 
* change description :
* Modified By : Manjeet
*/

package studi.co.Base;

import java.io.File;

import java.io.FileInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;



//Handling Config file operations and Extent report initialization
//Included @BeforeSuite & @AfterSuite capabilities for handling various iOS platforms

public class BaseClass {
	
	public static ThreadLocal<RemoteWebDriver> TLD=new ThreadLocal<RemoteWebDriver>();
	
	public static Properties prop; // Property file initialization
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest logger;
	public static String Report_Path = null;
	public static String platform_version;
	public static RemoteWebDriver driver=null;

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src//main//java//studi//co//Config//config.properties");
			prop.load(ip);
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}
	}

	@BeforeSuite
	public void setUp() {
		try {
			// Initialize Extent Report required static fields. 
			
			System.out.println(System.getProperty("user.dir"));

			String Report_Timestamp = "Extent_Report" + (LocalDateTime.now()).getHour() + "_"
					+ (LocalDateTime.now()).getMinute() + "_" + (LocalDateTime.now()).getSecond();

			Report_Path = System.getProperty("user.dir") + "//test-output//Report//" + Report_Timestamp;
			File f1 = new File(Report_Path);
			f1.mkdir();
			File F2 = new File(Report_Path + "//" + "Snapshot");
			F2.mkdir();

			htmlReporter = new ExtentHtmlReporter(Report_Path + "//STMExtentReport" + "_" + Report_Timestamp + ".html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "Automation Server");
			extent.setSystemInfo("Environment", "Windows-Appium-iOS");
			extent.setSystemInfo("User Name", "vTest QA Team");

			htmlReporter.config().setDocumentTitle("iOS-Appium execution report");
			htmlReporter.config().setReportName("iOS-Appium Execution Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	/*
	 * Initializing pre-requisite capabilities necessary for invoking corresponding
	 * device.
	 */
	@BeforeTest
	@Parameters({ "type", "APPIUM_SERVER_URL", "platformName", "deviceName", "appPackage", "appActivity", "platformVersion", "wdaLocalPort", "iOSversion" })
	public void beforeTest(String type, String APPIUM_SERVER_URL, String platformName, String deviceName, String appPackage, String appActivity, String platformVersion, String wdaLocalPort, String iOSversion)
			throws Exception {
		

		URL url = new URL(APPIUM_SERVER_URL);

		DesiredCapabilities caps = new DesiredCapabilities();
		
		if (type.equalsIgnoreCase("Android")) {			
			caps.setCapability("deviceName", deviceName);
			caps.setCapability("platformName", platformName);
			platform_version=deviceName;
			caps.setCapability("appPackage", appPackage);
			caps.setCapability("appActivity", appActivity);
			caps.setCapability("platformVersion", platformVersion);
			caps.setCapability("newCommandTimeout", "120");
			//caps.setCapability("noReset", "false");
		}
		else {		
			caps.setCapability("automationName", prop.getProperty("automationName"));
			caps.setCapability("deviceName", deviceName);
			platform_version=deviceName;
			caps.setCapability("udid", platformVersion);
			caps.setCapability("platformName", prop.getProperty("platformName"));
			caps.setCapability("platformVersion", iOSversion);
			caps.setCapability("bundleId", prop.getProperty("bundleId"));
			// caps.setCapability("appActivity",
			// "com.demo.liveplaces.view.activity.SplashActivity");
			caps.setCapability("noReset", "true");
			caps.setCapability("wdaLocalPort", wdaLocalPort);
			caps.setCapability("newCommandTimeout", "120");
		}

		driver = new RemoteWebDriver(url, caps); 
		setDriver(driver);
		
		getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);			

	}
	
	public void setDriver(RemoteWebDriver driver) {
		TLD.set(driver);
	}
	
	public RemoteWebDriver getDriver() {
		return TLD.get();
	}
	
	public static String getScreenshot(RemoteWebDriver appiumDriver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) appiumDriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		//String destination = System.getProperty("user.dir") + "\\test-output\\Report\\Snapshot\\"+screenshotName+dateName+".png";
		String destination = Report_Path + "//Snapshot//"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		Files.copy(source, finalDestination);
		return destination;
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws Exception {
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			Thread.sleep(2000);
			String screenshotPath = BaseClass.getScreenshot(getDriver(), result.getName());
			logger.log(Status.FAIL,"Screenshot from : " + screenshotPath,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
			else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
			}
		
	}
	
	@AfterTest
	public void afterTest() {
		getDriver().quit();
		TLD.set(null);
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
