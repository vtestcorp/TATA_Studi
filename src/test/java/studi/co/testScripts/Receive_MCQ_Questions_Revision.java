package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Model_Receive_MCQ_Questions_Revision;

public class Receive_MCQ_Questions_Revision extends BaseClass{
	
	public Receive_MCQ_Questions_Revision() {
		super();
	}

	@Test
	public void Verify_Review_Plan_Tab() throws Exception {
		
		Model_Receive_MCQ_Questions_Revision MRMQP = new Model_Receive_MCQ_Questions_Revision();
		MRMQP.Verify_Navigate_Revision_From_Topic_Listing();
	}

}
