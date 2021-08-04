package studi.co.pageModules;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;

import studi.co.pageObjects.Object_Study_Plan_Create_Plan;

public class Module_Studya_plan_Create_plan  extends BaseClass{
	Object_Study_Plan_Create_Plan ospcp = new Object_Study_Plan_Create_Plan();
	SoftAssert assert1=new SoftAssert();
	Boolean status;
	public void To_Verify_user_is_able_to_unflag_Book_for_which_the_user_dont_wants_to_pay_extra_attention(String subject,String topic) {
		SoftAssert assert1 = new SoftAssert();
		Boolean status;

		status = ospcp .profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		System.out.println("Clicking on Test Unit Module");
		clickOnElement(ospcp .testUnitModule);
		scrollTo2("Create");

		clickOnElement(ospcp .managePlanBtn);
		System.out.println("Clicked on Manage and Create plan Tab");

		status = ospcp .createStudyPlanBtn.isDisplayed();

		assert1.assertTrue(status);
		if (status) {
			System.out.println("Create Study Plan option shown on landing page");
			test.log(Status.INFO, "Create Study Plan option shown on landing page");
		}

		System.out.println("Clicking on Create a Study Plan");
		test.log(Status.INFO, "Clicking on Create a Study Plan");
		clickOnElement(ospcp .createStudyPlanBtn);
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Create Study Plan button is tappable");
		test.log(Status.INFO, "Create Study Plan button is tappable");
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Subject list displayed to select portion");
		test.log(Status.INFO, "Subject list displayed to select portion");

		assert1.assertTrue(status);
		if (status) {
			System.out.println("Instruction to select Book in the bookshelf page Displayed");
			test.log(Status.INFO, "Instruction to select Book in the bookshelf page Displayed");
		}

		create_plan(subject, topic);
		clickOnElement(findElementByText("Add to portion"));

		if (status) {
			System.out.println("Clicked on Add to Portion");
			test.log(Status.INFO, "Clicked on Add to Portion");
		}

		applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));

		clickOnElement(findElementByText("Next Step"));
		if (status) {
			System.out.println("Clicked on Next Step on Create Study Plan");
			test.log(Status.INFO, "Clicked on Next Step on Create Study Plan");
		}
		System.out.println("Moving to \"Pay Extra Attention\" Window");
		test.log(Status.INFO, "Moving to \"Pay Extra Attention\" Window");
		System.out.println("Try to flag the Subject");
		test.log(Status.INFO, "Try to flag the Subject");
		applyExplicitWaitsUntilElementClickable(ospcp.getFlagIcon());
		clickOnElement(ospcp.getFlagIcon());
		// clickOnElement(findElementByText(subject));

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		status = Boolean.parseBoolean(ospcp.getFlagIcon().getAttribute("focused"));
		System.out.println("Flag focus : " + ospcp.getFlagIcon().getAttribute("focused"));
		if (status) {
			ospcp.subjectFlag.put(subject, true);
			System.out.println("User is Able to Select the Flag");
			test.log(Status.INFO, "User is Able to Select the Flag");
		}

		applyExplicitWaitsUntilElementClickable(ospcp.getFlagIcon());
		clickOnElement(ospcp.getFlagIcon());

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		status = Boolean.parseBoolean(ospcp.getFlagIcon().getAttribute("focused"));
		System.out.println("Flag focus : " + ospcp.getFlagIcon().getAttribute("focused"));
		if (status) {
			ospcp.subjectFlag.put(subject, false);
			System.out.println("User is Able to DeSelect the Flag");
			test.log(Status.INFO, "User is Able to DeSelect the Flag");
			System.out.println("User is able to unflag the Book for which the user don't wants to pay extra attention");
			test.log(Status.INFO, "User is able to unflag the Book for which the user don't wants to pay extra attention");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}
	public void To_Verify_user_is_able_create_another_study_plan(String subject, String topic) {
		SoftAssert assert1 = new SoftAssert();
		Boolean status;

		status = ospcp.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = ospcp.testUnitModule.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(ospcp.testUnitModule);
		scrollTo1("Manage and Create Plans");


		System.out.println("Clicking on Manage and Create Plans");
		test.log(Status.INFO, "Clicking on Manage and Create Plans");
		clickOnElement(ospcp.managePlanBtn);
		//create_plan(subject, topic);
		applyExplicitWaitsUntilElementClickable(ospcp.createStudyPlanBtn);
		System.out.println("Clicking on Study Plan");
		test.log(Status.INFO, "Clicking on Study Plan");
		clickOnElement(ospcp.plan_on_MyPlans);

		applyExplicitWaitsUntilElementClickable(ospcp.editPlan);
		System.out.println("Clicking on Edit Plan Button");
		test.log(Status.INFO, "Clicking on Edit Plan Button");
		applyExplicitWaitsUntilElementClickable(ospcp.editPlan);
		clickOnElement(ospcp.editPlan);
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//applyExplicitWaitsUntilElementClickable(ospcp.object44);

		applyExplicitWaitsUntilElementClickable(findElementByText("Portion"));

		clickOnElement(findElementByText("Portion"));

		applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));

		clickOnElement(findElementByText("Next Step"));

		System.out.println("Moving to \"Pay Extra Attention\" Window");
		test.log(Status.INFO, "Moving to \"Pay Extra Attention\" Window");

		System.out.println("Try to flag the Subject");
		test.log(Status.INFO, "Try to flag the Subject");

		applyExplicitWaitsUntilElementClickable(ospcp.getFlagIcon());
		clickOnElement(ospcp.getFlagIcon());
		// clickOnElement(findElementByText(subject));

		//Thread.sleep(500);

		status = Boolean.parseBoolean(ospcp.getFlagIcon().getAttribute("focused"));
		System.out.println("Flag focus : " + ospcp.getFlagIcon().getAttribute("focused"));
		if (status) {
			ospcp.subjectFlag.put(subject, true);
			System.out.println("User is Able to add Spaced Practice2 if parent practice is incomplete");
			test.log(Status.INFO, "User is Able to add Spaced Practice2 if parent practice is incomplete");
			applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));
		}
		clickOnElement(findElementByText("Next Step"));
		System.out.println("Started calender");
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				List<MobileElement> dates = driver.findElements(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.GridView/android.view.View["
								+ (i + 1) + "]/android.view.View[" + (j + 1) + "]"));
				for (MobileElement date : dates) {
					System.out.println(date.getText() + " " + date.getAttribute("focused"));
					if (date.getAttribute("focused").contains("true")) {
						date.click();
					}
				}
			}
		}
		try {
			applyExplicitWaitsUntilElementVisible(findElementByText("Next"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//clickOnElement(findElementByText("Continue"));


		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("User is able to create another study plan");
		test.log(Status.INFO, "User is able to create another study plan");

		assert1.assertAll();
	}
	public void To_Verify_user_is_able_to_see_previous_plan(String subject,String topic) {
		SoftAssert assert1 = new SoftAssert();
		Boolean status;
		status = ospcp.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		status = ospcp.testUnitModule.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(ospcp.testUnitModule);
		scrollTo1("Manage and Create Plans");
		System.out.println("Clicking on Manage and Create Plans");
		test.log(Status.INFO, "Clicking on Manage and Create Plans");
		clickOnElement(ospcp.managePlanBtn);
		applyExplicitWaitsUntilElementClickable(ospcp.createStudyPlanBtn);
		System.out.println("Clicking on Study Plan");
		test.log(Status.INFO, "Clicking on Study Plan");
		clickOnElement(ospcp.plan_on_MyPlans);

		applyExplicitWaitsUntilElementClickable(ospcp.editPlan);
		System.out.println("Clicking on Edit Plan Button");
		test.log(Status.INFO, "Clicking on Edit Plan Button");
		applyExplicitWaitsUntilElementClickable(ospcp.editPlan);
		clickOnElement(ospcp.editPlan);
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		applyExplicitWaitsUntilElementClickable(findElementByText("Portion"));
		clickOnElement(findElementByText("Portion"));
		applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));
		clickOnElement(findElementByText("Next Step"));

		System.out.println("Moving to \"Pay Extra Attention\" Window");
		test.log(Status.INFO, "Moving to \"Pay Extra Attention\" Window");

		System.out.println("Try to flag the Subject");
		test.log(Status.INFO, "Try to flag the Subject");

		applyExplicitWaitsUntilElementClickable(ospcp.getFlagIcon());
		clickOnElement(ospcp.getFlagIcon());
		status = Boolean.parseBoolean(ospcp.getFlagIcon().getAttribute("focused"));
		System.out.println("Flag focus : " + ospcp.getFlagIcon().getAttribute("focused"));
		if (status) {
			ospcp.subjectFlag.put(subject, true);
			System.out.println("User is Able to add Spaced Practice2 if parent practice is incomplete");
			test.log(Status.INFO, "User is Able to add Spaced Practice2 if parent practice is incomplete");
			applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));
		}
		clickOnElement(findElementByText("Next Step"));
		System.out.println("Started calender");
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				List<MobileElement> dates = driver.findElements(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.GridView/android.view.View["
								+ (i + 1) + "]/android.view.View[" + (j + 1) + "]"));
				for (MobileElement date : dates) {
					System.out.println(date.getText() + " " + date.getAttribute("focused"));
					if (date.getAttribute("focused").contains("true")) {
						date.click();
					}
				}
			}
		}
		try {
			applyExplicitWaitsUntilElementVisible(findElementByText("Next"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("User is able to see the previous plan");
		test.log(Status.INFO, "User is able to see the previous plan");
		assert1.assertAll();
	}

	public void create_plan(String subject,String topic)
	{
		System.err.println("Clicked on " + subject);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		System.err.println("Clicked on " + topic);
		scrollTo2(topic);
		clickOnElement(findElementByText(topic));
	}
}
