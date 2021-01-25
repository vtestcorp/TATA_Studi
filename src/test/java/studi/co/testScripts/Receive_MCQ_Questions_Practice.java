package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Receive_MCQ_Questions_Practice;

public class Receive_MCQ_Questions_Practice extends BaseClass {

	// Calling base class constructor.
		public Receive_MCQ_Questions_Practice() {
			super();
		}

		@Test
		public void Receive_MCQ_Questions() throws Exception {
			
			Module_Receive_MCQ_Questions_Practice MRMQP = new Module_Receive_MCQ_Questions_Practice();
			MRMQP.Verify_Student_Receives_MCQ_Questions_Practice();
		}

}
