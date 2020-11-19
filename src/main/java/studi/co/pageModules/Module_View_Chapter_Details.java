package studi.co.pageModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Completed_In_School_Status;
import studi.co.pageObjects.Object_Excluded_From_Syllabus_Manually;
import studi.co.pageObjects.Object_View_Chapters_Listing;

public class Module_View_Chapter_Details extends BaseClass {
	
	public static String getBookShelfPage, getAllChaptersPage, getFieldLabel, getFieldLabel1, getNameChapter1, getNameChapter2;
		
		public void Verify_View_Chapter_Details() throws InterruptedException, AWTException{

			String getBookShelfPage;
			
			Object_Completed_In_School_Status RMQP = new Object_Completed_In_School_Status();
			
			Object_View_Chapters_Listing RMQP2 = new Object_View_Chapters_Listing();
									
			Object_Excluded_From_Syllabus_Manually RMQP1 = new Object_Excluded_From_Syllabus_Manually();
		
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
			
			robot.keyPress(KeyEvent.VK_UP);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_UP);
			Thread.sleep(2000);
		
			RMQP.click_down_arrow.click();
			Thread.sleep(1000);
			
			getFieldLabel = RMQP.get_Completed_In_School_FieldLabel.getText();
			if(getFieldLabel.contains("Completed in School"))
				System.out.println("Completed in School field shown");
			else
				System.out.println("Completed in School field not shown");
			
			getFieldLabel1 = RMQP1.get_Excluded_From_Syllabus_FieldText.getText();
			if(getFieldLabel1.contains("Exclude from Syllabus"))
				System.out.println("Exclude from Syllabus field shown");
			else
				System.out.println("Exclude from Syllabus field shown");
	}
		
		

}
