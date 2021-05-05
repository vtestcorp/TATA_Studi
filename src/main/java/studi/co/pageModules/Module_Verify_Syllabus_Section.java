package studi.co.pageModules;

import java.awt.AWTException;
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
import studi.co.pageObjects.Object_Syllabus_Section;

public class Module_Verify_Syllabus_Section extends BaseClass {
	Object_Syllabus_Section osm=new Object_Syllabus_Section();

	public void verify_Begin_Practise_Link() throws Exception {
		SoftAssert assert1 = new SoftAssert();
		String subject = "Political Science";
		String topic1 = "Diversity in India";
		osm.syllabus.click();

		applyExplicitWait(5);
		scrollTo2(subject);
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
		scrollTo2(topic1);
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
		clickOnElement(findElementByText(topic1));
		test.log(Status.INFO, "Clicked on "+topic1);

		applyExplicitWait(5);

		Boolean verify = osm.practise.isDisplayed();
		if(verify) {
			System.out.println("Begin Practise link displayed under topic name");
			test.log(Status.INFO, "Begin Practise link displayed under topic name");
		}
		assert1.assertTrue(verify);
		osm.practise.click();
		applyExplicitWait(5);

		Boolean topicHeading=osm.comparingNumberHeading.isDisplayed();
		if(topicHeading) {
			System.out.println("Begin Practise link is functional");
			test.log(Status.INFO, "Begin Practise link is functional");
		}
		assert1.assertTrue(topicHeading);
		assert1.assertAll();
	}

	public void verify_beginPractise_Button() throws Exception {
		SoftAssert assert1=new SoftAssert();
		//		String subject="Mathematics";
		//		String topic1="Comparing Numbers";

		//		verify_Begin_Practise_Link();	

		String subject = "Political Science";
		String topic1 = "Diversity in India";

		osm = new Object_Syllabus_Section();
		osm.syllabus.click();

		applyExplicitWait(5);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));
		test.log(Status.INFO, "Cilcked on "+subject+" subject");
		clickOnElement(findElementByText(topic1));
		test.log(Status.INFO, "Clicked on "+topic1);
		applyExplicitWait(5);
		osm.practise.click();
		applyExplicitWait(5);
		Boolean verify = osm.topicHeading.isDisplayed();
		test.log(Status.INFO, "Heading is displayed as :" + osm.topicHeading.getText());
		System.out.println("Heading is displayed as : " + osm.topicHeading.getText());
		assert1.assertTrue(verify);
		List<MobileElement> list_Topics = getDriver().findElementsById("com.tce.studi:id/tvQuesId");

		System.out.println(" Topics are available as follows");
		test.log(Status.INFO, "Topics displayed are as follows :");
		for (MobileElement topic : list_Topics) {
			assert1.assertTrue(topic.isDisplayed());
			test.log(Status.INFO, topic.getText());
		}

		List<MobileElement> list_videoIcons = getDriver().findElementsById("com.tce.studi:id/imgFlagId");
		for(MobileElement video: list_videoIcons) {
			assert1.assertTrue(video.isDisplayed());
		}
		System.out.println("Video Icon is displayed after each Questions");
		test.log(Status.INFO, " Video Icon is displayed after each Questions");
		assert1.assertAll();
	}

	public void verify_Practise_Quetions() throws Exception {
		//		verify_beginPractise_Button();
		String subject = "Political Science";
		String topic1 = "Diversity in India";

		osm = new Object_Syllabus_Section();
		//		scrollTo2("Syllabus");
		osm.syllabus.click();

		applyExplicitWait(5);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));
		test.log(Status.INFO, "Cilcked on "+subject+" subject");
		clickOnElement(findElementByText(topic1));
		test.log(Status.INFO, "Clicked on "+topic1+" Topic");
		applyExplicitWait(5);
		Thread.sleep(3000);
		//		osm.practice.click();
		clickOnElement(findElementByText("Practice"));
		applyExplicitWaitsUntilElementVisible(osm.practice1);
		//		osm.practice1.click();
		//applyExplicitWaitsUntilElementVisible(getDriver().findElementById("com.tce.studi:id/tv_heading_id"));
		applyExplicitWaitsUntilElementVisible(osm.topicHeader);
		clickOnElement(findElementByText("Practice"));

		applyExplicitWait(30);
		int quetionsCount = verify_Question_Count_In_Test_Module();

		SoftAssert soft = new SoftAssert();
		for (int i = 1; i <= quetionsCount; i++) {

			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(osm.question1_part_Text));

			Boolean verify = osm.question1_part_Text.isDisplayed();

			soft.assertTrue(verify);
			System.out.println("Question No-"+i+" Checked");
			applyExplicitWait(10);
			osm.i_will_attempt_later.click();
			System.out.println("Clicked on attempt later button");
			applyExplicitWait(10);
		}
		test.log(Status.INFO, "List of Questions are displayed to the User");
		soft.assertAll();

	}



	public void verify_User_Can_attempt_PractiseQuetions() throws Exception {

		String subject="Political Science";
		String topic1="Diversity in India";

		osm = new Object_Syllabus_Section();
		osm.syllabus.click();

		applyExplicitWait(5);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));
		test.log(Status.INFO, "Cilcked on "+subject+" Subject");
		clickOnElement(findElementByText(topic1));
		test.log(Status.INFO, "Clicked on "+topic1+" Topic");
		applyExplicitWait(5);
		//		osm.practise.click();
		clickOnElement(findElementByText("Practice"));
		//applyExplicitWaitsUntilElementVisible(getDriver().findElementById("com.tce.studi:id/tv_heading_id"));
		applyExplicitWaitsUntilElementVisible(osm.topicHeader);
		clickOnElement(findElementByText("Practice"));
		//		osm.practice1.click();
		int quetionsCount = verify_Question_Count_In_Test_Module();

		SoftAssert assert1 = new SoftAssert();

		for(int i=0;i<quetionsCount;i++) {
			Thread.sleep(3000);
			List<MobileElement> checkbox=getDriver().findElements(By.className("android.widget.CheckBox"));
			System.out.println(checkbox.size());
			int j=1;
			applyExplicitWaitsUntilElementVisible(osm.question1_part_Text);
			scrollToEnd();
			for(MobileElement check : checkbox) {
				new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(check));

				Boolean verify=	check.isDisplayed();
				System.out.println("Answer option no-"+j+" is displayed");
				assert1.assertTrue(verify);
				j++;
			}

			Boolean verify_checkAnswer=osm.check_answer.isDisplayed();
			if(verify_checkAnswer) {
				System.out.println("Check Answer Button displayed");

			}
			else {
				System.out.println("Check answer button is not available");
			}
			assert1.assertTrue(verify_checkAnswer);

			applyExplicitWait(10);
			osm.i_will_attempt_later.click();
			System.out.println("Clicked on attempt later button");
			applyExplicitWait(10);
		}
		test.log(Status.INFO, "Check Answer Button is displayed to each Question");
		test.log(Status.INFO, "Answer options are displayed to each Quetion");
		applyExplicitWait(10);
		applyExplicitWaitsUntilElementVisible(osm.question1_part_Text);

		scrollToEnd();
		selectCorrectAnswer();
		osm.check_answer.click();
		applyExplicitWaitsUntilElementVisible(osm.right_Answer_message);
		Boolean check_message=osm.right_Answer_message.isDisplayed();
		if(check_message) {
			//		test.log(Status.INFO, "Great job! Let's continue.- message displayed after clicking on right answer");
			test.log(Status.INFO, "Answer option converted in green smiley icon if answer is correct");

			System.out.println("Great job! Let's continue.- message displayed");
		}
		else {
			System.out.println("Selected answer is wrong");
		}
		assert1.assertTrue(check_message);

		osm.continue1.click();
		applyExplicitWaitsUntilElementVisible(osm.question1_part_Text);
		scrollToEnd();


		scrollToEnd();
		selectIncorrectAnswer();
		osm.check_answer.click();
		applyExplicitWaitsUntilElementVisible(osm.wrong_Answer_message);
		Boolean check_wrong_message=osm.wrong_Answer_message.isDisplayed();
		if(check_wrong_message) {
			System.out.println("Wrong answer message is displayed after clicking on wrong answer");
			//			test.log(Status.INFO, "Wrong answer message is displayed after clicking on wrong answer");
			test.log(Status.INFO, "Answer option converted in Red color smiley if answer is incorrect");
		}
		assert1.assertTrue(check_wrong_message);

		Boolean tryAgain=osm.try_Again_Button.isDisplayed();
		assert1.assertTrue(tryAgain);
		if(tryAgain) {
			System.out.println("Try Again Button is displayed");
			test.log(Status.INFO, "Try Again Button is displayed");
		}
		assert1.assertAll();

	}

	public void toVerify_ProperFeedBack_forCorrectOption() throws MalformedURLException, AWTException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		to_Launch_Practise_Quetions_Quiz();
		applyExplicitWaitsUntilElementVisible(osm.question1_part_Text);
		//scrollToEnd();
		Thread.sleep(2000);
		selectCorrectAnswer();
		osm.check_answer.click();
		applyExplicitWaitsUntilElementVisible(osm.right_Answer_message);
		if(osm.right_Answer_message.getText().equals("Great job! Let's continue.")) {
			test.log(Status.INFO, "Great job! Let's continue.- message displayed and green smiley icon is displayed");
			applyExplicitWait(5);
			String check_message=osm.right_Answer_message.getText();
			assert1.assertEquals(check_message, "Great job! Let's continue.");
		}


		Boolean verify=	osm.continue_Button.isDisplayed();
		if(verify.equals(true)) {
			test.log(Status.INFO, "Continue Button is displayed");
			System.out.println("Continue button is displayed");
		}
		else {
			System.out.println("Continue button is not displayed");
			test.log(Status.INFO, "Continue button is not displayed");
		}
		assert1.assertTrue(verify);
		assert1.assertAll();
	}

	public void toVerify_Warning_Message() throws MalformedURLException, InterruptedException{
		SoftAssert assert1=new SoftAssert();
		to_Launch_Practise_Quetions_Quiz();
		osm = new Object_Syllabus_Section();
		applyExplicitWaitsUntilElementVisible(osm.question1_part_Text);
		applyExplicitWaitsUntilElementVisible(osm.back_Button);
		osm.back_Button.click();
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(osm.warning_Message_1);
		String warning_Message_1=osm.warning_Message_1.getText();
		String warning_Message_2=osm.warning_Message_2.getText();

		Boolean warning_verify_1=osm.warning_Message_1.isDisplayed();
		Boolean warning_verify_2=osm.warning_Message_2.isDisplayed();

		assert1.assertTrue(warning_verify_1);
		assert1.assertTrue(warning_verify_2);

		if(warning_Message_1.equals("Are you sure want to go Away?") && warning_Message_2.equals("Your Progress will be lost.")) {
			test.log(Status.INFO, "Warning message shown to the User after clicking on Back button");
			System.out.println("Warning message shown to the User after clicking on Back button");
		}


		Boolean yes_Button=osm.yes_Button.isDisplayed();
		Boolean no_Button=osm.no_Button.isDisplayed();

		if(yes_Button) {
			test.log(Status.INFO, "Yes button is displayed");
			System.out.println("Yes button is displayed");
		}
		else {
			test.log(Status.INFO, "Yes button is not displayed");
			System.out.println("Yes button is not displayed");
		}

		if(no_Button) {
			test.log(Status.INFO, "No button is displayed");
			System.out.println("No button is displayed");
		}
		else {
			test.log(Status.INFO, "No button is not displayed");
			System.out.println("No button is not displayed");
		}
		assert1.assertTrue(yes_Button);
		assert1.assertTrue(no_Button);

		osm.no_Button.click();
		applyExplicitWait(5);
		if(osm.question1_part_Text.isDisplayed()) {
			test.log(Status.INFO, "User can navigated back to practise quiz after clicking on No button");
			System.out.println("User can navigated back to practise quiz after clicking on No button");
		}

		osm.back_Button.click();
		osm.yes_Button.click();

		applyExplicitWait(5);
		if(osm.your_Confidence_Report.isDisplayed()) {
			test.log(Status.INFO, "User can navigated back to Topic Listing Page after clicking on Yes button");
			System.out.println("User can navigated back to Topic Listing Page after clicking on Yes button");
		}
	}

	public void toVerify_ProperFeedBack_forInCorrectOption() throws MalformedURLException, InterruptedException, AWTException {
		SoftAssert assert1=new SoftAssert();
		to_Launch_Practise_Quetions_Quiz();
		applyExplicitWaitsUntilElementVisible(osm.question1_part_Text);
		//swipeUp();
		//scrollToEnd();
		selectIncorrectAnswer();
		osm.check_answer.click();
		String check_message=osm.wrong_Answer_message.getText();
		if(osm.wrong_Answer_message.getText().equals("Uh-oh! Give it another shot!")) {
			test.log(Status.INFO, "Text changed to red color with a red color smiley on answering the question incorrectly with proper explanation below the incorrect option");
			applyExplicitWait(5);
			assert1.assertEquals(check_message, "Uh-oh! Give it another shot!");
		}

		Boolean try_Button=osm.try_Again_Button.isDisplayed();
		assert1.assertTrue(try_Button);
		if(try_Button) {
			System.out.println("TRY AGAIN button is displayed");
			test.log(Status.INFO, "TRY AGAIN button is displayed");

		}
		else {
			System.out.println("TRY AGAIN button is not displayed");
			test.log(Status.INFO, "TRY AGAIN button is not displayed");
		}

		Boolean I_dont_know=osm.I_dont_know_Button.isDisplayed();
		assert1.assertTrue(I_dont_know);
		if(I_dont_know) {
			System.out.println("I dont know button is displayed");
			test.log(Status.INFO, "I dont know button is displayed");

		}
		else {
			System.out.println("I dont know button is not displayed");
			test.log(Status.INFO, "I dont know button is not displayed");

		}
		assert1.assertTrue(I_dont_know);

		applyExplicitWait(5);
		osm.I_dont_know_Button.click();
		//	Keyword.scrollToEnd();
		//	applyExplicitWait(5);
		Thread.sleep(5000);
		scrollTo2("Here you go");
		Boolean thatsRight=osm.hereYouGo.isDisplayed();
		if(thatsRight) {
			System.out.println("Correct answer is displayed after clicking on I dont Know button");
			test.log(Status.INFO, "Correct answer is displayed after clicking on I dont Know button");
		}
		else {
			System.out.println("Correct answer is not displayed after clicking on I dont Know button");
			test.log(Status.INFO, "Correct answer is not displayed after clicking on I dont Know button");

		}
		assert1.assertTrue(thatsRight);


		Boolean continue_Button=osm.continue1.isDisplayed();
		if(continue_Button) {
			System.out.println("Continue Button is displayed");
			test.log(Status.INFO, "Continue Button is displayed");
		}
		else {
			System.out.println("Continue Button is not displayed");
			test.log(Status.INFO, "Continue Button is not displayed");

		}
		assert1.assertTrue(continue_Button);

		applyExplicitWait(5);
		osm.continue1.click();
		applyExplicitWait(5);

		applyExplicitWaitsUntilElementVisible(osm.question1_part_Text);

		scrollToEnd();
		selectIncorrectAnswer();
		osm.check_answer.click();

		osm.try_Again_Button.click();
		applyExplicitWait(5);

		String errorMessage=osm.you_have_one_attempt_left.getText();
		if(errorMessage.equals("You have one attempt left")) {
			test.log(Status.INFO, "You have one attempt left - heading is displayed after clicking on TRY AGAIN Button");
			System.out.println("You have one attempt left - heading is displayed after clicking on TRY AGAIN Button");
		}

		Boolean checkAnswer=osm.check_answer.isEnabled();
		if(checkAnswer) {
			test.log(Status.INFO, "Check answer button  is enabled");
			System.out.println("Check answer button  is enabled");
		}
		else {
			test.log(Status.INFO, "Check answer button  is disabled");
			System.out.println("Check answer button is disabled");
		}

		applyExplicitWaitsUntilElementVisible(osm.question1_part_Text);
		scrollToEnd();
		Thread.sleep(2000);
		//		osm.answerOption1.click();
		//		applyExplicitWait(5);
		selectIncorrectAnswer();
		osm.check_answer.click();

		String error=osm.Not_quite_Lets_continue.getText();
		if(error.equals("Not quite. Let's continue.")) {
			//		test.log(Status.INFO, "Not quite. Let's continue.- Heading is displayed");
			System.out.println("Not quite. Let's continue.-this Heading is displayed");
		}	
		applyExplicitWait(5);
		osm.continue1.click();
		applyExplicitWait(5);

		Boolean nextPage=osm.question1_part_Text.isDisplayed();
		if(nextPage) {
			test.log(Status.INFO, "User Navigated to Next question on clicking continue button ");
			System.out.println("User Navigated to Next question on clicking continue button ");
		}

		assert1.assertTrue(nextPage);
		assert1.assertAll();
	}


	public void toVerify_Confidence_Report_Page() throws MalformedURLException, InterruptedException{

		SoftAssert assert1=new SoftAssert();
		osm = new Object_Syllabus_Section();
		String subject="Political Science";
		String topic1="Diversity in India";
		osm.syllabus.click();
		applyExplicitWait(10);
		clickOnElement(findElementByText(subject));
		System.out.println("Clicked on "+subject+" subject");
		test.log(Status.INFO, "Clicked on "+subject+" subject");
		Thread.sleep(10000);

		//		osm.estimationOfNumbers.click();
		clickOnElement(findElementByText(topic1));
		System.out.println("Clicked on "+topic1);
		test.log(Status.INFO, "Clicked on "+topic1);
		applyExplicitWait(10);
		clickOnElement(findElementByText("Practice"));
		//applyExplicitWaitsUntilElementVisible(getDriver().findElementById("com.tce.studi:id/tv_heading_id"));
		applyExplicitWaitsUntilElementVisible(osm.topicHeader);
		applyExplicitWaitsUntilElementClickable(osm.practise_Again1);
		clickOnElement(findElementByText("Practice"));
		applyExplicitWait(10);
		int quetionCount=verify_Question_Count_In_Test_Module();
		System.out.println(quetionCount);

		for(int i=1;i<=quetionCount;i++) {
			Thread.sleep(1000);
			System.out.println(i);
			applyExplicitWaitsUntilElementVisible(osm.question1_part_Text);
			//scrollToEnd();
			selectCorrectAnswer();
			osm.check_answer.click();
			applyExplicitWaitsUntilElementVisible(osm.right_Answer_message);
			applyExplicitWaitsUntilElementVisible(osm.continue1);
			osm.continue1.click();
		}
		//	//		osm.answerOption.click();
		////			applyExplicitWait(5);
		////			osm.check_answer.click();
		////			applyExplicitWait(5);
		////			Thread.sleep(2000);
		////			if(osm.right_Answer_message.getText().equals("Great job! Let's continue.")) {
		////				System.out.println("Right answer");
		////				applyExplicitWait(5);
		////				osm.continue1.click();
		////			}
		////			
		////			else if(osm.right_Answer_message.getText().equals("Uh-oh! Give it another shot!")) {
		////				System.out.println("wrong answer");
		////				osm.I_dont_know_Button.click();
		////				applyExplicitWait(5);
		////				osm.continue1.click();
		////			}
		//		
		////		applyExplicitWait(5);
		Boolean report=osm.your_Confidence_Report.isDisplayed();
		if(report) {
			System.out.println("Confidence Report is displayed");
			test.log(Status.INFO, "Confidence Report is displayed");
		}
		else {
			System.out.println("Confidence report is not displayed");
			test.log(Status.INFO, "Confidence Report is not displayed");
		}
		assert1.assertTrue(report);

		Boolean score=osm.high_Medium_Low.isDisplayed();
		if(score) {
			System.out.println("Score in High,Medium and Low sections are displayed");
			test.log(Status.INFO, "Score in High,Medium and Low sections are displayed");

		}
		else {
			System.out.println("Score in High,Medium and Low sections are not displayed");
			test.log(Status.INFO, "Score in High,Medium and Low sections are not displayed");

		}
		assert1.assertTrue(score);										

		List<MobileElement> list_Topics = getDriver().findElementsById("com.tce.studi:id/tvQuesId");

		System.out.println("Topic displayed are as below :");
		test.log(Status.INFO, "Topic displayed are as below :");
		for (MobileElement topic : list_Topics) {
			assert1.assertTrue(topic.isDisplayed());
			System.out.println(topic.getText());
			test.log(Status.INFO, topic.getText());

		}

		Boolean continue_Studying_Button=osm.continueStudying.isDisplayed();
		if(continue_Studying_Button) {
			System.out.println("Continue Studying Button is available");
			test.log(Status.INFO, "Continue Studying Button is available");

		}
		assert1.assertTrue(continue_Studying_Button);

		//	osm.continueStudying.click();
		//clickOnElement(findElementByText("Continue"));
		//applyExplicitWaitsUntilElementVisible(osm.topic_Name);

//		Boolean topic_Name=osm.topic_Name.isDisplayed();
//		if(topic_Name) {
//			System.out.println("User Navigated to next topic after clicking on Continue Studying Buttton");
//			test.log(Status.INFO, "User Navigated to next topic after clicking on Continue Studying Buttton");
//		}
//		assert1.assertTrue(topic_Name);
		//		applyExplicitWait(5);
		//		Thread.sleep(2000);
		//		osm.returnToSubject.click();
		//		Keyword.clickOnElementUsingText("Subject");
		driver.findElement(By.id("com.tce.studi:id/ivTertiaryAction")).click();
		clickOnElement(findElementByText("Return"));

		applyExplicitWait(10);
		//		applyExplicitWaitsUntilElementClickable(osm.practise3);
		//		osm.practise3.click();
		//		Keyword.clickOnElementUsingText("Practice");
		clickOnElement(findElementByText("Practice"));
		applyExplicitWait(5);
		//		Thread.sleep(10000);
		applyExplicitWaitsUntilElementVisible(osm.practise_Again1);
		//		Keyword.clickOnElementUsingText("Practice");
		clickOnElement(findElementByText("Practice"));
		//	osm.practise_Again1.click();
		applyExplicitWait(20);
		Boolean practise_Again=osm.question1_part_Text.isDisplayed();
		if(practise_Again) {
			System.out.println("Practise Again button is displayed to the User and after clicking Practise Again  button User can reattempt the quiz");
			test.log(Status.INFO, "Practise Again button is displayed to the User and after clicking on Practise Again button User can reattempt the quiz");
		}
		assert1.assertTrue(practise_Again);
		assert1.assertAll();

	}

	public void to_Launch_Practise_Quetions_Quiz() throws MalformedURLException, InterruptedException{
		//		String subject="Mathematics";
		//		String topic1="Comparing Numbers";

		String subject="Political Science";
		//String topic1="Aspects and Influence of Diversity";
		String topic1="Diversity in India";

		osm = new Object_Syllabus_Section();
		osm.syllabus.click();
		applyExplicitWait(10);
		clickOnElement(findElementByText(subject));
		System.out.println("Clicked on "+subject+" subject");
		test.log(Status.INFO, "Clicked on "+subject+" subject");
		clickOnElement(findElementByText(topic1));
		System.out.println("Clicked on "+ topic1);
		test.log(Status.INFO, "Clicked on "+ topic1);
		applyExplicitWait(10);
		//	osm.practiseButton.click();

		clickOnElement(findElementByText("Practice"));
		System.out.println("Clicked on Begin Practise button");
		test.log(Status.INFO, "Clicked on Begin Practise button");
		applyExplicitWait(30);
		//		Thread.sleep(5000);
		//applyExplicitWaitsUntilElementVisible(getDriver().findElementById("com.tce.studi:id/tv_heading_id"));
		applyExplicitWaitsUntilElementVisible(osm.topicHeader);
		applyExplicitWaitsUntilElementVisible(osm.begin_Practise_1);
			//osm.begin_Practise_1.click();
		//		Keyword.clickOnElementUsingText("Practice");
		clickOnElement(findElementByText("Practice"));
		System.out.println("Clicked on Begin Practise button");
		applyExplicitWait(30);
		
	}

	public int verify_Question_Count_In_Test_Module() throws MalformedURLException, InterruptedException {

		//	Thread.sleep(10000);
		applyExplicitWaitsUntilElementVisible(osm.quetionCount);
		applyExplicitWaitsUntilElementVisible(osm.question1_part_Text);
		String questionCount = osm.quetionCount.getText();
		String[] s = questionCount.split("of");
		String s1 = s[1].trim();
		int i = Integer.parseInt(s1);
		//		System.out.println("Total number of questions are : " + i);

		return i;
	}

	public Boolean selectCorrectOption(int queNumber) {
		switch (queNumber) {

		case 1:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '2')]")));
			return true;
		case 2:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '6')]")));
			return true;
		case 3:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3311')]")));
			return true;
		case 4:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '2474')]")));
			return true;
		case 5:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '277')]")));
			return true;
		case 6:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'True')]")));
			return true;
		case 7:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '8, 9, 12, 15')]")));
			return true;
		case 8:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'Ruler, Sharpener, Eraser, Pencil')]")));
			return true;
		case 9:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'Rahul, Jatin, Amit, Deepak')]")));
			return true;
		case 10:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'Mary')]")));
			return true;
		case 11:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '14389')]")));
			return true;
		case 12:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '5461')]")));
			return true;
		case 13:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'False')]")));
			return true;
		case 14:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'City C')]")));
			return true;
		case 15:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'Priya - 450')]")));
			return true;

		default:
			return false;
		}
	}
}