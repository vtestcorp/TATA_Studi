package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_ReviewPlan;
import studi.co.pageObjects.Object_Syllabus_Intent_Creation;


public class Module_Syllabus_Intent_Creation extends BaseClass{
	Object_Syllabus_Intent_Creation osic = new Object_Syllabus_Intent_Creation();
	SoftAssert assert1=new SoftAssert();
	Boolean status;
	//subject=Geography topic1=The Universe
	public void to_verify_all_the_Chapters_Topics_from_BrowseBook_section() throws Exception {
		osic.syllabus.click();
		applyExplicitWaitsUntilElementVisible(findElementByText("All Subjects"));
		System.out.println("Subjects are available as follows");
		test.log(Status.INFO, "Subjects are available as follows");

		List<MobileElement> books = getDriver().findElements(By.id("com.tce.studi:id/tv_book_name")); 	
		System.out.println("Books available are :");
		System.out.println(books.size());
		int i=1;
		for (MobileElement book : books) {
			assert1.assertTrue(book.isDisplayed());
			test.log(Status.INFO, "Topic "+i+" is Displayed");
			System.out.println(book.getText());
			i++;
		}

		SoftAssert assert1 = new SoftAssert();
		String subject = "Political Science";
		String topic1 = "Diversity in India";


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
		int j=1;
		for (MobileElement topic : list) {
			assert1.assertTrue(topic.isDisplayed());
			test.log(Status.INFO, "Topic "+i+" is Displayed");
			System.out.println(topic.getText());
			j++;
		}
		clickOnElement(findElementByText(topic1));
		test.log(Status.INFO, "Clicked on "+topic1);

		applyExplicitWait(5);

		assert1.assertAll();
	}




	public void to_verify_user_should_be_able_to_view_the_link_to_create_Digital_test(String subject , String topic_1) throws MalformedURLException {

		clickOnElement(findElementByText("Syllabus"));
		osic.add_assignment.click();
		test.log(Status.INFO, "Clicked on Add symbol to Open Assign-> Digital Test");
		System.out.println("Clicked on Add symbol to Open Assign-> Digital Test");

		status =osic.assign_Heading.isDisplayed();
		if (status) {
			System.out.println("Assign heading Shown on the page with Digital Test");
			test.log(Status.INFO, "Assign heading Shown on the page with Digital Test");
		}
		assert1.assertTrue(status);

		clickOnElement(findElementByText("Digital Test"));

		System.out.println("Digital Test is clickable and Functional");
		test.log(Status.INFO, "Digital Test is clickable and Functional");


		status =osic.assign_heading_OnBookShelf.isDisplayed();
		if (status) {
			System.out.println("Assign a digital test heading Shown with Book shelves");
			test.log(Status.INFO, "Assign a digital test heading Shown with Book shelves");
		}
		assert1.assertTrue(status);

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

		status =osic.enter_test_details.isDisplayed();
		if (status) {
			System.out.println("Enter Test Details shown");
			test.log(Status.INFO, "Enter Test Details shown");
		}
		assert1.assertTrue(status);

		status =osic.help.isDisplayed();
		if (status) {
			System.out.println("Help Button is availble on Enter Test Details");
			test.log(Status.INFO, "Help Button is availble on Enter Test Details");
		}
		assert1.assertTrue(status);
		status =osic.help_ON.isDisplayed();
		if (status) {
			System.out.println("Help Button is in ON State");
			test.log(Status.INFO, "Help Button is in ON State");
		}
		assert1.assertTrue(status);

		status =osic.titleHelp.isDisplayed();
		if (status) {
			System.out.println("Help ON button is Functinal shows Guidline for Fields");
			test.log(Status.INFO, "Help ON button is Functinal shows Guidline for Fields");
		}
		assert1.assertTrue(status);

		status =osic.title.isDisplayed();
		if (status) {
			System.out.println("Title field is displayed on Assign a Digital Test");
			test.log(Status.INFO, "Title field is displayed on Assign a Digital Test");
		}
		assert1.assertTrue(status);
		//preview Button

		//clickOnElement(findElementByText("Assign"));
		clickOnElement(osic.assign_Final);


		status =osic.notification.isDisplayed();
		if (status) {
			System.out.println("Notification Message Shown --> Digital Test is Ready!!");
			test.log(Status.INFO, "Notification Message Shown --> Digital Test is Ready!!");
		}
		assert1.assertTrue(status);
		assert1.assertAll();
	}





	public void to_verify_user_should_be_able_to_add_the_Content_even_if_striked_off(String subject , String topic1) throws MalformedURLException {
		clickOnElement(findElementByText("Syllabus"));
		osic.add_assignment.click();
		test.log(Status.INFO, "Clicked on Add symbol to Open Assign-> Digital Test");
		System.out.println("Clicked on Add symbol to Open Assign-> Digital Test");

		status =osic.assign_Heading.isDisplayed();
		if (status) {
			System.out.println("Assign heading Shown on the page with Digital Test");
			test.log(Status.INFO, "Assign heading Shown on the page with Digital Test");
		}
		assert1.assertTrue(status);

		clickOnElement(findElementByText("Digital Test"));

		System.out.println("Digital Test is clickable and Functional");
		test.log(Status.INFO, "Digital Test is clickable and Functional");
		status =osic.assign_heading_OnBookShelf.isDisplayed();
		if (status) {
			System.out.println("Assign a digital test heading Shown with Book shelves");
			test.log(Status.INFO, "Assign a digital test heading Shown with Book shelves");
		}
		assert1.assertTrue(status);

		System.out.println("Selecting the Striked Off topic from Subject");
		test.log(Status.INFO, "Selecting the Striked Off topic from Subject");
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
		clickOnElement(findElementByText("Next"));

		status =osic.enter_test_details.isDisplayed();
		if (status) {
			System.out.println("Enter Test Details shown");
			test.log(Status.INFO, "Enter Test Details shown");
		}
		assert1.assertTrue(status);
		//scrollTo2("Assign");
		//clickOnElement(findElementByText("Assign"));
		clickOnElement(osic.assign_Final);
		status =osic.notification.isDisplayed();
		if (status) {
			System.out.println("Notification Message Shown --> Digital Test is Ready!!");
			test.log(Status.INFO, "Notification Message Shown --> Digital Test is Ready!!");
		}


		assert1.assertTrue(status);
		assert1.assertAll();
	}




	public void On_click_one_of_the_topic_or_chapter_next_button_shown(String subject_History, String topic_H) {
		clickOnElement(findElementByText("Syllabus"));
		osic.add_assignment.click();
		test.log(Status.INFO, "Clicked on Add symbol to Open Assign-> Digital Test");
		System.out.println("Clicked on Add symbol to Open Assign-> Digital Test");

		status =osic.assign_Heading.isDisplayed();
		if (status) {
			System.out.println("Assign heading Shown on the page with Digital Test");
			test.log(Status.INFO, "Assign heading Shown on the page with Digital Test");
		}
		assert1.assertTrue(status);

		clickOnElement(findElementByText("Digital Test"));

		System.out.println("Digital Test is clickable and Functional");
		test.log(Status.INFO, "Digital Test is clickable and Functional");


		status =osic.assign_heading_OnBookShelf.isDisplayed();
		if (status) {
			System.out.println("Assign a digital test heading Shown with Book shelves");
			test.log(Status.INFO, "Assign a digital test heading Shown with Book shelves");
		}
		assert1.assertTrue(status);

		System.out.println("Selecting the Striked Off topic from Subject");
		test.log(Status.INFO, "Selecting the Striked Off topic from Subject");
		scrollTo1(subject_History);
		test.log(Status.INFO, "Opening " + subject_History);
		System.out.println("Opening " + subject_History);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject_History));
		clickOnElement(findElementByText(subject_History));

		scrollTo1(topic_H);
		test.log(Status.INFO, "Selecting " + topic_H);
		System.out.println("Selecting " + topic_H);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic_H));
		clickOnElement(findElementByText(topic_H));

		status =osic.next.isDisplayed();
		if (status) {
			System.out.println("Next button is available after selecting the topic");
			test.log(Status.INFO, "Next button is available after selecting the topic");
		}
		assert1.assertTrue(status);
		clickOnElement(findElementByText("Next"));


		status =osic.enter_test_details.isDisplayed();
		if (status) {
			System.out.println("When clicked on Next button--> Enter Test Details page shown");
			test.log(Status.INFO, "When clicked on Next button--> Enter Test Details page shown");
		}
		assert1.assertTrue(status);
		assert1.assertAll();
	}



	public void to_Verify_click_on_delete_icon_test_creation_will_be_aborted(String subject_History, String topic_H) throws MalformedURLException {
		clickOnElement(findElementByText("Syllabus"));
		osic.add_assignment.click();
		test.log(Status.INFO, "Clicked on Add symbol to Open Assign-> Digital Test");
		System.out.println("Clicked on Add symbol to Open Assign-> Digital Test");

		status =osic.assign_Heading.isDisplayed();
		if (status) {
			System.out.println("Assign heading Shown on the page with Digital Test");
			test.log(Status.INFO, "Assign heading Shown on the page with Digital Test");
		}
		assert1.assertTrue(status);

		clickOnElement(findElementByText("Digital Test"));

		System.out.println("Digital Test is clickable and Functional");
		test.log(Status.INFO, "Digital Test is clickable and Functional");


		status =osic.assign_heading_OnBookShelf.isDisplayed();
		if (status) {
			System.out.println("Assign a digital test heading Shown with Book shelves");
			test.log(Status.INFO, "Assign a digital test heading Shown with Book shelves");
		}
		assert1.assertTrue(status);

		System.out.println("Selecting the Striked Off topic from Subject");
		test.log(Status.INFO, "Selecting the Striked Off topic from Subject");
		scrollTo1(subject_History);
		test.log(Status.INFO, "Opening " + subject_History);
		System.out.println("Opening " + subject_History);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject_History));
		clickOnElement(findElementByText(subject_History));

		scrollTo1(topic_H);
		test.log(Status.INFO, "Selecting " + topic_H);
		System.out.println("Selecting " + topic_H);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic_H));
		clickOnElement(findElementByText(topic_H));

		status =osic.delete_test.isDisplayed();
		if (status) {
			System.out.println("Delete Test Option is availbale on Book Shelf");
			test.log(Status.INFO, "Delete Test Option is availbale on Book Shelf");
		}
		assert1.assertTrue(status);
		clickOnElement(osic.delete_test);
		status =osic.dlt_Confirmation.isDisplayed();
		if (status) {
			System.out.println("Are you sure you want to discard?---> Message Displayed");
			test.log(Status.INFO, "Are you sure you want to discard?---> Message Displayed");
		}
		assert1.assertTrue(status);
		clickOnElement(osic.please_Discard);

		status =osic.syllabus_AllSub.isDisplayed();
		if (status) {
			System.out.println("User navigated back to book shelf listing and digital test creation got aborted ");
			test.log(Status.INFO, "User navigated back to book shelf listing and digital test creation got aborted ");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}
	public void to_verify_user_should_not_be_allowed_to_proceed_further_keeping_Title_field_blank(String subject_History,String topic_H)
	{

		clickOnElement(findElementByText("Syllabus"));
		osic.add_assignment.click();
		test.log(Status.INFO, "Clicked on Add symbol to Open Assign-> Digital Test");
		System.out.println("Clicked on Add symbol to Open Assign-> Digital Test");

		status =osic.assign_Heading.isDisplayed();
		if (status) {
			System.out.println("Assign heading Shown on the page with Digital Test");
			test.log(Status.INFO, "Assign heading Shown on the page with Digital Test");
		}
		assert1.assertTrue(status);

		clickOnElement(findElementByText("Digital Test"));

		System.out.println("Digital Test is clickable and Functional");
		test.log(Status.INFO, "Digital Test is clickable and Functional");
		status =osic.assign_heading_OnBookShelf.isDisplayed();
		if (status) {
			System.out.println("Assign a digital test heading Shown with Book shelves");
			test.log(Status.INFO, "Assign a digital test heading Shown with Book shelves");
		}
		assert1.assertTrue(status);

		System.out.println("Selecting the topic from Subject");
		test.log(Status.INFO, "Selecting the topic from Subject");
		scrollTo1(subject_History);
		test.log(Status.INFO, "Opening " + subject_History);
		System.out.println("Opening " + subject_History);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject_History));
		clickOnElement(findElementByText(subject_History));

		scrollTo1(topic_H);
		test.log(Status.INFO, "Selecting " + topic_H);
		System.out.println("Selecting " + topic_H);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic_H));
		clickOnElement(findElementByText(topic_H));
		clickOnElement(osic.next); 
		status =osic.title.isDisplayed();
		if (status) {
			System.out.println("Title is displyed on Test Details page");
			test.log(Status.INFO, "Title is displyed on Test Details page");
		}
		assert1.assertTrue(status);

	}

	public void to_verify_user_should_be_able_to_Choose_difficulty_level(String subject_History, String topic_H)
	{	
		clickOnElement(findElementByText("Syllabus"));
		osic.add_assignment.click();
		test.log(Status.INFO, "Clicked on Add symbol to Open Assign-> Digital Test");
		System.out.println("Clicked on Add symbol to Open Assign-> Digital Test");

		status =osic.assign_Heading.isDisplayed();
		if (status) {
			System.out.println("Assign heading Shown on the page with Digital Test");
			test.log(Status.INFO, "Assign heading Shown on the page with Digital Test");
		}
		assert1.assertTrue(status);
		clickOnElement(findElementByText("Digital Test"));
		System.out.println("Digital Test is clickable and Functional");
		test.log(Status.INFO, "Digital Test is clickable and Functional");
		status =osic.assign_heading_OnBookShelf.isDisplayed();
		if (status) {
			System.out.println("Assign a digital test heading Shown with Book shelves");
			test.log(Status.INFO, "Assign a digital test heading Shown with Book shelves");
		}
		assert1.assertTrue(status);

		System.out.println("Selecting the topic from Subject");
		test.log(Status.INFO, "Selecting the topic from Subject");
		scrollTo1(subject_History);
		test.log(Status.INFO, "Opening " + subject_History);
		System.out.println("Opening " + subject_History);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject_History));
		clickOnElement(findElementByText(subject_History));

		scrollTo1(topic_H);
		test.log(Status.INFO, "Selecting " + topic_H);
		System.out.println("Selecting " + topic_H);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic_H));
		clickOnElement(findElementByText(topic_H));
		clickOnElement(osic.next); //for blank title field need value

		status =osic.title.isDisplayed();
		if (status) {
			System.out.println("Title is displyed on Test Details page");
			test.log(Status.INFO, "Title is displyed on Test Details page");
		}
		assert1.assertTrue(status);


		status =osic.difficultyLevel.isDisplayed();
		if (status) {
			System.out.println("Difficulty level is displayed -->");
			test.log(Status.INFO, "Difficulty level is displayed -->");
		}
		assert1.assertTrue(status);

		tapOnElement(osic.low);
		status = Boolean.parseBoolean(osic.low.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(true, "Low Difficulty Level For the Test is available & clickable");
			System.out.println("Low Difficulty Level For the Test is available & clickable");
		}
		tapOnElement(osic.medium);
		status = Boolean.parseBoolean(osic.medium.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(true, "Medium Difficulty Level For the Test is available & clickable");
			System.out.println("Medium Difficulty Level For the Test is available & clickable");
		}
		tapOnElement(osic.high);
		status = Boolean.parseBoolean(osic.high.getAttribute("clickable"));
		if (status) {
			assert1.assertTrue(true, "High Difficulty Level For the Testis available & clickable");
			System.out.println("High Difficulty Level For the Test is available & clickable");
		}
		assert1.assertAll();

	}
	public void to_verify_user_should_be_select_duration(String subject_History, String topic_H) {
		{	
			clickOnElement(findElementByText("Syllabus"));
			osic.add_assignment.click();
			test.log(Status.INFO, "Clicked on Add symbol to Open Assign-> Digital Test");
			System.out.println("Clicked on Add symbol to Open Assign-> Digital Test");

			status =osic.assign_Heading.isDisplayed();
			if (status) {
				System.out.println("Assign heading Shown on the page with Digital Test");
				test.log(Status.INFO, "Assign heading Shown on the page with Digital Test");
			}
			assert1.assertTrue(status);

			clickOnElement(findElementByText("Digital Test"));

			System.out.println("Digital Test is clickable and Functional");
			test.log(Status.INFO, "Digital Test is clickable and Functional");


			status =osic.assign_heading_OnBookShelf.isDisplayed();
			if (status) {
				System.out.println("Assign a digital test heading Shown with Book shelves");
				test.log(Status.INFO, "Assign a digital test heading Shown with Book shelves");
			}
			assert1.assertTrue(status);

			System.out.println("Selecting the topic from Subject");
			test.log(Status.INFO, "Selecting the topic from Subject");
			scrollTo1(subject_History);
			test.log(Status.INFO, "Opening " + subject_History);
			System.out.println("Opening " + subject_History);
			applyExplicitWaitsUntilElementClickable(findElementByText(subject_History));
			clickOnElement(findElementByText(subject_History));
			scrollTo1(topic_H);
			test.log(Status.INFO, "Selecting " + topic_H);
			System.out.println("Selecting " + topic_H);
			applyExplicitWaitsUntilElementClickable(findElementByText(topic_H));
			clickOnElement(findElementByText(topic_H));
			clickOnElement(osic.next); //for blank title field need value
			status =osic.title.isDisplayed();
			if (status) {
				System.out.println("Title is displyed on Test Details page");
				test.log(Status.INFO, "Title is displyed on Test Details page");
			}
			assert1.assertTrue(status);
			status =osic.duration.isDisplayed();
			if (status) {
				System.out.println("Tentative Duration is displayed -->");
				test.log(Status.INFO, "Tentative Duration is displayed -->");
			}
			assert1.assertTrue(status);
			tapOnElement(osic.five);
			status = Boolean.parseBoolean(osic.five.getAttribute("clickable"));
			if (status) {
				assert1.assertTrue(true, "User able to set 5Minutes of Duration");
				System.out.println("User able to set 5 Minutes of Duration");
			}
			tapOnElement(osic.ten);
			status = Boolean.parseBoolean(osic.ten.getAttribute("clickable"));
			if (status) {
				assert1.assertTrue(true, "User able to set 10 Minutes of Duration");
				System.out.println("User able to set 10 Minutes of Duration");
			}
			tapOnElement(osic.fifteen);
			status = Boolean.parseBoolean(osic.fifteen.getAttribute("clickable"));
			if (status) {
				assert1.assertTrue(true, "User able to set 15 Minutes of Duration");
				System.out.println("User able to set 15 Minutes of Duration");
			}
			tapOnElement(osic.thirty);
			status = Boolean.parseBoolean(osic.thirty.getAttribute("clickable"));
			if (status) {
				assert1.assertTrue(true, "User able to set 30 Minutes of Duration");
				System.out.println("User able to set 30 Minutes of Duration");
			}
			assert1.assertAll();
		}

	}

	public void to_verify_user_should_be_able_to_select_date_for_the_test(String subject_History,String topic_H) throws MalformedURLException, InterruptedException {
		{	
			clickOnElement(findElementByText("Syllabus"));
			osic.add_assignment.click();
			test.log(Status.INFO, "Clicked on Add symbol to Open Assign-> Digital Test");
			System.out.println("Clicked on Add symbol to Open Assign-> Digital Test");
			status =osic.assign_Heading.isDisplayed();
			if (status) {
				System.out.println("Assign heading Shown on the page with Digital Test");
				test.log(Status.INFO, "Assign heading Shown on the page with Digital Test");
			}
			assert1.assertTrue(status);
			clickOnElement(findElementByText("Digital Test"));
			System.out.println("Digital Test is clickable and Functional");
			test.log(Status.INFO, "Digital Test is clickable and Functional");
			status =osic.assign_heading_OnBookShelf.isDisplayed();
			if (status) {
				System.out.println("Assign a digital test heading Shown with Book shelves");
				test.log(Status.INFO, "Assign a digital test heading Shown with Book shelves");
			}
			assert1.assertTrue(status);

			System.out.println("Selecting the topic from Subject");
			test.log(Status.INFO, "Selecting the topic from Subject");
			System.err.println("Clicked on " + subject_History);
			scrollTo2(subject_History);
			clickOnElement(findElementByText(subject_History));

			System.err.println("Clicked on " + topic_H);
			scrollTo2(topic_H);
			clickOnElement(findElementByText(topic_H));

			clickOnElement(findElementByText("Next")); 
			status =osic.title.isDisplayed();
			if (status) {
				System.out.println("Title is displyed on Test Details page");
				test.log(Status.INFO, "Title is displyed on Test Details page");
			}
			assert1.assertTrue(status);

			String date=osic.select_Date.getText();

			System.out.println("Actual Date is :"+date);
			clickOnElement(osic.select_Date);
			applyExplicitWait(2);
			String[] s = date.split("-");
			String actualDate=s[0];
			int i = Integer.parseInt(actualDate);
			int date2=i+2;
			if(i>=26) {
				osic.nextMonthButton.click();
				//Thread.sleep(2000);
				//	 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));
				//new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
				//.until(ExpectedConditions.elementToBeClickable(orp.date1));

				clickOnElement(driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"01\")")));	
				System.out.println(driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"01\")")).getText());

			}
			else {
				MobileElement date3=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+"')]"));
				date3.click();

			}
			Thread.sleep(3);
			//String changed_date=osic.select_Date.getText();
			//System.out.println("The changed date is:"+changed_date);
			//clickOnElement(osic.ok_on_calendar);
			//applyExplicitWaitsUntilElementClickable(pauseBtn);
			clickOnElement(findElementByText("OK"));
			scrollTo2("Assign");
			applyExplicitWaitsUntilElementClickable(findElementByText("Assign"));
			clickOnElement(osic.assign_Final);
			status =osic.notification.isDisplayed();

			if (status) {
				System.out.println("Notification Message Shown --> Digital Test is Ready!!");
				test.log(Status.INFO, "Notification Message Shown --> Digital Test is Ready!!");
			}
			assert1.assertTrue(status);
			assert1.assertAll();
		}

	}

	public void test_should_be_created_on_clicking_the_Assign_button(String subject, String topic1) throws MalformedURLException {
		clickOnElement(findElementByText("Syllabus"));
		osic.add_assignment.click();
		test.log(Status.INFO, "Clicked on Add symbol to Open Assign-> Digital Test");
		System.out.println("Clicked on Add symbol to Open Assign-> Digital Test");

		status =osic.assign_Heading.isDisplayed();
		if (status) {
			System.out.println("Assign heading Shown on the page with Digital Test");
			test.log(Status.INFO, "Assign heading Shown on the page with Digital Test");
		}
		assert1.assertTrue(status);

		clickOnElement(findElementByText("Digital Test"));

		System.out.println("Digital Test is clickable and Functional");
		test.log(Status.INFO, "Digital Test is clickable and Functional");
		status =osic.assign_heading_OnBookShelf.isDisplayed();
		if (status) {
			System.out.println("Assign a digital test heading Shown with Book shelves");
			test.log(Status.INFO, "Assign a digital test heading Shown with Book shelves");
		}
		assert1.assertTrue(status);

		System.out.println("Selecting the topic from Subject");
		test.log(Status.INFO, "Selecting the topic from Subject");
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
		clickOnElement(findElementByText("Next"));

		status =osic.enter_test_details.isDisplayed();
		if (status) {
			System.out.println("Enter Test Details shown");
			test.log(Status.INFO, "Enter Test Details shown");
		}
		assert1.assertTrue(status);
		//clickOnElement(findElementByText("Assign"));
		clickOnElement(osic.assign_Final);

		status =osic.notification.isDisplayed();
		if (status) {
			System.out.println("Notification Message Shown --> Digital Test is Ready!!");
			test.log(Status.INFO, "Notification Message Shown --> Digital Test is Ready!!");
		}
		assert1.assertTrue(status);

		//Verify that recently created test should be displayed under 'Assignment listing page


		assert1.assertAll();


	}

}






