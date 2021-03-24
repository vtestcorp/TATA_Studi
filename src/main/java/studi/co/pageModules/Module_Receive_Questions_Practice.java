package studi.co.pageModules;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Begin_Practice;

public class Module_Receive_Questions_Practice extends BaseClass {
	Object_Begin_Practice obp = new Object_Begin_Practice();

	public void traverse_To_Begin_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		applyExplicitWaitsUntilElementClickable(obp.testUnit);
		scrollTo2("Syllabus");
		clickOnElement(obp.syllabus);
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");
		applyExplicitWait(5);

		scrollTo1(subject);
		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject));
		clickOnElement(findElementByText(subject));

		scrollTo1(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic));
		clickOnElement(findElementByText(topic));

		scrollTo2("Practice");
		test.log(Status.INFO, "Opening practice for " + topic);
		System.out.println("Opening practice for " + topic);
		clickOnElement(findElementByText("Practice"));
		Thread.sleep(3000);
		clickOnElement(obp.primaryAction);
	}

	public void Module_Receive_SCQ_Questions_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_All_Questions_Are_Visible();
		sAss.assertAll();
	}

	public void Module_Receive_SCQ_Answers_In_Default_State_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_All_SCQ_Answer_In_Default_State();
		sAss.assertAll();
	}

	public void Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_Multiple_Answers_Shown_For_SCQ();
		sAss.assertAll();
	}

	public void Module_Verify_SCQ_Answer_Can_Be_Slect_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = SCQ_Answers_Can_Be_Slect();
		sAss.assertAll();
	}

	public void Module_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = Only_Single_SCQ_Answer_Can_Be_Select();
		sAss.assertAll();
	}

	public void Module_Verify_Correct_Incorrect_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(String subject,
			String topic) throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				selectCorrectAnswer();

			}
			clickOnElement(obp.attempt_later);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();
	}

	public void Module_Verify_Attempting_SCQ_Quiz_Is_Mandatory_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int i = 0;
		String firstQuestion = null;
		String lastQuestion;

		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (i == 0) {
				if (device.equalsIgnoreCase("Android"))
					firstQuestion = obp.question.getText();
				else
					firstQuestion = obp.question.findElement(By.xpath("(//XCUIElementTypeStaticText)[2]")).getText();
				System.out.println("First question : " + firstQuestion);
			}
			swipeDown();
			i++;
			clickOnElement(obp.attempt_later);
		}

		if (device.equalsIgnoreCase("Android"))
			lastQuestion = obp.question.getText();
		else
			lastQuestion = obp.question.findElement(By.xpath("(//XCUIElementTypeStaticText)[2]")).getText();
		System.out.println("Last appeared question : " + lastQuestion);

		sAss.assertEquals(firstQuestion, lastQuestion);
		if (firstQuestion.equalsIgnoreCase(lastQuestion))
			test.log(Status.INFO, "Unattempted question appear again. So it's mandetory for practice");
		System.out.println("Unattempted question appear again. So it's mandetory for practice");
		
		sAss.assertAll();
	}

	public void Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_SCQ_In_Practice(
			String subject, String topic) throws Exception {
		traverse_To_Begin_Practice(subject, topic);
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting Incorrect answer for question " + (i + 1));
				System.out.println("Selecting Incorrect answer for question " + (i + 1));
				selectIncorrectAnswer();

				test.log(Status.INFO, "Clicking on Check Answer");
				System.out.println("Clicking on Check Answer");
				clickOnElement(obp.check_answer);

				test.log(Status.INFO, "Verifying feedback after wrong answer selection");
				System.out.println("Verifying feedback after wrong answer selection");
				swipeTop();

				status = obp.answerWrongMsg.isDisplayed();

				sAss.assertTrue(status, "Shown Incorrect feedback for Incorrect answer selection");
				if (status) {
					System.out.println("Shown correct feedback for Incorrect answer selection");
					test.log(Status.INFO, "Shown correct feedback for Incorrect answer selection");
				} else {
					System.out.println("Shown Incorrect feedback for Incorrect answer selection");
					test.log(Status.INFO, "Shown Incorrect feedback for Incorrect answer selection");
				}

				test.log(Status.INFO, "Click on Try Again");
				System.out.println("Click on Try Again");
				swipeDown();

				clickOnElement(obp.tryAgain);

				test.log(Status.INFO, "Verifying Attempts left warning message");
				System.out.println("Verifying Attempts left warning message");
				swipeTop();

				status = obp.attemptLeftsMsg.isDisplayed();

				sAss.assertTrue(status, "Attempts left warning message not displayed");
				if (status) {
					System.out.println("Attempts left warning message displayed");
					test.log(Status.INFO, "Attempts left warning message displayed");
				} else {
					System.out.println("Attempts left warning message not displayed");
					test.log(Status.INFO, "Attempts left warning message not displayed");
				}

				swipeDown();
				if ((i + 1 != questions))
					clickOnElement(obp.attempt_later);
				i++;
			} else {
				i++;
				clickOnElement(obp.attempt_later);
			}

		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();
	}

	public void Module_Verify_User_Should_Be_Able_To_Abandon_The_SCQ_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		String temp;
		test.log(Status.INFO, "Total " + questions + "questions appeared");
		System.out.println("Total " + questions + "questions appeared");
		List<MobileElement> answerCount;
		if (device.equalsIgnoreCase("Android"))
			answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
		else
			answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
		int ansCount = answerCount.size();
		System.out.println("answerCont = " + ansCount);

		if (device.equalsIgnoreCase("Android"))
			temp = obp.question.getText();
		else
			temp = obp.question.findElement(By.xpath("(//XCUIElementTypeStaticText)[2]")).getText();

		applyExplicitWait(1);
		test.log(Status.INFO, "Pressing back button");
		System.out.println("Pressing back button");
		if (device.equalsIgnoreCase("Android"))
			driver.navigate().back();
		else
			clickOnElement(obp.backBtn);

		applyExplicitWait(2);
		clickOnElement(obp.returnToTestPopup);
		test.log(Status.INFO, "Select NO option of cancel practice");
		System.out.println("Select NO option of cancel practice");

		applyExplicitWait(1);
		String temp2;
		if (device.equalsIgnoreCase("Android"))
			temp2 = obp.question.getText();
		else
			temp2 = obp.question.findElement(By.xpath("(//XCUIElementTypeStaticText)[2]")).getText();
		sAss.assertEquals(temp, temp2);
		test.log(Status.INFO, "Same question displayed again");
		System.out.println("Same question displayed again");

		applyExplicitWait(1);
		test.log(Status.INFO, "Pressing back button");
		System.out.println("Pressing back button");
		if (device.equalsIgnoreCase("Android"))
			driver.navigate().back();
		else
			clickOnElement(obp.backBtn);

		applyExplicitWait(2);
		clickOnElement(obp.submitTestPopup);
		test.log(Status.INFO, "Select YES option of cancel practice");
		System.out.println("Select YES option of cancel practice");

		if (findElementByText("Practice").isDisplayed()) {
			sAss.assertTrue(true);
			test.log(Status.INFO, "Practice abonded successfully");
			System.out.println("Practice abonded successfully");
		}
		sAss.assertAll();
	}

	public SoftAssert verify_All_Questions_Are_Visible() throws MalformedURLException, InterruptedException {

		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.equalsIgnoreCase("Android"))
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
			if ((i + 1) != questions)
				clickOnElement(obp.attempt_later);
			i++;

		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		return sAss;

	}

	public SoftAssert verify_All_SCQ_Answer_In_Default_State() throws InterruptedException, MalformedURLException {

		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.equalsIgnoreCase("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int c = 0;
				for (MobileElement mobileElement : answerCount) {
					if (device.equalsIgnoreCase("Android"))
						status = Boolean.parseBoolean(mobileElement.getAttribute("checked"));
					else
						status = mobileElement.getAttribute("value").equalsIgnoreCase("1");
					if (!status) {

						test.log(Status.INFO, "Answer " + c++ + "  is unchecked as default");
						System.out.println("Answer " + c + "  is unchecked as default");

					}
					sAss.assertFalse(status);
					swipeUp();
				}
			}
			clickOnElement(obp.attempt_later);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		return sAss;

	}

	public SoftAssert verify_Multiple_Answers_Shown_For_SCQ() throws InterruptedException, MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.equalsIgnoreCase("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				status = answerCount.size() > 1 ? true : false;
				sAss.assertTrue(status, "Multiple answers not available for question " + (i + 1));
				System.out.println("Multiple answers available for question " + (i + 1));
				test.log(Status.INFO, "Multiple answers available for question " + (i + 1));

			}
			if ((i + 1) != questions)
				clickOnElement(obp.attempt_later);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		return sAss;

	}

	public SoftAssert SCQ_Answers_Can_Be_Slect() throws InterruptedException, MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.equalsIgnoreCase("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int c = 1;
				action = new TouchAction(driver);
				for (MobileElement mobileElement : answerCount) {
					mobileElement.click();
					Thread.sleep(200);
					if (device.equalsIgnoreCase("Android"))
						status = Boolean.parseBoolean(mobileElement.getAttribute("focused"));
					else
						status = mobileElement.getAttribute("value").equalsIgnoreCase("1");

					sAss.assertTrue(status, "Multiple answers not available for question " + (i + 1));
					if (status) {
						System.out.println("Answer " + c + " can be select or unselect");
						test.log(Status.INFO, "Answer " + c++ + " can be select or unselect");
					} else {
						System.err.println("Answer " + c + " can't be select or unselect");
						test.log(Status.INFO, "Answer " + c++ + " can't be select or unselect");
					}
					mobileElement.click();
					swipeUp();
				}

			}
			clickOnElement(obp.attempt_later);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		return sAss;
	}

	public SoftAssert Only_Single_SCQ_Answer_Can_Be_Select() throws InterruptedException, MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.equalsIgnoreCase("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));

				for (MobileElement mobileElement : answerCount) {
					mobileElement.click();

				}
				int ansFlag = 0;
				Thread.sleep(100);

				for (MobileElement mobileElement2 : answerCount) {
					if (device.equalsIgnoreCase("Android"))
						status = Boolean.parseBoolean(mobileElement2.getAttribute("checked"));
					else
						status = mobileElement2.getAttribute("value").equalsIgnoreCase("1");
					if (status) {
						ansFlag++;
					}
				}
				System.err.println("ansFlag :" + ansFlag);
				status = ansFlag == 1 ? true : false;
				sAss.assertTrue(status, "Able to select multiple answers for SCQ question " + (i + 1));
				if (status) {
					System.err.println("Able to select single answer only for SCQ question " + (i + 1));
					test.log(Status.INFO, "Able to select single answer only for SCQ question " + (i + 1));
				}

			}

			if ((i + 1) != questions)
				clickOnElement(obp.attempt_later);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		return sAss;

	}

	public void Module_Receive_MCQ_Questions_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_All_Questions_Are_Visible_MCQ_Practice();
		sAss.assertAll();

	}

	public SoftAssert verify_All_Questions_Are_Visible_MCQ_Practice()
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.equalsIgnoreCase("Android"))
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
					swipeUp();
				}
			}
			if ((i + 1) != questions)
				clickOnElement(obp.attempt_later);
			i++;
		}
		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		return sAss;
	}

	public void Module_Receive_MCQ_Answers_In_Default_State_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_All_MCQ_Answer_In_Default_State();

		sAss.assertAll();
	}

	public SoftAssert verify_All_MCQ_Answer_In_Default_State() throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.equalsIgnoreCase("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int c = 0;
				for (MobileElement mobileElement : answerCount) {
					if (device.equalsIgnoreCase("Android"))
						status = Boolean.parseBoolean(mobileElement.getAttribute("checked"));
					else
						status = mobileElement.getAttribute("value").equalsIgnoreCase("1");
					if (!status) {

						test.log(Status.INFO, "Answer " + c++ + "  is unchecked as default");
						System.out.println("Answer " + c + "  is unchecked as default");

					}
					sAss.assertFalse(status);
					swipeUp();
				}
			}
			clickOnElement(obp.attempt_later);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		return sAss;
	}

	public void Module_Verify_Multiple_Answers_Shown_For_MCQ_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_Multiple_Answers_Shown_For_MCQ();

		sAss.assertAll();

	}

	public SoftAssert verify_Multiple_Answers_Shown_For_MCQ() throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.equalsIgnoreCase("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				status = answerCount.size() > 1 ? true : false;
				sAss.assertTrue(status, "Multiple answers not available for question " + (i + 1));
				System.out.println("Multiple answers available for question " + (i + 1));
				test.log(Status.INFO, "Multiple answers available for question " + (i + 1));

			}
			if ((i + 1) != questions)
				clickOnElement(obp.attempt_later);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		return sAss;

	}

	public void Module_Verify_MCQ_Answer_Can_Be_Slect_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = MCQ_Answers_Can_Be_Slect();

		sAss.assertAll();
		Thread.sleep(2000);
	}

	public SoftAssert MCQ_Answers_Can_Be_Slect() throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.equalsIgnoreCase("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int c = 1;
				action = new TouchAction(driver);
				for (MobileElement mobileElement : answerCount) {
					mobileElement.click();
					Thread.sleep(200);
					if (device.equalsIgnoreCase("Android"))
						status = Boolean.parseBoolean(mobileElement.getAttribute("focused"));
					else
						status = mobileElement.getAttribute("value").equalsIgnoreCase("1");

					sAss.assertTrue(status, "Multiple answers not available for question " + (i + 1));
					if (status) {
						System.out.println("Answer " + c + " can be select or unselect");
						test.log(Status.INFO, "Answer " + c++ + " can be select or unselect");
					} else {
						System.err.println("Answer " + c + " can't be select or unselect");
						test.log(Status.INFO, "Answer " + c++ + " can't be select or unselect");
					}
					mobileElement.click();
					swipeUp();
				}

			}
			clickOnElement(obp.attempt_later);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		return sAss;
	}

	public void Module_Verify_Multiple_MCQ_Answer_Can_Be_Select_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = Able_to_Select_Multiple_MSQ_Answer_Can_Be_Select();

		sAss.assertAll();
	}

	public SoftAssert Able_to_Select_Multiple_MSQ_Answer_Can_Be_Select()
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.equalsIgnoreCase("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));

				for (MobileElement mobileElement : answerCount) {
					mobileElement.click();

				}
				int ansFlag = 0;
				Thread.sleep(100);

				for (MobileElement mobileElement2 : answerCount) {
					if (device.equalsIgnoreCase("Android"))
						status = Boolean.parseBoolean(mobileElement2.getAttribute("checked"));
					else
						status = mobileElement2.getAttribute("value").equalsIgnoreCase("1");
					if (status) {
						ansFlag++;
					}
				}
				System.err.println("ansFlag :" + ansFlag);
				status = ansFlag > 1 ? true : false;
				sAss.assertTrue(status, "Not able to select multiple answers for MCQ question " + (i + 1));
				if (status) {
					System.err.println("Able to select multiple answers for MCQ question " + (i + 1));
					test.log(Status.INFO, "Able to select multiple answers for MCQ question " + (i + 1));
				}

			}

			if ((i + 1) != questions)
				clickOnElement(obp.attempt_later);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		return sAss;

	}

	public void Module_Verify_Correct_Feedback_Shown_After_Correct_Answer_Selection_For_MCQ_In_Practice(String subject,
			String topic) throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));
				selectCorrectAnswer();

				test.log(Status.INFO, "Clicked on Check Answer button");
				System.out.println("Clicked on Check Answer button");
				swipeDown();
				clickOnElement(obp.check_answer);

				test.log(Status.INFO, "Verifying feedback after answer selection");
				System.out.println("Verifying feedback after answer selection");
				status = obp.answerCorrectMsg1.isDisplayed();

				sAss.assertTrue(status);
				if (status) {
					System.err.println("Shown correct feedback for correct answer selection");
					test.log(Status.INFO, "Shown correct feedback for correct answer selection");
				} else {
					System.err.println("Shown Incorrect feedback for correct answer selection");
					test.log(Status.INFO, "Shown Incorrect feedback for correct answer selection");
				}

				if ((i + 1) != questions)
					clickOnElement(obp.conti_nue);
				i++;
			} else {
				i++;
				clickOnElement(obp.attempt_later);
			}

		}

		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Correct_Feedback_Shown_After_Partial_Answer_Selection_In_Practice(String subject,
			String topic) throws Exception {

		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting one partially correct answer for question " + (i + 1));
				System.out.println("Selecting one partially correct answer for question " + (i + 1));
				selectPartialCorrectAnswer();

				test.log(Status.INFO, "Clicked on Check Answer button");
				System.out.println("Clicked on Check Answer button");
				clickOnElement(obp.check_answer);

				swipeTop();

				test.log(Status.INFO, "Verifying feedback after answer selection");
				System.out.println("Verifying feedback after answer selection");
				status = obp.answerPartialCorrectMsg1.isDisplayed();

				sAss.assertTrue(status);
				if (status) {
					System.err.println("Shown correct feedback for partial answer selection");
					test.log(Status.INFO, "Shown correct feedback for partial answer selection");
				} else {
					System.err.println("Shown Incorrect feedback for partial answer selection");
					test.log(Status.INFO, "Shown Incorrect feedback for partial answer selection");
				}
				swipeDown();

				clickOnElement(obp.dontKnowBtn);
				Thread.sleep(1000);
				swipeDown();
				Thread.sleep(500);
				if ((i + 1) != questions) {
					if (device.equalsIgnoreCase("Android"))
						clickOnElement(obp.conti_nue);
					else
						clickOnElement(findElementByText("Continue"));
				}
				i++;
			} else {
				i++;
				clickOnElement(obp.attempt_later);
			}

		}

		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Attempting_MCQ_Quiz_Is_Mandatory_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_Quiz_Is_Mandatory();

		sAss.assertAll();

	}

	public SoftAssert verify_Quiz_Is_Mandatory() throws MalformedURLException {
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int i = 0;
		String firstQuestion = null;
		String lastQuestion;

		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (i == 0) {
				if (device.equalsIgnoreCase("Android"))
					firstQuestion = obp.question.getText();
				else
					firstQuestion = obp.question.findElement(By.xpath("(//XCUIElementTypeStaticText)[2]")).getText();
				System.out.println("First question : " + firstQuestion);
			}
			swipeDown();
			i++;
			clickOnElement(obp.attempt_later);
		}

		if (device.equalsIgnoreCase("Android"))
			lastQuestion = obp.question.getText();
		else
			lastQuestion = obp.question.findElement(By.xpath("(//XCUIElementTypeStaticText)[2]")).getText();
		System.out.println("Last appeared question : " + lastQuestion);

		sAss.assertEquals(firstQuestion, lastQuestion);
		if (firstQuestion.equalsIgnoreCase(lastQuestion))
			test.log(Status.INFO, "Unattempted question appear again. So it's mandetory for practice");
		System.out.println("Unattempted question appear again. So it's mandetory for practice");
		return sAss;
	}

	public void Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_MCQ_In_Practice(
			String subject, String topic) throws Exception {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting Incorrect answer for question " + (i + 1));
				System.out.println("Selecting Incorrect answer for question " + (i + 1));
				selectIncorrectAnswer();

				test.log(Status.INFO, "Clicking on Check Answer");
				System.out.println("Clicking on Check Answer");
				clickOnElement(obp.check_answer);

				test.log(Status.INFO, "Verifying feedback after wrong answer selection");
				System.out.println("Verifying feedback after wrong answer selection");
				swipeTop();

				status = obp.answerWrongMsg.isDisplayed();

				sAss.assertTrue(status, "Shown Incorrect feedback for Incorrect answer selection");
				if (status) {
					System.out.println("Shown correct feedback for Incorrect answer selection");
					test.log(Status.INFO, "Shown correct feedback for Incorrect answer selection");
				} else {
					System.out.println("Shown Incorrect feedback for Incorrect answer selection");
					test.log(Status.INFO, "Shown Incorrect feedback for Incorrect answer selection");
				}

				test.log(Status.INFO, "Click on Try Again");
				System.out.println("Click on Try Again");
				swipeDown();

				clickOnElement(obp.tryAgain);

				test.log(Status.INFO, "Verifying Attempts left warning message");
				System.out.println("Verifying Attempts left warning message");
				swipeTop();

				status = obp.attemptLeftsMsg.isDisplayed();

				sAss.assertTrue(status, "Attempts left warning message not displayed");
				if (status) {
					System.out.println("Attempts left warning message displayed");
					test.log(Status.INFO, "Attempts left warning message displayed");
				} else {
					System.out.println("Attempts left warning message not displayed");
					test.log(Status.INFO, "Attempts left warning message not displayed");
				}

				swipeDown();
				if ((i + 1 != questions))
					clickOnElement(obp.attempt_later);
				i++;
			} else {
				i++;
				clickOnElement(obp.attempt_later);
			}

		}

		test.log(Status.INFO, "Total " + actualcount + " MCQ questions are displayed");
		System.out.println("Total " + actualcount + " MCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_User_Can_Abond_MCQ_Quiz_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = User_Can_Abond_Quiz();

		sAss.assertAll();

	}

	public SoftAssert User_Can_Abond_Quiz() throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		String temp;
		test.log(Status.INFO, "Total " + questions + "questions appeared");
		System.out.println("Total " + questions + "questions appeared");
		List<MobileElement> answerCount;
		if (device.equalsIgnoreCase("Android"))
			answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
		else
			answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
		int ansCount = answerCount.size();
		System.out.println("answerCont = " + ansCount);

		if (device.equalsIgnoreCase("Android"))
			temp = obp.question.getText();
		else
			temp = obp.question.findElement(By.xpath("(//XCUIElementTypeStaticText)[2]")).getText();

		applyExplicitWait(1);
		test.log(Status.INFO, "Pressing back button");
		System.out.println("Pressing back button");
		if (device.equalsIgnoreCase("Android"))
			driver.navigate().back();
		else
			clickOnElement(obp.backBtn);

		applyExplicitWait(2);
		clickOnElement(obp.returnToTestPopup);
		test.log(Status.INFO, "Select NO option of cancel practice");
		System.out.println("Select NO option of cancel practice");

		applyExplicitWait(1);
		String temp2;
		if (device.equalsIgnoreCase("Android"))
			temp2 = obp.question.getText();
		else
			temp2 = obp.question.findElement(By.xpath("(//XCUIElementTypeStaticText)[2]")).getText();
		sAss.assertEquals(temp, temp2);
		test.log(Status.INFO, "Same question displayed again");
		System.out.println("Same question displayed again");

		applyExplicitWait(1);
		test.log(Status.INFO, "Pressing back button");
		System.out.println("Pressing back button");
		if (device.equalsIgnoreCase("Android"))
			driver.navigate().back();
		else
			clickOnElement(obp.backBtn);

		applyExplicitWait(2);
		clickOnElement(obp.submitTestPopup);
		test.log(Status.INFO, "Select YES option of cancel practice");
		System.out.println("Select YES option of cancel practice");

		if (findElementByText("Practice").isDisplayed()) {
			sAss.assertTrue(true);
			test.log(Status.INFO, "Practice abonded successfully");
			System.out.println("Practice abonded successfully");
		}

		return sAss;
	}

	public void Module_Verify_Feedback_Shown_For_Correct_Answer_Selection_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		applyExplicitWaitsUntilElementVisible(obp.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));
				selectCorrectAnswer();

				test.log(Status.INFO, "Clicked on Check Answer button");
				System.out.println("Clicked on Check Answer button");
				swipeDown();
				clickOnElement(obp.check_answer);

				test.log(Status.INFO, "Verifying feedback after answer selection");
				System.out.println("Verifying feedback after answer selection");
				status = obp.answerCorrectMsg1.isDisplayed();

				sAss.assertTrue(status);
				if (status) {
					System.err.println("Shown correct feedback for correct answer selection");
					test.log(Status.INFO, "Shown correct feedback for correct answer selection");
				} else {
					System.err.println("Shown Incorrect feedback for correct answer selection");
					test.log(Status.INFO, "Shown Incorrect feedback for correct answer selection");
				}

				if ((i + 1) != questions)
					clickOnElement(obp.conti_nue);
				i++;
			} else {
				i++;
				clickOnElement(obp.attempt_later);
			}

		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Feedback_Shown_For_Incorrect_Answer_Selection_In_Practice(String subject, String topic)
			throws Exception {
		traverse_To_Begin_Practice(subject, topic);
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting Wrong answer for question " + (i + 1));
				System.out.println("Selecting Wrong answer for question " + (i + 1));
				selectIncorrectAnswer();

				test.log(Status.INFO, "Clicked on Check Answer button");
				System.out.println("Clicked on Check Answer button");
				swipeDown();
				clickOnElement(obp.check_answer);

				test.log(Status.INFO, "Verifying feedback after answer selection");
				System.out.println("Verifying feedback after answer selection");
				swipeTop();
				status = obp.answerWrongMsg.isDisplayed();

				sAss.assertTrue(status);
				if (status) {
					System.err.println("Shown correct feedback for wrong answer selection");
					test.log(Status.INFO, "Shown correct feedback for wrong answer selection");
				} else {
					System.err.println("Shown Incorrect feedback for wrong answer selection");
					test.log(Status.INFO, "Shown Incorrect feedback for wrong answer selection");
				}
			}
			swipeDown();
			clickOnElement(obp.dontKnowBtn);
			swipeDown();
			Thread.sleep(500);
			if ((i + 1) != questions) {
				if(device.equalsIgnoreCase("Android"))
				clickOnElement(obp.conti_nue);
				else
					clickOnElement(findElementByText("Continue"));}
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();
	}
}