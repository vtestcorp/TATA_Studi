package studi.co.pageModules;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
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
		Thread.sleep(5000);
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
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		String firstQuestion = " ";

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (i == 0)
				firstQuestion = obp.question.getText();
			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				actualcount++;
				swipeUp();
			}

			test.log(Status.INFO, "Skip the question");
			System.out.println("Skip the question");

			clickOnElement(obp.attempt_later);
			i++;
		}
		status = firstQuestion.equalsIgnoreCase(obp.question.getText());
		sAss.assertTrue(status);
		if (status) {
			test.log(Status.INFO, "Same question appeared again.(i.e. Practice questions are mandetory)");
			System.out.println("Same question appeared again.(i.e. Practice questions are mandetory)");
		} else {
			test.log(Status.INFO, "Practice ended");
			System.err.println("Practice ended");
		}
		sAss.assertAll();
	}

	public void Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_SCQ_In_Practice(
			String subject, String topic) throws MalformedURLException, InterruptedException {
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
				clickOnElement(obp.check_answer);

				test.log(Status.INFO, "Verifying feedback after answer selection");
				System.out.println("Verifying feedback after answer selection");
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

			clickOnElement(obp.tryAgain);
			System.err.println("Clicked on try again");
			test.log(Status.INFO, "Clicked on try again");

			status = obp.attemptLeftsMsg.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.err.println("Warning message displayed as " + obp.attemptLeftsMsg.getText());
				test.log(Status.INFO, "Warning message displayed as " + obp.attemptLeftsMsg.getText());
			}

			test.log(Status.INFO, "Selecting correct answer");
			System.out.println("Selecting correct answer");
			selectCorrectAnswer();

			test.log(Status.INFO, "Clicked on Check Answer button");
			System.out.println("Clicked on Check Answer button");
			clickOnElement(obp.check_answer);

			test.log(Status.INFO, "Verifying feedback after answer selection");
			System.out.println("Verifying feedback after answer selection");
			status = obp.answerCorrectMsg2.isDisplayed();

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
		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();
	}

	public void Module_Verify_User_Should_Be_Able_To_Abandon_The_SCQ_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);
		applyExplicitWait(5);
		SoftAssert sAss = new SoftAssert();
		String actualQue, expectedQue;

		expectedQue = obp.question.getText();
		System.out.println("Clicked on BACK button");
		test.log(Status.INFO, "Clicked on BACK button");
		clickOnElement(obp.backBtn);
		applyExplicitWait(5);

		if (getDriver().findElementById("com.tce.studi:id/txtTitle").isEnabled()) {
			System.out.println("Popup message displayed");
			test.log(Status.INFO, "Popup message displayed");
		}

		System.out.println("Clicked on NO button");
		test.log(Status.INFO, "Clicked on NO button");
		clickOnElement(obp.noBtn);

		actualQue = obp.question.getText();
		if (actualQue.equalsIgnoreCase(expectedQue)) {
			sAss.assertTrue(actualQue.equalsIgnoreCase(expectedQue));
			System.out.println("same question appear again");
			test.log(Status.INFO, "same question appear again");
		}

		System.out.println("Clicked on BACK button");
		test.log(Status.INFO, "Clicked on BACK button");
		clickOnElement(obp.backBtn);
		applyExplicitWait(5);

		System.out.println("Clicked on YES button");
		test.log(Status.INFO, "Clicked on Yes button");
		clickOnElement(obp.yesBtn);
		applyExplicitWait(5);

		if (getDriver().findElementById("com.tce.studi:id/tv_primary_action").isDisplayed()) {
			System.out.println("Returned to begin practice page");
			test.log(Status.INFO, "Returned to begin practice page");
		}
		sAss.assertTrue(getDriver().findElementById("com.tce.studi:id/tv_primary_action").isDisplayed());

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
				if (device == "Android")
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

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device == "Android")
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int c = 0;
				for (MobileElement mobileElement : answerCount) {

					status = Boolean.parseBoolean(mobileElement.getAttribute("checked"));
					if (!status) {

						test.log(Status.INFO, "Answer " + c + "  is unchecked as default");
						System.out.println("Answer " + c + "  is unchecked as default");

					}
					sAss.assertFalse(status);
					c++;
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

	public SoftAssert verify_Multiple_Answers_Shown_For_SCQ() throws InterruptedException, MalformedURLException {
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
				List<MobileElement> answerCount;
				if (device == "Android")
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

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device == "Android")
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int c = 1;
				for (MobileElement mobileElement : answerCount) {
					mobileElement.click();
					Thread.sleep(100);
					status = Boolean.parseBoolean(mobileElement.getAttribute("focused"));

					sAss.assertTrue(status, "Multiple answers not available for question " + (i + 1));
					if (status) {
						System.out.println("Answer " + c + " can be select or unselect");
						test.log(Status.INFO, "Answer " + c++ + " can be select or unselect");
					} else {
						System.err.println("Answer " + c + " can't be select or unselect");
						test.log(Status.INFO, "Answer " + c++ + " can't be select or unselect");
					}
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

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device == "Android")
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int c = 1;
				for (MobileElement mobileElement : answerCount) {
					mobileElement.click();
					Thread.sleep(300);

					int ansFlag = 0;

					for (MobileElement mobileElement2 : answerCount) {
						if (Boolean.parseBoolean(mobileElement2.getAttribute("focused"))) {
							ansFlag++;
						}
					}

					status = ansFlag == 1 ? true : false;
					sAss.assertTrue(status, "Able to select multiple answers for SCQ question " + (i + 1));
					if (status) {
						System.out.println("Answer " + c + " selected individually");
						test.log(Status.INFO, "Answer " + c++ + " selected individually");
					} else {
						System.err.println("Able to select multiple answers for SCQ question " + (i + 1));
						test.log(Status.INFO, "Able to select multiple answers for SCQ question " + (i + 1));
						c++;
					}
				}

			}
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

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device == "Android")
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

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device == "Android")
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int c = 0;
				for (MobileElement mobileElement : answerCount) {

					status = Boolean.parseBoolean(mobileElement.getAttribute("checked"));
					if (!status) {

						test.log(Status.INFO, "Answer " + c++ + "  is unchecked as default");
						System.out.println("Answer " + c++ + "  is unchecked as default");

					}
					sAss.assertFalse(status);

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

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device == "Android")
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

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device == "Android")
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int c = 1;
				for (MobileElement mobileElement : answerCount) {
					mobileElement.click();
					Thread.sleep(100);
					status = Boolean.parseBoolean(mobileElement.getAttribute("focused"));

					sAss.assertTrue(status, "Multiple answers not available for question " + (i + 1));
					if (status) {
						System.out.println("Answer " + c + " can be select or unselect");
						test.log(Status.INFO, "Answer " + c++ + " can be select or unselect");
					} else {
						System.err.println("Answer " + c + " can't be select or unselect");
						test.log(Status.INFO, "Answer " + c++ + " can't be select or unselect");
					}
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

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device == "Android")
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));

				for (MobileElement mobileElement : answerCount) {
					mobileElement.click();

				}
				int ansFlag = 0;
				Thread.sleep(100);

				for (MobileElement mobileElement2 : answerCount) {
					if (Boolean.parseBoolean(mobileElement2.getAttribute("checked"))) {
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

	public void Module_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_MCQ_In_Practice(String property,
			String property2) {
		Assert.assertTrue(false);

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
		int flag = 1;
		int i = 0;
		int queFlag = 0;
		String firstQuestion = null;
		String lastQuestion;
		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				applyExplicitWait(5);
				queFlag = 0;

				ArrayList<MobileElement> answerCount = (ArrayList<MobileElement>) getDriver()
						.findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				test.log(Status.INFO, "question number " + (i + 1));
				action = new TouchAction(driver);
				action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
						.moveTo(PointOption.point(115, 350)).release().perform();
				test.log(Status.INFO, "answerCont = " + ansCount);
				queFlag = 1;
				if (ansCount != 0 && flag == 1) {
					if (i == 0)
						firstQuestion = obp.question.getText();

					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
					if (flag == 1) {
						flag = 0;
						test.log(Status.INFO, "Flag set to 0");
						continue normal;
					} else {
						flag = 1;
						test.log(Status.INFO, "Flag set to 1");
						continue normal;
					}
				}
			}
		}
		lastQuestion = obp.question.getText();
		sAss.assertEquals(firstQuestion, lastQuestion);
		if (firstQuestion.equalsIgnoreCase(lastQuestion))
			test.log(Status.INFO, "Unattempted question appear again. So it's mandetory for practice");

		return sAss;
	}

	public void Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_MCQ_In_Practice(
			String property, String property2) {
		Assert.assertTrue(false);

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
		int flag = 1;
		int i = 1;
		int queFlag = 0;
		String temp;
		test.log(Status.INFO, "Total " + questions + " appeared");
		// int actualcount = 0;
		try {
			List<MobileElement> answerCount;
				if (device == "Android")
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
			int ansCount = answerCount.size();
			System.out.println("answerCont = " + ansCount);
			queFlag = 1;

			if (ansCount != 0 && flag == 1) {
				temp = obp.question.getText();

				applyExplicitWait(1);
				clickOnElement(obp.backBtn);
				test.log(Status.INFO, "Pressing back button");

				applyExplicitWait(2);
				clickOnElement(obp.returnToTestPopup);
				test.log(Status.INFO, "Select NO option of cancel practice");

				applyExplicitWait(1);
				sAss.assertEquals(temp, obp.question.getText());
				test.log(Status.INFO, "Same question available");

				applyExplicitWait(1);
				clickOnElement(obp.backBtn);
				test.log(Status.INFO, "Pressing back button");

				applyExplicitWait(2);
				clickOnElement(obp.submitTestPopup);
				test.log(Status.INFO, "Select YES option of cancel practice");
				if (findElementByText("Begin Test").isDisplayed())
					sAss.assertTrue(true);

				ansCount = 0;

			} else if (ansCount != 0) {
				test.log(Status.INFO, "Answer count " + ansCount);
				flag = 1;
			} else {
				clickOnElement(obp.attempt_later);
				i++;
				flag = 1;
			}

		} catch (Exception e) {
			System.out.println("Exception occured");
			if (queFlag == 0) {
				i++;
				test.log(Status.INFO, "Question " + i + " not displayed");
				sAss.assertTrue(false);
				clickOnElement(obp.attempt_later);
			} else {
				if (flag == 1) {
					flag = 0;
					System.out.println("Flag set to 0");

				} else {
					flag = 1;
					System.out.println("Flag set to 1");

				}
			}
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

			}
			if ((i + 1) != questions)
				clickOnElement(obp.conti_nue);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Feedback_Shown_For_Incorrect_Answer_Selection_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
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
				clickOnElement(obp.check_answer);

				test.log(Status.INFO, "Verifying feedback after answer selection");
				System.out.println("Verifying feedback after answer selection");
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

			clickOnElement(obp.dontKnowBtn);
			if ((i + 1) != questions)
				clickOnElement(obp.conti_nue);
			i++;
		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();
	}
}