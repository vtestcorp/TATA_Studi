package studi.co.pageModules;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Sleep;
import org.assertj.core.util.FailureMessages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Study_Plan_Review_Active_Plan;

public class Module_Study_Plan_Review_Active_Plan extends BaseClass {
	
	Object_Study_Plan_Review_Active_Plan objStudyPlan = new Object_Study_Plan_Review_Active_Plan();
	Module_Create_Study_Plan CSP = new Module_Create_Study_Plan();
	public static String homepage_title, no_active_study_plan, lbl_testUnit, review_button_name, lbl_browse_books, lbl_all_subjects, lbl_book_1, lbl_book_2;
	Robot robot=null;
	
	
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
			Toggle_Switch_Operation(objStudyPlan.lbl_mySelfChapter_TP_aboutMe_excludeFromSyllabus,
					"Able to click on Toggle Switch for 'Exclude from Syllabus' for TP 'ABOUT ME' in chapter 'Myself' on Book's page.",
					"NOT Able to click on Toggle Switch for 'Exclude from Syllabus' for TP 'ABOUT ME' in chapter 'Myself' on Book's page.");
			Validate_Required_Label_Text("Exclude from Syllabus", objStudyPlan.lbl_mySelfChapter_TP_aboutMe_excludeFromSyllabus.getText(), 
					"Label 'Exclude from Syllabus' is present in TP 'ABOUT ME' of chapter 'Myself' on Book's page.", 
					"Label 'Exclude from Syllabus' is NOT present in TP 'ABOUT ME' of chapter 'Myself' on Book's page.");
			Toggle_Switch_Operation(objStudyPlan.switch_mySelfChapter_TP_aboutMe_compltedInSchool,
					"Able to click on Toggle Switch for 'Completed in School' for TP 'ABOUT ME' in chapter 'Myself' on Book's page.",
					"NOT Able to click on Toggle Switch for 'Exclude from Syllabus' for TP 'ABOUT ME' in chapter 'Myself' on Book's page.");
			Validate_Required_Label_Text("Completed in School", objStudyPlan.switch_mySelfChapter_TP_aboutMe_compltedInSchool.getText(), 
					"Label 'Completed in School' is present in TP 'ABOUT ME' of chapter 'Myself' on Book's page.", 
					"Label 'Completed in School' is NOT present in TP 'ABOUT ME' of chapter 'Myself' on Book's page.");
		}
		
		public void Toggle_Switch_Operation(WebElement ele1, String strSuccessMsg, String strFailureMsg)
		{
			try {
				ele1.click();
				Thread.sleep(8000);
				System.out.println(strSuccessMsg);
			}
			catch (Exception e) {
				System.out.println("NOT able to perform click Toggle Switch. Exception is: \n"+e.getMessage());
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

}






