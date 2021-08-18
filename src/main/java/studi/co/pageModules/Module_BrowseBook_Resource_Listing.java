package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_BrowseBook_Resource_Listing;
import studi.co.pageObjects.Object_Syllabus;

public class Module_BrowseBook_Resource_Listing extends BaseClass
{
	Object_BrowseBook_Resource_Listing osbl = new Object_BrowseBook_Resource_Listing();
	SoftAssert assert1=new SoftAssert();
	Boolean status;

	public void to_Verify_User_should_be_shown_Confidence_score_of_each_chapter_against_every_book(String subject,
			String topic) throws Exception {

		Boolean status;
		SoftAssert assert1 = new SoftAssert();
		toVerify_The_Available_Resource_Of_The_BookShelf();

		status=osbl.status.isDisplayed();
		if(status) {
			System.out.println("Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO, "Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(osbl.subjectHeading);
		status=osbl.subjectHeading.isDisplayed();
		if(status) {

			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic);

		action = new TouchAction(driver);
		List<MobileElement> chapters = getAllElementsFromPageUsingID("com.tce.studi:id/tvChapter");

		ArrayList<String> aa = new ArrayList<>();
		for (MobileElement mobileElement : chapters) {
			aa.add(mobileElement.getText().replaceAll("\\d", "").trim());
		}

		System.out.println("Chapters available in given subject are :");
		test.log(Status.INFO, "chapters available in given subject are :");
		List<String> chaptersWD = new ArrayList<>(new HashSet<>(aa));
		chaptersWD.sort(Comparator.naturalOrder());

		System.out.println(chaptersWD.size());
		for (String chapter1 : chaptersWD) {
			test.log(Status.INFO, chapter1);
			System.out.println(chapter1);
		}
		//swipeTop();
		applyExplicitWait(5);
		scrollTo2(topic);
		applyExplicitWait(5);
		List<MobileElement> list = getDriver().findElements(By.id("com.tce.studi:id/tvTopic")); 	
		System.out.println("Topics available in given chapter are :");
		System.out.println(list.size());
		int i=1;
		for (MobileElement topic1 : list) {
			assert1.assertTrue(topic1.isDisplayed());
			test.log(Status.INFO, "Topic "+i+" is Displayed");
			System.out.println(topic1.getText());
			i++;
			MobileElement confidenceStatus=getDriver().findElementByXPath("//*[contains(@text, '"+topic1.getText()+"')]/preceding-sibling::android.widget.ImageView");

			assert1.assertTrue(confidenceStatus.isDisplayed());
		}

		test.log(Status.INFO, "Confidence Score/Status is shown to the user against  every TP");
		System.out.println("Confidence Score/Status is shown to the user against  every TP");

		assert1.assertAll();
	}



	public void to_verify_user_should_be_shown_Not_Accessed_Status_when_user_has_not_started_that_particular_chapter(String not_accessed_sub,String not_accessed_topic) throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status=osbl.status.isDisplayed();
		if(status) {
			System.out.println("Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO, "Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		System.out.println(not_accessed_sub);
		scrollTo2(not_accessed_sub);
		clickOnElement(findElementByText(not_accessed_sub));

		applyExplicitWaitsUntilElementVisible(osbl.subjectHeading);
		status=osbl.subjectHeading.isDisplayed();
		if(status) {

			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(not_accessed_topic);

		action = new TouchAction(driver);
		List<MobileElement> chapters = getAllElementsFromPageUsingID("com.tce.studi:id/tvChapter");

		ArrayList<String> aa = new ArrayList<>();
		for (MobileElement mobileElement : chapters) {
			aa.add(mobileElement.getText().replaceAll("\\d", "").trim());
		}

		System.out.println("Chapters available in given subject are :");
		test.log(Status.INFO, "chapters available in given subject are :");
		List<String> chaptersWD = new ArrayList<>(new HashSet<>(aa));
		chaptersWD.sort(Comparator.naturalOrder());

		System.out.println(chaptersWD.size());
		for (String chapter1 : chaptersWD) {
			test.log(Status.INFO, chapter1);
			System.out.println(chapter1);

		}
		applyExplicitWait(5);
		scrollTo2(not_accessed_topic);
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
		status =osbl.initial_status.isDisplayed();
		if(status) {

			System.out.println("Status Shown for particular chapter");
			test.log(Status.INFO, "Status Shown for particular chapter");
		}
		assert1.assertTrue(status);


		scrollTo2(not_accessed_topic);

		tapOnElement(driver.findElement(By.xpath("//*[contains(@text, '"+not_accessed_topic+"')]/parent::*")).findElement(By.id("com.tce.studi:id/ivTopic")));
		String msg=osbl.confidence_status.getText();
		assert1.assertEquals("Not Assessed", msg);
		{
			System.out.println("when user has not started studying any particular Chapter  in a book, use shown the Not Accessed Status for that chapter against that book");
			test.log(Status.INFO, "when user has not started studying any particular Chapter  in a book, use shown the Not Accessed Status for that chapter against that book");
		}
		assert1.assertAll();


	}
	public void to_verify_User_should_be_shown_Low_Confidence_Status_for_the_chapter_in_which_user_has_scored_Low_Confidence(
			String subject_low, String topic_low) throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status=osbl.status.isDisplayed();
		if(status) {
			System.out.println("Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO, "Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2("Mathematics");
		clickOnElement(findElementByText("Mathematics"));

		applyExplicitWaitsUntilElementVisible(osbl.subjectHeading);
		status=osbl.subjectHeading.isDisplayed();
		if(status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2("The Number Line");
		clickOnElement(findElementByText("The Number Line"));

		scrollTo2("Practice");
		clickOnElement(findElementByText("Practice"));
		applyExplicitWaitsUntilElementVisible(findElementByText("you"));
		clickOnElement(findElementByText("Practice"));

		applyExplicitWaitsUntilElementVisible(osbl.question1_part_Text);
		String questionCount = osbl.quetionCount.getText();
		String[] s = questionCount.split("of");
		String s1 = s[1].trim();
		int question=Integer.parseInt(s1);

		for(int j=0;j<question;j++) {

			if(verifySCQorMCQ().equalsIgnoreCase("scq")||verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWaitsUntilElementVisible(osbl.question1_part_Text);
				selectIncorrectAnswer();
				clickOnElement(findElementByText("Check"));
				Thread.sleep(300);

				try{clickOnElement(driver.findElement(By.id("com.tce.studi:id/tvSecondaryAction")));}
				catch(Exception e) {

				}
				Thread.sleep(1500);
				clickOnElement(findElementByText("continue"));
			}
			else {

			}
		}
		applyExplicitWaitsUntilElementVisible(osbl.target);
		osbl.hamBurgerMenu.click();
		applyExplicitWaitsUntilElementVisible(osbl.returnTitle);
		osbl.returnTitle.click();

		//		osbl.backButton.click();
		//		
		//		Thread.sleep(3000);
		//		clickOnElement(findElementByText("Yes"));
		//		
		//		clickOnElement(findElementByText("Return"));
		//		scrollTo2("The Number Line");

		tapOnElement(driver.findElement(By.xpath("//*[contains(@text, '"+"The Number Line"+"')]/parent::*")).findElement(By.id("com.tce.studi:id/ivTopic")));
		String msg=osbl.confidence_status.getText();
		assert1.assertEquals("Low Confidence", msg);
		{
			System.out.println("Low Confidence Status is shown to the user for those particular TP for which user has scored Medium Confidence");
			test.log(Status.INFO, "Low Confidence Status is shown to the user for those particular TP for which user has scored Medium Confidence");
		}
		assert1.assertAll();


	}

	public void to_verify_User_should_be_shown_medium_Confidence_Status_for_the_chapter_in_which_user_has_scored_Low_Confidence(
			String subject_eng, String topic_medium) throws Exception {
		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status = osbl.status.isDisplayed();
		if (status) {
			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject_eng);
		clickOnElement(findElementByText(subject_eng));

		applyExplicitWaitsUntilElementVisible(osbl.subjectHeading);
		status = osbl.subjectHeading.isDisplayed();
		if (status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic_medium);
		tapOnElement(findElementByText(topic_medium));

		scrollTo2("Practice");
		clickOnElement(findElementByText("Practice"));
		applyExplicitWaitsUntilElementVisible(findElementByText("you"));
		clickOnElement(findElementByText("Practice"));
		applyExplicitWait(30);
		applyExplicitWaitsUntilElementVisible(osbl.question1_part_Text);
		String questionCount = osbl.quetionCount.getText();
		String[] s = questionCount.split("of");
		String s1 = s[1].trim();
		int question = Integer.parseInt(s1);

		for (int j = 1; j <= question; j++) {

			if (j == 0) {

				applyExplicitWaitsUntilElementVisible(osbl.question1_part_Text);

				// swipeUp();
				selectCorrectAnswer();
				clickOnElement(findElementByText("Check Answer"));

				clickOnElement(findElementByText("Continue"));
			}

			else {

				applyExplicitWaitsUntilElementVisible(osbl.question1_part_Text);
				// scrollToEnd();
				selectIncorrectAnswer();
				clickOnElement(findElementByText("Check Answer"));
				try {
					clickOnElement(driver.findElement(By.id("com.tce.studi:id/tvSecondaryAction")));
				} catch (Exception e) {
				}
				// selectIncorrectAnswer();
				// clickOnElement(findElementByText("Check"));
				clickOnElement(findElementByText("Continue"));
			}

		}

		applyExplicitWaitsUntilElementVisible(osbl.target);
		osbl.hamBurgerMenu.click();
		applyExplicitWaitsUntilElementVisible(osbl.returnTitle);
		osbl.returnTitle.click();

		scrollTo2(topic_medium);

		tapOnElement(driver.findElement(By.xpath("//*[contains(@text, '" + topic_medium + "')]/parent::*"))
				.findElement(By.id("com.tce.studi:id/ivTopic")));
		String msg = osbl.confidence_status.getText();

		assert1.assertEquals("Medium Confidence", msg);
		{
			System.out.println(
					"Medium Confidence Status is shown to the user for those particular TP for which user has scored Medium Confidence");
			test.log(Status.INFO,
					"Medium Confidence Status is shown to the user for those particular TP for which user has scored Medium Confidence");
		}

		assert1.assertAll();

	}
	public void to_verify_User_should_be_shown_High_Confidence_Status_for_the_chapter_in_which_user_has_scored_Low_Confidence(
			String subject_eng, String topic_eng) throws Exception {
		String subject="Political Science";
		String topic="Diversity in India";
		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status=osbl.status.isDisplayed();
		if(status) {
			System.out.println("Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO, "Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(osbl.subjectHeading);
		status=osbl.subjectHeading.isDisplayed();
		if(status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(osbl.subjectHeading);
		status=osbl.subjectHeading.isDisplayed();
		if(status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(osbl.subjectHeading);
		status=osbl.subjectHeading.isDisplayed();
		if(status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic);
		clickOnElement(findElementByText(topic));

		scrollTo2("Practice");
		clickOnElement(findElementByText("Practice"));
		applyExplicitWaitsUntilElementVisible(findElementByText("you"));
		clickOnElement(findElementByText("Practice"));

		applyExplicitWaitsUntilElementVisible(osbl.question1_part_Text);
		String questionCount = osbl.quetionCount.getText();
		String[] s = questionCount.split("of");
		String s1 = s[1].trim();
		int question=Integer.parseInt(s1);

		for(int j=0;j<question;j++) {

			applyExplicitWaitsUntilElementVisible(osbl.question1_part_Text);
			applyExplicitWaitsUntilElementVisible(osbl.quetionCount);

			selectCorrectAnswer();
			clickOnElement(findElementByText("Check"));

			clickOnElement(findElementByText("continue"));
		}

		applyExplicitWaitsUntilElementVisible(osbl.target);
		osbl.hamBurgerMenu.click();
		applyExplicitWaitsUntilElementVisible(osbl.returnTitle);
		osbl.returnTitle.click();
		scrollTo2(topic);
		tapOnElement(driver.findElement(By.xpath("//*[contains(@text, '"+topic+"')]/parent::*")).findElement(By.id("com.tce.studi:id/ivTopic")));
		String msg=osbl.confidence_status.getText();
		assert1.assertEquals("High Confidence", msg);
		{
			System.out.println("High Confidence Status is shown to the user for those particular TP for which user has scored High Confidence");
			test.log(Status.INFO, "High Confidence Status is shown to the user for those particular TP for which user has scored Hign Confidence");
		}
		assert1.assertTrue(status);
		assert1.assertAll();
	}



	public void to_Verify_User_should_be_shown_Not_Accessed_Status_for_the_TP_when_user_has_not_started_that_particular_TP(String subject_eng,String topic_eng2) throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status=osbl.status.isDisplayed();
		if(status) {
			System.out.println("Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO, "Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		System.out.println(subject_eng);
		scrollTo2(subject_eng);
		clickOnElement(findElementByText(subject_eng));

		applyExplicitWaitsUntilElementVisible(osbl.subjectHeading);
		status=osbl.subjectHeading.isDisplayed();
		if(status) {

			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic_eng2);

		action = new TouchAction(driver);
		List<MobileElement> chapters = getAllElementsFromPageUsingID("com.tce.studi:id/tvChapter");

		ArrayList<String> aa = new ArrayList<>();
		for (MobileElement mobileElement : chapters) {
			aa.add(mobileElement.getText().replaceAll("\\d", "").trim());
		}

		System.out.println("Chapters available in given subject are :");
		test.log(Status.INFO, "chapters available in given subject are :");
		List<String> chaptersWD = new ArrayList<>(new HashSet<>(aa));
		chaptersWD.sort(Comparator.naturalOrder());

		System.out.println(chaptersWD.size());
		for (String chapter1 : chaptersWD) {
			test.log(Status.INFO, chapter1);
			System.out.println(chapter1);

		}
		applyExplicitWait(5);
		scrollTo2(topic_eng2);
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
		status =osbl.initial_status.isDisplayed();
		if(status) {

			System.out.println("Status Shown for particular chapter");
			test.log(Status.INFO, "Status Shown for particular chapter");
		}
		assert1.assertTrue(status);


		scrollTo2(topic_eng2);

		tapOnElement(driver.findElement(By.xpath("//*[contains(@text, '"+topic_eng2+"')]/parent::*")).findElement(By.id("com.tce.studi:id/ivTopic")));
		String msg=osbl.confidence_status.getText();
		assert1.assertEquals("Not Assessed", msg);
		{
			System.out.println("when user has not started studying any particular Chapter  in a book, use shown the Not Accessed Status for that chapter against that book");
			test.log(Status.INFO, "when user has not started studying any particular Chapter  in a book, use shown the Not Accessed Status for that chapter against that book");
		}
		assert1.assertAll();


	}
	public void to_Verify_User_should_be_shown_Completed_In_School_Status(String subject,
			String topic) throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status=osbl.status.isDisplayed();
		if(status) {
			System.out.println("Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO, "Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(osbl.subjectHeading);
		status=osbl.subjectHeading.isDisplayed();
		if(status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic);
		clickOnElement(findElementByText(topic));

		applyExplicitWaitsUntilElementVisible(osbl.completedInSchool);
		status=osbl.completedInSchool.isDisplayed();
		if(status) {

			System.out.println("User able to tap on any chapter");
			System.out.println("On tapping any Chapter title,toggle switch options to Mark it as \" Completed In School\" is shown to the user");
			test.log(Status.INFO, "User able to tap on any chapter");
			test.log(Status.INFO, "On tapping any Chapter title,toggle switch options to Mark it as \" Completed In School\" is shown to the user");
		}
		assert1.assertTrue(status);

		osbl.completedInSchool.click();

		status=Boolean.parseBoolean(osbl.completedInSchool.getAttribute("clickable"));
		if(status) {

			System.out.println("User can toggle the switch \" ON \" to mark the status of the chapter as \"Completed in School\"");
			test.log(Status.INFO, "User can toggle the switch \" ON \" to mark the status of the chapter as \"Completed in School\"");
		}
		assert1.assertTrue(status);
		//@		
		MobileElement status1=getDriver().findElementByXPath("//*[contains(@text, '"+topic+"')]/preceding-sibling::android.widget.ImageView");

		status =status1.isDisplayed();
		if(status) {

			System.out.println("User can see the same status \"Completed in School\" against that TP");
			test.log(Status.INFO, "User can see the same status \"Completed in School\" against that TP");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}

	public void To_Verify_User_should_be_shown_Excluded_from_Syllabus_Status_for_the_TP(String subject,
			String topic) throws Exception {
		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status=osbl.status.isDisplayed();
		if(status) {
			System.out.println("Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO, "Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(osbl.subjectHeading);
		status=osbl.subjectHeading.isDisplayed();
		if(status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic);

		clickOnElement(findElementByText(topic));

		applyExplicitWaitsUntilElementVisible(osbl.excludeFromSyllabus);
		status=osbl.excludeFromSyllabus.isDisplayed();
		if(status) {

			System.out.println("User able to tap on any chapter");
			System.out.println("On tapping any Chapter title,toggle switch options to Mark it as \" Excluded from Syllabus\" is shown to the user");
			test.log(Status.INFO, "User able to tap on any chapter");
			test.log(Status.INFO, "On tapping any Chapter title,toggle switch options to Mark it as \" Excluded from Syllabus\" is shown to the user");
		}
		assert1.assertTrue(status);

		osbl.excludeFromSyllabus.click();

		status=Boolean.parseBoolean(osbl.excludeFromSyllabus.getAttribute("clickable"));
		if(status) {

			System.out.println("User can toggle the switch \" ON \" to mark the status of the chapter as \"Excluded from Syllabus\"");
			test.log(Status.INFO, "User can toggle the switch \" ON \" to mark the status of the chapter as \"Excluded from Syllabus\"");
		}
		assert1.assertTrue(status);

		MobileElement status1=getDriver().findElementByXPath("//*[contains(@text, '"+topic+"')]/preceding-sibling::android.widget.ImageView");

		status =status1.isDisplayed();
		if(status) {

			System.out.println("User can see the same status \"Excluded from Syllabus\" against that TP");
			test.log(Status.INFO, "User can see the same status \"Excluded from Syllabus\" against that TP");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}

	public void toVerify_The_Available_Resource_Of_The_BookShelf() throws Exception {


		SoftAssert assert1 = new SoftAssert();
		status=osbl.userName.isDisplayed();
		if(status) {
			System.out.println("User can be navigated to the Home page after login");
			test.log(Status.INFO, "User can be navigated to the Home page after login");
		}

		assert1.assertTrue(status);
		try
		{
			swipeUp();
		}
		catch (Exception e) {
		}
		osbl.syllabus.click();;
		status=osbl.syllabusSectionHeading.isDisplayed();

		assert1.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab shown to the user on Home Page is tappable");
			test.log(Status.INFO, "Syllabus tab shown to the user on Home Page is tappable");
		}
		for(MobileElement book : osbl.books) {
			status=	book.isDisplayed();

			assert1.assertTrue(status);
			if (status) {
				System.out.println(book.getText()+" book is displayed");
				test.log(Status.INFO, book.getText()+" book is displayed");
			}

			assert1.assertAll();
		}
	}
}

