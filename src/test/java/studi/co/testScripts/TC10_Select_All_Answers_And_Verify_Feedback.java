package studi.co.testScripts;

import java.awt.AWTException;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_Verify_Answer_Feedback_In_Revision;

public class TC10_Select_All_Answers_And_Verify_Feedback extends BaseClass {
 public TC10_Select_All_Answers_And_Verify_Feedback() {
	 super(); 
 }
 @Test
 public void verify_All_Answers() throws InterruptedException, AWTException {
	 Module_Login ml= new Module_Login(); 
	 ml.Login_to_app();
	 
	 Module_Verify_Answer_Feedback_In_Revision mvaf=new Module_Verify_Answer_Feedback_In_Revision(); 
	 mvaf.Verify_Feedback_On_All_Answers_In_Revision();
 }
}
