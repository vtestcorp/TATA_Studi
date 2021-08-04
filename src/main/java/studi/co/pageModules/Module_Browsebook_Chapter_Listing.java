package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Browsebook_Chapter_Listing;
import studi.co.pageObjects.Object_Syllabus_Section;

public class Module_Browsebook_Chapter_Listing extends BaseClass{
	Object_Browsebook_Chapter_Listing obcl=new Object_Browsebook_Chapter_Listing();

	public void to_verify_use_must_be_able_to_view_the_content_of_the_Chapter_Listing_page() throws Exception
	{
		SoftAssert assert1 = new SoftAssert();
		Object_Browsebook_Chapter_Listing obcl = new Object_Browsebook_Chapter_Listing();	
		String subject = "Political Science";
		String topic1 = "Diversity in India";
		obcl.syllabus.click();

		applyExplicitWait(5);
		scrollTo1(subject);
		clickOnElement(findElementByText(subject));
		test.log(Status.INFO, "Cilcked on "+subject+" subject");
		applyExplicitWait(5);

		action = new TouchAction(driver);
		List<MobileElement> chapters = getAllElementsFromPageUsingID("com.tce.studi:id/tvChapter");

		ArrayList<String> aa = new ArrayList<>(); 
		for (MobileElement mobileElement : chapters) {
			aa.add(mobileElement.getText().replaceAll("\\d", "").trim());
		}

		System.out.println("Chapters available in given subject are :");
		test.log(Status.INFO, "Chapters available in given subject are :");
		List<String> chaptersWD = new ArrayList<>(new HashSet<>(aa));
		chaptersWD.sort(Comparator.naturalOrder());

		System.out.println(chaptersWD.size());
		for (String chapter1 : chaptersWD) {
			test.log(Status.INFO, chapter1);
			System.out.println(chapter1);
			
		}
		//swipeTop();

		applyExplicitWait(5);
		scrollTo1(topic1);
		applyExplicitWait(5);
		List<MobileElement> list = getDriver().findElements(By.id("com.tce.studi:id/tvTopic")); 	
		System.out.println("Topics available in given chapter are :");
		System.out.println(list.size());
		int i=1;
		for (MobileElement topic : list) {
			assert1.assertTrue(topic.isDisplayed());
			test.log(Status.INFO, "Topic "+i+" is Displayed");
			System.out.println(topic.getText());
			i++;
		}
		
		
		assert1.assertAll();
	}

	public void to_verify_use_must_be_able_to_view_the_details_of_the_chapters(String subject, String chapter1) throws Exception {

		SoftAssert assert1 = new SoftAssert();
		obcl = new Object_Browsebook_Chapter_Listing();
		Boolean status = obcl.userName.isDisplayed();
		if(status) {
			System.out.println("User can be navigated to the Home page after login");
			test.log(Status.INFO, "User can be navigated to the Home page after login");
		}

		assert1.assertTrue(status);

		status = obcl.syllabus.isDisplayed();

		if (status) {
			System.out.println("Syllabus tab is shown to the user on Home Page");
			test.log(Status.INFO, "Syllabus tab is shown to the user on Home Page");
		}
		assert1.assertTrue(status);
		obcl.syllabus.click();
		System.out.println("Books showing to user");
		test.log(Status.INFO, "Books showing to user");
		applyExplicitWait(5);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));
		test.log(Status.INFO, "Cilcked on "+subject+" subject");
		applyExplicitWait(5);
		String title=obcl.chapterHeading.getText();
		System.out.println("Chapter Title:"+ title+ "shown");

		clickOnElement(obcl.chapterHeading);
		status = obcl.completedInSchool.isDisplayed();

		if (status) {
			System.out.println("Chapter title is clickable , shown completed in school option");
			test.log(Status.INFO, "Chapter title is clickable , shown completed in school option");
		}
		assert1.assertTrue(status);
		assert1.assertAll();
	}


	public void to_verify_use_must_be_able_to_navigate_to_revision_from_topic(String subject, String topic) throws MalformedURLException {
		SoftAssert assert1 = new SoftAssert();
		Boolean status = obcl.userName.isDisplayed();
		if(status) {
			System.out.println("User can be navigated to the Home page after login");
			test.log(Status.INFO, "User can be navigated to the Home page after login");
		}

		assert1.assertTrue(status);

		status = obcl.syllabus.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab is shown to the user on Home Page");
			test.log(Status.INFO, "Syllabus tab is shown to the user on Home Page");
		}
		//clickOnElement(obcl.syllabus);
		clickOnElement(findElementByText("Syllabus"));

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
		clickOnElement(findElementByText("Revis"));
		test.log(Status.INFO, "Clicked on Start Revision");
		System.out.println("Clicked on Start Revision");
		applyExplicitWait(5);
		status = findElementByText("you").isDisplayed();

		if (status) {
			System.out.println("Starting the Revesion");
			test.log(Status.INFO, "Starting the Revesion");

		}

		clickOnElement(findElementByText("Revis"));
		status = findElementByText("Overview").isDisplayed();

		if (status) {
			System.out.println("Stared the Revesion");
			test.log(Status.INFO, "Started the Revesion");

		}
		assert1.assertAll();
	}


	public void to_verify_use_must_be_able_to_navigate_to_practice_from_topic(String subject, String topic) throws MalformedURLException {
		SoftAssert assert1 = new SoftAssert();
		Boolean status = obcl.userName.isDisplayed();
		if(status) {
			System.out.println("User can be navigated to the Home page after login");
			test.log(Status.INFO, "User can be navigated to the Home page after login");
		}

		assert1.assertTrue(status);

		status = obcl.syllabus.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab is shown to the user on Home Page");
			test.log(Status.INFO, "Syllabus tab is shown to the user on Home Page");
		}
		clickOnElement(obcl.syllabus);
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
		clickOnElement(findElementByText("Practice"));
		test.log(Status.INFO, "Clicked on Start Practice");
		System.out.println("Clicked on Start Practice");
		applyExplicitWait(5);
		status = findElementByText("you").isDisplayed();

		if (status) {
			System.out.println("Starting the practice");
			test.log(Status.INFO, "Starting the Practice");

		}

		clickOnElement(findElementByText("Practice"));
		status = findElementByText("Check").isDisplayed();

		if (status) {
			System.out.println("Stared the practice");
			test.log(Status.INFO, "Started the practice");

		}
		assert1.assertAll();
	}
	public void to_verify_the_user_should_be_able_to_Navigate_to_Notes_listing_page(String subject, String topic) throws MalformedURLException
	{
		SoftAssert assert1 = new SoftAssert();
		Boolean status = obcl.userName.isDisplayed();
		if(status) {
			System.out.println("User can be navigated to the Home page after login");
			test.log(Status.INFO, "User can be navigated to the Home page after login");
		}

		assert1.assertTrue(status);

		status = obcl.syllabus.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab is shown to the user on Home Page");
			test.log(Status.INFO, "Syllabus tab is shown to the user on Home Page");
		}
		//clickOnElement(obcl.syllabus);
		clickOnElement(findElementByText("Syllabus"));

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
		scrollTo2("Notes");

		applyExplicitWait(5);
		applyExplicitWaitsUntilElementClickable(obcl.notes);
		status = findElementByText("Notes").isDisplayed();

		if (status) {
			System.out.println("Displayed Notes of Selected Topic");
			test.log(Status.INFO, "Displayed Notes of Selected Topic");

		}
		clickOnElement(obcl.notes);
		if (status) {
			System.out.println("Displayed Notes of Selected Topic");
			test.log(Status.INFO, "Displayed Notes of Selected Topic");

		}
		assert1.assertTrue(status);
		clickOnElement(obcl.backBtn);
		if (status) {
			System.out.println("User is able to get back from Notes");
			test.log(Status.INFO, "User is able to get back from Notes");

		}
		assert1.assertTrue(status);

		assert1.assertAll();

	}

	public void to_verify_user_should_be_able_to_navigate_to_the_StrikedOut_Topics(String subject, String topic1) throws MalformedURLException {
		SoftAssert assert1 = new SoftAssert();
		Boolean status = obcl.userName.isDisplayed();
		if(status) {
			System.out.println("User can be navigated to the Home page after login");
			test.log(Status.INFO, "User can be navigated to the Home page after login");
		}

		assert1.assertTrue(status);

		status = obcl.syllabus.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab is shown to the user on Home Page");
			test.log(Status.INFO, "Syllabus tab is shown to the user on Home Page");
		}
		//clickOnElement(obcl.syllabus);
		clickOnElement(findElementByText("Syllabus"));

		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");
		applyExplicitWait(5);

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
		scrollTo2("Practice");
		applyExplicitWait(5);
		status = findElementByText("Revis").isDisplayed();

		if (status) {
			System.out.println("StrikedOut Topic shown");
			test.log(Status.INFO, "StrikedOut Topic shown");
		}
		assert1.assertAll();


	}
	
}


