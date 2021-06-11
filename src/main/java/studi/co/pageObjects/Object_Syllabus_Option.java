package studi.co.pageObjects;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import studi.co.Base.BaseClass;

public class Object_Syllabus_Option extends BaseClass {

	public Object_Syllabus_Option() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	@iOSFindBy(id = "skip")
	public static WebElement skip;
	
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther")
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]")
	public static MobileElement videoPlayer;

	@AndroidFindBy(id = "com.tce.studi:id/layoutQuiz")
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"WebviewQuiz\"]")
	public static MobileElement quiz;

	@iOSFindBy(xpath = "//*[@type=\"XCUIElementTypeSlider\"]")
	@AndroidFindBy(className = "android.widget.SeekBar")
	public static MobileElement seekBar;

	public int count = 0;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Let's summarise...\"]")
	@AndroidFindBy(id = "com.tce.studi:id/tv_lets_summarise")
	public WebElement letsSummriseTxt;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"All Subjects\"]")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	public WebElement allSubjectLbl;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"playIcon\"]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/exo_play\").className(\"android.widget.ImageButton\")")
	public WebElement playBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"pause\"]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/exo_pause\").className(\"android.widget.ImageButton\")")
	public WebElement pauseBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"FastForward 2\"]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/exo_ffwd\").className(\"android.widget.ImageButton\")")
	public WebElement fwdBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"FastForward 2\"]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/exo_rew\").className(\"android.widget.ImageButton\")")
	public WebElement bkwdBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"addNotes\"]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/ib_create_note\")")
	public WebElement addNotesBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"humBurger\"]")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView[1]")
	public WebElement hamburgerBtn;

	@AndroidFindBy(id = "com.tce.studi:id/tv_disruptive_continue")
	public WebElement continueOnVdoBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/tvPrimaryAction")
	public WebElement continue_Studying;
	
	@AndroidFindBy(id = "com.tce.studi:id/tvSecondaryAction")
	public WebElement return_to_Subject;
	
	
	@iOSFindBy(xpath = "//XCUIElementTypeImage[@name=\"user\"]")
	@AndroidFindBy(id = "com.tce.studi:id/ivProfile")
	public WebElement profilePic;

	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"WebviewQuiz\"]/XCUIElementTypeOther[2]")
	
	@AndroidFindBy(id ="com.tce.studi:id/quizWebView")
	public WebElement question;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"backWithBackground\"]")
	@AndroidFindBy(id = "com.tce.studi:id/iv_left_icon")
	public WebElement backBtn;
	

	@AndroidFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement yesBtn;

	@AndroidFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
	@AndroidFindBy(id ="com.tce.studi:id/txtNegativeBtn")
	public WebElement noBtn;

	@AndroidFindBy(id ="com.tce.studi:id/txtNegativeBtn")
	public WebElement next_topic;
	
	@iOSFindBy(id = "tertiaryBtn")
	@AndroidFindBy(id = "com.tce.studi:id/ivTertiaryAction")
	public WebElement tertiaryBtnBottom;

	public int notesLimit = 3000;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextView")
	@AndroidFindBy(id = "com.tce.studi:id/etNotes")
	public WebElement noteTxtArea;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save Note\"]")
	@AndroidFindBy(id ="com.tce.studi:id/tvSaveNote")
	public WebElement saveNoteBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Discard\"]")
	@AndroidFindBy(id = "com.tce.studi:id/tvDiscard")
	public WebElement discardNoteBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"WhiteBgCross\"]")
	@AndroidFindBy(id = "com.tce.studi:id/ivCross")
	public WebElement closeNotesBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Are you sure you would like to discard the changes? \"]")
	//@AndroidFindBy(id = "com.tce.studi:id/tv_discard_confirmation")
	@AndroidFindBy(id = "com.tce.studi:id/tvDiscardConfirmation")
	public WebElement discardWarnMsg;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"tick\"]")
	//@AndroidFindBy(id = "com.tce.studi:id/ib_discard_accept")
	@AndroidFindBy(id = "com.tce.studi:id/ivDiscardAccept")
	public WebElement discardAcceptBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"cross\"]")
	//@AndroidFindBy(id = "com.tce.studi:id/ib_discard_deny")
	@AndroidFindBy(id = "com.tce.studi:id/ivDiscardDeny")
	public WebElement discardDenyBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther")
	//@AndroidFindBy(id = "com.tce.studi:id/tv_notes_indicator")
	@AndroidFindBy(id = "com.tce.studi:id/tvNotesIndicator")
	public WebElement notesCountIndicator;
	
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
	public WebElement hamburgerNotes;
	
	@AndroidFindBy(id="com.tce.studi:id/iv_right_action_primary")
	public WebElement forward;
	


	public void traverse_toward_syllabus() throws MalformedURLException {
		applyExplicitWait(5);
		scrollTo1("Syllabus");
		applyExplicitWait(5);
		clickOnElement(findElementByText("Syllabus"));
		applyExplicitWait(5);

	}

	public void traverse_toward_subject(String subject) throws MalformedURLException {
		applyExplicitWait(5);
		scrollTo1("Syllabus");
		applyExplicitWait(5);
		clickOnElement(findElementByText("Syllabus"));
		applyExplicitWait(5);

		scrollTo1(subject);
		applyExplicitWait(2);
		clickOnElement(findElementByExactText(subject));
		applyExplicitWait(5);

	}

	public void traverse_toward_topic(String subject, String topic) throws MalformedURLException, InterruptedException {

		applyExplicitWait(5);
		scrollTo1("Syllabus");
		applyExplicitWait(5);
		clickOnElement(findElementByText("Syllabus"));
		applyExplicitWait(5);

		scrollTo1(subject);
		applyExplicitWait(2);
		clickOnElement(findElementByExactText(subject));
		applyExplicitWait(5);

		scrollTo2(topic);
		applyExplicitWait(2);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);

		Thread.sleep(500);
		action = new TouchAction(driver);
		if (device.contains("Android"))
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(700)))
					.moveTo(PointOption.point(115, 450)).release().perform();
		else
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(700)))
					.moveTo(PointOption.point(115, 550)).release().perform();

		try {
			if (findElementByText("Notes").isDisplayed()) {
				notesFlag = true;
				System.out.println("Notes available");
				clickOnElement(findElementByText("Notes"));
				deleteNotesCount();
			} else {
				notesFlag = false;
				System.out.println("Notes not available");
			}
		} catch (Exception e) {
			System.out.println("Notes not created previously");
		}
	}

	public void startRevision1() throws MalformedURLException {
		Boolean status;
		scrollTo2("Practice");
		clickOnElement(findElementByText("Revis"));
		test.log(Status.INFO, "Clicked on Start Revision");
		System.out.println("Clicked on Start Revision");
		applyExplicitWait(5);
					status = findElementByText("you").isDisplayed();
		
		if (status) {
			System.out.println("List of TQ's Displayed");
			test.log(Status.INFO, "List of TQ's Displayed");

		}
	}

	public void startRevision2() throws MalformedURLException, InterruptedException {

		Thread.sleep(2000);
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;
		while (flag == 0) {
			try {
				applyExplicitWait(5);
				status = findElementByText("Begin Revis").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Begin Revision button Displayed");
					test.log(Status.INFO, "Begin Revision button Displayed");
					clickOnElement(findElementByText("Begin Revision"));
					flag = 1;
				}
			} catch (Exception e) {

				applyExplicitWait(5);
				if (device.contains("Android"))
					status = findElementByText("Revise again").isDisplayed();
				else
					status = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Revise again\"]"))
							.isEnabled();
				sAss.assertTrue(status);
				if (status) {

					System.out.println("Revise again button Displayed");
					test.log(Status.INFO, "Revise again button Displayed");

					if (device.contains("Android"))
						clickOnElement(findElementByText("Revise again"));
					else
					{
						MobileElement btn=driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Revise again\"]"));
						  driver.performTouchAction(new TouchAction(driver).tap(PointOption.point(((btn.getLocation().x)+(btn.getSize().width/2)),((btn.getLocation().y)+(btn.getSize().height/2)))));
					}
					
					System.out.println("Clicking on Revise again");
					test.log(Status.INFO, "Clicking on Revise again");

					flag = 1;
				}

			}

		}
	}

	public void deleteNote() {
		clickOnElement(hamburgerBtn);
		clickOnElement(findElementByText("Notes"));

	}

}
