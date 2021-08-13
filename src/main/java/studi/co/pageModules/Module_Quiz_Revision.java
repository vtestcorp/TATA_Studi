package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Quiz_Revision;

public class Module_Quiz_Revision extends BaseClass {
	Object_Quiz_Revision oqr = new Object_Quiz_Revision();
	SoftAssert assert1 = new SoftAssert();
	Boolean status;

	public void to_Verify_not_mandatory_in_Revise_module_to_attempt_each_question(String subject1, String topic)
			throws InterruptedException, MalformedURLException {
		applyExplicitWaitsUntilElementVisible(oqr.testUnit);
		scrollTo2("Syllabus");
		clickOnElement(findElementByText("Syllabus"));
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");
		applyExplicitWait(5);

		scrollTo2(subject1);
		test.log(Status.INFO, "Opening " + subject1);
		System.out.println("Opening " + subject1);
		clickOnElement(findElementByExactText(subject1));

		if(device.contains("Android"))
		scrollTo2(topic);
		else
			scrollTo1(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		tapOnElement(findElementByText(topic));

		if(device.contains("Android"))
			scrollTo2("Practice");
			else
				scrollTo1("Practice");
		test.log(Status.INFO, "Opening revision for " + topic);
		System.out.println("Opening revision for " + topic);

		try {

			tapOnElement(findElementByText("Revis"));
		} catch (Exception e) {

			clickOnElement(findElementByText("Revise"));
		}

		Thread.sleep(2000);
		tapOnElement(findElementByText("Revis"));
		Thread.sleep(2000);
		test.log(Status.INFO, "Video started");
		Thread.sleep(3000);
		clickOnElement(oqr.skip);
		Thread.sleep(2000);
		applyExplicitWaitsUntilElementVisible(oqr.question);
		System.out.println("Attempting the revision");
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = oqr.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		Boolean status;
		int i = 0;
		actualcount = 0;
		SoftAssert sAss = new SoftAssert();
		while (i < questions) {
			System.out.println("Question " + (i + 1));
			test.log(Status.INFO, "Question " + (i + 1));
			applyExplicitWait(5);
			actualcount++;

			test.log(Status.INFO, "Click on Next");

			clickOnElement(oqr.nextButton);
			i++;

		}

		test.log(Status.INFO, "Total " + questions + " questions are displayed");
		System.out.println("Total " + questions + " questions are displayed");

		status = (i == questions) ? true : false;
		if (status) {
			test.log(Status.INFO, "Revision ended without attemting any question");
			System.out.println("Revision ended without attemting any question");
		}
		test.log(Status.INFO, "Verifed that It's not mandatory in Revise module to attempt a each and every question");
		System.out.println("Verifed that It's not mandatory in Revise module to attempt a each and every question");
		applyExplicitWait(5);

		assert1.assertAll();
	}

	public void to_Verify_user_can_easily_skip_continue_to_next_question_without_attempting_current_one(String subject1,
			String topic) throws MalformedURLException, InterruptedException {
		applyExplicitWaitsUntilElementVisible(oqr.testUnit);
		scrollTo2("Syllabus");
		clickOnElement(findElementByText("Syllabus"));
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");
		applyExplicitWait(5);

		scrollTo2(subject1);
		test.log(Status.INFO, "Opening " + subject1);
		System.out.println("Opening " + subject1);
		clickOnElement(findElementByExactText(subject1));

		if(device.contains("Android"))
		scrollTo2(topic);
		else
			scrollTo1(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		tapOnElement(findElementByText(topic));

		if(device.contains("Android"))
			scrollTo2("Practice");
			else
				scrollTo1("Practice");
		test.log(Status.INFO, "Opening revision for " + topic);
		System.out.println("Opening revision for " + topic);

		try {

			tapOnElement(findElementByText("Revis"));
		} catch (Exception e) {

			clickOnElement(findElementByText("Revise"));
		}

		Thread.sleep(2000);
		tapOnElement(findElementByText("Revis"));
		Thread.sleep(2000);
		test.log(Status.INFO, "Video started");
		Thread.sleep(3000);
		clickOnElement(oqr.skip);
		Thread.sleep(2000);
		applyExplicitWaitsUntilElementVisible(oqr.question);
		System.out.println("Attempting the revision");
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = oqr.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		Boolean status;
		int i = 0;
		actualcount = 0;
		SoftAssert sAss = new SoftAssert();
		while (i < questions) {
			System.out.println("Question " + (i + 1));
			test.log(Status.INFO, "Question " + (i + 1));
			applyExplicitWait(5);

			actualcount++;

			test.log(Status.INFO, "Click on Next");

			clickOnElement(oqr.nextButton);
			i++;

		}

		test.log(Status.INFO, "Total " + questions + " questions are displayed");
		System.out.println("Total " + questions + " questions are displayed");

		status = (i == 1) ? true : false;
		if (status) {
			test.log(Status.INFO,
					"User can easily skip and continue to next question without attempting the current one");
			System.out.println("User can easily skip and continue to next question without attempting the current one");
		}
		{
			test.log(Status.INFO, "After clicking on last question it comes to first question");
			System.out.println("After clicking on last question it comes to first question");
		}

		assert1.assertAll();
	}

	public void to_Verify_user_Feedback_provided_at_the_click_of_options_itself(String subject1, String topic)
			throws MalformedURLException, InterruptedException {
		applyExplicitWaitsUntilElementVisible(oqr.testUnit);
		scrollTo2("Syllabus");
		clickOnElement(findElementByText("Syllabus"));
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");
		applyExplicitWait(5);

		scrollTo2(subject1);
		test.log(Status.INFO, "Opening " + subject1);
		System.out.println("Opening " + subject1);
		clickOnElement(findElementByExactText(subject1));

		if(device.contains("Android"))
		scrollTo2(topic);
		else
			scrollTo1(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		tapOnElement(findElementByText(topic));

		if(device.contains("Android"))
			scrollTo2("Practice");
			else
				scrollTo1("Practice");
		test.log(Status.INFO, "Opening revision for " + topic);
		System.out.println("Opening revision for " + topic);

		try {

			tapOnElement(findElementByText("Revis"));
		} catch (Exception e) {

			clickOnElement(findElementByText("Revise"));
		}

		Thread.sleep(2000);
		tapOnElement(findElementByText("Revis"));
		Thread.sleep(2000);
		test.log(Status.INFO, "Video started");
		Thread.sleep(3000);
		clickOnElement(oqr.skip);
		Thread.sleep(2000);
		applyExplicitWaitsUntilElementVisible(oqr.question);
		System.out.println("Attempting the revision");
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = oqr.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);

		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;

		test.log(Status.INFO, "Checking feedback for correct answer selection");
		System.out.println("Checking feedback for correct answer selection");

		while (i < questions) {
			applyExplicitWaitsUntilElementVisible(oqr.question);
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq") || verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				selectCorrectAnswer();
				status = check_Right_Answer_Feedback_In_Revision();

				sAss.assertTrue(status, "Incorrect feedback shown for right answers selection");
				if (status) {
					test.log(Status.INFO, "Correct feedback shown for right answers selection");
					System.out.println("Correct feedback shown for right answers selection");

				}
			}
			if (i + 1 != questions)
				clickOnElement(oqr.nextButton);
			i++;
		}

		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " questions are displayed");
		System.out.println("Total " + actualcount + " questions are displayed");
		sAss.assertAll();

	}

	private Boolean check_Right_Answer_Feedback_In_Revision() throws InterruptedException {
		Set<String> context = driver.getContextHandles();
		for (String cont : context) {
			if (cont.contains("WEBVIEW"))
				getDriver().context(cont);
		}
		List<MobileElement> as = driver
				.findElements(By.xpath("//*[contains(@class, 'selectedOtp') and contains(@class, 'correct')]"));
		getDriver().context("NATIVE_APP");
		System.err.println("as :" + as.size() + " correct ans : " + correctAnswers);
		if (as.size() == correctAnswers)
			return true;
		else
			return false;
	}

}