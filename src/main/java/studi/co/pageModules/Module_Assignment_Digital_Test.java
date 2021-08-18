package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Assignment_Digital_Test;
public class Module_Assignment_Digital_Test  extends BaseClass{
	Object_Assignment_Digital_Test oadt = new Object_Assignment_Digital_Test();
	SoftAssert assert1=new SoftAssert();
	Boolean status;
	public void create_Assignment_Digital_Test(String subject, String topic) throws MalformedURLException {
		scrollTo2("Assignments");
		clickOnElement(oadt.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		//applyExplicitWaitsUntilElementVisible(oadt.add_assignment);
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
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
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
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
		applyExplicitWaitsUntilElementVisible(oadt.questionView);
		swipeDown();
		status =oadt.testTimer.isDisplayed();

		if (status) {
			System.out.println("Test Duration is displayed");
			test.log(Status.INFO, "Test Duration is displayed");
		}
		assert1.assertTrue(status);
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

		//		test.log(Status.INFO, "Clicking on Help Switch--> ON" );
		//		System.out.println("Clicking on Help Switch--> ON");

		if (oadt.help_ON.isDisplayed()) {
			test.log(Status.INFO, "Clicked on Help Switch--> It shows guidelines as: " );
			System.out.println("Clicked on Help Switch--> It shows guidelines as: ");

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
		clickOnElement(oadt.help);//OFF help btn
		try {
			oadt.title_Instruction.isDisplayed();
			assert1.assertFalse(true);
			System.out.println("If Help is OFF then guidlines for Title is not Removed  ");
			test.log(Status.INFO, "If Help is OFF then guidlines for Title is not Removed  ");
		}
		catch(Exception e)
		{
			assert1.assertFalse(false); 
			System.out.println("If Help is OFF then guidlines for Title is Removed  ");
			test.log(Status.INFO, "If Help is OFF then guidlines for Title is Removed  ");

		}
		try {
			oadt.difficulty_level_Instruction.isDisplayed();
			assert1.assertFalse(true);
			System.out.println("If Help is OFF then guidlines for Difficulty level  is not Removed  ");
			test.log(Status.INFO, "If Help is OFF then guidlines for Difficulty level  is not Removed  ");
		}
		catch(Exception e)
		{
			assert1.assertFalse(false); 
			System.out.println("If Help is OFF then guidlines for Difficulty level is Removed  ");
			test.log(Status.INFO, "If Help is OFF then guidlines for Difficulty level is Removed  ");
		}
		try {
			oadt.difficulty_level_Instruction.isDisplayed();
			assert1.assertFalse(true);
			System.out.println("If Help is OFF then guidlines for entative Duration is not Removed  ");
			test.log(Status.INFO, "If Help is OFF then guidlines for entative Duration is not Removed  ");
		}
		catch(Exception e) {
			assert1.assertFalse(false); 
			System.out.println("If Help is OFF then guidlines for entative Duration is Removed  ");
			test.log(Status.INFO, "If Help is OFF then guidlines for entative Duration is Removed  ");
		}
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
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");

		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		clickOnElement(oadt.flag);
		applyExplicitWait(5);
		test.log(Status.INFO, "Set the flag for First question " );
		System.out.println("Set the flag for First question ");
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
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

		if (status) {
			System.out.println("The Count of flagged question is displayed for review before the test submission");
			test.log(Status.INFO, "The Count of flagged question is displayed for review before the test submission");
		}
		assert1.assertTrue(status);
		String attempted=oadt.attempted_count.getText();
		System.out.println("Count of Flagged questions: -" +attempted);

		assert1.assertAll();
	}




	public void to_verify_Count_of_attempted_Pending_Flagged_questions_should_be_display(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		
		clickOnElement(oadt.viewAssignmenBtn);
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		clickOnElement(findElementByText("Begin Test"));
		//clickOnElement(oadt.beginTest);

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		oadt.flag.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Set the flag for First question " );
		System.out.println("Set the flag for First question ");
		oadt.closePopup();
		//applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
		System.out.println(questions);
		int i = 0;
		Boolean status;

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

		String attempted=oadt.attempted_count.getText();
		String flagged=oadt.flagged_count.getText();
		String pending=oadt.pending_count.getText();

		status = oadt.attempted.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Attempted  count of Questions displayed  --  :" + attempted);
			test.log(Status.INFO, "Attempted  count of Questions displayed --  :"+ attempted );
		}

		status = oadt.pending.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Pendig count of Questions displayed --  :"+ pending );
			test.log(Status.INFO, "Pendig count of Questions displayed --  :"+ pending);
		}

		status = oadt.flagged.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("The flagged Count of questions is displayed  -- : " + flagged);
			test.log(Status.INFO, "The flagged Count of questions is displayed --  : " +flagged);
		}
		assert1.assertAll();

	}



	public void to_verify_the_review_of_digital_test(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		//		oadt.flag.click();
		//		applyExplicitWait(5);
		//		test.log(Status.INFO, "Set the flag for First question " );
		//		System.out.println("Set the flag for First question ");
		oadt.closePopup();
		//applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
		System.out.println(questions);
		int i = 0;
		Boolean status;

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
		clickOnElement(oadt.next_questin_Arrow);

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.submitTest);
		applyExplicitWaitsUntilElementVisible(findElementByText("Check"));
		clickOnElement(oadt.check_Answer);
		applyExplicitWait(5);
		//clickOnElement(oadt.check_Answer);

		status = oadt.exit_Review.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("User able to review the answer of the questions on the clicking of Check Answer Button ");
			test.log(Status.INFO, "User able to review the answer of the questions on the clicking of Check Answer Button ");
		}
		assert1.assertAll();

	}


	public void to_verify_the_the_flag_reflection_on_Review(String subject, String topic) throws MalformedURLException, InterruptedException {
		create_Assignment_Digital_Test(subject, topic);
		Thread.sleep(1000);
		clickOnElement(oadt.viewAssignmenBtn);
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		//oadt.flag.click();
		clickOnElement(oadt.flag);
		applyExplicitWait(5);
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
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
		System.out.println("Attempted the last question of the Test");
		test.log(Status.INFO, "Attempted the last question of the Test");
		Thread.sleep(3000);
		clickOnElement(oadt.submitTest);

		test.log(Status.INFO, "Test Submitted");
		System.out.println("Test Submitted");

		applyExplicitWaitsUntilElementVisible(findElementByText("Check Answers"));
		clickOnElement(findElementByText("Check Answers"));
		clickOnElement(oadt.hamburgerBtn);
		applyExplicitWaitsUntilElementVisible(findElementByText("REVIEW"));

		System.out.println("Review Page is opened after click on Check Answers");
		test.log(Status.INFO, "Flag  icon  only displayed to that question which user is selected flagged at time of  giving test");
		applyExplicitWait(5);


		try {
			status = oadt.flagged.isDisplayed();

			if (status) {
				System.out.println("Flag  icon  only displayed to that question which user is selected flagged at time of  giving test");
				test.log(Status.INFO, "Flag  icon  only displayed to that question which user is selected flagged at time of  giving test");
			}
		}
		catch(Exception ex) {
			System.out.println("Flag  icon  is not displayed on REVIEW page to that question which user is selected flagged at time of  giving test");
			test.log(Status.INFO, "Flag  icon  is not displayed on REVIEW page to that question which user is selected flagged at time of  giving test");

		}
		// flag reflection 
		assert1.assertAll();

	}
	public void to_verify_the_Correct_Incorrect_answers_on_review_page(String subject, String topic) throws MalformedURLException {

		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
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
		test.log(Status.INFO, "Going towards Review");
		System.out.println("Going towards Review");

		clickOnElement(oadt.backBtn);
		applyExplicitWaitsUntilElementVisible(findElementByText("REVIEW"));
		//-On review Correct answers should display with happy emoticon and  incorrect answers display with sad emoticon 
		//-After click on emoticon page direct to perticular question 

		assert1.assertAll();


	}




	public void to_verify_the_review_Scrolling(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);

		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		//oadt.flag.click();
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		applyExplicitWait(5);
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
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
		clickOnElement(oadt.submitTest);
		clickOnElement(oadt.check_Answer);

		test.log(Status.INFO, "Going towards Review");
		System.out.println("Going towards Review");
		applyExplicitWaitsUntilElementClickable(oadt.hamburgerBtn);
		clickOnElement(oadt.hamburgerBtn);
		applyExplicitWaitsUntilElementVisible(findElementByText("REVIEW"));
		scrollToEnd();
		scrollTo2("REVIEW");

		status=findElementByText("REVIEW").isDisplayed();

		//status = oadt.exit_Review.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Scrolling Functinality works successfully ");
			test.log(Status.INFO, "Scrolling Functinality works successfully ");
		}


		assert1.assertAll();

	}




	public void to_verify_the_close_review(String subject, String topic) throws MalformedURLException {

		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);

		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		oadt.flag.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Set the flag for First question " );
		System.out.println("Set the flag for First question ");
		oadt.closePopup();
		//applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
		System.out.println(questions);
		int i = 0;
		Boolean status;

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
		clickOnElement(oadt.next_questin_Arrow);

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.submitTest);
		applyExplicitWaitsUntilElementVisible(findElementByText("Check"));
		clickOnElement(oadt.check_Answer);
		applyExplicitWait(5);


		status = oadt.exit_Review.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("User able to review the answer of the questions on the clicking of Check Answer Button ");
			test.log(Status.INFO, "User able to review the answer of the questions on the clicking of Check Answer Button ");
		}


		assert1.assertAll();

	}


	public void to_verify_the_exit_review(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		oadt.flag.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Set the flag for First question " );
		System.out.println("Set the flag for First question ");
		oadt.closePopup();
		//applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
		System.out.println(questions);
		int i = 0;
		Boolean status;

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
		clickOnElement(oadt.next_questin_Arrow);

		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.submitTest);
		applyExplicitWaitsUntilElementVisible(findElementByText("Check"));
		clickOnElement(oadt.check_Answer);
		applyExplicitWait(5);


		//status = oadt.exit_Review.isDisplayed();
		status=findElementByText("Exit Review").isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("User able to review the answer of the questions on the clicking of Check Answer Button ");
			test.log(Status.INFO, "User able to review the answer of the questions on the clicking of Check Answer Button ");
		}
		
		applyExplicitWaitsUntilElementVisible(oadt.question);
		tapOnElement(findElementByText("Exit Review"));
		applyExplicitWaitsUntilElementVisible(findElementByText("Redo"));

		status = findElementByText("Redo Test").isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("After clcik on exit review button  page  directed to Redo test");
			test.log(Status.INFO, "After clcik on exit review button  page  direcedt to Redo test");
		}

		assert1.assertAll();

	}
	public void to_verify_from_review_user_should_be_able_to_redirect_the_Test_Summary_and_redo_test(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		oadt.flag.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Set the flag for First question " );
		System.out.println("Set the flag for First question ");
		oadt.closePopup();
		//applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
		System.out.println(questions);
		int i = 0;
		Boolean status;

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
		clickOnElement(oadt.next_questin_Arrow);
		test.log(Status.INFO, "Submitting Test");
		System.out.println("Submitting Test");
		clickOnElement(oadt.submitTest);
		applyExplicitWaitsUntilElementVisible(findElementByText("Check Answers"));
		clickOnElement(oadt.check_Answer);
		applyExplicitWait(3);
		//clickOnElement(oadt.exit_Review);
		applyExplicitWaitsUntilElementClickable(findElementByText("Exit Review"));
		clickOnElement(findElementByText("Exit Review"));
		status =findElementByText("Check Answers").isDisplayed();
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




	public void to_verify_for_the_Abondon_Test(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");

		//clickOnElement(oadt.beginTest);
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		clickOnElement(findElementByText("Begin Test"));

		//		test.log(Status.INFO, "Attempting the test " );
		//		System.out.println("Attempting the test");
		//		oadt.flag.click();
		//		applyExplicitWait(5);
		//		test.log(Status.INFO, "Set the flag for First question " );
		//		System.out.println("Set the flag for First question ");
		//		oadt.closePopup();
		//		//applyExplicitWait(3);

		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
		System.out.println(questions);
		//		int i = 0;
		//		Boolean status;
		//
		//		while (i < questions) {
		//
		//			int[] qArray = new int[questions];
		//			test.log(Status.INFO, "Question " + (i + 1));
		//			System.out.println("Question " + (i + 1));
		//
		//			if (verifySCQorMCQ().contains("mcq")) {
		//				qArray[i] = 1;
		//				applyExplicitWait(5);
		//				actualcount++;
		//				swipeUp();
		//				test.log(Status.INFO, "Selecting correct answer for question " + (i + 1));
		//				System.out.println("Selecting correct answer for question " + (i + 1));
		//
		//				selectCorrectAnswer();
		//
		//			} else
		//				qArray[i] = 0;
		//			if ((i + 1) != questions)
		//				clickOnElement(oadt.next_questin_Arrow);
		//			i++;
		//		}
		//		//clickOnElement(oadt.next_questin_Arrow);
		//		applyExplicitWait(3);

		//clickOnElement(oadt.backBtn);
		clickOnElement(oadt.hamburgerBtn);
		test.log(Status.INFO, "Clicked On Back Button from the Test" );
		System.out.println("Clicked On Back Button from the Test");
		applyExplicitWait(2);
		status = oadt.abandon_Test.isDisplayed();

		assert1.assertTrue(status);
		if (status) {
			System.out.println("User is able to Abandon Test without attempting  any question or with attempting questions");
			test.log(Status.INFO, "User is able to Abandon Test without attempting  any question or with attempting questions\"");
		}
		assert1.assertAll();
	}

	public void to_verify_the_message_After_abandon_the_test(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));

		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		oadt.flag.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Set the flag for First question " );
		System.out.println("Set the flag for First question ");
		oadt.closePopup();
		//applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
		System.out.println(questions);

		clickOnElement(oadt.hamburgerBtn);
		test.log(Status.INFO, "Clicked On Back Button from the Test" );
		System.out.println("Clicked On Back Button from the Test");
		clickOnElement(oadt.abandon_Test);
		test.log(Status.INFO, "Clicked for Abandon the Test" );
		System.out.println("Clicked for Abandon the Test");
		status = oadt.abandon_msg.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Your Progress will be lost. Are you sure want to go Away? : Message Displayed");
			test.log(Status.INFO, "Your Progress will be lost. Are you sure want to go Away? : Message Displayed");
		}
		clickOnElement(oadt.abandon_Test_msg);

		status = oadt.redo_Test.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("User  able to Abandon Test without attempting  any question or with attempting questions");
			test.log(Status.INFO, "User  able to Abandon Test without attempting  any question or with attempting questions");
		}
		assert1.assertAll();

	}

	public void to_verify_after_submitting_the_test_user_should_be_able_to_Check_Answers(String subject, String topic) throws MalformedURLException {
		create_Assignment_Digital_Test(subject, topic);
		clickOnElement(oadt.viewAssignmenBtn);
		test.log(Status.INFO, "Opening the created Assignment" );
		System.out.println("Opening the created Assignment");

		test.log(Status.INFO, "Traversing to Begin Test" );
		System.out.println("Traversing to Begin Test");
		applyExplicitWaitsUntilElementVisible(findElementByText("What you will be tested on"));
		//clickOnElement(oadt.beginTest);
		clickOnElement(findElementByText("Begin Test"));
		test.log(Status.INFO, "Attempting the test " );
		System.out.println("Attempting the test");
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		oadt.flag.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Set the flag for First question " );
		System.out.println("Set the flag for First question ");
		oadt.closePopup();
		//applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
		System.out.println(questions);
		int i = 0;
		Boolean status;

		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().contains("SCQ")||(verifySCQorMCQ().contains("mcq"))) {
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
		clickOnElement(oadt.next_questin_Arrow);

		clickOnElement(oadt.submitTest);
		test.log(Status.INFO, "Submitted The Test");
		System.out.println("Submitted The Test");

		clickOnElement(oadt.check_Answer);
		test.log(Status.INFO, "Verifying feedback after answer selection");
		System.out.println("Verifying feedback after answer selection");

		//applyExplicitWait(3);
		try {
			status = findElementByText("That’s right.").isDisplayed();
			assert1.assertTrue(status);
			if (status) {
				System.out.println("Shown incorrect feedback for wrong answer");
				test.log(Status.INFO, "Shown incorrect feedback for wrong answer");
			}
		}

		catch(Exception ex) {

			status = findElementByText("Oops! You missed this.").isDisplayed();
			assert1.assertTrue(status);
			if (status) {
				System.err.println("Shown incorrect feedback for wrong answer");
				test.log(Status.INFO, "Shown incorrect feedback for wrong answer");
			}
		}
		System.err.println("User should be able to check anwers of all questions attempted with the submitted  answers");
		test.log(Status.INFO, "User should be able to check anwers of all questions attempted with the submitted  answers");
		assert1.assertAll();	
	}



	public SoftAssert to_set_the_flag() throws MalformedURLException
	{
		SoftAssert assert1 = new SoftAssert();
		Set<String> allQuestions = new HashSet<>();

		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oadt.question);
		int questions = oadt.get_Total_Number_Of_Questions_In_digital_Test();
		int i = 0;
		int j = 0;
		clickOnElement(oadt.hamburgerBtn);
		Iterator<String> it = allQuestions.iterator();
		ArrayList<MobileElement> queCount;

		if (device.contains("Android"))
			queCount = (ArrayList<MobileElement>) getDriver().findElementsById("com.tce.studi:id/tvQuestion");
		else
			queCount = (ArrayList<MobileElement>) getDriver().findElements(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell"));

		System.err.println("Count : " + queCount.size());
		String[] hList = new String[queCount.size()];
		for (MobileElement mobileElement : queCount)
			hList[j++] = mobileElement.getText();

		applyExplicitWait(2);
		if (device.contains("Android"))
			clickOnElement(findElementByText(hList[0].toString()));
		else
			clickOnElement(findElementByText("Q1"));

		while (i < questions) {

			applyExplicitWait(2);
			clickOnElement(oadt.queFlag);
			test.log(Status.INFO, "quesetiong flag");
			System.out.println("quesetiong flag");
			applyExplicitWait(2);
			clickOnElement(oadt.hamburgerBtn);

			assert1.assertTrue(oadt.hamFlag.isDisplayed());
			test.log(Status.INFO, "Hamburger flag");
			System.out.println("Hamburger flag");

			applyExplicitWait(2);
			if (device.contains("Android"))
				clickOnElement(findElementByText(hList[i].split(":")[0]));
			else
				clickOnElement(findElementByText("Q" + (i + 1)));
			test.log(Status.INFO, it.toString());
			System.out.println(it.toString());
			test.log(Status.INFO, "quesetion number");
			System.out.println("quesetion number");

			applyExplicitWait(2);
			clickOnElement(oadt.queFlag);
			test.log(Status.INFO, "quesetiong flag");
			System.out.println("quesetiong flag");

			applyExplicitWait(2);
			clickOnElement(oadt.hamburgerBtn);
			applyExplicitWait(2);
			if ((i + 1) != questions) {
				if (device.contains("Android"))
					clickOnElement(findElementByText(hList[i + 1].split(":")[0]));
				else
					clickOnElement(findElementByText("Q" + (i + 2)));
			}
			i++;
		}

		return assert1;

	}

}






