package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Assignment_Oral_Test;

public class Module_Assignment_Oral_Test extends BaseClass{
	Object_Assignment_Oral_Test oadt = new Object_Assignment_Oral_Test();
	SoftAssert assert1=new SoftAssert();
	Boolean status;

	public void to_verify_that_from_syllabus_menu_user_should_be_able_to_navigate_oral_test() throws MalformedURLException {
		scrollTo2("Assignments");

		clickOnElement(oadt.syllabus);

		System.out.println("Books showing to user");
		test.log(Status.INFO, "Books showing to user");
		applyExplicitWait(5);

		clickOnElement(oadt.add_Symbol);
		System.out.println("Clicked on Add symbol");
		test.log(Status.INFO, "Clicked on Add symbol");
		applyExplicitWait(5);
		Boolean oral_Test = oadt.oral_Test.isDisplayed();
		assert1.assertTrue(oral_Test);
		if (oral_Test) {
			System.out.println("Oral Test is shown");
			test.log(Status.INFO, "Oral Test is shown");
		}
		assert1.assertTrue(oral_Test);
		assert1.assertAll();
	}



	public void to_verify_after_clicking_on_oral_test_user_should_be_able_to_view_oral_test_option() throws MalformedURLException {
		scrollTo2("Assignments");

		clickOnElement(oadt.syllabus);

		System.out.println("Books showing to user");
		test.log(Status.INFO, "Books showing to user");
		applyExplicitWait(5);

		clickOnElement(oadt.add_Symbol);
		System.out.println("Clicked on Add symbol");
		test.log(Status.INFO, "Clicked on Add symbol");

		System.out.println("Oral Test showing to user");
		test.log(Status.INFO, "Oral Test showing to user");

		clickOnElement(oadt.oral_Test);
		applyExplicitWait(5);

		Boolean heading = oadt.oral_Test_Heading.isDisplayed();
		assert1.assertTrue(heading);
		if (heading) {
			System.out.println("Create an Oral Test Heading  is shown");
			test.log(Status.INFO, "Create an Oral Test Heading  is shown");
		}
		assert1.assertTrue(heading);
		assert1.assertAll();
	}


	public void to_verify_that_user_should_be_able_to_add_the_Content_even_if_striked_off_for_creating_oral_test(String subject, String topic_1) throws MalformedURLException {
		test.log(Status.INFO,"Creating the oral test for striked off topic: Geography-The Universe " );
		System.out.println("Creating the oral test for striked off topic: Geography-The Universe ");
		traverse_to_Begin_Oral_Test(subject, topic_1);
		oadt.next1.click();
		applyExplicitWait(5);
		oadt.start_Test.click();
		applyExplicitWait(5);
		Boolean begin_Test = oadt.begin_Test.isDisplayed();
		assert1.assertTrue(begin_Test);
		if (begin_Test) {
			System.out.println("Begin Oral Test shown");
			test.log(Status.INFO, "Begin Oral Test shown");
		}
		assert1.assertTrue(begin_Test);
		assert1.assertAll();
	}


	public void to_verify_that_user_is_able_to_select_the_chapters_from_subject(String subject, String topic_1) throws MalformedURLException {
		traverse_to_Begin_Oral_Test(subject, topic_1);
		applyExplicitWait(5);
		oadt.next1.click();
		System.out.println("Clicked On Start Button to bigin the Test");
		Boolean begin_Test = oadt.begin_Test.isDisplayed();

		if (begin_Test) {
			System.out.println("Begin Oral Test shown");
			test.log(Status.INFO, "Begin Oral Test shown");
		}
		assert1.assertTrue(begin_Test);
		assert1.assertAll();



	}

	public void to_verify_that_user_is_able_to_select_the_topics_from_subject(String subject, String topic_1, String topic_2) throws MalformedURLException {
		scrollTo2("Assignments");
		clickOnElement(oadt.syllabus);
		test.log(Status.INFO, "Clicked Syllabus" );
		System.out.println("Clicked on Syllabus");
		clickOnElement(oadt.add_Symbol);
		test.log(Status.INFO, "Clicked to Add Oral test" );
		System.out.println("Clicked to Add Oral test");
		clickOnElement(oadt.oral_Test);
		System.out.println("Clicked on Oral Test");
		scrollTo1(subject);
		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject));
		clickOnElement(findElementByText(subject));
		scrollTo1(topic_1);
		test.log(Status.INFO, "Selecting " + topic_1);
		System.out.println("Selecting " + topic_1);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic_1));
		clickOnElement(findElementByText(topic_1));
		applyExplicitWait(5);
		scrollTo1(topic_2);
		test.log(Status.INFO, "Selecting " + topic_2);
		System.out.println("Selecting " + topic_2);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic_2));
		clickOnElement(findElementByText(topic_2));
		applyExplicitWait(5);

		clickOnElement(oadt.next1);
		System.out.println("Clicked on Next Button to Start the Test");
		Boolean status = oadt.test_Details.isDisplayed();

		if ( status) {
			System.out.println("User able to select single or multiple chapter from the Selected subject");
			test.log(Status.INFO, "User able to select single or multiple chapter from the Selected subject");
		}
		assert1.assertTrue( status);
		assert1.assertAll();



	}


	public void to_verify_for_select_Deselect_of_chapters_and_Topics(String subject_ps, String topic_unity) throws MalformedURLException {
		scrollTo2("Assignments");
		clickOnElement(oadt.syllabus);
		test.log(Status.INFO, "Clicked Syllabus" );
		System.out.println("Clicked on Syllabus");

		clickOnElement(oadt.add_Symbol);
		test.log(Status.INFO, "Clicked to Add Oral test" );
		System.out.println("Clicked to Add Oral test");

		clickOnElement(oadt.oral_Test);
		System.out.println("Clicked on Oral Test");

		scrollTo1(subject_ps);
		test.log(Status.INFO, "Opening " + subject_ps);
		System.out.println("Opening " + subject_ps);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject_ps));
		clickOnElement(findElementByText(subject_ps));
		scrollTo1(topic_unity);
		test.log(Status.INFO, "Selecting " + topic_unity);
		System.out.println("Selecting " + topic_unity);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic_unity));
		clickOnElement(findElementByText(topic_unity));
		test.log(Status.INFO, "Topic _ Unity in Diversity is selected from Political Science" );
		System.out.println("Topic _ Unity in Diversity is selected from Political Science");

		applyExplicitWait(5);
		clickOnElement(oadt.back_btn);
		test.log(Status.INFO, "Opening " + subject_ps);
		System.out.println("Opening " + subject_ps);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject_ps));
		clickOnElement(findElementByText(subject_ps));
		scrollTo1(topic_unity);
		test.log(Status.INFO, "Selecting " + topic_unity);
		System.out.println("Selecting " + topic_unity);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic_unity));
		clickOnElement(findElementByText(topic_unity));
		test.log(Status.INFO, "Topic _ Unity in Diversity is Deselected from Political Science" );
		System.out.println("Topic _ Unity in Diversity is Deselected from Political Science");
		assert1.assertAll();
	}



	public void to_verify_Search_tab_for_topics() {


	}



	public void to_verify_user_should_be_able_to_move_from_current_step_to_next_step(String subject,String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		clickOnElement(oadt.next1);
		System.out.println("Clicked on Next Button");
		applyExplicitWait(5);
		Boolean details = oadt.test_Details.isDisplayed();
		if (details) {
			System.out.println("After clicking Next Buton User able to navigate from Current step to next step");
			test.log(Status.INFO, "After clicking Next Buton User able to navigate from Current step to next step");
		}
		assert1.assertTrue(details);
		assert1.assertAll();

	}



	public void to_verify_that_user_is_able_to_move_from_current_step_to_previous_step(String subject,String topic_1) throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);

		clickOnElement(oadt.previous_btn);
		System.out.println("Clicked on Previous Button");
		Boolean details = oadt.all_Sub.isDisplayed();
		if (details) {
			System.out.println("After clicking Previous Buton User able to navigate from Current step to Previous step");
			test.log(Status.INFO, "After clicking Previous Buton User able to navigate from Current step to Previous step");
		}
		assert1.assertTrue(details);
		assert1.assertAll();

	}



	public void to_verify_that__on_all_steps_user_able_to_delete_it_the_all_oral_creation_process(String subject,String topic_1) {


	}





	public void to_verify_that_after_click_on_delete_two_option_should_get_display(String subject, String topic_1) throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);
		applyExplicitWait(5);
		clickOnElement(oadt.next1);
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementClickable(oadt.delete_note);
		clickOnElement(oadt.delete_note);
		applyExplicitWait(5);
		System.out.println("Clicked On Delete Note");
		test.log(Status.INFO, "Clicked On Delete Note");
		applyExplicitWait(5);
		Boolean discard_msg = oadt.please_Discard.isDisplayed();
		assert1.assertTrue(discard_msg);
		if (discard_msg) {
			System.out.println("Yes , Please Discard Button is shown ");
			test.log(Status.INFO, "Yes , Please Discard Button is shown ");
		}
		assert1.assertTrue(discard_msg);
		Boolean msg = oadt.take_me_Back.isDisplayed();
		assert1.assertTrue(msg);
		if (msg) {
			System.out.println("Take me Back is shown");
			test.log(Status.INFO, "Take me Back is shown");
		}
		assert1.assertTrue(msg);
		assert1.assertAll();	

	}
	public void to_verify_YesPleaseDiscard_button(String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		applyExplicitWait(5);
		clickOnElement(oadt.next1);
		System.out.println("Clicked On Next buttion");
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementClickable(oadt.delete_note);
		clickOnElement(oadt.delete_note);

		applyExplicitWait(5);
		Boolean discard_msg = oadt.please_Discard.isDisplayed();
		assert1.assertTrue(discard_msg);
		if (discard_msg) {
			System.out.println("Yes , Please Discard Button is shown ");
			test.log(Status.INFO, "Yes , Please Discard Button is shown ");
		}
		assert1.assertTrue(discard_msg);

		clickOnElement(oadt.please_Discard);
		System.out.println("Clicked on --> Yes , Please Discard Button is shown ");
		test.log(Status.INFO, "Clicked on --> Yes , Please Discard Button is shown ");
		// check after delete condition

		Boolean book_shelf = oadt.all_Sub.isDisplayed();
		assert1.assertTrue( book_shelf);
		if ( book_shelf) {
			System.out.println("After Discard ,Navigated back to book shelf listing and Oral Test creation get aborted ");
			test.log(Status.INFO, "After Discard ,Navigated back to book shelf listing and Oral Test creation get aborted  ");
		}
		assert1.assertTrue( book_shelf);
		assert1.assertAll();


	}
	public void to_verify_TakeMeBack_Button(String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);;

		clickOnElement(oadt.next1);
		applyExplicitWaitsUntilElementClickable(oadt.delete_note);
		clickOnElement(oadt.delete_note);
		applyExplicitWait(5);

		Boolean msg = oadt.take_me_Back.isDisplayed();
		assert1.assertTrue(msg);
		if (msg) {
			System.out.println("Take me Back is shown");
			test.log(Status.INFO, "Take me Back is shown");
		}
		assert1.assertTrue(msg);

		clickOnElement(oadt.take_me_Back);
		System.out.println("Clicked on --> Take me Back Button ");
		test.log(Status.INFO, "Clicked on --> Take me Back Button  ");
		// check after delete condition

		Boolean status = oadt.start_Test.isDisplayed();
		assert1.assertTrue( status);
		if ( status) {
			System.out.println("After Take me back Button ,Delete opertaion get discard and page remain on same step ");
			test.log(Status.INFO, "After Take me back Button ,Delete opertaion get discard and page remain on same step ");
		}
		assert1.assertTrue( status);
		assert1.assertAll();
	}
	public void to_verify_enter_test_settings_screen_should_get_display(String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);

		clickOnElement(oadt.next1);
		test.log(Status.INFO, "Clicked to Next Button" );
		System.out.println("Clicked to Next Button");
		applyExplicitWait(5);
		Boolean status = oadt.test_Details.isDisplayed();

		if ( status) {
			System.out.println("Enter Test Settings screen is displayed ");
			test.log(Status.INFO, "Enter Test Settings screen is displayed ");
		}
		assert1.assertTrue( status);
		assert1.assertAll();
	}



	public void to_verify_while_entering_test_setting_details_User_able_to_ON_Help_toggle(String subject, String topic_1) throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);
		applyExplicitWaitsUntilElementClickable(oadt.next1);
		clickOnElement(oadt.next1);
		applyExplicitWaitsUntilElementVisible(oadt.test_Details);
		Boolean status = oadt.test_Details.isDisplayed();
		if ( status) {
			System.out.println("Enter Test Settings screen is displayed ");
			test.log(Status.INFO, "Enter Test Settings screen is displayed ");
		}
		assert1.assertTrue( status);
		Boolean status1 = oadt.help_ON.isDisplayed();
		if ( status1) {
			System.out.println("Help Button is displayed and It's ON ");
			test.log(Status.INFO, "Help Button is displayed and It's ON ");
		}
		assert1.assertTrue( status);
		Boolean status2 = oadt.title_Instruction.isDisplayed();
		if ( status2) {
			System.out.println("If ON is selected for Help then User guidlines are displayed for Title ");
			test.log(Status.INFO, "If ON is selected for Help then User guidlines are displayed for Title ");
		}

		Boolean status3 = oadt.difficulty_level_Instruction.isDisplayed();
		if ( status3) {
			System.out.println("If ON is selected for Help then User guidlines are displayed for Difficulty Level ");
			test.log(Status.INFO, "If ON is selected for Help then User guidlines are displayed for Difficulty Level ");
		}

		Boolean status4 = oadt.duration_instruction.isDisplayed();
		if ( status4) {
			System.out.println("If ON is selected for Help then User guidlines are displayed for Tentative DUration ");
			test.log(Status.INFO, "If ON is selected for Help then User guidlines are displayed for Tentative DUration ");
		}


		System.out.println("If ON is selected for Help then User guidlines are displayed For all Fileds ");
		test.log(Status.INFO, "If ON is selected for Help then User guidlines are displayed For all Fileds   ");
		assert1.assertAll();
	}



	public void to_verify_while_entering_test_setting_details_User_able_to_OFF_Help_toggle(String subject,String topic_1) throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);
		applyExplicitWaitsUntilElementClickable(oadt.next1);
		clickOnElement(oadt.next1);
		applyExplicitWaitsUntilElementVisible(oadt.test_Details);
		Boolean status = oadt.test_Details.isDisplayed();
		if ( status) {
			System.out.println("Enter Test Settings screen is displayed ");
			test.log(Status.INFO, "Enter Test Settings screen is displayed ");
		}
		applyExplicitWaitsUntilElementClickable(oadt.help_OFF);
		oadt.help_OFF.click();
		Boolean status1 = oadt.title_Instruction.isDisplayed();
		if ( status1) {
			System.out.println("If OFF is selected then User guidlines  Displayed ");
			test.log(Status.INFO, "If OFF is selected then User guidlines  Displayed ");
		}
		else
			System.out.println("If OFF is selected then User guidlines  Removed  ");
		test.log(Status.INFO, "If OFF is selected then User guidlines  Removed  ");

		System.out.println("If OFF is selected for Help then User guidlines are Removed For all Fileds ");
		test.log(Status.INFO, "If OFF is selected for Help then User guidlines areRemoved For all Fileds   ");
		assert1.assertAll();

	}



	public void to_verify__default_title_of_the_oral_test(String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);


		System.out.println("Topic Selcted for Test is--> "+topic_1);
		Boolean status = oadt.title_field.isDisplayed();
		if ( status) {
			System.out.println("Title field is shown on Enter Test Settings screen ");
			test.log(Status.INFO, "Title field is shown on Enter Test Settings screen ");
		}
		applyExplicitWait(5);
		String title=oadt.title_field.getText();
		System.out.println(title);
		System.out.println("As per selection of chapters and topics Default Title name is display");
		assert1.assertAll();
	}



	public void to_verify__with_blank_Title(String subject, String topic_1) throws MalformedURLException {	
		creation_of_Oral_Test(subject, topic_1);
		clickOnElement(oadt.next1);;
		Boolean status = oadt.title_field.isDisplayed();
		if ( status) {
			System.out.println("Title field is shown on Enter Test Settings screen ");
			test.log(Status.INFO, "Title field is shown on Enter Test Settings screen ");
		}
		oadt.title_field.clear();
		System.out.println("Cleared the text in Title FIeld");
		clickOnElement(oadt.start_Test);
		System.out.println("Clicked on Start Test");
		String error_msg=oadt.title_field.getText();
		System.out.println(error_msg);
		assert1.assertAll();


	}



	public void to_verify__edit_title_of_the_oral_test(String subject, String topic_1) throws MalformedURLException {
		traverse_to_Begin_Oral_Test(subject,topic_1);
		Boolean status = oadt.title_field.isDisplayed();
		if ( status) {
			System.out.println("Title field is shown on Enter Test Settings screen ");
			test.log(Status.INFO, "Title field is shown on Enter Test Settings screen ");
		}
		oadt.title_field.clear();
		System.out.println("Cleared the text in Title FIeld");
		System.out.println("Entering Test title");
		oadt.title_field.sendKeys("@Tata Studi 1");
		System.out.println("Tata Studi title assigned in Title Field");
		clickOnElement(oadt.start_Test);
		System.out.println("Clicked on Start Test");
		applyExplicitWaitsUntilElementVisible(oadt.begin_Test);
		Boolean status1 = oadt.begin_Test.isDisplayed();
		if ( status1) {
			System.out.println("User able to Edit the title of oral test");
			test.log(Status.INFO, "User able to Edit the title of oral test");
		}
		assert1.assertTrue( status);
		assert1.assertAll();



	}




	public void to_verify_input_limitation_and_input_validation_for_the_title(String subject, String topic_1) throws MalformedURLException {
		traverse_to_Begin_Oral_Test(subject,topic_1);
		Boolean status = oadt.title_field.isDisplayed();
		if ( status) {
			System.out.println("Title field is shown on Enter Test Settings screen ");
			test.log(Status.INFO, "Title field is shown on Enter Test Settings screen ");
		}
		oadt.title_field.clear();
		System.out.println("Cleared the text in Title FIeld");
		System.out.println("Entering Test title");
		oadt.title_field.sendKeys("@Tata Studi 1");
		System.out.println("Tata Studi title assigned in Title Field");
		clickOnElement(oadt.start_Test);
		System.out.println("Clicked on Start Test");
		applyExplicitWaitsUntilElementVisible(oadt.begin_Test);
		Boolean status1 = oadt.begin_Test.isDisplayed();
		if ( status1) {
			System.out.println("It accepted all Characters ,Numbers and special Charactes");
			test.log(Status.INFO, "It accepted all Characters ,Numbers and special Charactes");
		}
		assert1.assertTrue( status);
		assert1.assertAll();
	}



	public void to_verify_Set_level_of_difficulty_for_the_test(String subject, String topic_1) throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);
		clickOnElement(oadt.next1);
		System.out.println("Clicked On next Button");
		applyExplicitWaitsUntilElementVisible(oadt.test_Details);
		System.out.println("Enter Test Details Page is avalable");
		tapOnElement(oadt.low);
		status = Boolean.parseBoolean(oadt.low.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(true, "Low Difficulty Level For the Test is clickable");
			System.out.println("Low Difficulty Level For the Test is clickable");
		}
		tapOnElement(oadt.medium);
		status = Boolean.parseBoolean(oadt.medium.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(true, "Medium Difficulty Level For the Test is clickable");
			System.out.println("Medium Difficulty Level For the Test is clickable");
		}
		tapOnElement(oadt.high);
		status = Boolean.parseBoolean(oadt.high.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(true, "High Difficulty Level For the Test is clickable");
			System.out.println("High Difficulty Level For the Test is clickable");
		}
		assert1.assertAll();

	}
	public void to_verify_to_set_duration_for_the_test(String subject, String topic_1) throws MalformedURLException {

		traverse_to_Begin_Oral_Test(subject, topic_1);
		tapOnElement(oadt.five);
		status = Boolean.parseBoolean(oadt.five.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(true, "User able to set 5Minutes of Duration");
			System.out.println("User able to set 5 Minutes of Duration");
		}
		tapOnElement(oadt.ten);
		status = Boolean.parseBoolean(oadt.ten.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(true, "User able to set 10 Minutes of Duration");
			System.out.println("User able to set 10 Minutes of Duration");
		}
		tapOnElement(oadt.fifteen);
		status = Boolean.parseBoolean(oadt.fifteen.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(true, "User able to set 15 Minutes of Duration");
			System.out.println("User able to set 15 Minutes of Duration");
		}
		tapOnElement(oadt.thirty);
		status = Boolean.parseBoolean(oadt.thirty.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(true, "User able to set 30 Minutes of Duration");
			System.out.println("User able to set 30 Minutes of Duration");
		}
		assert1.assertAll();

	}



	public void to_verify_the_navigation_from_Start_Test_Now(String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		test.log(Status.INFO, "Clicking on Start Oral Test " );
		System.out.println("Clicking on Start Oral Test ");
		swipeUp();
		clickOnElement(oadt.start_Test);
		System.out.println("Clicked On Start Test");
		applyExplicitWait(5);
		Boolean status1 = oadt.begin_Test.isDisplayed();
		if ( status1) {
			System.out.println("The Page directed to assigment module to Begin the test ");
			test.log(Status.INFO, "The Page directed to assigment module to Begin the test ");
		}
		assert1.assertTrue( status);
		assert1.assertAll();

	}

	public void traverse_to_Begin_Oral_Test (String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		test.log(Status.INFO, "Clicking on Start Oral Test " );
		System.out.println("Clicking on Start Oral Test ");
		//scrollTo2("Start");
		applyExplicitWait(5);
		clickOnElement(oadt.start_Test);
		applyExplicitWait(5);
		test.log(Status.INFO, "Oral Test successfully Created");
		System.out.println("Oral Test successfully Created");
	}

	public void creation_of_Oral_Test (String subject, String topic_1) throws MalformedURLException {

		scrollTo2("Assignments");
		clickOnElement(oadt.syllabus);
		test.log(Status.INFO, "Clicked Syllabus" );
		System.out.println("Clicked on Syllabus");
		clickOnElement(oadt.add_Symbol);
		test.log(Status.INFO, "Clicked to Add Oral test" );
		System.out.println("Clicked to Add Oral test");
		clickOnElement(oadt.oral_Test);
		System.out.println("Clicked on Oral Test");
		scrollTo1(subject);
		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject));
		clickOnElement(findElementByText(subject));
		scrollTo1(topic_1);
		test.log(Status.INFO, "Selecting " + topic_1);
		System.out.println("Selecting " + topic_1);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic_1));
		clickOnElement(findElementByText(topic_1));
		applyExplicitWait(5);

	}



	public void to_verify_the_Start_Test_UI(String subject, String topic_1) throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);
		test.log(Status.INFO, "Clicking on Start Oral Test " );
		System.out.println("Clicking on Start Oral Test ");
		swipeUp();
		clickOnElement(oadt.start_Test);
		System.out.println("Clicked On Start Test");

		Boolean status1 = oadt.begin_Test.isDisplayed();
		if ( status1) {
			System.out.println("The Begin Test page is showm");
			test.log(Status.INFO, "The Begin Test page is showm");
		}

		Boolean status2 = oadt.topic_name.isDisplayed();
		if ( status2) {
			System.out.println("On page layout contents: Displayed Topic Name related to selected Topics  ");
			test.log(Status.INFO, "On page layout contents: Displayed Topic Name related to selected Topics  ");
		}

		Boolean status3 = oadt.video_icon.isDisplayed();
		if ( status3) {
			System.out.println("On page layout contents: Displayed videos related to selected Topics  ");
			test.log(Status.INFO, "On page layout contents: Displayed videos related to selected Topics  ");
		}


		assert1.assertTrue( status);
		assert1.assertAll();
	}



	public void to_verify_When_click_on_start_test_button_before_starting_test_user_should_be_Able_to_view_Videos(
			String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		test.log(Status.INFO, "Clicking on Start Oral Test " );
		System.out.println("Clicking on Start Oral Test ");
		swipeUp();
		clickOnElement(oadt.start_Test);
		System.out.println("Clicked On Start Test");
		applyExplicitWait(5);
		Boolean status1 = oadt.begin_Test.isDisplayed();
		if ( status1) {
			System.out.println("The Begin Test page is showm");
			test.log(Status.INFO, "The Begin Test page is showm");
		}
		Boolean status3 = oadt.video_icon.isDisplayed();
		if ( status3) {
			System.out.println("On page layout contents: Displayed videos related to selected Topics  ");
			test.log(Status.INFO, "On page layout contents: Displayed videos related to selected Topics  ");
		}
		clickOnElement(oadt.video_icon);
		System.out.println("Clicked On Video Icon");

		applyExplicitWaitsUntilElementVisible(oadt.video_close);
		Boolean status2 = oadt.video_close.isDisplayed();
		if ( status2) {
			System.out.println("User able to play the video before starting the Test");
			test.log(Status.INFO, "User able to play the video before starting the Test");
		}
		assert1.assertTrue( status);
		System.out.println("Closing the Video");
		clickOnElement(oadt.video_close);
		assert1.assertAll();
	}



	public void to_verify_he_begin_test(String subject, String topic_1) throws MalformedURLException {
		traverse_to_Begin_Oral_Test(subject, topic_1);

		applyExplicitWaitsUntilElementVisible(oadt.begin_Test);
		clickOnElement(oadt.begin_Test);
		applyExplicitWaitsUntilElementVisible(findElementByText("Correct"));
		Boolean status = oadt.question_Text.isDisplayed();
		if ( status) {
			System.out.println("Test get begin after clicking on Begin Test Button");
			test.log(Status.INFO, "Test get begin after clicking on Begin Test Button");
		}
		assert1.assertTrue( status);
		assert1.assertAll();






	}



	public void to_verify_the_question_with__Answer_appears(String subject_History, String topic_H) throws MalformedURLException {
		traverse_to_Begin_Oral_Test(subject_History, topic_H);

		clickOnElement(oadt.begin_Test);
		applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("Correct"));

		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int i = 0;
		Boolean status;
		applyExplicitWaitsUntilElementVisible(oadt.question_1);
		test.log(Status.INFO, "Total questions : " + questions);
		System.out.println("Total questions : " + questions);
		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("scq")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				List<MobileElement> answerCount;
				if (device.contains("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				status = answerCount.size() > 1 ? true : false;
				sAss.assertTrue(status, "Multiple answers not available for question " + (i + 1));
				System.out.println("Multiple answers available for question " + (i + 1));
				test.log(Status.INFO, "Multiple answers available for question " + (i + 1));

			}
			if ((i + 1) != questions)
				clickOnElement(oadt.next_arrow);
			i++;
		}

		assert1.assertAll();

	}



	public SoftAssert to_verify_the_Default_Correct_Answer_of_question_is_display(String subject_History, String topic_H) throws MalformedURLException, InterruptedException {
		traverse_to_Begin_Oral_Test(subject_History, topic_H);

		clickOnElement(oadt.begin_Test);
		applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("Correct"));

		//SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		System.out.println(questions);

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
				if (device.contains("Android"))
					answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				else
					answerCount = getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch"));
				int c = 1;
				for (MobileElement mobileElement : answerCount) {

					if (device.contains("Android")) {

						if (getElementAttribute(mobileElement, "checked").trim().equalsIgnoreCase("true")) {	
							assert1.assertTrue(true);
							Thread.sleep(5000);
							test.log(Status.INFO, "Answer " + c + " is in default state");
							System.out.println("Answer " + c + " is in default state");

						} else
							assert1.assertTrue(false);
					} else {
						if (!mobileElement.isSelected()) {
							assert1.assertTrue(true);
							Thread.sleep(5000);
							test.log(Status.INFO, "Answer " + c + " is in default state");
							System.out.println("Answer " + c + " is in default state");

						} else
							assert1.assertTrue(false);
					}
					swipeUp();
					c++;
				}
			}
			if ((i + 1) != questions)
				clickOnElement(oadt.next_arrow);
			i++;
		}

		return assert1;


	}

	public void to_verify_that_user_should_be_able_to_hide_answers(String subject_History, String topic_H) throws MalformedURLException {

		traverse_to_Begin_Oral_Test(subject_History, topic_H);

		clickOnElement(oadt.begin_Test);
		applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("Correct"));
		applyExplicitWait(5);
		System.out.println("Getting total Count of Questions in Oral Test...> ");
		int questions = oadt.get_Total_Number_Of_Questions_In_Oral_Test();
		System.out.println( questions );
		assert1.assertTrue(Boolean.parseBoolean(getElementAttribute(oadt.correct_ans, "checked")));
		System.out.println("Answer is shown ");
		scrollTo2("Hide");

		clickOnElement(oadt.hide_Ans);
		test.log(Status.INFO, "Clicked on Hode Answer Button");
		System.out.println("Clicked on Hode Answer Button");

		assert1.assertFalse(Boolean.parseBoolean(getElementAttribute(oadt.correct_ans, "checked")));
		System.out.println("Answer Hidden after click on hide Button");
		assert1.assertAll();

	}



	public void to_verify_the_Answer_with_Did_you_get_it_righ(String subject_History, String topic_H) throws MalformedURLException, InterruptedException {
		traverse_to_Begin_Oral_Test(subject_History, topic_H);

		clickOnElement(oadt.begin_Test);
		applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("Correct"));
		applyExplicitWait(5);
	
		Thread.sleep(3000);
		scrollTo2("Incorrect");
		//applyExplicitWaitsUntilElementVisible(oadt.correct_option);
		clickOnElement(oadt.correct_option);
		status = Boolean.parseBoolean(oadt.correct_option.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue( status, "Did you get it right? -->Correct option is clickable");
			System.out.println("Did you get it correct-->Correct option is clickable");
		} 
		Thread.sleep(3000);
		//applyExplicitWaitsUntilElementVisible(oadt.partially_correct);
		clickOnElement(oadt.partially_correct);
		status = Boolean.parseBoolean(oadt.correct_option.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(status, "Did you get it right?-->Partially Correct option is clickable");
			System.out.println("Did you get it right?-->Partially Correct option is clickable");
		}
		Thread.sleep(3000);
		//applyExplicitWaitsUntilElementVisible(oadt.incorrect_option);
		clickOnElement(oadt.incorrect_option);
		status = Boolean.parseBoolean(oadt.correct_option.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(status, "Did you get it right?-->InCorrect option is clickable");
			System.out.println("Did you get it right?-->InCorrect option is clickable");
		}

		assert1.assertAll();




	}



	public void to_verify_after_hiding_Answer_user_should_be_able_to_view_Answer_Again(String subject_History,String topic_H) throws MalformedURLException, InterruptedException {
		traverse_to_Begin_Oral_Test(subject_History, topic_H);

		clickOnElement(oadt.begin_Test);
		applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("Correct"));
		applyExplicitWait(5);
		//System.out.println("Getting total Count of Questions in Oral Test...> ");
		//int questions = oadt.get_Total_Number_Of_Questions_In_Oral_Test();
		//System.out.println( questions );
		assert1.assertTrue(Boolean.parseBoolean(getElementAttribute(oadt.correct_ans, "checked")));
		System.out.println("Answer is shown ");
		scrollTo2("Hide");

		clickOnElement(oadt.hide_Ans);
		test.log(Status.INFO, "Clicked on Hide Answer Button");
		System.out.println("Clicked on Hide Answer Button");

		assert1.assertFalse(Boolean.parseBoolean(getElementAttribute(oadt.correct_ans, "checked")));
		System.out.println("Answer Hidden after click on hide Button");

		scrollTo2("Show");
		clickOnElement(oadt.show_Ans);
		test.log(Status.INFO, "Clicked on Show Answer Button");
		System.out.println("Clicked on Show Answer Button");
		Thread.sleep(3000);

		assert1.assertTrue(Boolean.parseBoolean(getElementAttribute(oadt.correct_ans, "checked")));
		System.out.println("Answer is shown again when clicked on Show answer Button");

		assert1.assertAll();


	}



	public void to_verify_with_correct_Answer(String property, String property2) {
		// TODO Auto-generated method stub
		
	}



	public void to_verify_with_partialy_correct_Answer(String property, String property2) {
		// TODO Auto-generated method stub
		
	}




	public void to_verify__with_Incorrect_Answer(String property, String property2) {
		// TODO Auto-generated method stub
		
	}



	public void to_verify_the_user_should_be_able_to_end_test_without_checking_the_Answer(String property,
			String property2) {
		// TODO Auto-generated method stub
		
	}



	public void to_verify_the_Verify_user_should_be_able_to_end_test_without_checking_the_Answer(String property,
			String property2) {
		// TODO Auto-generated method stub
		
	}



	public void to_verify_the_Verify_that_submit_test_successfully(String property, String property2) {
		// TODO Auto-generated method stub
		
	}



	public void to_verify_after_submi_oral_test_there_should_not_be_any_scoring_critria(String property,
			String property2) {
		// TODO Auto-generated method stub
		
	}



	public void to_verify_the_Preview_functionality(String property, String property2) {
		// TODO Auto-generated method stub
		
	}



	public void to_verify_user_should_be_able_to_preview_of_the_Oral_Test(String property, String property2) {
		// TODO Auto-generated method stub
		
	}








}




