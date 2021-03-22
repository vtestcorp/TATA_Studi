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

import org.openqa.selenium.JavascriptExecutor;

import java.awt.AWTException;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import studi.co.pageObjects.Object_Syllabus_Option;

//Handling Config file operations and Extent report initialization
//Included @BeforeSuite & @AfterSuite capabilities for handling various iOS platforms

public class BaseClass {

	public static Boolean notesFlag = false;
	public static ExtentTest test, temptest;
	public static Properties prop; // Property file initialization
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest logger;
	public static String Report_Path = null;
	public static WebDriver dr2;
	public static AppiumDriver<MobileElement> driver;
	public static DesiredCapabilities caps;
	public static URL url;
	public static TouchAction action;
	public static WebDriverWait wait;
	public static Logger log;
	public int actualcount = 0;
	public static Timer timer;
	public static int notesCount;
	static int timerCount = 0;
	public static JFrame frame = new JFrame();
	public static JLabel label = new JLabel("Wait until timer ends : ");
	public static JLabel label2 = new JLabel("1");;
	public static int correctAnswers;
	public static int[] correctAnswer = new int[10];
	public static int wrongAnswers;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/exo_pause\").className(\"android.widget.ImageButton\")")
	public WebElement pauseBtn;
	
	public BaseClass() {
		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\studi\\co\\Config\\config.properties");
			prop.load(ip);
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}
	}

	public static String RandomString() {

		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}

	
	public void selectCorrectAnswer() {
		action = new TouchAction(driver);
		action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(400)))
				.moveTo(PointOption.point(115, 350)).release().perform();
		correctAnswers = 0;
		int i = 0;
		
		Set<String> context = driver.getContextHandles();
				for (String cont : context) {
					if (cont.contains("WEBVIEW"))
						getDriver().context(cont);
				}
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		List<MobileElement> as = driver.findElements(By.tagName("tce-option"));
		for (WebElement s : as) {
			if (s.getAttribute("class").equalsIgnoreCase("tick")) {
				s.click();
				System.err.println((correctAnswers + 1) + "th answer selected");
				correctAnswers++;
			}
			swipeUp();
		}
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		getDriver().context("NATIVE_APP");
	}

	public void selectIncorrectAnswer() {
		Set<String> context = driver.getContextHandles();
		for (String cont : context) {
			if (cont.contains("WEBVIEW"))
				getDriver().context(cont);
		}
		List<MobileElement> as = driver.findElements(By.tagName("tce-option"));

		for (WebElement s : as) {
			System.err.println("checking");
			if (s.getAttribute("class").equalsIgnoreCase("tick")) {
			} else {
				wrongAnswers = 1;
				s.click();
				break;
			}
		}
		getDriver().context("NATIVE_APP");
	}

	public String verifySCQorMCQ() {
		correctAnswers = 0;
		Set<String> context = driver.getContextHandles();
		for (String cont : context) {
					if (cont.contains("WEBVIEW"))
				getDriver().context(cont);
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String as = driver.findElementByXPath("//*[contains(@class, 'theme')]").getTagName();
		getDriver().context("NATIVE_APP");
		System.err.println("as :" + as);
		if (as.contains("scq")) {
			return "SCQ";
		} else if (as.contains("mcq")) {
			return "MCQ";
		} else if (as.contains("subjective")) {
			return "subjective";
		}
			return "OTHR";

	}

	/*
	 * Initializing pre-requisite capabilities necessary for invoking corresponding
	 * device.
	 */

	@BeforeTest
	@Parameters({ "type" })
	public static void beforeTest(String type) throws Exception {
		String s = type;
		caps = new DesiredCapabilities();
		if (s.equalsIgnoreCase("Android")) {
			// caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY223HQBHZ");
			// caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM M105F");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7");
			// caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9
			// PPR1.180610.011");
			// caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			caps.setCapability("appPackage", "com.tce.studi");
			caps.setCapability("appActivity", "com.tce.view.ui.activities.SplashScreenActivity");
			caps.setCapability("app", "C:\\Users\\LENOVO\\Downloads\\Studi_QA_v1.1.19mar.apk");
			caps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
			caps.setCapability(MobileCapabilityType.NO_RESET, true);
			System.out.println("Required Desired Capabilities Defined");
			final String appiumserverUrl = "http://127.0.0.1:4723/wd/hub";
			url = new URL(appiumserverUrl);

			System.out.println("Appium Server URL is entered ");
			driver = new AndroidDriver<MobileElement>(url, caps);

			System.out.println("AndroidDriver Configured with the required Desired Capabilities and URL");
			applyExplicitWait(20);
			// Module_Login login = new Module_Login();
			// login.Login_to_app();

		} else if (s.equalsIgnoreCase("IOS")) {
			caps = new DesiredCapabilities();
			caps.setCapability("automationName", prop.getProperty("automationName"));
			caps.setCapability("deviceName", "iPhone 6s");
			// platform_version=deviceName;
			caps.setCapability("udid", "d179cb05cdb31945cc0ec2e6ba0d3044ff2fd41a");
			caps.setCapability("platformName", "iOS");
			caps.setCapability("platformVersion", "13.3.1");
			caps.setCapability("bundleId", "com.google.Chrome");
			caps.setCapability("appActivity", "com.demo.liveplaces.view.activity.SplashActivity");
			caps.setCapability("noReset", "true");
			// caps.setCapability("wdaLocalPort", wdaLocalPort);
			caps.setCapability("newCommandTimeout", "120");
			AppiumDriver<MobileElement> driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), caps);

			System.out.println("iOSDriver Configured with the required Desired Capabilities and URL");

		} else if (s.equalsIgnoreCase("Jenkins")) {
			caps = new DesiredCapabilities();

			// Set your access credentials
			caps.setCapability("browserstack.user", "bhushans5");
			caps.setCapability("browserstack.key", "CV55rv5TWx9wRXus2oqr");

			caps.setCapability("bundleId", "com.google.Chrome");
			caps.setCapability("appActivity", "com.demo.liveplaces.view.activity.SplashActivity");
			caps.setCapability("app", "bs://ebe9e4d351887da685fd245723d9bc981cf04df1");
			caps.setCapability("os_version", "13");
			caps.setCapability("device", "iPhone 11 Pro");
			caps.setCapability("real_mobile", "true");
			caps.setCapability("autoAcceptAlerts", true);

			// caps.setCapability("browserstack.appium_version", "1.7.1");
			caps.setCapability("browserstack.local", "false");
			driver = new AppiumDriver<MobileElement>(new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);
			System.out.println("Launched");

		}

		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("object_wait_timeout")),
				TimeUnit.SECONDS);

	}

	public static AppiumDriver<MobileElement> getDriver() {

		return (AppiumDriver<MobileElement>) driver;
	}

	public void takeScreenshot1(String screenshotName) throws MalformedURLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY hh-mm-ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		File finalDestination = new File(
				System.getProperty("user.dir") + "//Screenshots//" + screenshotName + "_" + datetime + ".png");
		try {
			FileUtils.copyFile(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE), finalDestination);
		} catch (WebDriverException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void takeScreenshot1() throws MalformedURLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY hh-mm-ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		File finalDestination = new File(System.getProperty("user.dir") + "//Screenshots//"
				+ Thread.currentThread().getStackTrace()[3].getMethodName() + "_" + datetime + ".png");
		try {
			FileUtils.copyFile(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE), finalDestination);
		} catch (WebDriverException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method returns the property for the key which we will pass which are
	 * defined in the .property File in Config file
	 * 
	 * @param key
	 * @param fileNamewithExtension
	 * @return
	 * @throws IOException
	 */
	public static String getPropertyFromPropertyFile(String key) throws IOException {
		String s = prop.getProperty(key);
		return s;
	}

	/**
	 * This method performs click operation on the element which we have passed as
	 * an argument
	 * 
	 * @param element
	 * @throws MalformedURLException
	 */
	public static void clickOnElement(WebElement element) {
		System.out.println("Clicking on element " + element.getText());
		// test.log(Status.INFO,"Clicking on element " + element.getText());
		try {
			applyExplicitWaitsUntilElementVisible(element);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.click();
	}

	public static String getBetweenStrings(String text, String textFrom, String textTo) {

		String result = "";

		// Cut the beginning of the text to not occasionally meet a
		// 'textTo' value in it:
		result = text.substring(text.indexOf(textFrom) + textFrom.length(), text.length());

		// Cut the excessive ending of the text:
		result = result.substring(0, result.indexOf(textTo));

		return result;
	}

	/**
	 * This method will send the text at the location for which we have specified
	 * the locator
	 * 
	 * @param element    at which we want to send the text
	 * @param text:which we want to send
	 */
	public static void sendText(WebElement element, String text) {
		System.out.println("Sending Text in the Text Input Field");
		// test.log(Status.INFO,"Sending Text in the Text Input Field");
		element.sendKeys(text);

	}

	/**
	 * This method clears the text if there is already some pre-typed/saved text in
	 * the textbox
	 * 
	 * @param:element Accepts a paramter for the element which we want to clear the
	 *                        text
	 */
	public static void clearText(WebElement element) {
		System.out.println("Clearing the previousy entered Text if any");
		// test.log(Status.INFO,"Clearing the previousy entered Text if any");
		element.clear();
	}

	/**
	 * This method will return the text value of the Element of our interest which
	 * we have passed as an argument
	 */
	public static String getTextOfElement(WebElement element) {
		System.out.println("Geting the text property of the given Element");
		// test.log(Status.INFO,"Geting the text property of the given Element");
		String s = element.getText();
		return s;
	}

	/**
	 * This method will perform scroll function until an element for which the text
	 * is matching and we pass this as an argument
	 * 
	 * @param text
	 */
	public static void scrollTo1(String text) {
		System.out.println("Scrolling to the Element which has the given text property : " + text);
		// test.log(Status.INFO,"Scrolling to the Element which has the given text
		// property : " + text);
		getDriver().findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
	}

	/**
	 * This method performs
	 * 
	 * @param text
	 */
	public static void scrollTo2(String text) {
		System.out.println("Scrolling to the Element which has the given text property : " + text);
		getDriver().findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ text + "\").instance(0))"));
	}

	public static void scrollTo3(String text, int instance) {
		System.out.println("Scrolling to the Element which has the given text property : " + text);
		getDriver().findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ text + "\").instance(" + (instance - 1) + "))"));
	}

	/**
	 * This will apply fluent wait until the given element is visible
	 * 
	 * @param element:Accepts WebElement element as an argumentS
	 * @throws MalformedURLException
	 */
	public static void applyExplicitWaitsUntilElementVisible(WebElement element) throws MalformedURLException {
		System.out.println("Applying Explicit wait until the given element is visible");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * This method will apply fluent wait until the specified element becomes
	 * clickable
	 * 
	 * @param element
	 */
	public static void applyExplicitWaitsUntilElementClickable(WebElement element) {
		System.out.println("Applying explicit wait until the given element is clickable");
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.withTimeout(15, TimeUnit.SECONDS);
	}

	/**
	 * This method will give explicit wait for the specified duration
	 * 
	 * @param timeInSeconds
	 * @throws MalformedURLException
	 */
	public static void applyExplicitWait(int timeInSeconds) throws MalformedURLException {
		System.out.println("Applying explicit wait for the given time duration in seconds : " + timeInSeconds);
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.withTimeout(timeInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * This method apply implicit wait and takes argument as integer value as time
	 * duration in seconds for which time the wait will be applied for
	 * 
	 * @param timeInSeconds
	 * @throws MalformedURLException
	 */

	public static void applyImplicitWait(int timeInSeconds) throws MalformedURLException {
		System.out.println("Applying implicit wait for the given time duartion in Seconds : " + timeInSeconds);
		getDriver().manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * This method will give us the attribute or property value for the element of
	 * our interest and it needs that WebElement as well as the attribute key
	 * 
	 * @param : Locator of type accessibilityID
	 * @param:elementPropertyOrAttribute for which we want to get the
	 *                                       property/attribute value
	 * @return value of the property/attribute
	 * @throws MalformedURLException
	 */
	public static String getElementAttribute(WebElement element, String attributeKey) throws MalformedURLException {
		System.out.println("Geting the value for the attribute/property for the given mobile element");
		// test.log(Status.INFO,"Geting the value for the attribute/property for the
		// given mobile element");
		MobileElement ele = (MobileElement) element;
		// Keyword.applyImplicitWait(20);
		applyExplicitWait(5);
		String value = ele.getAttribute(attributeKey);
		return value;

	}

	public int getTotalQuestionsInPractice() {
		MobileElement ele = getDriver().findElement(By.xpath("//*[contains(@text, '1 of')]"));
		String temp[] = ele.getText().split(" ");
		return Integer.parseInt(temp[temp.length - 1]);
	}

	public int getCurrentQuestionInPractice(int totalQue) {
		MobileElement ele = getDriver().findElement(By.xpath("//*[contains(@text, 'of '" + totalQue + ")]"));
		String temp[] = ele.getText().split(" ");
		return Integer.parseInt(temp[0]);
	}

	public static int getBetweenString(WebElement ele, String firstString, String secondString) {
		String text = ele.getText();
		System.out.println(text);
		String betweenString = getBetweenStrings(text, firstString, secondString).trim();
		System.out.println(betweenString);
		int betweenValue = Integer.parseInt(betweenString);
		return betweenValue;

	}

	public void deleteNotesCount() throws InterruptedException {
		System.err.println("Called");
		try {
			applyExplicitWaitsUntilElementVisible(findElementByText("Notes"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MobileElement> notes = (List<MobileElement>) driver.findElementsById("com.tce.studi:id/clRootView");
		System.err.println("Total notes :" + notes.size());
		for (int i = 0; i < notes.size(); i++) {
			// applyExplicitWaitsUntilElementClickable(mobileElement);
			Thread.sleep(5000);
			driver.findElementById("com.tce.studi:id/clRootView").click();
			clickOnElement(driver.findElementById("com.tce.studi:id/ivDeleteNote"));
			clickOnElement(driver.findElementById("com.tce.studi:id/txtPositiveBtn"));
			System.out.println("deleted");
		}
		clickOnElement(driver.findElementById("com.tce.studi:id/ivCross"));
	}

	public void swipeUp() {
		action = new TouchAction(driver);
		action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(115, 350)).release().perform();
	}

	public void swipeDown() {
		action = new TouchAction(driver);
		action.press(PointOption.point(115, 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(115, 650)).release().perform();
	}

	public void swipeLeft() {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		System.out.println(size.height + "height");
		System.out.println(size.width + "width");
		System.out.println(size);
		int startPoint = (int) (size.width * 0.99);
		int endPoint = (int) (size.width * 0.15);
		int ScreenPlace = (int) (size.height * 0.40);
		int y = (int) size.height * 20;

		TouchAction ts = new TouchAction(driver);
		// for(int i=0;i<=3;i++) {
		ts.press(PointOption.point(startPoint, ScreenPlace))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(endPoint, ScreenPlace)).release().perform();

	}

	public static void getColorFromScreenshot(WebElement element) throws HeadlessException, AWTException {
		MobileElement ele = (MobileElement) element;
		Point point = ele.getCenter();
		int centreX = point.getX();
		int centreY = point.getY();
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		int color = image.getRGB(centreX, centreY);
		int red = (color & 0x00ff0000) >> 16;
		int green = (color & 0x0000ff00) >> 8;
		int blue = color & 0x000000ff;
		System.out.println("Red Color value = " + red);
		System.out.println("Green Color value = " + green);
		System.out.println("Blue Color value = " + blue);
	}

	/**
	 * This method will handle when the video starts. It accepts parameter as two
	 * WebElements. The first locator has to be given precisely for the image of the
	 * lower half of the video(click on the player next to the timer when video
	 * starts for getting this locator). And the second locator is of the video end
	 * time
	 * 
	 * @param element1
	 * @param element2
	 * @throws IOException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 * 
	 * @throws MalformedURLException
	 */
	public static void forwardVideoTimerToEnd() throws WebDriverException, IOException, InterruptedException {
		action = new TouchAction(getDriver());
		WebElement seekBar = (MobileElement) driver.findElementByClassName("android.widget.SeekBar");
		// get location of seek bar from left
		int start = seekBar.getLocation().getX();
		System.out.println("Startpoint - " + start);

		// get location of seekbar from top
		int y = seekBar.getLocation().getY();
		System.out.println("Yaxis - " + y);

		// Get total width of seekbar
		int end = seekBar.getSize().getWidth();
		System.out.println("End point - " + end);

		action.press(PointOption.point(start, y)).moveTo(PointOption.point(end + start - 3, y)).release().perform();
		getDriver().findElementByAccessibilityId("Play").click();

		applyExplicitWaitsUntilElementVisible(driver.findElementById("com.tce.studi:id/layoutQuiz"));
	}

	public static MobileElement findElementByText(String text) {
		return getDriver().findElement(By.xpath("//*[contains(@text, '" + text + "')]"));
	}

	public List<MobileElement> getAllElementsFromPageUsingID(String id) throws Exception {
		System.out.println("startef");
		int c = 0;
		List<MobileElement> topics1 = (List<MobileElement>) driver.findElementsById(id);
		int flag = 0;
		normal: while (flag == 0) {
			swipeVertical(0.8, 0.3, 0.2, 500);
			topics1.addAll(driver.findElementsById(id));
			try {
				// if (driver.findElementById("com.tce.studi:id/tv_ebook").isEnabled())
				// if
				// (ExpectedConditions.visibilityOfElementLocated(By.id("com.tce.studi:id/tv_ebook"))==null)
				if (c++ == 15)
					flag = 1;
			} catch (Exception e) {
				continue normal;
			}
		}
		List<MobileElement> listWithoutDuplicates = new ArrayList<>(new HashSet<>(topics1));
		return listWithoutDuplicates;

	}

	public static void swipeVertical(double startPercentage, double finalPercentage, double anchorPercentage,
			int duration) throws Exception {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * finalPercentage);
		getTouchAction().press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
				.moveTo(PointOption.point(anchor, endPoint)).release().perform();
	}

	public static void swipeTop() throws Exception {
		System.out.println("Swiping top");
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * 0.2);
		int startPoint = (int) (size.height * 0.3);
		int endPoint = (int) (size.height * 0.8);
		getTouchAction().press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(anchor, endPoint))
				.release().perform();
	}

	public static TouchAction getTouchAction() {
		return new TouchAction(driver);
	}

	public String check_For_MSQ_or_SCQ() throws InterruptedException {
		Thread.sleep(200);
		int ansFlag = 0;
		int count = 0;
		try {
			ArrayList<MobileElement> answerCount = (ArrayList<MobileElement>) getDriver()
					.findElementsByClassName("android.widget.CheckBox");
			System.out.println("Answer Count " + answerCount.size());
			ansFlag = 1;

			for (MobileElement mobileElement : answerCount) {
				mobileElement.click();
				System.out.println(mobileElement.getText() + " Clicked");
			}

			for (MobileElement mobileElement : answerCount) {
				Thread.sleep(200);
				if (getElementAttribute(mobileElement, "checked").trim().equalsIgnoreCase("true")) {
					System.out.println("count " + (++count));
					applyExplicitWait(5);
					clickOnElement(mobileElement);
					mobileElement.clear();
					System.out.println(mobileElement.getText() + " checked");
				}

			}
			answerCount = (ArrayList<MobileElement>) getDriver().findElementsByClassName("android.widget.CheckBox");
			for (MobileElement mobileElement : answerCount) {
				Thread.sleep(200);
				if (getElementAttribute(mobileElement, "checked").trim().equalsIgnoreCase("true")) {
					applyExplicitWait(5);
					clickOnElement(mobileElement);

				}

			}

			if (count > 1)
				ansFlag = 2;
			System.out.println("count " + count);

		} catch (Exception e) {
			System.out.println("Exception ocurred at MCQ.SCQ cheking module");
		}
		if (ansFlag == 0)
			return "none";
		else if (ansFlag == 2) {
			actualcount++;
			return "MCQ";
		} else
			return "SCQ";

	}

	public String verify_TQ_Resource() throws MalformedURLException {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (getDriver().findElement(By.xpath(
					"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
					.isDisplayed())
				return "Video";
		} catch (Exception e) {
		}
		try {
			if (getDriver().findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout")
					.isDisplayed())
				return "Quiz";
		} catch (Exception e) {
		}
		return " ";

	}

	public static void sendTestUsingRobot(String keys) throws AWTException {
		Robot robot = new Robot();
		for (char c : keys.toCharArray()) {

			if (c == '@') {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_2);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_2);
			} else {
				int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
				/*
				 * if (KeyEvent.CHAR_UNDEFINED == keyCode) { throw new
				 * RuntimeException("Key code not found for character '" + c + "'"); }
				 */
				robot.keyPress(keyCode);
				robot.delay(100);
				robot.keyRelease(keyCode);
				robot.delay(100);
			}
		}
	}

	public void closePopup() {
		try {
			while (getDriver().findElementById("com.tce.studi:id/tutorialDoNotShow").isDisplayed()) {
				clickOnElement(getDriver().findElementById("com.tce.studi:id/tutorialDoNotShow"));
			}
		} catch (Exception e) {
			test.log(Status.INFO, "Popup closed");
		}
	}

	public static void closeVideoPopup() throws InterruptedException {
		int c = 1;
		// notesCount=4;
		System.err.println(notesCount + " Notes");
		while (notesCount > 0) {
			try {
				if (driver.findElementById("com.tce.studi:id/tv_disruptive_continue").isDisplayed()) {
					clickOnElement(findElementByText("CONTINUE"));
					notesCount--;
					System.err.println("Skipping note " + c);
					test.log(Status.INFO, "Skipping note " + c);
					c++;
				} else
					wait.until(ExpectedConditions
							.visibilityOf(driver.findElementById("com.tce.studi:id/disruptive_note_container")));
			} catch (Exception e) {

			}
		}
		if (notesCount == 0) {
			test.log(Status.INFO, "All Popup closed");
			System.out.println("All Popup closed");

		}
	}

	public void createNoteInVideo(String note) throws MalformedURLException, AWTException {
		Object_Syllabus_Option oso = new Object_Syllabus_Option();
		applyExplicitWait(5);
		clickOnElement(oso.addNotesBtn);
		applyExplicitWait(5);
		clickOnElement(oso.playBtn);

		sendTestUsingRobot(note);
		driver.hideKeyboard();

		applyExplicitWait(5);
		clickOnElement(findElementByText("Save Note"));
		System.out.println("Note " + prop.getProperty("note") + " Saved");
		test.log(Status.INFO, "Note " + prop.getProperty("note") + " Saved");

		applyExplicitWait(2);
		closePopup();

		getDriver().findElement(By.xpath(
				"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
				.click();
		applyExplicitWait(2);
		getDriver().findElementByAccessibilityId("Pause").click();
		System.out.println("Clicked on Pause Button");
		test.log(Status.INFO, "Clicked on Pause Button");

	}

	public static void startCounter(int timer1) {

		Timer timer;
		timerCount = timer1;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new CardLayout());

		label.setForeground(java.awt.Color.WHITE);
		label2.setForeground(java.awt.Color.WHITE);

		frame.setResizable(false);
		frame.setLayout(new GridBagLayout());
		frame.add(label);
		frame.add(label2);
		/*
		 * timer = new Timer(20, new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { timerCount--; if
		 * (timerCount >= 0) { label2.setText(Integer.toString(timerCount + 1)); } else
		 * { ((Timer) (e.getSource())).stop(); frame.dispose(); } } });
		 */
		label.setText("Wait until timer ends : ");
		label2.setText(Integer.toString(timerCount));
		// timer.setDelay(1000);
		// timer.start();
		frame.getContentPane().setBackground(java.awt.Color.GRAY);

		frame.pack();
		frame.setSize(new Dimension(200, 70));
		frame.setMaximumSize(new Dimension(200, 70));
		frame.setLocation(500, 200);

		frame.setVisible(true);
		frame.requestFocus();
	}

	public static void scrollToEnd() {
		action = new TouchAction(driver);
		action.press(PointOption.point(115, 750)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
				.moveTo(PointOption.point(115, 50)).release().perform();
	}

	public static void clickOnCoordinate(int x, int y) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();

	}

	@AfterTest
	public void afterTest() {
		getDriver().quit();

	}

}
