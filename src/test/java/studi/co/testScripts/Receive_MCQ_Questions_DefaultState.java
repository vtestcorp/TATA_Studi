package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Model_Receive_MCQ_Questions_DefaultState;

public class Receive_MCQ_Questions_DefaultState extends BaseClass {
	
	public Receive_MCQ_Questions_DefaultState() {
		super();
	}

	@Test
	public void Verify_Review_Plan_Tab() throws Exception {
		
		Model_Receive_MCQ_Questions_DefaultState MRMQP = new Model_Receive_MCQ_Questions_DefaultState();
		MRMQP.Verify_MCQ_Questions_DefaultState();
	}


}
