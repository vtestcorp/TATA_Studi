package studi.co.pageModules;

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
import studi.co.pageObjects.Object_Syllabus;

public class Module_Syllabus_Section extends BaseClass {
	Object_Syllabus oso = new Object_Syllabus();

	public void toVerify_Syllabus_Option() {

		Boolean status;
		SoftAssert assert1 = new SoftAssert();
		status = oso.userName.isDisplayed();
		if (status) {
			System.out.println("User can be navigated to the Home page after login");
			test.log(Status.INFO, "User can be navigated to the Home page after login");
		}

		assert1.assertTrue(status);

		status = oso.syllabus.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab is shown to the user on Home Page");
			test.log(Status.INFO, "Syllabus tab is shown to the user on Home Page");
		}
		assert1.assertAll();
	}

	public void toVerify_Syllabus_Options_Should_Be_Tappable() throws Exception {

		Boolean status;
		oso = new Object_Syllabus();
		SoftAssert assert1 = new SoftAssert();
		status = oso.userName.isDisplayed();
		if (status) {
			System.out.println("User can be navigated to the Home page after login");
			test.log(Status.INFO, "User can be navigated to the Home page after login");
		}

		assert1.assertTrue(status);
		swipeUp();
		oso.syllabus.click();
		;
		status = oso.syllabusSectionHeading.isDisplayed();

		assert1.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab shown to the user on Home Page is tappable");
			test.log(Status.INFO, "Syllabus tab shown to the user on Home Page is tappable");
		}
		assert1.assertAll();
	}

	public void toVerify_The_Available_Resource_Of_The_BookShelf() throws Exception {
		toVerify_Syllabus_Options_Should_Be_Tappable();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		// List<MobileElement>
		// books=getDriver().findElementsById("com.tce.studi:id/tv_book_name");
		Thread.sleep(2000);
		for (MobileElement book : oso.books) {
			status = book.isDisplayed();
			assert1.assertTrue(status);
			if (status) {
				// System.out.println(book.getText() + " book is displayed");
				// test.log(Status.INFO, book.getText() + " book is displayed");
			}

			assert1.assertAll();
		}

	}

	public void toVerify_Grade_School_Details_And_Education_Board_Details() throws Exception {

		SoftAssert assert1 = new SoftAssert();
		Boolean status;
		status = oso.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		status = findElementByText("Syllabus").isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab displayed");
			test.log(Status.INFO, "Syllabus tab displayed");
		}
		// scrollTo2("Assignments");
		oso.syllabus.click();
		Thread.sleep(2000);
		scrollTo2("Class");
		swipeUp();
		status = oso.grade.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Grade is displayed");
			test.log(Status.INFO, "Grade is displayed");
		}
		status = oso.editButton.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Edit icon is displayed");
			test.log(Status.INFO, "Edit icon is displayed");
		}

		oso.editButton.click();
		status = oso.assign.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Edit icon is tappable");
			test.log(Status.INFO, "Edit icon is tappable");
		}
		assert1.assertAll();
	}

	public void toVerify_User_Should_Be_Shown_Completed_In_School_Status() throws Exception {
		Boolean status;
		SoftAssert assert1 = new SoftAssert();
		String subject = "Geography";

		toVerify_The_Available_Resource_Of_The_BookShelf();

		status = oso.status.isDisplayed();
		if (status) {

			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");

		}
		assert1.assertTrue(status);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		System.out.println(oso.lessonPanel08.getAttribute("resource-id"));

		List<MobileElement> lessons = oso.lessonPanel08.findElementsById("com.tce.studi:id/tvTopic");
		System.out.println(lessons.size());
		String[] lesson1 = new String[lessons.size()];
		int i = 0;
		for (MobileElement lesson : lessons) {

			lesson1[i] = lesson.getText();
			i++;
		}
		int j = 0;
		for (MobileElement lesson : lessons) {

			clickOnElement(findElementByText(lesson1[j]));
			applyExplicitWaitsUntilElementVisible(oso.completedInSchool);
			oso.completedInSchool.click();
			Thread.sleep(5000);
			clickOnElement(findElementByText(lesson1[j]));
			j++;
		}
		oso.backButton.click();

		applyExplicitWaitsUntilElementVisible(oso.statusOfChapter);
		status = oso.statusOfChapter.isDisplayed();
		assert1.assertTrue(status);
		if (status) {

			System.out.println(
					"\"Completed in School\" Status is shown to the user for those particular chapter of a book which has been marked Completed by User");
			test.log(Status.INFO,
					"\"Completed in School\" Status is shown to the user for those particular chapter of a book which has been marked Completed by User");

		}
		assert1.assertAll();
	}

	public void toVerify_User_Should_Be_Shown_Excluded_From_Syllabus_Status() throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();
		String subject = "Geography";

		status = oso.status.isDisplayed();
		if (status) {

			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");

		}
		assert1.assertTrue(status);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));
		System.out.println(oso.lessonPanel08.getAttribute("resource-id"));
		List<MobileElement> lessons = oso.lessonPanel08.findElementsById("com.tce.studi:id/tvTopic");
		System.out.println(lessons.size());
		String[] lesson1 = new String[lessons.size()];
		int i = 0;
		for (MobileElement lesson : lessons) {

			lesson1[i] = lesson.getText();
			i++;
		}
		int j = 0;
		for (MobileElement lesson : lessons) {

			clickOnElement(findElementByText(lesson1[j]));
			applyExplicitWaitsUntilElementVisible(oso.excludeFromSyllabus);
			oso.excludeFromSyllabus.click();
			Thread.sleep(5000);
			clickOnElement(findElementByText(lesson1[j]));
			j++;
		}
		oso.backButton.click();

		applyExplicitWaitsUntilElementVisible(oso.statusOfChapter);
		status = oso.statusOfChapter.isDisplayed();
		assert1.assertTrue(status);
		if (status) {

			System.out.println(
					"\"Excluded from Syllabus\" Status is shown to the user for those particular chapter of a book,which is excluded from the users curriculum OR by marking it Excluded manually");
			test.log(Status.INFO,
					"\"Excluded from Syllabus\" Status is shown to the user for those particular chapter of a book,which is excluded from the users curriculum OR by marking it Excluded manually");

		}
	}

	public void toVerify_User_Should_Able_To_Mark_The_Chapter_As_Completed_In_School_Manually(String subject,
			String topic) throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;

		SoftAssert assert1 = new SoftAssert();

		status = oso.status.isDisplayed();
		if (status) {
			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(oso.subjectHeading);
		status = oso.subjectHeading.isDisplayed();
		if (status) {

			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic);
		clickOnElement(findElementByText(topic));

		applyExplicitWaitsUntilElementVisible(oso.completedInSchool);
		status = oso.completedInSchool.isDisplayed();
		if (status) {

			System.out.println("User able to tap on any chapter");
			System.out.println("User able to tap on any chapter");
			test.log(Status.INFO,
					"On tapping any Chapter title,toggle switch options to Mark it as \" Completed In School\" is shown to the user");
			test.log(Status.INFO,
					"On tapping any Chapter title,toggle switch options to Mark it as \" Completed In School\" is shown to the user");
		}
		assert1.assertTrue(status);

		status = Boolean.parseBoolean(oso.completedInSchool.getAttribute("clickable"));
		if (status) {

			System.out.println(
					"User can toggle the switch \" ON \" to mark the status of the chapter as \"Completed in School\"");
			test.log(Status.INFO,
					"User can toggle the switch \" ON \" to mark the status of the chapter as \"Completed in School\"");
		}
		assert1.assertTrue(status);
		clickOnElement(findElementByText(topic));

		System.out.println(oso.lessonPanel08.getAttribute("resource-id"));

		List<MobileElement> lessons = oso.lessonPanel08.findElementsById("com.tce.studi:id/tvTopic");
		System.out.println(lessons.size());
		String[] lesson1 = new String[lessons.size()];
		int i = 0;
		for (MobileElement lesson : lessons) {

			lesson1[i] = lesson.getText();
			i++;
		}
		int j = 0;
		for (MobileElement lesson : lessons) {

			clickOnElement(findElementByText(lesson1[j]));
			applyExplicitWaitsUntilElementVisible(oso.completedInSchool);
			oso.completedInSchool.click();
			Thread.sleep(2000);
			clickOnElement(findElementByText(lesson1[j]));
			j++;
		}
		oso.backButton.click();

		applyExplicitWaitsUntilElementVisible(oso.statusOfChapter);
		status = oso.statusOfChapter.isDisplayed();
		assert1.assertTrue(status);
		if (status) {

			System.out.println(
					"\"Completed in School\" Status is shown to the user for those particular chapter of a book which has been marked Completed by User");
			test.log(Status.INFO,
					"\"Completed in School\" Status is shown to the user for those particular chapter of a book which has been marked Completed by User");

		}
		assert1.assertAll();

	}

	public void toVerify_User_Should_Able_To_Mark_The_Chapter_As_Excluded_From_Syllabus_Manually(String subject,
			String topic) throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status = oso.status.isDisplayed();
		if (status) {
			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(oso.subjectHeading);
		status = oso.subjectHeading.isDisplayed();
		if (status) {

			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic);
		clickOnElement(findElementByText(topic));

		applyExplicitWaitsUntilElementVisible(oso.excludeFromSyllabus);
		status = oso.excludeFromSyllabus.isDisplayed();
		if (status) {

			System.out.println("User able to tap on any chapter");
			System.out.println("User able to tap on any chapter");
			test.log(Status.INFO,
					"On tapping any Chapter title,toggle switch options to Mark it as \" Excluded from Syllabus\" is shown to the user");
			test.log(Status.INFO,
					"On tapping any Chapter title,toggle switch options to Mark it as \" Excluded from Syllabus\" is shown to the user");
		}
		assert1.assertTrue(status);

		status = Boolean.parseBoolean(oso.excludeFromSyllabus.getAttribute("clickable"));
		if (status) {

			System.out.println(
					"User can toggle the switch \" ON \" to mark the status of the chapter as \"Excluded from Syllabus\"");
			test.log(Status.INFO,
					"User can toggle the switch \" ON \" to mark the status of the chapter as \"Excluded from Syllabus\"");
		}
		assert1.assertTrue(status);
		clickOnElement(findElementByText(topic));

		System.out.println(oso.lessonPanel08.getAttribute("resource-id"));

		List<MobileElement> lessons = oso.lessonPanel08.findElementsById("com.tce.studi:id/tvTopic");
		System.out.println(lessons.size());
		String[] lesson1 = new String[lessons.size()];
		int i = 0;
		for (MobileElement lesson : lessons) {

			lesson1[i] = lesson.getText();
			i++;
		}
		int j = 0;
		for (MobileElement lesson : lessons) {

			clickOnElement(findElementByText(lesson1[j]));
			applyExplicitWaitsUntilElementVisible(oso.excludeFromSyllabus);
			oso.excludeFromSyllabus.click();
			Thread.sleep(2000);
			clickOnElement(findElementByText(lesson1[j]));
			j++;
		}
		oso.backButton.click();

		applyExplicitWaitsUntilElementVisible(oso.statusOfChapter);
		status = oso.statusOfChapter.isDisplayed();
		assert1.assertTrue(status);
		if (status) {

			System.out.println(
					"\"Excluded from Syllabus\" Status is shown to the user for those particular chapter of a book which has been marked Completed by User");
			test.log(Status.INFO,
					"\"Excluded from Syllabus\" Status is shown to the user for those particular chapter of a book which has been marked Completed by User");

		}
		assert1.assertAll();
	}

	public void toVerify_User_Should_Be_Shown_Status_Of_Each_TP(String subject, String topic) throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status = oso.status.isDisplayed();
		if (status) {
			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(oso.subjectHeading);
		status = oso.subjectHeading.isDisplayed();
		if (status) {

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
		// swipeTop();

		applyExplicitWait(5);
		scrollTo2(topic);
		applyExplicitWait(5);
		List<MobileElement> list = getDriver().findElements(By.id("com.tce.studi:id/tvTopic"));
		System.out.println("Topics available in given chapter are :");
		System.out.println(list.size());
		int i = 1;
		for (MobileElement topic1 : list) {
			assert1.assertTrue(topic1.isDisplayed());
			test.log(Status.INFO, "Topic " + i + " is Displayed");
			System.out.println(topic1.getText());
			i++;
			MobileElement confidenceStatus = getDriver().findElementByXPath(
					"//*[contains(@text, '" + topic1.getText() + "')]/preceding-sibling::android.widget.ImageView");
			assert1.assertTrue(confidenceStatus.isDisplayed());
		}

		test.log(Status.INFO, "Confidence Score/Status is shown to the user against  every TP");
		System.out.println("Confidence Score/Status is shown to the user against  every TP");

		assert1.assertAll();
	}

	public void toVerify_User_Should_Able_To_Mark_The_TPs_As_Completed_In_School_Manually(String subject, String topic)
			throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status = oso.status.isDisplayed();
		if (status) {
			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(oso.subjectHeading);
		status = oso.subjectHeading.isDisplayed();
		if (status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic);
		clickOnElement(findElementByText(topic));

		applyExplicitWaitsUntilElementVisible(oso.completedInSchool);
		status = oso.completedInSchool.isDisplayed();
		if (status) {

			System.out.println("User able to tap on any chapter");
			System.out.println(
					"On tapping any Chapter title,toggle switch options to Mark it as \" Completed In School\" is shown to the user");
			test.log(Status.INFO, "User able to tap on any chapter");
			test.log(Status.INFO,
					"On tapping any Chapter title,toggle switch options to Mark it as \" Completed In School\" is shown to the user");
		}
		assert1.assertTrue(status);

		oso.completedInSchool.click();

		status = Boolean.parseBoolean(oso.completedInSchool.getAttribute("clickable"));
		if (status) {

			System.out.println(
					"User can toggle the switch \" ON \" to mark the status of the chapter as \"Completed in School\"");
			test.log(Status.INFO,
					"User can toggle the switch \" ON \" to mark the status of the chapter as \"Completed in School\"");
		}
		assert1.assertTrue(status);
		// @
		MobileElement status1 = getDriver().findElementByXPath(
				"//*[contains(@text, '" + topic + "')]/preceding-sibling::android.widget.ImageView");

		status = status1.isDisplayed();
		if (status) {

			System.out.println("User can see the same status \"Completed in School\" against that TP");
			test.log(Status.INFO, "User can see the same status \"Completed in School\" against that TP");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}

	public void toVerify_User_Should_Able_To_Mark_The_TPs_As_Excluded_From_Syllabus_Manually(String subject,
			String topic) throws Exception {
		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status = oso.status.isDisplayed();
		if (status) {
			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		applyExplicitWaitsUntilElementVisible(oso.subjectHeading);
		status = oso.subjectHeading.isDisplayed();
		if (status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic);

		clickOnElement(findElementByText(topic));

		applyExplicitWaitsUntilElementVisible(oso.excludeFromSyllabus);
		status = oso.excludeFromSyllabus.isDisplayed();
		if (status) {

			System.out.println("User able to tap on any chapter");
			System.out.println(
					"On tapping any Chapter title,toggle switch options to Mark it as \" Excluded from Syllabus\" is shown to the user");
			test.log(Status.INFO, "User able to tap on any chapter");
			test.log(Status.INFO,
					"On tapping any Chapter title,toggle switch options to Mark it as \" Excluded from Syllabus\" is shown to the user");
		}
		assert1.assertTrue(status);

		oso.excludeFromSyllabus.click();

		status = Boolean.parseBoolean(oso.excludeFromSyllabus.getAttribute("clickable"));
		if (status) {

			System.out.println(
					"User can toggle the switch \" ON \" to mark the status of the chapter as \"Excluded from Syllabus\"");
			test.log(Status.INFO,
					"User can toggle the switch \" ON \" to mark the status of the chapter as \"Excluded from Syllabus\"");
		}
		assert1.assertTrue(status);

		MobileElement status1 = getDriver().findElementByXPath(
				"//*[contains(@text, '" + topic + "')]/preceding-sibling::android.widget.ImageView");

		status = status1.isDisplayed();
		if (status) {

			System.out.println("User can see the same status \"Excluded from Syllabus\" against that TP");
			test.log(Status.INFO, "User can see the same status \"Excluded from Syllabus\" against that TP");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}

	public void toVerify_User_Should_Be_Shown_Low_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence(
			String subject_low, String topic_low) throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status = oso.status.isDisplayed();
		if (status) {
			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject_low);
		clickOnElement(findElementByText(subject_low));

		applyExplicitWaitsUntilElementVisible(oso.subjectHeading);
		status = oso.subjectHeading.isDisplayed();
		if (status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic_low);
		clickOnElement(findElementByText(topic_low));

		scrollTo2("Practice");
		clickOnElement(findElementByText("Practice"));
		applyExplicitWaitsUntilElementVisible(findElementByText("you"));
		clickOnElement(findElementByText("Practice"));

		applyExplicitWaitsUntilElementVisible(oso.question1_part_Text);
		String questionCount = oso.quetionCount.getText();
		String[] s = questionCount.split("of");
		String s1 = s[1].trim();
		int question = Integer.parseInt(s1);

		for (int j = 0; j < question / 4; j++) {
			if (verifySCQorMCQ().equalsIgnoreCase("scq") || verifySCQorMCQ().equalsIgnoreCase("mcq")) {
				applyExplicitWaitsUntilElementVisible(oso.question1_part_Text);
				selectIncorrectAnswer();
				clickOnElement(findElementByText("Check"));
				Thread.sleep(300);
				try {
					clickOnElement(driver.findElement(By.id("com.tce.studi:id/tvSecondaryAction")));
				} catch (Exception e) {
				}
				clickOnElement(findElementByText("Continue"));

			}
		}
		clickOnElement(oso.backButton);
		clickOnElement(findElementByText("Yes"));

		applyExplicitWaitsUntilElementVisible(oso.target);
		oso.hamBurgerMenu.click();
		applyExplicitWaitsUntilElementVisible(oso.returnTitle);
		oso.returnTitle.click();
		Thread.sleep(3000);

		scrollTo2(topic_low);

		tapOnElement(driver.findElement(By.xpath("//*[contains(@text, '" + topic_low + "')]/parent::*"))
				.findElement(By.id("com.tce.studi:id/ivTopic")));
		String msg = oso.confidence_status.getText();
		System.err.println(msg);
		assert1.assertEquals(msg, "Low Confidence");
		{
			System.out.println(
					"Low Confidence Status is shown to the user for those particular TP for which user has scored Medium Confidence");
			test.log(Status.INFO,
					"Low Confidence Status is shown to the user for those particular TP for which user has scored Medium Confidence");
		}
		assert1.assertAll();

	}

	public void toVerify_User_Should_Be_Shown_High_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence(
			String subject_eng, String topic_eng) throws Exception {

		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status = oso.status.isDisplayed();
		if (status) {
			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject_eng);
		clickOnElement(findElementByText(subject_eng));

		applyExplicitWaitsUntilElementVisible(oso.subjectHeading);
		status = oso.subjectHeading.isDisplayed();
		if (status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(subject_eng);
		clickOnElement(findElementByText(subject_eng));

		applyExplicitWaitsUntilElementVisible(oso.subjectHeading);
		status = oso.subjectHeading.isDisplayed();
		if (status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(subject_eng);
		clickOnElement(findElementByText(subject_eng));

		applyExplicitWaitsUntilElementVisible(oso.subjectHeading);
		status = oso.subjectHeading.isDisplayed();
		if (status) {
			System.out.println("User able to tap on any book");
			test.log(Status.INFO, "User able to tap on the book");
		}
		assert1.assertTrue(status);

		scrollTo2(topic_eng);
		clickOnElement(findElementByText(topic_eng));

		scrollTo2("Practice");
		clickOnElement(findElementByText("Practice"));
		applyExplicitWaitsUntilElementVisible(findElementByText("you"));
		clickOnElement(findElementByText("Practice"));

		applyExplicitWaitsUntilElementVisible(oso.question1_part_Text);
		String questionCount = oso.quetionCount.getText();
		String[] s = questionCount.split("of");
		String s1 = s[1].trim();
		int question = Integer.parseInt(s1);

		for (int j = 0; j < question; j++) {

			applyExplicitWaitsUntilElementVisible(oso.question1_part_Text);
			applyExplicitWaitsUntilElementVisible(oso.quetionCount);

			selectCorrectAnswer();
			clickOnElement(findElementByText("Check"));

			clickOnElement(findElementByText("Continue"));
		}

		applyExplicitWaitsUntilElementVisible(oso.target);
		oso.hamBurgerMenu.click();
		applyExplicitWaitsUntilElementVisible(oso.returnTitle);
		oso.returnTitle.click();
		scrollTo2(topic_eng);
		tapOnElement(driver.findElement(By.xpath("//*[contains(@text, '" + topic_eng + "')]/parent::*"))
				.findElement(By.id("com.tce.studi:id/ivTopic")));

		String msg = oso.confidence_status.getText();
		System.err.println(msg);
		assert1.assertEquals("High Confidence", msg);
		{
			System.out.println(
					"High Confidence Status is shown to the user for those particular TP for which user has scored High Confidence");
			test.log(Status.INFO,
					"High Confidence Status is shown to the user for those particular TP for which user has scored Hign Confidence");
		}
		assert1.assertTrue(status);
		assert1.assertAll();
	}

	public void toVerify_User_Should_Be_Shown_Medium_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence(
			String subject_eng, String topic_medium) throws Exception {
		toVerify_The_Available_Resource_Of_The_BookShelf();
		Boolean status;
		SoftAssert assert1 = new SoftAssert();

		status = oso.status.isDisplayed();
		if (status) {
			System.out.println(
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
			test.log(Status.INFO,
					"Various status of each chapter against every book listed in its Curriculum is shown to the User");
		}
		assert1.assertTrue(status);

		scrollTo2(subject_eng);
		clickOnElement(findElementByText(subject_eng));

		applyExplicitWaitsUntilElementVisible(oso.subjectHeading);
		status = oso.subjectHeading.isDisplayed();
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
		applyExplicitWaitsUntilElementVisible(oso.question1_part_Text);
		String questionCount = oso.quetionCount.getText();
		String[] s = questionCount.split("of");
		String s1 = s[1].trim();
		int question = Integer.parseInt(s1);

		for (int j = 1; j <= question; j++) {

			if (j == 0) {

				applyExplicitWaitsUntilElementVisible(oso.question1_part_Text);

				// swipeUp();
				selectCorrectAnswer();
				clickOnElement(findElementByText("Check Answer"));

				clickOnElement(findElementByText("Continue"));
			}

			else {

				applyExplicitWaitsUntilElementVisible(oso.question1_part_Text);
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

		applyExplicitWaitsUntilElementVisible(oso.target);
		oso.hamBurgerMenu.click();
		applyExplicitWaitsUntilElementVisible(oso.returnTitle);
		oso.returnTitle.click();

		scrollTo2(topic_medium);

		tapOnElement(driver.findElement(By.xpath("//*[contains(@text, '" + topic_medium + "')]/parent::*"))
				.findElement(By.id("com.tce.studi:id/ivTopic")));
		String msg = oso.confidence_status.getText();

		assert1.assertEquals("Medium Confidence", msg);
		{
			System.out.println(
					"Medium Confidence Status is shown to the user for those particular TP for which user has scored Medium Confidence");
			test.log(Status.INFO,
					"Medium Confidence Status is shown to the user for those particular TP for which user has scored Medium Confidence");
		}

		assert1.assertAll();

	}

}
