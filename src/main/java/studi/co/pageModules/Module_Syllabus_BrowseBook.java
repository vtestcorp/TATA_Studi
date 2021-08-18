package studi.co.pageModules;

import java.net.MalformedURLException;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Syllabus_BrowseBook;

public class Module_Syllabus_BrowseBook extends BaseClass {
	Object_Syllabus_BrowseBook osb = new Object_Syllabus_BrowseBook();
	SoftAssert sAss = new SoftAssert();
	Boolean status;

	public void traverse_To_Topic(String subject, String topic) throws MalformedURLException, InterruptedException {
		applyExplicitWaitsUntilElementVisible(osb.testUnit);

		/*
		 * if (device.contains("Android")) swipeUp(); else
		 */
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

	}

	public void validate_radio_buttons() {

		scrollTo2("Exclude");

		System.out.println("Selecting Exclude from Syllabus switch");
		test.log(Status.INFO, "Selecting Exclude from Syllabus switch");
		clickOnElement(osb.exclude_From_Syllabus_Switch);

		status = Boolean.parseBoolean(osb.completed_In_School_Switch.getAttribute("clickable"));
		if (status) {
			sAss.assertTrue(false, "Both radio buttons can be select at a time");
			System.out.println("Both radio buttons can be select at a time");
		}

		clickOnElement(osb.exclude_From_Syllabus_Switch);

		System.out.println("Selecting Completed in school switch");
		test.log(Status.INFO, "Selecting Completed in school switch");
		clickOnElement(osb.completed_In_School_Switch);

		status = Boolean.parseBoolean(osb.exclude_From_Syllabus_Switch.getAttribute("clickable"));
		if (status) {
			sAss.assertTrue(false, "Both radio buttons can be select at a time");
			System.out.println("Both radio buttons can be select at a time");
		}

		clickOnElement(osb.completed_In_School_Switch);
		sAss.assertAll();
	}

	public void validate_revision_functionality() throws MalformedURLException, InterruptedException {

		scrollTo2("Revis");

		clickOnElement(findElementByText("Revis"));
		Thread.sleep(2000);
		clickOnElement(findElementByText("Revis"));

		status = osb.skip.isDisplayed();
		sAss.assertTrue(status, "Revision not started");
		if (status) {
			System.out.println("User able to revise chapter");
			test.log(Status.INFO, "User able to revise chapter");
		}

	}

	public void validate_practice_functionality() throws InterruptedException {
		scrollTo2("Practice");

		clickOnElement(findElementByText("Practice"));
		Thread.sleep(2000);
		clickOnElement(findElementByText("Practice"));

		status = osb.question.isDisplayed();
		sAss.assertTrue(status, "User is not able to do the practice of the selected chapter");
		if (status) {
			System.out.println("User is able to do the practice of the selected chapter");
			test.log(Status.INFO, "User is able to do the practice of the selected chapter");
		}

	}

	public void validate_revision_excludeFromSyllabus_functionality() throws InterruptedException {
		scrollTo2("Exclude");
		System.out.println("Selecting Exclude from Syllabus switch");
		test.log(Status.INFO, "Selecting Exclude from Syllabus switch");
		clickOnElement(osb.exclude_From_Syllabus_Switch);

		scrollTo2("Revis");
		System.out.println("Selecting Revision");
		test.log(Status.INFO, "Selecting Revision");
		clickOnElement(findElementByText("Revis"));
		Thread.sleep(2000);
		
		status=osb.primaryAction.isDisplayed();
		sAss.assertFalse(status, "User is able to revise chapter which is excluded from syllabus");
		if (!status) {
			System.out.println("User is not able to revise chapter which is excluded from syllabus");
			test.log(Status.INFO, "User is not able to revise chapter which is excluded from syllabus");
		}
			
		clickOnElement(osb.backBtn);
		scrollTo2("Exclude");
		clickOnElement(osb.exclude_From_Syllabus_Switch);
		
		sAss.assertAll();
	}

	public void validate_practice_excludeFromSyllabus_functionality() throws InterruptedException {
		scrollTo2("Exclude");
		System.out.println("Selecting Exclude from Syllabus switch");
		test.log(Status.INFO, "Selecting Exclude from Syllabus switch");
		clickOnElement(osb.exclude_From_Syllabus_Switch);

		scrollTo2("Practice");
		System.out.println("Selecting Practice");
		test.log(Status.INFO, "Selecting Practice");
		clickOnElement(findElementByText("Practice"));
		Thread.sleep(2000);
		
		status=osb.primaryAction.isDisplayed();
		sAss.assertFalse(status, "User is able to start practice which is excluded from syllabus");
		if (!status) {
			System.out.println("User is not able to start practice which is excluded from syllabus");
			test.log(Status.INFO, "User is not able to start practice which is excluded from syllabus");
		}
			
		clickOnElement(osb.backBtn);
		scrollTo2("Exclude");
		clickOnElement(osb.exclude_From_Syllabus_Switch);
		
		sAss.assertAll();
		
	}

	public void validate_revision_completedInSchool_functionality() throws InterruptedException {
		scrollTo2("Exclude");
		System.out.println("Selecting Completed In School switch");
		test.log(Status.INFO, "Selecting Completed In School switch");
		clickOnElement(osb.completed_In_School_Switch);

		scrollTo2("Revis");
		System.out.println("Selecting Revision");
		test.log(Status.INFO, "Selecting Revision");
		clickOnElement(findElementByText("Revis"));
		Thread.sleep(2000);
		
		status=osb.primaryAction.isDisplayed();
		sAss.assertFalse(status, "User is able to revise chapter which is Completed In School");
		if (!status) {
			System.out.println("User is not able to revise chapter which is Completed In School");
			test.log(Status.INFO, "User is not able to revise chapter which is Completed In School");
		}
			
		clickOnElement(osb.backBtn);
		scrollTo2("Exclude");
		clickOnElement(osb.completed_In_School_Switch);
		
		sAss.assertAll();

		
	}

	public void validate_practice_completedInSchool_functionality() throws InterruptedException {
		scrollTo2("Exclude");
		System.out.println("Selecting Completed In School switch");
		test.log(Status.INFO, "Selecting Completed In School switch");
		clickOnElement(osb.completed_In_School_Switch);

		scrollTo2("Practice");
		System.out.println("Selecting Practice");
		test.log(Status.INFO, "Selecting Practice");
		clickOnElement(findElementByText("Practice"));
		Thread.sleep(2000);
		
		status=osb.primaryAction.isDisplayed();
		sAss.assertFalse(status, "User is able to start practice which is Completed In School");
		if (!status) {
			System.out.println("User is not able to start practice which is Completed In School");
			test.log(Status.INFO, "User is not able to start practice which is Completed In School");
		}
			
		clickOnElement(osb.backBtn);
		scrollTo2("Exclude");
		clickOnElement(osb.completed_In_School_Switch);
		
		sAss.assertAll();
	}

	public void validate_create_oral_test_page() throws MalformedURLException {
		applyExplicitWaitsUntilElementVisible(osb.testUnit);
		scrollTo2("Syllabus");
		clickOnElement(findElementByText("Syllabus"));
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");

		clickOnElement(osb.assignmentButton);
		
		clickOnElement(findElementByText("Oral Test"));
		

		status=findElementByText("Create an oral test").isDisplayed();
		sAss.assertFalse(status, "User is not able to navigate towards create oral test page");
		if (!status) {
			System.out.println("User is able to click on oral test and page should navigate to create oral test page");
			test.log(Status.INFO, "User is able to click on oral test and page should navigate to create oral test page");
		}
			
	}

	public void validate_study_plan_page() throws MalformedURLException {
		applyExplicitWaitsUntilElementVisible(osb.testUnit);
		scrollTo2("Syllabus");
		clickOnElement(findElementByText("Syllabus"));
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");

		clickOnElement(osb.assignmentButton);
		
		clickOnElement(findElementByText("Study Plan"));
		

		status=findElementByText("Create Study Plan").isDisplayed();
		sAss.assertFalse(status, "User is not able to navigate towards create study plan page");
		if (!status) {
			System.out.println("User is able to click on study plan and page should navigate to create study plan page");
			test.log(Status.INFO, "User is able to click on study plan and page should navigate to create study plan page");
		}
			
		
	}

	public void validate_digital_test_page() throws MalformedURLException {
		applyExplicitWaitsUntilElementVisible(osb.testUnit);
		scrollTo2("Syllabus");
		clickOnElement(findElementByText("Syllabus"));
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");

		clickOnElement(osb.assignmentButton);
		
		clickOnElement(findElementByText("Digital Test"));
		

		status=findElementByText("Assign a digital test").isDisplayed();
		sAss.assertFalse(status, "User is not able to navigate towards Assign Digital Test page");
		if (!status) {
			System.out.println("User is able to click on Digital Test and page should navigate to Assign Digital Test page");
			test.log(Status.INFO, "User is able to click on Digital Test and page should navigate to Assign Digital Test page");
		}
				
	}
	
	
}
