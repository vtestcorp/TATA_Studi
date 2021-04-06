package studi.co.pageModules;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;

import studi.co.Base.BaseClass;

import studi.co.pageObjects.Object_Receive_Subjective_Questions_Revision;

public class Model_Receive_Subjective_Questions_Revision extends BaseClass {
	Object_Receive_Subjective_Questions_Revision RMSQR = new Object_Receive_Subjective_Questions_Revision();


	private void pauseVideo() throws MalformedURLException, InterruptedException {
		applyExplicitWaitsUntilElementVisible(driver.findElement(By.xpath(
				"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]")));
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(RMSQR.addNotesBtn);
		driver.findElement(By.xpath(
				"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
		.click();
		// applyExplicitWait(2);
		RMSQR.pauseBtn.click();
	}

	public void traverse_To_Begin_Revision(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		applyExplicitWaitsUntilElementClickable(RMSQR.testUnit);
		//Thread.sleep(2000);
		swipeUp();
		clickOnElement(RMSQR.syllabus);
		test.log(Status.INFO, "Opening Syllabus tab");
		System.out.println("Opening Syllabus tab");
		applyExplicitWait(5);

		scrollTo2(subject);

		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		clickOnElement(findElementByText(subject));

		scrollTo2(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		clickOnElement(findElementByText(topic));

		scrollTo2("Practice");
		test.log(Status.INFO, "Opening revision for " + topic);
		System.out.println("Opening revision for " + topic);
		swipeUp();

		try {
			applyExplicitWaitsUntilElementClickable(findElementByText("Revision"));
			clickOnElement(findElementByText("Revision"));
		} catch (Exception e) {
			applyExplicitWaitsUntilElementClickable(findElementByText("Revise"));
			clickOnElement(findElementByText("Revise"));
		}

		Thread.sleep(3000);

		try {
			clickOnElement(findElementByText("Revision"));
		} catch (Exception e) {
			clickOnElement(findElementByText("Revise"));
		}
	}


	@SuppressWarnings("unused")
	public void Module_Receive_Subjective_Questions_Revision(String subject, String topic)
			throws WebDriverException, IOException, InterruptedException {

		traverse_To_Begin_Revision(subject, topic);
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");

		pauseVideo();
		forwardVideoTimerToEnd();
		applyExplicitWait(15);

		int questions = getTotalQuestionsInPractice();
		test.log(Status.INFO, "Total questions : " + questions);
		int actualcount = 0;
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		applyExplicitWaitsUntilElementVisible(RMSQR.question);
		normal: while (i < questions) {
			Thread.sleep(200);

			test.log(Status.INFO, "Question " + (i + 1));
			System.out.println("Question " + (i + 1));

			if (verifySCQorMCQ().equalsIgnoreCase("subjective")) {
				applyExplicitWait(5);
				actualcount++;
				swipeUp();
				//Verify that question text along with "show answer" button should be available and functional




			}

			if (i + 1 != questions)
				clickOnElement(RMSQR.nextButton);
			i++;
		}
		test.log(Status.INFO, "Total " + actualcount + " Subjective questions are displayed");
		System.out.println("Total " + actualcount + " Subjectivequestions are displayed");
		applyExplicitWait(2);
		sAss.assertAll();
	}



	//To verify that user should be able to attempt the subjective type question









}




