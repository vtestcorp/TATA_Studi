package studi.co.pageModules;

import java.net.MalformedURLException;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Assignment_Digital_Task;
public class Module_Assignment_Digital_Task  extends BaseClass{
	Object_Assignment_Digital_Task oadt = new Object_Assignment_Digital_Task();
	SoftAssert assert1=new SoftAssert();
	Boolean status;
	public void create_Assignment_Digital_Test(String subject, String topic) throws MalformedURLException {
		scrollTo2("Assignments");
		clickOnElement(oadt.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(oadt.add_assignment);
		oadt.digital_tets.click();
		System.out.println("Clicked on Digital Test");
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
		applyExplicitWait(5);
		oadt.next1.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Clicking on create assignment " );
		System.out.println("Clicking on create assignment");
		oadt.assign.click();
		System.out.println("Created New Assignment");
	}




	public void to_verify_display_of_test_duration(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		clickOnElement(oadt.beginTest);
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		swipeDown();
		status =oadt.testTimer.isDisplayed();
		
		if (status) {
			System.out.println("Test Duration is displayed");
			test.log(Status.INFO, "Test Duration is displayed");
			assert1.assertTrue(status);
		}

		assert1.assertAll();

	}



	public void to_verify_that_after_test_begin_timer_should_get_start(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);
		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		clickOnElement(oadt.beginTest);
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		swipeDown();
		status =oadt.testTimer.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Test Duration is displayed");
			test.log(Status.INFO, "Test Duration is displayed");
		}

		assert1.assertAll();

	}





	public void to_verify_that_User_able_to_ON_Help_toggle(String subject, String topic) throws MalformedURLException {

		scrollTo2("Assignments");
		clickOnElement(oadt.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(oadt.add_assignment);
		oadt.digital_tets.click();
		System.out.println("Clicked on Digital Test");
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
		applyExplicitWait(5);
		clickOnElement(oadt.next1);
		applyExplicitWait(5);

		test.log(Status.INFO, "Clicking on Help Switch--> ON" );
		System.out.println("Clicking on Help Switch--> ON");

		clickOnElement(oadt.help);

		test.log(Status.INFO, "Clicked on Help Switch--> It shows guidelines as:\n" );
		System.out.println("Clicked on Help Switch--> It shows guidelines as:\\n");

		status =oadt.titleHelp.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Add a title that is easy to scan");
			test.log(Status.INFO, "Add a title that is easy to scan");
		}

		status =oadt.difficultyLevelHelp.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Set a difficulty level for the test");
			test.log(Status.INFO,"Set a difficulty level for the test");
		}

		status =oadt.durationHelp.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Define time required to complete this task");
			test.log(Status.INFO, "Define time required to complete this task");
		}

		status =oadt.dueDateHelp.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Set a date for completing the task");
			test.log(Status.INFO, "Set a date for completing the task");
		}
		assert1.assertAll();

	}



	public void to_verify_that_User_able_to_OFF_Help_toggle(String subject, String topic) throws MalformedURLException {
		scrollTo2("Assignments");
		clickOnElement(oadt.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(oadt.add_assignment);
		oadt.digital_tets.click();
		System.out.println("Clicked on Digital Test");
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
		applyExplicitWait(5);
		clickOnElement(oadt.next1);
		applyExplicitWait(5);

		test.log(Status.INFO, "Clicking on Help Switch--> OFF" );
		System.out.println("Clicking on Help Switch--> OFF");

		clickOnElement(oadt.help);

		test.log(Status.INFO, "Clicked on Help Switch--> It shows guidelines as:\n" );
		System.out.println("Clicked on Help Switch--> It shows guidelines as:\\n");

		//If OFF is selected for Help then User guidline should  not be display for Title ,Difficulty,Duration,Due By fields
		//User should be able to  set ON/OFF toggle for Help

		assert1.assertAll();


	}



	public void to_verify_assign_digital_test_and_success_message(String subject, String topic) throws MalformedURLException {
		scrollTo2("Assignments");
		oadt.assignment.click();

		applyExplicitWait(5);
		oadt.add_assignment.click();
		test.log(Status.INFO, "Clicked on assignments " );
		System.out.println("Clicked on assignments");

		oadt.digital_tets.click();
		System.out.println("Clicked on Digital Test");

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
		applyExplicitWait(5);
		oadt.next1.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Clicking on create assignment " );
		System.out.println("Clicking on create assignment");
		oadt.assign.click();
		test.log(Status.INFO, "Clicked on create assignment " );
		System.out.println("Clicked on create assignment");

		status = oadt.notification.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Alert Notification of success message is displayed");
			test.log(Status.INFO, "Alert Notification of success message is displayed");
		}
		assert1.assertAll();




	}



	public void to_verify_add_flag_for_review_before_submission(String subject, String topic) throws MalformedURLException {
		//		create_Assignment_Digital_Test(subject, topic);
		//		clickOnElement(oadt.viewAssignmenBtn);
		//
		//		test.log(Status.INFO, "Traversing to Begin Test" );
		//		System.out.println("Traversing to Begin Test");
		//
		clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);

		test.log(Status.INFO, "Set the flag for First question " );
		System.out.println("Set the flag for First question ");
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}


		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.next_questin_Arrow);
		status = oadt.flagged.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("The flagged question is displayed for review before the test submission");
			test.log(Status.INFO, "The flagged question is displayed for review before the test submission");
		}
		assert1.assertAll();
	}




	public void to_verify_Count_of_attempted_Pending_Flagged_questions_should_be_display() throws MalformedURLException {
		// 	create_Assignment_Digital_Test(subject, topic);
		//		clickOnElement(oadt.viewAssignmenBtn);
		//
		//		test.log(Status.INFO, "Traversing to Begin Test" );
		//		System.out.println("Traversing to Begin Test");
		//
		clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);

		test.log(Status.INFO, "Set the flag for First question " );
		System.out.println("Set the flag for First question ");
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.next_questin_Arrow);

		status = oadt.attempted.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("At End of Test--> 1. Attempted  count of Questions displayed for review before the test submission");
			test.log(Status.INFO, "At End of Test--> 1. Attempted  count of Questions displayed for review before the test submission");
		}
		status = oadt.pending.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("\n 2. Pendig count of Questions displayed for review before the test submission");
			test.log(Status.INFO, "\n 2. Pendig count of Questions displayed for review before the test submission");
		}

		status = oadt.flagged.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("The flagged Count of questions is displayed for review before the test submission");
			test.log(Status.INFO, "The flagged Count of questions is displayed for review before the test submission");
		}
		assert1.assertAll();

	}



	public void to_verify_the_review_of_digital_test(String subject, String topic) throws MalformedURLException {
		//	 	create_Assignment_Digital_Test(subject, topic);
		//		clickOnElement(oadt.viewAssignmenBtn);
		//
		//		test.log(Status.INFO, "Traversing to Begin Test" );
		//		System.out.println("Traversing to Begin Test");
		//
		clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.next_questin_Arrow);

		//clickOnElement(oadt.check_Answer);

		status = oadt.exit_Review.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("User able to review the answer of the questions on the clicking of Check Answer Button ");
			test.log(Status.INFO, "User able to review the answer of the questions on the clicking of Check Answer Button ");
		}
		assert1.assertAll();

	}


	public void to_verify_the_the_flag_reflection_on_Review(String subject, String topic) throws MalformedURLException {
		//	 	create_Assignment_Digital_Test(subject, topic);
		//		clickOnElement(oadt.viewAssignmenBtn);
		//
		//		test.log(Status.INFO, "Traversing to Begin Test" );
		//		System.out.println("Traversing to Begin Test");
		//
		clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.next_questin_Arrow);

		clickOnElement(oadt.check_Answer);
		//now chk flag reflection here


	}




	public void to_verify_the_Correct_Incorrect_answers_on_review_page() throws MalformedURLException {

		//	 	create_Assignment_Digital_Test(subject, topic);
		//		clickOnElement(oadt.viewAssignmenBtn);
		//
		//		test.log(Status.INFO, "Traversing to Begin Test" );
		//		System.out.println("Traversing to Begin Test");
		//
		clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.next_questin_Arrow);

		clickOnElement(oadt.check_Answer);
		//now chk flag reflection here
		//-On review Correct answers should display with happy emoticon and  incorrect answers display with sad emoticon 
		//-After click on emoticon page direct to perticular question 


	}




	public void to_verify_the_review_Scrolling(String subject, String topic) throws MalformedURLException {
		//	 	create_Assignment_Digital_Test(subject, topic);
		//		clickOnElement(oadt.viewAssignmenBtn);
		//
		//		test.log(Status.INFO, "Traversing to Begin Test" );
		//		System.out.println("Traversing to Begin Test");
		//
		clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.next_questin_Arrow);
		clickOnElement(oadt.check_Answer);
		//now chkreview scrolling functinality here

	}




	public void to_verify_the_close_review(String subject, String topic) throws MalformedURLException {

		//		create_Assignment_Digital_Test(subject, topic);
		//		clickOnElement(oadt.viewAssignmenBtn);
		//
		//		test.log(Status.INFO, "Traversing to Begin Test" );
		//		System.out.println("Traversing to Begin Test");
		//
		//		clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.next_questin_Arrow);

		oadt.submitTest.click();
		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");

		oadt.check_Answer.click();
		test.log(Status.INFO, "Clicked on Check Answer");
		System.out.println("Clicked on Check Answer");

		clickOnElement(oadt.backBtn);
		test.log(Status.INFO, "Clicked On Back to Summary");
		System.out.println("Clicked On Back to Summary");



		status = oadt.closeTest2.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Closed the Test using close Sign");
			test.log(Status.INFO, "Closed the Test using close Sign");
		}
		assert1.assertAll();
	}



	public void to_verify_the_exit_review(String subject, String topic) throws MalformedURLException {
		//	 	create_Assignment_Digital_Test(subject, topic);
		//		clickOnElement(oadt.viewAssignmenBtn);
		//
		//		test.log(Status.INFO, "Traversing to Begin Test" );
		//		System.out.println("Traversing to Begin Test");

		clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		test.log(Status.INFO, "End of the Test");
		System.out.println("End of the Test");
		clickOnElement(oadt.next_questin_Arrow);

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.submitTest);

		clickOnElement(oadt.check_Answer);
		//now chk exit review functinality here

		clickOnElement(oadt.exit_Review);
		status = oadt.check_Answer.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("User able to EXit review after click on Exit Review Button  ");
			test.log(Status.INFO, "User able to EXit review after click on Exit Review Button  ");
		}
		assert1.assertAll();
	}
	public void to_verify_from_review_user_should_be_able_to_redirect_the_Test_Summary_and_redo_test(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");

		clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		test.log(Status.INFO, "End of the Test");
		System.out.println("End of the Test");
		clickOnElement(oadt.next_questin_Arrow);

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.submitTest);

		clickOnElement(oadt.check_Answer);
		//now chk exit review functinality here

		clickOnElement(oadt.exit_Review);

		status = oadt.summary_Heading.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Summary with Check Answer Button is displayed   ");
			test.log(Status.INFO, "Summary with Check Answer Button is displayed   ");
		}

		status = oadt.redo_Test.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Redo Test Option is Displayed ");
			test.log(Status.INFO, "Redo Test Option is Displayed ");
		}
		assert1.assertAll();

	}




	public void to_verify_for_the_Abondon_Test() throws MalformedURLException {
		//		create_Assignment_Digital_Test(subject, topic);
		//		clickOnElement(oadt.viewAssignmenBtn);
		//
		//		test.log(Status.INFO, "Traversing to Begin Test" );
		//		System.out.println("Traversing to Begin Test");
		//
		//		clickOnElement(oadt.beginTest);
		//
		//		test.log(Status.INFO, "Attempting the test " );
		//		System.out.println("Attempting the test");

		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		clickOnElement(oadt.backBtn);
		test.log(Status.INFO, "Clicked On Back Button from the Test" );
		System.out.println("Clicked On Back Button from the Test");

		status = oadt.abandon.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("User is able to Abandon Test without attempting  any question or with attempting questions");
			test.log(Status.INFO, "User is able to Abandon Test without attempting  any question or with attempting questions\"");
		}
		assert1.assertAll();
	}

	public void to_verify_the_message_After_abandon_the_test(String subject, String topic) throws MalformedURLException {
		//		create_Assignment_Digital_Test(subject, topic);
		//		clickOnElement(oadt.viewAssignmenBtn);
		//
		//		test.log(Status.INFO, "Traversing to Begin Test" );
		//		System.out.println("Traversing to Begin Test");
		//
		//		clickOnElement(oadt.beginTest);
		//
		//		test.log(Status.INFO, "Attempting the test " );
		//		System.out.println("Attempting the test");

		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		clickOnElement(oadt.backBtn);
		test.log(Status.INFO, "Clicked On Back Button from the Test" );
		System.out.println("Clicked On Back Button from the Test");


		clickOnElement(oadt.abandon);
		test.log(Status.INFO, "Clicked for Abandon the Test" );
		System.out.println("Clicked for Abandon the Test");



		status = oadt.abandon_msg.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Your Progress will be lost. Are you sure want to go Away? : Message Displayed");
			test.log(Status.INFO, "Your Progress will be lost. Are you sure want to go Away? : Message Displayed");
		}
		assert1.assertAll();

	}





	public void to_verify_after_submitting_the_test_user_should_be_able_to_Check_Answers(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("mcq")) {
				qArray[i] = 1;
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
				System.out.println("Selecting correct answer for question " + (i + 1));

				selectCorrectAnswer();

			} else
				qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_questin_Arrow);
			i++;
		}

		test.log(Status.INFO, "End of the Test");
		System.out.println("End of the Test");
		clickOnElement(oadt.next_questin_Arrow);

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.submitTest);

		clickOnElement(oadt.check_Answer);
		//applyExplicitWaitsUntilElementVisible(oadt.wrong_ans_msg);
		status = oadt.wrong_ans_msg.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("After submitting the test user is able to Check the Answers");
			test.log(Status.INFO, "After submitting the test user is able to Check the Answers");
		}
		assert1.assertAll();

	}


}
