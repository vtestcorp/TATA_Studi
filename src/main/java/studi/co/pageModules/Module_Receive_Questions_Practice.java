package studi.co.pageModules;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	public void Module_Receive_SCQ_Answers_In_Default_State_In_Practice(String subject, String topic)
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
						sAss.assertFalse(Boolean.parseBoolean(getElementAttribute(mobileElement, "checked")));
						System.out.println("Answer " + c++ + "  is unchecked as default");
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

	public void Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice(String subject, String topic)
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

				if (ansCount != 0 && flag == 1) {
					sAss.assertTrue(ansCount >= 2 ? true : false);
					System.out.println("Multiple answers available for question " + (i + 1));
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

	public void Module_Verify_SCQ_Answer_Can_Be_Slect_In_Practice(String subject, String topic)
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
		// scrollTo1("Practice again");
		clickOnElement(findElementByText("Begin Practice"));
		// clickOnElement(findElementByText("Practice again"));
		Thread.sleep(3000);
		clickOnElement(RMQP.click_begin_practice_button);
		// clickOnElement(findElementByText("Practice again"));
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		int i = 0;
		int ansFlag = 0;
		normal: while (i < questions) {
			try {
				Thread.sleep(2000);
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();

				System.out.println("answerCont = " + ansCount);
				ansFlag = 1;
				int c = 1;
				if (ansCount != 0) {
					for (MobileElement mobileElement : answerCount) {
						applyImplicitWait(5);
						try {
							mobileElement.click();
							applyExplicitWait(1);
							mobileElement.click();
						} catch (Exception e) {
							ansFlag = 0;
						}
						if (ansFlag != 0)
							System.out.println(c++ + " can be select or unselect");
						applyExplicitWait(1);
					}
					sAss.assertTrue(ansFlag != 0 ? true : false);
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					System.out.println("Answer count " + ansCount);
					flag = 1;
				} else if (ansCount == 0 && flag == 0) {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
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
		sAss.assertAll();

	}

	public void Module_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Practice(String subject, String topic)
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
		// scrollTo1("Practice again");
		clickOnElement(findElementByText("Begin Practice"));
		// clickOnElement(findElementByText("Practice again"));
		Thread.sleep(3000);
		clickOnElement(RMQP.click_begin_practice_button);
		// clickOnElement(findElementByText("Practice again"));
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		int i = 0;
		int ansFlag = 0;
		Boolean prvsElement;
		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				applyExplicitWait(5);
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();

				System.out.println("answerCont = " + ansCount);
				prvsElement = true;
				int c = 1;
				if (ansCount != 0 && flag == 1) {
					for (MobileElement mobileElement : answerCount) {
						applyImplicitWait(5);
						mobileElement.click();

						prvsElement = Boolean.parseBoolean(getElementAttribute(mobileElement, "focused"));
						if (prvsElement == false)
							mobileElement.click();

						System.out.println("Answer " + c++ + "  is selected");
						ansFlag = 0;
						for (MobileElement mobileElement2 : answerCount) {
							applyImplicitWait(5);
							if (getElementAttribute(mobileElement2, "focused").equalsIgnoreCase("true")) {
								ansFlag++;
								System.out.println((c - 1) + "  " + ansFlag);
							}
						}

						sAss.assertTrue(ansFlag == 1 ? true : false);
						applyExplicitWait(1);
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

		sAss.assertAll();

	}

	public void Module_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(String subject,
			String topic) throws MalformedURLException, InterruptedException {
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
		// scrollTo1("Practice again");
		clickOnElement(findElementByText("Begin Practice"));
		// clickOnElement(findElementByText("Practice again"));
		Thread.sleep(3000);
		clickOnElement(RMQP.click_begin_practice_button);
		// clickOnElement(findElementByText("Practice again"));
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
					obp.selectCorrectOption(i + 1);
					clickOnElement(obp.check_answer);
					sAss.assertTrue(obp.answerCorrectMsg.isDisplayed());
					if (obp.answerCorrectMsg.isDisplayed())
						System.out.println("Shown correct feedback");
					ansCount = 0;
					if (++i < questions)
						clickOnElement(obp.conti_nue);

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

	public void Module_Verify_Correct_Incorrect_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(String subject,
			String topic) throws MalformedURLException, InterruptedException {
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
		// scrollTo1("Practice again");
		clickOnElement(findElementByText("Begin Practice"));
		// clickOnElement(findElementByText("Practice again"));
		Thread.sleep(3000);
		clickOnElement(RMQP.click_begin_practice_button);
		// clickOnElement(findElementByText("Practice again"));
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

					obp.selectWrongOption(i + 1);
					clickOnElement(obp.check_answer);
					sAss.assertTrue(findElementByText("Uh-oh! Give it another shot!").isDisplayed());
					if (findElementByText("Uh-oh! Give it another shot!").isDisplayed())
						System.out.println("Shown correct feedback for incorrect answer");

					clickOnElement(findElementByText("TRY AGAIN"));

					getDriver().findElementById("com.tce.studi:id/tvQuestionPosition").click();

					obp.selectCorrectOption(i + 1);
					clickOnElement(obp.check_answer);
					sAss.assertTrue(obp.answerCorrectMsg.isDisplayed());
					if (obp.answerCorrectMsg.isDisplayed())
						System.out.println("Shown correct feedback for correct answer");
					ansCount = 0;
					if (++i < questions)
						clickOnElement(obp.conti_nue);

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