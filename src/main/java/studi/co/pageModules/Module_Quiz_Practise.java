package studi.co.pageModules;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Quiz_Practise;

public class Module_Quiz_Practise extends BaseClass {

	Object_Quiz_Practise quiz = new Object_Quiz_Practise();
	SoftAssert assert1 = new SoftAssert();
	Boolean status;

	public void traverse_To_Begin_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		applyExplicitWaitsUntilElementVisible(quiz.testUnit);
		scrollTo2("Syllabus");
		clickOnElement(findElementByText("Syllabus"));
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");
		applyExplicitWait(5);

		scrollTo2(subject);
		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		clickOnElement(findElementByExactText(subject));

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
		test.log(Status.INFO, "Opening practice for " + topic);
		System.out.println("Opening practice for " + topic);
		tapOnElement(findElementByText("Practice"));
		Thread.sleep(3000);
		tapOnElement(findElementByText("Practice"));
	}

	public void verify_All_Questions_Are_Mandatory_In_Practise_Module(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);
		Thread.sleep(2000);
		applyExplicitWaitsUntilElementVisible(quiz.question);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int i = 0;
		String firstQuestion = null;
		String lastQuestion;

		
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (i == 0) {
				if (device.contains("Android"))
					firstQuestion = quiz.question.getText();
				else
					firstQuestion = quiz.question.findElement(By.xpath("(//XCUIElementTypeStaticText)[2]")).getText();
				System.out.println("First question : " + firstQuestion);
			}
			// swipeDown();
			scrollTo2("attempt");
			i++;
			clickOnElement(quiz.attempt_later);
		}

		if (device.contains("Android"))
			lastQuestion = quiz.question.getText();
		else
			lastQuestion = quiz.question.findElement(By.xpath("(//XCUIElementTypeStaticText)[2]")).getText();
		System.out.println("Last appeared question : " + lastQuestion);

		sAss.assertEquals(firstQuestion, lastQuestion);
		if (firstQuestion.contains(lastQuestion))
			test.log(Status.INFO, "Unattempted question appear again. So it's mandetory for practice");
		System.out.println("Unattempted question appear again. So it's mandetory for practice");

		sAss.assertAll();

	}

	public void Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt(String subject, String topic)
			throws Exception {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = new SoftAssert();
		Thread.sleep(3000);
		applyExplicitWaitsUntilElementVisible(quiz.question);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting Incorrect answer for question " + (i + 1));
				System.out.println("Selecting Incorrect answer for question " + (i + 1));
				selectIncorrectAnswer();

				test.log(Status.INFO, "Clicking on Check Answer");
				System.out.println("Clicking on Check Answer");
				if(!device.contains("Android"))
					scrollTo2("Check");
				tapOnElement(quiz.check_answer);
				
				swipeDown();
				
				test.log(Status.INFO, "Verifying feedback after wrong answer selection");
				System.out.println("Verifying feedback after wrong answer selection");
				swipeTop();

				status = quiz.answerWrongMsg.isDisplayed();

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

				
				tapOnElement(quiz.tryAgain);

				test.log(Status.INFO, "Verifying Attempts left warning message");
				System.out.println("Verifying Attempts left warning message");
				swipeTop();

				status = quiz.attemptLeftsMsg.isDisplayed();

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
					{scrollTo2("attempt");
					clickOnElement(quiz.attempt_later);}
				i++;
			} else {
				i++;
				scrollTo2("attempt");
				clickOnElement(quiz.attempt_later);
			}
			

		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}

	public void Module_Verify_Feedback_Shown_For_Correct_Answer_Selection_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);
		SoftAssert sAss = new SoftAssert();
		Thread.sleep(3000);
		applyExplicitWaitsUntilElementVisible(quiz.question);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();

				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));
				selectCorrectAnswer();

				test.log(Status.INFO, "Clicked on Check Answer button");
				System.out.println("Clicked on Check Answer button");
				// swipeDown();
				// clickOnElement(obp.check_answer);
				clickOnElement(findElementByText("Check"));
				test.log(Status.INFO, "Verifying feedback after answer selection");
				System.out.println("Verifying feedback after answer selection");
				status = quiz.answerCorrectMsg1.isDisplayed();

				sAss.assertTrue(status);
				if (status) {
					System.err.println("Shown correct feedback for correct answer selection");
					test.log(Status.INFO, "Shown correct feedback for correct answer selection");
				} else {
					System.err.println("Shown Incorrect feedback for correct answer selection");
					test.log(Status.INFO, "Shown Incorrect feedback for correct answer selection");
				}

				if ((i + 1) != questions) {
					if(!device.contains("Android"))
					{scrollTo2("Continue");
					swipeUp();}
					tapOnElement(findElementByText("Continue"));}
				i++;
			} else {
				i++;
				if(!device.contains("Android"))
					scrollTo2("attempt");
				clickOnElement(quiz.attempt_later);
			}

		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();

	}

	public void verify_submitting_Test_Without_Submitting_Answers(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);
		SoftAssert sAss = new SoftAssert();
		applyExplicitWaitsUntilElementVisible(quiz.question);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(quiz.question);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				if ((i + 1) != questions)
					clickOnElement(quiz.conti_nue);
				i++;
			} else {
				i++;
				clickOnElement(quiz.attempt_later);
			}
		}

		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		System.out.println("Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();
	}

	public void to_Verify_user_can_easily_skip_continue_to_next_question_without_attempting_current_one(String subject1,
			String topic) throws MalformedURLException, InterruptedException {
		applyExplicitWaitsUntilElementVisible(quiz.testUnit);
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
		clickOnElement(quiz.skip);
		Thread.sleep(2000);
		applyExplicitWaitsUntilElementVisible(quiz.question);
		System.out.println("Attempting the revision");
		int questions;
		if (device.contains("Android"))
			questions = getTotalQuestionsInPractice();
		else
			questions = quiz.get_Total_Number_Of_Questions_InRevision();
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

			clickOnElement(quiz.nextButton);
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

}
