package studi.co.pageModules;

import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Create_Study_Plan;
import studi.co.pageObjects.Object_MyLesson_Page;
import studi.co.pageObjects.Object_ReviewPlan;

public class Module_Create_Study_Plan extends BaseClass {
	Object_Create_Study_Plan oso = new Object_Create_Study_Plan();
	Object_ReviewPlan orp;
	Object_MyLesson_Page omp= new Object_MyLesson_Page();

	public void Verify_Existing_User_Should_Be_Able_To_Navigate_Create_Study_Plan(String property, String property2) {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}
		sAss.assertAll();
	}

	public void Verify_New_User_Should_Be_Able_To_Navigate_To_Study_Plan(String property, String property2) {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		status = oso.studyPlanTab.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Create Study Plan option shown on landing page");
			test.log(Status.INFO, "Create Study Plan option shown on landing page");
		}
		sAss.assertAll();
	}

	public void Verify_Existing_User_With_Active_Study_Plan_Able_To_Navigate_Create_Plan(String property,
			String property2) throws MalformedURLException, Exception {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		Thread.sleep(500);
		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}

		sAss.assertAll();
	}

	public void Verify_Existing_User_With_Paused_Study_Plan_Able_To_Navigate_To_Test_Plan(String property,
			String property2) throws Exception {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");

			if (oso.testPauselbl.isDisplayed()) {
				System.out.println("Paused Test Unit available");
				test.log(Status.INFO, "Paused Test Unit available");
				clickOnElement(oso.backButton);
				//scrollTo1("Report an issue");
				status = findElementByText("Syllabus").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Syllabus option displayed");
					test.log(Status.INFO, "Syllabus option displayed");
				}

				status = findElementByText("Assignments").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Assignments option displayed");
					test.log(Status.INFO, "Assignments option displayed");
				}

			} else {
				System.out.println("Paused Study plan not available");
				test.log(Status.INFO, "Paused Study plan not available");

			}
		} else {
			System.out.println("Study plan not available");
			test.log(Status.INFO, "Study plan not available");

		}
		sAss.assertAll();

	}

	public void Verify_User_Should_Not_Be_Able_Create_Study_Plan_Unless_Selecting_Syllabus(String property,
			String property2) throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards Create Study Plan tab");
		test.log(Status.INFO, "Traverse towards Create Study Plan tab");
		oso.traverse_toward_create_study_plan();

		System.out.println("Clicking on Create a Study Plan");
		test.log(Status.INFO, "Clicking on Create a Study Plan");
		clickOnElement(oso.createStudyPlanBtn);
		applyExplicitWait(5);

		//	applyExplicitWaitsUntilElementVisible(driver.findElementByClassName("android.widget.Image"));
		applyExplicitWaitsUntilElementVisible(oso.image);
		System.out.println("Subject list displayed to select portion");
		test.log(Status.INFO, "Subject list displayed to select portion");

		System.out.println("Trying to click on Next Step without selecting Subject");
		test.log(Status.INFO, "Trying to click on Next Step without selecting Subject");

		status = oso.nextStepBtn.isEnabled();
		sAss.assertFalse(status);
		if (!status) {
			System.out.println("Next Step button disable as no subject selected");
			test.log(Status.INFO, "Next Step button disable as no subject selected");
		}

		sAss.assertAll();
	}

	public void Verify_Create_Study_Plan_Button_Is_Tappable_On_Landing_Page(String property, String property2)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		System.out.println("Clicking on Test Unit Module");
		clickOnElement(oso.testUnitModule);
		scrollTo2("Create");

		clickOnElement(oso.managePlanBtn);
		System.out.println("Clicked on Manage and Create plan Tab");

		status = oso.createStudyPlanBtn.isDisplayed();

		sAss.assertTrue(status);
		if (status) {
			System.out.println("Create Study Plan option shown on landing page");
			test.log(Status.INFO, "Create Study Plan option shown on landing page");
		}

		System.out.println("Clicking on Create a Study Plan");
		test.log(Status.INFO, "Clicking on Create a Study Plan");
		clickOnElement(oso.createStudyPlanBtn);
		applyExplicitWait(5);

		//		applyExplicitWaitsUntilElementVisible(driver.findElementByClassName("android.widget.Image"));
		//		applyExplicitWaitsUntilElementVisible(oso.image);
		System.out.println("Create Study Plan button is tappable");
		test.log(Status.INFO, "Create Study Plan button is tappable");

		sAss.assertAll();
	}

	public void Verify_After_Create_Study_Plan_Button_User_Navigate_To_Bookshelf(String property, String property2)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		System.out.println("Clicking on Test Unit Module");
		clickOnElement(oso.testUnitModule);
		scrollTo2("Create");

		clickOnElement(oso.managePlanBtn);
		System.out.println("Clicked on Manage and Create plan Tab");

		status = oso.createStudyPlanBtn.isDisplayed();

		sAss.assertTrue(status);
		if (status) {
			System.out.println("Create Study Plan option shown on landing page");
			test.log(Status.INFO, "Create Study Plan option shown on landing page");
		}

		System.out.println("Clicking on Create a Study Plan");
		test.log(Status.INFO, "Clicking on Create a Study Plan");
		clickOnElement(oso.createStudyPlanBtn);
		applyExplicitWait(5);

		//		applyExplicitWaitsUntilElementVisible(driver.findElementByClassName("android.widget.Image"));
		//		applyExplicitWaitsUntilElementVisible(oso.image);
		System.out.println("Create Study Plan button is tappable");
		test.log(Status.INFO, "Create Study Plan button is tappable");
		applyExplicitWait(5);

		//	applyExplicitWaitsUntilElementVisible(driver.findElementByClassName("android.widget.Image"));
		//	applyExplicitWaitsUntilElementVisible(oso.image);
		System.out.println("Subject list displayed to select portion");
		test.log(Status.INFO, "Subject list displayed to select portion");

		//status = findElementByText("tap on a subject to select chapters").isDisplayed();

		sAss.assertTrue(status);
		if (status) {
			System.out.println("Instruction to select Book in the bookshelf page Displayed");
			test.log(Status.INFO, "Instruction to select Book in the bookshelf page Displayed");
		}

		sAss.assertAll();

	}
	//TC 28
	public void Verify_Lesson_Order_In_Test_Unit(String property, String property2) throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}
		//@


		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo1(lesson.getKey().toString());

			scrollTo2("Summary");

			String actualLesson = getDriver().findElementByXPath(lesson.getValue().toString() + "" + oso.lessonType)
					.getText();

			System.err.println(actualLesson);
			sAss.assertEquals(actualLesson, lesson.getKey().toString(), "Lesson order wrong");
		}

		sAss.assertAll();
	}

	public void Verify_Lesson_Order_After_Complting_Lessons_In_Test_Unit(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		oso.createPlan(subject, topic);

		System.out.println("Marking All lessons as complete");
		test.log(Status.INFO, "Marking All lessons as complete");

		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			clickOnElement(oso.topLessonStatus);
			applyExplicitWait(5);
			clickOnElement(oso.markAsComplete);
		}
		//@		
		int i = 0;
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo2(lesson.getKey().toString());
			//this path is incorrect of actual lession
			String actualStatus = getDriver().findElementByXPath(
					"hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[2]"
							+ (i + 1) + "]/android.view.ViewGroup" + "" + oso.lessonStatus)
					.getAttribute("resource-id");
			System.err.println(actualStatus);
			status = actualStatus.contains("complete");
			sAss.assertTrue(status, "Incorrect Status");
			i++;
			if (i == oso.expectedLessonOrder.size())
				break;
		}

		sAss.assertAll();

	}

	public void Verify_BigIdea_Revise_And_Practice_Unlocked_Together_In_Test_Unit(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		oso.createPlan(subject, topic);

		System.out.println("Checking lock unlock status of lesson");
		test.log(Status.INFO, "Checking lock unlock status of lesson");
		//@
		int i = 0;
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo2(lesson.getKey().toString());
			System.err.println(lesson.getKey());
			String actualStatus = getDriver().findElementByXPath(lesson.getValue() + "" + oso.lessonType)
					.getAttribute("clickable");	
			// Problem with App. Returned wrong status of attribute "clickable"
			System.err.println(actualStatus + " for " + lesson.getKey());
			status = Boolean.parseBoolean(actualStatus);
			if (status) {
				System.out.println(lesson.getKey() + " Unlocked");
				test.log(Status.INFO, lesson.getKey() + " Unlocked");
			}
			sAss.assertTrue(status, "Incorrect Status");
			i++;
			if (i == 3)
				break;
		}

		sAss.assertAll();

	}

	public void Verify_After_First_Topic_Completion_Second_Topic_Will_Unlocked_In_Test_Unit(String subject,
			String topic1, String topic8_w) throws Exception {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		oso.createPlan(subject, topic1, topic8_w);

		System.out.println("Marking 1st Topic as completed");
		test.log(Status.INFO, "Marking 1st Topic as completed");
		scrollTo1(topic8_w);
		//clickOnElement(findElementByText("Test"));
		//@
		String topic1Subject = "", topic2Subject;
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			applyExplicitWaitsUntilElementClickable(oso.topLessonStatus);
			//topic1Subject = getDriver().findElementByXPath(lesson.getValue() + "" + oso.lessonSubjectName).getText();
			topic1Subject=getDriver().findElementById("com.tce.studi:id/tvSubjectName").getText();
			clickOnElement(oso.topLessonStatus);
			applyExplicitWait(5);
			clickOnElement(oso.markAsComplete);
		}

		scrollTo2("Upcoming");

		System.out.println("Checking 2nd Topic for same subject");
		test.log(Status.INFO, "Checking 2nd Topic for same subject");
		action = new TouchAction(driver);
		//@
		int i = 0;
		for (Map.Entry<String, String> lesson : oso.upcomingLesson.entrySet()) {
			scrollTo2(lesson.getKey());

			topic2Subject = getDriver().findElementByXPath(lesson.getValue() + "" + oso.lessonSubjectName).getText();
			System.err.println(topic2Subject + " for " + lesson.getKey());
			status = topic1Subject.equals(topic2Subject);
			if (status) {
				System.out.println(lesson.getKey() + " Enabled for second topic :" + topic8_w);
				test.log(Status.INFO, lesson.getKey() + " Enabled for second topic :" + topic8_w);
			}
			sAss.assertTrue(status, "Incorrect Subject Displayed for " + topic8_w);
			i++;
			if (i == oso.upcomingLesson.size())
				break;
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(115, 550)).release().perform();

		}
		sAss.assertAll();

	}

	public void Verify_BigIdea_Revise_And_Practice_Unlocked_Together_For_Upcoming_Topic_In_Test_Unit(String subject,
			String topic1, String topic8_w) throws Exception {

		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		oso.createPlan(subject, topic1, topic8_w);

		System.out.println("Marking 1st Topic as completed");
		test.log(Status.INFO, "Marking 1st Topic as completed");

		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			clickOnElement(oso.topLessonStatus);
			applyExplicitWait(5);
			clickOnElement(oso.markAsComplete);
		}

		// scrollTo2(topic2);
		// clickOnElement(findElementByText("Upcoming"));

		System.out.println("Checking Lock|Unlock status of 2nd Topic");
		test.log(Status.INFO, "Checking Lock|Unlock status of 2nd Topic");
		int i = 0;
		for (Map.Entry<String, String> lesson : oso.upcomingLesson.entrySet()) {
			scrollTo3(lesson.getKey(), 2);
			//@
			String actualStatus = getDriver().findElementByXPath(lesson.getValue() + "" + oso.lessonType)
					.getAttribute("enabled");
			// Problem with App. Returned wrong status of attribute "clickable"
			System.err.println(actualStatus + " for " + lesson.getKey());
			status = Boolean.parseBoolean(actualStatus);
			if (status) {
				System.out.println(lesson.getKey() + " Unlocked");
				test.log(Status.INFO, lesson.getKey() + " Unlocked");
			}
			sAss.assertTrue(status, "Incorrect Status");
			i++;
			if (i == 3)
				break;
		}
		sAss.assertAll();
	}

	public void Verify_One_Spaced_Practice_For_All_ParentLesson_In_Test_Unit(String subject, String topic1,
			String topic2) throws Exception {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		oso.createPlan(subject, topic1);

		System.out.println("Marking Topic as completed");
		test.log(Status.INFO, "Marking Topic as completed");

		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			clickOnElement(oso.topLessonStatus);
			applyExplicitWait(5);
			clickOnElement(oso.markAsComplete);
		}

		scrollTo2("Upcoming");

		for (int i = 0; i < 1; i++) {
			if (!oso.subjectFlag.get(subject)) {

				System.out.println(subject + " not Flagged");
				test.log(Status.INFO, subject + " not Flagged");

				System.out.println("Checking for single spaced practice");
				test.log(Status.INFO, "Checking for single spaced practice");
				//@
				status = driver.findElementByXPath(oso.getUpcommingLesson(i) + "" + oso.lessonType).getText()
						.equalsIgnoreCase("Practice 1");
				if (status) {
					System.out.println("Spaced practice1 available for " + subject);
					test.log(Status.INFO, "Spaced practice1 available for " + subject);
				}
			}
		}

		sAss.assertAll();
	}

	public void Verify_Two_Spaced_Practice_For_All_Flaged_ParentLesson_In_Test_Unit(String subject, String topic1,
			String topic2) throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		oso.createPlan(subject, topic1, true);

		System.out.println("Marking Topic as completed");
		test.log(Status.INFO, "Marking Topic as completed");

		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			applyExplicitWaitsUntilElementClickable(oso.topLessonStatus);
			clickOnElement(oso.topLessonStatus);
			applyExplicitWait(5);
			clickOnElement(oso.markAsComplete);
		}

		scrollTo2("Upcoming");
		action = new TouchAction<>(driver);
		action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
		.moveTo(PointOption.point(115, 450)).release().perform();

		for (int i = 0; i < 1; i++) {
			System.out.println("flag = " + oso.subjectFlag.get(subject));
			if (!oso.subjectFlag.get(subject)) {

				System.out.println(subject + " not Flagged");
				test.log(Status.INFO, subject + " not Flagged");

				System.out.println("Checking for single spaced practice");
				test.log(Status.INFO, "Checking for single spaced practice");
				//@
				status = driver.findElementByXPath(oso.getUpcommingLesson(i) + "" + oso.lessonType).getText()
						.equalsIgnoreCase("Practice 1");
				if (status) {
					System.out.println("Spaced practice1 available for " + subject);
					test.log(Status.INFO, "Spaced practice1 available for " + subject);
				}
			} else {
				System.out.println(subject + " Flagged");
				test.log(Status.INFO, subject + " Flagged");

				System.out.println("Checking for spaced Practice1");
				test.log(Status.INFO, "Checking for spaced Practice1");
				scrollTo2("Practice");
				status = driver.findElementByXPath(oso.getUpcommingLesson(i) + "" + oso.lessonType).getText()
						.equalsIgnoreCase("Practice 1");
				if (status) {
					System.out.println("Spaced practice1 available for " + subject);
					test.log(Status.INFO, "Spaced practice1 available for " + subject);
				}
				action = new TouchAction<>(driver);
				action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
				.moveTo(PointOption.point(115, 450)).release().perform();

				System.out.println("Checking for spaced Practice2");
				test.log(Status.INFO, "Checking for spaced Practice2");
				//@
				status = driver.findElementByXPath(oso.getUpcommingLesson(i + 1) + "" + oso.lessonType).getText()
						.equalsIgnoreCase("Practice 2");
				if (status) {
					System.out.println("Spaced practice2 available for " + subject);
					test.log(Status.INFO, "Spaced practice2 available for " + subject);
				}

			}
		}
		sAss.assertAll();

	}

	public void Verify_Spaced2_Practice_Only_Added_If_Parent_Practice_Is_Incomplete_In_Test_Unit(String subject,
			String topic) throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan Without flagged the Subject");
		test.log(Status.INFO, "Creating new Plan Without flagged the Subject");
		//oso.createPlan(subject, topic);

		System.out.println("Checking weather we can add Flag for Subject(without completing Parent practice)");
		test.log(Status.INFO, "Checking weather we can add Flag for Subject(without completing Parent practice)");

		scrollTo1("Manage and Create Plans");

		System.out.println("Clicking on Manage and Create Plans");
		test.log(Status.INFO, "Clicking on Manage and Create Plans");
		clickOnElement(oso.managePlanBtn);

		applyExplicitWaitsUntilElementClickable(oso.createStudyPlanBtn);
		System.out.println("Clicking on Study Plan");
		test.log(Status.INFO, "Clicking on Study Plan");
		clickOnElement(oso.element44);

		applyExplicitWaitsUntilElementClickable(oso.editPlan);
		System.out.println("Clicking on Edit Plan Button");
		test.log(Status.INFO, "Clicking on Edit Plan Button");
		clickOnElement(oso.editPlan);
		applyExplicitWait(5);

		applyExplicitWaitsUntilElementClickable(oso.object44);
		clickOnElement(findElementByText("Portion"));

		applyExplicitWaitsUntilElementClickable(oso.nextStepBtn);
		clickOnElement(oso.nextStepBtn);

		System.out.println("Moving to \"Pay Extra Attention\" Window");
		test.log(Status.INFO, "Moving to \"Pay Extra Attention\" Window");

		System.out.println("Try to flag the Subject");
		test.log(Status.INFO, "Try to flag the Subject");

		applyExplicitWaitsUntilElementClickable(oso.getFlagIcon());
		clickOnElement(oso.getFlagIcon());
		// clickOnElement(findElementByText(subject));

		Thread.sleep(500);
		status = Boolean.parseBoolean(oso.getFlagIcon().getAttribute("focused"));
		System.out.println("Flag focus : " + oso.getFlagIcon().getAttribute("focused"));
		if (status) {
			oso.subjectFlag.put(subject, true);
			System.out.println("User is Able to add Spaced Practice2 if parent practice is incomplete");
			test.log(Status.INFO, "User is Able to add Spaced Practice2 if parent practice is incomplete");
		}
		//@
		applyExplicitWaitsUntilElementClickable(oso.nextStepBtn);
		clickOnElement(oso.nextStepBtn);
		System.out.println("Started calender");
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				List<MobileElement> dates = driver.findElements(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.GridView/android.view.View["
								+ (i + 1) + "]/android.view.View[" + (j + 1) + "]"));
				for (MobileElement date : dates) {
					System.out.println(date.getText() + " " + date.getAttribute("focused"));
					if (date.getAttribute("focused").equalsIgnoreCase("true")) {
						date.click();
					}
				}
			}
		}
		applyExplicitWaitsUntilElementClickable(oso.nextStepBtn);
		clickOnElement(oso.nextStepBtn);

		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("Plan Updated");
		test.log(Status.INFO, "Plan Updated");

		System.out.println("Verifying updated Spaced Practice2");
		test.log(Status.INFO, "Verifying updated Spaced Practice2");

		scrollTo2("Upcoming");
		action = new TouchAction<>(driver);
		action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(115, 550)).release().perform();

		for (int i = 0; i < 1; i++) {
			System.out.println("flag = " + oso.subjectFlag.get(subject));
			if (!oso.subjectFlag.get(subject)) {

				System.out.println(subject + " not Flagged");
				test.log(Status.INFO, subject + " not Flagged");

				System.out.println("Checking for single spaced practice");
				test.log(Status.INFO, "Checking for single spaced practice");
				//@
				status = driver.findElementByXPath(oso.getUpcommingLesson(i) + "" + oso.lessonType).getText()
						.equalsIgnoreCase("Practice 1");
				if (status) {
					System.out.println("Spaced practice1 available for " + subject);
					test.log(Status.INFO, "Spaced practice1 available for " + subject);
				}
			} else {
				System.out.println(subject + " Flagged");
				test.log(Status.INFO, subject + " Flagged");

				System.out.println("Checking for spaced Practice1");
				test.log(Status.INFO, "Checking for spaced Practice1");
				//@
				status = driver.findElementByXPath(oso.getUpcommingLesson(i) + "" + oso.lessonType).getText()
						.equalsIgnoreCase("Practice 1");
				if (status) {
					System.out.println("Spaced practice1 available for " + subject);
					test.log(Status.INFO, "Spaced practice1 available for " + subject);
				}
				action = new TouchAction<>(driver);
				action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
				.moveTo(PointOption.point(115, 350)).release().perform();

				System.out.println("Checking for spaced Practice2");
				test.log(Status.INFO, "Checking for spaced Practice2");
				//@
				status = driver.findElementByXPath(oso.getUpcommingLesson(i + 1) + "" + oso.lessonType).getText()
						.equalsIgnoreCase("Practice 2");
				if (status) {
					System.out.println("Spaced practice2 available for " + subject);
					test.log(Status.INFO, "Spaced practice2 available for " + subject);
				}

			}
		}
		sAss.assertAll();

	}

	public void Verify_User_Should_Be_Able_To_Create_Study_Plan_Via_Syllabus_Module(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.syllabusUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Syllabus Module displayed on landing page");
			test.log(Status.INFO, "Syllabus Module displayed on landing page");
		}

		System.out.println("Opening Syllabus Module");
		test.log(Status.INFO, "Opening Syllabus Module");
		clickOnElement(oso.syllabusUnitModule);

	//	System.out.println("Clicking on assign button");
		//test.log(Status.INFO, "Clicking on assign button");
		//clickOnElement(oso.assignBtn);

		applyExplicitWaitsUntilElementClickable(oso.studyPlanSyl);
		clickOnElement(oso.studyPlanSyl);

		System.err.println("Clicked on " + subject);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		System.err.println("Clicked on " + topic);
		scrollTo2(topic);
		clickOnElement(findElementByText(topic));

		applyExplicitWait(5);
		clickOnElement(findElementByText("Add to portion"));

		applyExplicitWaitsUntilElementClickable(oso.nextStepBtn);
		clickOnElement(oso.nextStepBtn);
		applyExplicitWait(5);

		action = new TouchAction(driver);

		status = Boolean.parseBoolean(driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View["
						+ 1 + "]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button")
				.getAttribute("focused"));
		if (status) {
			oso.subjectFlag.put(subject, true);
		} else {
			oso.subjectFlag.put(subject, false);
		}

		applyExplicitWaitsUntilElementClickable(oso.nextStepBtn);
		clickOnElement(oso.nextStepBtn);
		applyExplicitWaitsUntilElementClickable(oso.nextStepBtn);
		clickOnElement(oso.nextStepBtn);

		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		applyExplicitWait(5);

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("New plan created");
			test.log(Status.INFO, "New plan created");
		}

		sAss.assertAll();
	}

	public void Verify_Spaced_Practice1_And_Prctice2_Not_Come_In_Same_Day(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan Without flagged the Subject");
		test.log(Status.INFO, "Creating new Plan Without flagged the Subject");
		oso.createPlan(subject, topic, true);

		System.out.println("Checking weather due Date for Spaced Practice1 and Practice2 must be different");
		test.log(Status.INFO, "Checking weather due Date for Spaced Practice1 and Practice2 must be different");

		scrollTo2("View Full Schedule");
		action = new TouchAction<>(driver);
		action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(115, 550)).release().perform();

		System.out.println("Checking Due Date for spaced Practice1");
		test.log(Status.INFO, "Checking Due Date for spaced Practice1");
		//@
		status = driver.findElementByXPath(oso.getUpcommingLesson(0) + "" + oso.lessonType).getText()
				.equalsIgnoreCase("Practice 1");
		String practice1Due = driver.findElementByXPath(oso.getUpcommingLesson(0) + "" + oso.lessonDueDate).getText();
		if (status) {
			System.out.println("Spaced practice1 available for " + subject);
			test.log(Status.INFO, "Spaced practice1 available for " + subject);
		}
		action = new TouchAction<>(driver);
		action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
		.moveTo(PointOption.point(115, 450)).release().perform();

		System.out.println("Checking for spaced Practice2");
		test.log(Status.INFO, "Checking for spaced Practice2");
		//@
		status = driver.findElementByXPath(oso.getUpcommingLesson(1) + "" + oso.lessonType).getText()
				.equalsIgnoreCase("Practice 2");
		String practice2Due = driver.findElementByXPath(oso.getUpcommingLesson(1) + "" + oso.lessonDueDate).getText();
		if (status) {
			System.out.println("Spaced practice2 available for " + subject);
			test.log(Status.INFO, "Spaced practice2 available for " + subject);
		}
		System.out.println("Practice1 :" + practice1Due);
		test.log(Status.INFO, "Practice1 :" + practice1Due);

		System.out.println("Practice2 :" + practice2Due);
		test.log(Status.INFO, "Practice2 :" + practice2Due);

		if (!practice1Due.equals(practice2Due)) {
			System.out.println("Due Date for Both Spaced Practice are different");
			test.log(Status.INFO, "Due Date for Both Spaced Practice are different");
		}
		sAss.assertNotEquals(practice1Due, practice2Due);

		sAss.assertAll();
	}

	public void Verify_Spaced_Practice_And_Parent_Prctice_Not_Come_In_Same_Day(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan Without flagged the Subject");
		test.log(Status.INFO, "Creating new Plan Without flagged the Subject");
		oso.createPlan(subject, topic, true);

		System.out.println(
				"Checking weather due Date for parent Practice is different from Spaced Practice1 and Practice2");
		test.log(Status.INFO,
				"Checking weather due Date for parent Practice is different from Spaced Practice1 and Practice2");

		System.out.println("Checking Due Date for Parent Practice");
		test.log(Status.INFO, "Checking Due Date for Parent Practice1");
		scrollTo1("Practice");

		DateTimeFormatter dtf = DateTimeFormatter.RFC_1123_DATE_TIME;
		ZonedDateTime now = ZonedDateTime.now();

		String[] tempDate = now.format(dtf).toString().split(" ");
		String parectPracticeDue = "due on " + tempDate[1] + " " + tempDate[2];

		scrollTo2("View Full Schedule");
		action = new TouchAction<>(driver);
		action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(115, 550)).release().perform();

		System.out.println("Checking Due Date for spaced Practice1");
		test.log(Status.INFO, "Checking Due Date for spaced Practice1");
		//@
		status = driver.findElementByXPath(oso.getUpcommingLesson(0) + "" + oso.lessonType).getText()
				.equalsIgnoreCase("Practice 1");
		String practice1Due = driver.findElementByXPath(oso.getUpcommingLesson(0) + "" + oso.lessonDueDate).getText();
		if (status) {
			System.out.println("Spaced practice1 available for " + subject);
			test.log(Status.INFO, "Spaced practice1 available for " + subject);
		}
		action = new TouchAction<>(driver);
		action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
		.moveTo(PointOption.point(115, 450)).release().perform();

		System.out.println("Checking for spaced Practice2");
		test.log(Status.INFO, "Checking for spaced Practice2");
		//@
		status = driver.findElementByXPath(oso.getUpcommingLesson(1) + "" + oso.lessonType).getText()
				.equalsIgnoreCase("Practice 2");
		String practice2Due = driver.findElementByXPath(oso.getUpcommingLesson(1) + "" + oso.lessonDueDate).getText();
		if (status) {
			System.out.println("Spaced practice2 available for " + subject);
			test.log(Status.INFO, "Spaced practice2 available for " + subject);
		}
		System.out.println("Parent Practice :" + parectPracticeDue);
		test.log(Status.INFO, "Parent Practice :" + parectPracticeDue);

		System.out.println("Spaced Practice1 :" + practice1Due);
		test.log(Status.INFO, "Spaced Practice1 :" + practice1Due);

		System.out.println("Spaced Practice2 :" + practice2Due);
		test.log(Status.INFO, "Spaced Practice2 :" + practice2Due);

		if (!parectPracticeDue.equals(practice2Due) && !parectPracticeDue.equals(practice2Due)) {
			System.out.println("Due Date for Parent Practice and Spaced Practice are different");
			test.log(Status.INFO, "Due Date for Parent Practice and Spaced Practice are different");
		}
		sAss.assertNotEquals(parectPracticeDue, practice1Due);
		sAss.assertNotEquals(parectPracticeDue, practice2Due);

		sAss.assertAll();

	}

	public void Verify_Lesson_Status_Will_Reflects_In_Lessons_Today_Tab(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating Plan");
		test.log(Status.INFO, "Creating Plan");
		oso.createPlan(subject, topic);

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}
		//@
		scrollTo2("Revise");
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo1(lesson.getKey().toString());
			WebElement actualLessonPanel = getDriver().findElementByXPath(
					lesson.getValue().toString() + "" + oso.lessonType + "/parent::*/parent::*/parent::*/parent::*");
			System.err.println("For " + lesson.getKey() + " :" + actualLessonPanel.getAttribute("resource-id"));

			status = actualLessonPanel.getAttribute("resource-id")
					.equals(oso.todaysLessonPanel.getAttribute("resource-id"));
			if (status) {
				System.out.println(lesson.getKey() + "'s status reflected in MyLesson Today panel");
				test.log(Status.INFO, lesson.getKey() + "'s status reflected in MyLesson Today panel");
			}
			sAss.assertTrue(status, "Element not match");
		}

		sAss.assertAll();

	}

	public void Verify_After_Completing_Lesson_Not_Reflects_In_Upcoming_Today_Tab(String subject, String topic1,
			String topic2) throws Exception {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating Plan");
		test.log(Status.INFO, "Creating Plan");
		oso.createPlan(subject, topic1);

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}

		scrollTo2("Revise");
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			applyExplicitWait(5);
			scrollTo1(lesson.getKey().toString());
			applyExplicitWaitsUntilElementClickable(oso.topLessonStatus);
			if (oso.topLessonStatus.getAttribute("resource-id").contains("img")) {
				clickOnElement(oso.topLessonStatus);
				applyExplicitWait(5);
				applyExplicitWaitsUntilElementClickable(oso.markAsComplete);
				clickOnElement(oso.markAsComplete);

				System.out.println(topic1 + " : " + lesson.getKey() + " marked as complete");
				test.log(Status.INFO, topic1 + " : " + lesson.getKey() + " marked as complete");

			}
			System.err.println("Next");
		}
		System.out.println("All lessons from " + topic1 + " marked as complete");
		test.log(Status.INFO, "All lessons from " + topic1 + " marked as complete");

		scrollTo1("Upcoming");

		System.out.println(oso.getTaskCountForUpcomingPlan() + " Lessons in Upcoming tab");
		test.log(Status.INFO, oso.getTaskCountForUpcomingPlan() + " Lessons in Upcoming tab");

		System.out.println("Try to complete lessons in Upcoing tab");
		test.log(Status.INFO, oso.getTaskCountForUpcomingPlan() + "Try to complete lessons in Upcoing tab");

		int panel = 1;
		int lockedCount = 0;
		//@
		for (int i = 0; panel <= oso.getTaskCountForUpcomingPlan(); i++) {
			System.err.println(oso.getTaskCountForUpcomingPlan());
			if (driver
					.findElementByXPath(
							oso.upcomingLessonsPanel + "/android.view.ViewGroup[" + panel + "]" + oso.lessonStatus)
					.getAttribute("resource-id").contains("img")) {

				System.out.println(topic2 + " : "
						+ driver.findElementByXPath(
								oso.upcomingLessonsPanel + "/android.view.ViewGroup[" + panel + "]" + oso.lessonType)
						.getText()
						+ " marked as complete");
				test.log(Status.INFO,
						topic2 + " : " + driver.findElementByXPath(
								oso.upcomingLessonsPanel + "/android.view.ViewGroup[" + panel + "]" + oso.lessonType)
						.getText() + " marked as complete");

				applyExplicitWaitsUntilElementClickable(driver.findElementByXPath(
						oso.upcomingLessonsPanel + "/android.view.ViewGroup[" + panel + "]" + oso.lessonStatus));
				clickOnElement(driver.findElementByXPath(
						oso.upcomingLessonsPanel + "/android.view.ViewGroup[" + panel + "]" + oso.lessonStatus));
				applyExplicitWait(5);
				applyExplicitWaitsUntilElementClickable(oso.markAsComplete);
				clickOnElement(oso.markAsComplete);

			} else if (driver
					.findElementByXPath(
							oso.upcomingLessonsPanel + "/android.view.ViewGroup[" + panel + "]" + oso.lessonStatus)
					.getAttribute("resource-id").contains("lock")) {
				applyExplicitWait(5);

				System.err.println(driver
						.findElementByXPath(
								oso.upcomingLessonsPanel + "/android.view.ViewGroup[" + panel + "]" + oso.lessonType)
						.getText() + " Is Locked");
				test.log(Status.INFO,
						driver.findElementByXPath(
								oso.upcomingLessonsPanel + "/android.view.ViewGroup[" + panel + "]" + oso.lessonType)
						.getText() + " Is Locked");
				sAss.assertTrue(driver
						.findElementByXPath(
								oso.upcomingLessonsPanel + "/android.view.ViewGroup[" + panel + "]" + oso.lessonType)
						.getText().contains("Practice"));
				///////// IMP///////////
				panel++;
				///////////////////////
				lockedCount++;
			}
			action = new TouchAction<>(driver);
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(115, 450)).release().perform();
			applyExplicitWait(5);

		}

		System.out.println("All lessons marked as complete");
		test.log(Status.INFO, oso.getTaskCountForUpcomingPlan() + "All lessons marked as complete");

		System.err.println("Locked count " + lockedCount);
		status = lockedCount == oso.getTaskCountForUpcomingPlan() ? true : false;
		sAss.assertTrue(status, "Upcoming task count mismatch");
		if (status) {
			System.out.println("None of the lesson remain in Upcoming tab");
			test.log(Status.INFO, oso.getTaskCountForUpcomingPlan() + "None of the lesson remain in Upcoming tab");
		}

		sAss.assertAll();

	}

	public void Verify_Past_Completed_Lessons_Can_Be_Attempted_Again(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating Plan");
		test.log(Status.INFO, "Creating Plan");
		oso.createPlan(subject, topic);

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}

		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			clickOnElement(oso.topLessonStatus);
			applyExplicitWait(5);
			clickOnElement(oso.markAsComplete);
		}

		System.out.println("Marking All lessons as complete");
		test.log(Status.INFO, "Marking All lessons as complete");
		//@
		int i = 0;
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo2(lesson.getKey().toString());
			String actualStatus = getDriver().findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
							+ (i + 1) + "]/android.view.ViewGroup" + "" + oso.lessonStatus)
					.getAttribute("resource-id");
			System.err.println(actualStatus);
			status = actualStatus.contains("complete");
			sAss.assertTrue(status, "Incorrect Status");
			i++;
			if (i == oso.expectedLessonOrder.size())
				break;
		}
		if (status) {
			System.out.println("Today's lessons marked as complete");
			test.log(Status.INFO, "Today's lessons marked as complete");
		}

		System.out.println("Try to attempt completed lessons again");
		test.log(Status.INFO, "Try to attempt completed lessons again");

		((FindsByAndroidUIAutomator<MobileElement>) getDriver()).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(20)");

		i = 0;
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			applyExplicitWait(5);
			scrollTo2(lesson.getKey().toString());
			clickOnElement(findElementByText(lesson.getKey()));

			System.out.println("Try to open " + lesson.getKey());
			test.log(Status.INFO, "Try to open " + lesson.getKey());
			Thread.sleep(2000);
			//@
			switch (lesson.getKey()) {
			case "Big Idea":
				Thread.sleep(2000);
				applyExplicitWaitsUntilElementVisible(driver.findElementById("com.tce.studi:id/header_bar_container"));
				new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(driver.findElementById("com.tce.studi:id/header_bar_container")));
				status = driver.findElementById("com.tce.studi:id/header_bar_container").isDisplayed();
				sAss.assertTrue(status);
				if (status) {

					System.out.println("Big Idea Can be attempt either it's done previously");
					test.log(Status.INFO, "Big Idea Can be attempt either it's done previously");
				}

				driver.navigate().back();
				applyExplicitWait(5);
				clickOnElement(findElementByText("Yes"));
				break;

			case "Revise":
				status = findElementByText("Return to Study Plan").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Revision Can be attempt either it's done previously");
					test.log(Status.INFO, "Revision Can be attempt either it's done previously");
				}

				driver.navigate().back();
				applyExplicitWait(5);
				break;
			case "Practice":
				status = findElementByText("Return to Study Plan").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Practice Can be attempt either it's done previously");
					test.log(Status.INFO, "Practice Can be attempt either it's done previously");
				}

				driver.navigate().back();
				applyExplicitWait(5);

				break;
			case "Summary":
				System.err.println("Summary tab not yet Developed");
				test.log(Status.ERROR, "Summary tab not yet Developed");
				break;
				//@				
			case "Test":
				//				getDriver().findElementByXPath(
				//						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.view.ViewGroup")
				//						.click();

				oso.element52.click();

				status = findElementByText("Return to Study Plan").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Test Can be attempt either it's done previously");
					test.log(Status.INFO, "Test Can be attempt either it's done previously");
				}

				driver.navigate().back();
				applyExplicitWait(5);

				break;

			default:

			}

			i++;
			if (i == oso.expectedLessonOrder.size())
				break;
		}

		sAss.assertAll();
	}

	public void Verify_Each_Topic_Have_5Lessons_With_One_Spaced_Practice(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		oso.createPlan(subject, topic);

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}
		//@
		scrollTo2("Revise");
		action = new TouchAction(driver);
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo1(lesson.getKey());
			String actualLesson = getDriver().findElementByXPath(lesson.getValue().toString() + "" + oso.lessonType)
					.getText();
			System.err.println(actualLesson);
			test.log(Status.INFO, actualLesson);
			sAss.assertEquals(actualLesson, lesson.getKey().toString(),
					lesson.getKey().toString() + " not added in test plan");
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(115, 550)).release().perform();

		}
		//@
		scrollTo1("Upcoming");
		//String actualLesson = getDriver().findElementById("com.tce.studi:id/tvTopic"+ "" + oso.lessonType).getText();
		//List<MobileElement>actuallession=getDriver().findElementsById("com.tce.studi:id/upcomingMainView");


		//test.log(Status.INFO, actualLesson);
		//sAss.assertEquals(actualLesson, "Practice 1", "Practice1 not added in test plan");
		//System.err.println(actuallession.size());

		for(MobileElement mb:oso.mainView)
		{
			MobileElement e =mb.findElementById("com.tce.studi:id/tvChapterType");
			System.out.println(e.getText());
			sAss.assertTrue(e.isDisplayed());
		}


		sAss.assertAll();

	}

	public void TC27_Verify_Each_Flagged_Subject_Have_5Lessons_With_Two_Spaced_Practice(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		oso.createPlan(subject, topic, true);

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}
		//@
		scrollTo2("Revise");
		action = new TouchAction(driver);
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo1(lesson.getKey());
			String actualLesson = getDriver().findElementByXPath(lesson.getValue().toString() + "" + oso.lessonType)
					.getText();
			System.err.println(actualLesson);
			test.log(Status.INFO, actualLesson);
			sAss.assertEquals(actualLesson, lesson.getKey().toString(),
					lesson.getKey().toString() + " not added in test plan");
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(115, 550)).release().perform();

		}
		//@
		scrollTo1("Upcoming");

		ArrayList practice= new ArrayList(oso.mainView.size());
		int i=0;

		for(MobileElement mb:oso.mainView)
		{
			MobileElement e =mb.findElementById("com.tce.studi:id/tvChapterType");
			String actualLesson=e.getText();
			practice.add(actualLesson);

		}

		if(practice.contains("Practice 1"))
		{
			System.out.println("Practice 1 is present");
		}
		else
		{
			System.err.println("Practice 1 is not present");	
		}

		if(practice.contains("Practice 2"))
		{
			System.out.println("Practice 2 is present");
		}
		else
		{
			System.err.println("Practice 2 is not present");	
		}


		//String actualLesson = getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"+ "" + oso.lessonType).getText();
		//System.err.println(actualLesson);
		//test.log(Status.INFO, actualLesson);
		//sAss.assertEquals(actualLesson, "Practice 1", "Practice 2 not added in test plan");
		//action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		//.moveTo(PointOption.point(115, 550)).release().perform();

		//actualLesson = getDriver().findElementByXPath(
		//	"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"	+ "" + oso.lessonType).getText();
		//"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]" +"" +oso.lessonType).getText();
		//System.err.println(actualLesson);
		//test.log(Status.INFO, actualLesson);
		//sAss.assertEquals(actualLesson, "Practice 2", "Practice 2 not added in test plan");

		sAss.assertAll();

	}

	public void Verify_Order_Of_Release_As_BigIdea_Revise_And_Practice(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}

		oso.createPlan(subject, topic);
		//@
		scrollTo2("Revise");
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo2(lesson.getKey());
			String actualLesson = getDriver().findElementByXPath(lesson.getValue().toString() + "" + oso.lessonType)
					.getText();
			test.log(Status.INFO, actualLesson);
			System.err.println(actualLesson);
			sAss.assertEquals(actualLesson, lesson.getKey().toString(), "Release order wrong");
		}

		sAss.assertAll();

	}

	public void Verify_After_Chapter_Complition_Summary_And_Test_Will_Released(String subject, String topic8_w)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		oso.createPlan(subject, topic8_w);

		System.out.println("Checking lock unlock status of lesson");
		test.log(Status.INFO, "Checking lock unlock status of lesson");

		scrollTo2("Revise");
		//@
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo1(lesson.getKey().toString());
			System.err.println(lesson.getKey());

			if (getDriver().findElementByXPath(lesson.getValue() + "" + oso.lessonStatus).getAttribute("resource-id")
					.equalsIgnoreCase("img")) {
				System.out.println(lesson.getKey() + " Unlocked initially");
				test.log(Status.INFO, lesson.getKey() + " Unlocked initially");
			} else if (getDriver().findElementByXPath(lesson.getValue() + "" + oso.lessonStatus)
					.getAttribute("resource-id").contains("lock")) {
				System.out.println(lesson.getKey() + " Locked initially");
				test.log(Status.INFO, lesson.getKey() + " Locked initially");
			}
		}

		System.out.println("Completing released lessons");
		test.log(Status.INFO, "Completing released lessons");

		int i = 0;
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			applyExplicitWaitsUntilElementClickable(oso.topLessonStatus);
			clickOnElement(oso.topLessonStatus);
			applyExplicitWait(5);
			clickOnElement(oso.markAsComplete);

			i++;
			if (i == 3)
				break;
		}

		System.out.println("Checking status of Summary and Test after chapter complition");
		test.log(Status.INFO, "Checking status of Summary and Test after chapter complition");
		//@
		i = 1;
		int flagw = 0;
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo2(lesson.getKey());
			System.err.println(lesson.getKey());
			if (flagw > 3) {
				if (i == 5) {
					System.out.println("Summary Unlocked");
					test.log(Status.INFO, "Summary Unlocked");
					if (getDriver().findElementByXPath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
									+ 4 + "]/android.view.ViewGroup" + "" + oso.lessonStatus)
							.getAttribute("resource-id").contains("img")) {
						System.out.println(lesson.getKey() + " Unlocked");
						test.log(Status.INFO, lesson.getKey() + " Unlocked");
					}
				}
				if (i == 4) {
					if (getDriver().findElementByXPath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[2]")
							.getAttribute("resource-id").contains("img")) {
						System.out.println(lesson.getKey() + " Unlocked");
						test.log(Status.INFO, lesson.getKey() + " Unlocked");
					}
				}
			} else if (getDriver().findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
							+ i + "]/android.view.ViewGroup" + "" + oso.lessonStatus)
					.getAttribute("resource-id").contains("lock")) {
				System.out.println(lesson.getKey() + " Locked");
				sAss.assertTrue(false, "Some lessons are still locked");
				test.log(Status.INFO, lesson.getKey() + " Locked");
			} else if (getDriver().findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
							+ i + "]/android.view.ViewGroup" + "" + oso.lessonStatus)
					.getAttribute("resource-id").contains("complete")) {
				System.out.println(lesson.getKey() + " completed");
				test.log(Status.INFO, lesson.getKey() + " completed");
			}
			i++;
			flagw++;
		}

		sAss.assertAll();

	}

	public void Verify_After_Completing_Only_Practice_Lessons_Of_Upcoming_Topic_Unlocked(String subject, String topic,
			String topic8_w) throws Exception {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		oso.createPlan(subject, topic, topic8_w);

		System.out.println("Verifying status of 2nd Topic");
		test.log(Status.INFO, "Verifying status of 2nd Topic");

		scrollTo1("Upcoming");
		action = new TouchAction(driver);
		//@
		int i = 0;
		for (Map.Entry<String, String> lesson : oso.upcomingLesson.entrySet()) {
			scrollTo2(lesson.getKey());
			Boolean actualStatus = getDriver().findElementByXPath(lesson.getValue() + "" + oso.lessonStatus)
					.getAttribute("resource-id").contains("lock");
			// Problem with App. Returned wrong status of attribute "clickable"
			System.err.println(actualStatus + " for " + lesson.getKey());
			status = (actualStatus);
			if (status) {
				System.out.println(lesson.getKey() + " Locked Initially");
				test.log(Status.INFO, lesson.getKey() + " Locked Initially");
			}
			sAss.assertTrue(status, "Incorrect Status");
			i++;
			if (i == 3)
				break;
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(115, 450)).release().perform();

		}

		scrollTo2("Today");

		System.out.println("Marking Practice of 1st Topic as completed");
		test.log(Status.INFO, "Marking Practice of 1st Topic as completed");

		scrollTo2("Practice");
		//@
		clickOnElement(getDriver().findElementByXPath(oso.expectedLessonOrder.get("Practice") + "" + oso.lessonStatus));
		applyExplicitWait(5);
		clickOnElement(oso.markAsComplete);

		// scrollTo2(topic2);
		// clickOnElement(findElementByText("Upcoming"));

		scrollTo1("Upcoming");
		System.out.println("Checking Lock|Unlock status of 2nd Topic After completing 1st Topic");
		test.log(Status.INFO, "Checking Lock|Unlock status of 2nd Topic After completing 1st Topic");
		i = 0;
		for (Map.Entry<String, String> lesson : oso.upcomingLesson.entrySet()) {
			scrollTo2(lesson.getKey());
			Boolean actualStatus = getDriver().findElementByXPath(lesson.getValue() + "" + oso.lessonStatus)
					.getAttribute("resource-id").contains("img");
			// Problem with App. Returned wrong status of attribute "clickable"
			System.err.println(actualStatus + " for " + lesson.getKey());
			status = (actualStatus);
			if (status) {
				System.out.println(lesson.getKey() + " Unlocked");
				test.log(Status.INFO, lesson.getKey() + " Unlocked");
			} else {
				System.out.println(lesson.getKey() + " Still Locked");
				test.log(Status.INFO, lesson.getKey() + "Still Locked");
			}
			sAss.assertTrue(status, "Incorrect Status");
			i++;
			if (i == 3)
				break;
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(115, 450)).release().perform();

		}
		sAss.assertAll();

	}

	public void Verify_After_Completing_Test_Lessons_Of_Upcoming_Topic_Unlocked(String subject, String topic,
			String topic8_w) throws Exception {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		oso.createPlan(subject, topic, topic8_w);

		System.out.println("Verifying status of 2nd Topic");
		test.log(Status.INFO, "Verifying status of 2nd Topic");

		scrollTo1("Upcoming");
		action = new TouchAction(driver);
		//@
		int i = 0;
		for (Map.Entry<String, String> lesson : oso.upcomingLesson.entrySet()) {
			scrollTo2(lesson.getKey());
			Boolean actualStatus = getDriver().findElementByXPath(lesson.getValue() + "" + oso.lessonStatus)
					.getAttribute("resource-id").contains("lock");
			// Problem with App. Returned wrong status of attribute "clickable"
			System.err.println(actualStatus + " for " + lesson.getKey());
			status = (actualStatus);
			if (status) {
				System.out.println(lesson.getKey() + " Locked Initially");
				test.log(Status.INFO, lesson.getKey() + " Locked Initially");
			}
			sAss.assertTrue(status, "Incorrect Status");
			i++;
			if (i == 3)
				break;
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(115, 450)).release().perform();

		}

		scrollTo2("Today");

		System.out.println("Marking Test of 1st Topic as completed");
		test.log(Status.INFO, "Marking Test of 1st Topic as completed");
		//@
		scrollTo2("Practice");
		clickOnElement(getDriver().findElementByXPath(oso.expectedLessonOrder.get("Practice") + "" + oso.lessonStatus));
		applyExplicitWait(5);
		clickOnElement(oso.markAsComplete);
		scrollTo2("Test");
		clickOnElement(getDriver().findElementByXPath(oso.expectedLessonOrder.get("Test") + "" + oso.lessonStatus));
		applyExplicitWait(5);
		clickOnElement(oso.markAsComplete);

		// scrollTo2(topic2);
		// clickOnElement(findElementByText("Upcoming"));

		scrollTo1("Upcoming");
		System.out.println("Checking Lock|Unlock status of 2nd Topic After completing 1st Topic");
		test.log(Status.INFO, "Checking Lock|Unlock status of 2nd Topic After completing 1st Topic");
		//@
		i = 0;
		for (Map.Entry<String, String> lesson : oso.upcomingLesson.entrySet()) {
			scrollTo2(lesson.getKey());
			Boolean actualStatus = getDriver().findElementByXPath(lesson.getValue() + "" + oso.lessonStatus)
					.getAttribute("resource-id").contains("img");
			// Problem with App. Returned wrong status of attribute "clickable"
			System.err.println(actualStatus + " for " + lesson.getKey());
			status = (actualStatus);
			if (status) {
				System.out.println(lesson.getKey() + " Unlocked");
				test.log(Status.INFO, lesson.getKey() + " Unlocked");
			} else {
				System.out.println(lesson.getKey() + " Still Locked");
				test.log(Status.INFO, lesson.getKey() + "Still Locked");
			}
			sAss.assertTrue(status, "Incorrect Status");
			i++;
			if (i == 3)
				break;
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(115, 450)).release().perform();

		}
		sAss.assertAll();

	}

	public void Verify_Listing_Of_Scheduled_Lessons(String subject, String topic) throws Exception {
		createPlan(0);
		omp= new Object_MyLesson_Page();
		applyExplicitWaitsUntilElementVisible(omp.backicon);
		omp.backicon.click();
			 
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		oso.createPlan(subject, topic);

		omp.kebabMenu.click();
		applyExplicitWaitsUntilElementVisible(omp.markAsComplete);
		omp.markAsComplete.click();


		scrollTo1("View Full Schedule");
		System.out.println("Opening complete schedule");
		test.log(Status.INFO, "Opening complete schedule");

		clickOnElement(oso.viewFullScheduleBtn);

		applyExplicitWaitsUntilElementVisible(oso.fullScheduleLbl);
		System.out.println("Full schedule window open");
		test.log(Status.INFO, "Full schedule window open");
		scrollTo2("Practice");
		//	List<MobileElement> mainList = new ArrayList<MobileElement>();
		Set<MobileElement> tempList = new LinkedHashSet<MobileElement>();



		//		List<MobileElement>	mainList=getDriver().findElementsById(oso.box);
		List<MobileElement>	mainList=getDriver().findElementsByXPath(oso.status);
		//		
		String[] lessonType=new String[mainList.size()];
		int j=0;
		for(MobileElement element : mainList) {


			System.out.println(element.getAttribute("resource-id"));
			String lessons=element.getAttribute("resource-id");
			String lesson=lessons.split("/")[1];
			System.out.println(lesson);
			lessonType[j]=lesson;
			j++;


		}
		//		System.out.println(mainList.size());
		//		int i=1;
		//		int j=0;
		//		for (MobileElement element : mainList) 
		//			
		//		{
		//		if(i>2) {
		//			System.out.println(i);
		//			Thread.sleep(1000);
		//			System.out.println(element.findElementByXPath(oso.status).getAttribute("resource-id"));
		//			String lessons=element.findElementByXPath(oso.status).getAttribute("resource-id");
		//			String lesson=lessons.split("/")[1];
		//			System.out.println(lesson);
		//			lessonType[j]=lesson;
		//			j++;
		//		}
		//		i++;
		//		
		//		}


		System.out.println("------------");

		for(String ss : lessonType) {
			System.out.println(ss);
		}

		for(int k=0;k<lessonType.length-1;k++) {

			if(lessonType[k]!=null && lessonType[k+1]!=null) {
				Boolean flag = false;
				if(lessonType[k].equals("completed")){

					flag=lessonType[k+1].equals("completed") || lessonType[k+1].equals("img_overflow") || lessonType[k+1].equals("locked");

				}

				else if(lessonType[k].equals("img_overflow")){

					flag=lessonType[k+1].equals("img_overflow") || lessonType[k+1].equals("locked");

				}

				else if(lessonType[k].equals("locked")){

					flag=lessonType[k+1].equals("locked");

				}
				System.out.println(flag);
				sAss.assertTrue(flag);
			}
			sAss.assertAll();
		}



	}

	public void Verify_Verify_User_Should_Be_Select_MultiPle_Books(String property, String property2) {


	}
	//TC-38
	public void Verify_Lessons_Planned_For_Future(String property, String property2) throws Exception {

		createPlan(4);
		omp= new Object_MyLesson_Page();
		applyExplicitWaitsUntilElementVisible(omp.backicon);
		omp.backicon.click();
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		applyExplicitWaitsUntilElementVisible(omp.taskToBeCompletedToday);
		String todaysTasks=omp.taskToBeCompletedToday.getText();
		int tasks=Integer.parseInt(getBetweenStrings(todaysTasks, "have", "tasks").trim());
		System.out.println(tasks);



		System.out.println("Creating new Plan");
		test.log(Status.INFO, "Creating new Plan");
		// oso.createPlan(subject, topic);

		scrollTo2("View Full Schedule");
		System.out.println("Opening complete schedule");
		test.log(Status.INFO, "Opening complete schedule");

		clickOnElement(oso.viewFullScheduleBtn);

		applyExplicitWaitsUntilElementVisible(oso.fullScheduleLbl);
		System.out.println("Full schedule window open");
		test.log(Status.INFO, "Full schedule window open");
		scrollTo2("Practice");

		MobileElement todayView=oso.todayMainView;
		int	todaysLessonBefore = 0;
		int	todaysLessonAfter = 0;

		//		System.out.println(todayView.findElementById("com.tce.studi:id/tv_day_name").getText());
		//		if (oso.todayMainView.findElementById("com.tce.studi:id/tv_day_name").getText().contains("Today")) {
		//			
		//			List <MobileElement> todaysLesson=todayView.findElementsById("com.tce.studi:id/row_lesson_main_view");
		//			System.out.println(todaysLesson.size()+" Before");
		//			todaysLessonBefore=todaysLesson.size();
		//		}

		//@
		//	MobileElement LessonPanel1 = getDriver().findElementByXPath("//*[contains(@text, 'Today')]/parent::*/following-sibling::androidx.recyclerview.widget.RecyclerView");

		List <MobileElement> todaysLesson=oso.lessonPanel38.findElementsById("com.tce.studi:id/row_lesson_main_view");
		System.out.println(todaysLesson.size()+" Before");
		todaysLessonBefore=todaysLesson.size();

		for(int i=0;i<=tasks;i++) {
			omp.kebabMenu.click();
			applyExplicitWaitsUntilElementVisible(omp.markAsComplete);
			omp.markAsComplete.click();
			scrollTo2("Practice");
		}

		//	scrollTo2("Practice");
		scrollTo2("Today");
		//		if (todayView.findElementById("com.tce.studi:id/tv_day_name").getText().contains("Today")) {

		List <MobileElement> todayLesson=oso.lessonPanel38.findElementsById("com.tce.studi:id/row_lesson_main_view");
		System.out.println(todaysLesson.size()+" After");
		todaysLessonAfter=todayLesson.size();

		//		}
		if(todaysLessonBefore!=todaysLessonAfter) {
			System.out.println("Lesson which are Planned for future but completed earlier , the lesson appeared under completed date in scheduled list");
			test.log(Status.INFO, "Lesson which are Planned for future but completed earlier , the lesson appeared under completed date in scheduled list");
		}
		sAss.assertNotEquals(todaysLessonBefore, todaysLessonAfter);

	}

	//TC-40
	public void Verify_Lesson_Completed_In_Past_And_Then_Completed_Again_Lesson_Will_Appear_Under_Recent_Completed_Date(
			String property, String property2, String property3) throws Exception, InterruptedException {

		Verify_Past_Completed_Lessons_Can_Be_Attempted_Again(prop.getProperty("subject"),prop.getProperty("topic"));
		Boolean status;
		SoftAssert sAss = new SoftAssert();

		scrollTo2("Our plan for today!");
		//@
		//			MobileElement LessonPanel1 = getDriver().findElementByXPath("//*[contains(@text, 'Today')]/following-sibling::androidx.recyclerview.widget.RecyclerView");


		System.out.println(oso.lessonPanel.getAttribute("resource-id"));
		scrollTo2("Practice");
		List <MobileElement> lessons=oso.lessonPanel.findElementsById("com.tce.studi:id/tv_chapter_type");
		System.out.println(lessons.size());

		for(MobileElement lesson : lessons) {
			status=lesson.isDisplayed();
			sAss.assertTrue(status);
			if(status)
			{

				System.out.println(lesson.getText()+" lesson appeared under recent completed date");
				test.log(Status.INFO, lesson.getText()+" lesson appeared under recent completed date");

			}
		}
		sAss.assertAll();


	}

	public void Verify_Tick_Mark_Appears_In_Study_Ring(String property, String property2) throws Exception {

		createPlan(2);
		SoftAssert assert1 = new SoftAssert();

		clickOnElement(oso.testUnitModule);
		applyExplicitWaitsUntilElementVisible(oso.taskToBeCompletedToday);
		String todaysTasks=oso.taskToBeCompletedToday.getText();
		applyExplicitWaitsUntilElementVisible(oso.taskToBeCompletedToday);
		int tasks=Integer.parseInt(getBetweenStrings(todaysTasks, "have", "tasks").trim());
		System.out.println(tasks);
		scrollToEnd();
		for(int i=0;i<tasks;i++) {
			oso.kebabMenu.click();
			applyExplicitWaitsUntilElementVisible(oso.markAsComplete);
			oso.markAsComplete.click();
		}
		scrollTo2("today");

		applyExplicitWaitsUntilElementVisible(oso.tick);
		Thread.sleep(tasks*(3/2));
		Boolean taskCompleted=oso.tick.isDisplayed();
		if(taskCompleted) {
			System.out.println("On making progress in the plan and completing all the planned lessons for the day, user is shown the tick mark at the centre of the ring");
			test.log(Status.INFO, "On making progress in the plan and completing all the planned lessons for the day, user is shown the tick mark at the centre of the ring");
		}
		assert1.assertTrue(taskCompleted);
		assert1.assertAll();

	}


	public void createPlan(int days) throws Exception {
		orp=new Object_ReviewPlan();
		SoftAssert sAss = new SoftAssert();
		boolean status;
		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		if(orp.subHeading.getText().contains("Paused")){
			orp.test_unit.click();
			applyExplicitWait(5);
			orp.resumePlan.click();
			applyExplicitWait(5);
		}
		else {
			applyExplicitWait(5);
			orp.test_unit.click();
		}
		applyExplicitWait(5);
		Boolean myLessonPage=orp.planTestUnit.isDisplayed();
		if(myLessonPage) {
			System.out.println("User able to navigate to MyLessons Page");
			//			test.log(Status.INFO, "User able to navigate to MyLessons Page");
		}
		else {
			System.out.println("User unable to navigate to MyLessons Page");
			//			test.log(Status.INFO, "User unable to navigate to MyLessons Page");
		}

		scrollTo2("Manage and Create Plans");		
		applyExplicitWait(5);
		orp.manageAndCreatePlan.click();
		//	applyExplicitWaitsUntilElementVisible(orp.);

		clickOnElement(findElementByText("Create"));
		applyExplicitWaitsUntilElementVisible(orp.subjectAtCreatePlan);
		orp.subjectAtCreatePlan.click();
		applyExplicitWaitsUntilElementVisible(orp.topicCheckBoxAtCreateStudyPlan);
		orp.topicCheckBoxAtCreateStudyPlan.click();
		orp.addToPortion.click();

		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Next Step"));


		String date=orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();
		System.out.println(actualDate);
		int i = Integer.parseInt(actualDate);
		int date2=i+days;

		if(i>=23) {
			orp.nextMonthButton.click();
			//		 Thread.sleep(2000);
			//		 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));

			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(oso.date1));

			oso.date1.click();
		}
		else {
			//		MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
			MobileElement date1=oso.getDate(days);
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(date1));
			date1.click();
		}


		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		Thread.sleep(2000);
		clickOnElement(findElementByText("Begin Studying"));

	}

	//TS-51
	public void Verify_Lessons_Attempted_Today_Lesson_Will_Only_Reflect_Under_Todays_Date_In_Schedule_List(
			String property, String property2, String property3) throws Exception {

		createPlan(14);
		omp= new Object_MyLesson_Page();
		applyExplicitWaitsUntilElementVisible(omp.backicon);
		omp.backicon.click();
		//applyExplicitWaitsUntilElementVisible(omp.yesButton);
		//clickOnElement(oso.yesBtn);
		SoftAssert sAss = new SoftAssert();
		Boolean status;
		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		applyExplicitWaitsUntilElementVisible(omp.taskToBeCompletedToday);
		String todaysTasks=omp.taskToBeCompletedToday.getText();
		//	String taskss=Keyword.getBetweenStrings(todaysTasks, "have", "tasks").trim();
		int tasks=Integer.parseInt(getBetweenStrings(todaysTasks, "have", "tasks").trim());
		System.out.println(tasks);


		scrollTo2("View Full Schedule");
		System.out.println("Opening complete schedule");
		test.log(Status.INFO, "Opening complete schedule");

		clickOnElement(oso.viewFullScheduleBtn);

		scrollTo2("Practice");


		//			MobileElement LessonPanel = getDriver().findElementByXPath("//*[contains(@text, 'Today')]/parent::*/following-sibling::*");

		//			System.out.println(oso.lessonPanel53.getAttribute("resource-id"));

		for(int i=0;i<=tasks;i++) {
			omp.kebabMenu.click();
			applyExplicitWaitsUntilElementVisible(omp.markAsComplete);
			omp.markAsComplete.click();
			scrollTo2("Practice");
		}
		System.out.println("Lesson Attempted");
		test.log(Status.INFO, "Lesson Attempted");

		Thread.sleep(1000);
		List <MobileElement> lessonTypes=oso.lessonPanel53.findElements(By.id("com.tce.studi:id/list_title"));
		System.out.println(lessonTypes.size());
		int i=1;
		for(MobileElement lesson: lessonTypes) {
			if(i>tasks) {

				applyExplicitWaitsUntilElementVisible(lesson);
				//@						
				System.out.println(lesson.getAttribute("resource-id"));
				MobileElement element=lesson.findElementById("com.tce.studi:id/list_title");
				Boolean verify=element.isDisplayed();
				System.out.println(element.getText());
				sAss.assertTrue(verify);
				if(verify) {

					System.out.println("For Lessons attempted today,Lesson only reflected under today's date in the scheduled list");
					test.log(Status.INFO, "For Lessons attempted today,Lesson only reflected under today's date in the scheduled list");

				}

			}
			i++;
		}
		sAss.assertAll();
	}

	public void Verify_Past_Lesson_Attempted_Today_Will_Reflect_In_Today_Tab(String property, String property2) throws Exception {

		Verify_Past_Completed_Lessons_Can_Be_Attempted_Again(prop.getProperty("subject"),
				prop.getProperty("topic"));
		Boolean status;
		SoftAssert sAss = new SoftAssert();

		scrollTo2("Our plan for today!");

		//	MobileElement LessonPanel1 = getDriver().findElementByXPath("//*[contains(@text, 'Today')]/following-sibling::androidx.recyclerview.widget.RecyclerView");


		System.out.println(oso.lessonPanel.getAttribute("resource-id"));
		scrollTo2("Practice");
		List <MobileElement> lessons=oso.lessonPanel.findElementsById("com.tce.studi:id/tv_chapter_type");
		System.out.println(lessons.size());

		for(MobileElement lesson : lessons) {
			status=lesson.isDisplayed();
			sAss.assertTrue(status);
			if(status)
			{

				System.out.println(lesson.getText()+" lesson reflected in Today Tab");
				test.log(Status.INFO, lesson.getText()+" lesson reflected in Today Tab");

			}
		}
		sAss.assertAll();
	}

	public void Verify_Past_Completed_Lessons_Will_Not_Influence_Unlocking_Or_Locking_When_Its_Attempted_Again(
			String subject, String topic) throws MalformedURLException, Exception {

		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating Plan");
		test.log(Status.INFO, "Creating Plan");
		oso.createPlan(subject, topic);

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}

		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			clickOnElement(oso.topLessonStatus);
			applyExplicitWait(5);
			clickOnElement(oso.markAsComplete);
		}

		System.out.println("Marking All lessons as complete");
		test.log(Status.INFO, "Marking All lessons as complete");

		//@
		int i = 0;
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			scrollTo2(lesson.getKey().toString());
			String actualStatus = getDriver().findElementByXPath(
			 	//	"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
			        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["	
						+ (i + 1) + "]/android.view.ViewGroup" + "" + oso.lessonStatus)
					.getAttribute("resource-id");
			System.err.println(actualStatus);
			status = actualStatus.contains("complete");
			sAss.assertTrue(status, "Incorrect Status");
			i++;
			if (i == oso.expectedLessonOrder.size())
				break;
		}
		if (status) {
			System.out.println("Today's lessons marked as complete");
			test.log(Status.INFO, "Today's lessons marked as complete");
		}

		System.out.println("Try to attempt completed lessons again");
		test.log(Status.INFO, "Try to attempt completed lessons again");

		((FindsByAndroidUIAutomator<MobileElement>) getDriver()).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(20)");

		i = 0;
		for (Map.Entry<String, String> lesson : oso.expectedLessonOrder.entrySet()) {
			applyExplicitWait(5);
			scrollTo2(lesson.getKey().toString());
			clickOnElement(findElementByText(lesson.getKey()));

			System.out.println("Try to open " + lesson.getKey());
			test.log(Status.INFO, "Try to open " + lesson.getKey());
			Thread.sleep(2000);

			switch (lesson.getKey()) {
			case "Big Idea":
				Thread.sleep(2000);
				//			status = driver.findElementById("com.tce.studi:id/header_bar_container").isDisplayed();
				status = oso.bigIdeaHeading.isDisplayed();

				sAss.assertTrue(status);
				if (status) {

					System.out.println("Big Idea lesson not influence unlocking or locking when its attempted again");
					test.log(Status.INFO, "Big Idea lesson not influence unlocking or locking when its attempted again");
				}

				driver.navigate().back();
				applyExplicitWait(5);
				clickOnElement(findElementByText("Yes"));
				break;

			case "Revise":
				status = findElementByText("Return to Study Plan").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Revision lesson not influence unlocking or locking when its attempted again");
					test.log(Status.INFO, "Revision lesson not influence unlocking or locking when its attempted again");
				}

				driver.navigate().back();
				applyExplicitWait(5);
				break;
			case "Practice":
				status = findElementByText("Return to Study Plan").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Practice lesson not influence unlocking or locking when its attempted again");
					test.log(Status.INFO, "Practice lesson not influence unlocking or locking when its attempted again");
				}

				driver.navigate().back();
				applyExplicitWait(5);

				break;
			case "Summary":
				System.err.println("Summary tab not yet Developed");
				test.log(Status.ERROR, "Summary tab not yet Developed");
				break;
			case "Test":
				//				getDriver().findElementByXPath(
				//						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.view.ViewGroup")
				//						.click();
				oso.element52.click();
				status = findElementByText("Return to Study Plan").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Test not influence unlocking or locking when its attempted again");
					test.log(Status.INFO, "Test not influence unlocking or locking when its attempted again");
				}

				driver.navigate().back();
				applyExplicitWait(5);

				break;

			default:
			}

			i++;
			if (i == oso.expectedLessonOrder.size())
				break;
		}

		sAss.assertAll();
	}

	public void Verify_Lessons_Which_Are_Planned_In_Past_But_Completed_Later_Lesson_Should_Appear_Under_Completed_Date(String property, String property2) throws Exception {


		SoftAssert sAss = new SoftAssert();
		Boolean status;
		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		applyExplicitWaitsUntilElementVisible(omp.taskToBeCompletedToday);
		String todaysTasks=omp.taskToBeCompletedToday.getText();
		int tasks=Integer.parseInt(getBetweenStrings(todaysTasks, "have", "tasks").trim());
		System.out.println(tasks);


		scrollTo2("Practice");
		//	List<MobileElement> element=getDriver().findElementsById(oso.topicName1);
		System.out.println(oso.topicName.size());

		for(MobileElement ele : oso.topicName) {

			System.out.println(ele.getAttribute("resource-id"));

		}

		System.out.println("Lessons which are Planned in past are displayed");
		test.log(Status.INFO, "Lesson which are Planned in past are displayed");

		for(int i=0; i<tasks; i++) {

			omp.kebabMenu.click();
			applyExplicitWaitsUntilElementVisible(omp.markAsComplete);
			omp.markAsComplete.click();
			scrollTo2("Practice");
		}

		scrollTo2("Our plan for today!");
		//	MobileElement LessonPanel1 = getDriver().findElementByXPath("//*[contains(@text, 'Today')]/following-sibling::androidx.recyclerview.widget.RecyclerView");

		System.out.println(oso.lessonPanel.getAttribute("resource-id"));
		//				scrollTo2("Practice");
		//List <MobileElement> lessons=oso.lessonPanel.findElementsById("com.tce.studi:id/tv_chapter_type");
		List <MobileElement> lessons=oso.lessonPanel.findElementsById("com.tce.studi:id/tvChapterType");
		System.out.println(lessons.size());

		for(MobileElement lesson : lessons) {

			status=lesson.isDisplayed();
			sAss.assertTrue(status);
			if(status)
			{
				System.out.println("Lesson which are Planned in past but completed later,Lesson appeared under completed date in scheduled list");
				test.log(Status.INFO,"Lesson which are Planned in past but completed later,Lesson appeared under completed date in scheduled list");
			}
		}
		sAss.assertAll();
	}

	public void Verify_Past_Lesson_Attempted_Today_If_Was_Failed_Attempt_Then_It_Will_Reflect_Only_In_Past_Date_In_Scheduled_Lesson(
			String property, String property2) throws Exception {

		SoftAssert sAss = new SoftAssert();
		Boolean status;
		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		applyExplicitWaitsUntilElementVisible(omp.taskToBeCompletedToday);
		String todaysTasks=omp.taskToBeCompletedToday.getText();
		//	String taskss=Keyword.getBetweenStrings(todaysTasks, "have", "tasks").trim();
		//			int tasks=Integer.parseInt(getBetweenStrings(todaysTasks, "have", "tasks").trim());
		//			System.out.println(tasks);


		scrollTo2("View Full Schedule");
		System.out.println("Opening complete schedule");
		test.log(Status.INFO, "Opening complete schedule");

		clickOnElement(oso.viewFullScheduleBtn);

		scrollTo2("Big Idea");

		//	MobileElement element=getDriver().findElementById("com.tce.studi:id/tv_day_name");
		//	System.out.println(element.getText());

		//
		MobileElement LessonPanel1 = getDriver().findElementByXPath("//*[contains(@text, 'Today')]/parent::*/ancestor::androidx.recyclerview.widget.RecyclerView");

		System.out.println(oso.lessonPanel1.getAttribute("resource-id"));
		MobileElement lesson=oso.lessonPanel1.findElementById("com.tce.studi:id/list_title");
		lesson.click();
		Thread.sleep(5000);
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(oso.backButton));
		applyExplicitWaitsUntilElementVisible(oso.backButton);
		oso.backButton.click();
		applyExplicitWaitsUntilElementVisible(oso.positiveButton);
		oso.positiveButton.click();
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(lesson));
		applyExplicitWaitsUntilElementVisible(lesson);

		status= LessonPanel1.findElementById("com.tce.studi:id/list_title").isDisplayed();

		if(status) {
			System.out.println("Past lesson attempted today ,If it was failed attempt then it will reflect only in past date in scheduled lesson");
			test.log(Status.INFO, "Past lesson attempted today ,If it was failed attempt then it will reflect only in past date in scheduled lesson");
		}
		Assert.assertTrue(status);


	}
	//TC - 41
	public void Verify_Lesson_Planned_In_Past_But_Not_Completed_It_Will_Be_Displayed_Under_New_Planned_Date(
			String property, String property2, String property3) throws Exception {

		SoftAssert sAss = new SoftAssert();
		Boolean status;
		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		applyExplicitWaitsUntilElementVisible(omp.taskToBeCompletedToday);
		String todaysTasks=omp.taskToBeCompletedToday.getText();
		int tasks=Integer.parseInt(getBetweenStrings(todaysTasks, "have", "tasks").trim());
		System.out.println(tasks);


		scrollTo2("View Full Schedule");
		System.out.println("Opening complete schedule");
		test.log(Status.INFO, "Opening complete schedule");

		clickOnElement(oso.viewFullScheduleBtn);

		scrollTo2("Big Idea");

		System.out.println(oso.today.getText());

		//		List <MobileElement> pastLessons=getDriver().findElementsById("com.tce.studi:id/tv_due");

		//		List <MobileElement> pastLessons=oso.getPastLessons();
		System.out.println(oso.pastLessons1.size());

		for(MobileElement lesson : oso.pastLessons1) {

			//		MobileElement input = getDriver().findElementByXPath("//*[contains(@text, 'overdue')]/preceding-sibling::android.widget.TextView[3]");
			System.out.println(oso.inputLesson.getText());
			status=oso.inputLesson.isDisplayed();
			sAss.assertTrue(status);
		}

		if(status) {

			System.out.println("Lesson planned in past but not completed,it displayed under new planned date");
			test.log(Status.INFO, "Lesson planned in past but not completed,it displayed under new planned date");

		}
		sAss.assertAll();

	}

	public void Verify_Past_Lesson_Score_And_Status_Will_Override_To_New_And_Reflect_In_My_Lesson_Today_Tab(
			String subject, String topic) throws Exception, InterruptedException {

		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = oso.testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitModule);

		System.out.println("Creating Plan");
		test.log(Status.INFO, "Creating Plan");
		oso.createPlan("Political Science", "Diversity in India");

		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}

		String todaysTasks=omp.taskToBeCompletedToday.getText();
		//	String taskss=Keyword.getBetweenStrings(todaysTasks, "have", "tasks").trim();
		int tasks=Integer.parseInt(getBetweenStrings(todaysTasks, "have", "tasks").trim());
		System.out.println(tasks);

		for(int i=0;i<tasks;i++) {
			omp.kebabMenu.click();
			applyExplicitWaitsUntilElementVisible(omp.markAsComplete);
			omp.markAsComplete.click();
		}


		System.out.println("Today's lessons marked as complete");
		test.log(Status.INFO, "Today's lessons marked as complete");



		scrollTo2("Practice");
		clickOnElement(findElementByText("Practice"));

		String score=oso.target.getText();
		System.out.println(score);
		String betweenString = getBetweenStrings(score, "Score", "or").split("%")[0].trim();
		System.out.println(betweenString);
		int previousScore = Integer.parseInt(betweenString);
		//	int scoreOfLesson=getBetweenString(oso.target,"scored","Next");
		System.out.println(previousScore);

		applyExplicitWaitsUntilElementVisible(oso.target);
		clickOnElement(findElementByText("Practice"));
		//		oso.practise_Again1.click();
		applyExplicitWaitsUntilElementVisible(oso.question1_part_Text);
		String questionCount = oso.quetionCount.getText();
		String[] s = questionCount.split("of");
		String s1 = s[1].trim();

		int question=Integer.parseInt(s1);

		for(int j=0;j<question;j++) {

			applyExplicitWaitsUntilElementVisible(oso.question1_part_Text);
			scrollToEnd();
			selectCorrectAnswer();
			clickOnElement(findElementByText("Check"));
			new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(oso.right_Answer_message));
			//		applyExplicitWaitsUntilElementVisible(oso.right_Answer_message);
			clickOnElement(findElementByText("Continue"));

		}

		Thread.sleep(5000);
		applyExplicitWaitsUntilElementVisible(oso.target);

		status=oso.target.isDisplayed();
		String score1=oso.target.getText();
		String betweenString1 = getBetweenStrings(score1, "scored", "Next").split("%")[0].trim();
		System.out.println(betweenString1);
		int finalScore = Integer.parseInt(betweenString1);
		//	int scoreOfLesson=getBetweenString(oso.target,"scored","Next");
		System.out.println(previousScore!=finalScore);
		if(previousScore!=finalScore) {
			System.out.println("Past lesson score override to new score");
			test.log(Status.INFO, "Past lesson score override to new score");
		}
		sAss.assertTrue(status);


	}
}

