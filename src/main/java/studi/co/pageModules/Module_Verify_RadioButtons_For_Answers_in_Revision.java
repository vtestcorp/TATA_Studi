package studi.co.pageModules;

import java.net.MalformedURLException;

import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import studi.co.Base.Keyword;
import studi.co.pageObjects.Object_Browse_Books;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Revision;
import studi.co.pageObjects.Object_Subject_Geography;

public class Module_Verify_RadioButtons_For_Answers_in_Revision extends Object_Receive_MCQ_Questions_Revision {

	public Module_Verify_RadioButtons_For_Answers_in_Revision() {
		super(); 
	}
	public void verify_RadioButton() throws MalformedURLException, InterruptedException {
		Object_Browse_Books obb=new Object_Browse_Books(); 
		Object_Receive_MCQ_Questions_Revision orm= new Object_Receive_MCQ_Questions_Revision(); 
		Object_Subject_Geography osg= new Object_Subject_Geography(); 
		
		Keyword.applyExplicitWaitsUntilElementClickable(obb.syllabus);
		
		Keyword.clickOnElement(obb.syllabus);
		
		Keyword.applyExplicitWaitsUntilElementClickable(osg.subject_Geography);
		
		Keyword.applyExplicitWaitsUntilElementClickable(orm.select_topic_from_chapter); 
		
		Keyword.clickOnElement(orm.select_topic_from_chapter);
		
		Keyword.applyExplicitWaitsUntilElementClickable(orm.select_Begin_Revision); 
		
		Keyword.clickOnElement(orm.select_Begin_Revision); 
		
		Keyword.applyExplicitWaitsUntilElementClickable(orm.click_Begin_Revision);
		
		Keyword.clickOnElement(orm.click_Begin_Revision);
		
		Keyword.applyExplicitWait(15);
		
		Keyword.handleVideoWait(orm.img_OverviewPg_screen, orm.img_OverviewPg_screen_time);
		
		Keyword.applyExplicitWait(10);
		
		Keyword.applyExplicitWaitsUntilElementVisible(orm.select_1st_Choice);
		
		//Verify if the questions are displayed
		String attributeValue =Keyword.getElementAttribute(orm.select_1st_Choice, "attribute");
		System.out.println(attributeValue);
		Boolean result=attributeValue.equalsIgnoreCase(""); 
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(result);
		
		Keyword.scrollTo1("CHECK ANSWER");
		Keyword.applyExplicitWait(5);
		System.out.println("Scrolled Successfully");
		
		String is1stAnswerDisplayed=Keyword.getElementAttribute(orm.select_1st_Choice, "attribute");
		Keyword.applyExplicitWait(2);
		String is2ndAnswerDisplayed=Keyword.getElementAttribute(orm.select_2nd_Choice, "attribute");
		Keyword.applyExplicitWait(2);
		String is3rdAnswerDisplayed=Keyword.getElementAttribute(orm.select_3rd_Choice, "attribute");
		Keyword.applyExplicitWait(2);
		String is4thAnswerDisplayed=Keyword.getElementAttribute(orm.select_4th_Choice, "attribute");
		Keyword.applyExplicitWait(2);
		
		boolean isRadioPresentAnswer1=is1stAnswerDisplayed.equalsIgnoreCase("attribute");
		boolean isRadioPresentAnswer2=is2ndAnswerDisplayed.equalsIgnoreCase("attribute"); 
		boolean isRadioPresentAnswer3=is3rdAnswerDisplayed.equalsIgnoreCase("attribute"); 
		boolean isRadioPresentAnswer4=is4thAnswerDisplayed.equalsIgnoreCase("attribute"); 
		
		softassert.assertTrue(isRadioPresentAnswer1, "Boolean result for Radio Button for Answer Option Number 1");
		softassert.assertTrue(isRadioPresentAnswer2, "Boolean result for Radio Button for Answer Option Number 2");
		softassert.assertTrue(isRadioPresentAnswer3, "Boolean result for Radio Button for Answer Option Number 3");
		softassert.assertTrue(isRadioPresentAnswer4, "Boolean result for Radio Button for Answer Option Number 4");
		
		//Clicking on Answer Option 1 and getting its property
		Keyword.clickOnElement(orm.select_1st_Choice); 
		Keyword.applyExplicitWait(2);
		String valueFor1AnswerAfterClick=Keyword.getElementAttribute(orm.select_1st_Choice, "Selected"); 
		
		//Clicking on Answer Option 1 and getting the its property
		
		//Unclicking on Answer Option 1 and then after getting its property
		Keyword.clickOnElement(orm.select_1st_Choice);
		Keyword.applyExplicitWait(2);
		String valueFor1AnswerAfterUnclick=Keyword.getElementAttribute(orm.select_1st_Choice, "Selected"); 
		
		boolean compareattributebeforeandAfterclick=valueFor1AnswerAfterClick.equalsIgnoreCase(valueFor1AnswerAfterUnclick);
		softassert.assertFalse(compareattributebeforeandAfterclick);
		
		softassert.assertAll();
		
	}
}