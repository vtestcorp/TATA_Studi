package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Review_Plan_Tab;

public class Review_Plan_Tab extends BaseClass {
	
	public Review_Plan_Tab() {
		super();
	}

	@Test
	public void Verify_Review_Plan_Tab() throws Exception {
		
		Module_Review_Plan_Tab MRMQP = new Module_Review_Plan_Tab();
		MRMQP.Verify_Review_Plan_Tab();
	}

}
