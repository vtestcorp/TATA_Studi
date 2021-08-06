package studi.co.pageModules;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Receive_Questions_Revision;

public class Module_Receive_Questions_Revision extends BaseClass {
	Object_Receive_Questions_Revision RMQR = new Object_Receive_Questions_Revision();

	public void traverse_To_Begin_Revision(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		applyExplicitWaitsUntilElementVisible(RMQR.testUnit);

		if (device.contains("Android"))
			swipeUp();
		else
			scrollTo2("Syllabus");
		clickOnElement(findElementByText("Syllabus"));
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");
		applyExplicitWait(5);

		scrollTo2(subject);
		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		clickOnElement(findElementByExactText(subject));

		scrollTo2(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		clickOnElement(findElementByText(topic));

		scrollTo2("Practice");
		test.log(Status.INFO, "Opening revision for " + topic);
		System.out.println("Opening revision for " + topic);

		try {
			// applyExplicitWaitsUntilElementClickable(findElementByText("Revis"));
			clickOnElement(findElementByText("Revis"));
		} catch (Exception e) {
			// applyExplicitWaitsUntilElementClickable(findElementByText("Revise"));
			clickOnElement(findElementByText("Revise"));
		}

		Thread.sleep(3000);

		try {
			applyExplicitWaitsUntilElementVisible(RMQR.why_tested_msg);
			clickOnElement(findElementByText("Revis"));
		} catch (Exception e) {
			if (device.contains("Android"))
				clickOnElement(findElementByText("Revis"));
			else
				clickOnElement(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Revise again\"]")));
		}
	}

	private void pauseVideo() throws MalformedURLException, InterruptedException {
		if (device.contains("Android")) {
			applyExplicitWaitsUntilElementVisible(driver.findElement(By.id("com.tce.studi:id/layoutVideo")));
			applyExplicitWaitsUntilElementVisible(RMQR.addNotesBtn);
			driver.findElement(By.id("com.tce.studi:id/layoutVideo")).click();
			pauseBtn.click();
		}

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

	private Boolean check_Wrong_Answer_Feedback_In_Revision() throws InterruptedException {
		Set<String> context = driver.getContextHandles();
		for (String cont : context) {
			if (cont.contains("WEBVIEW"))
				getDriver().context(cont);
		}
		List<MobileElement> as = driver
				.findElements(By.xpath("//*[contains(@class, 'selectedOtp') and contains(@class, 'incorrect')]"));
		getDriver().context("NATIVE_APP");
		System.err.println("as :" + as.size() + " correct ans : " + wrongAnswers);
		if (as.size() == wrongAnswers || as.size() == 1)
			return true;
		else
			return false;
	}

	public void Module_Receive_SCQ_Questions_Revision(String subject, String topic)
			throws WebDriverException, IOException, InterruptedException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		System.out.println("Video Started");
		Thread.sleep(2000);
		applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);

		int questions;
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		int actualcount = 0;
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("scq")) {
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
					swipeUp();
					if (mobileElement.isDisplayed()) {
						sAss.assertTrue(true);
						test.log(Status.INFO, "Answer " + t + " Displayed");
						System.out.println("Answer " + t + " Displayed");

					} else
						sAss.assertTrue(false);
					t++;
				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		applyExplicitWait(2);
		sAss.assertAll();
	}

	public void Module_Receive_SCQ_Questions_Default_State_In_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");

		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		while (i < questions) {

			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("scq")) {
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
					if (device.contains("Android")) {
						if (getElementAttribute(mobileElement, "focused").trim().contains("false")) {
							sAss.assertTrue(true);
							test.log(Status.INFO, "Answer " + t + " is in default state");
							System.out.println("Answer " + t + " is in default state");

						} else
							sAss.assertTrue(false);
					} else {
						if (!mobileElement.isSelected()) {
							sAss.assertTrue(true);
							test.log(Status.INFO, "Answer " + t + " is in default state");
							System.out.println("Answer " + t + " is in default state");

						} else
							sAss.assertTrue(false);
					}
					t++;
				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Receive_SCQ_Questions_Answer_Can_Be_Select_In_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		System.out.println("Video started");
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWait(15);

		int questions;
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("scq")) {
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
					swipeUp();
					mobileElement.click();
					Thread.sleep(700);
					if (device.contains("Android"))
						status = Boolean.parseBoolean(mobileElement.getAttribute("checked"));
					else
						status = mobileElement.getAttribute("value").equals("1");
					System.err.println(status);
					if (status) {
						sAss.assertTrue(true);
						test.log(Status.INFO, "Answer " + t + " can be select");
						System.out.println("Answer " + t + " can be select");
						swipeUp();

					} else
						sAss.assertTrue(false);
					t++;
				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;

		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}

	public void Verify_Only_Single_Answer_Can_Be_Select_For_SCQ_Question_In_Revision(String subject, String topic)
			throws Exception {

		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWait(15);

		int questions;
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.contains("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				for (MobileElement mobileElement : answerCount) {
					Thread.sleep(200);
					mobileElement.click();
					swipeUp();
				}
				int c = 0;
				swipeTop();
				for (MobileElement mobileElement : answerCount) {
					Thread.sleep(200);
					if (device.contains("Android"))
						status = Boolean.parseBoolean(mobileElement.getAttribute("checked"));
					else
						status = mobileElement.getAttribute("value").equals("1");
					System.err.println(status);
					if (status)
						c++;
					swipeUp();
				}
				System.err.println("C = " + c);
				if (c == 1) {
					sAss.assertTrue(true, "Only single answer can be select");
					test.log(Status.INFO, "Only single answer can be select");
					System.out.println("Only single answer can be select");
				} else {
					sAss.assertTrue(false, "Multiple answers can be select for SCQ");
					test.log(Status.INFO, "Multiple answers can be select for SCQ");
					System.out.println("Multiple answers can be select for SCQ");

				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;

		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Attempting_Quiz_Is_Not_Mandatory_In_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		traverse_To_Begin_Revision(subject, topic);
		test.log(Status.INFO, "Video started");
		Thread.sleep(1000);
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
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
			// if (verifySCQorMCQ().contains("scq") ||
			// verifySCQorMCQ().contains("mcq")) {
			actualcount++;
			// }
			test.log(Status.INFO, "Click on Next");

			clickOnElement(RMQR.nextButton);
			i++;

		}

		test.log(Status.INFO, "Total " + questions + " questions are displayed");
		System.out.println("Total " + questions + " questions are displayed");

		status = (i == questions) ? true : false;
		if (status) {
			test.log(Status.INFO, "Revision ended without attemting any question");
			System.out.println("Revision ended without attemting any question");
		}

		applyExplicitWait(5);
		sAss.assertAll();
	}

	public void Module_Verify_User_Can_Abandon_Quiz_In_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		traverse_To_Begin_Revision(subject, topic);
		test.log(Status.INFO, "Video started");
		Thread.sleep(2000);
		
		applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		int questions;

		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);

		SoftAssert sAss = new SoftAssert();
		Boolean status;
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		if (device.contains("Android"))
			driver.navigate().back();
		else
			clickOnElement(RMQR.backBtn);
		System.out.println("Clicked on Back Button");
		test.log(Status.INFO, "Clicked on Back Button");

		Thread.sleep(200);
		status = RMQR.exitPopup.isEnabled();
		if (status) {
			System.out.println("Warning message displayed");
			test.log(Status.INFO, "Warning message displayed");
		}

		clickOnElement(RMQR.submitTestPopup);
		System.out.println("Ending Test");
		test.log(Status.INFO, "Ending Test");
		
		Thread.sleep(2000);
		
		
		applyExplicitWait(5);
		if (device.contains("Android"))
			status = findElementByText("you").isDisplayed();
		else
			status = findElementByText("YOU").isDisplayed();
		if (status) {
			System.out.println("Revision aboanded succesfully");
			test.log(Status.INFO, "Revision aboanded succesfully");
		}
		sAss.assertTrue(status, "Revision not able to aboand");
		sAss.assertAll();

	}

	public void Module_Receive_MCQ_Questions_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		System.out.println("Video Started");
		Thread.sleep(1000);
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		int actualcount = 0;
		int i = 0;
		SoftAssert sAss = new SoftAssert();

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
					if (mobileElement.isDisplayed()) {
						sAss.assertTrue(true);
						test.log(Status.INFO, "Answer " + t + " Displayed");
						System.out.println("Answer " + t + " Displayed");

					} else
						sAss.assertTrue(false);
					t++;
				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}
		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		applyExplicitWait(2);
		sAss.assertAll();

	}

	public void Module_Verify_Various_SCQ_Answers_Available_In_Revision(String subject, String topic)
			throws WebDriverException, IOException, InterruptedException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		// pauseVideo();
		// forwardVideoTimerToEnd();
		Thread.sleep(1000);
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWait(15);
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;
		while (i < questions) {

			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.contains("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				status = answerCount.size() > 1 ? true : false;
				sAss.assertTrue(status);
				if (status) {
					test.log(Status.INFO, answerCount.size() + " answers available of question " + (i + 1));
					System.out.println(answerCount.size() + " answers available of question " + (i + 1));

				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}

	public void Verify_Student_Should_Get_Instant_Feedback_For_SCQ_Question(String subject, String topic)
			throws WebDriverException, IOException, InterruptedException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		System.out.println("Video started");

		Thread.sleep(2000);
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;

		test.log(Status.INFO, "Checking feedback for correct answer selection");
		System.out.println("Checking feedback for correct answer selection");

		while (i < questions) {
			applyExplicitWaitsUntilElementVisible(RMQR.question);
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting correct answer");
				System.out.println("Selecting correct answer");
				selectCorrectAnswer();
				status = check_Right_Answer_Feedback_In_Revision();

				sAss.assertTrue(status, "Incorrect feedback shown for right answers selection");
				if (status) {
					test.log(Status.INFO, "Correct feedback shown for right answers selection");
					System.out.println("Correct feedback shown for right answers selection");

				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}

		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}

	public void Verify_State_Of_Answer_Should_Be_Maintained_For_SCQ_Question(String subject, String topic)
			throws IOException, InterruptedException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");

		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		Thread.sleep(2000);
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;

		test.log(Status.INFO, "Selecting correct answers for all SCQ's");
		System.out.println("Selecting correct answers for all SCQ's");

		while (i < questions) {

			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				selectCorrectAnswer();
			}
			correctAnswer[i] = correctAnswers;
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}

		System.err.print("Correct ans : ");
		for (int j = 0; j < questions; j++)
			System.out.print(" " + correctAnswer[j]);

		i = 0;
		test.log(Status.INFO, "Checking state of selected answer");
		System.out.println("Checking state of selected answer");

		while (i < questions) {
			applyExplicitWaitsUntilElementVisible(RMQR.question);

			if (verifySCQorMCQ().contains("scq")) {
				applyExplicitWait(5);
				swipeUp();
				int checkCnt = 0;
				List<MobileElement> answerCount;
				if (device.contains("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				for (MobileElement mobileElement : answerCount) {
					if (device.contains("Android"))
						status = Boolean.parseBoolean(mobileElement.getAttribute("checked"));
					else
						status = mobileElement.getAttribute("value").equals("1");
					swipeUp();
					if (status)
						checkCnt++;
				}

				status = checkCnt == correctAnswer[questions - i - 1] ? true : false;
				sAss.assertTrue(status, "Attempted state not maintained in Revision");
				if (status) {
					test.log(Status.INFO, "Attempted state maintained in Revision for question " + (questions - i));
					System.out.println("Attempted state maintained in Revision for question " + (questions - i));

				}

			}
			if (i + 1 != questions)
				clickOnElement(RMQR.prvsButton);
			i++;
		}

		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Receive_MCQ_Answers_In_Default_State_In_Revision(String subject, String topic)
			throws WebDriverException, IOException, InterruptedException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWait(15);
		int questions;
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
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
					if (device.contains("Android")) {
						if (getElementAttribute(mobileElement, "focused").trim().contains("false")) {
							sAss.assertTrue(true);
							test.log(Status.INFO, "Answer " + t + " is in default state");
							System.out.println("Answer " + t + " is in default state");

						} else
							sAss.assertTrue(false);
					} else {
						if (!mobileElement.isSelected()) {
							sAss.assertTrue(true);
							test.log(Status.INFO, "Answer " + t + " is in default state");
							System.out.println("Answer " + t + " is in default state");

						} else
							sAss.assertTrue(false);
					}
					t++;
				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Multiple_Answers_Shown_For_MCQ_In_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		Thread.sleep(1000);
		applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWait(15);
		int questions;
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;
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
				status = answerCount.size() > 1 ? true : false;
				sAss.assertTrue(status);
				if (status) {
					test.log(Status.INFO, answerCount.size() + " answers available of question " + (i + 1));
					System.out.println(answerCount.size() + " answers available of question " + (i + 1));

				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_MCQ_Answers_Can_Be_Select_In_Revision(String subject, String topic)
			throws WebDriverException, IOException, InterruptedException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);

		int questions;
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;
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
						sAss.assertTrue(true);
						test.log(Status.INFO, "Answer " + t + " can be select");
						System.out.println("Answer " + t + " can be select");

					} else
						sAss.assertTrue(false);
					swipeUp();
					t++;
				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;

		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Multiple_Answers_Can_Be_Select_For_MCQ_Question_In_Revision(String subject, String topic)
			throws Exception {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWait(15);

		int questions;
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;
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
				for (MobileElement mobileElement : answerCount) {
					mobileElement.click();
					swipeUp();
				}
				swipeTop();
				int c = 0;
				for (MobileElement mobileElement : answerCount) {
					Thread.sleep(400);
					if (device.contains("Android"))
						status = Boolean.parseBoolean(mobileElement.getAttribute("checked"));
					else
						status = mobileElement.getAttribute("value").equals("1");
					System.err.println(status);
					swipeUp();
					if (status)
						c++;
				}
				if (c == 1) {
					sAss.assertTrue(false, "Only single answer can be select");
					test.log(Status.INFO, "Only single answer can be select");
					System.out.println("Only single answer can be select");
				} else {
					sAss.assertTrue(true);
					test.log(Status.INFO, "Multiple answers can be select for MCQ");
					System.out.println("Multiple answers can be select for MCQ");

				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;

		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Instant_Feedback_Shown_After_MCQ_Answer_Selection_In_Revision(String subject,
			String topic) throws WebDriverException, IOException, InterruptedException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");

		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWait(15);

		int questions;
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;

		test.log(Status.INFO, "Checking feedback for correct answer selection");
		System.out.println("Checking feedback for correct answer selection");

		while (i < questions) {
			applyExplicitWaitsUntilElementVisible(RMQR.question);
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
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
				clickOnElement(RMQR.nextButton);
			i++;
		}

		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Instant_Feedback_Shown_After_MCQ_Wrong_Answer_Selection_In_Revision(String subject,
			String topic) throws WebDriverException, IOException, InterruptedException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		int questions;

		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;

		test.log(Status.INFO, "Checking feedback for wrong answer selection");
		System.out.println("Checking feedback for wrong answer selection");

		while (i < questions) {
			applyExplicitWaitsUntilElementVisible(RMQR.question);
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				selectIncorrectAnswer();
				status = check_Wrong_Answer_Feedback_In_Revision();

				sAss.assertTrue(status, "Incorrect feedback shown for wrong answers selection");
				if (status) {
					test.log(Status.INFO, "Correct feedback shown for wrong answers selection");
					System.out.println("Correct feedback shown for wrong answers selection");

				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}

		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_State_Of_Answer_Should_Be_Maintained_For_MCQ_Answer_In_Revision(String subject,
			String topic) throws WebDriverException, IOException, InterruptedException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;

		test.log(Status.INFO, "Selecting correct answers for all MCQ's");
		System.out.println("Selecting correct answers for all MCQ's");

		while (i < questions) {

			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				selectCorrectAnswer();
			}
			correctAnswer[i] = correctAnswers;
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}

		System.err.print("Correct ans : ");
		for (int j = 0; j < questions; j++)
			System.out.print(" " + correctAnswer[j]);

		i = 0;
		test.log(Status.INFO, "Checking state of selected answers");
		System.out.println("Checking state of selected answers");

		while (i < questions) {
			applyExplicitWaitsUntilElementVisible(RMQR.question);

			if (verifySCQorMCQ().contains("mcq")) {
				applyExplicitWait(5);
				swipeUp();
				int checkCnt = 0;
				List<MobileElement> answerCount;
				if (device.contains("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				for (MobileElement mobileElement : answerCount) {
					if (device.contains("Android"))
						status = Boolean.parseBoolean(mobileElement.getAttribute("checked"));
					else
						status = mobileElement.getAttribute("value").equals("1");
					swipeUp();
					if (status)
						checkCnt++;
				}

				status = checkCnt == correctAnswer[questions - i - 1] ? true : false;
				sAss.assertTrue(status, "Attempted state not maintained in Revision");
				if (status) {
					test.log(Status.INFO, "Attempted state maintained in Revision for question " + (questions - i));
					System.out.println("Attempted state maintained in Revision for question " + (questions - i));

				}

			}
			if (i + 1 != questions)
				clickOnElement(RMQR.prvsButton);
			i++;
		}

		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Instant_Feedback_Shown_After_SCQ_Wrong_Answer_Selection_In_Revision(String subject,
			String topic) throws InterruptedException, WebDriverException, IOException {
		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		Thread.sleep(1000);
		Thread.sleep(1000);applyExplicitWaitsUntilElementClickable(RMQR.skip);
		clickOnElement(RMQR.skip);
		applyExplicitWaitsUntilElementVisible(RMQR.question);
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		Boolean status;

		test.log(Status.INFO, "Checking feedback for wrong answer selection");
		System.out.println("Checking feedback for wrong answer selection");

		while (i < questions) {
			applyExplicitWaitsUntilElementVisible(RMQR.question);
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				selectIncorrectAnswer();
				status = check_Wrong_Answer_Feedback_In_Revision();

				sAss.assertTrue(status, "Incorrect feedback shown for wrong answers selection");
				if (status) {
					test.log(Status.INFO, "Correct feedback shown for wrong answers selection");
					System.out.println("Correct feedback shown for wrong answers selection");

				}
			}
			if (i + 1 != questions)
				clickOnElement(RMQR.nextButton);
			i++;
		}

		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}
}
