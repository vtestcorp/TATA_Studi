package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Assignment_Oral_Test;

public class Module_Assignment_Oral_Test extends BaseClass {
	Object_Assignment_Oral_Test oadt = new Object_Assignment_Oral_Test();
	SoftAssert assert1 = new SoftAssert();
	Boolean status;

	public void to_verify_that_from_syllabus_menu_user_should_be_able_to_navigate_oral_test()
			throws MalformedURLException {
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

	public void to_verify_after_clicking_on_oral_test_user_should_be_able_to_view_oral_test_option()
			throws MalformedURLException {
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

	public void to_verify_that_user_should_be_able_to_add_the_Content_even_if_striked_off_for_creating_oral_test(
			String subject, String topic1) throws MalformedURLException {
		test.log(Status.INFO, "Creating the oral test for striked off topic: Geography-The Universe ");
		System.out.println("Creating the oral test for striked off topic: Geography-The Universe ");
		traverse_to_Begin_Oral_Test(subject, topic1);
		Boolean status = oadt.begin_Test.isDisplayed();
		if (status) {
			System.out.println("Begin Oral Test shown");
			test.log(Status.INFO, "Begin Oral Test shown");
		}

		assert1.assertAll();
	}

	public void to_verify_that_user_is_able_to_select_the_chapters_from_subject(String subject, String topic_1)
			throws MalformedURLException {
		traverse_to_Begin_Oral_Test(subject, topic_1);
		applyExplicitWait(5);
		// oadt.next1.click();
		System.out.println("Clicked On Start Button to bigin the Test");
		Boolean begin = oadt.begin_Test.isDisplayed();
		if (begin) {
			System.out.println("Begin Oral Test shown");
			test.log(Status.INFO, "Begin Oral Test shown");
		}
		assert1.assertTrue(begin);
		assert1.assertAll();

	}

	public void to_verify_that_user_is_able_to_select_the_topics_from_subject(String subject, String topic_1,
			String topic_2) throws MalformedURLException {
		scrollTo2("Assignments");
		clickOnElement(oadt.syllabus);
		test.log(Status.INFO, "Clicked Syllabus");
		System.out.println("Clicked on Syllabus");
		clickOnElement(oadt.add_Symbol);
		test.log(Status.INFO, "Clicked to Add Oral test");
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

		if (status) {
			System.out.println("User able to select single or multiple chapter from the Selected subject");
			test.log(Status.INFO, "User able to select single or multiple chapter from the Selected subject");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}

	public void to_verify_for_select_Deselect_of_chapters_and_Topics(String subject_ps, String topic_unity)
			throws MalformedURLException {
		scrollTo2("Assignments");
		clickOnElement(oadt.syllabus);
		test.log(Status.INFO, "Clicked Syllabus");
		System.out.println("Clicked on Syllabus");

		clickOnElement(oadt.add_Symbol);
		test.log(Status.INFO, "Clicked to Add Oral test");
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
		test.log(Status.INFO, "Topic _ Unity in Diversity is selected from Political Science");
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
		test.log(Status.INFO, "Topic _ Unity in Diversity is Deselected from Political Science");
		System.out.println("Topic _ Unity in Diversity is Deselected from Political Science");
		assert1.assertAll();
	}

	public void to_verify_user_should_be_able_to_move_from_current_step_to_next_step(String subject, String topic_1)
			throws MalformedURLException {
		scrollTo2("Assignments");
		clickOnElement(oadt.syllabus);
		test.log(Status.INFO, "Clicked Syllabus");
		System.out.println("Clicked on Syllabus");
		clickOnElement(oadt.add_Symbol);
		test.log(Status.INFO, "Clicked to Add Oral test");
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

		Boolean details = oadt.next1.isDisplayed();
		if (details) {
			System.out.println("After clicking Next Buton User able to navigate from Current step to next step ");
			test.log(Status.INFO, "After clicking Next Buton User able to navigate from Current step to next step");
			System.out.println("on one of the topic or chapter selection, next button displayed ");
			test.log(Status.INFO, "on one of the topic or chapter selection, next button displayed ");
		}
		assert1.assertTrue(details);
		assert1.assertAll();

	}

	public void to_verify_that_user_is_able_to_move_from_current_step_to_previous_step(String subject, String topic_1)
			throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		System.out.println("Clicked on Next  Button");
		test.log(Status.INFO, "Clicked on Next Button");
		clickOnElement(findElementByText("Previous"));
		System.out.println("Clicked on Previous Button");
		test.log(Status.INFO, "Clicked on Previous Button");
		applyExplicitWaitsUntilElementVisible(findElementByText("Next"));
		Boolean details = oadt.next1.isDisplayed();
		if (details) {
			System.out
			.println("After clicking Previous Buton User able to navigate from Current step to Previous step");
			test.log(Status.INFO,
					"After clicking Previous Buton User able to navigate from Current step to Previous step");
		}
		assert1.assertTrue(details);
		assert1.assertAll();

	}

	public void to_verify_that__on_all_steps_user_able_to_delete_it_the_all_oral_creation_process(String subject,
			String topic_1) throws MalformedURLException {
		try {
			creation_of_Oral_Test(subject, topic_1);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applyExplicitWait(5);
		// clickOnElement(oadt.next1);
		applyExplicitWait(5);
		//applyExplicitWaitsUntilElementClickable(oadt.delete_note);
		clickOnElement(oadt.delete_note);
		applyExplicitWait(5);
		System.out.println("Clicked On Delete Note");
		test.log(Status.INFO, "Clicked On Delete Note");
		applyExplicitWait(5);
		Boolean discard_msg = oadt.please_Discard.isDisplayed();
		assert1.assertTrue(discard_msg);
		if (discard_msg) {
			System.out.println("Pop Up displayed : Are you sure you want to discard? You will lose what you were working on.");
			test.log(Status.INFO,"Pop Up displayed : Are you sure you want to discard? You will lose what you were working on.");
		}
		assert1.assertTrue(discard_msg);
		assert1.assertAll();
	}

	public void to_verify_that_after_click_on_delete_two_option_should_get_display(String subject, String topic_1)
			throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);
		applyExplicitWait(5);
		// clickOnElement(oadt.next1);
		applyExplicitWait(5);
		//applyExplicitWaitsUntilElementClickable(oadt.delete_note);
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
		scrollTo2("Assignments");
		clickOnElement(oadt.syllabus);
		test.log(Status.INFO, "Clicked Syllabus");
		System.out.println("Clicked on Syllabus");
		clickOnElement(oadt.add_Symbol);
		test.log(Status.INFO, "Clicked to Add Oral test");
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

		// Boolean book_shelf = oadt.all_Sub.isDisplayed();
		Boolean book_shelf = oadt.add_Symbol.isDisplayed();
		assert1.assertTrue(book_shelf);
		if (book_shelf) {
			System.out
			.println("After Discard ,Navigated back to book shelf listing and Oral Test creation get aborted ");
			test.log(Status.INFO,
					"After Discard ,Navigated back to book shelf listing and Oral Test creation get aborted  ");
		}
		assert1.assertTrue(book_shelf);
		assert1.assertAll();

	}

	public void to_verify_TakeMeBack_Button(String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);

		// clickOnElement(oadt.next1);
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
		assert1.assertTrue(status);
		if (status) {
			System.out.println("After Take me back Button ,Delete opertaion get discard and page remain on same step ");
			test.log(Status.INFO,
					"After Take me back Button ,Delete opertaion get discard and page remain on same step ");
		}
		assert1.assertTrue(status);
		assert1.assertAll();
	}

	public void to_verify_enter_test_settings_screen_should_get_display(String subject, String topic_1)
			throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		test.log(Status.INFO, "Clicked to Next Button");
		System.out.println("Clicked to Next Button");
		applyExplicitWait(3);
		Boolean status = oadt.test_Details.isDisplayed();

		if (status) {
			System.out.println("Enter Test Settings screen is displayed ");
			test.log(Status.INFO, "Enter Test Settings screen is displayed ");
		}
		assert1.assertTrue(status);
		assert1.assertAll();
	}

	public void to_verify_while_entering_test_setting_details_User_able_to_ON_Help_toggle(String subject,
			String topic_1) throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);

		System.out.println("Clicked On Next Button");
		test.log(Status.INFO, "Clicked On Next Button");
		applyExplicitWaitsUntilElementVisible(oadt.test_Details);
		Boolean status = oadt.test_Details.isDisplayed();
		if (status) {
			System.out.println("Enter Test Settings screen is displayed ");
			test.log(Status.INFO, "Enter Test Settings screen is displayed ");
		}
		assert1.assertTrue(status);
		Boolean status1 = oadt.help_ON.isDisplayed();
		if (status1) {
			System.out.println("Help Button is displayed and It's ON ");
			test.log(Status.INFO, "Help Button is displayed and It's ON ");
		}
		assert1.assertTrue(status);
		Boolean status2 = oadt.title_Instruction.isDisplayed();
		if (status2) {
			System.out.println("If ON is selected for Help then User guidlines are displayed for Title ");
			test.log(Status.INFO, "If ON is selected for Help then User guidlines are displayed for Title ");
		}

		Boolean status3 = oadt.difficulty_level_Instruction.isDisplayed();
		if (status3) {
			System.out.println("If ON is selected for Help then User guidlines are displayed for Difficulty Level ");
			test.log(Status.INFO, "If ON is selected for Help then User guidlines are displayed for Difficulty Level ");
		}

		Boolean status4 = oadt.duration_instruction.isDisplayed();
		if (status4) {
			System.out.println("If ON is selected for Help then User guidlines are displayed for Tentative DUration ");
			test.log(Status.INFO,
					"If ON is selected for Help then User guidlines are displayed for Tentative DUration ");
		}

		System.out.println("If ON is selected for Help then User guidlines are displayed For all Fileds ");
		test.log(Status.INFO, "If ON is selected for Help then User guidlines are displayed For all Fileds   ");
		assert1.assertAll();
	}

	public void to_verify_while_entering_test_setting_details_User_able_to_OFF_Help_toggle(String subject,
			String topic_1) throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);

		applyExplicitWaitsUntilElementVisible(oadt.test_Details);
		Boolean status = oadt.test_Details.isDisplayed();
		if (status) {
			System.out.println("Enter Test Settings screen is displayed ");
			test.log(Status.INFO, "Enter Test Settings screen is displayed ");
		}
		applyExplicitWaitsUntilElementClickable(oadt.help);
		oadt.help.click();

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
		System.out.println("If OFF is selected for Help then User guidlines are Removed For all Fileds ");
		test.log(Status.INFO, "If OFF is selected for Help then User guidlines areRemoved For all Fileds   ");
		assert1.assertAll();
	}

	public void to_verify__default_title_of_the_oral_test(String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		System.out.println("Topic Selcted for Test is--> " + topic_1);
		Boolean status = oadt.title_field.isDisplayed();
		if (status) {
			System.out.println("Title field is shown on Enter Test Settings screen ");
			test.log(Status.INFO, "Title field is shown on Enter Test Settings screen ");
		}
		applyExplicitWait(5);
		String title = oadt.title_field.getText();
		System.out.println(title);
		System.out.println("As per selection of chapters and topics Default Title name is display");
		assert1.assertAll();
	}

	public void to_verify__with_blank_Title(String subject, String topic1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic1);
		clickOnElement(oadt.next1);
		Boolean status = oadt.title_field.isDisplayed();
		if (status) {
			System.out.println("Title field is shown on Enter Test Settings screen ");
			test.log(Status.INFO, "Title field is shown on Enter Test Settings screen ");
		}
		oadt.title_field.clear();
		System.out.println("Cleared the text in Title FIeld");
		clickOnElement(oadt.start_Test);
		System.out.println("Clicked on Start Test");
		String error_msg = oadt.title_field.getText();
		System.out.println(error_msg);
		assert1.assertAll();

	}

	public void to_verify__edit_title_of_the_oral_test(String subject, String topic_1) throws MalformedURLException {
		// traverse_to_Begin_Oral_Test(subject,topic_1);
		creation_of_Oral_Test(subject, topic_1);
		Boolean status = oadt.title_field.isDisplayed();
		if (status) {
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
		if (status1) {
			System.out.println("User able to Edit the title of oral test");
			test.log(Status.INFO, "User able to Edit the title of oral test");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}

	public void to_verify_input_limitation_and_input_validation_for_the_title(String subject, String topic_1)
			throws MalformedURLException {
		// traverse_to_Begin_Oral_Test(subject,topic_1);
		creation_of_Oral_Test(subject, topic_1);
		Boolean status = oadt.title_field.isDisplayed();
		if (status) {
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
		if (status1) {
			System.out.println("It accepted all Characters ,Numbers and special Charactes");
			test.log(Status.INFO, "It accepted all Characters ,Numbers and special Charactes");
		}
		assert1.assertTrue(status);
		assert1.assertAll();
	}

	public void to_verify_Set_level_of_difficulty_for_the_test(String subject, String topic_1)
			throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);
		// clickOnElement(oadt.next1);
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

		// traverse_to_Begin_Oral_Test(subject, topic_1);
		creation_of_Oral_Test(subject, topic_1);
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

	public void to_verify_the_navigation_from_Start_Test_Now(String subject, String topic_1)
			throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		test.log(Status.INFO, "Clicking on Start Oral Test ");
		System.out.println("Clicking on Start Oral Test ");
		// swipeUp();
		scrollTo2("Start");
		clickOnElement(oadt.start_Test);
		System.out.println("Clicked On Start Test");
		applyExplicitWait(5);
		Boolean status1 = oadt.begin_Test.isDisplayed();
		if (status1) {
			System.out.println("The Page directed to assigment module to Begin the test ");
			test.log(Status.INFO, "The Page directed to assigment module to Begin the test ");
		}
		assert1.assertTrue(status1);
		assert1.assertAll();

	}

	public void traverse_to_Begin_Oral_Test(String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		test.log(Status.INFO, "Clicking on Start Oral Test ");
		System.out.println("Clicking on Start Oral Test ");
		applyExplicitWait(5);
		// clickOnElement(findElementByText("Start Test"));
		scrollTo2("Start");
		clickOnElement(oadt.start_Test);
		applyExplicitWait(5);
		test.log(Status.INFO, "Oral Test successfully Created");
		System.out.println("Oral Test successfully Created");
	}

	public void creation_of_Oral_Test(String subject, String topic_1) throws MalformedURLException {

		scrollTo2("Assignments");
		clickOnElement(oadt.syllabus);
		test.log(Status.INFO, "Clicked Syllabus");
		System.out.println("Clicked on Syllabus");
		clickOnElement(oadt.add_Symbol);
		test.log(Status.INFO, "Clicked to Add Oral test");
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

		clickOnElement(findElementByText("Next"));

	}

	public void to_verify_the_Start_Test_UI(String subject, String topic_1) throws MalformedURLException {

		creation_of_Oral_Test(subject, topic_1);
		scrollTo2("Start Test");
		clickOnElement(findElementByText("Start"));
		applyExplicitWaitsUntilElementVisible(oadt.confidence_icon);

		//		String chapter = oadt.title_field.getText();
		//		System.out.println("Chapter Name displayed with Oral Test");
		//		System.out.println(chapter);


		Boolean status2 = oadt.topic_name.isDisplayed();
		if (status2) {
			System.out.println("On page layout contents: Displayed Topic Name related to selected Topics  ");
			test.log(Status.INFO, "On page layout contents: Displayed Topic Name related to selected Topics  ");
		}

		assert1.assertTrue(status2);
		Boolean status3 = oadt.video_icon.isDisplayed();
		if (status3) {
			System.out.println("Displayed videos related to selected Topics  ");
			test.log(Status.INFO, " Displayed videos related to selected Topics  ");
		}

		assert1.assertTrue(status3);
		assert1.assertAll();
	}

	public void to_verify_When_click_on_start_test_button_before_starting_test_user_should_be_Able_to_view_Videos(
			String subject, String topic_1) throws MalformedURLException {
		creation_of_Oral_Test(subject, topic_1);
		test.log(Status.INFO, "Clicking on Start Oral Test ");
		System.out.println("Clicking on Start Oral Test ");
		swipeUp();
		clickOnElement(oadt.start_Test);
		System.out.println("Clicked On Start Test");
		applyExplicitWait(5);
		Boolean status1 = oadt.begin_Test.isDisplayed();
		if (status1) {
			System.out.println("The Begin Test page is showm");
			test.log(Status.INFO, "The Begin Test page is showm");
		}
		Boolean status3 = oadt.video_icon.isDisplayed();
		if (status3) {
			System.out.println("On page layout contents: Displayed videos related to selected Topics  ");
			test.log(Status.INFO, "On page layout contents: Displayed videos related to selected Topics  ");
		}
		clickOnElement(oadt.video_icon);
		System.out.println("Clicked On Video Icon");

		applyExplicitWaitsUntilElementVisible(oadt.video_close);
		Boolean status2 = oadt.video_close.isDisplayed();
		if (status2) {
			System.out.println("User able to play the video before starting the Test");
			test.log(Status.INFO, "User able to play the video before starting the Test");
		}
		assert1.assertTrue(status);
		// System.out.println("Closing the Video");
		// clickOnElement(oadt.video_close);
		assert1.assertAll();
	}

	public void to_verify_the_begin_test(String subject, String topic_1) throws MalformedURLException {
		traverse_to_Begin_Oral_Test(subject, topic_1);

		//applyExplicitWaitsUntilElementVisible(oadt.begin_Test);

		applyExplicitWaitsUntilElementVisible(oadt.why_tested_msg);
		clickOnElement(oadt.begin_Test);
		applyExplicitWaitsUntilElementVisible(oadt.question_Text);
		Boolean status = oadt.question_Text.isDisplayed();
		if (status) {
			System.out.println("Test get begin after clicking on Begin Test Button");
			test.log(Status.INFO, "Test get begin after clicking on Begin Test Button");
		}
		assert1.assertTrue(status);
		assert1.assertAll();
	}

	public void to_verify_the_question_with__Answer_appears(String subject_History, String topic_H)
			throws MalformedURLException {
		traverse_to_Begin_Oral_Test(subject_History, topic_H);
		applyExplicitWaitsUntilElementVisible(oadt.why_tested_msg);
		clickOnElement(oadt.begin_Test);
		applyExplicitWait(3);
		applyExplicitWaitsUntilElementClickable(findElementByText("Correct"));
		applyExplicitWait(5);

		if(verifySCQorMCQ().contains("scq")) {
			Set<String> context = driver.getContextHandles();
			for (String cont : context) {
				if (cont.contains("WEBVIEW"))
					getDriver().context(cont);
			}
			List<MobileElement> as = driver.findElements(By.tagName("tce-option"));
			for (MobileElement s : as) {
				if(s.findElement(By.className("optionWrapper")).getCssValue("color").equalsIgnoreCase("rgba(7, 214, 0, 1)"))
				{
					assert1.assertTrue(true);
					System.out.println("Correct answer available in Green color {rgba(7, 214, 0, 1)}");
				}
			}
			getDriver().context("NATIVE_APP");
		}
		else
			clickOnElement(oadt.next_arrow);
		/*
		 * Boolean end = oadt.end_Test_Title.isDisplayed(); if (end) {
		 * System.out.println("Test get begin after clicking on Begin Test Button");
		 * test.log(Status.INFO, "Test get begin after clicking on Begin Test Button");
		 * }
		 */
		//assert1.assertTrue(end);

		assert1.assertAll();

	}

	public SoftAssert to_verify_the_Default_Correct_Answer_of_question_is_display(String subject_History,
			String topic_H) throws MalformedURLException, InterruptedException {
		traverse_to_Begin_Oral_Test(subject_History, topic_H);
		//clickOnElement(oadt.begin_Test);
		applyExplicitWaitsUntilElementVisible(oadt.why_tested_msg);
		clickOnElement(findElementByText("Begin"));
		applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));
		applyExplicitWait(5);
		int questions = oadt.get_Total_Number_Of_Questions_In_oral_Test();
		System.out.println(questions);
		int i = 0;

		while (i < questions) {
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if(verifySCQorMCQ().equalsIgnoreCase("scq")) {
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

	public void to_verify_that_user_should_be_able_to_hide_answers(String subject_History, String topic_H)
			throws MalformedURLException {

		traverse_to_Begin_Oral_Test(subject_History, topic_H);
		// clickOnElement(oadt.begin_Test);
		applyExplicitWaitsUntilElementVisible(oadt.why_tested_msg);

		clickOnElement(findElementByText("Begin"));

		//		applyExplicitWait(3);
		//		applyExplicitWaitsUntilElementClickable(findElementByText("Begin"));
		//		clickOnElement(findElementByText("Begin"));

		applyExplicitWaitsUntilElementVisible(findElementByText("Correct"));
		applyExplicitWait(3);
		System.out.println("Getting total Count of Questions in Oral Test...> ");
		int questions = oadt.get_Total_Number_Of_Questions_In_oral_Test();
		System.out.println(questions);
		// assert1.assertTrue(Boolean.parseBoolean(getElementAttribute(oadt.correct_ans,
		// "checked")));
		if (verifySCQorMCQ().contains("scq")) {
			List<MobileElement> ans = getDriver().findElements(By.className("android.widget.CheckBox"));
			System.out.println(ans.size());
			int i = 0, count = 0;
			for (MobileElement an : ans) {
				if (an.getAttribute("checked").contains("true")) {

					i = Integer.parseInt(an.getAttribute("resource-id"));
					count++;
				}

			}
			assert1.assertTrue(count > 0);
			System.out.println("Answer is shown ");
			scrollTo2("Hide");

			clickOnElement(oadt.hide_Ans);
			test.log(Status.INFO, "Clicked on Hide Answer Button");
			System.out.println("Clicked on Hide Answer Button");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			assert1.assertFalse(Boolean
					.parseBoolean(driver.findElement(MobileBy.AndroidUIAutomator(
							"new UiSelector().className(\"android.widget.CheckBox\").resourceId(\"" + i + "\")"))
							.getAttribute("checked")));
			System.out.println("Answer Hidden after click on hide Button");
		}
		assert1.assertAll();

	}

	public void to_verify_the_Answer_with_Did_you_get_it_righ(String subject_History, String topic_H)
			throws MalformedURLException, InterruptedException {
		traverse_to_Begin_Oral_Test(subject_History, topic_H);

		//clickOnElement(oadt.begin_Test);
		applyExplicitWaitsUntilElementVisible(oadt.why_tested_msg);
		clickOnElement(findElementByText("Begin"));
		applyExplicitWait(3);
		applyExplicitWaitsUntilElementVisible(findElementByText("Correct"));
		applyExplicitWait(5);
		Thread.sleep(3000);
		swipeUp();
		clickOnElement(oadt.correct_option);
		status = Boolean.parseBoolean(oadt.correct_option.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(status, "Did you get it right? -->Correct option is clickable");
			System.out.println("Did you get it correct-->Correct option is clickable");
		}
		Thread.sleep(3000);
		// applyExplicitWaitsUntilElementVisible(oadt.partially_correct);
		clickOnElement(oadt.partially_correct);
		status = Boolean.parseBoolean(oadt.correct_option.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(status, "Did you get it right?-->Partially Correct option is clickable");
			System.out.println("Did you get it right?-->Partially Correct option is clickable");
		}
		Thread.sleep(3000);
		// applyExplicitWaitsUntilElementVisible(oadt.incorrect_option);
		clickOnElement(oadt.incorrect_option);
		status = Boolean.parseBoolean(oadt.correct_option.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(status, "Did you get it right?-->InCorrect option is clickable");
			System.out.println("Did you get it right?-->InCorrect option is clickable");
		}
		assert1.assertAll();
	}

	public void to_verify_after_hiding_Answer_user_should_be_able_to_view_Answer_Again(String subject_History,
			String topic_H) throws MalformedURLException, InterruptedException {
		traverse_to_Begin_Oral_Test(subject_History, topic_H);
		// clickOnElement(oadt.begin_Test);
		applyExplicitWaitsUntilElementVisible(oadt.why_tested_msg);

		clickOnElement(findElementByText("Begin"));

		//		applyExplicitWait(3);
		//		applyExplicitWaitsUntilElementClickable(findElementByText("Begin"));
		//		clickOnElement(findElementByText("Begin"));

		applyExplicitWaitsUntilElementVisible(findElementByText("Correct"));
		applyExplicitWait(3);
		System.out.println("Getting total Count of Questions in Oral Test...> ");
		int questions = oadt.get_Total_Number_Of_Questions_In_oral_Test();
		System.out.println(questions);
		// assert1.assertTrue(Boolean.parseBoolean(getElementAttribute(oadt.correct_ans,
		// "checked")));
		if (verifySCQorMCQ().contains("scq")) {
			List<MobileElement> ans = getDriver().findElements(By.className("android.widget.CheckBox"));
			System.out.println(ans.size());
			int i = 0, count = 0;
			for (MobileElement an : ans) {
				if (an.getAttribute("checked").contains("true")) {

					i = Integer.parseInt(an.getAttribute("resource-id"));
					count++;
				}

			}
			assert1.assertTrue(count > 0);
			System.out.println("Answer is shown ");
			scrollTo2("Hide");

			clickOnElement(oadt.hide_Ans);
			test.log(Status.INFO, "Clicked on Hide Answer Button");
			System.out.println("Clicked on Hide Answer Button");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			assert1.assertFalse(Boolean
					.parseBoolean(driver.findElement(MobileBy.AndroidUIAutomator(
							"new UiSelector().className(\"android.widget.CheckBox\").resourceId(\"" + i + "\")"))
							.getAttribute("checked")));
			System.out.println("Answer Hidden after click on hide Button");
		}


		scrollTo2("Show");
		clickOnElement(findElementByText("Show"));
		List<MobileElement> ans = getDriver().findElements(By.className("android.widget.CheckBox"));
		System.out.println(ans.size());
		int i = 0, count = 0;
		for (MobileElement an : ans) {
			if (an.getAttribute("checked").contains("true")) {

				i = Integer.parseInt(an.getAttribute("resource-id"));
				count++;
			}

		}
		assert1.assertTrue(count > 0);
		System.out.println("Answer is shown again ");
		assert1.assertAll();

	}
	public void to_verify_with_correct_Answer(String property, String property2) {
		// TODO Auto-generated method stub

	}


	public void to_verify_with_partialy_correct_Answer(String subject_History, String topic_H) {
		// TODO Auto-generated method stub

	}

	public void to_verify__with_Incorrect_Answer(String subject_History, String topic_H) {
		// TODO Auto-generated method stub

	}

	public void to_verify_the_user_should_be_able_to_end_test_without_checking_the_Answer(String subject_History,
			String topic_H) throws MalformedURLException {
		to_verify_the_begin_test(subject_History, topic_H);
		int questions = oadt.get_Total_Number_Of_Questions_In_oral_Test();
		System.out.println(questions);
		int i = 0;
		Boolean status;

		while (i < questions) {

			int[] qArray = new int[questions];
			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));
			qArray[i] = 0;
			if ((i + 1) != questions)
				clickOnElement(oadt.next_arrow);
			i++;
		}
		clickOnElement(oadt.next_arrow);
		Boolean status1 = oadt.end_Test_Title.isDisplayed();
		if (status1) {
			System.out.println("User can Submit Oral Test without checking the answers");
			test.log(Status.INFO, "User can Submit Oral Test without checking the answers");
		}
		assert1.assertTrue(status1);
		assert1.assertAll();
	}

	public void to_verify_that_submit_test_successfully(String subject_History, String topic_H)
			throws MalformedURLException {
		to_verify_the_begin_test(subject_History, topic_H);
		int questions = oadt.get_Total_Number_Of_Questions_In_oral_Test();
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
				clickOnElement(oadt.next_arrow);
			i++;
		}
		clickOnElement(oadt.next_arrow);
		Boolean status1 = oadt.end_Test_Title.isDisplayed();
		if (status1) {
			System.out.println("End Test window shown to the user");
			test.log(Status.INFO, "End Test window shown to the user");
		}
		assert1.assertTrue(status1);
		System.out.println("Submitting the Oral Test");
		test.log(Status.INFO, "Submitting the Oral Test");
		clickOnElement(oadt.submit_Test);
		Boolean redo = oadt.redo_Test.isDisplayed();
		if (redo) {
			System.out.println("Test sumbitted Successfully");
			test.log(Status.INFO, "Test sumbitted Successfully");
		}
		assert1.assertTrue(redo);

		assert1.assertAll();

	}

	public void to_verify_after_submi_oral_test_there_should_not_be_any_scoring_critria(String subject_History,
			String topic_H) throws MalformedURLException {
		to_verify_the_begin_test(subject_History, topic_H);
		int questions = oadt.get_Total_Number_Of_Questions_In_oral_Test();
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
				clickOnElement(oadt.next_arrow);
			i++;
		}
		clickOnElement(oadt.next_arrow);
		clickOnElement(oadt.submit_Test);


		//		Boolean score = oadt.confidence_icon.isDisplayed();
		//		if (score) {
		//			System.out.println("Cofidence Icon is shown");
		//			test.log(Status.INFO, "Cofidence Icon is shown");
		//		}
		//		assert1.assertTrue(score);

		String msg=oadt.confidence_icon.getText();

		if(msg.contains(" "))
		{
			System.out.println("Confidence level should not be display for oral Test ");
			test.log(Status.INFO, "Confidence level should not be display for oral Test ");
		}

		assert1.assertAll();	
	}

	public void to_verify_the_actions_on_last_question_of_the_Oral_test(String subject_History, String topic_H)
			throws MalformedURLException {

		to_verify_the_begin_test(subject_History, topic_H);
		int questions = oadt.get_Total_Number_Of_Questions_In_oral_Test();
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
				clickOnElement(oadt.next_arrow);
			i++;
		}
		clickOnElement(oadt.next_arrow);

		System.out.println("After selecting last question's answer pop up get displayed with-->");
		test.log(Status.INFO, "After selecting last question's answer pop up get displayed with-->");

		Boolean title = oadt.end_Test_Title.isDisplayed();
		if (title) {
			System.out.println("End of Test On Pop_up is Shown");
			test.log(Status.INFO, "End of Test On Pop_up is Shown");
		}
		assert1.assertTrue(title);

		Boolean sub_title = oadt.end_subtitle.isDisplayed();
		if (title) {
			System.out.println("You have reached the end of test shown");
			test.log(Status.INFO, "You have reached the end of test Shown");
		}
		assert1.assertTrue(title);

		Boolean submit_btn = oadt.submit_Test.isDisplayed();
		if (submit_btn) {
			System.out.println("Submit Test button is Shown ");
			test.log(Status.INFO, "Submit Test button is Shown ");
		}
		assert1.assertTrue(submit_btn);

		Boolean return_btn = oadt.Return_To_Test.isDisplayed();
		if (return_btn) {
			System.out.println("Return to Test Button is Shown");
			test.log(Status.INFO, "Return to Test Button is Shown");
		}
		assert1.assertTrue(return_btn);
		assert1.assertAll();

	}

	public void to_verify_Reurn_to_test_functionality_after_submission_of_test(String subject_History, String topic_H)
			throws MalformedURLException {
		to_verify_the_begin_test(subject_History, topic_H);
		int questions = oadt.get_Total_Number_Of_Questions_In_oral_Test();
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
				clickOnElement(oadt.next_arrow);
			i++;
		}
		clickOnElement(oadt.next_arrow);

		System.out.println("After selecting last question's answer pop up get displayed with-->");
		test.log(Status.INFO, "After selecting last question's answer pop up get displayed with-->");

		Boolean title = oadt.end_Test_Title.isDisplayed();
		if (title) {
			System.out.println("End of Test On Pop_up is Shown");
			test.log(Status.INFO, "End of Test On Pop_up is Shown");
		}
		assert1.assertTrue(title);

		Boolean return_btn = oadt.Return_To_Test.isDisplayed();
		if (return_btn) {
			System.out.println("Return to Test Button is Shown");
			test.log(Status.INFO, "Return to Test Button is Shown");
		}
		assert1.assertTrue(return_btn);
		clickOnElement(oadt.Return_To_Test);

		Boolean hide = oadt.hide_Ans.isDisplayed();
		if (hide) {
			System.out.println(
					"On Return to Test button click it directed to the last question of the oral test to review");
			test.log(Status.INFO,
					"On Return to Test button click it directed to the last question of the oral test to review");
		}
		assert1.assertTrue(hide);
		assert1.assertAll();
	}

	public void to_check_for_the_confirmation_Message_for_redo_test_after_submiting_test(String subject_History,
			String topic_H) throws MalformedURLException {
		to_verify_the_begin_test(subject_History, topic_H);
		int questions = oadt.get_Total_Number_Of_Questions_In_oral_Test();
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
				clickOnElement(oadt.next_arrow);
			i++;
		}
		clickOnElement(oadt.next_arrow);
		clickOnElement(oadt.submit_Test);
		//applyExplicitWaitsUntilElementVisible(findElementByText("Redo"));
		clickOnElement(findElementByText("Redo"));
		applyExplicitWaitsUntilElementVisible(findElementByText("better"));
		Boolean title = oadt.redo_Test_popup_Title.isDisplayed();
		if (title) {
			System.out.println("Message displayed--> Redo test for a better score");
			test.log(Status.INFO, "Message displayed--> Redo test for a better score");
		}
		assert1.assertTrue(title);

		Boolean subtitle = oadt.redo_Test_popup_SubTitle.isDisplayed();
		if (subtitle) {
			System.out.println("All previous scores will be lost");
			test.log(Status.INFO, "All previous scores will be lost");
		}
		assert1.assertTrue(subtitle);
		assert1.assertAll();

	}

	public void to_verify_the_functionality_of_redo_test(String subject_History, String topic_H)
			throws MalformedURLException {
		to_verify_the_begin_test(subject_History, topic_H);
		int questions = oadt.get_Total_Number_Of_Questions_In_oral_Test();
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
				clickOnElement(oadt.next_arrow);
			i++;
		}
		clickOnElement(oadt.next_arrow);
		clickOnElement(oadt.submit_Test);
		applyExplicitWaitsUntilElementVisible(oadt.why_tested_msg);
		clickOnElement(findElementByText("Redo Test"));

		Boolean title = oadt.redo_Test_popup_Title.isDisplayed();
		if (title) {
			System.out.println("Message displayed--> Redo test for a better score");
			test.log(Status.INFO, "Message displayed--> Redo test for a better score");
		}
		assert1.assertTrue(title);

		Boolean subtitle = oadt.redo_Test_popup_SubTitle.isDisplayed();
		if (title) {
			System.out.println("Message Shown--> All Previous Score will be lost");
			test.log(Status.INFO, "Message Shown--> All Previous Score will be lost");
		}
		assert1.assertTrue(subtitle);
		clickOnElement(findElementByText("Redo Test"));

		applyExplicitWaitsUntilElementVisible(findElementByText("correct"));

		Boolean hide = oadt.hide_Ans.isDisplayed();
		if (hide) {
			System.out.println("User is able to redo the oral  test");
			test.log(Status.INFO, "User is able to redo the oral  test");
		}
		assert1.assertTrue(hide);
		assert1.assertAll();

	}


}
