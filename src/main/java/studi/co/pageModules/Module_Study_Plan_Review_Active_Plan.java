package studi.co.pageModules;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Study_Plan_Review_Active_Plan;

public class Module_Study_Plan_Review_Active_Plan extends BaseClass {
	
	Object_Study_Plan_Review_Active_Plan objStudyPlan = new Object_Study_Plan_Review_Active_Plan();
	Module_Create_Study_Plan CSP = new Module_Create_Study_Plan();
	public static String homepage_title, no_active_study_plan, lbl_testUnit, review_button_name, lbl_browse_books, lbl_all_subjects, lbl_book_1, lbl_book_2;
	Robot robot=null;
	private List<String> lstQuestions=null;
	private String currentQuestionBeforeBackClicked="";
	
	
	public void Validate_Home_Page_Header() throws InterruptedException
	{
		Validate_Required_Label_Text("What would\n" + "you like to do next?", objStudyPlan.homePageHeader.getText(), 
				"User is navigated to the landing page", "User is NOT navigated to the landing page");
	}
	
	
	public void Validate_Required_Label_Text(String strTxtReqLabel, String strTxtActualLabel, String successMessage, String failureMessage) throws InterruptedException
	{
		try {
		if(strTxtReqLabel.contains(strTxtActualLabel))
			System.out.println(successMessage);
		else 
			System.out.println(failureMessage);
		}
		catch (Exception e) {
			System.out.println("NOT able to fetch the Text as '"+strTxtReqLabel+"'");
			System.out.println("Exception is: "+e.getMessage());
		}
		Thread.sleep(2000);
	}
	
	public void Navigate_To_Active_Study_Plan_Page() throws InterruptedException
	{
		boolean flag_active_study_plan = true;
		try {
		no_active_study_plan = objStudyPlan.noActiveStudyPlan.getText();
			if(no_active_study_plan.equals("There is no active plan"))
			{
				System.out.println("'No Active Plan'");
				flag_active_study_plan = false;
			}	
		}
		catch (Exception e) {}
		if(flag_active_study_plan==false)
		{
			CSP.Validate_create_study_plan();				
		}
		objStudyPlan.activeStudyPlan.click();
		Thread.sleep(4000);
	}
	
	public void Validate_Mylessons_Page_Header() throws InterruptedException, MalformedURLException, AWTException
	{
		lbl_testUnit = objStudyPlan.lbl_testUnit.getText(); 
		if(lbl_testUnit.equals("Test Unit"))
			System.out.println("User is navigated to the 'My Lessons' page");
		else 
			System.out.println("User is NOT able to navigate to the 'My Lessons' page");
	}

	public void Verify_Review_Plan_Button() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);			
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		review_button_name = objStudyPlan.btn_reviewPlan.getText();
		if(review_button_name.equals("Review Plan"))
			System.out.println("'Review Plan' button is present at the bottom of the page 'My Lessons'");
		else 
			System.out.println("'Review Plan' button is NOT present at the bottom of the page 'My Lessons'");
	}

		public void scroll(WebElement ele, RemoteWebDriver driver, int retryCount) {
		    boolean flag=true;
		    int count=1;
		    while(flag){
		        try {
		        	WebElement ele1 = ele;
		        	System.out.println("In Scroll Try");
		            flag=false;
		            break;
		        }
		        catch(Exception e) {
		        	System.out.println("In EXCEP: "+e.getMessage());
		            count=count+1;
		            Map<String, Object> params = new HashMap<>();
		            params.put("start","40%,90%");
		            params.put("end","40%,20%");
		            params.put("duration","2");
		            System.out.println("Before");
		            Object res= driver.executeScript("mobile:touch:swipe",params);
		        if(count==retryCount)
		        {
		            break;
		        }
		        }
		    }
		}

		public void Check_Visibility_Of_Element(WebElement ele, int maxTryCount) throws InterruptedException
		{
			System.out.println("IN Check_Visibility_Of_Element");
			int counter =0;
			while(counter < maxTryCount)
			{
				try
				{
					ele.isDisplayed();
				}
				catch (Exception e) {
					getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					counter++;
				}
			}
		}

		public RemoteWebDriver Get_Android_driver() throws MalformedURLException
		{
			String device = "Android"; 
			String devicename = "E1MGA3E822429306";
			String platformversion = "7";
			String platformname = "Android";
			

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("device", device);
			cap.setCapability("deviceName", devicename);
			cap.setCapability("platformName", platformname);
			cap.setCapability("platformVersion", platformversion);
			//cap.setCapability("browserName", "");
			cap.setCapability("appPackage", "com.tce.afs");
			cap.setCapability("appActivity", "com.tce.view.ui.activities.SplashScreenActivity");
			//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
			cap.setCapability("newCommandTimeout", "120");
		
			RemoteWebDriver driver1 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			return driver1;
		}

		public void Navigate_To_Books_Shelf_Page() throws InterruptedException
		{
			lbl_browse_books = objStudyPlan.lbl_browseBooks.getText();
				if(lbl_browse_books.equals("BROWSE BOOKS"))
					System.out.println("Label 'BROWSE BOOKS' is present on the Home Page");
				else
					System.out.println("Label 'BROWSE BOOKS' is NOT present on the Home Page");
			objStudyPlan.lbl_browseBooks.click();
			Thread.sleep(4000);
		}
		
		public void Verify_Books_Page() throws InterruptedException
		{
			Validate_Required_Label_Text("All Subjects", objStudyPlan.lbl_all_subjects.getText(), 
					"Label 'All Subjects' is present on 'Browse Books' page.", 
					"Label 'All Subjects' is NOT present on 'Browse Books' page.");
			Validate_Required_Label_Text("Mathematics - ClassEdge Imprints Math Grade 1", objStudyPlan.lbl_book_1.getText(), 
					"Label for Book/ Subject as 'Mathematics - ClassEdge Imprints Math Grade 1' is present on 'Browse Books' page.", 
					"Label for Book/ Subject as 'Mathematics - ClassEdge Imprints Math Grade 1' is NOT present on 'Browse Books' page.");
			Validate_Required_Label_Text("Environmental Science - ClassEdge Imprints EVS Grade 1", objStudyPlan.lbl_book_2.getText(), 
					"Label for Book/ Subject as 'Environmental Science - ClassEdge Imprints EVS Grade 1' is present on 'Browse Books' page.", 
					"Label for Book/ Subject as 'Environmental Science - ClassEdge Imprints EVS Grade 1' is NOT present on 'Browse Books' page.");
		}
		
		public void Verify_Bottom_Of_Books_Page() throws InterruptedException
		{
			Validate_Required_Label_Text("Your Syllabus", objStudyPlan.lbl_yourSyllabus.getText(), 
					"Label 'Your Syllabus' is present on 'Browse Books' page.", 
					"Label 'Your Syllabus' is NOT present on 'Browse Books' page.");
			Validate_Required_Label_Text(objStudyPlan.lbl_grade.getText(), "Grade", 
					"Label for 'Grade' is present on 'Browse Books' page.", 
					"Label for 'Grade' is NOT present on 'Browse Books' page.");
		/*	Validate_Required_Label_Text("Your Syllabus", objStudyPlan.lbl_schoolName.getText(), 
					"Label for 'School Name' is present on 'Browse Books' page.", 
					"Label for 'School Name' is NOT present on 'Browse Books' page.");
			Validate_Required_Label_Text("Your Syllabus", objStudyPlan.lbl_educationBoard.getText(), 
					"Label for 'Education Board' is present on 'Browse Books' page.", 
					"Label for 'Grade' is NOT present on 'Browse Books' page.");
		*/
		}

		public void Verify_Edit_Icon_On_Bottom_Of_Books_Page() throws InterruptedException
		{
			Validate_Required_Label_Text("true", ""+objStudyPlan.icon_edit.isEnabled(), 
					"'Edit Icon' is displayed and is enabled on 'Browse Books' page.", 
					"'Edit Icon' is NOT displayed and is enabled on 'Browse Books' page.");
		}
		
		public void Verify_Edit_Icon_Is_tappable_Books_Page() throws InterruptedException
		{
			Verify_Click(objStudyPlan.icon_edit, "User is able to click on 'Edit Icon'", "User is NOT able to click on 'Edit Icon'");
			/*
			 Validate_Required_Label_Text("true", ""+objStudyPlan.lbl_syllabusHeading.getText(), 
				"Label for 'Syllabus Heading' is present on 'Browse Books' page.", 
				"Label for 'Syllabus Heading' is NOT present on 'Browse Books' page.");
			*/
		}

		public void Verify_Navigation_After_Tapping_On_Edit_On_Books_Page() throws InterruptedException
		{
			 Validate_Required_Label_Text("", objStudyPlan.lbl_headerFeaturePage.getText(), 
				"Header is present on 'Feature' page.", "Header is NOT present on 'Feature' page.");
		}

		
		public void Verify_Click(WebElement ele, String successMessage, String failureMessage)
		{
			try {
				ele.click();
				System.out.println(successMessage);
			}
			catch (Exception e) {
				System.out.println(failureMessage);
				System.out.println("Exception is: "+e.getMessage());
			}
		}

		public void Verify_Tapping_On_Book() throws Exception
		{
			Navigate_To_Book(objStudyPlan.lbl_book_1);
			objStudyPlan.arrow_back_book.click();
			Navigate_To_Book(objStudyPlan.lbl_book_2);
			objStudyPlan.arrow_back_book.click();
		}
		
		public void Navigate_To_Book1() throws Exception
		{
			Thread.sleep(3000);
			Navigate_To_Book(objStudyPlan.lbl_book_1);
		}
		
		public void Verify_Tapping_And_Navigation_To_Chapter() throws Exception
		{
			Thread.sleep(3000);
			Verify_Various_Status_Of_Each_Chapter("Myself", objStudyPlan.lbl_mySelfChapter, 
					objStudyPlan.lbl_mySelfChapter_excludeFromSyllabus, objStudyPlan.lbl_mySelfChapter_completedInSchool);
			Verify_Various_Status_Of_Each_Chapter("My Body", objStudyPlan.lbl_myBodyChapter, 
					objStudyPlan.lbl_myBodyChapter_excludeFromSyllabus, objStudyPlan.lbl_myBodyChapter_completedInSchool);
			scrollDown_SecondTime(13);
			Verify_Various_Status_Of_Each_Chapter("My Family", objStudyPlan.lbl_myFamilyChapter, 
					objStudyPlan.lbl_myFamilyChapter_excludeFromSyllabus, objStudyPlan.lbl_myFamilyChapter_completedInSchool);
			
			Thread.sleep(2000);
			scrollDown_SecondTime(27);
			Verify_Various_Status_Of_Each_Chapter("Festivals and Celebrations", objStudyPlan.lbl_Chapter_2, 
					objStudyPlan.lbl_Chapter_2_excludeFromSyllabus, objStudyPlan.lbl_Chapter_2_completedInSchool);
			Verify_Various_Status_Of_Each_Chapter("Food We Eat", objStudyPlan.lbl_Chapter_3, 
					objStudyPlan.lbl_Chapter_3_excludeFromSyllabus, objStudyPlan.lbl_Chapter_3_completedInSchool);
		
			Thread.sleep(2000);
			scrollDown_SecondTime(24);
			Verify_Various_Status_Of_Each_Chapter("My House", objStudyPlan.lbl_Chapter_2, 
					objStudyPlan.lbl_Chapter_2_excludeFromSyllabus, objStudyPlan.lbl_Chapter_2_completedInSchool);
			Verify_Various_Status_Of_Each_Chapter("My Neighbourhood", objStudyPlan.lbl_Chapter_3, 
					objStudyPlan.lbl_Chapter_3_excludeFromSyllabus, objStudyPlan.lbl_Chapter_3_completedInSchool);
			/*
			System.out.println("AFter My Neighbourhood");
			scrollDown_SecondTime(25);
			Verify_Various_Status_Of_Each_Chapter("What People Do", objStudyPlan.lbl_Chapter_2, 
					objStudyPlan.lbl_Chapter_2_excludeFromSyllabus, objStudyPlan.lbl_Chapter_2_completedInSchool);
			Verify_Various_Status_Of_Each_Chapter("Plants Arround Us", objStudyPlan.lbl_Chapter_3, 
					objStudyPlan.lbl_Chapter_3_excludeFromSyllabus, objStudyPlan.lbl_Chapter_3_completedInSchool);
		
			scrollDown_SecondTime(34);
			Verify_Various_Status_Of_Each_Chapter("Animals Arround Us", objStudyPlan.lbl_Chapter_2, 
					objStudyPlan.lbl_Chapter_2_excludeFromSyllabus, objStudyPlan.lbl_Chapter_2_completedInSchool);
			Verify_Various_Status_Of_Each_Chapter("Air and Water", objStudyPlan.lbl_Chapter_3, 
					objStudyPlan.lbl_Chapter_3_excludeFromSyllabus, objStudyPlan.lbl_Chapter_3_completedInSchool);
			 */
		}
		
		public void Verify_Tapping_On_TP() throws InterruptedException
		{
			Validate_Required_Label_Text("ABOUT ME", objStudyPlan.lbl_mySelfChapter_TP_aboutMe.getText(), 
					"Label 'ABOUT ME' is present in chapter 'Myself' on Book's page.", "Label 'ABOUT ME' is NOT present in chapter 'Myself' on Book's page.");
			objStudyPlan.lbl_mySelfChapter_TP_aboutMe.click();
			Thread.sleep(1000);
			Validate_Required_Label_Text("Completed in School", objStudyPlan.lbl_mySelfChapter_TP_completedInSchool.getText(), 
					"Label 'Completed in School' is present in TP of chapter 'Myself' on Book's page.", 
					"Label 'Completed in School' is NOT present in TP of chapter 'Myself' on Book's page.");
			Verify_Click(objStudyPlan.lbl_mySelfChapter_TP_completedInSchool_switch, 
					"User is able to switch ON/ OFF the 'Completed in School' in TP 'ABOUT ME' for chapter 'Myself'",
					"User is NOT able to switch ON/ OFF the 'Completed in School' in TP 'ABOUT ME' for chapter 'Myself'");
		}
		
		
		public void Verify_Various_Status_Of_Each_Chapter(String chapterName, WebElement ele1, WebElement ele2, WebElement ele3) throws InterruptedException
		{
			Navigate_To_Chapter(ele1);
			Validate_Required_Label_Text(ele1.getText(), chapterName, 
					"Label '"+chapterName+"' is present on Book's page.", "Label '"+chapterName+"' is NOT present on Book's page.");
			Validate_Required_Label_Text("Exclude from Syllabus", ele2.getText(), 
					"Label 'Exclude from Syllabus' is present for chapter '"+chapterName+"'.", "Label 'Exclude from Syllabus' is NOT present for chapter '"+chapterName+"'.");
			Validate_Required_Label_Text("Completed in School", ele3.getText(), 
					"Label 'Completed in School' is present for chapter '"+chapterName+"'.", "Label 'Completed in School' is NOT present for chapter '"+chapterName+"'.");
			Navigate_To_Chapter(ele1);
		}

		public void Navigate_To_Book(WebElement ele_bookName) throws InterruptedException
		{
			ele_bookName.click();
			Thread.sleep(6000);
			Validate_Required_Label_Text("All Chapters", objStudyPlan.lbl_allChapters.getText(), 
			"Label 'All Chapters' is present on Book's page.", "Label 'All Chapters' is NOT present on Book's page.");
		}
		public void Navigate_To_Chapter(WebElement ele_ChapterName) throws InterruptedException
		{
			ele_ChapterName.click();
			Thread.sleep(2000);
		}
		
		public void scrollDown_SecondTime(int count) throws InterruptedException, AWTException
		{
			int counter=0;
			robot = new Robot();
			while(counter<count)
			{
				robot.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(500);
				counter++;
			}
		}
	
		public void moveBack(int count) throws InterruptedException, AWTException
		{
			Thread.sleep(3000);
			int counter=0;
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(500);
			while(counter<count)
			{
				robot.keyPress(KeyEvent.VK_BACK_QUOTE);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				counter++;
			}
		}
		public void Verify_Tapping_And_Navigation_To_Chapter_Myself() throws Exception
		{
			Thread.sleep(3000);
			Verify_Various_Status_Of_Each_Chapter("Myself", objStudyPlan.lbl_mySelfChapter, 
					objStudyPlan.lbl_mySelfChapter_excludeFromSyllabus, objStudyPlan.lbl_mySelfChapter_completedInSchool);
		}
	
		public void Verify_Tapping_And_Navigation_To_Chapter_MyBody(int chapterCount) throws Exception
		{
			Verify_Status_Of_Chapter("My Body", objStudyPlan.lbl_myBodyChapter, 
					objStudyPlan.lbl_myBodyChapter_excludeFromSyllabus, objStudyPlan.lbl_myBodyChapter_completedInSchool);
			List<WebElement> lst_chapterTopics=objStudyPlan.getChapterTopic_myBody_chaper(chapterCount);
			Navigate_To_Begin_Practice(lst_chapterTopics, "My Body");
		}
		
		public void Verify_Tapping_And_Navigation_To_Chapter_MyBody_Check_Notes(int chapterCount) throws Exception
		{
			String chapterName="My Body";
			Verify_Status_Of_Chapter(chapterName, objStudyPlan.lbl_myBodyChapter, 
					objStudyPlan.lbl_myBodyChapter_excludeFromSyllabus, objStudyPlan.lbl_myBodyChapter_completedInSchool);
			List<WebElement> lst_chapterTopics=objStudyPlan.getChapterTopic_myBody_chaper(chapterCount);
			lst_chapterTopics.get(0).click();
			scrollDown_SecondTime(16);
			Navigate_To_Notes_PopUP(chapterName);
		}

		public void Navigate_To_Notes_PopUP(String chapterName) throws Exception
		{
			String str_topicName_ui=objStudyPlan.lbl_notes_myBodyChapter.getText();
			objStudyPlan.lbl_notes_myBodyChapter.click();
			
			System.out.println("The Tile for Topic '"+str_topicName_ui+"' is expanded.");
			if(str_topicName_ui.equals("Notes"))
				System.out.println("The label '"+str_topicName_ui+"' is present in chapter '"+chapterName+"'.");
			else
				System.out.println("The label '"+str_topicName_ui+"' is NOT present in chapter '"+chapterName+"'.");
			String str_notesPopUpName=objStudyPlan.lbl_NOTES_notesPopUp.getText();
			if(str_notesPopUpName.equals("NOTES"))
				System.out.println("The label '"+str_notesPopUpName+"' is present in 'NOTES' popup for chapter '"+chapterName+"'.");
			else
				System.out.println("The label '"+str_notesPopUpName+"' is NOT present in 'NOTES' popup for chapter '"+chapterName+"'.");
			String xpath_closePopUp="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView";
			getDriver().findElement(By.xpath(xpath_closePopUp)).click();
			Thread.sleep(2000);
			System.out.println("The Tile for Topic '"+str_topicName_ui+"' is expanded.");
			String str_topicName_ui_2=objStudyPlan.lbl_notes_myBodyChapter.getText();
			
			if(str_topicName_ui_2.equals("Notes"))
				System.out.println("The label '"+str_topicName_ui_2+"' is present in chapter '"+chapterName+"'.");
			else
				System.out.println("The label '"+str_topicName_ui_2+"' is NOT present in chapter '"+chapterName+"'.");

		}
		
		public void Verify_Status_Of_Chapter(String chapterName, WebElement ele1, WebElement ele2, WebElement ele3) throws Exception
		{
			Thread.sleep(3000);
			Verify_Various_Status_Of_Each_Chapter(chapterName, ele1, ele2, ele3);
		}
		
		public void Navigate_To_Begin_Practice(List<WebElement> lst_ele, String chapterName) throws Exception
		{
			int counterEle=0;
			WebElement ele_lbl_confReport;
			for(int i=1;i<=lst_ele.size();i++)
			{
				lst_ele.get(counterEle).click();
				String xpath1= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView";
				String xpath2= xpath1 + "/android.view.ViewGroup["+i+"]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]";

				String xpath_conf="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView";
				String xpath_back="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView[2]";

				WebElement ele1=getDriver().findElement(By.xpath(xpath2));
				String str_topicName_ui=lst_ele.get(counterEle).getText();
				System.out.println("The Tile for Topic '"+str_topicName_ui+"' is expanded.");
				if(ele1.getText().equals("Begin Practice"))
				{
					System.out.println("The label 'Begin Practice' is present in topic '"+str_topicName_ui+"' for chapter '"+chapterName+"'.");
				}
				else
				{
					System.out.println("The label 'Begin Practice' is NOT present in topic '"+str_topicName_ui+"' for chapter '"+chapterName+"'.");
				}
				ele1.click();
				Thread.sleep(4000);
				ele_lbl_confReport=getDriver().findElement(By.xpath(xpath_conf));
				if(ele_lbl_confReport.getText().equals("Your Confidence Report"))
				{
					System.out.println("User is Navigated to 'Onboarding page of Practice Module'");
				}
				else
				{
					System.out.println("User is NOT Navigated to 'Onboarding page of Practice Module'");
				}
				getDriver().findElement(By.xpath(xpath_back)).click();;
				Thread.sleep(4000);
				break;
			}
			
			
		}
		
		
		public boolean Compare_Two_Lists(List<String> reqLst, List<String> actLst, String successMsg, String failureMsg)
		{
			boolean flag_isLstEqual=false;
			if(reqLst.equals(reqLst))
			{
				System.out.println(successMsg);
				flag_isLstEqual=true;
			}
			else
			{
				System.out.println(failureMsg);
			}
			return flag_isLstEqual;
		}
		public List<String> getChapterTopics()
		{
			List<String> lst_topics= new ArrayList<>();
			lst_topics.add("Parts of the Body");
			lst_topics.add("Sense Organs");
			lst_topics.add("Keeping Healthy");
			lst_topics.add("Same and Different");
			return lst_topics;
		}
		
		
		public void Navigate_To_TP_AboutMe_And_Verify_Presence_Of_Toggle_Switch_Options() throws Exception
		{
			Validate_Required_Label_Text("ABOUT ME", objStudyPlan.lbl_mySelfChapter_TP_aboutMe.getText(), 
					"Label 'ABOUT ME' is present in chapter 'Myself' on Book's page.", "Label 'ABOUT ME' is NOT present in chapter 'Myself' on Book's page.");
			objStudyPlan.lbl_mySelfChapter_TP_aboutMe.click();
			Thread.sleep(5000);
			Perform_Click_Operation(objStudyPlan.lbl_mySelfChapter_TP_aboutMe_excludeFromSyllabus,
					"Able to click on Toggle Switch for 'Exclude from Syllabus' for TP 'ABOUT ME' in chapter 'Myself' on Book's page.",
					"NOT Able to click on Toggle Switch for 'Exclude from Syllabus' for TP 'ABOUT ME' in chapter 'Myself' on Book's page.", 8000);
			Validate_Required_Label_Text("Exclude from Syllabus", objStudyPlan.lbl_mySelfChapter_TP_aboutMe_excludeFromSyllabus.getText(), 
					"Label 'Exclude from Syllabus' is present in TP 'ABOUT ME' of chapter 'Myself' on Book's page.", 
					"Label 'Exclude from Syllabus' is NOT present in TP 'ABOUT ME' of chapter 'Myself' on Book's page.");
			Perform_Click_Operation(objStudyPlan.switch_mySelfChapter_TP_aboutMe_compltedInSchool,
					"Able to click on Toggle Switch for 'Completed in School' for TP 'ABOUT ME' in chapter 'Myself' on Book's page.",
					"NOT Able to click on Toggle Switch for 'Exclude from Syllabus' for TP 'ABOUT ME' in chapter 'Myself' on Book's page.", 8000);
			Validate_Required_Label_Text("Completed in School", objStudyPlan.switch_mySelfChapter_TP_aboutMe_compltedInSchool.getText(), 
					"Label 'Completed in School' is present in TP 'ABOUT ME' of chapter 'Myself' on Book's page.", 
					"Label 'Completed in School' is NOT present in TP 'ABOUT ME' of chapter 'Myself' on Book's page.");
		}
		
		public void Perform_Click_Operation(WebElement ele1, String strSuccessMsg, String strFailureMsg, int sleepMillis)
		{
			try {
				ele1.click();
				Thread.sleep(sleepMillis);
				System.out.println(strSuccessMsg);
			}
			catch (Exception e) {
				System.out.println("NOT able to perform click. Exception is: \n"+e.getMessage());
				System.out.println(strFailureMsg);
			}
		}

		public void Verify_Confidence_Present_Against_TP() throws Exception
		{
			Validate_Required_Label_Text("ABOUT ME", objStudyPlan.lbl_mySelfChapter_TP_aboutMe.getText(), 
					"Label 'ABOUT ME' is present in chapter 'Myself' on Book's page.", "Label 'ABOUT ME' is NOT present in chapter 'Myself' on Book's page.");
			Thread.sleep(5000);
			Verify_Presence_Of_Confidence_Score_Iage(objStudyPlan.img_mySelfChapter_TP_aboutMe_confidanceScore, 
					"Confidance Score for 'ABOUT ME' is present for present.", 
					"Confidance Score for 'ABOUT ME' is NOT present for present.");
		}
		
		public void Verify_Presence_Of_Confidence_Score_Iage(WebElement ele1, String strSuccessMsg, String strFailureMsg)
		{
			try {
				ele1.isEnabled();
				System.out.println(strSuccessMsg);
			}
			catch (Exception e) {
				System.out.println("NOT able to find 'Confidance Score'. Exception is: \n"+e.getMessage());
				System.out.println(strFailureMsg);
			}
		}

		public void Verify_Highlight_Pop_Up() throws Exception
		{
			objStudyPlan.btn_highlight.click();
			Thread.sleep(5000);
			List<String> lst_actualHighLights= new ArrayList<>();
			lst_actualHighLights.add(objStudyPlan.lbl_NotAccessed.getText());
			lst_actualHighLights.add(objStudyPlan.lbl_CompletedinSchool.getText());
			lst_actualHighLights.add(objStudyPlan.lbl_LowConfidence.getText());
			lst_actualHighLights.add(objStudyPlan.lbl_MediumConfidence.getText());
			lst_actualHighLights.add(objStudyPlan.lbl_HighConfidence.getText());
			Compare_Two_Lists(reqHighlights(), lst_actualHighLights, 
					"In the pop up 'Highlight', the study statuses are present", 
					"In the pop up 'Highlight', the study statuses are NOT present");
			
			Validate_Presense_Of_Statuses_And_CheckBox_In_Highlights_PopUp();
			objStudyPlan.chkBox_NotAccessed.click();
			Thread.sleep(2000);
			objStudyPlan.btn_apply.click();
			Thread.sleep(5000);
			Verify_Tapping_And_Navigation_To_Chapter_Myself();
		}
		public void Validate_Presense_Of_Statuses_And_CheckBox_In_Highlights_PopUp() 
		{
			objStudyPlan.chkBox_NotAccessed.isEnabled();
			objStudyPlan.chkBox_CompletedinSchool.isEnabled();
			objStudyPlan.chkBox_LowConfidence.isEnabled();
			objStudyPlan.chkBox_MediumConfidence.isEnabled();
			objStudyPlan.chkBox_HighConfidence.isEnabled();	
			objStudyPlan.chkBox_NotAccessed.click();
			objStudyPlan.chkBox_NotAccessed.click();
			objStudyPlan.chkBox_CompletedinSchool.click();
			objStudyPlan.chkBox_CompletedinSchool.click();
			objStudyPlan.chkBox_LowConfidence.click();
			objStudyPlan.chkBox_LowConfidence.click();
			objStudyPlan.chkBox_MediumConfidence.click();
			objStudyPlan.chkBox_MediumConfidence.click();
			objStudyPlan.chkBox_HighConfidence.click();
			objStudyPlan.chkBox_HighConfidence.click();
		}
		public List<String> reqHighlights()
		{
			List<String> lst_topics= new ArrayList<>();
			lst_topics.add("Not Accessed");
			lst_topics.add("Completed in School");
			lst_topics.add("Low Confidence");
			lst_topics.add("Medium Confidence");
			lst_topics.add("High Confidence");
			return lst_topics;
		}

		public void Navigate_To_First_Book_Political_Science() throws Exception
		{
			Validate_Home_Page_Header();
			Navigate_To_Books_Shelf_Page();
			Navigate_To_Book1();
		}

		public void Navigate_To_First_Chapter_Political_Science_Quize_Page()throws Exception
		{
			Thread.sleep(3000);
			Validate_Required_Label_Text("Aspects and Influence of Diversity", objStudyPlan.lbl_PoliticalScience_Chapter1.getText(), 
					"Chapter 'Aspects and Influence of Diversity' label is present on 'Political Science' book's page", 
					"Chapter 'Aspects and Influence of Diversity' label is NOT present on 'Political Science' book's page");
			objStudyPlan.lbl_PoliticalScience_Chapter1.click();
			Thread.sleep(2000);
			Validate_Required_Label_Text("Begin Revision", objStudyPlan.lbl_PoliticalScience_Chapter1_beginRevision.getText(), 
					"Label 'Begin Revision' is present under chapter label 'Aspects and Influence of Diversity' on 'Political Science' book's page", 
					"Label 'Begin Revision' is NOT present under chapter label 'Aspects and Influence of Diversity' on 'Political Science' book's page");
			objStudyPlan.lbl_PoliticalScience_Chapter1_beginRevision.click();
			Thread.sleep(3000);
			Validate_Required_Label_Text("WHAT YOU WILL REVISE", objStudyPlan.lbl_PoliticalScience_Chapter1_whatWillYouRevise.getText(), 
					"Label 'WHAT YOU WILL REVISE' is present on Revise page", "Label 'WHAT YOU WILL REVISE' is NOT present on Revise page");
			Validate_Required_Label_Text("Begin Revision", objStudyPlan.btn_PoliticalScience_Chapter1_RevisionPg_BeginRevise.getText(), 
					"Button 'Begin Revision' is present on Revise page", "Button 'Begin Revision' is NOT present on Revise page");
			objStudyPlan.btn_PoliticalScience_Chapter1_RevisionPg_BeginRevise.click();
			Thread.sleep(3000);
			Validate_Required_Label_Text("Overview", objStudyPlan.lbl_PoliticalScience_Chapter1_OverviewPg_Overview.getText(), 
					"Label 'Overview' is present on Overview page", "Label 'Overview' is NOT present on Overview page");
			objStudyPlan.img_OverviewPg_screen.click();
			String totalVedioTime=objStudyPlan.img_OverviewPg_screen_time.getText();
			int totalWaitingMins=Integer.parseInt(totalVedioTime.split(":")[0]);
			int totalWaitingSecs=Integer.parseInt(totalVedioTime.split(":")[1]);
			int minSecs=(totalWaitingMins)*60;
			int totalWait=(minSecs+totalWaitingSecs+5)*1000;
			System.out.println("Waiting for Video to complete. Waiting for '"+(totalWait)/1000+"' seconds");
			int wait=0; 
			try {
			while(wait<totalWait)
			{
				Thread.sleep(5000);
				objStudyPlan.img_OverviewPg_screen.click();
				wait=wait+5000;
			}
			}
			catch (Exception e) {}
			System.out.println("Waited till '"+(totalWait)/1000+"' seconds");
		}
		public void Validate_Quize_Page() throws Exception
		{
			Validate_Required_Label_Text("What are the aspects of diversity?", objStudyPlan.btn_quize_pg_header.getText(), 
					"Header 'What are the aspects of diversity?' is present on Quize page", 
					"Header 'What are the aspects of diversity?' is NOT present on Quize page");
			Validate_Required_Label_Text("WHAT DO YOU THINK?", objStudyPlan.lbl_qaizepg_whatDoYouThink.getText(), 
					"Label 'WHAT DO YOU THINK?' is present on Quize page", 
					"Label 'WHAT DO YOU THINK?' is NOT present on Quize page");
			Validate_Required_Label_Text("CONTINUE", objStudyPlan.btn_quize_pg_continue.getText(), 
					"Button 'CONTINUE' is present on Quize page", 
					"Button 'CONTINUE' is NOT present on Quize page");
		}
		
		public void Validate_Quize_Page_Questions_Format() throws Exception
		{
			Validate_Quize_Page_Single_Select_Question();
			objStudyPlan.btn_quize_pg_continue.click();
			Thread.sleep(3000);
			Validate_Quize_Page_Multi_Select_Question();
			objStudyPlan.btn_quize_pg_continue.click();
			Thread.sleep(3000);
			Validate_Quize_Page_Single_Select_Question_Radio_Btn();
		}
		
		public boolean Validate_Quize_Page_Single_Select_Question_Radio_Btn()throws Exception
		{
			boolean flag_radioSelect=false, flag_radio1=false,flag_radio2=false;
			String parentXpath_Text="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]";
			String xpathOpt1=parentXpath_Text+"/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View",
				xpathOpt2=parentXpath_Text+"/android.view.View[3]/android.view.View/android.view.View[2]/android.view.View",
				xpathOpt3=parentXpath_Text+"/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View";
			try {
				System.out.println("Select options are:");
				System.out.println(getDriver().findElement(By.xpath(xpathOpt1)).getText());
				System.out.println(getDriver().findElement(By.xpath(xpathOpt2)).getText());
				System.out.println(getDriver().findElement(By.xpath(xpathOpt3)).getText());
			}
			catch (Exception e) {
				System.out.println("NOT able to fetch the Single Select (Radio Button) options.");
				System.out.println("Exception is: "+e.getMessage());
			}
			
			String parentXpath_radio="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]";
			String radioXpath1="";
			System.out.println("Question is: "+objStudyPlan.lbl_quize_pg_q1.getText());
			try {
				radioXpath1 = parentXpath_radio+"/android.view.View[2]/android.view.View/android.view.View[3]";
				
				getDriver().findElement(By.xpath(radioXpath1)).click();
				flag_radio1=true;
				Thread.sleep(1000);
				System.out.println("This question is of Type Single Select (Radio Button).");
				if(flag_radio1)
				{
					System.out.println("User is able to select Radio Button");
				}
				else
				{
					System.out.println("User is NOT able to select Radio Button");
				}
				flag_radioSelect=true;
			}
			catch (Exception e) {
				System.out.println("Got the Exception while performaing operation in Single Select (Redio Button) Question: "+e.getMessage());
			}
		return flag_radioSelect;
		}
			
		public boolean Validate_Quize_Page_Multi_Select_Question()throws Exception
		{
			boolean flag_multiSelect=false, flag_chk1=false, flag_chk2=false;
			String parentXpath_Text="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]";
			String xpathOpt1=parentXpath_Text+"/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View",
				xpathOpt2=parentXpath_Text+"/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View",
				xpathOpt3=parentXpath_Text+"/android.view.View[3]/android.view.View/android.view.View[2]/android.view.View",
				xpathOpt4=parentXpath_Text+"/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View";
			
			try {
				System.out.println("Select options are:");
				System.out.println(getDriver().findElement(By.xpath(xpathOpt1)).getText());
				System.out.println(getDriver().findElement(By.xpath(xpathOpt2)).getText());
				System.out.println(getDriver().findElement(By.xpath(xpathOpt3)).getText());
				System.out.println(getDriver().findElement(By.xpath(xpathOpt4)).getText());
			}
			catch (Exception e) {
				System.out.println("NOT able to fetch the Single Select (Radio Button) options.");
				System.out.println("Exception is: "+e.getMessage());
			}
			
			String parentXpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]";
			String chktXpath1="", chktXpath2="", chkXpath_aterChk1="";
			System.out.println("Question is: "+objStudyPlan.lbl_quize_pg_q1.getText());
			try {
				chktXpath1 = parentXpath+"/android.view.View[2]/android.view.View[1]/android.widget.CheckBox";
				chktXpath2 = parentXpath+"/android.view.View/android.view.View[2]/android.widget.CheckBox";
				
				getDriver().findElement(By.xpath(chktXpath1)).click();
				flag_chk1=true;
				Thread.sleep(1000);
				getDriver().findElement(By.xpath(chktXpath2)).click();
				flag_chk2=true;
				Thread.sleep(1000);
				System.out.println("This question is of Type Multiple Select.");
				if(flag_chk1 & flag_chk2)
				{
					System.out.println("User is able to select Multiple Check Boxes");
				}
				else
				{
					System.out.println("User is NOT able to select Multiple Check Boxes");
				}
				flag_multiSelect=true;
			}
			catch (Exception e) {
				System.out.println("Got the Exception while performaing operation in Multi Select Question: "+e.getMessage());
			}
		return flag_multiSelect;
		}
		
		public boolean Validate_Quize_Page_Single_Select_Question() throws Exception
		{
			boolean flag_singleSelect=false;
			String parentXpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]";
			String singleSelectXpath1="", singleSelectXpath2="", singleSelectXpath3="";
			System.out.println("Question is: "+objStudyPlan.lbl_quize_pg_q1.getText());
			objStudyPlan.btn_quize_pg_q1_checkAns.click();
			Thread.sleep(2000);
			try {
				singleSelectXpath1 = parentXpath+"/android.view.View[3]/android.widget.Button";
				singleSelectXpath2 = parentXpath+"/android.view.View[4]/android.widget.Button";
				singleSelectXpath3 = parentXpath+"/android.view.View[5]/android.widget.Button";
				WebElement btn1 = getDriver().findElement(By.xpath(singleSelectXpath1));
				btn1.click();
				Thread.sleep(1000);
				System.out.println("User is able to click on Button '"+btn1.getText()+"'");
				WebElement btn2 = getDriver().findElement(By.xpath(singleSelectXpath2));
				btn2.click();
				Thread.sleep(1000);
				System.out.println("User is able to click on Button '"+btn2.getText()+"'");
				WebElement btn3 = getDriver().findElement(By.xpath(singleSelectXpath3));
				btn3.click();
				Thread.sleep(1000);
				System.out.println("User is able to click on Button '"+btn3.getText()+"'");
				flag_singleSelect=true;
			}
			catch (Exception e) {
				System.out.println("Got the Exception while performaing operation in Single Select Question: "+e.getMessage());
			}
		return flag_singleSelect;
		}
		
		public void Validate_Quize_Page_Questions_Format_InstantFeedback() throws Exception
		{
			Validate_Quize_Page_Questions_Format_InstantFeedback_Single_Select();
			objStudyPlan.btn_quize_pg_continue.click();
			Thread.sleep(3000);
			Validate_Quize_Page_Questions_Format_InstantFeedback_Multi_Select();
			objStudyPlan.btn_quize_pg_continue.click();
			Thread.sleep(3000);
			Validate_Quize_Page_Questions_Format_InstantFeedback_Single_Select_Radio_Button();
		}

		public void Validate_Quize_Page_Questions_Format_InstantFeedback_Single_Select() throws Exception
		{
			Validate_Quize_Page_Single_Select_Question();
			String strQuestion=objStudyPlan.lbl_quize_pg_q1.getText();
			System.out.println("Question is: "+strQuestion);
			WebElement ele1=null;
			try {
			ele1 = objStudyPlan.btn_selected_Text_singleSelect;
			System.out.println("The Instant Feedback is given for selected option '"+ele1.getText()+"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("NOT able to fetch the Instant Feedback for selected option for question '"+strQuestion+"'.");
			}
			Thread.sleep(1000);
		}

		public void Validate_Quize_Page_Questions_Format_InstantFeedback_Multi_Select() throws Exception
		{
			Validate_Quize_Page_Multi_Select_Question();
			String strQuestion=objStudyPlan.lbl_quize_pg_q1.getText();
			System.out.println("Question is: "+strQuestion);
			String eleXpath1="//android.view.View[3]/android.view.View/android.view.View[1]/android.widget.CheckBox[@checked='true']";
			String eleXpath2="//android.view.View[3]/android.view.View/android.view.View[2]/android.widget.CheckBox[@checked='true']";
			
			try {
				getDriver().findElement(By.xpath(eleXpath1));
				getDriver().findElement(By.xpath(eleXpath2));
				String strop1=objStudyPlan.chk_selected_Text_multiSelect1.getText();
				String strop2=objStudyPlan.chk_selected_Text_multiSelect2.getText();
				
			System.out.println("The Instant Feedback is given for selected option '"+strop1+"' for question '"+strQuestion+"'.");
			System.out.println("The Instant Feedback is given for selected option '"+strop2+"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("NOT able to fetch the Instant Feedback for selected option for question '"+strQuestion+"'.");
			}
			Thread.sleep(1000);
		}
		
		public void Validate_Quize_Page_Questions_Format_InstantFeedback_Single_Select_Radio_Button() throws Exception
		{
			Validate_Quize_Page_Single_Select_Question_Radio_Btn();
			String strQuestion=objStudyPlan.lbl_quize_pg_q1.getText();
			System.out.println("Question is: "+strQuestion);
			String eleXpath1="//android.view.View/android.widget.CheckBox[@checked='true']";
			
			try {
				getDriver().findElement(By.xpath(eleXpath1));
				String strop1=objStudyPlan.radio_selected_Text_singleSelect.getText();
				System.out.println("The Instant Feedback is given for selected option '"+strop1+"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("NOT able to fetch the Instant Feedback for selected option for question '"+strQuestion+"'.");
			}
			Thread.sleep(1000);
		}
		
		
		public void Validate_Quize_Page_Questions_By_Default_Selected_Answer() throws Exception
		{
			Validate_Quize_Page_Questions_By_Default_Selected_Answer_Single_Select();
			objStudyPlan.btn_quize_pg_continue.click();
			Thread.sleep(3000);
			Validate_Quize_Page_Questions_By_Default_Selected_Answer_Multi_Select();
			objStudyPlan.btn_quize_pg_continue.click();
			Thread.sleep(3000);
			Validate_Quize_Page_Questions_By_Default_Selected_Answer_Single_Select_Radio_Button();
		}
		
		
		public void Validate_Quize_Page_Questions_By_Default_Selected_Answer_Single_Select() throws Exception
		{
			String parentXpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]";
			String singleSelectXpath1="", singleSelectXpath2="", singleSelectXpath3="";
			String strQuestion = objStudyPlan.lbl_quize_pg_q1.getText();
			System.out.println("Question is: "+strQuestion);
			objStudyPlan.btn_quize_pg_q1_checkAns.click();
			Thread.sleep(2000);
			try {
				singleSelectXpath1 = parentXpath+"/android.view.View[3]/android.widget.Button";
				singleSelectXpath2 = parentXpath+"/android.view.View[4]/android.widget.Button";
				singleSelectXpath3 = parentXpath+"/android.view.View[5]/android.widget.Button";
				System.out.println("Options are: ");
				System.out.println(getDriver().findElement(By.xpath(singleSelectXpath1)).getText());
				System.out.println(getDriver().findElement(By.xpath(singleSelectXpath2)).getText());
				System.out.println(getDriver().findElement(By.xpath(singleSelectXpath3)).getText());
			}
			catch (Exception e) {
				System.out.println("NOT able to fetch the Options label (present on Buttons). Exception is: "+e.getMessage());
			}
			WebElement ele1=null;
			try {
			ele1 = objStudyPlan.btn_selected_Text_singleSelect;
			System.out.println("By Default the option/ answer is selected as '"+ele1.getText()+"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("By Default the option/ answer is NOT selected for question '"+strQuestion+"'.");
			}
			Thread.sleep(1000);
		}
		
		public void Validate_Quize_Page_Questions_By_Default_Selected_Answer_Multi_Select() throws Exception
		{
			String strQuestion = objStudyPlan.lbl_quize_pg_q1.getText();
			System.out.println("Question is: "+strQuestion);
			String parentXpath_Text="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]";
			String xpathOpt1=parentXpath_Text+"/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View",
				xpathOpt2=parentXpath_Text+"/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View",
				xpathOpt3=parentXpath_Text+"/android.view.View[3]/android.view.View/android.view.View[2]/android.view.View",
				xpathOpt4=parentXpath_Text+"/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View";
			try {
				System.out.println("Multi Select (Using Check Box) options are:");
				System.out.println(getDriver().findElement(By.xpath(xpathOpt1)).getText());
				System.out.println(getDriver().findElement(By.xpath(xpathOpt2)).getText());
				System.out.println(getDriver().findElement(By.xpath(xpathOpt3)).getText());
				System.out.println(getDriver().findElement(By.xpath(xpathOpt4)).getText());
			}
			catch (Exception e) {
				System.out.println("NOT able to fetch the Multi Select (Check Boxes) options.");
				System.out.println("Exception is: "+e.getMessage());
			}
			String eleXpath1="//android.view.View[3]/android.view.View/android.view.View[1]/android.widget.CheckBox[@checked='true']",
					eleXpath2="//android.view.View[3]/android.view.View/android.view.View[2]/android.widget.CheckBox[@checked='true']",
					eleXpath3="//android.view.View[3]/android.view.View/android.view.View[3]/android.widget.CheckBox[@checked='true']",
					eleXpath4="//android.view.View[3]/android.view.View/android.view.View[4]/android.widget.CheckBox[@checked='true']";
			try {
				getDriver().findElement(By.xpath(eleXpath1));
				System.out.println("By Default the option/ answer is selected as '"+objStudyPlan.chk_selected_Text_multiSelect1.getText()+
						"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("By Default the option/ answer is NOT selected for question '"+strQuestion+"'.");
			}
			try {
				getDriver().findElement(By.xpath(eleXpath2));
				System.out.println("By Default the option/ answer is selected as '"+objStudyPlan.chk_selected_Text_multiSelect2.getText()+
						"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("By Default the option/ answer is NOT selected for question '"+strQuestion+"'.");
			}
			try {
				getDriver().findElement(By.xpath(eleXpath3));
				System.out.println("By Default the option/ answer is selected as '"+objStudyPlan.chk_selected_Text_multiSelect3.getText()+
						"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("By Default the option/ answer is NOT selected for question '"+strQuestion+"'.");
			}
			try {
				getDriver().findElement(By.xpath(eleXpath4));
				System.out.println("By Default the option/ answer is selected as '"+objStudyPlan.chk_selected_Text_multiSelect4.getText()+
						"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("By Default the option/ answer is NOT selected for question '"+strQuestion+"'.");
			}
			Thread.sleep(1000);
		}
		
		public void Validate_Quize_Page_Questions_By_Default_Selected_Answer_Single_Select_Radio_Button() throws Exception
		{
			String strQuestion = objStudyPlan.lbl_quize_pg_q1.getText();
			System.out.println("Question is: "+strQuestion);
			String parentXpath_Text="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]";
			String xpathOpt1=parentXpath_Text+"/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View",
				xpathOpt2=parentXpath_Text+"/android.view.View[3]/android.view.View/android.view.View[2]/android.view.View",
				xpathOpt3=parentXpath_Text+"/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View";
			try {
				System.out.println("Select options are:");
				System.out.println(getDriver().findElement(By.xpath(xpathOpt1)).getText());
				System.out.println(getDriver().findElement(By.xpath(xpathOpt2)).getText());
				System.out.println(getDriver().findElement(By.xpath(xpathOpt3)).getText());
			}
			catch (Exception e) {
				System.out.println("NOT able to fetch the Single Select (Radio Button) options.");
				System.out.println("Exception is: "+e.getMessage());
			}
			String eleXpath1="//android.view.View/android.view.View[3]/android.view.View[1]/android.widget.CheckBox[@checked='true']",
					eleXpath2="//android.view.View/android.view.View[3]/android.view.View[2]/android.widget.CheckBox[@checked='true']",
					eleXpath3="//android.view.View/android.view.View[3]/android.view.View[3]/android.widget.CheckBox[@checked='true']";
			try {
				getDriver().findElement(By.xpath(eleXpath1));
				System.out.println("By Default the option/ answer is selected as '"+objStudyPlan.radio_selected_Text_singleSelect_1.getText()+
						"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("By Default the option/ answer is NOT selected for question '"+strQuestion+"'.");
			}
			try {
				getDriver().findElement(By.xpath(eleXpath2));
				System.out.println("By Default the option/ answer is selected as '"+objStudyPlan.radio_selected_Text_singleSelect_2.getText()+
						"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("By Default the option/ answer is NOT selected for question '"+strQuestion+"'.");
			}
			try {
				getDriver().findElement(By.xpath(eleXpath3));
				System.out.println("By Default the option/ answer is selected as '"+objStudyPlan.radio_selected_Text_singleSelect_3.getText()+
						"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("By Default the option/ answer is NOT selected for question '"+strQuestion+"'.");
			}
			Thread.sleep(1000);
		}
		
		public void Validate_Quize_Page_Questions_Are_Not_Mandatory_To_Answer() throws Exception
		{
			Validate_Quize_Page_Questions_By_Default_Selected_Answer_Single_Select();
			System.out.println("Performing click on button 'CONTINUE' for proceeding to next question.");
			objStudyPlan.btn_quize_pg_continue.click();
			Thread.sleep(3000);
			System.out.println("User is able to move to NEXT question without answering current question");
			Validate_Quize_Page_Questions_By_Default_Selected_Answer_Multi_Select();
			System.out.println("Performing click on button 'CONTINUE' for proceeding to next question.");
			objStudyPlan.btn_quize_pg_continue.click();
			Thread.sleep(3000);
			System.out.println("User is able to move to NEXT question without answering current question");
			Validate_Quize_Page_Questions_By_Default_Selected_Answer_Single_Select_Radio_Button();
		}

		public void Navigate_To_First_Chapter_Political_Science_Practice_Module_Page()throws Exception
		{
			Thread.sleep(3000);
			Validate_Required_Label_Text("Aspects and Influence of Diversity", objStudyPlan.lbl_PoliticalScience_Chapter1.getText(), 
					"Chapter 'Aspects and Influence of Diversity' label is present on 'Political Science' book's page", 
					"Chapter 'Aspects and Influence of Diversity' label is NOT present on 'Political Science' book's page");
			objStudyPlan.lbl_PoliticalScience_Chapter1.click();
			Thread.sleep(2000);
			Validate_Required_Label_Text("Begin Practice", objStudyPlan.lbl_PoliticalScience_Chapter1_beginPractice.getText(), 
					"Label 'Begin Practice' is present under chapter label 'Aspects and Influence of Diversity' on 'Political Science' book's page", 
					"Label 'Begin Practice' is NOT present under chapter label 'Aspects and Influence of Diversity' on 'Political Science' book's page");
			objStudyPlan.lbl_PoliticalScience_Chapter1_beginPractice.click();
			Thread.sleep(3000);
			Validate_Required_Label_Text("Your Confidence Report", objStudyPlan.lbl_PoliticalScience_Chapter1_yourConfidenceReport.getText(), 
					"Label 'Your Confidence Report' is present on Practice page", "Label 'Your Confidence Report' is NOT present on Practice page");
			Validate_Required_Label_Text("Begin Practice", objStudyPlan.btn_PoliticalScience_Chapter1_PracticePg_BeginPractice.getText(), 
					"Button 'Begin Practice' is present on Practice page", "Button 'Begin Practice' is NOT present on Practice page");
			Validate_Required_Label_Text("Not right now", objStudyPlan.btn_PoliticalScience_Chapter1_RevisionPg_NotRightNow.getText(), 
					"Label 'Not right now' is present on Practice page", "Label 'Not right now' is NOT present on Practice page");
			Navigate_To_Quize_page();
		}
		
		public void Navigate_To_Quize_page()throws Exception
		{
			int counter=0;
			while(counter<5)
			{
				try {
					counter++;
					objStudyPlan.btn_PoliticalScience_Chapter1_PracticePg_BeginPractice.click();
					Thread.sleep(5000);
					objStudyPlan.lbl_Practice_Quize_QNos.getText();
					System.out.println("User is navigated to 'Practice Quize' page");
					break;
				} catch (Exception e) {
					System.out.println("User is NOT navigated to 'Practice Quize' page");
				}
			}
		}
		
		public void Validate_Quize_Questions() throws Exception
		{
			String questionsCount= objStudyPlan.lbl_Practice_Quize_QNos.getText().split(" ")[2];
			int length= Integer.parseInt(questionsCount);
			String question="";
			int counter=1;
			boolean flagOpt1=false, flagOpt2=false, multipleOptionSelectQuestion=false;
			for(int i=0;i<length;i++)
			{
				question=objStudyPlan.lbl_Practice_Quize_Question.getText();
				System.out.println("Current question number is '"+counter+"' and question is: "+question);
				Validate_Quize_Question_Select_Instruction();
				System.out.println("Scrolling the Mobile Screen");
				scrollDown_SecondTime(15);
				Thread.sleep(2000);
				Validate_Quize_Question_Get_Options(question);
				Validate_Quize_Question_Click_Option(objStudyPlan.lbl_Practice_Quize_Q_opt1,
						"User is able to select First Option",
						"User is NOT able to select First Option");
				Validate_Quize_Question_Click_Option(objStudyPlan.lbl_Practice_Quize_Q_opt2,
						"User is able to select Second Option",
						"User is NOT able to select Second Option");
				flagOpt1 = Validate_Quize_Question_Selected_Option(objStudyPlan.lbl_Practice_Quize_Q_opt1.getText(), 0, 
						"Option 1 is in selected Mode", "Option 1 is NOT in selected Mode");
				flagOpt2 = Validate_Quize_Question_Selected_Option(objStudyPlan.lbl_Practice_Quize_Q_opt2.getText(), 1, 
						"Option 2 is in selected Mode", "Option 2 is NOT in selected Mode");
				if(flagOpt1 & flagOpt2)
				{
					multipleOptionSelectQuestion=true;
					break;
				}
				else
				{
					objStudyPlan.lbl_Practice_Qauize_IwillAttemptLater.click();
					Thread.sleep(2000);
				}
				counter++;
			}
			if(multipleOptionSelectQuestion)
			{
				System.out.println("'Multiple Option Select' question is present in 'Practice Quize'.");
				System.out.println("'Multiple Option Select' question was present in 'Practice Quize' at number '"+counter+"'.");
			}
			else
			{
				System.out.println("'Multiple Option Select' question is NOT present in 'Practice Quize'.");
			}
		}
		
		public boolean Validate_Quize_Question_Selected_Option(String optLabel, int id, String successMsg, String failureMsg)
		{
			boolean flag=false;
			String xpath="//android.widget.CheckBox[@resource-id='"+id+"' and @checked='true']";
			try {
				getDriver().findElement(By.xpath(xpath));
				System.out.println("The option/ answer is selected as '"+optLabel+"'.");
				flag=true;
			}
			catch (Exception e) {
				System.out.println("Option/ answer is NOT selected as '"+optLabel+"'.");
			}
			return flag;
		}
		
		
		public boolean Validate_Quize_Question_Click_Option(WebElement ele, String successMsg, String failureMsg)
		{
			boolean flag=false;
			try {
			ele.click();
			System.out.println(successMsg);
			flag=true;
			}
			catch (Exception e) {
				System.out.println(failureMsg);
			}
			return flag;
		}
		
		public void Validate_Quize_Question_Get_Options(String strQuestion)
		{
			int counter=0;
			System.out.println("Avalable answer/ options are: ");
			try {
				System.out.println("First Option: "+objStudyPlan.lbl_Practice_Quize_Q_opt1.getText());
				counter++;
			} catch (Exception e) {
				System.out.println("NOT able to fetch the 'First Option' label/ 'First Option' label is NOT present");
			}
			try {
				System.out.println("Second Option: "+objStudyPlan.lbl_Practice_Quize_Q_opt2.getText());
				counter++;
			} catch (Exception e) {
				System.out.println("NOT able to fetch the 'Second Option' label/ 'Second Option' label is NOT present");
			}
			try {
				System.out.println("Third Option: "+objStudyPlan.lbl_Practice_Quize_Q_opt3.getText());
				counter++;
			} catch (Exception e) {
				System.out.println("NOT able to fetch the 'Third Option' label/ 'Third Option' label is NOT present");
			}
			try {
				System.out.println("Fourth Option: "+objStudyPlan.lbl_Practice_Quize_Q_opt4.getText());
				counter++;
			} catch (Exception e) {
				System.out.println("NOT able to fetch the 'Fourth Option' label/ 'Fourth Option' label is NOT present");
			}
			if(counter>1)
			{
			System.out.println("The question '"+strQuestion+"' is of type MCQ");	
			}
			else
			{
				System.out.println("The question '"+strQuestion+"' is NOT of type MCQ");	
			}
			
		}
		
		public void Validate_Quize_Question_Select_Instruction()
		{
			try {
				String instruction= objStudyPlan.lbl_Practice_Quize_Q_selectInstruction.getText();
				System.out.println("Instruction for selecting answer for question is given as: "+instruction);
				
			} catch (Exception e) {
				System.out.println("Instruction for selecting answer for question is NOT given");
			}
		}
		
		public void Validate_Quize_Questions_Feedback_After_Answer() throws Exception
		{
			String questionsCount= objStudyPlan.lbl_Practice_Quize_QNos.getText().split(" ")[2];
			int length= Integer.parseInt(questionsCount);
			String question="";
			int counter=1;
			boolean flagOpt1=false;
			for(int i=0;i<length;i++)
			{
				question=objStudyPlan.lbl_Practice_Quize_Question.getText();
				System.out.println("Current question number is '"+counter+"' and question is: "+question);
				Validate_Quize_Question_Select_Instruction();
				System.out.println("Scrolling the Mobile Screen");
				scrollDown_SecondTime(15);
				Thread.sleep(2000);
				Validate_Quize_Question_Get_Options(question);
				Validate_Button_Check_Answer_Enabled();
				Validate_Quize_Question_Click_Option(objStudyPlan.lbl_Practice_Quize_Q_opt1,
						"User is able to select First Option",
						"User is NOT able to select First Option");
				Validate_Button_Check_Answer_Enabled();
				String strText=objStudyPlan.btn_Practice_Quize_CheckAnswer.getText();
				if(strText.equalsIgnoreCase("CHECK ANSWER"))
				{
				objStudyPlan.btn_Practice_Quize_CheckAnswer.click();
				}
				String strOpt1=objStudyPlan.lbl_Practice_Quize_Q_opt1.getText();
				flagOpt1 = Validate_Quize_Question_Selected_Option(strOpt1, 0, 
						"Option 1 is in selected Mode", "Option 1 is NOT in selected Mode");
				if(flagOpt1)
				{
					Validate_Practice_Quize_Answers_Feedback(strOpt1, question, 0);
				}
				Navigate_To_Next_Question();
				Thread.sleep(2000);
				counter++;
			}
		}
		
		public void Navigate_To_Next_Question()
		{
			try {
				objStudyPlan.lbl_Practice_Qauize_IwillAttemptLater.click();
				System.out.println("Clicked on link 'I'll attempt later'");
				objStudyPlan.lbl_Practice_Quize_Continue.click();
				System.out.println("Clicked on button 'CONTINUE'");
			}
			catch (Exception e) {
				objStudyPlan.lbl_Practice_Quize_Continue.click();
				System.out.println("Clicked on button 'CONTINUE'");
			}
		}
		
		public boolean Validate_Button_Check_Answer_Enabled() throws Exception
		{
			boolean enableFlag=false;
			try {
				objStudyPlan.btn_Practice_Quize_CheckAnswer.getText();
				System.out.println("Button 'CHECK ANSWER' is enabled.");
				enableFlag=true;
			} catch (Exception e) {
				System.out.println("Button 'CHECK ANSWER' is NOT enabled.");
			}
			return enableFlag;
		}
			
		public void Validate_Practice_Quize_Answers_Feedback(String strOptLabel, String strQuestion, int resourceID) throws Exception
		{
			String xpath="//android.widget.CheckBox[@resource-id='"+resourceID+"' and @checked='true']";
			System.out.println("Question is: "+strQuestion);
			try {
			getDriver().findElement(By.xpath(xpath));	
			System.out.println("The Feedback is given for selected option '"+strOptLabel+"' for question '"+strQuestion+"'.");
			}
			catch (Exception e) {
				System.out.println("NOT able to fetch the Feedback for selected option for question '"+strQuestion+"'.");
			}
			Thread.sleep(1000);
		}
		
		public void Validate_Quiz_Skipped_Questions_Added_To_Queue() throws Exception
		{
			String questionsCount= objStudyPlan.lbl_Practice_Quize_QNos.getText().split(" ")[2];
			int length= Integer.parseInt(questionsCount);
			String question="";
			int counter=1;
			boolean flagOpt1=false;
			List<String> lstQues= new LinkedList<String>();
			for(int i=0;i<length+1;i++)
			{
				question=objStudyPlan.lbl_Practice_Quize_Question.getText();
				lstQues.add(question);
				System.out.println("Current question number is '"+counter+"' and question is: "+question);
				if(counter==1)
				{
					System.out.println("'Skipping', question present on number '"+counter+"' and question is: "+question);
					objStudyPlan.lbl_Practice_Qauize_IwillAttemptLater.click();
					System.out.println("Clicked on link 'I'll attempt later'");
					Thread.sleep(2000);
				}
				else if(counter==(length+1))
				{
					if(lstQues.get(0).equalsIgnoreCase(question))
					{
						System.out.println("The 'Skipped' question is added in the queue at the last.");
						System.out.println("The 'Skipped' question is addeded at position '"+counter+"'");
					}
					else
					{
						System.out.println("The 'Skipped' question is NOT added in the queue at the last, on number '"+counter+"'");
					}
				}
				else {
				System.out.println("Scrolling the Mobile Screen");
				scrollDown_SecondTime(15);
				Thread.sleep(2000);
				Validate_Quize_Question_Click_Option(objStudyPlan.lbl_Practice_Quize_Q_opt1,
						"User is able to select First Option",
						"User is NOT able to select First Option");
				String strText=objStudyPlan.btn_Practice_Quize_CheckAnswer.getText();
				if(strText.equalsIgnoreCase("CHECK ANSWER"))
				{
				objStudyPlan.btn_Practice_Quize_CheckAnswer.click();
				}
				String strOpt1=objStudyPlan.lbl_Practice_Quize_Q_opt1.getText();
				flagOpt1 = Validate_Quize_Question_Selected_Option(strOpt1, 0, 
						"Option 1 is in selected Mode", "Option 1 is NOT in selected Mode");
				if(flagOpt1)
				{
					Validate_Practice_Quize_Answers_Feedback(strOpt1, question, 0);
				}
				Navigate_To_Next_Question_Do_NOT_SKIP();
				Thread.sleep(2000);
				}
				counter++;
			}
		}
		
		public void Navigate_To_Next_Question_Do_NOT_SKIP()
		{
			try {
				String strText=objStudyPlan.lbl_Practice_Quize_Continue.getText();
				objStudyPlan.lbl_Practice_Quize_Continue.click();
				if(strText.equalsIgnoreCase("TRY AGAIN"))
				{
				System.out.println("Clicked on button 'TRY AGAIN'. Selecting the option 2 as '"+objStudyPlan.lbl_Practice_Quize_Q_opt2.getText()+"'.");
				Validate_Quize_Question_Click_Option(objStudyPlan.lbl_Practice_Quize_Q_opt2,
						"User is able to select Second Option",
						"User is NOT able to select Second Option");
				objStudyPlan.btn_Practice_Quize_CheckAnswer.click();
				objStudyPlan.lbl_Practice_Quize_Continue.click();
				}
				else
				{
					System.out.println("Clicked on button 'CONTINUE'");
				}
			}
			catch (Exception e) {
				System.out.println("NOT able to navigate to Next Question");
			}
		}
		
		public List<String> Validate_Presence_Of_Quize_Questions() throws Exception
		{
			lstQuestions= new ArrayList<String>();
			String questionsCount= objStudyPlan.lbl_Practice_Quize_QNos.getText().split(" ")[2];
			int length= Integer.parseInt(questionsCount);
			String question="";
			int counter=1;
			for(int i=0;i<length;i++)
			{
				question=objStudyPlan.lbl_Practice_Quize_Question.getText();
				lstQuestions.add(question);
				System.out.println("Current question number is '"+counter+"' and question is: "+question);
				Validate_Quize_Question_Select_Instruction();
				System.out.println("Scrolling the Mobile Screen");
				scrollDown_SecondTime(15);
				Thread.sleep(2000);
				Validate_Quize_Question_Get_Options(question);
				objStudyPlan.lbl_Practice_Qauize_IwillAttemptLater.click();
				Thread.sleep(2000);
				counter++;
			}
			System.out.println("\nFollowing Questions are present in 'Practice Quize':");
			int counter1=1;
			for(int i=0;i<lstQuestions.size();i++)
			{
				System.out.println("Question "+counter1+": "+lstQuestions.get(i));
				counter1++;
			}
			Thread.sleep(2000);
			return lstQuestions;
		}
		
		public String Validate_Warining_Msg_After_Click_On_Back_Button() throws Exception
		{
			currentQuestionBeforeBackClicked=objStudyPlan.lbl_Practice_Quize_Question.getText();
			Perform_Click_Operation(objStudyPlan.btn_back_quizQuestion, 
					"User is able to click on 'Back Button', when user is on page having question: "+currentQuestionBeforeBackClicked,
					"User is NOT able to click on 'Back Button', when user is on page having question: "+currentQuestionBeforeBackClicked, 2000);
			return currentQuestionBeforeBackClicked;
		}
		
		public void Validate_Warining_Msg_Popup() throws Exception
		{
			String warningMsg=Get_Element_Text(objStudyPlan.lbl_warningPopUp_Msg,
					"Able to fetch the 'Warning Message' from 'Warning Pop Up'",  "NOT able to fetch the 'Warning Message' from 'Warning Pop Up'");
			if(warningMsg.equalsIgnoreCase("Your Progress will be lost. Are you sure want to go Away?"))
			{
				System.out.println("Correct 'Warining Message' message is shown as: "+warningMsg);
			}
			else
			{
				System.out.println("Wrong 'Warining Message' message is shown as: "+warningMsg);
			}
			String btn_No_Text=Get_Element_Text(objStudyPlan.btn_warningPopUp_NO,
					"Able to fetch the label of button 'NO' from 'Warning Pop Up'", "NOT able to fetch the label of button 'NO' from 'Warning Pop Up'");
			if(btn_No_Text.equalsIgnoreCase("NO"))
			{
				System.out.println("Correct label is shown on button 'NO': "+btn_No_Text);
			}
			else
			{
				System.out.println("Correct label is NOT shown on button 'NO': "+btn_No_Text);
			}
			String btn_Yes_Text=Get_Element_Text(objStudyPlan.btn_warningPopUp_YES,
					"Able to fetch the label of button 'YES' from 'Warning Pop Up'", "NOT able to fetch the label of button 'YES' from 'Warning Pop Up'");
			if(btn_Yes_Text.equalsIgnoreCase("YES"))
			{
				System.out.println("Correct label is shown on button 'YES': "+btn_Yes_Text);
			}
			else
			{
				System.out.println("Correct label is NOT shown on button 'YES': "+btn_Yes_Text);
			}
		}
		
		public String Get_Element_Text(WebElement ele, String successEleMsg, String failureMsg)
		{
			String lblText=null;
			try {
				lblText=ele.getText();
				System.out.println(successEleMsg);
			}
			catch (Exception e) {
				System.out.println(failureMsg);
			}
			return lblText;
		}
		
		public void Validate_Tap_On_NO_Warining_PopUp_And_Question_From_Abandan_Initiated() throws Exception
		{
			Perform_Click_Operation(objStudyPlan.btn_warningPopUp_NO, 
					"User is able to click on 'NO' button",	"User is able NOT to click on 'NO' button", 2000);
			String currentQuestion=objStudyPlan.lbl_Practice_Quize_Question.getText();
			if(currentQuestion.equalsIgnoreCase(currentQuestionBeforeBackClicked))
			{
				System.out.println("Same question appeared on the screen from where 'Quiz Abandan' was initiated.");
			}
			else
			{
				System.out.println("Same question is NOT appeared on the screen from where 'Quiz Abandan' was initiated.");
			}
		}
		
		public void Validate_Tap_On_YES_Warining_PopUp_And_Navigation_To_Practice_Again_Page() throws Exception
		{
			Perform_Click_Operation(objStudyPlan.btn_warningPopUp_YES, 
					"User is able to click on 'YES' button","User is able NOT to click on 'YES' button", 2000);
			Perform_Click_Operation(objStudyPlan.btn_back_quizQuestion, 
					"User is able to click on 'Back Button', when user is on 'Practice Page'",
					"User is NOT able to click on 'Back Button', when user is on 'Practice Page'", 2000);
			Validate_Required_Label_Text("All Chapters", objStudyPlan.lbl_allChapters.getText(), 
					"User is navigated to 'Book's Page'. Label 'All Chapters' is present on Book's page.",
					"User is NOT navigated to 'Book's Page'. Label 'All Chapters' is NOT present on Book's page.");
		}
		
		
		
}




