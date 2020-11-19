package studi.co.pageModules;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Completed_In_School_Status;
import studi.co.pageObjects.Object_Confirm_Syllabus_Tab;

public class Module_Get_Syllabus_Tab_Label extends BaseClass{
	
public static String getSyllabusTab;
	
	public void Verify_Syllabus_Tab_Label() throws InterruptedException{
		
		Object_Confirm_Syllabus_Tab RMQP = new Object_Confirm_Syllabus_Tab();
		//Module_Login login = new Module_Login();
		
		Object_Completed_In_School_Status RMQP1 = new Object_Completed_In_School_Status();
		//Module_Login login = new Module_Login();
		
		
		//login.Login_to_app();
		RMQP1.select_book_shelf.click();
		Thread.sleep(1000);
		
		//login.Login_to_app();
		
		getSyllabusTab = RMQP.get_syllabus_Tab_Label.getText();
		System.out.println(getSyllabusTab);
		if(getSyllabusTab.contains("Your Syllabus"))
			System.out.println("Syllabus Tab Shown");
		else
			System.out.println("Syllabus Tab Not Shown");
		

}}
