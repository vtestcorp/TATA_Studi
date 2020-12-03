package studi.co.testScripts;

import java.awt.AWTException;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_Verify_Answer_Feedback_In_Revision;

public class TC08_Verify_Feedback_for_Answers_in_Revision extends BaseClass {
	
	public TC08_Verify_Feedback_for_Answers_in_Revision() {
		super();
	}
	@Test
	public void verify_feedback_for_answers() throws InterruptedException, AWTException {
		Module_Login ml=new Module_Login(); 
		ml.Login_to_app();
		
		Module_Verify_Answer_Feedback_In_Revision mva=new Module_Verify_Answer_Feedback_In_Revision(); 
		mva.verify_Answer_Feedback();
	}
}
