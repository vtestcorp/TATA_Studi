package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Navigate_Revision_From_Topic_Listing;
import studi.co.pageModules.Module_View_Chapter_Details;

public class Navigate_Revision_From_Topic_Listing extends BaseClass {
	
	public Navigate_Revision_From_Topic_Listing() {
		super();
	}

	@Test
	public void Verify_Review_Plan_Tab() throws Exception {
		
		Module_Navigate_Revision_From_Topic_Listing MRMQP = new Module_Navigate_Revision_From_Topic_Listing();
		MRMQP.Verify_Navigate_Revision_From_Topic_Listing();
	}

}
