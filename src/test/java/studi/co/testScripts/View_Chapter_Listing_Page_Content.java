package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_View_Chapter_Details;

public class View_Chapter_Listing_Page_Content extends BaseClass{
	
	public View_Chapter_Listing_Page_Content() {
		super();
	}

	@Test
	public void Verify_Review_Plan_Tab() throws Exception {
		
		Module_View_Chapter_Details MRMQP = new Module_View_Chapter_Details();
		MRMQP.Verify_View_Chapter_Details();
	}

}
