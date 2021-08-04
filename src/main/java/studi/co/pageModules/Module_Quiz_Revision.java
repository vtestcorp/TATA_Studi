package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Quiz_Revision;
public class Module_Quiz_Revision extends BaseClass{
	Object_Quiz_Revision oqr = new Object_Quiz_Revision();
	SoftAssert assert1=new SoftAssert();
	Boolean status;

	public void to_Verify_user_attempt_sorting_question_in_revision_module(String subject1,String topic) throws MalformedURLException, InterruptedException {
		SoftAssert assert1 = new SoftAssert();
		Boolean status;

		traverse_To_Begin_practice(subject1, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(oqr.skip);
		clickOnElement(oqr.skip);

		int questions;
		applyExplicitWaitsUntilElementVisible(oqr.question);
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = oqr.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;

		int actualcount = 0;
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.contains("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int t = 1;
				for (MobileElement mobileElement : answerCount) {
					mobileElement.click();
					Thread.sleep(300);
					if (device.contains("Android"))
						status = Boolean.parseBoolean(mobileElement.getAttribute("focused"));
					else
						status = mobileElement.getAttribute("value").equals("1");
					System.err.println(status);
					if (status) {
						assert1.assertTrue(true);
						test.log(Status.INFO, "Answer " + t + " can be select");
						System.out.println("Answer " + t + " can be select");

					} else
						assert1.assertTrue(false);
					swipeUp();
					t++;
				}
			}
			if (i + 1 != questions)
				clickOnElement(oqr.nextButton);
			i++;
		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");

		test.log(Status.INFO, "User should be able to attempt sorting question in revision module");
		System.out.println("User should be able to attempt sorting question in revision module");

		assert1.assertAll();


	}


	public void to_verify_user_is_able_to_drag_drop_all_options_in_place_holder_to_answer_the_sorting_question(
			String property, String property2) {
		// TODO Auto-generated method stub

	}

	public void to_Verify_not_mandatory_in_Revise_module_to_attempt_each_question(String subject1, String topic) throws InterruptedException, MalformedURLException {
		traverse_To_Begin_practice(topic, topic);
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert assert1 = verify_Quiz_Is_Not_Mandatory();
		assert1.assertAll();
	}

	public void to_Verify_user_can_easily_skip_continue_to_next_question_without_attempting_current_one(String property,
			String property2) {


	}

	public void to_Verify_If_user_chooses_1option_right_another_wrong_the_answers_considered_partially_correct_in_sorting_question(String subject1,String topic) throws MalformedURLException, InterruptedException {

		traverse_To_Begin_practice(subject1, topic);

		SoftAssert assert1 = new SoftAssert();
		applyExplicitWaitsUntilElementVisible(oqr.question);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		applyExplicitWaitsUntilElementVisible(oqr.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting one partially correct answer for question " + (i + 1));
				System.out.println("Selecting one partially correct answer for question " + (i + 1));
				selectPartialCorrectAnswer();

				test.log(Status.INFO, "Clicked on Check Answer button");
				System.out.println("Clicked on Check Answer button");
				clickOnElement(oqr.check_answer);

				//swipeTop();

				test.log(Status.INFO, "Verifying feedback after answer selection");
				System.out.println("Verifying feedback after answer selection");
				status = oqr.answerPartialCorrectMsg1.isDisplayed();

				assert1.assertTrue(status);
				if (status) {
					System.err.println("Shown correct feedback for partial answer selection");
					test.log(Status.INFO, "Shown correct feedback for partial answer selection");
				} else {
					System.err.println("Shown Incorrect feedback for partial answer selection");
					test.log(Status.INFO, "Shown Incorrect feedback for partial answer selection");
				}
				swipeDown();

				clickOnElement(oqr.dontKnowBtn);
				Thread.sleep(1000);
				swipeDown();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if ((i + 1) != questions) {
					if (device.contains("Android"))
						clickOnElement(oqr.conti_nue);
					else
						clickOnElement(findElementByText("Continue"));
				}
				i++;
			} else {
				i++;
				clickOnElement(oqr.attempt_later);
			}

		}

		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		assert1.assertAll();

	}
	public void traverse_To_Begin_practice(String subject1, String topic)
			throws MalformedURLException, InterruptedException {

		applyExplicitWaitsUntilElementVisible(oqr.testUnit);

		if (device.contains("Android"))
			swipeUp();
		else
			scrollTo2("Syllabus");
		clickOnElement(findElementByText("Syllabus"));
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");
		applyExplicitWait(5);

		scrollTo2(subject1);
		test.log(Status.INFO, "Opening " + subject1);
		System.out.println("Opening " + subject1);
		clickOnElement(findElementByText(subject1));

		scrollTo2(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		clickOnElement(findElementByText(topic));

		scrollTo2("Practice");
		test.log(Status.INFO, "Opening revision for " + topic);
		System.out.println("Opening revision for " + topic);

		try {

			clickOnElement(findElementByText("Revis"));
		} catch (Exception e) {

			clickOnElement(findElementByText("Revise"));
		}

		Thread.sleep(3000);

		try {
			applyExplicitWaitsUntilElementVisible(oqr.why_tested_msg);
			clickOnElement(findElementByText("Revis"));
		} catch (Exception e) {
			if (device.contains("Android"))
				clickOnElement(findElementByText("Revis"));
			else
				clickOnElement(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Revise again\"]")));
		}
	}
	public void startTest() throws MalformedURLException, InterruptedException {
		if (device.contains("Android"))
			clickOnElement(getDriver().findElementById("com.tce.studi:id/tvPrimaryAction"));
		else
			clickOnElement(getDriver().findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		try {
			applyExplicitWaitsUntilElementVisible(findElementByExactText("Redo Test"));
			tapOnElement(findElementByText("Redo Test"));
		} catch (Exception e) {
			System.out.println("Fresh Test");
		}
		applyExplicitWait(5);

		applyExplicitWaitsUntilElementClickable(oqr.testUnit);

		test.log(Status.INFO, "Opening Test Unit");
		System.out.println("Opening Test Unit");
		clickOnElement(oqr.testUnit);

		applyExplicitWait(5);
		scrollTo1("Practice 1");
		applyExplicitWait(5);
		if (device.contains("Android")) {
			System.err.println("test 1");
			ArrayList<MobileElement> mobileElement = (ArrayList<MobileElement>) getDriver()
					.findElements(By.xpath("//*[contains(@resource-id,\"tvChapterType\")]"));
			for (MobileElement mobileElement2 : mobileElement) {
				if (mobileElement2.getText().trim().equalsIgnoreCase("Test")) {
					clickOnElement(mobileElement2);
					break;
				}
			}
		} else
			clickOnElement(findElementByExactText("Test"));
		System.out.println("Opening Test");
		test.log(Status.INFO, "Opening Test");
		Thread.sleep(3000);
	}


	public void to_Verify_user_Feedback_provided_at_the_click_of_options_itself(String subject1, String topic) throws MalformedURLException, InterruptedException {
		traverse_To_Begin_practice(subject1, topic);
		SoftAssert assert1 = new SoftAssert();
		applyExplicitWaitsUntilElementVisible(oqr.question);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		applyExplicitWaitsUntilElementVisible(oqr.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));
				selectCorrectAnswer();

				test.log(Status.INFO, "Clicked on Check Answer button");
				System.out.println("Clicked on Check Answer button");
				//swipeDown();
				//clickOnElement(oqr.check_answer);
				clickOnElement(findElementByText("Check"));
				test.log(Status.INFO, "Verifying feedback after answer selection");
				System.out.println("Verifying feedback after answer selection");
				status = oqr.answerCorrectMsg1.isDisplayed();

				assert1.assertTrue(status);
				if (status) {
					System.err.println("Shown correct feedback for correct answer selection");
					test.log(Status.INFO, "Shown correct feedback for correct answer selection");
				} else {
					System.err.println("Shown Incorrect feedback for correct answer selection");
					test.log(Status.INFO, "Shown Incorrect feedback for correct answer selection");
				}

				if ((i + 1) != questions)
					clickOnElement(oqr.conti_nue);
				i++;
			} else {
				i++;
				clickOnElement(oqr.attempt_later);
			}

		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		assert1.assertAll();

	}
	public SoftAssert verify_Quiz_Is_Not_Mandatory() throws MalformedURLException, InterruptedException {
		SoftAssert assert1 = new SoftAssert();
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oqr.question);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oqr.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.contains("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				status = answerCount.size() > 1 ? true : false;
				assert1.assertTrue(status, "Multiple answers not available for question " + (i + 1));
				System.out.println("Multiple answers available for question " + (i + 1));
				test.log(Status.INFO, "Multiple answers available for question " + (i + 1));
			}
			if ((i + 1) != questions)
				clickOnElement(oqr.nextBtn);
			i++;
		}
		System.out.println("Reaching to last question without any answer selection");
		test.log(Status.INFO, "Reaching to last question without any answer selection");

		System.out.println("Try to exit test");
		test.log(Status.INFO, "Try to exit test");

		test.log(Status.INFO, "Pressing back button");
		System.out.println("Pressing back button");
		if (device.contains("Android"))
			driver.navigate().back();
		else
			clickOnElement(oqr.backBtn);
		clickOnElement(oqr.exitTestOK);

		status = oqr.objectiveCard.isEnabled();
		assert1.assertTrue(status);
		if (status) {
			test.log(Status.INFO, "Test ended");
			System.out.println("Test ended");
		}
		return assert1;
	}


}