package studi.co.pageModules;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Completed_In_School_Status;
import studi.co.pageObjects.Object_Excluded_From_Syllabus_Manually;

public class Module_Excluded_From_Syllabus_Manually extends BaseClass {
	
	public static String getBookShelfPage, getAllChaptersPage, getFieldLabel;
	
	public void Verify_Excluded_From_Syllabus() throws InterruptedException{

		String getBookShelfPage;
		
		Object_Completed_In_School_Status RMQP = new Object_Completed_In_School_Status();
		//Module_Login login = new Module_Login();
		
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
		
		RMQP.click_down_arrow.click();
		Thread.sleep(1000);
		
		getFieldLabel = RMQP1.get_Excluded_From_Syllabus_FieldText.getText();
		System.out.println(getFieldLabel);
		if(getFieldLabel.contains("Exclude from Syllabus"))
			System.out.println("Exclude from Syllabus field shown");
		else
			System.out.println("Exclude from Syllabus field shown");
		
		RMQP1.click_Excluded_From_Syllabus_Toggle.click();
		Thread.sleep(8000);
		
		System.out.println("Exclude from Syllabus toggle turned ON");
		
		RMQP1.click_Excluded_From_Syllabus_Toggle.click();
		Thread.sleep(8000);
		
		System.out.println("Exclude from Syllabus toggle turned OFF");
		
		
	}
}
