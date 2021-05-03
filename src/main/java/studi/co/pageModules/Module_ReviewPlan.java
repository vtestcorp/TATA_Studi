package studi.co.pageModules;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_MyLesson_Page;
import studi.co.pageObjects.Object_ReviewPlan;
import studi.co.pageObjects.Object_Syllabus_Section;

public class Module_ReviewPlan extends BaseClass{
	Object_MyLesson_Page omp;

	Object_Syllabus_Section osm;
	Object_ReviewPlan orp;
	String dailyStudyHoursBefore;


	public void toVerify_User_Navigate_to_ReviewPlan() throws MalformedURLException, InterruptedException {
		osm = new Object_Syllabus_Section();
		orp=new Object_ReviewPlan();
		SoftAssert assert1=new SoftAssert();

		Boolean landingPage=orp.userName.isDisplayed();
		if(landingPage) {
			System.out.println("User can be navigated to the landing page after login");
			test.log(Status.INFO, "User can be navigated to the landing page after login");
		}
		else {
			System.out.println("User can not be navigated to the landing page after login");
			test.log(Status.INFO, "User can not be navigated to the landing page after login");

		}
		assert1.assertTrue(landingPage);

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
			test.log(Status.INFO, "User able to navigate to MyLessons Page");
		}
		else {
			System.out.println("User unable to navigate to MyLessons Page");
			test.log(Status.INFO, "User unable to navigate to MyLessons Page");
		}
		assert1.assertTrue(myLessonPage);

		scrollTo2("Manage and Create Plans");		
		applyExplicitWait(5);

		Boolean reviewPlanTab=orp.reviewPlan.isDisplayed();
		if(reviewPlanTab) {
			System.out.println("At the bottom Review Plan button is displayed");
			test.log(Status.INFO, "At the bottom Review Plan button is displayed");

		}
		else {
			System.out.println("At the bottom Review Plan button is not displayed");
			test.log(Status.INFO, "At the bottom Review Plan button is not displayed");

		}
		String dailyGoals=orp.dailyGoals.getText();
		dailyStudyHoursBefore=getBetweenStrings(dailyGoals, "study", "every").trim();

		assert1.assertTrue(reviewPlanTab);

		assert1.assertAll();
	}


	public void toVerify_ReviewPlan_Tab() throws MalformedURLException, InterruptedException {

		toVerify_User_Navigate_to_ReviewPlan();

		orp.reviewPlan.click();
		applyExplicitWait(10);
		Thread.sleep(5000);
		Boolean testUnitHeading=orp.testPlanHeading.isDisplayed();
		if(testUnitHeading) {
			System.out.println("User can click on Review Plan button and can navigate to Review Plan Page");
			test.log(Status.INFO, "User can click on Review Plan button and can navigate to Review Plan Page");
		}
		Assert.assertTrue(testUnitHeading);

	}


	public void toVerify_Contents_on_ReviewPlan_Page() throws MalformedURLException, InterruptedException {
		toVerify_ReviewPlan_Tab();
		SoftAssert assert1=new SoftAssert();
		//applyExplicitWait(10);
		applyExplicitWaitsUntilElementVisible(orp.graphicalRepresentation);
		Boolean graphicalRepresentation=orp.graphicalRepresentation.isDisplayed();
		if(graphicalRepresentation) {
			System.out.println("Graphical Representation is displayed to user");
			test.log(Status.INFO, "Graphical Representation is displayed to user");
		}
		assert1.assertTrue(graphicalRepresentation);
		scrollTo2("Plan Details");
		Boolean portionProgress=orp.portionProgressBar.isDisplayed();
		if(portionProgress) {
			System.out.println("Portion Progress Bar is displayed to user");
			test.log(Status.INFO, "Portion Progress Bar is displayed to user");

		}
		assert1.assertTrue(portionProgress);

		applyExplicitWait(5);
		orp.editButton.click();

		Boolean modifyPortion=orp.modifyPortion.isDisplayed();
		if(modifyPortion) {
			System.out.println("Modify Portion Tab is displayed to user");
			test.log(Status.INFO, "Modify Portion Tab is displayed to user");

		}
		assert1.assertTrue(modifyPortion);

		Boolean pauseButton=orp.pause.isDisplayed();
		if(pauseButton) {
			System.out.println("Pause Button is displayed to user at bottom");
			test.log(Status.INFO, "Pause Button is displayed to user at bottom");

		}
		assert1.assertTrue(pauseButton);

		assert1.assertAll();
	}


	public void toVerify_Contents_of_graph() throws MalformedURLException, InterruptedException {
		toVerify_ReviewPlan_Tab();
		SoftAssert assert1=new SoftAssert();
		applyExplicitWait(10);
		Boolean graphicalRepresentation=orp.graphicalRepresentation.isDisplayed();
		if(graphicalRepresentation) {
			System.out.println("Graphical Representation is displayed to user");
			test.log(Status.INFO, "Graphical Representation is displayed to user");
		}
		assert1.assertTrue(graphicalRepresentation);

		Boolean plannedTask=orp.plannedTask.isDisplayed();
		if(plannedTask) {
			System.out.println("User able to see the status of the active plan in Planned Task");
			test.log(Status.INFO, "User able to see the status of the active plan in Planned Task");
		}
		assert1.assertTrue(plannedTask);

		Boolean currentTask=orp.currentTask.isDisplayed();
		if(currentTask) {
			System.out.println("User able to see the status of the active plan in Current Task");
			test.log(Status.INFO, "User able to see the status of the active plan in Current Task");
		}
		assert1.assertTrue(currentTask);

		Boolean requiredTask=orp.requiredTask.isDisplayed();
		if(requiredTask) {
			System.out.println("User able to see the status of the active plan in Required Task");
			test.log(Status.INFO, "User able to see the status of the active plan in Required Task");
		}
		assert1.assertTrue(requiredTask);

		Boolean filterOption=orp.filter.isDisplayed();
		if(filterOption) {
			System.out.println("Filter option displayed at the top of the Graph");
			test.log(Status.INFO, "Filter option displayed at the top of the Graph");
		} 
		assert1.assertTrue(filterOption);

		applyExplicitWait(10);
		scrollTo2("You are almost there");
		Boolean informationText=orp.youAlmostThere.isDisplayed();
		if(informationText) {
			System.out.println(orp.youAlmostThere.getText()+" this information text is displayed to keep user in sync with the progress in active plan");
			test.log(Status.INFO, orp.youAlmostThere.getText()+" this information text is displayed to keep user in sync with the progress in active plan");
		}
		assert1.assertTrue(informationText);
		assert1.assertAll();

	}


	public void toVerify_Progress_of_Active_Plan_Datewise() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_ReviewPlan_Tab();

		applyExplicitWait(10);

		//clickOnCoordinate(450, 550);
		Thread.sleep(2000);
		System.out.println("Clicked on a graph on a Date");
		test.log(Status.INFO, "Clicked on a graph on a Date");

		//applyExplicitWait(10);
		applyExplicitWaitsUntilElementVisible(orp.graphicalRepresentation);
		Boolean status=orp.plan.isDisplayed();
		if(status) {
			System.out.println("User is shown the status of the active plan in Planned vs Required vs Actual flow of study, datewise");
			test.log(Status.INFO, "User is shown the status of the active plan in Planned vs Required vs Actual flow of study, datewise");
		}
		else {
			System.out.println("Status of active plan is not shown");
		}
		assert1.assertTrue(status);

		//assert1.assertAll();

	}


	public void toVerify_Filter_Option() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_ReviewPlan_Tab();

		orp.filter.click();
		Thread.sleep(10000);
		applyExplicitWaitsUntilElementVisible(orp.filterFullPlan);
		Boolean fullStudyPlan=orp.filterFullPlan.isDisplayed();
		if(fullStudyPlan) {
			System.out.println("Full Study Plan option displayed after clicking on Filter Option");
			test.log(Status.INFO, "Full Study Plan option displayed after clicking on Filter Option");

		}
		else {
			System.out.println("Full Study Plan option doesn't displayed after clicking on Filter Option");
			test.log(Status.INFO, "Full Study Plan option doesn't displayed after clicking on Filter Option");

		}
		assert1.assertTrue(fullStudyPlan);

		//applyExplicitWaitsUntilElementClickable(orp.apply);
		Boolean monthlyPlan=orp.filterThisMonth.isDisplayed();
		if(monthlyPlan) {
			System.out.println("Monthly Plan option displayed after clicking on Filter Option");
			test.log(Status.INFO, "Monthly Plan option displayed after clicking on Filter Option");

		}
		else {
			System.out.println("Monthly Plan option doesn't displayed after clicking on Filter Option");
			test.log(Status.INFO, "Monthly Plan option doesn't displayed after clicking on Filter Option");

		}
		assert1.assertTrue(monthlyPlan);

		Boolean weeklyPlan=orp.filterThisWeek.isDisplayed();
		if(weeklyPlan) {
			System.out.println("Weekly Plan option displayed after clicking on Filter Option");
			test.log(Status.INFO, "Weekly Plan option displayed after clicking on Filter Option");

		}
		else {
			System.out.println("Weekly Plan option doesn't displayed after clicking on Filter Option");
			test.log(Status.INFO, "Weekly Plan option doesn't displayed after clicking on Filter Option");

		}
		assert1.assertTrue(weeklyPlan);


		assert1.assertAll();

	}


	public void toVerify_Monthly_Option() throws MalformedURLException, InterruptedException {
		toVerify_Filter_Option();
		SoftAssert assert1=new SoftAssert();
		applyExplicitWaitsUntilElementVisible(orp.filterThisMonth);
		Boolean month=orp.filterThisMonth.isDisplayed();
		assert1.assertTrue(month);
		orp.filterThisMonth.click();

		Boolean monthClick=orp.filterThisMonth.isSelected();
		if(month && monthClick) {
			System.out.println("User can click on Monthly Option");
			test.log(Status.INFO, "User can click on Monthly Option");
		}
		else {
			System.out.println("User can't click on Monthly Option");
			test.log(Status.INFO, "User can't click on Monthly Option");
		}
		assert1.assertTrue(monthClick);

		orp.apply.click();


	}


	public void toVerify_Weekly_Option() {


	}


	public void toVerify_Full_Plan_in_Graph() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_ReviewPlan_Tab();
		applyExplicitWait(10);	
		Boolean graph=orp.defaultGraph.isDisplayed();
		assert1.assertTrue(graph);

		clickOnCoordinate(450, 550);
		applyExplicitWait(10);
		Boolean defaultViewGraph=orp.plan.isDisplayed();
		assert1.assertTrue(defaultViewGraph);

		if(graph && defaultViewGraph) {
			System.out.println("User able to view Full Plan in the Graph (Default View)");
			test.log(Status.INFO, "User able to view Full Plan in the Graph (Default View)");
		}
		else {
			System.out.println("User unable to view Full Plan in the Graph (Default View)");
			test.log(Status.INFO, "User unable to view Full Plan in the Graph (Default View)");
		}
		assert1.assertAll();;
	}


	public void toVerify_ProgressBar_InReviewPage() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_ReviewPlan_Tab();

		scrollTo2("Plan Details");
		Boolean progressbar=orp.progressBar.isDisplayed();
		if(progressbar) {
			System.out.println("Progress Bar Displayed under the Heading Portion");
			test.log(Status.INFO, "Progress Bar Displayed under the Heading Portion");

		}
		assert1.assertTrue(progressbar);

	}


	public void toVerify_ProgressBar_ofEachSubject_InReviewPage() throws MalformedURLException, InterruptedException {
		toVerify_User_Navigate_to_ReviewPlan();
		SoftAssert assert1=new SoftAssert();
		applyExplicitWait(5);

		orp.reviewPlan.click();
		scrollTo2("Plan Details");
		//	List <MobileElement> subjectProgressBars=getDriver().findElementsById("com.tce.studi:id/upper_progress");
		System.out.println("Total Test subjects displayed are :"+orp.subjectProgressBars.size());
		int i=1;
		for(MobileElement progressBar : orp.subjectProgressBars) {

			String subjectName=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/android.widget.TextView[1]").getText();
			Boolean progressbar=progressBar.isDisplayed();
			if(progressbar) {
				System.out.println("Progress Bar Displayed for "+subjectName+" subject under the Heading Portion");
				test.log(Status.INFO, "Progress Bar Displayed for "+subjectName+" subject under the Heading Portion");
			}
			assert1.assertTrue(progressbar);
			i++;
		}

		assert1.assertAll();
	}


	public void toVerify_SeekBar_InReviewPage() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_ReviewPlan_Tab();

		scrollTo2("Plan Details");

		Boolean seekBar=orp.seekBar.isDisplayed();
		if(seekBar) {
			System.out.println("Seek Bar Displayed under the Heading Portion");
			test.log(Status.INFO, "Seek Bar Displayed under the Heading Portion");
		}
		assert1.assertTrue(seekBar);
		String seekBarPercentage=orp.seekBar.getText();

		double seekBarPercent=Double.parseDouble(seekBarPercentage);
		int seekbarPercentInt=(int)seekBarPercent;
		System.out.println(seekbarPercentInt);

		if(seekbarPercentInt>0) {
			System.out.println("In this Subject ,User has moved further");
			test.log(Status.INFO, "In this Subject ,User has moved further");
		}
		else {
			System.out.println("In this Subject,User is lacking behind the schedule");
			test.log(Status.INFO, "In this Subject,User is lacking behind the schedule");

		}
	}


	public void toVerify_TopicsAndChapters_InReviewPlanPage() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_ReviewPlan_Tab();

		applyExplicitWait(5);
		scrollTo2("Plan Details");
		Boolean progressbar=orp.progressBar.isDisplayed();
		if(progressbar) {
			System.out.println("Progress Bar Displayed under the Heading Portion");
			test.log(Status.INFO, "Progress Bar Displayed under the Heading Portion");
		}
		assert1.assertTrue(progressbar);

		Boolean topicChapter=orp.topicAndChapter.isDisplayed();
		if(topicChapter) {
			System.out.println("Total number of chapters and topics added to the subject are shown to the user.");
			test.log(Status.INFO, "Total number of chapters and topics added to the subject are shown to the user.");
		}
		assert1.assertTrue(topicChapter);

		assert1.assertAll();
	}


	public void toVerify_SubjectShown_In_ReviewPage_IsTappable() throws MalformedURLException, InterruptedException {

		SoftAssert assert1=new SoftAssert();
		toVerify_ReviewPlan_Tab();
		scrollTo2("Plan Details");
		Boolean subject=orp.subjectNameAtReviewPlanPage.isDisplayed();

		assert1.assertTrue(subject);
		orp.subjectNameAtReviewPlanPage.click();
		applyExplicitWait(10);
		Thread.sleep(5000);
		Boolean subjectHeading=	orp.subjectHeading.isDisplayed();

		if(subjectHeading && subject) {
			System.out.println("Subject shown under portion with a progress bar is tappable");
			test.log(Status.INFO, "Subject shown under portion with a progress bar is tappable");
		}
		assert1.assertTrue(subjectHeading);
		assert1.assertAll();

	}


	public void toVerify_Portions_AddedToTheSubject_In_ActivePlan() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_SubjectShown_In_ReviewPage_IsTappable();

		applyExplicitWait(5);
		Thread.sleep(5000);
		Boolean chapters=orp.chaptersInSubject.isDisplayed();
		if(chapters) {
			System.out.println("Chapters are shown in active plan");
			test.log(Status.INFO, "Chapters are shown in active plan");
		}
		assert1.assertTrue(chapters);

		//	List<MobileElement> topics=getDriver().findElementsById("com.tce.studi:id/tvTopic");
		int totalTopics=orp.topics.size();
		System.out.println("Total topics shown in chapter are  : "+totalTopics);
		test.log(Status.INFO, "Total topics shown in chapter are  : "+totalTopics);


		for(MobileElement topic : orp.topics) {
			Boolean verify=topic.isDisplayed();
			assert1.assertTrue(verify);
			System.out.println(topic.getText());
			test.log(Status.INFO, topic.getText());
		}
		assert1.assertAll();
	}


	public void toVerify_Turtle_Icon() throws MalformedURLException, InterruptedException {
		toVerify_User_Navigate_to_ReviewPlan();
		SoftAssert assert1=new SoftAssert();
		applyExplicitWait(5);
		scrollTo2("Manage and Create Plans");
		orp.manageAndCreatePlan.click();
		System.out.println("Clicked on manage And Create Plan");
		applyExplicitWait(10);
		Thread.sleep(5000);
		orp.turtleTestUnit.click();
		applyExplicitWait(5);

		scrollTo2("Plan Details");

		String seekBarPercentage=orp.seekBar.getText();
		double seekBarPercent=Double.parseDouble(seekBarPercentage);
		int seekbarPercentInt=(int)seekBarPercent;


		if(seekbarPercentInt==0) {
			Boolean isIconDisplayed=orp.turtleIcon.isDisplayed();

			if(isIconDisplayed) {
				System.out.println("Turtle icon is displayed,if progress on the plan is slow for any subject");
				test.log(Status.INFO, "Turtle icon is displayed,if progress on the plan is slow for any subject");
			}
			assert1.assertTrue(isIconDisplayed);
		}
		assert1.assertAll();
	}


	public void toVerify_Rabbit_Icon() throws MalformedURLException, InterruptedException {

		toVerify_User_Navigate_to_ReviewPlan();
		SoftAssert assert1=new SoftAssert();
		applyExplicitWait(5);
		scrollTo2("Manage and Create Plans");
		orp.manageAndCreatePlan.click();
		System.out.println("Clicked on Manage and Create Plans");
		applyExplicitWait(5);
		orp.rabbitTestUnit.click();
		applyExplicitWait(5);

		scrollTo2("Plan Details");

		String seekBarPercentage=orp.seekBar.getText();
		double seekBarPercent=Double.parseDouble(seekBarPercentage);
		int seekbarPercentInt=(int)seekBarPercent;


		if(seekbarPercentInt>0) {
			Boolean isIconDisplayed=orp.rabbitIcon.isDisplayed();

			if(isIconDisplayed) {
				System.out.println("Rabbit icon is displayed,if progress on the plan is fast for any subject");
				test.log(Status.INFO, "Rabbit icon is displayed,if progress on the plan is fast for any subject");

			}
			assert1.assertTrue(isIconDisplayed);

		}
		assert1.assertAll();

	}


	public void toVerify_PlanDetailtab() throws MalformedURLException, InterruptedException {
		toVerify_ReviewPlan_Tab();
		SoftAssert assert1=new SoftAssert();

		scrollTo2("Plan Details");
		Boolean planDetails=orp.planDetails.isDisplayed();
		if(planDetails) {
			System.out.println("The Plan Detail tab is shown to the user");
			test.log(Status.INFO, "The Plan Detail tab is shown to the user");
		}
		assert1.assertTrue(planDetails);
		assert1.assertAll();
	}


	public void toVerify_DetailsIn_PlanDetailtab() throws MalformedURLException, InterruptedException {

		toVerify_PlanDetailtab();
		SoftAssert assert1=new SoftAssert();

		Boolean currentWeek=orp.currentWeek.isDisplayed();
		if(currentWeek) {
			System.out.println("The current week, user is presently in is shown to user");
			test.log(Status.INFO, "The current week, user is presently in is shown to user");

		}
		assert1.assertTrue(currentWeek);

		Boolean dailyGoal=orp.dailyGoal.isDisplayed();
		String dailyGoalWithEndDate=orp.dailyGoal.getText();

		String [] endDateArray=dailyGoalWithEndDate.split("by");
		String endDate=endDateArray[1].trim();


		if(dailyGoal) {
			System.out.println("Daily Study Goal is shown to the user");
			test.log(Status.INFO, "Daily Study Goal is shown to the user");

			System.out.println("Plan End Date is shown to user");
			test.log(Status.INFO, "Plan End Date is shown to user");

			System.out.println(endDate);

		}
		assert1.assertTrue(dailyGoal);

		assert1.assertAll();
	}


	public void toVerify_ModifyTab_PlanDetailtab() throws MalformedURLException, InterruptedException {

		toVerify_ReviewPlan_Tab();
		SoftAssert assert1=new SoftAssert();

		Boolean modifyTab=orp.editButton.isDisplayed();
		if(modifyTab) {
			System.out.println("The Modify tab is shown to the user");
			test.log(Status.INFO, "The Modify tab is shown to the user");
		}
		assert1.assertTrue(modifyTab);
		assert1.assertAll();

	}


	public void toVerify_DeadLineTab() throws MalformedURLException, InterruptedException {

		toVerify_ReviewPlan_Tab();
		SoftAssert assert1=new SoftAssert();

		Boolean modifyTab=orp.editButton.isDisplayed();
		if(modifyTab) {
			System.out.println("The Modify tab is shown to the user");
			test.log(Status.INFO, "The Modify tab is shown to the user");

		}
		assert1.assertTrue(modifyTab);
		orp.editButton.click();
		applyExplicitWait(5);


		Boolean deadLineOption=orp.dailyStudyTime.isDisplayed();
		if(deadLineOption) {
			System.out.println("Under Modify tab, Deadline  option is shown to the user");
			test.log(Status.INFO, "Under Modify tab, Deadline  option is shown to the user");

		}
		assert1.assertTrue(deadLineOption);
		assert1.assertAll();
	}


	public void toVerify_DeadLineTab_UnderModifyTab() throws MalformedURLException, InterruptedException {
		toVerify_DeadLineTab();
		SoftAssert assert1=new SoftAssert();

		applyExplicitWait(15);
		Thread.sleep(5000);
		orp.dailyStudyTime.click();
		applyExplicitWait(15);
		Boolean deadLinePage=orp.deadLinepage.isDisplayed();
		System.out.println("DeadLine page is displayed");
		assert1.assertTrue(deadLinePage);

		applyExplicitWaitsUntilElementVisible(orp.calender);
		Boolean calender=orp.calender.isDisplayed();
		assert1.assertTrue(calender);

		if(deadLinePage && calender) {
			System.out.println("User navigated to the Review Deadline page with Calendar view");
			test.log(Status.INFO, "User navigated to the Review Deadline page with Calendar view");

		}
		assert1.assertAll();
	}


	public void toVerify_ModifiedDeadline() throws MalformedURLException, InterruptedException, ParseException {

		toVerify_DeadLineTab_UnderModifyTab();

		String date=orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();
		System.out.println(actualDate);
		System.out.println(s[1]);
		int i = Integer.parseInt(actualDate);
		int date2;

		if(i>=26) {
			date2=1;
			orp.nextMonthButton.click();
			//		 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));
			orp.date1.click();
		}
		else {
			date2=i+4;
			MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
			date1.click();
		}







		applyExplicitWait(5);
		Thread.sleep(3000);
		//		orp.nextStep.click();
		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		//	orp.beginStudying.click();
		clickOnElement(findElementByText("Begin Studying"));
		Thread.sleep(3000);
		scrollTo2("Review Plan");
		String dailyGoalWithEndDate=orp.dailyGoals.getText();

		String [] endDateArray=dailyGoalWithEndDate.split("by");
		String endDate=endDateArray[1].trim();
		System.out.println(endDate);
		Assert.assertTrue(endDate.contains(date2+""));
		System.out.println("After selecting date in the calendar, users able to activate the plan with the new deadline");
		test.log(Status.INFO, "After selecting date in the calendar, users able to activate the plan with the new deadline");

	}


	public void toVerify_UnfeasibleDeadline() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_DeadLineTab_UnderModifyTab();

		String date=orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();
		//		System.out.println(actualDate);
		int i = Integer.parseInt(actualDate);
		int date2=i-2;


		MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
		date1.click();

		Thread.sleep(2000);
		Boolean feasibleDate=orp.date1.isSelected();
		if(feasibleDate) {
			System.out.println("User able to activate the plan with unfeasible deadline");
			test.log(Status.INFO, "User able to activate the plan with unfeasible deadline");
		}
		else
		{
			System.out.println("User unable to activate the plan with unfeasible deadline");
			test.log(Status.INFO, "User unable to activate the plan with unfeasible deadline");
		}
		assert1.assertFalse(feasibleDate);
		assert1.assertAll();
	}


	public void toVerify_ModifiedDeadline_InMyLessonsPage() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_DeadLineTab_UnderModifyTab();


		String date=orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();

		int i = Integer.parseInt(actualDate);
		int date2;

		if(i>=25) {
			date2=1;
			orp.nextMonthButton.click();
			//			 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));
			orp.date1.click();
		}
		else {
			date2=i+6;
			MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
			date1.click();
		}

		applyExplicitWait(5);
		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		//	orp.beginStudying.click();
		clickOnElement(findElementByText("Begin Studying"));

		applyExplicitWaitsUntilElementVisible(orp.testPlanHeading);

		Boolean testPlanPage=orp.testPlanHeading.isDisplayed();
		if(testPlanPage) {
			System.out.println("After activating the updated deadline, user can navigated to Mylessons page");
			test.log(Status.INFO, "After activating the updated deadline, user can navigated to Mylessons page");
		}
		assert1.assertTrue(testPlanPage);
		scrollTo2("Review Plan");
		String dailyGoalWithEndDate=orp.dailyGoals.getText();

		String [] endDateArray=dailyGoalWithEndDate.split("by");
		String endDate=endDateArray[1].trim();
		System.out.println(endDate);
		Assert.assertTrue(endDate.contains(date2+""));
		test.log(Status.INFO, "User able to view the modified deadline of the plan");

	}

	public void toVerify_PortionOption() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_ReviewPlan_Tab();
		orp.editButton.click();

		Boolean portion=orp.modifyPortion.isDisplayed();
		if(portion) {
			System.out.println("Portion option is displayed under Modify Tab");
			test.log(Status.INFO, "Portion option is displayed under Modify Tab");
		}
		assert1.assertTrue(portion);
	}

	public void toVerify_PortionOption_IsFunctional() throws MalformedURLException, InterruptedException {
		toVerify_PortionOption();
		SoftAssert assert1=new SoftAssert();
		orp.modifyPortion.click();

		applyExplicitWait(5);
		Boolean editStudyPlanPage=orp.editStudyPlanPage.isDisplayed();
		if(editStudyPlanPage) {
			System.out.println("On tapping Portion, user navigated to the Edit study Plan page with the bookshelf view");
			test.log(Status.INFO, "On tapping Portion, user navigated to the Edit study Plan page with the bookshelf view");
		}
		assert1.assertTrue(editStudyPlanPage);
	}


	public void toVerify_toModify_thePortion() throws MalformedURLException, InterruptedException {
		//	String subject="Political Science";
		String subject="Geography";
		toVerify_PortionOption_IsFunctional();
		SoftAssert assert1=new SoftAssert();
		applyExplicitWait(5);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(5);

		orp.checkBox1.click();
		//		orp.checkBox2.click();
		//		orp.checkBox4.click();

		orp.addToPortion.click();
		applyExplicitWait(5);

		MobileElement topicsAndChapters=getDriver().findElementByXPath("//*[contains(@text, '"+subject+"')]/following-sibling::android.widget.TextView");
		String topicChaptersAfterAdd=topicsAndChapters.getText();
		System.out.println(topicChaptersAfterAdd);
		Boolean verify=topicsAndChapters.isDisplayed();
		if(verify) {
			System.out.println("Topics and Chapters displayed under subject name");
		}
		assert1.assertTrue(verify);

		clickOnElement(findElementByText(subject));
		applyExplicitWait(5);
		orp.checkBox2.click();
		//		orp.checkBox4.click();
		orp.addToPortion.click();
		applyExplicitWait(5);

		MobileElement topicsAndChaptersAfter=getDriver().findElementByXPath("//*[contains(@text, '"+subject+"')]/following-sibling::android.widget.TextView");
		String topicChaptersAfterUpdate=topicsAndChapters.getText();
		System.out.println(topicChaptersAfterUpdate);

		assert1.assertNotEquals(topicChaptersAfterAdd, topicChaptersAfterUpdate);
		assert1.assertAll();

	}


	public void toVerify_toModify_CountOfChapters() throws MalformedURLException, InterruptedException {
		String subject="Political Science";
		toVerify_PortionOption_IsFunctional();
		SoftAssert assert1=new SoftAssert();

		//	String beforeAddMessage=orp.TopicAndChaptersOnEditPage.getText();

		MobileElement topicsAndChaptersBefore=getDriver().findElementByXPath("//*[contains(@text, '"+subject+"')]/following-sibling::android.widget.TextView");
		String beforeAddMessage=topicsAndChaptersBefore.getText();
		System.out.println(beforeAddMessage);
		//orp.subjectOnEditPage.click();
		clickOnElement(findElementByText(subject));
		applyExplicitWait(5);
		//	orp.checkBox2.click();
		orp.checkBox3.click();
		orp.checkBox1.click();
		orp.addToPortion.click();
		applyExplicitWait(5);

		//	String afterAddMessage=orp.TopicAndChaptersOnEditPage.getText();
		//	Boolean afterAdd=orp.TopicAndChaptersOnEditPage.isDisplayed();

		MobileElement topicsAndChaptersAfter=getDriver().findElementByXPath("//*[contains(@text, '"+subject+"')]/following-sibling::android.widget.TextView");
		String afterAddMessage=topicsAndChaptersAfter.getText();
		System.out.println(afterAddMessage);

		if(!beforeAddMessage.equals(afterAddMessage)) {
			System.out.println("User can show modified count of Chapters/Topics added to the plan");
			test.log(Status.INFO, "User can show modified count of Chapters/Topics added to the plan");
		}

	}


	public void toVerify_Activation_ofModifiedPortion_ToThePlan() throws MalformedURLException, InterruptedException {
		String subject="Geography";
		toVerify_PortionOption_IsFunctional();
		SoftAssert assert1=new SoftAssert();
		Thread.sleep(5000);
		//	orp.geographyOnEditPage.click();
		clickOnElement(findElementByText(subject));

		applyExplicitWait(5);
		orp.checkBoxGeography.click();
		orp.addToPortion.click();
		applyExplicitWait(5);
		orp.nextStep.click();
		applyExplicitWait(5);
		orp.nextStep1.click();
		applyExplicitWait(5);
		orp.nextStep1.click();
		applyExplicitWait(5);

		Boolean activatePlan=orp.activateplan.isDisplayed();
		if(activatePlan) {
			System.out.println("User can activate the plan");
			test.log(Status.INFO, "User can activate the plan");

		}
		assert1.assertTrue(activatePlan);
		orp.activateplan.click();
		applyExplicitWait(5);
		orp.beginStudying.click();

		assert1.assertAll();
	}


	public void toVerify_PauseTab() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_ModifyTab_PlanDetailtab();

		orp.editButton.click();

		Boolean pauseButton=orp.pauseButton.isDisplayed();
		if(pauseButton) {
			System.out.println("Pause Button is displayed");
			test.log(Status.INFO, "Pause Button is displayed");

		}
		assert1.assertTrue(pauseButton);
		assert1.assertAll();
	}


	public void toVerify_PauseTab_IsFunctional() throws MalformedURLException, InterruptedException {
		toVerify_PauseTab();		
		SoftAssert assert1=new SoftAssert();

		orp.pauseButton.click();
		applyExplicitWait(5);
		Boolean pauseMessage=orp.pauseMessage.isDisplayed();
		if(pauseMessage) {
			System.out.println("Pause Tab is Tappable");
			test.log(Status.INFO, "Pause Tab is Tappable");

		}
		assert1.assertTrue(pauseMessage);
		assert1.assertAll();
	}


	public void toVerify_UserAbleTo_PausePlan() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_PauseTab_IsFunctional();

		Boolean pauseMessage=orp.pauseMessage.isDisplayed();
		if(pauseMessage) {
			System.out.println("User able to navigate to the pause plan page");
			test.log(Status.INFO, "User able to navigate to the pause plan page");

		}
		assert1.assertTrue(pauseMessage);

		orp.proceedButton.click();

		Boolean pausePlan=orp.pausePlanPageHeading.isDisplayed();
		if(pausePlan) {
			System.out.println("User can successfully pause the plan");
			test.log(Status.INFO, "User can successfully pause the plan");

		}
		assert1.assertTrue(pausePlan);
		assert1.assertAll();
	}


	public void toVerify_UserAbleTo_Activate_PausePlan() throws MalformedURLException, InterruptedException {
		toVerify_UserAbleTo_PausePlan()	;
		SoftAssert assert1=new SoftAssert();
		orp.resumePlan.click();

		Boolean verifyResumePlan=orp.testPlanPage.isDisplayed();
		if(verifyResumePlan) {
			System.out.println("On tapping Activate Plan, user able to Reactivate the same paused plan successfully");
			test.log(Status.INFO, "On tapping Activate Plan, user able to Reactivate the same paused plan successfully");
		}
		assert1.assertTrue(verifyResumePlan);

	}


	public void toVerify_UserAbleTo_Activate_AnyOtherPlan() throws MalformedURLException, InterruptedException {
		toVerify_UserAbleTo_PausePlan()	;
		SoftAssert assert1=new SoftAssert();

		Boolean selectAnotherPlan=orp.selectAnotherPlan.isDisplayed();
		if(selectAnotherPlan) {
			System.out.println("Navigate to other Plans option is displayed");
			test.log(Status.INFO, "Navigate to other Plans option is displayed");
		}
		assert1.assertTrue(selectAnotherPlan);

		orp.selectAnotherPlan.click();

		//		List <MobileElement> listOfOtherPlans=driver.findElementsById("com.tce.studi:id/tv_plan_name");
		System.out.println(orp.listOfOtherPlans.size());

		for(MobileElement plan: orp.listOfOtherPlans) {
			Boolean verify=plan.isDisplayed();
			System.out.println(plan.getText());
			test.log(Status.INFO, plan.getText());
			assert1.assertTrue(verify);

		}

		applyExplicitWait(5);
		orp.testUnit1.click();
		Boolean verify=orp.testPlanHeading1.isDisplayed();
		if(verify) {
			System.out.println("User able to select any plan from the list and able to activate the plan");
			test.log(Status.INFO, "User able to select any plan from the list and able to activate the plan");
		}
		assert1.assertTrue(verify);
		assert1.assertAll();

	}


	public void toVerify_OnTapping_PausedPlan_UserShouldNotbe_shown_MyLessons_Page() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		orp=new Object_ReviewPlan();
		Boolean landingPage=orp.userName.isDisplayed();
		if(landingPage) {
			System.out.println("User can be navigated to the landing page after login");
			test.log(Status.INFO, "User can be navigated to the landing page after login");
		}
		else {
			System.out.println("User can not be navigated to the landing page after login");
			test.log(Status.INFO, "User can not be navigated to the landing page after login");

		}
		assert1.assertTrue(landingPage);
		applyExplicitWait(5);
		Boolean testPlan=orp.test_unit.isDisplayed();
		assert1.assertTrue(testPlan);
		Boolean testPlanSubheading=orp.subHeading.isDisplayed();
		if(testPlan && testPlanSubheading) {
			System.out.println("Paused StudyPlan Tab is displayed on landing Page");
			test.log(Status.INFO, "Paused StudyPlan Tab is displayed on landing Page");
		}
		assert1.assertTrue(testPlanSubheading);

		if(orp.subHeading.getText().contains("Completing")){
			orp.test_unit.click();
			scrollTo2("Review Plan");
			orp.pauseTab.click();
			applyExplicitWait(5);
			orp.proceedButton.click();
			applyExplicitWait(5);
			Thread.sleep(2000);
			orp.back.click();
		}

		orp.test_unit.click();
		applyExplicitWait(5);
		Boolean myLessonpage = false;
		try {
			myLessonpage=orp.planTestUnit.isDisplayed();
			if(myLessonpage) {
				System.out.println("My lessons page is displayed");
			}}
		catch(NoSuchElementException e) {
			System.out.println("My lessons page is not displayed");
		}

		assert1.assertFalse(myLessonpage);

	}


	public void toVerify_OnTapping_PausedPlan_UserShouldNotbe_shown_StudyRing() throws MalformedURLException, InterruptedException {

		SoftAssert assert1=new SoftAssert();
		orp=new Object_ReviewPlan();
		applyExplicitWait(5);
		Boolean landingPage=orp.userName.isDisplayed();
		if(landingPage) {
			System.out.println("User can be navigated to the landing page after login");
			test.log(Status.INFO, "User can be navigated to the landing page after login");
		}
		else {
			System.out.println("User can not be navigated to the landing page after login");
			test.log(Status.INFO, "User can not be navigated to the landing page after login");

		}
		assert1.assertTrue(landingPage);
		Boolean testPlan=orp.test_unit.isDisplayed();
		assert1.assertTrue(testPlan);
		Boolean testPlanSubheading=orp.subHeading.isDisplayed();
		if(testPlan && testPlanSubheading) {
			System.out.println("Paused StudyPlan Tab is displayed on landing Page");
			test.log(Status.INFO, "Paused StudyPlan Tab is displayed on landing Page");
		}
		assert1.assertTrue(testPlanSubheading);

		if(orp.subHeading.getText().contains("Completing")){
			orp.test_unit.click();
			scrollTo2("Review Plan");
			orp.pauseTab.click();
			applyExplicitWait(5);
			orp.proceedButton.click();
			applyExplicitWait(5);
			Thread.sleep(2000);
			orp.back.click();
		}

		orp.test_unit.click();
		applyExplicitWait(5);
		Boolean myLessonpage = false;
		try {
			myLessonpage=orp.studyRing.isDisplayed();
			if(myLessonpage) {
				System.out.println("Study Ring is displayed");
			}}
		catch(NoSuchElementException e) {
			System.out.println("Study Ring is not displayed");
		}
		assert1.assertFalse(myLessonpage);
		assert1.assertAll();
	}


	public void toVerify_Paused_ActivePlan() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		orp=new Object_ReviewPlan();

		Boolean landingPage=orp.userName.isDisplayed();
		if(landingPage) {
			System.out.println("User can be navigated to the landing page after login");
			test.log(Status.INFO, "User can be navigated to the landing page after login");
		}
		else {
			System.out.println("User can not be navigated to the landing page after login");
			test.log(Status.INFO, "User can not be navigated to the landing page after login");
		}
		assert1.assertTrue(landingPage);

		Boolean testPlan=orp.test_unit.isDisplayed();
		assert1.assertTrue(testPlan);
		Boolean testPlanSubheading=orp.subHeading.isDisplayed();
		if(testPlan && testPlanSubheading) {
			System.out.println("Paused StudyPlan Tab is displayed on landing Page");
			test.log(Status.INFO, "Paused StudyPlan Tab is displayed on landing Page");
		}
		assert1.assertTrue(testPlanSubheading);

		if(orp.subHeading.getText().contains("Completing")){
			orp.test_unit.click();
			scrollTo2("Review Plan");
			orp.pauseTab.click();
			applyExplicitWait(5);
			orp.proceedButton.click();
			applyExplicitWait(5);
			Thread.sleep(2000);
			orp.back.click();
		}

		applyExplicitWait(5);
		orp.test_unit.click();

		Boolean pausePlan=orp.pausePlanPageHeading.isDisplayed();
		if(pausePlan) {
			System.out.println("user can navigated to the paused plan page");
			test.log(Status.INFO, "user can navigated to the paused plan page");
		}
		assert1.assertTrue(pausePlan);

		Boolean selectAnotherPlan=orp.selectAnotherPlan.isDisplayed();
		if(selectAnotherPlan) {
			System.out.println("Navigate to other Plan option is displayed");
			test.log(Status.INFO, "Navigate to other Plan option is displayed");
		}
		assert1.assertTrue(selectAnotherPlan);

		Boolean resumePlan=orp.resumePlan.isDisplayed();
		if(resumePlan) {
			System.out.println("Resume Plan option is displayed");
			test.log(Status.INFO, "Resume Plan option is displayed");
		}
		assert1.assertTrue(resumePlan);

		orp.resumePlan.click();
		Boolean verifyResumePlan=orp.testPlanPage.isDisplayed();
		if(verifyResumePlan) {
			System.out.println("On tapping Activate Plan, user able to Reactivate the same paused plan successfully");
			test.log(Status.INFO, "On tapping Activate Plan, user able to Reactivate the same paused plan successfully");

		}
		assert1.assertTrue(verifyResumePlan);

		scrollTo2("Review Plan");
		orp.pauseTab.click();
		applyExplicitWait(5);
		orp.proceedButton.click();
		applyExplicitWait(5);
		Thread.sleep(2000);

		orp.selectAnotherPlan.click();
		applyExplicitWait(5);
		orp.testUnit1.click();
		Boolean verify=orp.testPlanHeading1.isDisplayed();
		if(verify) {
			System.out.println("User able to select any plan from the list and able to activate the plan");
			test.log(Status.INFO, "User able to select any plan from the list and able to activate the plan");
		}
		assert1.assertTrue(verify);

		assert1.assertAll();
	}


	public void toVerify_UserCan_Discard_TheModifiedPortion() throws MalformedURLException, InterruptedException {

		String subject="Political Science";
		toVerify_PortionOption_IsFunctional();
		SoftAssert assert1=new SoftAssert();
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(orp.subjectOnEditPlanPage);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(orp.checkBoxTopic);
		orp.checkBoxTopic.click();
		applyExplicitWait(5);
		orp.addToPortion.click();
		applyExplicitWait(5);

		MobileElement topicsAndChaptersBefore=getDriver().findElementByXPath("//*[contains(@text, '"+subject+"')]/following-sibling::android.widget.TextView");
		String beforeAddMessage=topicsAndChaptersBefore.getText();
		System.out.println(beforeAddMessage);

		orp.delete.click();
		applyExplicitWait(5);
		orp.yesPleaseDiscard.click();
		applyExplicitWait(5);

		Boolean testUnitHeading=orp.testPlanHeading.isDisplayed();
		if(testUnitHeading) {
			System.out.println("On Deleting the modified portion, user can be navigated back to the Review Plan page");
			test.log(Status.INFO, "On Deleting the modified portion, user can be navigated back to the Review Plan page");
		}
		Assert.assertTrue(testUnitHeading);
		scrollTo2("Plan Details");

		String TopicAndChapterAfterDelete=orp.topicAndChaptersOnReviewPlanPage.getText();
		System.out.println(TopicAndChapterAfterDelete);
		assert1.assertAll();
	}


	public void toVerify_ToModify_ThePlansDeadLine() throws Exception {
		////		createPlans();
		////		omp= new Object_MyLesson_Page();
		////		applyExplicitWaitsUntilElementVisible(omp.backIcon);
		////		omp.backIcon.click();
		////		SoftAssert assert1=new SoftAssert();
		////		toVerify_DeadLineTab_UnderModifyTab();




		SoftAssert assert1 = new SoftAssert();
		toVerify_DeadLineTab_UnderModifyTab();

		String date = orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();
		System.out.println(actualDate);
		int i = Integer.parseInt(actualDate);
		int date2 = i + 2;

		if (i >= 26) {
			orp.nextMonthButton.click();
			MobileElement date1 = getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));
			date1.click();
		} else {
			MobileElement date1 = getDriver().findElement(By.xpath("//*[contains(@text, '" + date2 + ", 2021')]"));
			date1.click();
		}

		//		for (int i = 0; i <2; i++) {
		//			applyExplicitWait(5);
		//			orp.backMonthButton.click();
		//		}
		//		orp.date1.click();
		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		orp.beginStudying.click();

		scrollTo2("Review Plan");
		String dailyStudyHoursBefore1 = dailyStudyHoursBefore;
		System.out.println(dailyStudyHoursBefore1);
		String dailyGoals = orp.dailyGoals.getText();
		String dailyStudyHours = getBetweenStrings(dailyGoals, "study", "every").trim();
		System.out.println(dailyStudyHours);
		Assert.assertNotEquals(dailyStudyHoursBefore1, dailyStudyHours);





	}


	public void toVerify_Activation_ofModifiedPortion() throws MalformedURLException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		toVerify_PortionOption_IsFunctional();
		String subject="Political Science";

		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(orp.subjectOnEditPage);
		orp.subjectOnEditPage.click();
		applyExplicitWait(5);
		orp.checkBox1.click();
		orp.checkBox2.click();
		//		orp.checkBox4.click();
		applyExplicitWait(5);
		orp.addToPortion.click();

		MobileElement topicsAndChaptersBefore=getDriver().findElementByXPath("//*[contains(@text, '"+subject+"')]/following-sibling::android.widget.TextView");
		String topicAndChapters=topicsAndChaptersBefore.getText();
		System.out.println(topicAndChapters);
		String chapters=getBetweenStrings(topicAndChapters, "in", "chapter").trim();
		System.out.println(chapters);

		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(orp.beginStudying);
		clickOnElement(findElementByText("Begin Studying"));

		applyExplicitWaitsUntilElementVisible(orp.testPlanHeading);
		Boolean testPlanPage=orp.testPlanHeading.isDisplayed();
		if(testPlanPage) {
			System.out.println("After activating the updated portion plan, user navigated to Mylessons Page");
			test.log(Status.INFO, "After activating the updated portion plan, user navigated to Mylessons Page");
		}
		assert1.assertTrue(testPlanPage);
		scrollTo2("Review Plan");
		orp.reviewPlan.click();
		applyExplicitWait(5);
		scrollTo2("Plan Details");

		String topicsAndChapter=orp.subjectTopicAndChaptersOnReviewPlanPage.getText();
		String chaptersAfterModify=getBetweenStrings(topicsAndChapter, "Total", "chapters").trim();
		System.out.println(chaptersAfterModify);

		assert1.assertEquals(chapters, chaptersAfterModify);
	}


	public void createPlan() throws Exception {
		orp=new Object_ReviewPlan();
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

		clickOnElement(findElementByText("CREATE"));
		applyExplicitWaitsUntilElementVisible(orp.subjectAtCreatePlan);
		orp.subjectAtCreatePlan.click();
		applyExplicitWaitsUntilElementVisible(orp.topicCheckBoxAtCreateStudyPlan);
		orp.topicCheckBoxAtCreateStudyPlan.click();
		orp.addToPortion.click();

		clickOnElement(findElementByText("Next Step"));
		Thread.sleep(2000);
		clickOnElement(findElementByText("Next Step"));

		String date=orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();
		System.out.println(actualDate);
		int i = Integer.parseInt(actualDate);
		int date2=i+7;

		if(i>=26) {
			orp.nextMonthButton.click();
			Thread.sleep(2000);
			//			 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));


			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(orp.date1));
			orp.date1.click();
		}
		else {
			MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(date1));
			date1.click();
		}


		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		//			orp.beginStudying.click();
		applyExplicitWaitsUntilElementVisible(orp.beginStudying);
		clickOnElement(findElementByText("Begin Studying"));
		Thread.sleep(2000);
	}

	public void createPlans() throws Exception {
		orp=new Object_ReviewPlan();
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
		clickOnElement(findElementByText("Create"));
		applyExplicitWaitsUntilElementVisible(orp.subjectAtCreatePlan);
		orp.subjectAtCreatePlan.click();
		applyExplicitWaitsUntilElementVisible(orp.topicCheckBoxAtCreateStudyPlan);
		orp.topicCheckBoxAtCreateStudyPlan.click();
		orp.addToPortion.click();

		clickOnElement(findElementByText("Next Step"));
		Thread.sleep(2000);
		clickOnElement(findElementByText("Next Step"));

		String date=orp.selectDate.getText();
		System.out.println(date);
		String[] s = date.split(", ");
		String[] s1 = s[1].split(" ");
		String actualDate = s1[1].trim();
		System.out.println(actualDate);
		int i = Integer.parseInt(actualDate);
		int date2=i+1;

		if(i>=28) {
			orp.nextMonthButton.click();
			Thread.sleep(2000);
			//		 MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '1, 2021')]"));


			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(orp.date1));
			orp.date1.click();
		}
		else {
			MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '"+date2+", 2021')]"));
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(date1));
			date1.click();
		}


		clickOnElement(findElementByText("Next Step"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		//			orp.beginStudying.click();
		applyExplicitWaitsUntilElementVisible(orp.beginStudying);
		clickOnElement(findElementByText("Begin Studying"));
	}
}


