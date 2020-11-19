package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Model_View_Chapter_Listing;

public class View_Chapter_Details extends BaseClass {
	
	public View_Chapter_Details() {
		super();
	}

	@Test
	public void Verify_Review_Plan_Tab() throws Exception {
		
		Model_View_Chapter_Listing MRMQP = new Model_View_Chapter_Listing();
		MRMQP.Verify_View_Chapter_Listing();
	}


}
