package studi.co.pageModules;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Completed_In_School_Status;
import studi.co.pageObjects.Object_Confirm_Syllabus_Tab;
import studi.co.pageObjects.Object_Review_Plan_Tab;

public class Module_Syllabus_Tappable extends BaseClass {
	
	public static String getSyllabusTab, getLandingPageTitle;
	
    public void Verify_Syllabus_Tappable() throws InterruptedException{
		
		Object_Confirm_Syllabus_Tab RMQP = new Object_Confirm_Syllabus_Tab();
		
		Object_Completed_In_School_Status RMQP1 = new Object_Completed_In_School_Status();
		
       Object_Review_Plan_Tab RMQP2 = new Object_Review_Plan_Tab();
		
		getLandingPageTitle = RMQP2.verify_landing_page.getText();
		System.out.println(getLandingPageTitle);
		if(getLandingPageTitle.contains("What would\n" + "you like to do next?"))
			System.out.println("Landing page displayed");
		else
			System.out.println("Landing page not displayed");
		
		RMQP1.select_book_shelf.click();
		Thread.sleep(1000);
		
		getSyllabusTab = RMQP.get_syllabus_Tab_Label.getText();
		if(getSyllabusTab.contains("Your Syllabus"))
			System.out.println("Syllabus Tab Is Clickable");
		else
			System.out.println("Syllabus Tab Is Clickable");
		

}
}
