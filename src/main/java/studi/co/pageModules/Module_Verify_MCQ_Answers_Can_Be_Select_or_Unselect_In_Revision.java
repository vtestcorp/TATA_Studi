package studi.co.pageModules;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Practice;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Revision;

public class Module_Verify_MCQ_Answers_Can_Be_Select_or_Unselect_In_Revision extends BaseClass {
	
	public void Verify_MCQ_Answers_Can_Be_Select_or_Unselect_In_Revision() throws WebDriverException, IOException, InterruptedException
	{
	Object_Receive_MCQ_Questions_Practice RMQP = new Object_Receive_MCQ_Questions_Practice();
	Object_Receive_MCQ_Questions_Revision RMQP1 = new Object_Receive_MCQ_Questions_Revision();
	RMQP.select_syllabus.click();
	applyExplicitWait(1);
	RMQP.select_subject.click();
	applyExplicitWait(1);
	System.out.println("Subject - Geography - Geography Grade 6 is shown");
	RMQP1.select_topic_from_chapter.click();
	applyExplicitWait(2);
	System.out.println("Selected Topic");
	RMQP1.select_Begin_Revision.click();
	applyExplicitWait(20);
	RMQP1.click_Begin_Revision.click();
	applyExplicitWait(2);

	System.out.println("Video started");
	forwardVideoTimerToEnd();
	applyExplicitWait(15);
	
	List<MobileElement> questions = getDriver().findElementsByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView");
	System.out.println("Total questions : " + questions.size());
	int flag = 0;
	int i = 0;

	normal: while (i < questions.size()) {
		try {
			applyExplicitWait(2);
			if (flag == 1) {
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount= answerCount.size();
				clickOnElement(RMQP1.select_1st_Choice);
				System.out.println("1st option selected");
				if (--ansCount!=0) {
					clickOnElement(RMQP1.select_2nd_Choice);
					System.out.println("2nd option selected");
				} 
				if (--ansCount!=0) {
					clickOnElement(RMQP1.select_3rd_Choice);
					System.out.println("3rd option selected");
				}
				if (--ansCount!=0) {
					clickOnElement(RMQP1.select_4th_Choice);
					System.out.println("4th option selected");
				}
				clickOnElement(RMQP1.nextButton);
				i++;
			}
			if (flag == 0) {
				clickOnElement(RMQP1.checkAnswer);
				clickOnElement(RMQP1.nextButton);
				i++;
			}
		} catch (Exception e) {
			System.out.println("Exception occured");
			if (flag == 1) {
				flag = 0;
				System.out.println("Flag set to 0");
				continue normal;
			} else {
				flag = 1;
				System.out.println("Flag set to 1");
				continue normal;
			}

		}
	}
	applyExplicitWait(2);
	Assert.assertTrue(RMQP1.letsSummriseTxt.isDisplayed());
	}
	
}
