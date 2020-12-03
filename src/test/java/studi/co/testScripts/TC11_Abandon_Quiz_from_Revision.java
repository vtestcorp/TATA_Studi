package studi.co.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_Verify_Abandon_Quiz_From_Revision;
import studi.co.pageObjects.Object_Begin_Revision_Topic4_Chapter1_Mathematics;
import studi.co.pageObjects.Object_Browse_Books;
import studi.co.pageObjects.Object_Login;
import studi.co.pageObjects.Object_Subject_Mathematics;

public class TC11_Abandon_Quiz_from_Revision extends BaseClass{
	
	public TC11_Abandon_Quiz_from_Revision() {
		super();
	}
	
	@Test
	public void verifyAbandon() throws InterruptedException {
		Module_Login login = new Module_Login();
		login.Login_to_app();
		
		Module_Verify_Abandon_Quiz_From_Revision mvaqfr=new Module_Verify_Abandon_Quiz_From_Revision();
		mvaqfr.verifyAbandonQuiz();
	}
	
}
				
		
		
		
		
		
		
		



