package studi.co.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.BaseClass;

public class Object_Begin_Practice extends BaseClass {
	public Object_Begin_Practice() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[1]")
	public WebElement hamburgerBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Test Unit\")")
	public WebElement testUnit;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	public WebElement syllabus;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Practice')]")
	@AndroidFindBy(id = "com.tce.studi:id/tvPrimaryAction")
	public WebElement primaryAction;

	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"WebviewQuiz\"]")
	//@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]")

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"CHECK ANSWER\"]")
	@AndroidFindBy(xpath ="com.tce.studi:id/tvPrimaryAction")
	public WebElement check_answer;

	//@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"I'll attempt later\"]")
	//@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[3]")
	//public WebElement attempt_later;

	@iOSFindBy(id = "RETRY")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]")
	public WebElement tryAgain;


	@iOSFindBy(id = "Great job! Let's continue.")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Great job! Let's continue.\")" )
	public WebElement answerCorrectMsg1;

	@iOSFindBy(id = "You're close! Try again.")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"You're close! Try again.\")" )
	public WebElement answerPartialCorrectMsg1;

	@iOSFindBy(id = "Good going")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Good going\")" )
	public WebElement answerRightMsg;

	@iOSFindBy(id = "Uh-oh! Give it another shot!")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Uh-oh! Give it another shot!\")")
	//@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View")
	public WebElement answerWrongMsg;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"I'll attempt later\"]")
	@AndroidFindBy(id = "com.tce.studi:id/tvSecondaryAction")
	public WebElement attempt_later;

	@iOSFindBy(id = "You have one attempt left")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"attempt left\")")
	public WebElement attemptLeftsMsg;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"I don't know\"]")
	@AndroidFindBy(id = "com.tce.studi:id/tvSecondaryAction")
	public WebElement dontKnowBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
	@AndroidFindBy(id = "com.tce.studi:id/tvPrimaryAction")
	public WebElement conti_nue;

	@iOSFindBy(id = "backWithBackground" )
	@AndroidFindBy(id = "com.tce.studi:id/iv_left_icon")
	public WebElement backBtn;

	@AndroidFindBy(id ="com.tce.studi:id/layoutQuiz")
	public WebElement question;

	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement yesBtn;

	@AndroidFindBy(id = "com.tce.studi:id/txtNegativeBtn")
	public WebElement noBtn;

	@AndroidFindBy(id = "com.tce.studi:id/btnSubmitTest")
	public WebElement submitTestBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement submitTestPopup;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtNegativeBtn")
	public WebElement returnToTestPopup;

	@AndroidFindBy(id = "com.tce.studi:id/txtSubtitle")
	public WebElement unattemtQueTxt;

	@AndroidFindBy(id = "com.tce.studi:id/tv_review_id")
	public WebElement reviewAttemt;

	@AndroidFindBy(id = "com.tce.studi:id/ibFlag")
	public WebElement queFlag; 

	@AndroidFindBy(id = "com.tce.studi:id/imgFlagId")
	public WebElement hamFlag;

	@AndroidFindBy(id = "com.tce.studi:id/tvQuestionMarks")
	public WebElement marks;

	@AndroidFindBy(id = "com.tce.studi:id/layoutQuiz")
	public WebElement queLayout;


	@AndroidFindBy(id = "com.tce.studi:id/iv_right_action_primary")
	public WebElement forward;

	public void selectCorrectOption(int queNumber) {

		switch (queNumber) {
		case 2:
			// clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3 × (3
			// + 5)')]")));
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '11,128')]")));
			break;
		case 3:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '(7 – 3) ÷ 4')]")));
			//clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '(7 – 3) ÷ 4')]")));
			break;
		case 5:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '40 ÷ [5 × (3 + 5)]')]")));
			//clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '40 ÷ [5 × (3 + 5)]')]")));
			break;
		case 4:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '312')]")));
			//clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '44')]")));
			break;
		case 1:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '4')]")));
		}

	}

	public void selectWrongOption(int queNumber) {

		switch (queNumber) {
		case 2:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '12,228')]")));
			//clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3 × (3 × 5)')]")));
			break;
		case 3:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '4 ÷ (7 – 3)')]")));
			//clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '4 ÷ (7 – 3)')]")));
			break;
		case 5:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '5 ÷ [40 × (3 + 5)]')]")));
			//clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '5 ÷ [40 × (3 + 5)]')]")));
			break;
		case 4:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '412')]")));
			//clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '41')]")));
			break;
		case 1:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '55')]")));
		}

	}
}
