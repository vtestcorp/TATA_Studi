package studi.co.pageModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Completed_In_School_Status;
import studi.co.pageObjects.Object_View_Chapters_Listing;

public class Model_View_Chapter_Listing extends BaseClass {

public static String getBookShelfPage, getAllChaptersPage, getFieldLabel, getNameChapter1, getNameChapter2, getTopicNames1Chapter1,
getTopicNames2Chapter1, getTopicNames3Chapter1, getTopicNames4Chapter1, getTopicName1Chapter2, getTopicName2Chapter2;
	
	public void Verify_View_Chapter_Listing() throws InterruptedException, AWTException{

		String getBookShelfPage;
		
		Object_Completed_In_School_Status RMQP = new Object_Completed_In_School_Status();
		
		Object_View_Chapters_Listing RMQP2 = new Object_View_Chapters_Listing();
	
		RMQP.select_book_shelf.click();
		Thread.sleep(1000);
		
		getBookShelfPage = RMQP.verify_book_shelf_page.getText();
		System.out.println(getBookShelfPage);
		if(getBookShelfPage.contains("Browse Books"))
			System.out.println("All Subjects page shown");
		else
			System.out.println("All Subjects page not shown");
		
		RMQP.select_subject.click();
		Thread.sleep(1000);
		
		getAllChaptersPage = RMQP.verify_chapters_page.getText();
		System.out.println(getAllChaptersPage);
		if(getAllChaptersPage.contains("All Chapters"))
			System.out.println("All Chapters page shown");
		else
			System.out.println("All Chapters page not shown");
		
		getNameChapter1 = RMQP2.getName_Chapter1.getText();
		if(getNameChapter1.contains("1. Numbers from 0 to 20"))
			System.out.println("Chapter 1 is available");
		else
			System.out.println("Chapter 1 is not available");
		System.out.println("");
		
		getTopicNames1Chapter1 = RMQP2.getTopic1_Chapter1.getText();
		getTopicNames2Chapter1 = RMQP2.getTopic2_Chapter1.getText();
		getTopicNames3Chapter1 = RMQP2.getTopic3_Chapter1.getText();
		getTopicNames4Chapter1 = RMQP2.getTopic4_Chapter1.getText();
		
		System.out.println("List of topics from chapter 1:");
		System.out.println("Topic 1: " + getTopicNames1Chapter1);
		System.out.println("Topic 2: " + getTopicNames2Chapter1);
		System.out.println("Topic 3: " + getTopicNames3Chapter1);
		System.out.println("Topic 4: " + getTopicNames4Chapter1);
		System.out.println("");
		
		Thread.sleep(2000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		getNameChapter2 = RMQP2.getName_Chapter1.getText();
		if(getNameChapter2.contains("2. Addition up to 10"))
			System.out.println("Chapter 2 is available");
		else
			System.out.println("Chapter 2 is not available");
		
		getTopicName1Chapter2 = RMQP2.getTopic1_Chapter2.getText();
		getTopicName2Chapter2 = RMQP2.getTopic2_Chapter2.getText();
		
		System.out.println("List of topics from chapter 2:");
		System.out.println("Topic 1: " + getTopicName1Chapter2);
		System.out.println("Topic 2: " + getTopicName2Chapter2);
	
}
}
