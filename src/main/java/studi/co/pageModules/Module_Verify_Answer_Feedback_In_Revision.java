package studi.co.pageModules;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestResult;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.Base.Keyword;
import studi.co.pageObjects.Object_Begin_Revision_Topic1_Chapter1_Geography;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Practice;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Revision;

public class Module_Verify_Answer_Feedback_In_Revision extends BaseClass{
	public void verify_Answer_Feedback() throws InterruptedException, AWTException, WebDriverException, IOException {
		Object_Receive_MCQ_Questions_Practice RMQP = new Object_Receive_MCQ_Questions_Practice();
		Object_Receive_MCQ_Questions_Revision RMQP1 = new Object_Receive_MCQ_Questions_Revision();
		
		Keyword.clickOnElement(RMQP.select_syllabus);
		Keyword.applyExplicitWait(2);
		Keyword.clickOnElement(RMQP.select_subject); 
		Keyword.applyExplicitWait(5);
		System.out.println("Subject - Geography - Geography Grade 6 is shown");
		Keyword.clickOnElement(RMQP1.select_topic_from_chapter); 
		Keyword.applyExplicitWait(5);
		System.out.println("Selected Topic");
		Keyword.applyExplicitWait(5);
		Keyword.clickOnElement(RMQP1.select_Begin_Revision);
		Keyword.applyExplicitWait(20);
		Keyword.clickOnElement(RMQP1.click_Begin_Revision);
		Keyword.applyExplicitWait(15);
		
		System.out.println("Video started");
		
		
		  Keyword.applyExplicitWait(5);
		  
		  //Used the utility method instead
		  Keyword.handleVideoWait(RMQP1.img_OverviewPg_screen,
		  RMQP1.img_OverviewPg_screen_time);
		 
		
//		Keyword.clickOnElement(RMQP1.img_OverviewPg_screen);
//		String totalVideoTime=Keyword.getTextOfElement(RMQP1.img_OverviewPg_screen_time);
//		System.out.println(totalVideoTime);
//		int totalWaitingMins=Integer.parseInt(totalVideoTime.split(":")[0]);
//		int totalWaitingSecs=Integer.parseInt(totalVideoTime.split(":")[1]);
//		int minSecs=(totalWaitingMins)*60;
//		int totalWait=(minSecs+totalWaitingSecs+5)*1000;
//		System.out.println("Waiting for Video to complete. Waiting for '"+(totalWait)/1000+"' seconds");
//		int wait=0; 
//		try {
//		while(wait<totalWait)
//		{
//			Keyword.applyExplicitWait(5);
//			Keyword.clickOnElement(RMQP1.img_OverviewPg_screen);
//			wait=wait+5000;
//		}
//		}
//		catch (Exception e) {}
//		System.out.println("Waited till '"+(totalWait)/1000+"' seconds");
		
		Keyword.applyExplicitWait(10);
		
		
		//Getting the property called bounds of the element before the click for answer 1
		MobileElement element1before=(MobileElement)RMQP1.select_1st_Choice;
		String bounds1BeforeClick=element1before.getAttribute("bounds"); 
		
		System.out.println("Value of the property bounds before click is "+bounds1BeforeClick);		
		//Getting the property called bounds of the element after click for answer 1 
		Keyword.clickOnElement(RMQP1.select_1st_Choice); 
		MobileElement element1after=(MobileElement)RMQP1.select_1st_Choice;
		String bounds1AfterClick=element1after.getAttribute("bounds");
		System.out.println("Value of the property bounds after click for answer 1 is :"+bounds1AfterClick);
		Keyword.applyExplicitWait(2);
		//Doing the same for answer option 2
		MobileElement element2before=(MobileElement)RMQP1.select_2nd_Choice;
		String bounds2before=element2before.getAttribute("bounds");
		System.out.println("Value of the property bounds before clicking answer 2 "+bounds2before);
		Keyword.clickOnElement(RMQP1.select_2nd_Choice); 
		Keyword.applyExplicitWait(2);
		
		MobileElement element2after=(MobileElement)RMQP1.select_2nd_Choice;
		String bounds2after=element2after.getAttribute("bounds"); 
		System.out.println("Value of the property bounds after clicking answer 2 "+bounds2after);
		Keyword.applyExplicitWait(2);
		
		
	}
	
		public void Verify_Feedback_On_All_Answers_In_Revision() throws InterruptedException, AWTException, HeadlessException, IOException {
			Object_Receive_MCQ_Questions_Practice RMQP = new Object_Receive_MCQ_Questions_Practice();
			Object_Receive_MCQ_Questions_Revision RMQP1 = new Object_Receive_MCQ_Questions_Revision();
			
			Keyword.clickOnElement(RMQP.select_syllabus);
			Keyword.applyExplicitWait(3);
			RMQP.select_subject.click();
			Keyword.applyExplicitWait(3);
			System.out.println("Subject - Geography - Geography Grade 6 is shown");
			Keyword.clickOnElement(RMQP1.select_topic_from_chapter);
			Keyword.applyExplicitWait(3);
			System.out.println("Selected Topic");
			Keyword.clickOnElement(RMQP1.select_Begin_Revision);
			Keyword.applyExplicitWait(3);
			Keyword.clickOnElement(RMQP1.click_Begin_Revision);
			Keyword.applyExplicitWait(7);
			
			System.out.println("Video started");
			
			Keyword.applyExplicitWait(5);
			
			Keyword.handleVideoWait(RMQP1.img_OverviewPg_screen, RMQP1.img_OverviewPg_screen_time);
			
			Keyword.applyExplicitWait(6);
			
		
			Keyword.clickOnElementUsingText("The Pole star");
			Keyword.applyExplicitWait(3);
			
			Keyword.clickOnElementUsingText("The moon");
			Keyword.applyExplicitWait(3);
			
			Keyword.clickOnElementUsingText("The earth");
			Keyword.applyExplicitWait(3);
			
			Keyword.clickOnElementUsingText("The sun");
			Keyword.applyExplicitWait(3);
			takeScreenshot();
			
		}

	}

