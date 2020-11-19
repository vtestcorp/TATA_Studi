package studi.co.pageModules;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Completed_In_School_Status;

public class Module_Mark_Completed_In_School_Manually extends BaseClass {
	
public static String getBookShelfPage, getAllChaptersPage, getFieldLabel;
	
	public void Verify_Completed_In_School_Status() throws InterruptedException{

		String getBookShelfPage;
		
		Object_Completed_In_School_Status RMQP = new Object_Completed_In_School_Status();
		//Module_Login login = new Module_Login();
		
		
		//login.Login_to_app();
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
		
		getFieldLabel = RMQP.get_Completed_In_School_FieldLabel.getText();
		System.out.println(getFieldLabel);
		if(getFieldLabel.contains("Completed in School"))
			System.out.println("Completed in School field shown");
		else
			System.out.println("Completed in School field not shown");
		
		RMQP.check_Completed_In_School_Toggle.click();
		Thread.sleep(8000);
		
		System.out.println("Status marked as ON");
		
		RMQP.check_Completed_In_School_Toggle.click();
		Thread.sleep(8000);
		
		System.out.println("Status marked as OFF");
}

}
