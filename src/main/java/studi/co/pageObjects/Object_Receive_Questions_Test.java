package studi.co.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import io.appium.java_client.ios.IOSBatteryInfo;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.BaseClass;

public class Object_Receive_Questions_Test extends BaseClass {

	public Object_Receive_Questions_Test() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Test Unit\")")
	public WebElement testUnit;

	@iOSFindBy(id = "nextBtn")
	@AndroidFindBy(id = "com.tce.studi:id/ivNext")
	public WebElement nextBtn;

	@iOSFindBy(id = "previousBtn")
	@AndroidFindBy(id = "com.tce.studi:id/ivPrevious")
	public WebElement previousBtn;

	@iOSFindBy(id = "HumbrgrMenu")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[1]")
	public WebElement hamburgerBtn;

	@iOSFindBy(id = "WebviewQuiz")
	@AndroidFindBy(id = "com.tce.studi:id/layoutQuiz")
	public WebElement question;

	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Submit Test\"])[1]")
	@AndroidFindBy(id = "com.tce.studi:id/tvSubmitTest")
	public WebElement submitTestBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Submit Test\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement submitTestBtnOnPopup;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Return to Test\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtNegativeBtn")
	public WebElement returnToTestPopup;

	@AndroidFindBy(id = "com.tce.studi:id/txtSubtitle")
	public WebElement unattemtQueTxt;

	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Check Answers\"])")
	@AndroidFindBy(id = "com.tce.studi:id/tv_review_id")
	public WebElement reviewAttemt;

	@iOSFindBy(id = "unselectedFlag")
	@AndroidFindBy(id = "com.tce.studi:id/ivFlag")
	public WebElement queFlag;

	@iOSFindBy(xpath = "/XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeImage")
	@AndroidFindBy(id = "com.tce.studi:id/ivFlag")
	public WebElement hamFlag;

	@iOSFindBy(xpath = "//*[contains(@name, 'Marks')]")
	@AndroidFindBy(id = "com.tce.studi:id/tvQuestionMarks")
	public WebElement marks;

	@iOSFindBy(id = "backWithBackground")
	@AndroidFindBy(id = "com.tce.studi:id/iv_left_icon")
	public WebElement backBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Check Answers\"]")
	@AndroidFindBy(id = "com.tce.studi:id/vp_lesson_cards")
	public WebElement objectiveCard;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
	@AndroidFindBy(id = "com.tce.studi:id/cl_confidence_container")
	public WebElement confidenceCtnr;

	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	public WebElement exitTestOK;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtNegativeBtn")
	public WebElement exitTestCancel;

	public Boolean selectCorrectOption(int queNumber) {
		switch (queNumber) {

		case 1:

			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '4')]")));
			test.log(Status.INFO, "Selecting option 4");
			return true;
		case 2:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '1512')]")));
			test.log(Status.INFO, "Selecting option 1512");
			return true;
		case 3:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '40 ÷ [5 × (3 + 5)]')]")));
			test.log(Status.INFO, "Selecting option 40 ÷ [5 × (3 + 5)]");
			return true;
		case 4:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3')]")));
			test.log(Status.INFO, "Selecting option 3");
			return true;
		case 5:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3 × (3 + 5)')]")));
			test.log(Status.INFO, "Selecting option 3 × (3 + 5)");
			return true;
		case 6:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '44')]")));
			test.log(Status.INFO, "Selecting option 44");
			return true;
		default:
			return false;
		}

	}

}
