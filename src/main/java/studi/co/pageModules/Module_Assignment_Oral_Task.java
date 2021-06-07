package studi.co.pageModules;

import java.net.MalformedURLException;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Assignment_Oral_Task;

public class Module_Assignment_Oral_Task extends BaseClass{
	Object_Assignment_Oral_Task oadt = new Object_Assignment_Oral_Task();
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


	public void to_verify_that_user_should_be_able_to_add_the_Content_even_if_striked_off_for_creating_oral_test(String subject, String topic1) throws MalformedURLException {
		test.log(Status.INFO,"Creating the oral test for striked off topic: Geography-The Universe " );
		System.out.println("Creating the oral test for striked off topic: Geography-The Universe ");
		traverse_to_Begin_Oral_Test(subject, topic1);

		Boolean begin_Test = oadt.begin_Test.isDisplayed();
		assert1.assertTrue(begin_Test);
		if (begin_Test) {
			System.out.println("Begin Oral Test shown");
			test.log(Status.INFO, "Begin Oral Test shown");
		}
		assert1.assertTrue(begin_Test);
		assert1.assertAll();
	}


	public void to_verify_that_user_is_able_to_select_the_chapters_from_subject(String subject, String topic1) throws MalformedURLException {
		traverse_to_Begin_Oral_Test(subject, topic1);
		Boolean begin_Test = oadt.begin_Test.isDisplayed();
		assert1.assertTrue(begin_Test);
		if (begin_Test) {
			System.out.println("Begin Oral Test shown");
			test.log(Status.INFO, "Begin Oral Test shown");
		}
		assert1.assertTrue(begin_Test);
		assert1.assertAll();



	}

	public void to_verify_that_user_is_able_to_select_the_topics_from_subject() throws MalformedURLException {
		
		
		
	}

	public void traverse_to_Begin_Oral_Test (String subject, String topic1) throws MalformedURLException {

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

		scrollTo1(topic1);
		test.log(Status.INFO, "Selecting " + topic1);
		System.out.println("Selecting " + topic1);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic1));
		clickOnElement(findElementByText(topic1));
		applyExplicitWait(5);
		test.log(Status.INFO, "Clicking on Start Oral Test " );
		System.out.println("Clicking on Start Oral Test ");
		swipeUp();
		clickOnElement(oadt.start_Test);
		applyExplicitWait(5);
		test.log(Status.INFO, "Oral Test successfully Created");
		System.out.println("Oral Test successfully Created");


	}
}

