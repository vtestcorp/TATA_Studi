package studi.co.pageModules;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Syllabus_Notes_Listing;

public class Module_Syllabus_Notes_Listing extends BaseClass
{
	Object_Syllabus_Notes_Listing osnl = new Object_Syllabus_Notes_Listing();
	SoftAssert assert1=new SoftAssert();
	Boolean status;


	public void To_verify_user_should_be_able_to_view_the_added_notes_from_the_hamburger_menu(String subject,
			String topic) throws MalformedURLException, AWTException, InterruptedException {
	}



	public void To_verify_user_should_be_able_to_view_the_added_notes_from_the_expanded_form(String subject,
			String topic) throws MalformedURLException, AWTException, InterruptedException {
		Verify_User_Is_Able_To_create_Note(subject , topic);
		clickOnElement(osnl.saveNoteBtn);

		try
		{
			clickOnElement(findElementByText("DO NOT SHOW"));
		}
		catch(Exception e)
		{
			System.out.println("Towards list on Notes by CLicking back button");
		}
		Thread.sleep(2000);
		applyExplicitWaitsUntilElementClickable(osnl.backBtn);
		scrollTo2("Notes");
		clickOnElement(findElementByText("Notes"));
		System.out.println("Clicked on Notes List");
		test.log(Status.INFO, "Clicked on Notes List");

		clickOnElement(osnl.note_address);
		System.out.println("Selecting the note to open in expanded view");
		test.log(Status.INFO, "Selecting the note to open in expanded view");
		status = osnl.to_note_location.isDisplayed();
		if (status) {
			System.out.println("Note get opened in expande View");
			test.log(Status.INFO, "Note get opened in expande View");
		}
		assert1.assertTrue(status);

		status = osnl.delete_icon.isDisplayed();

		if (status) {
			System.out.println("Delete Note Icon is shown on expnaded view");
			test.log(Status.INFO, "Delete Note Icon is shown on expnaded view");
		}
		assert1.assertTrue(status);

		status = osnl.edit_icon.isDisplayed();
		if (status) {
			System.out.println("Edit Note Icon is shown on expnaded view");
			test.log(Status.INFO, "Edit Note Icon is shown on expnaded view");
		}
		assert1.assertTrue(status);
		status = osnl.to_note_location.isDisplayed();

		if (status) {
			System.out.println("Go to The Location Tab is Displayed On Expanded view");
			test.log(Status.INFO, "Go to The Location Tab is Displayed On Expanded view");
		}
		assert1.assertTrue(status);
		clickOnElement(findElementByText("Go to Note Location"));
		assert1.assertTrue(status);
		status = osnl.create_note.isDisplayed();
		if (status) {
			System.out.println("Go to The Location Tab is Functional On Expanded view");
			test.log(Status.INFO, "Go to The Location Tab is Functional On Expanded view");
		}
		assert1.assertTrue(status);

	}
	public void To_verify_that_user_should_be_able_to_Edit_Delete_the_note(String subject, String topic) throws MalformedURLException, InterruptedException {
		Verify_User_Is_Able_To_create_Note(subject , topic);

		clickOnElement(osnl.saveNoteBtn);

		try
		{
			clickOnElement(findElementByText("DO NOT SHOW"));
		}
		catch(Exception e)
		{
			System.out.println("Towards list on Notes by CLicking back button");
		}
		Thread.sleep(2000);
		applyExplicitWaitsUntilElementClickable(osnl.backBtn);
		clickOnElement(osnl.backBtn);

		scrollTo2("Notes");
		clickOnElement(findElementByText("Notes"));
		System.out.println("Clicked on Notes List");
		test.log(Status.INFO, "Clicked on Notes List");

		clickOnElement(osnl.note_address);

		System.out.println("Selecting the note to open in expanded view");
		test.log(Status.INFO, "Selecting the note to open in expanded view");

		//applyExplicitWaitsUntilElementVisible(osnl.to_note_location);
		applyExplicitWait(3);
		status = osnl.edit_icon.isDisplayed();

		if (status) {
			System.out.println("Edit Icon is Displayed on Expanded view");
			test.log(Status.INFO, "Edit Icon is Displayed on Expanded view");
		}
		assert1.assertTrue(status);

		clickOnElement(osnl.edit_icon);
		applyExplicitWaitsUntilElementVisible(findElementByText("Update"));


		osnl.notes_container.clear();

		{
			System.out.println("Clearing the text from notes to Edit");
			test.log(Status.INFO, "Clearing the text from notes to Edit");
		}
		osnl.notes_container.sendKeys("Updating TATA Test@1_new");


		//applyExplicitWaitsUntilElementVisible(findElementByText("Update Note"));

		clickOnElement(osnl.update_note_final);
		System.out.println("Clicked On Update Note Button");
		test.log(Status.INFO, "Clicked On Update Note Button");

		status=osnl.to_note_location.isDisplayed();
		{
			System.out.println("Note updated Successfully using Edit Icon on Expanded note");
			test.log(Status.INFO, "Note updated Successfully using Edit Icon on Expanded note");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}


	public void to_verify_user_should_be_able_to_navigate_to_note_location_after_clicking_GoToNote_location(String subject, String topic) throws MalformedURLException, InterruptedException {
		Verify_User_Is_Able_To_create_Note(subject , topic);
		clickOnElement(osnl.saveNoteBtn);
		try
		{
			clickOnElement(findElementByText("DO NOT SHOW"));
		}
		catch(Exception e)
		{
			System.out.println("Towards list on Notes by CLicking back button");
		}
		Thread.sleep(2000);
		applyExplicitWaitsUntilElementClickable(osnl.backBtn);
		scrollTo2("Notes");
		clickOnElement(findElementByText("Notes"));
		System.out.println("Clicked on Notes List");
		test.log(Status.INFO, "Clicked on Notes List");
		clickOnElement(osnl.note_address);
		System.out.println("Selecting the note to open in expanded view");
		test.log(Status.INFO, "Selecting the note to open in expanded view");
		status = osnl.to_note_location.isDisplayed();

		if (status) {
			System.out.println("Note get opened in expande View");
			test.log(Status.INFO, "Note get opened in expande View");
		}
		assert1.assertTrue(status);
		status = osnl.to_note_location.isDisplayed();
		if (status) {
			System.out.println("Go to The Location Tab is Displayed On Expanded view");
			test.log(Status.INFO, "Go to The Location Tab is Displayed On Expanded view");
		}
		assert1.assertTrue(status);
		clickOnElement(findElementByText("Go to Note Location"));
		assert1.assertTrue(status);
		status = osnl.create_note.isDisplayed();
		if (status) {
			System.out.println("clicking 'Go to Notes Location' user has been  navigated to video player where the note have been added");
			test.log(Status.INFO, "clicking 'Go to Notes Location' user has been  navigated to video player where the note have been added");
		}
		assert1.assertTrue(status);

	}

	public void Verify_User_Is_Able_To_create_Note(String subject , String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		traverse_toward_topic(subject, topic);

		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		startRevision1();
		startRevision2();

		pauseVideo();

		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(osnl.addNotesBtn);
		status = osnl.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(osnl.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);

		System.out.println("Try to enter Text with special characters");
		test.log(Status.INFO, "Try to enter Text with special characters");
		String temp = "Tata Studi @Test1";
		osnl.noteTxtArea.sendKeys(temp);

		System.out.println("Checking entered text");
		test.log(Status.INFO, "Checking entered text");

		String temp2 = osnl.noteTxtArea.getText();

		System.out.println("Entered text: " + temp + ", Accepted text by note module: " + temp2);
		test.log(Status.INFO, "Entered text: " + temp + ", Accepted text by note module: " + temp2);

		status = temp.equalsIgnoreCase(temp2) ? true : false;
		sAss.assertTrue(status, "User is not able to create note");
		if (status) {
			System.out.println("User can create note");
			test.log(Status.INFO, "User can create note");
		}
	}


	public void traverse_toward_topic(String subject, String topic) throws MalformedURLException, InterruptedException {

		applyExplicitWait(5);
		scrollTo1("Syllabus");
		applyExplicitWait(5);
		clickOnElement(findElementByText("Syllabus"));
		applyExplicitWait(5);

		scrollTo1(subject);
		applyExplicitWait(2);
		clickOnElement(findElementByExactText(subject));
		applyExplicitWait(5);

		scrollTo2(topic);
		applyExplicitWait(2);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);

		Thread.sleep(500);
		if (device.contains("Android"))
			swipeUp();
		else
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(700)))
			.moveTo(PointOption.point(115, 550)).release().perform();

		try {
			if (findElementByText("Notes").isDisplayed()) {
				notesFlag = true;
				System.out.println("Notes available");
				clickOnElement(findElementByText("Notes"));
				deleteNotesCount();
			} else {
				notesFlag = false;
				System.out.println("Notes not available");
			}
		} catch (Exception e) {
			System.out.println("Notes not created previously");
		}
	}

	public void startRevision1() throws MalformedURLException {
		Boolean status;
		scrollTo2("Practice");
		clickOnElement(findElementByText("Revis"));
		test.log(Status.INFO, "Clicked on Start Revision");
		System.out.println("Clicked on Start Revision");
		applyExplicitWait(5);
		status = findElementByText("you").isDisplayed();

		if (status) {
			System.out.println("List of TQ's Displayed");
			test.log(Status.INFO, "List of TQ's Displayed");

		}
	}

	public void startRevision2() throws MalformedURLException, InterruptedException {

		Thread.sleep(2000);
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;
		while (flag == 0) {
			try {
				applyExplicitWait(5);
				status = findElementByText("Revis").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Begin Revision button Displayed");
					test.log(Status.INFO, "Begin Revision button Displayed");
					clickOnElement(findElementByText("Revis"));
					flag = 1;
				}
			} catch (Exception e) {

				applyExplicitWait(5);
				if (device.contains("Android"))
					status = findElementByText("Revis").isDisplayed();
				else
					status = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Revise again\"]"))
					.isEnabled();
				sAss.assertTrue(status);
				if (status) {

					System.out.println("Revise again button Displayed");
					test.log(Status.INFO, "Revise again button Displayed");

					if (device.contains("Android"))
						clickOnElement(findElementByText("Revis"));
					else
					{
						MobileElement btn=driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Revise again\"]"));
						driver.performTouchAction(new TouchAction(driver).tap(PointOption.point(((btn.getLocation().x)+(btn.getSize().width/2)),((btn.getLocation().y)+(btn.getSize().height/2)))));
					}

					System.out.println("Clicking on Revise again");
					test.log(Status.INFO, "Clicking on Revise again");

					flag = 1;
				}

			}

		}
	}


	private void pauseVideo() throws MalformedURLException, InterruptedException {

		applyExplicitWaitsUntilElementVisible(osnl.addNotesBtn);
		if (device.contains("Android")) {
			driver.findElement(By.id("com.tce.studi:id/player_view")).click();
		}			
		driver.findElement(By.id("com.tce.studi:id/exo_pause")).click();
	}

}