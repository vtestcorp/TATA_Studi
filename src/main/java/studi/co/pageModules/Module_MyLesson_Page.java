package studi.co.pageModules;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Create_Study_Plan;
import studi.co.pageObjects.Object_MyLesson_Page;
import studi.co.pageObjects.Object_ReviewPlan;

public class Module_MyLesson_Page extends BaseClass{
	Object_MyLesson_Page omp;
	Object_ReviewPlan orp;


	public void toVerify_User_Navigate_to_MyLessonsPage() throws MalformedURLException {
		omp= new Object_MyLesson_Page();
		SoftAssert assert1=new SoftAssert();

		Boolean landingPage=omp.userName.isDisplayed();
		if(landingPage) {
			System.out.println("User can be navigated to the landing page after login");
			test.log(Status.INFO, "User can be navigated to the landing page after login");
		}
		else {
			System.out.println("User can not be navigated to the landing page after login");
			test.log(Status.INFO, "User can not be navigated to the landing page after login");
		}
		assert1.assertTrue(landingPage);

		Boolean testUnit=omp.test_unit.isDisplayed();
		if(testUnit) {
			System.out.println("In the landing page,Active StudyPlan tab is displayed");
			test.log(Status.INFO, "In the landing page,Active StudyPlan tab is displayed");
		}
		assert1.assertTrue(testUnit);
		//createPlan();
		omp.test_unit.click();
		applyExplicitWait(5);
		Boolean myLessonPage=omp.planTestUnit.isDisplayed();
		if(myLessonPage) {
			System.out.println("User able to navigate to MyLessons Page,after tapping on active study plan");
			test.log(Status.INFO, "User able to navigate to MyLessons Page,after tapping on active study plan");
		}
		assert1.assertTrue(myLessonPage);
		assert1.assertAll();
	}


	public void toVerify_VariousContentsOn_MyLessonsPage() throws MalformedURLException {
		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();

		Boolean menuIcon=omp.menuIcon.isDisplayed();
		if(menuIcon) {
			System.out.println("Menu Icon is displayed on MyLessons Page");
			test.log(Status.INFO, "Menu Icon is displayed on MyLessons Page");
		}
		assert1.assertTrue(menuIcon);

		Boolean titleOfStudyPlan=omp.planTestUnit.isDisplayed();
		if(titleOfStudyPlan) {
			System.out.println("Title of Study Plan is displayed on MyLessons Page as :"+omp.planTestUnit.getText());
			test.log(Status.INFO, "Title of Study Plan is displayed on MyLessons Page as :"+omp.planTestUnit.getText());
		}
		assert1.assertTrue(titleOfStudyPlan);

		Boolean studyRing=omp.studyRing.isDisplayed();
		if(studyRing) {
			System.out.println("StudyRing is displayed on MyLessons Page");
			test.log(Status.INFO, "StudyRing is displayed on MyLessons Page");
		}
		assert1.assertTrue(studyRing);
		assert1.assertAll();

	}


	public void toVerify_UserCanNavigate_BackTo_TheLandingPage() throws MalformedURLException {

		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();

		omp.menuIcon.click();

		Boolean landingPage=omp.userName.isDisplayed();
		if(landingPage) {
			System.out.println("On Tapping Menu Icon,User can be navigated to the landing page.");
			test.log(Status.INFO, "On Tapping Menu Icon,User can be navigated to the landing page.");
		}
		assert1.assertTrue(landingPage);
		assert1.assertAll();
	}


	public void toVerify_StudyRing_For_NewStudyPlan() throws Exception {
		SoftAssert assert1=new SoftAssert();
		//createPlan();
		//omp= new Object_MyLesson_Page();
		//applyExplicitWaitsUntilElementVisible(omp.backIcon);
		//omp.backIcon.click();
		toVerify_User_Navigate_to_MyLessonsPage();

		Boolean studyRing=omp.studyRing.isDisplayed();
		if(studyRing) {
			System.out.println("For a New StudyPlan, The study ring is shown to the user in a Default state");
			test.log(Status.INFO, "For a New StudyPlan, The study ring is shown to the user in a Default state");
		}

		assert1.assertTrue(studyRing);
		assert1.assertAll();

	}


	public void toVerify_StudyRing_For_Existing_StudyPlan() throws MalformedURLException {
		SoftAssert assert1=new SoftAssert();
		toVerify_User_Navigate_to_MyLessonsPage();

		Boolean studyRing=omp.studyRing.isDisplayed();
		if(studyRing) {
			System.out.println("StudyRing is displayed on MyLessons Page");
			test.log(Status.INFO, "StudyRing is displayed on MyLessons Page");
		}
		assert1.assertTrue(studyRing);
		assert1.assertAll();


	}


	public void toVerify_3_Rings_In_StudyRing() throws Exception {

		SoftAssert assert1=new SoftAssert();
		toVerify_User_Navigate_to_MyLessonsPage();

		Boolean studyRing=omp.studyRing.isDisplayed();
		if(studyRing) {
			System.out.println("StudyRing is displayed on MyLessons Page");
			test.log(Status.INFO, "StudyRing is displayed on MyLessons Page");
		}
		assert1.assertTrue(studyRing);

		Boolean timeRing=omp.outerRing.isDisplayed();
		if(studyRing) {
			System.out.println("Time Ring is displayed in StudyRing");
			test.log(Status.INFO, "Time Ring is displayed in StudyRing");
		}
		assert1.assertTrue(timeRing);

		Boolean lessonRing=omp.middleRing.isDisplayed();
		if(studyRing) {
			System.out.println("Lesson Ring is displayed in StudyRing");
			test.log(Status.INFO, "Lesson Ring is displayed in StudyRing");
		}
		assert1.assertTrue(lessonRing);

		Boolean rewardRing=omp.innerRing.isDisplayed();
		if(studyRing) {
			System.out.println("Reward Ring is displayed in StudyRing");
			test.log(Status.INFO, "Reward Ring is displayed in StudyRing");
		}
		assert1.assertTrue(rewardRing);

		assert1.assertAll();

	}


	public void toVerify_Information_OfTask() throws Exception {
		SoftAssert assert1=new SoftAssert();
		toVerify_User_Navigate_to_MyLessonsPage();

		Boolean studyRing=omp.studyRing.isDisplayed();
		if(studyRing) {
			System.out.println("StudyRing is displayed on MyLessons Page");
			test.log(Status.INFO, "StudyRing is displayed on MyLessons Page");
		}
		assert1.assertTrue(studyRing);

		Boolean todaysTask=omp.taskToBeCompletedToday.isDisplayed();
		if(studyRing) {
			System.out.println("Information of task to be completed today is displayed,in a single liner text below the Study Ring");
			test.log(Status.INFO, "Information of task to be completed today is displayed,in a single liner text below the Study Ring");
		}
		assert1.assertTrue(todaysTask);

		String todaysTasks=omp.taskToBeCompletedToday.getText();
		//	String taskss=Keyword.getBetweenStrings(todaysTasks, "have", "tasks").trim();
		int tasks=Integer.parseInt(getBetweenStrings(todaysTasks, "have", "tasks").trim());
		System.out.println(tasks);

		for(int i=0;i<tasks;i++) {
			omp.kebabMenu.click();
			applyExplicitWaitsUntilElementVisible(omp.markAsComplete);
			omp.markAsComplete.click();
		}

		applyExplicitWaitsUntilElementVisible(omp.taskCompleted);
		Boolean taskCompleted=omp.taskCompleted.isDisplayed();
		if(taskCompleted) {
			System.out.println("Completion text is displayed on completion of todays task");
			test.log(Status.INFO, "Completion text is displayed on completion of todays task");
		}
		assert1.assertTrue(taskCompleted);

		assert1.assertAll();

	}


	public void toVerify_TickMark() throws Exception {
		SoftAssert assert1=new SoftAssert();

		createPlan();
		omp= new Object_MyLesson_Page();
		Thread.sleep(2000);
		//		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		//		.until(ExpectedConditions.elementToBeClickable(omp.backIcon));
		//		applyExplicitWaitsUntilElementVisible(omp.backicon);
		//		omp.backicon.click();


		toVerify_User_Navigate_to_MyLessonsPage();

		Boolean studyRing=omp.studyRing.isDisplayed();
		if(studyRing) {
			System.out.println("StudyRing is displayed on MyLessons Page");
			test.log(Status.INFO, "StudyRing is displayed on MyLessons Page");
		}
		assert1.assertTrue(studyRing);


		String todaysTasks=omp.taskToBeCompletedToday.getText();
		//	String taskss=Keyword.getBetweenStrings(todaysTasks, "have", "tasks").trim();
		int tasks=Integer.parseInt(getBetweenStrings(todaysTasks, "have", "tasks").trim());
		System.out.println(tasks);

		for(int i=0;i<tasks;i++) {
			omp.kebabMenu.click();
			applyExplicitWaitsUntilElementVisible(omp.markAsComplete);
			omp.markAsComplete.click();
		}


		applyExplicitWaitsUntilElementVisible(omp.tick);
		Thread.sleep(tasks*(3/2));
		Boolean taskCompleted=omp.tick.isDisplayed();
		if(taskCompleted) {
			System.out.println("On making progress in the plan and completing all the planned lessons for the day, user is shown the tick mark at the centre of the ring");
			test.log(Status.INFO, "On making progress in the plan and completing all the planned lessons for the day, user is shown the tick mark at the centre of the ring");
		}
		assert1.assertTrue(taskCompleted);
		assert1.assertAll();


	}


	public void createPlan() throws MalformedURLException {

		Object_Create_Study_Plan temp = new Object_Create_Study_Plan();
		clickOnElement(temp.testUnitModule);
		try {
			clickOnElement(temp.selectAnotherPlanBtn);
		} catch (Exception e) {
			if (device.contains("Android")) {
				scrollTo1("Manage and Create Plans");
				applyExplicitWait(5);
			} else
				swipeDown();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Clicking on Manage and Create Plans");
			clickOnElement(temp.managePlanBtn);
		}

		applyExplicitWait(5);
		System.out.println("Clicking on Create Study Plans");
		applyExplicitWaitsUntilElementClickable(temp.createStudyPlanBtn);
		clickOnElement(temp.createStudyPlanBtn);

		System.err.println("Clicked on " + prop.getProperty("msubject"));
		scrollTo2(prop.getProperty("msubject"));
		applyExplicitWaitsUntilElementVisible(findElementByText(prop.getProperty("msubject")));
		clickOnElement(findElementByText(prop.getProperty("msubject")));

		System.err.println("Clicked on " + prop.getProperty("topic2"));
		scrollTo2(prop.getProperty("topic2"));
		applyExplicitWaitsUntilElementVisible(findElementByText(prop.getProperty("topic2")));
		clickOnElement(findElementByText(prop.getProperty("topic2")));

		applyExplicitWait(5);
		clickOnElement(findElementByText("Add to portion"));

		applyExplicitWaitsUntilElementClickable(temp.nextStepBtn);
		clickOnElement(temp.nextStepBtn);
		applyExplicitWait(5);

		action = new TouchAction(driver);
		Set<String> context = driver.getContextHandles();
		for (String cont : context) {
			if (cont.contains("WEBVIEW"))
				getDriver().context(cont);
		}
		Boolean status = getDriver().findElement(By.xpath("//*[contains(@class, 'icon-flag-svg')]"))
				.getAttribute("class").contains("active");
		getDriver().context("NATIVE_APP");
		if (status) {
			temp.subjectFlag.put(prop.getProperty("msubject"), true);
		} else {
			temp.subjectFlag.put(prop.getProperty("msubject"), false);
		}

		applyExplicitWaitsUntilElementClickable(temp.nextStepBtn);
		clickOnElement(temp.nextStepBtn);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		applyExplicitWaitsUntilElementClickable(temp.nextStepBtn);
		clickOnElement(temp.nextStepBtn);

		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("New plan created");

		int j = 0;
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			applyExplicitWaitsUntilElementClickable(temp.topLessonStatus);
			clickOnElement(temp.topLessonStatus);
			applyExplicitWait(5);
			//clickOnElement(temp.markAsComplete);
			clickOnElement(findElementByText("Mark"));
			//if (j == 1)
			//scrollTo2("due");
			j++;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickOnElement(temp.backBtnTestUnit);

	}


	// 1045_13
	public void toVerify_Todays_Tab() throws Exception {
		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();

		applyExplicitWaitsUntilElementVisible(omp.todayTab);	
		Boolean todayTab=omp.todayTab.isDisplayed();
		if(todayTab) {
			System.out.println("Todays Tab is shown to the user next to the StudyRing");
			test.log(Status.INFO, "Todays Tab is shown to the user next to the StudyRing");
		}
		Assert.assertTrue(todayTab);

	}


	public void toVerify_Lessons_In_Todays_Tab() throws Exception {
		SoftAssert assert1=new SoftAssert();
		createPlan();
		omp= new Object_MyLesson_Page();
		Thread.sleep(2000);
		//		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		//		.until(ExpectedConditions.elementToBeClickable(omp.backIcon));
		//		applyExplicitWaitsUntilElementVisible(omp.backicon);
		//		omp.backicon.click();

		toVerify_Todays_Tab();
		scrollTo2("Upcoming");

		Boolean todayCount=omp.todaysCount.isDisplayed();
		if(todayCount) {
			System.out.println("A single line text to inform todays count is displayed in Today Tab");
			test.log(Status.INFO, "A single line text to inform todays count is displayed in Today Tab");
		}
		//Assert.assertTrue(todayCount);
		//String todaysTasks=omp.taskToBeCompletedToday.getText();
		//int todaysCount=getBetweenStrings(omp.todaysCount,"have","tasks");
		//System.out.println(todaysCount);

		//List<MobileElement> topics= getDriver().findElementsById("com.tce.studi:id/cl_data");
		//int j=0;
		//for(MobileElement topic : topics) {
		//while(j!=todaysCount) {
		//System.out.println(topic.getText());
		//assert1.assertTrue(topic.isDisplayed());
		//j++;
		//}
		//}
		System.out.println("Planned lessons for the day are displayed in Todays Tab");
		test.log(Status.INFO, "Planned lessons for the day are displayed in Todays Tab");

		scrollTo2("Our plan for today!");

		//for(int i=0;i<4;i++) {

		omp.kebabMenu.click();
		applyExplicitWaitsUntilElementVisible(omp.markAsComplete);
		omp.markAsComplete.click();
		//}

		scrollTo2("Today");
		applyExplicitWaitsUntilElementVisible(omp.completedLessons);
		Boolean completedLessons=omp.completedLessons.isDisplayed();
		if(completedLessons) {
			System.out.println("Completed Lessons of the day are displayed in Today Tab");
			test.log(Status.INFO, "Completed Lessons of the day are displayed in Today Tab");
		}
		assert1.assertTrue(completedLessons);

	}


	public void toVerify_Upcoming_Tab() throws Exception {
		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();

		scrollTo2("Upcoming");
		applyExplicitWaitsUntilElementVisible(omp.upcomingTab);	
		Boolean upcomingTab=omp.upcomingTab.isDisplayed();
		if(upcomingTab) {
			System.out.println("Upcoming Tab is shown to the user below Todays Tab");
			test.log(Status.INFO, "Upcoming Tab is shown to the user below Todays Tab");
		}
		Assert.assertTrue(upcomingTab);

	}


	public void toVerify_Lessons_In_Upcoming_Tab() throws Exception {
		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();

		//	scrollTo1("Upcoming");
		scrollTo2("Upcoming");
		//	List<MobileElement> topicsInUpcoming=getDriver().findElementsById("com.tce.studi:id/upcoming_main_view");
		System.out.println(omp.topicsInUpcoming.size());
		for(MobileElement topic : omp.topicsInUpcoming) {

			assert1.assertTrue(topic.isDisplayed());

		}
		System.out.println("Planned lessons due on future dates are displayed in Upcoming Tab");
		test.log(Status.INFO, "Planned lessons due on future dates are displayed in Upcoming Tab");


	}


	public void toVerify_Various_Colour_Code_Schema_For_Various_Books() throws Exception {

		createPlan3(7);

		omp= new Object_MyLesson_Page();
		Thread.sleep(2000);
//		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
//		.until(ExpectedConditions.elementToBeClickable(omp.backIcon));
//		applyExplicitWaitsUntilElementVisible(omp.backIcon);
		//omp.backicon.click();
		//omp.test_unit.click();
		//toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();

		scrollTo2("Practice");

		clickOnElement(findElementByText("Practice"));
		//applyExplicitWaitsUntilElementVisible(getDriver().findElementById("com.tce.studi:id/tv_objective"));
		//swipeLeft();
		//applyExplicitWaitsUntilElementVisible("practise");
		applyExplicitWaitsUntilElementVisible("you");

		clickOnElement(findElementByText("Practice"));
		applyExplicitWaitsUntilElementVisible("Select");
		applyExplicitWaitsUntilElementVisible(omp.quetionText);
		Set<String> context = driver.getContextHandles();
		for (String cont : context) {

			if (cont.contains("WEBVIEW"))
				getDriver().context(cont);
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applyExplicitWait(5);
		//	WebElement colour=getDriver().findElementByXPath("//tce-scq");
		String colour1=driver.findElementByXPath("//*[contains(@class, 'theme')]").getAttribute("class");
		System.err.println(colour1);
		String colourOfSubject1=colour1.split("-")[1];
		System.out.println(colourOfSubject1);
		getDriver().context("NATIVE_APP");

		omp.backButton.click();
		applyExplicitWaitsUntilElementVisible(omp.yesButton);
		omp.yesButton.click();
		omp.backButton.click();
		scrollTo2("POLSC");
		applyExplicitWaitsUntilElementVisible(omp.practicePoliticalScience);
		omp.practicePoliticalScience.click();
		//		applyExplicitWaitsUntilElementVisible(getDriver().findElementById("com.tce.studi:id/tv_objective"));
		//applyExplicitWaitsUntilElementVisible(omp.objective);
		omp.markAsComplete.click();
		omp.markAsComplete.click();
		clickOnElement(findElementByText("Practice"));
		applyExplicitWaitsUntilElementVisible(omp.quetionText);//locked
		Set<String> context1 = driver.getContextHandles();
		for (String cont : context1) {

			if (cont.contains("WEBVIEW"))
				getDriver().context(cont);
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		WebElement colour2=getDriver().findElementByXPath("//tce-scq");
		String colour3=driver.findElementByXPath("//*[contains(@class, 'theme')]").getAttribute("class");
		//String colour3=omp.colour.getAttribute("class");
		System.out.println(colour3);
		String colourOfSubject2=colour3.split("-")[1];
		System.out.println(colourOfSubject2);
		getDriver().context("NATIVE_APP");
		assert1.assertNotEquals(colourOfSubject1, colourOfSubject2);
		System.out.println("Various lessons from book maintain the colour schema");
		test.log(Status.INFO, "Various lessons from book maintain the colour schema");
		assert1.assertAll();


	}
	private void applyExplicitWaitsUntilElementVisible(String string) {
		// TODO Auto-generated method stub

	}


	// Test Case - 18
	public void toVerify_User_Should_Not_Shown_Any_Colour_Code_Schema_In_Upcoming_Tab() throws Exception {

		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();

		scrollTo2("Upcoming");
		applyExplicitWaitsUntilElementVisible(omp.practiceUpcoming);
		omp.practiceUpcoming.click();
		//		applyExplicitWaitsUntilElementVisible(getDriver().findElementById("com.tce.studi:id/tv_objective"));
		applyExplicitWaitsUntilElementVisible(omp.objective);
		clickOnElement(findElementByText("Practice"));
		applyExplicitWaitsUntilElementVisible(omp.quetionText);
		Set<String> context = driver.getContextHandles();
		for (String cont : context) {

			if (cont.contains("WEBVIEW"))
				getDriver().context(cont);
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		WebElement colour=getDriver().findElementByXPath("//tce-scq");
		String colour1=omp.colour.getAttribute("class");
		System.out.println(colour1);
		String colourOfSubject1=colour1.split("-")[1];
		System.out.println(colourOfSubject1);
		getDriver().context("NATIVE_APP");

	}



	public void toVerify_Lesson_Card_Content() throws Exception {
		createPlan();
		omp= new Object_MyLesson_Page();
		Thread.sleep(2000);
		//		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		//		.until(ExpectedConditions.elementToBeClickable(omp.backIcon));
		//		applyExplicitWaitsUntilElementVisible(omp.backIcon);
		//		omp.backIcon.click();


		SoftAssert assert1=new SoftAssert();
		toVerify_User_Navigate_to_MyLessonsPage();


		scrollTo2("Today");
		//	List<MobileElement> todayList=getDriver().findElementsById("com.tce.studi:id/main_view_today");
		System.out.println(omp.todayList.size());

		for(MobileElement list : omp.todayList) {

			//		MobileElement subject =getDriver().findElementById("com.tce.studi:id/tv_subject_name");

			Boolean subject1=omp.subject.isDisplayed();
			if(subject1) {
				System.out.println("Subject is Displayed");
				System.out.println(omp.subject.getText());
			}

			//		MobileElement lessonStatus =getDriver().findElementById("com.tce.studi:id/img_overflow");

			Boolean lessonStatus1=omp.lessonStatus.isDisplayed();
			if(lessonStatus1) {
				System.out.println("lesson status is Displayed");
				//			System.out.println(lessonStatus.getText());
			}

			//		MobileElement typeOfLesson =getDriver().findElementById("com.tce.studi:id/tv_chapter_type");

			Boolean lessonType=omp.typeOfLesson.isDisplayed();
			if(lessonType) {
				System.out.println("lesson type is Displayed");
				System.out.println(omp.typeOfLesson.getText());
			}
		}

		scrollTo2("Upcoming");
		//		List<MobileElement> upcomingList=getDriver().findElementsById("com.tce.studi:id/upcoming_main_view");
		System.out.println(omp.upcomingList.size());

		for(MobileElement list : omp.upcomingList) {

			//	MobileElement subject =getDriver().findElementById("com.tce.studi:id/tv_subject_name");

			Boolean subject1=omp.subject.isDisplayed();
			if(subject1) {
				System.out.println("Subject is Displayed");
				System.out.println(omp.subject.getText());
			}

			//	MobileElement lessonStatus =getDriver().findElementById("com.tce.studi:id/img_overflow");
			//	MobileElement lessonStatus12 =getDriver().findElementById("com.tce.studi:id/locked");
			Boolean lessonStatus1=(omp.locked.isDisplayed() || omp.unlocked.isDisplayed());
			if(lessonStatus1) {
				System.out.println("lesson status is Displayed");
				//			System.out.println(lessonStatus.getText());
			}

			//		MobileElement typeOfLesson =getDriver().findElementById("com.tce.studi:id/tv_chapter_type");

			Boolean lessonType=omp.unlocked.isDisplayed();
			if(lessonType) {
				System.out.println("lesson type is Displayed");
				System.out.println(omp.typeOfLesson.getText());
			}
		}


	}





	public void toVerify_Tick_Mark_On_Lesson_Completion() throws Exception {


		createPlan();
		omp= new Object_MyLesson_Page();
		Thread.sleep(2000);
		//		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		//		.until(ExpectedConditions.elementToBeClickable(omp.backIcon));
		//		applyExplicitWaitsUntilElementVisible(omp.backIcon);

		//	omp.backicon.click();

		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();

		omp.kebabMenu.click();
		applyExplicitWaitsUntilElementVisible(omp.markAsComplete);
		omp.markAsComplete.click();
		swipeUp();

		applyExplicitWaitsUntilElementVisible(omp.completedLessons);
		Boolean tickmark=omp.completedLessons.isDisplayed();
		if(tickmark) {
			System.out.println("Tick mark displayed against that lesson after completion  of lesson");
			test.log(Status.INFO, "Tick mark displayed against that lesson after completion  of lesson");
		}
		Assert.assertTrue(tickmark);


	}


	public void toVerify_Unlock_Lessons() throws Exception {


		createPlan();
		omp= new Object_MyLesson_Page();
		Thread.sleep(2000);
		//		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		//		.until(ExpectedConditions.elementToBeClickable(omp.backIcon));
		//		applyExplicitWaitsUntilElementVisible(omp.backIcon);
		//		omp.backicon.click();

		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();

		scrollTo2("Today");
		Boolean unlockLessons=omp.kebabMenu.isDisplayed();
		if(unlockLessons) {
			System.out.println("Unlocked lessons are displayed in Todays tab");
			test.log(Status.INFO, "Unlocked lessons are displayed in Todays tab");
		}
		assert1.assertTrue(unlockLessons);

		scrollTo2("Practice");

		//swipeLeft();
		applyExplicitWaitsUntilElementVisible("Practise");
		//omp.topic.click();
		clickOnElement(findElementByText("Practice"));

		Boolean lessonTappable=omp.topicPageHeading1.isDisplayed();
		if(lessonTappable) {
			System.out.println("Lessons in unlocked status in Todays tab are tappable");
			test.log(Status.INFO, "Lessons in unlocked status  in Todays tab are tappable");
		}
		assert1.assertTrue(lessonTappable);
		//swipeLeft();
		applyExplicitWaitsUntilElementVisible(omp.backIcon);
		omp.backIcon.click();

		scrollTo2("View");
		omp.viewFullSchedule.click();

		applyExplicitWaitsUntilElementVisible(omp.imagefilterScheduldePage);
		scrollTo2("Practice");
		Boolean unlockLessonsSchedule=omp.kebabMenu.isDisplayed();
		if(unlockLessonsSchedule) {
			System.out.println("Unlocked lessons are displayed in Schedule tab");
			test.log(Status.INFO, "Unlocked lessons are displayed in Schedule tab");
		}
		assert1.assertTrue(unlockLessonsSchedule);


		//	omp.topicSchedule1.click();
		clickOnElement(findElementByText("Practice"));
		Boolean lessonTappableSchedule=omp.topicPageHeading1.isDisplayed();
		if(lessonTappableSchedule) {
			System.out.println("Lessons in unlocked status in Schedule tab are tappable");
			test.log(Status.INFO, "Lessons in unlocked status  in Schedule tab are tappable");
		}
		assert1.assertTrue(lessonTappableSchedule);
		assert1.assertAll();
	}


	public void toVerify_Unlock_Lessons_Functionality() throws Exception {
		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();

		scrollTo2("Today");
		Boolean unlockLessons=omp.kebabMenu.isDisplayed();
		if(unlockLessons) {
			System.out.println("Unlocked lessons are displayed in Todays tab");
			test.log(Status.INFO, "Unlocked lessons are displayed in Todays tab");
		}
		Assert.assertTrue(unlockLessons);

		scrollTo2("Revise");
		String topicNameBefore=omp.aspectsAndInfluence.getText();
		//omp.topic.click();

		clickOnElement(findElementByText("Practice"));
		Boolean lessonTappable=omp.topicPageHeading1.isDisplayed();
		assert1.assertTrue(lessonTappable);
		String topicNameAfter=omp.topicPageHeading1.getText();
		assert1.assertEquals(topicNameBefore, topicNameAfter);
		if(lessonTappable) {
			System.out.println("On tapping unlocked lessons from the list, respective lessons get open for the user to attempt");
			test.log(Status.INFO, "On tapping unlocked lessons from the list, respective lessons get open for the user to attempt");
		}

		assert1.assertAll();

	}


	public void toVerify_View_Full_Schedule() throws Exception {

		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();
		scrollTo2("View");

		Boolean viewFullSchedule=omp.viewFullSchedule.isDisplayed();
		if(viewFullSchedule) {
			System.out.println("Full Schedule button is shown to the user below upcoming tab");
			test.log(Status.INFO, "Full Schedule button is shown to the user below upcoming tab");
		}
		assert1.assertTrue(viewFullSchedule);
	}


	public void toVerify_Schedule_List_Page() throws Exception {

		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();
		scrollTo2("View");

		omp.viewFullSchedule.click();
		applyExplicitWaitsUntilElementVisible(omp.fullSchedule);
		Boolean scheduleListPage=omp.fullSchedule.isDisplayed();
		if(scheduleListPage) {
			System.out.println("On tapping View Full Schedule, user navigated to the Schedule list page");
			test.log(Status.INFO, "On tapping View Full Schedule, user navigated to the Schedule list page");
		}
		assert1.assertTrue(scheduleListPage);


	}


	public void toVerify_Schedule_List_Of_Plan() throws Exception {
		toVerify_Schedule_List_Page();
		SoftAssert assert1=new SoftAssert();
		String [] days= {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		scrollTo2("Big");
		//	List<MobileElement> listOfLessons=getDriver().findElementsById("com.tce.studi:id/list_title");
		System.out.println(omp.listOfLessons.size());

		for(String day : days) 
		{
			scrollTo2(day);
			System.out.println("lessons for "+day);
			//		listOfLessons=getDriver().findElementsById("com.tce.studi:id/list_title");
			//			Keyword.scrollToEnd();
			for(MobileElement lesson : omp.listOfLessons) {

				Boolean isLesson=lesson.isDisplayed();
				assert1.assertTrue(isLesson);
				System.out.println(lesson.getText());

			}
		}

	}



	public void toVerify_Schedule_List_Of_Plan_Arranged_Weekly() throws Exception {



		toVerify_Schedule_List_Page();
		SoftAssert assert1=new SoftAssert();
		String [] days= {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		for(int i = 1;i<days.length-1;i++) {
			if(i<=6) {
				scrollTo2(days[i]);
			}
			else {
				swipeDown();
			}

			//MobileElement  date=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/android.view.ViewGroup[1]/android.widget.TextView");
			MobileElement  date=getDriver().findElementById("com.tce.studi:id/txtMonthDay");

			System.out.println(date.getText());
			assert1.assertTrue(date.isDisplayed());

			List<MobileElement> lessons=getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup");
			System.out.println(lessons.size());
			if(lessons.size()==0) {
				System.out.println("No lessons scheduled for : "+date.getText());
				test.log(Status.INFO, "No lessons scheduled for : "+date.getText());
			}
			else {
				int j=1;
				test.log(Status.INFO, "Lessons for "+date.getText());
				for(MobileElement lesson : lessons) {
					MobileElement lesson1=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+j+"]/android.widget.TextView[3]");
					Boolean isLesson=lesson1.isDisplayed();
					assert1.assertTrue(isLesson);
					System.out.println(lesson1.getText());
					test.log(Status.INFO, lesson1.getText());
					j++;
				}
			}
		}
		assert1.assertAll();
	}


	public void toVerify_Schedule_List_Of_Plan_For_Other_Weeks() throws Exception {
		createPlan1(7);
		omp= new Object_MyLesson_Page();
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(omp.backIcon));
		applyExplicitWaitsUntilElementVisible(omp.backIcon);
		omp.backIcon.click();
		toVerify_Schedule_List_Page();
		SoftAssert assert1=new SoftAssert();

		Boolean nextWeekTab=omp.nextWeek.isDisplayed();
		System.out.println(nextWeekTab);
		if(nextWeekTab) {
			System.out.println("Forward arrow button is shown to the user");
			test.log(Status.INFO, "Forward arrow button is shown to the user");
		}
		assert1.assertTrue(nextWeekTab);

		//	String totalweeks=getDriver().findElementById("com.tce.studi:id/tv_week").getText();
		swipeUp();
		String[] weeks=omp.weeks.getText().split(" ");
		int size=weeks.length;
		int totalWeeks =Integer.parseInt(weeks[size-1]);
		System.out.println(totalWeeks);
		String currentWeek=getBetweenStrings(omp.weeks.getText(), "Week", "of").trim();
		int currentweek=Integer.parseInt(currentWeek);
		System.out.println(currentweek);

		for(int i= currentweek;i<=totalWeeks;i++) {
			//			String totalweeks1=getDriver().findElementById("com.tce.studi:id/tv_week").getText();
			String currentWeek1=getBetweenStrings(omp.weeks.getText(), "Week", "of").trim();
			int currentweek1=Integer.parseInt(currentWeek1);
			System.out.println("User can navigated to "+i+" no week");
			assert1.assertEquals(i, currentweek1);
			omp.nextWeek.click();

		}
		assert1.assertAll();
	}


	public void toVerify_Filter_Option() throws Exception {

		toVerify_Schedule_List_Page();
		SoftAssert assert1=new SoftAssert();
		swipeUp();
		applyExplicitWaitsUntilElementVisible(omp.filter);
		Boolean filter=omp.filter.isDisplayed();
		if(filter) {
			System.out.println("Filter Icon at the top of the Full schedule list page is shown to the User");
			test.log(Status.INFO, "Filter Icon at the top of the Full schedule list page is shown to the User");
		}
		assert1.assertTrue(filter);
		assert1.assertAll();
	}


	public void toVerify_Filter_Icon_On_Schedule_List_Should_Be_Tappable() throws Exception {
		toVerify_Filter_Option();		
		SoftAssert assert1=new SoftAssert();

		omp.filter.click();
		applyExplicitWaitsUntilElementVisible(omp.filterHeading);
		Boolean filterHeading=omp.filterHeading.isDisplayed();
		if(filterHeading) {
			System.out.println("Filter Icon at the top of the Full schedule list page is tappable");
			test.log(Status.INFO, "Filter Icon at the top of the Full schedule list page is tappable");
		}
		assert1.assertTrue(filterHeading);

	}


	public void toVerify_Various_Filter_Options() throws Exception {

		toVerify_Filter_Option();		
		SoftAssert assert1=new SoftAssert();

		omp.filter.click();

		Boolean filterSubject=omp.filterSubject.isDisplayed();
		assert1.assertTrue(filterSubject);
		Boolean filterLessonType=omp.filterLessonType.isDisplayed();
		assert1.assertTrue(filterLessonType);
		//	String [] contents= {"SUBJECTS","LESSON TYPE","LESSON STATUS"};

		for(int i=1;i<=2;i++) {
			//@	
			List<MobileElement> subjects= getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView["+i+"]/android.view.ViewGroup");
			System.out.println(subjects.size());
			for(int j=1;j<=subjects.size();j++) {

				MobileElement subject=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView["+i+"]/android.view.ViewGroup["+j+"]/android.widget.TextView");
				System.out.println(subject.getText());
				assert1.assertTrue(subject.isDisplayed());
				MobileElement subjectCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView["+i+"]/android.view.ViewGroup["+j+"]/android.widget.ImageView[2]");
				assert1.assertTrue(subjectCheckBox.isDisplayed());
				if(!subjectCheckBox.isSelected()) {
					subjectCheckBox.click();
				}
			}
		}

		System.out.println("List of various Subjects with their individual check boxes are shown to the user");
		test.log(Status.INFO, "List of various Subjects with their individual check boxes are shown to the user");

		scrollTo2("Lessons Status");

		Boolean filterLessonStatus=omp.filterLessonStatus.isDisplayed();
		assert1.assertTrue(filterLessonStatus);
		if(filterSubject && filterLessonType && filterLessonStatus) {
			System.out.println("On tapping Filter Icon at the top of the Full schedule list page,options of applying filter is shown to the User");
			test.log(Status.INFO, "On tapping Filter Icon at the top of the Full schedule list page,options of applying filter is shown to the User");
		}

		//		List<MobileElement> subjects= getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup");
		System.out.println(omp.subjects.size());
		for(int j=4;j<7;j++) {

			//MobileElement subject=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup["+j+"]/android.widget.TextView");
			//MobileElement subject=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView"+j+"]/android.widget.TextView");
			MobileElement subject=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView");
			assert1.assertTrue(subject.isDisplayed()); 
			System.out.println(subject.getText());
			//MobileElement subjectCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup["+j+"]/android.widget.ImageView[2]");
			MobileElement subjectCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView[2]");
			assert1.assertTrue(subjectCheckBox.isDisplayed());
			if(!subjectCheckBox.isSelected()) {
				subjectCheckBox.click();
			}
		}

		System.out.println("List of various Lessons under Lesson type with their individual check boxes are shown to the user");
		test.log(Status.INFO, "List of various Lessons under Lesson type with their individual check boxes are shown to the user");


		//		List<MobileElement> lessonStatus= getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup");
		System.out.println(omp.lessonStatus1.size());
		for(int j=1;j<=omp.lessonStatus1.size();j++) {

			//MobileElement status=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup["+j+"]/android.widget.TextView");
			MobileElement status=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup");
			assert1.assertTrue(status.isDisplayed());
			System.out.println(status.getText());
			//MobileElement lessonStatusCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup["+j+"]/android.widget.ImageView[2]");
			//MobileElement lessonStatusCheckBox=getDriver().findElementById("com.tce.studi:id/img_check_id");
			MobileElement lessonStatusCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView[2]");
			assert1.assertTrue(lessonStatusCheckBox.isDisplayed());
			Boolean ver=lessonStatusCheckBox.isSelected();
			System.out.println(ver);
			if(!ver) {
				lessonStatusCheckBox.click();
			}
		}
		System.out.println("List of various Lesson status under Lesson status with their individual check boxes are shown to the user");
		test.log(Status.INFO, "List of various Lesson status under Lesson status with their individual check boxes are shown to the user");


	}


	public void toVerify_Various_Filter_Options_On_Schedule_List_Should_Be_Functional() throws Exception {
		createPlan2(7);
		omp= new Object_MyLesson_Page();
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(omp.backIcon));
		applyExplicitWaitsUntilElementVisible(omp.backIcon);
		omp.backIcon.click();


		toVerify_Filter_Option();
		SoftAssert assert1=new SoftAssert();

		omp.filter.click();

		for(int i=1;i<=2;i++) {

			List<MobileElement> subjects= getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView["+i+"]/android.view.ViewGroup");
			System.out.println(subjects.size());
			for(int j=1;j<=subjects.size();j++) {

				MobileElement subjectCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView["+i+"]/android.view.ViewGroup["+j+"]/android.widget.ImageView[2]");
				if(!subjectCheckBox.isSelected()) {
					subjectCheckBox.click();

				}
			}
		}
		System.out.println("Done 1");
		scrollTo2("Lessons Status");

		List<MobileElement> lessonStatus1= getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup");
		System.out.println(omp.subjects.size());
		for(int j=4;j<=lessonStatus1.size();j++) {

			MobileElement lessonCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup["+j+"]/android.widget.ImageView[2]");
			assert1.assertTrue(lessonCheckBox.isDisplayed());
			// if(lessonCheckBox.getAttribute("xpath").equals("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[2]/android.widget.ImageView[2]")){


			lessonCheckBox.click();

		}
		System.out.println("Done 3");

		//	List<MobileElement> lessonStatus= getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup");
		System.out.println(omp.lessonStatus2.size());
		for(int j=1;j<=omp.lessonStatus2.size();j++) {

			MobileElement lessonStatusCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup["+j+"]/android.widget.ImageView[2]");

			assert1.assertTrue(lessonStatusCheckBox.isDisplayed());
			Boolean ver=lessonStatusCheckBox.isSelected();
			System.out.println(ver);
			if(!ver) {
				lessonStatusCheckBox.click();
			}
		}

		scrollTo2("Subject");

		//	getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[2]/android.widget.ImageView[2]").click();
		omp.subject36.click();
		for(int i=1;i<=2;i++) {

			List<MobileElement> subjects= getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView["+i+"]/android.view.ViewGroup");

			// 	/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView")
			System.out.println(subjects.size());
			for(int j=1;j<=subjects.size();j++) {

				MobileElement subjectCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView["+i+"]/android.view.ViewGroup["+j+"]/android.widget.ImageView[2]");
				if(!subjectCheckBox.isSelected()) {
					subjectCheckBox.click();

				}
			}
		}
		System.out.println("Done 1");
		scrollTo2("Lessons Status");

		//	List<MobileElement> lessonStatus12= getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup");
		System.out.println(omp.subjects.size());
		for(int j=4;j<=omp.subjects.size();j++) {

			MobileElement lessonCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup["+j+"]/android.widget.ImageView[2]");
			lessonCheckBox.click();
		}

		System.out.println("Done 3");

		//		List<MobileElement> lessonStatus23= getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup");
		System.out.println(omp.lessonStatus2.size());
		for(int j=1;j<=omp.lessonStatus2.size();j++) {

			MobileElement lessonStatusCheckBox=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup["+j+"]/android.widget.ImageView[2]");
			Boolean ver=lessonStatusCheckBox.isSelected();
			System.out.println(ver);
			if(!ver) {
				lessonStatusCheckBox.click();
			}
		}

		omp.applyButton.click();

		scrollTo2("Fri");

		//		List<MobileElement> lessonType = getDriver().findElementsById("com.tce.studi:id/tv_type");
		System.out.println(omp.lessonType.size());
		for (MobileElement mobileElement : omp.lessonType) {

			String lessonType1=mobileElement.getText();
			assert1.assertEquals(lessonType1, "Revise");;
		}
		assert1.assertAll();
	}


	//1045-36
	public void toVerify_Various_Filter_Options_On_Schedule_List_Should_Be_Functional_For_All_The_Weeks() throws Exception {


		toVerify_Filter_Option();
		SoftAssert assert1=new SoftAssert();
		//scrollTo1("Week");

		String date1=omp.weeks.getText();
		int dates=Integer.parseInt(date1.split("of")[1].trim());
		System.out.println(dates);

		omp.filter.click();
		omp.revise.click();
		omp.applyButton.click();


		for(int i=0;i<dates;i++) {
			scrollTo2("Fri");

			//		List<MobileElement> lessonType = getDriver().findElementsById("com.tce.studi:id/tv_type");
			System.out.println(omp.lessonType.size());
			for (MobileElement mobileElement : omp.lessonType) {

				String lessonType1=mobileElement.getText();
				assert1.assertEquals(lessonType1, "Revise");;
				//	System.out.println("List of various Lesson status under Lesson status with their individual check boxes are shown to the user");
				//	test.log(Status.INFO, "List of various Lesson status under Lesson status with their individual check boxes are shown to the user");
			}
			scrollTo2("Week");

			omp.nextWeek.click(); 
		}
		assert1.assertAll();
	}


	public void toVerify_Manage_And_Create_Plan() throws Exception {
		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();
		scrollTo2("Manage and Create Plans");
		Boolean manageAndCreatePlan=omp.manageAndCreatePlan.isDisplayed();
		if(manageAndCreatePlan) {

			System.out.println("Manage and Create Plan button is shown to the user below at the bottom of the page");
			test.log(Status.INFO, "Manage and Create Plan button is shown to the user below at the bottom of the page");

		}
		Assert.assertTrue(manageAndCreatePlan);

	}


	public void toVerify_Manage_And_Create_Plan_Is_Tappable() throws Exception {
		toVerify_Manage_And_Create_Plan();
		omp.manageAndCreatePlan.click();

		Boolean manageAndCreatePlantappable=omp.myStudyPlan.isDisplayed();
		if(manageAndCreatePlantappable) {

			System.out.println("Manage and Create Plan button shown to the user is tappable");
			test.log(Status.INFO, "Manage and Create Plan button shown to the user is tappable");

		}
		Assert.assertTrue(manageAndCreatePlantappable);

	}


	public void toVerify_HighLighted_Lesson() throws Exception {

		createPlan1(0);
		omp= new Object_MyLesson_Page();
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(omp.backIcon));
		applyExplicitWaitsUntilElementVisible(omp.backIcon);
		omp.backIcon.click();

		toVerify_User_Navigate_to_MyLessonsPage();
		SoftAssert assert1=new SoftAssert();
		scrollTo2("Today");

		System.out.println(omp.highLightedLesson.getAttribute("resource-id"));
		Boolean highLightedCard=omp.highLightedLesson.isDisplayed();
		if(highLightedCard) {
			System.out.println("Highlighted card is shown in Todays tab");
			test.log(Status.INFO, "Highlighted card is shown in Todays tab");
		}
		assert1.assertTrue(highLightedCard);

		String lessonType=omp.highLightedLesson.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[1]")).getText();
		System.out.println("Initially "+lessonType+" Lesson Type is Highlighted");
		test.log(Status.INFO, "Initially "+lessonType+" Lesson Type is Highlighted");
		assert1.assertAll();
	}


	public void toVerify_the_Highlighted_lessons_gets_changed() throws Exception {

		toVerify_HighLighted_Lesson();
		SoftAssert assert1=new SoftAssert();
		scrollTo2("Today");

		String todaysTasks=omp.taskToBeCompletedToday.getText();
		int tasks=Integer.parseInt(getBetweenStrings(todaysTasks, "have", "tasks").trim());
		System.out.println(tasks);
		//			WebElement highLightedLesson = getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup");;
		for(int i=0;i<tasks;i++) {

			omp.kebabMenu.click();
			applyExplicitWaitsUntilElementVisible(omp.markAsComplete);
			omp.markAsComplete.click();
			Thread.sleep(5000);
			System.out.println(i);

			if(i<tasks-1) {



				Boolean highLightedCard=omp.highLightedLesson.isDisplayed();
				if(highLightedCard) {
					System.out.println("When user completes highlighted lesson, some other lesson from the list get highlighted");
					test.log(Status.INFO, "When user completes highlighted lesson, some other lesson from the list get highlighted");
				}
				assert1.assertTrue(highLightedCard);

				//	String lessonType1=highLightedLesson.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[1]")).getText();
				String lessonType1=omp.highLightedLesson.findElement(By.id("com.tce.studi:id/tvChapterType")).getText();
				System.out.println(lessonType1+" Lesson Type is Highlighted");
				test.log(Status.INFO, lessonType1+" Lesson Type is Highlighted");
			}

			else {
				System.out.println("Once all the planned lessons completed for the day, No highlighted lessons is shown");
				test.log(Status.INFO, "Once all the planned lessons completed for the day, No highlighted lessons is shown");
			}
		}

	}


	public void createPlan1(int day) throws Exception {
		orp=new Object_ReviewPlan();
		if(orp.subHeading.getText().contains("Paused")){
			orp.test_unit.click();
			applyExplicitWaitsUntilElementVisible(orp.resumePlan);
			orp.resumePlan.click();
			applyExplicitWait(5);
		}
		else {
			applyExplicitWait(5);
			orp.test_unit.click();
		}

		scrollTo2("Manage and Create Plans");		
		applyExplicitWait(5);
		orp.manageAndCreatePlan.click();
		clickOnElement(findElementByText("Create"));
		applyExplicitWaitsUntilElementVisible(orp.subjectAtCreatePlan);
		orp.subjectAtCreatePlan.click();
		applyExplicitWaitsUntilElementVisible(orp.chapterCheckBox);
		orp.chapterCheckBox.click();
		orp.addToPortion.click();

		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);

		String date=orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();
		System.out.println(actualDate);
		int i = Integer.parseInt(actualDate);
		int date2=i+day;

		if(i>=22) {
			orp.nextMonthButton.click();
			Thread.sleep(2000);
			//	 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));
			//new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			//.until(ExpectedConditions.elementToBeClickable(orp.date1));

			System.out.println(orp.date1.getText());
			orp.date1.click();
		}
		else {
			MobileElement date3=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
			date3.click();
		}


		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		//	orp.beginStudying.click();
		Thread.sleep(2000);
		clickOnElement(findElementByText("Begin Studying"));


	}

	public void createPlan2(int day) throws Exception {
		orp=new Object_ReviewPlan();
		if(orp.subHeading.getText().contains("Paused")){
			orp.test_unit.click();
			applyExplicitWaitsUntilElementVisible(orp.resumePlan);
			orp.resumePlan.click();
			applyExplicitWait(5);
		}
		else {
			applyExplicitWait(5);
			orp.test_unit.click();
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
		applyExplicitWaitsUntilElementVisible(orp.topicCheckBoxAtCreateStudyPlan1);
		orp.topicCheckBoxAtCreateStudyPlan1.click();
		orp.addToPortion.click();

		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);

		String date=orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();
		System.out.println(actualDate);
		int i = Integer.parseInt(actualDate);
		int date2=i+day;

		if(i>=22) {
			orp.nextMonthButton.click();
			Thread.sleep(2000);
			//	 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(orp.date1));

			System.out.println(orp.date1.getText());
			orp.date1.click();
		}
		else {
			MobileElement date3=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
			date3.click();
		}


		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Begin Studying"));

	}


	public void toVerify_Manage_And_Create_Plan_Is_Functional() throws Exception {
		SoftAssert assert1=new SoftAssert();
		toVerify_Manage_And_Create_Plan_Is_Tappable();

		Boolean activePlan=omp.activePlan.isDisplayed();
		assert1.assertTrue(activePlan);
		Boolean activePlanDetails=omp.detailsOfActivePlan.isDisplayed();
		assert1.assertTrue(activePlanDetails);
		if(activePlan && activePlanDetails) {
			System.out.println("The Active plan and its details are shown");
			test.log(Status.INFO, "The Active plan and its details are shown");
		}


		Boolean otherPlan=omp.otherPlans.isDisplayed();
		if(otherPlan) {
			System.out.println("The Other plan Tab is shown");
			test.log(Status.INFO, "The Other plan Tab is shown");
		}
		assert1.assertTrue(otherPlan);

		//	List <MobileElement> otherPlans=getDriver().findElementsById("com.tce.studi:id/tv_plan_name");
		for(MobileElement plan : omp.otherPlan){
			Boolean otherPlanDetails=plan.isDisplayed();
			assert1.assertTrue(otherPlanDetails);

		}

		Boolean createStudyPlan=omp.createAStudyPlan.isDisplayed();
		if(createStudyPlan) {
			System.out.println("Create Study Plan Tab is shown to the User");
			test.log(Status.INFO, "Create Study Plan Tab is shown to the User");
		}
		assert1.assertTrue(createStudyPlan);

	}


	public void toVerify_User_Should_Be_Able_To_Review_The_Active_Plan() throws Exception {

		toVerify_Manage_And_Create_Plan();
		SoftAssert assert1 =new SoftAssert();

		omp.manageAndCreatePlan.click();

		Boolean activePlan=omp.activePlan.isDisplayed();
		assert1.assertTrue(activePlan);
		if(activePlan) {

			System.out.println("On tapping Manage and Create Plan, user navigate to the page, wherein Active plan tab is shown to the user");
			test.log(Status.INFO, "On tapping Manage and Create Plan, user navigate to the page, wherein Active plan tab is shown to the user");

		}

		omp.testPlan.click();
		applyExplicitWaitsUntilElementVisible(omp.testPlanHeading);
		Boolean reviewPlan=omp.testPlanHeading.isDisplayed();
		assert1.assertTrue(reviewPlan);
		if(reviewPlan) {
			System.out.println("On tapping Active Plan ,review page of the plan is shown to the User");
			test.log(Status.INFO, "On tapping Active Plan ,review page of the plan is shown to the User");
		}
		assert1.assertAll();
	}


	public void toVerify_User_Should_Be_Able_To_Reactivate_The_Older_Plans() throws Exception {

		toVerify_Manage_And_Create_Plan();
		SoftAssert assert1 =new SoftAssert();
		orp=new Object_ReviewPlan();
		omp.manageAndCreatePlan.click();

		Boolean otherPlan=omp.otherPlans.isDisplayed();
		if(otherPlan) {
			System.out.println("The Other plan Tab is shown");
			test.log(Status.INFO, "The Other plan Tab is shown");
		}
		assert1.assertTrue(otherPlan);

		omp.testUnit.click();
		omp.editButton.click();
		omp.editPortion.click();


		//		applyExplicitWaitsUntilElementVisible(omp.activatePlanButton);
		//		omp.activatePlanButton.click();
		//		applyExplicitWaitsUntilElementVisible(omp.subjectAtCreatePlan);
		//		omp.subjectAtCreatePlan.click();
		//		applyExplicitWaitsUntilElementVisible(orp.chapterCheckBox);
		//		orp.chapterCheckBox.click();
		//		orp.addToPortion.click();

		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		//	clickOnElement(findElementByText("Next Step"));

		clickOnElement(findElementByText("Activate Plan"));

		applyExplicitWait(5);

		String date=orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();
		System.out.println(actualDate);
		int i = Integer.parseInt(actualDate);
		int date2=i+3;

		if(i>=26) {
			orp.nextMonthButton.click();
			Thread.sleep(2000);
			//		 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(orp.date1));
			orp.date1.click();
		}
		else {
			MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
			date1.click();
		}


		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		//	orp.beginStudying.click();
		Thread.sleep(2000);
		clickOnElement(findElementByText("Begin Studying"));


		Boolean testUnit=omp.testUnitHeading.isDisplayed();
		assert1.assertTrue(testUnit);
		if(testUnit) {
			System.out.println("User can edit the portion/deadline and can reactivate the plan");
			test.log(Status.INFO, "User can edit the portion/deadline and can reactivate the plan");
		}
		assert1.assertAll();

	}


	public void toVerify_User_Should_Be_Able_To_Create_New_Plan() throws Exception {
		toVerify_Manage_And_Create_Plan();
		SoftAssert assert1 =new SoftAssert();
		orp=new Object_ReviewPlan();
		omp.manageAndCreatePlan.click();

		Boolean createAStudyPlan=omp.createAStudyPlan.isDisplayed();
		if(createAStudyPlan) {
			System.out.println("Create a study plan tab is shown to the user");
			test.log(Status.INFO, "Create a study plan tab is shown to the user");
		}
		assert1.assertTrue(createAStudyPlan);

		omp.createAStudyPlan.click();

		//applyExplicitWaitsUntilElementVisible(omp.subjectAtCreatePlan);
		omp.subjectAtCreatePlan.click();
		applyExplicitWaitsUntilElementVisible(orp.chapterCheckBox);
		orp.chapterCheckBox.click();
		orp.addToPortion.click();

		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);

		String date=orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();
		System.out.println(actualDate);
		int i = Integer.parseInt(actualDate);
		int date2=i+3;

		if(i>=26) {
			orp.nextMonthButton.click();
			Thread.sleep(2000);
			//	 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(orp.date1));
			orp.date1.click();
		}
		else {
			MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
			date1.click();
		}


		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		//	orp.beginStudying.click();
		Thread.sleep(2000);
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("On tapping Create study plan, user navigated to the pages wherein user can select portion and deadline and can create a plan successfully");
		test.log(Status.INFO, "On tapping Create study plan, user navigated to the pages wherein user can select portion and deadline and can create a plan successfully");

		Boolean testUnit=omp.testUnitHeading.isDisplayed();
		assert1.assertTrue(testUnit);
		if(testUnit) {
			System.out.println("After successfully creating a plan from Manage and create button,Mylessons page of the newly created plan is show to the user");
			test.log(Status.INFO, "After successfully creating a plan from Manage and create button,Mylessons page of the newly created plan is show to the user");
		}
		assert1.assertAll();

	}


	public void toVerify_Locked_Lessons_Functionality() throws Exception {

		createPlan1(4);
		omp= new Object_MyLesson_Page();
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(omp.backIcon));
		applyExplicitWaitsUntilElementVisible(omp.backIcon);
		omp.backIcon.click();

		SoftAssert assert1 =new SoftAssert();
		toVerify_User_Navigate_to_MyLessonsPage();
		scrollTo2("Practice");
		//	List<MobileElement> lockedLessons=getDriver().findElementsById("com.tce.studi:id/locked");
		//	List<MobileElement> unlockedLessons=getDriver().findElementsById("com.tce.studi:id/img_overflow");

		//	List<MobileElement> lessons=getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup");
		System.out.println(omp.lessons.size());

		int i=1;
		for(MobileElement lesson : omp.lessons) {

			MobileElement web=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/android.view.ViewGroup/android.widget.ImageView[2]");
			System.out.println(web.getAttribute("resource-id")+"--------"+i);
			if(web.getAttribute("resource-id").equals("com.tce.studi:id/locked")) {

				//getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/android.view.ViewGroup/android.widget.TextView[3]").click();

				Boolean testPlanHeading=omp.testPlanHeading.isDisplayed();
				if(testPlanHeading) {
					System.out.println(i);
					System.out.println("Lessons in locked status in Upcoming tab are not functional");
					test.log(Status.INFO, "Lessons in locked status in Upcoming tab are not functional");
				}
				assert1.assertTrue(testPlanHeading);
			}
			i++;
		}

		scrollTo2("View");
		omp.viewFullSchedule.click();

		scrollTo2("Fri");

		//	List<MobileElement> lessons1=getDriver().findElementsById("com.tce.studi:id/locked");
		//	List<MobileElement> lessons2=getDriver().findElementsById("com.tce.studi:id/img_overflow");
		List<MobileElement> lessonStatus=new ArrayList<MobileElement>();
		lessonStatus.addAll(omp.lockedList1);
		lessonStatus.addAll(omp.unlockedList1);
		System.out.println(lessonStatus.size()+"size");


		for (int k = 1; k <=lessonStatus.size(); k++) {

			List<MobileElement> lessons12=getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+k+"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup");
			System.out.println(lessons12.size());
			for (int k2 = 1; k2 <=lessons12.size(); k2++) {

				MobileElement web=getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+k+"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+k2+"]/android.widget.ImageView[2]");
				if(web.getAttribute("resource-id").equals("com.tce.studi:id/locked")) {

					WebElement topic=	getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+k+"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+k2+"]/android.widget.TextView[3]");
					System.out.println(topic.getText());
					topic.click();

					Boolean testPlanHeading=omp.testPlanHeading1.isDisplayed();
					if(testPlanHeading) {
						System.out.println();
						System.out.println("Lessons in locked status in View Full Schedule tab are not functional");

					}
					assert1.assertTrue(testPlanHeading);
				}}
			//			j++;
			test.log(Status.INFO, "Lessons in locked status in View Full Schedule tab are not functional");
		}
		assert1.assertAll();
	}

	public void createPlan3(int day) throws Exception {
		orp=new Object_ReviewPlan();
		if(orp.subHeading.getText().contains("Paused")){
			orp.test_unit.click();
			applyExplicitWaitsUntilElementVisible(orp.resumePlan);
			orp.resumePlan.click();
			applyExplicitWait(5);
		}
		else {
			applyExplicitWait(5);
			orp.test_unit.click();
		}


		scrollTo2("Manage and Create Plans");		
		applyExplicitWait(5);
		orp.manageAndCreatePlan.click();
		//	applyExplicitWaitsUntilElementVisible(orp.);

		clickOnElement(findElementByText("Create"));
		applyExplicitWaitsUntilElementVisible(orp.subject_Political_AtCreatePlan);
		orp.subject_Political_AtCreatePlan.click();
		applyExplicitWaitsUntilElementVisible(orp.topicCheckBoxAtCreateStudyPlan);
		orp.topicCheckBoxAtCreateStudyPlan.click();
//		applyExplicitWaitsUntilElementVisible(orp.topicCheckBoxAtCreateStudyPlan1);
//		orp.topicCheckBoxAtCreateStudyPlan1.click();

		orp.addToPortion.click();

//		applyExplicitWaitsUntilElementVisible(orp.subject_GeographyAtCreatePlan);
//
//		orp.subject_GeographyAtCreatePlan.click();
//		applyExplicitWaitsUntilElementVisible(orp.topicCheckBoxAtCreateStudyPlan);
//		orp.topicCheckBoxAtCreateStudyPlan.click();
//		applyExplicitWaitsUntilElementVisible(orp.topicCheckBoxAtCreateStudyPlan1);
//		orp.topicCheckBoxAtCreateStudyPlan1.click();
//		orp.addToPortion.click();

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
		int date2=i+day;

		if(i>=22) {
			orp.nextMonthButton.click();
			Thread.sleep(2000);
			//			 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(orp.date1));

			System.out.println(orp.date1.getText());
			orp.date1.click();
		}
		else {
			MobileElement date3=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
			date3.click();
		}


		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Begin Studying"));


	}




}
