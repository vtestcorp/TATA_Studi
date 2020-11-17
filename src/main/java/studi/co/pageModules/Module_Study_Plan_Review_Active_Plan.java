package studi.co.pageModules;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.assertj.core.util.FailureMessages;
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
		
}

