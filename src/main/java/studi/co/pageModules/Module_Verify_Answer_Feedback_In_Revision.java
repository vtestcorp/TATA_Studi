package studi.co.pageModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Begin_Revision_Topic1_Chapter1_Geography;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Practice;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Revision;

public class Module_Verify_Answer_Feedback_In_Revision extends BaseClass{
	public void verify_Answer_Feedback() throws InterruptedException, AWTException {
		Object_Receive_MCQ_Questions_Practice RMQP = new Object_Receive_MCQ_Questions_Practice();
		Object_Receive_MCQ_Questions_Revision RMQP1 = new Object_Receive_MCQ_Questions_Revision();
		
		RMQP.select_browse_books.click();
		Thread.sleep(1000);
		RMQP.select_subject.click();
		Thread.sleep(1000);
		System.out.println("Subject - Geography - Geography Grade 6 is shown");
		RMQP1.select_topic_from_chapter.click();
		Thread.sleep(5000);
		System.out.println("Selected Topic");
		RMQP1.select_Begin_Revision.click();
		Thread.sleep(20000);
		RMQP1.click_Begin_Revision.click();
		Thread.sleep(3000);
		
		System.out.println("Video started");
		
		Thread.sleep(5000);
		
		RMQP1.img_OverviewPg_screen.click();
		String totalVedioTime=RMQP1.img_OverviewPg_screen_time.getText();
		System.out.println(totalVedioTime);
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
			RMQP1.img_OverviewPg_screen.click();
			wait=wait+5000;
		}
		}
		catch (Exception e) {}
		System.out.println("Waited till '"+(totalWait)/1000+"' seconds");
		
		Thread.sleep(10000);
		
		RMQP1.select_1st_Choice.click();
		Thread.sleep(2000);
		RMQP1.select_2nd_Choice.click();
		Thread.sleep(2000);
		
		 	
		Thread.sleep(2000);
		String rgbvalue1=RMQP1.select_1st_Choice.getCssValue("background-color");
		Thread.sleep(2000);
		String rgbvalue2=RMQP1.select_2nd_Choice.getCssValue("background-color"); 
		Thread.sleep(2000);
		
		System.out.println("Got the css Value");
		if (rgbvalue1!=rgbvalue2) {
			System.out.println("Feedback is given correctly after choosing 1 wrong and 1 correct answer options");
		} else {
			System.out.println("Feedback is not given properly");
	}
	}
		public void Verify_Feedback_On_All_Answers_In_Revision() throws InterruptedException, AWTException {
			Object_Receive_MCQ_Questions_Practice RMQP = new Object_Receive_MCQ_Questions_Practice();
			Object_Receive_MCQ_Questions_Revision RMQP1 = new Object_Receive_MCQ_Questions_Revision();
			
			RMQP.select_browse_books.click();
			Thread.sleep(1000);
			RMQP.select_subject.click();
			Thread.sleep(1000);
			System.out.println("Subject - Geography - Geography Grade 6 is shown");
			RMQP1.select_topic_from_chapter.click();
			Thread.sleep(2000);
			System.out.println("Selected Topic");
			RMQP1.select_Begin_Revision.click();
			Thread.sleep(20000);
			RMQP1.click_Begin_Revision.click();
			Thread.sleep(7000);
			
			System.out.println("Video started");
			
			Thread.sleep(5000);
			
			RMQP1.img_OverviewPg_screen.click();
			String totalVedioTime=RMQP1.img_OverviewPg_screen_time.getText();
			System.out.println(totalVedioTime);
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
				RMQP1.img_OverviewPg_screen.click();
				wait=wait+5000;
			}
			}
			catch (Exception e) {}
			System.out.println("Waited till '"+(totalWait)/1000+"' seconds");
			
			Thread.sleep(10000);
			MobileElement elementBefore=(MobileElement)RMQP1.select_1st_Choice;
			String beforeclick=elementBefore.getAttribute("bounds");
			System.out.println(beforeclick);
			
			RMQP1.select_1st_Choice.click();
			Thread.sleep(2000);
			
			MobileElement elementAfter=(MobileElement)RMQP1.select_1st_Choice;
			String afterclick=elementAfter.getAttribute("bounds"); 
			System.out.println(afterclick);
			Thread.sleep(2000);
			Assert.assertFalse(afterclick.equals(beforeclick));
					}

	}

