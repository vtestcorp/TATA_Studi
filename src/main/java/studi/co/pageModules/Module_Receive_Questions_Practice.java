package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Begin_Practice;
import studi.co.pageObjects.Object_Receive_Questions_Practice;

public class Module_Receive_Questions_Practice extends BaseClass {
	Object_Receive_Questions_Practice RMQP = new Object_Receive_Questions_Practice();
	Object_Begin_Practice obp = new Object_Begin_Practice();

	public void Module_Receive_SCQ_Questions_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		RMQP.select_syllabus.click();
		applyExplicitWait(1);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(1);
		System.out.println(subject);
		applyExplicitWait(5);
		scrollTo1(topic);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(2);
		System.out.println(topic);
		scrollTo1("Begin Practice");
		clickOnElement(findElementByText("Begin Practice"));
		Thread.sleep(3000);
		clickOnElement(RMQP.click_begin_practice_button);
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		int i = 0;
		int queFlag = 0;
		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				applyExplicitWait(5);
				queFlag = 0;
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				obp.question.isDisplayed();
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;
				int c = 1;
				if (ansCount != 0 && flag == 1) {
					for (MobileElement mobileElement : answerCount) {
						sAss.assertTrue(mobileElement.isDisplayed());
						System.out.println("Answer " + c++ + "  displayed");
					}
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					System.out.println("Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					System.out.println("Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		sAss.assertAll();
	}

	public void Module_Receive_SCQ_Answers_In_Default_State_In_Practice(String subject, String topic) throws MalformedURLException, InterruptedException {
		RMQP.select_syllabus.click();
		applyExplicitWait(1);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(1);
		System.out.println(subject);
		applyExplicitWait(5);
		scrollTo1(topic);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(2);
		System.out.println(topic);
		scrollTo1("Begin Practice");
		clickOnElement(findElementByText("Begin Practice"));
		Thread.sleep(3000);
		clickOnElement(RMQP.click_begin_practice_button);
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		int i = 0;
		int queFlag = 0;
		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				applyExplicitWait(5);
				queFlag = 0;
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				obp.question.isDisplayed();
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;
				int c = 1;
				if (ansCount != 0 && flag == 1) {
					for (MobileElement mobileElement : answerCount) {
						sAss.assertFalse(Boolean.parseBoolean(getElementAttribute(mobileElement, "checked")));
						System.out.println("Answer " + c++ + "  displayed");
					}
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					System.out.println("Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					System.out.println("Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		sAss.assertAll();
			
	}

	public void Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice(String subject, String topic) throws MalformedURLException, InterruptedException {
		RMQP.select_syllabus.click();
		applyExplicitWait(1);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(1);
		System.out.println(subject);
		applyExplicitWait(5);
		scrollTo1(topic);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(2);
		System.out.println(topic);
		scrollTo1("Begin Practice");
		clickOnElement(findElementByText("Begin Practice"));
		Thread.sleep(3000);
		clickOnElement(RMQP.click_begin_practice_button);
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		int i = 0;
		int queFlag = 0;
		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				applyExplicitWait(5);
				queFlag = 0;
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				obp.question.isDisplayed();
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;
				
				if (ansCount != 0 && flag == 1) {
					
						sAss.assertTrue(ansCount>=2?true:false);
						
					
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					System.out.println("Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					System.out.println("Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		sAss.assertAll();
		
	}

	public void Module_Verify_SCQ_Answer_Can_Be_Slect_In_Practice(String subject, String topic) throws MalformedURLException, InterruptedException {
		RMQP.select_syllabus.click();
		applyExplicitWait(1);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(1);
		System.out.println(subject);
		applyExplicitWait(5);
		scrollTo1(topic);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(2);
		System.out.println(topic);
		scrollTo1("Begin Practice");
		clickOnElement(findElementByText("Begin Practice"));
		Thread.sleep(3000);
		clickOnElement(RMQP.click_begin_practice_button);
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		int i = 0;
		int queFlag = 0;
		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				applyExplicitWait(5);
				queFlag = 0;
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				obp.question.isDisplayed();
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;
				
				if (ansCount != 0 && flag == 1) {
					obp.selectCorrectOption(i+1);
					clickOnElement(obp.check_answer);
					sAss.assertTrue(obp.answerCorrectMsg.isDisplayed());
							
					ansCount = 0;
					clickOnElement(obp.conti_nue);
					i++;
				} else if (ansCount != 0) {
					System.out.println("Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					System.out.println("Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		sAss.assertAll();
		
		
	}
}
