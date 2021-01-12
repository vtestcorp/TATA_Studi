package studi.co.pageModules;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.ss.util.ImageUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Receive_Questions_Practice;
import studi.co.pageObjects.Object_Receive_Questions_Revision;

public class Module_Receive_Questions_Revision extends BaseClass {
	Object_Receive_Questions_Revision RMQR = new Object_Receive_Questions_Revision();

	public void traverse_To_Begin_Revision(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		clickOnElement(RMQR.testUnit);
		test.log(Status.INFO, "Open Test Unit");
		applyExplicitWait(5);
		Thread.sleep(1000);
		test.log(Status.INFO, topic);
		scrollTo1("Revise");
		clickOnElement(findElementByText("Revise"));
		test.log(Status.INFO, "Opening Revision in Test Unit");
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Revision"));
	}

	public void Module_Receive_SCQ_Questions_Revision(String subject, String topic)
			throws WebDriverException, IOException, InterruptedException {

		RMQR.select_syllabus.click();
		applyExplicitWait(1);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(1);
		test.log(Status.INFO, prop.getProperty("subject"));
		scrollTo1(topic);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(2);
		test.log(Status.INFO, prop.getProperty("topic"));
		RMQR.select_Begin_Revision.click();
		Thread.sleep(3000);
		RMQR.click_Begin_Revision.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		forwardVideoTimerToEnd();
		applyExplicitWait(15);

		List<MobileElement> questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions.size());
		int actualcount = 0;
		int flag = 1;
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		normal: while (i < questions.size()) {
			try {
				// String base64FormatOfImageFromImage =
				// getBase64StringFormatOfImage(getReferenceImageB64("C:\\Users\\Dell\\Desktop"));
				// MobileElement iconButton =
				// getDriver().findElementByImage(base64FormatOfImageFromImage);
				// if(iconButton.isDisplayed())
				// test.log(Status.INFO,"SCQ
				// Question...............................................");
				applyExplicitWait(5);

				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();

				test.log(Status.INFO, "answerCont = " + ansCount);
				if (ansCount == 0) {
					flag = 1;
					clickOnElement(RMQR.nextButton);
					i++;
				} else if (flag == 1) {
					RMQR.select_1st_Choice.isDisplayed();
					actualcount++;
					test.log(Status.INFO, "1st answer is visible");
					if (--ansCount > 0) {
						test.log(Status.INFO, "answerCont = " + ansCount);
						sAss.assertTrue(RMQR.select_2nd_Choice.isDisplayed());
						test.log(Status.INFO, "2nd answer is visible");

					}
					if (--ansCount > 0) {
						test.log(Status.INFO, "answerCont = " + ansCount);
						sAss.assertTrue(RMQR.select_3rd_Choice.isDisplayed());
						test.log(Status.INFO, "3rd answer is visible");

					}
					if (--ansCount > 0) {
						test.log(Status.INFO, "answerCont = " + ansCount);
						sAss.assertTrue(RMQR.select_4th_Choice.isDisplayed());
						test.log(Status.INFO, "4th answer is visible");
					}
					if (--ansCount > 0) {
						sAss.assertTrue(RMQR.select_5th_Choice.isDisplayed());
						test.log(Status.INFO, "5th answer is visible");
					}
					clickOnElement(RMQR.nextButton);
					i++;
				} else if (flag == 0) {
					clickOnElement(RMQR.checkAnswer);
					clickOnElement(RMQR.nextButton);
					i++;
				}
			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (flag == 1) {
					flag = 0;
					test.log(Status.INFO, "Flag set to 0");
					continue normal;
				} else {
					flag = 1;
					test.log(Status.INFO, "Flag set to 1");
					continue normal;
				}

			}
		}
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		applyExplicitWait(2);
		sAss.assertAll();
	}

	public void Module_Receive_SCQ_Questions_Default_State_In_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		RMQR.select_syllabus.click();
		applyExplicitWait(1);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(1);
		scrollTo1(topic);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);
		test.log(Status.INFO, "Selected Topic");
		scrollTo1("Begin Revision");
		clickOnElement(findElementByText("Begin Revision"));
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Revision"));
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		forwardVideoTimerToEnd();
		applyExplicitWait(15);

		List<MobileElement> questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions.size());
		int flag = 1;
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		normal: while (i < questions.size()) {
			try {
				applyExplicitWait(5);

				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();

				test.log(Status.INFO, "answerCont = " + ansCount);
				if (ansCount == 0) {
					flag = 1;
					clickOnElement(RMQR.nextButton);
					i++;
				} else if (flag == 1) {
					if (flag == 1) {
						RMQR.select_1st_Choice.isDisplayed();
						actualcount++;
						test.log(Status.INFO, getElementAttribute(RMQR.select_1st_Choice, "focused"));
						if (getElementAttribute(RMQR.select_1st_Choice, "focused").trim().equalsIgnoreCase("false")) {
							sAss.assertTrue(true);
							test.log(Status.INFO, "1st answer is in default state");
						} else
							sAss.assertTrue(false);
						if (--ansCount > 0) {
							if (getElementAttribute(RMQR.select_2nd_Choice, "focused").trim()
									.equalsIgnoreCase("false")) {
								sAss.assertTrue(true);
								test.log(Status.INFO, "2nd answer is in default state");
							} else
								sAss.assertTrue(false);
						}
						if (--ansCount > 0) {
							if (getElementAttribute(RMQR.select_3rd_Choice, "focused").trim()
									.equalsIgnoreCase("false")) {
								sAss.assertTrue(true);
								test.log(Status.INFO, "3rd answer is in default state");
							} else
								sAss.assertTrue(false);
						}
						if (--ansCount > 0) {
							if (getElementAttribute(RMQR.select_4th_Choice, "focused").trim()
									.equalsIgnoreCase("false")) {
								sAss.assertTrue(true);
								test.log(Status.INFO, "4th answer is in default state");
							} else
								sAss.assertTrue(false);
						}
						if (--ansCount > 0) {
							if (getElementAttribute(RMQR.select_5th_Choice, "focused").trim()
									.equalsIgnoreCase("false")) {
								sAss.assertTrue(true);
								test.log(Status.INFO, "5th answer is in default state");

							} else
								sAss.assertTrue(false);
						}
						clickOnElement(RMQR.nextButton);
						i++;
					}
				} else if (flag == 0) {
					clickOnElement(RMQR.checkAnswer);
					clickOnElement(RMQR.nextButton);
					i++;
				}
			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (flag == 1) {
					flag = 0;
					test.log(Status.INFO, "Flag set to 0");
					continue normal;
				} else {
					flag = 1;
					test.log(Status.INFO, "Flag set to 1");
					continue normal;
				}

			}
		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();
	}

	public void Module_Receive_SCQ_Questions_Answer_Can_Be_Select_In_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		RMQR.select_syllabus.click();
		applyExplicitWait(1);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(1);
		scrollTo1(topic);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);
		test.log(Status.INFO, "Selected Topic");
		scrollTo1("Begin Revision");
		clickOnElement(findElementByText("Begin Revision"));
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Revision"));
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		forwardVideoTimerToEnd();
		applyExplicitWait(15);

		List<MobileElement> questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions.size());
		int flag = 1;
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		normal: while (i < questions.size()) {
			try {
				applyExplicitWait(5);

				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();

				test.log(Status.INFO, "answerCont = " + ansCount);
				if (flag == 1) {
					if (flag == 1) {
						RMQR.select_1st_Choice.isDisplayed();
						actualcount++;

						clickOnElement(RMQR.select_1st_Choice);
						test.log(Status.INFO, "1st answer can be select");
						if (--ansCount > 0) {
							clickOnElement(RMQR.select_2nd_Choice);
							sAss.assertTrue(
									Boolean.parseBoolean(getElementAttribute(RMQR.select_2nd_Choice, "checked")));
							test.log(Status.INFO, "2nd answer can be select");
						}
						if (--ansCount > 0) {
							clickOnElement(RMQR.select_3rd_Choice);
							sAss.assertTrue(
									Boolean.parseBoolean(getElementAttribute(RMQR.select_3rd_Choice, "checked")));
							test.log(Status.INFO, "3rd answer can be select");
						}
						if (--ansCount > 0) {
							clickOnElement(RMQR.select_4th_Choice);
							sAss.assertTrue(
									Boolean.parseBoolean(getElementAttribute(RMQR.select_4th_Choice, "checked")));
							test.log(Status.INFO, "4th answer can be select");
						}
						if (--ansCount > 0) {
							clickOnElement(RMQR.select_5th_Choice);
							sAss.assertTrue(
									Boolean.parseBoolean(getElementAttribute(RMQR.select_5th_Choice, "checked")));
							test.log(Status.INFO, "5th answer can be select");

						}
						clickOnElement(RMQR.nextButton);
						i++;
					}
				} else if (flag == 0) {
					clickOnElement(RMQR.checkAnswer);
					test.log(Status.INFO, "Answer can be verified as designed");
					clickOnElement(RMQR.nextButton);
					i++;
				}
			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (flag == 1) {
					flag = 0;
					test.log(Status.INFO, "Flag set to 0");
					continue normal;
				} else {
					flag = 1;
					test.log(Status.INFO, "Flag set to 1");
					continue normal;
				}

			}
		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();
	}

	public void Single_Answer_Is_Correct_For_SCQ_Question_In_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {

		RMQR.select_syllabus.click();
		applyExplicitWait(1);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(1);
		scrollTo1(topic);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);
		test.log(Status.INFO, "Selected Topic");
		scrollTo1("Begin Revision");
		clickOnElement(findElementByText("Begin Revision"));
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Revision"));
		applyExplicitWait(5);
		test.log(Status.INFO, "Video started");
		forwardVideoTimerToEnd();
		applyExplicitWait(15);

		List<MobileElement> questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions.size());
		int flag = 1;
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		int actualcount = 0;
		int correctAnswer;
		normal: while (i < questions.size()) {
			try {
				applyExplicitWait(5);

				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();

				test.log(Status.INFO, "answerCont = " + ansCount);
				if (flag == 1) {
					if (flag == 1) {
						correctAnswer = 0;
						RMQR.select_1st_Choice.isDisplayed();
						actualcount++;
						String ans1 = getElementAttribute(RMQR.select_1st_Choice, "text");
						clickOnElement(RMQR.select_1st_Choice);
						test.log(Status.INFO, "1st selected");

						test.log(Status.INFO, ans1 + " " + findElementByText(ans1).getCssValue("color"));

						if (getElementAttribute(RMQR.select_1st_Choice, "focused").trim().equalsIgnoreCase("true"))
							;
						{
							test.log(Status.INFO, getElementAttribute(RMQR.select_1st_Choice, "focused"));
							correctAnswer++;
						}
						if (--ansCount > 0) {
							clickOnElement(RMQR.select_2nd_Choice);
							test.log(Status.INFO, "2nd answer can be select");

							if (getElementAttribute(RMQR.select_2nd_Choice, "focused").trim().equalsIgnoreCase("true"))
								;
							{
								test.log(Status.INFO, getElementAttribute(RMQR.select_2nd_Choice, "focused"));
								correctAnswer++;
							}
						}
						if (--ansCount > 0) {
							clickOnElement(RMQR.select_3rd_Choice);
							test.log(Status.INFO, "3rd answer can be select");

							if (getElementAttribute(RMQR.select_3rd_Choice, "focused").trim().equalsIgnoreCase("true"))
								;
							{
								test.log(Status.INFO, getElementAttribute(RMQR.select_3rd_Choice, "focused"));
								correctAnswer++;
							}
						}
						if (--ansCount > 0) {
							clickOnElement(RMQR.select_4th_Choice);
							test.log(Status.INFO, "4th answer can be select");

							if (getElementAttribute(RMQR.select_4th_Choice, "focused").trim().equalsIgnoreCase("true"))
								;
							{
								test.log(Status.INFO, getElementAttribute(RMQR.select_4th_Choice, "focused"));
								correctAnswer++;
							}
						}
						if (--ansCount > 0) {
							clickOnElement(RMQR.select_5th_Choice);
							test.log(Status.INFO, "5th answer can be select");
							if (getElementAttribute(RMQR.select_5th_Choice, "focused").trim().equalsIgnoreCase("true"))
								;
							{
								test.log(Status.INFO, getElementAttribute(RMQR.select_5th_Choice, "focused"));
								correctAnswer++;
							}

						}
						if (correctAnswer == 1)
							sAss.assertTrue(true);
						else
							sAss.assertTrue(false);
						clickOnElement(RMQR.nextButton);
						i++;
					}
				} else if (flag == 0) {
					clickOnElement(RMQR.checkAnswer);
					test.log(Status.INFO, "Answer can be verified as designed");
					clickOnElement(RMQR.nextButton);
					i++;
				}
			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (flag == 1) {
					flag = 0;
					test.log(Status.INFO, "Flag set to 0");
					continue normal;
				} else {
					flag = 1;
					test.log(Status.INFO, "Flag set to 1");
					continue normal;
				}

			}
		}
		applyExplicitWait(2);
		test.log(Status.INFO, "Total " + actualcount + " SCQ questions are displayed");
		sAss.assertAll();
	}

	public void Module_Verify_Attempting_Quiz_Is_Not_Mandatory_In_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		traverse_To_Begin_Revision(subject, topic);
		test.log(Status.INFO, "Video started");
		forwardVideoTimerToEnd();
		applyExplicitWait(15);

		List<MobileElement> questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions.size());
		int flag = 1;
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		normal: while (i < questions.size()) {
			try {
				Thread.sleep(1000);
				new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(RMQR.question));
				test.log(Status.INFO, "Question " + (i + 1));
				applyExplicitWait(5);
				flag = 1;
				test.log(Status.INFO, "Click on Next");
				clickOnElement(RMQR.nextButton);
				i++;

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (flag == 1) {
					flag = 0;
					// test.log(Status.INFO, "Flag set to 0");
					continue normal;
				} else {
					flag = 1;
					// test.log(Status.INFO, "Flag set to 1");
					continue normal;
				}

			}
		}
		applyExplicitWait(5);
		test.log(Status.INFO, "Revision ended without attemting any question");
		sAss.assertAll();
	}

	public void Module_Verify_User_Can_Abandon_Quiz_In_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		traverse_To_Begin_Revision(subject, topic);
		test.log(Status.INFO, "Video started");
		forwardVideoTimerToEnd();
		applyExplicitWait(15);

		List<MobileElement> questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions.size());
		int flag = 1;
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(RMQR.question));
		clickOnElement(RMQR.backBtn);
		test.log(Status.INFO, "Clicked on Back Button");
		clickOnElement(RMQR.submitTestPopup);
		test.log(Status.INFO, "Ending Test");
		
		
		applyExplicitWait(5);
		sAss.assertTrue(findElementByText("Begin Revision").isEnabled());
		test.log(Status.INFO, "revision aboanded succesfully");
		sAss.assertAll();

	}

	public void Module_Receive_MCQ_Questions_Revision(String subject, String topic) throws InterruptedException, WebDriverException, IOException {
		traverse_To_Begin_Revision(subject, topic);
		test.log(Status.INFO, "Video started");
		System.out.println("Video started");
		forwardVideoTimerToEnd();
		applyExplicitWait(15);

		List<MobileElement> questions = RMQR.get_Total_Number_Of_Questions_InRevision();
		test.log(Status.INFO, "Total questions : " + questions.size());
		int flag = 1;
		int i = 0;
		SoftAssert sAss = new SoftAssert();
		normal: while (i < questions.size()) {
			try {
				Thread.sleep(1000);
				new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(RMQR.question));
				sAss.assertTrue(RMQR.question.isDisplayed());
				test.log(Status.INFO, "Question " + (i + 1)+" Visible");
				
				applyExplicitWait(5);
				flag = 1;
				test.log(Status.INFO, "Click on Next");
				clickOnElement(RMQR.nextButton);
				i++;

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (flag == 1) {
					flag = 0;
					// test.log(Status.INFO, "Flag set to 0");
					continue normal;
				} else {
					flag = 1;
					// test.log(Status.INFO, "Flag set to 1");
					continue normal;
				}

			}
		}
		applyExplicitWait(5);
		
		sAss.assertAll();
		
	}
}
