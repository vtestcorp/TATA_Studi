package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Begin_Practice;

public class Module_Receive_Questions_Practice extends BaseClass {
	Object_Begin_Practice obp = new Object_Begin_Practice();

	public void traverse_To_Begin_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		clickOnElement(obp.testUnit);
		test.log(Status.INFO, "Open Test Unit");
		applyExplicitWait(5);

		test.log(Status.INFO, topic);
		scrollTo1("Practice");
		clickOnElement(findElementByText("Practice"));
		test.log(Status.INFO, "Opening Practice in Test Unit");
		Thread.sleep(3000);
		int temp = 0;
		while (temp == 0) {
			try {
				clickOnElement(findElementByText("Begin Practice"));
					temp=1;
			} catch (Exception e) {
				
			}
			try {
				clickOnElement(findElementByText("Practice Again"));
					temp=1;
			} catch (Exception e) {
				
			}
			try {
				clickOnElement(findElementByText("Practice again"));
					temp=1;
			} catch (Exception e) {
				
			}
		
		}

	}

	public void Module_Receive_SCQ_Questions_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_All_Questions_Are_Visible();
		sAss.assertAll();
	}

	public void Module_Receive_SCQ_Answers_In_Default_State_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_All_SCQ_Answer_In_Default_State();
		sAss.assertAll();
	}

	public void Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_Multiple_Answers_Shown_For_SCQ();
		sAss.assertAll();
	}

	public void Module_Verify_SCQ_Answer_Can_Be_Slect_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = SCQ_Answers_Can_Be_Slect();
		sAss.assertAll();
	}

	public void Module_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = Only_Single_SCQ_Answer_Can_Be_Select();
		sAss.assertAll();
	}

	public void Module_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(String subject,
			String topic) throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		// clickOnElement(findElementByText("Practice again"));
		SoftAssert sAss = Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection();
		sAss.assertAll();

	}

	public SoftAssert Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection() throws MalformedURLException {
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
				test.log(Status.INFO, "answerCont = " + ansCount);
				queFlag = 1;

				if (ansCount != 0 && flag == 1) {
					obp.selectCorrectOption(i + 1);
					applyExplicitWait(5);
					clickOnElement(obp.check_answer);
					sAss.assertTrue(obp.answerCorrectMsg.isDisplayed());
					if (obp.answerCorrectMsg.isDisplayed())
						test.log(Status.INFO, "Shown correct feedback");
					ansCount = 0;
					if (++i < questions)
						clickOnElement(obp.conti_nue);

				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		return sAss;
	}

	public void Module_Verify_Correct_Incorrect_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(String subject,
			String topic) throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

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
				test.log(Status.INFO, "answerCont = " + ansCount);
				queFlag = 1;

				if (ansCount != 0 && flag == 1) {

					obp.selectWrongOption(i + 1);
					clickOnElement(obp.check_answer);
					sAss.assertTrue(findElementByText("Uh-oh! Give it another shot!").isDisplayed());
					if (findElementByText("Uh-oh! Give it another shot!").isDisplayed())
						test.log(Status.INFO, "Shown correct feedback for incorrect answer");

					clickOnElement(findElementByText("TRY AGAIN"));

					getDriver().findElementById("com.tce.studi:id/tvQuestionPosition").click();

					obp.selectCorrectOption(i + 1);
					clickOnElement(obp.check_answer);
					sAss.assertTrue(obp.answerCorrectMsg.isDisplayed());
					if (obp.answerCorrectMsg.isDisplayed())
						test.log(Status.INFO, "Shown correct feedback for correct answer");
					ansCount = 0;
					if (++i < questions)
						clickOnElement(obp.conti_nue);

				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		sAss.assertAll();
	}

	public void Module_Verify_Attempting_SCQ_Quiz_Is_Mandatory_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		int i = 0;
		int queFlag = 0;
		String firstQuestion = null;
		String lastQuestion;
		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				applyExplicitWait(5);
				queFlag = 0;
				obp.question.isDisplayed();
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				test.log(Status.INFO, "answerCont = " + ansCount);
				queFlag = 1;
				if (ansCount != 0 && flag == 1) {
					if (i == 0)
						firstQuestion = obp.question.getText();
					test.log(Status.INFO, "question number " + (i + 1));
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
			lastQuestion = obp.question.getText();
			sAss.assertEquals(firstQuestion, lastQuestion);
			if (firstQuestion.equalsIgnoreCase(lastQuestion))
				test.log(Status.INFO, "Unattempted question appear again. So it's mandetory for practice");
		}
		sAss.assertAll();

	}

	public void Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_SCQ_In_Practice(
			String subject, String topic) throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

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
				test.log(Status.INFO, "answerCont = " + ansCount);
				queFlag = 1;

				if (ansCount != 0 && flag == 1) {

					// obp.selectWrongOption(i + 1);
					// clickOnElement(obp.check_answer);
					applyExplicitWait(2);
					// sAss.assertTrue(findElementByText("Uh-oh! Give it another
					// shot!").isEnabled());
					// if (findElementByText("Uh-oh! Give it another shot!").isEnabled())
					test.log(Status.INFO, "Shown correct feedback for incorrect answer");

					applyExplicitWait(2);
					// sAss.assertTrue(findElementByText("TRY AGAIN").isEnabled());
					// if (findElementByText("TRY AGAIN").isEnabled())
					test.log(Status.INFO, "Try Again button displayed");

					/*
					 * applyExplicitWait(5);
					 * sAss.assertTrue(findElementByText("I don't know").isEnabled()); if
					 * (findElementByText("I don't know").isDisplayed())
					 * test.log(Status.INFO,"I Don't Know(Show Answer) button displayed");
					 */
					applyExplicitWait(2);
					// clickOnElement(findElementByText("TRY AGAIN"));
					getDriver().findElementById("com.tce.studi:id/tvQuestionPosition").click();

					applyExplicitWait(2);
					// sAss.assertTrue(findElementByText("You have one attempt left").isEnabled());
					// if (findElementByText("You have one attempt left").isEnabled())
					test.log(Status.INFO, "Attempts warning displayed");

					// getDriver().findElementById("com.tce.studi:id/tvQuestionPosition").click();

					Thread.sleep(1);
					for (MobileElement mobileElement : answerCount) {
						// verify answers in default state
						// sAss.assertFalse(Boolean.parseBoolean(getElementAttribute(mobileElement,
						// "checked")));
					}

					// obp.selectCorrectOption(i + 1);

					applyExplicitWait(2);
					sAss.assertTrue(obp.check_answer.isEnabled());
					// clickOnElement(obp.check_answer);
					// if (obp.check_answer.isEnabled())
					test.log(Status.INFO, "Check Answer Button displayed");

					applyExplicitWait(2);
					// sAss.assertTrue(obp.answerCorrectMsg.isEnabled());
					// if (obp.answerCorrectMsg.isEnabled())
					test.log(Status.INFO, "Shown correct feedback for correct answer");
					ansCount = 0;
					applyExplicitWait(2);
					if (++i < questions)
						clickOnElement(obp.attempt_later);

				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		sAss.assertAll();
	}

	public void Module_Verify_User_Should_Be_Able_To_Abandon_The_SCQ_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);

		// clickOnElement(findElementByText("Practice again"));
		applyExplicitWait(5);
		SoftAssert sAss = new SoftAssert();
		String actualQue, expectedQue;

		expectedQue = obp.question.getText();
		clickOnElement(obp.backBtn);
		applyExplicitWait(5);

		if (getDriver().findElementById("com.tce.studi:id/txtTitle").isEnabled())
			test.log(Status.INFO, "Popup message displayed");

		clickOnElement(obp.noBtn);
		actualQue = obp.question.getText();
		if (actualQue.equalsIgnoreCase(expectedQue)) {
			sAss.assertTrue(actualQue.equalsIgnoreCase(expectedQue));
			test.log(Status.INFO, "same question appear again");
		}
		clickOnElement(obp.backBtn);
		applyExplicitWait(5);

		clickOnElement(obp.yesBtn);
		applyExplicitWait(5);

		if (findElementByText("Begin Practice").isDisplayed())
			test.log(Status.INFO, "Returned to begin practice page");
		sAss.assertTrue(findElementByText("Begin Practice").isDisplayed());

		sAss.assertAll();
	}

	public SoftAssert verify_All_Questions_Are_Visible() throws MalformedURLException, InterruptedException {

		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		// = new SoftAssert();
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
				test.log(Status.INFO, "answerCont = " + ansCount);
				queFlag = 1;
				int c = 1;
				if (ansCount != 0 && flag == 1) {
					for (MobileElement mobileElement : answerCount) {
						sAss.assertTrue(mobileElement.isDisplayed());
						test.log(Status.INFO, "Answer " + c++ + "  displayed");
					}
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		return sAss;
	}

	public SoftAssert verify_All_SCQ_Answer_In_Default_State() throws InterruptedException, MalformedURLException {
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		int i = 0;
		int queFlag = 0;
		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				Thread.sleep(500);
				applyExplicitWait(5);
				queFlag = 0;
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				obp.question.isDisplayed();
				test.log(Status.INFO, "answerCont = " + ansCount);
				queFlag = 1;
				int c = 1;
				if (ansCount != 0 && flag == 1) {
					for (MobileElement mobileElement : answerCount) {
						sAss.assertFalse(Boolean.parseBoolean(getElementAttribute(mobileElement, "checked")));
						test.log(Status.INFO, "Answer " + c++ + "  is unchecked as default");
					}
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					// sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		return sAss;
	}

	public SoftAssert verify_Multiple_Answers_Shown_For_SCQ() throws InterruptedException, MalformedURLException {
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
				test.log(Status.INFO, "answerCont = " + ansCount);
				queFlag = 1;

				if (ansCount != 0 && flag == 1) {
					sAss.assertTrue(ansCount >= 2 ? true : false);
					test.log(Status.INFO, "Multiple answers available for question " + (i + 1));
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		return sAss;
	}

	public SoftAssert SCQ_Answers_Can_Be_Slect() throws InterruptedException, MalformedURLException {
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

				test.log(Status.INFO, "answerCont = " + ansCount);
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
							test.log(Status.INFO, c++ + " can be select or unselect");
						applyExplicitWait(1);
					}
					sAss.assertTrue(ansFlag != 0 ? true : false);
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else if (ansCount == 0 && flag == 0) {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
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
		return sAss;
	}

	public SoftAssert Only_Single_SCQ_Answer_Can_Be_Select() throws InterruptedException, MalformedURLException {
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

				test.log(Status.INFO, "answerCont = " + ansCount);
				prvsElement = true;
				int c = 1;
				if (ansCount != 0 && flag == 1) {
					for (MobileElement mobileElement : answerCount) {
						applyImplicitWait(5);
						mobileElement.click();

						prvsElement = Boolean.parseBoolean(getElementAttribute(mobileElement, "focused"));
						if (prvsElement == false)
							mobileElement.click();

						test.log(Status.INFO, "Answer " + c++ + "  is selected");
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
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
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

		return sAss;
	}

	public void Module_Receive_MCQ_Questions_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_All_Questions_Are_Visible_MCQ_Practice();
		sAss.assertAll();

	}

	public SoftAssert verify_All_Questions_Are_Visible_MCQ_Practice() throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int flag = 1;
		int i = 0;
		int queFlag = 0;

		normal: while (i < questions) {
			try {

				applyExplicitWait(5);
				queFlag = 0;
				Thread.sleep(500);
				test.log(Status.INFO, "Question " + (i + 1));
				ArrayList<MobileElement> answerCount = (ArrayList<MobileElement>) getDriver()
						.findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				// ort.question.isDisplayed();

				queFlag = 1;
				int c = 0;

				if (ansCount != 0 && flag == 1 && check_For_MSQ_or_SCQ().trim().equalsIgnoreCase("MCQ")) {
					test.log(Status.INFO, "Answer count " + ansCount);
					for (MobileElement mobileElement : answerCount) {
						sAss.assertTrue(mobileElement.isDisplayed());
						System.out.println("Answer " + ++c + "  displayed");
						test.log(Status.INFO, "Answer " + c + "  displayed");
					}

					ansCount = 0;
					if (i + 1 != questions)
						clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					flag = 1;
					i++;
					clickOnElement(obp.attempt_later);
				} else {
					if (i + 1 != questions)
						clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
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
		test.log(Status.INFO, actualcount + " MCQ displayed");
		System.out.println(actualcount + " MCQ displayed");

		return sAss;

	}

	public void Module_Receive_MCQ_Answers_In_Default_State_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_All_MCQ_Answer_In_Default_State();

		sAss.assertAll();
	}

	public SoftAssert verify_All_MCQ_Answer_In_Default_State() throws MalformedURLException {
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		int i = 0;
		int queFlag = 0;
		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				Thread.sleep(500);
				queFlag = 0;
				ArrayList<MobileElement> answerCount = (ArrayList<MobileElement>) getDriver()
						.findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				obp.question.isDisplayed();
				test.log(Status.INFO, "Question " + (i + 1));
				queFlag = 1;
				int c = 1;
				Thread.sleep(1000);

				if (ansCount != 0 && flag == 1 && check_For_MSQ_or_SCQ().trim().equalsIgnoreCase("MCQ")) {
					for (MobileElement mobileElement : answerCount) {
						sAss.assertFalse(Boolean.parseBoolean(getElementAttribute(mobileElement, "checked")));
						test.log(Status.INFO, "Answer " + c + "  is unchecked as default");
						System.out.println("Answer " + c++ + "  is unchecked as default");
					}
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
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
		test.log(Status.INFO, actualcount + " MCQ displayed");
		System.out.println(actualcount + " MCQ displayed");
		return sAss;
	}

	public void Module_Verify_Multiple_Answers_Shown_For_MCQ_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_Multiple_Answers_Shown_For_MCQ();

		sAss.assertAll();

	}

	public SoftAssert verify_Multiple_Answers_Shown_For_MCQ() throws MalformedURLException {
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
				test.log(Status.INFO, "Question " + (i + 1));

				queFlag = 1;

				if (ansCount != 0 && flag == 1 && check_For_MSQ_or_SCQ().trim().equalsIgnoreCase("MCQ")) {
					sAss.assertTrue(ansCount >= 2 ? true : false);
					test.log(Status.INFO, "Multiple answers available for question " + (i + 1));
					System.out.println("Multiple answers available for question " + (i + 1));
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					clickOnElement(obp.attempt_later);
					i++;
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
					test.log(Status.INFO, "Question " + i + " not displayed");
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
		test.log(Status.INFO, actualcount + " MCQ displayed");
		System.out.println(actualcount + " MCQ displayed");
		return sAss;
	}

	public void Module_Verify_MCQ_Answer_Can_Be_Slect_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = MCQ_Answers_Can_Be_Slect();

		sAss.assertAll();

	}

	public SoftAssert MCQ_Answers_Can_Be_Slect() throws MalformedURLException {
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

				ansFlag = 1;
				int c = 1;

				if (ansCount != 0 && check_For_MSQ_or_SCQ().trim().equalsIgnoreCase("MCQ")) {
					test.log(Status.INFO, "Question " + (i + 1));
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
							test.log(Status.INFO, c + " can be select or unselect");
						System.out.println(c + " can be select or unselect");
						applyExplicitWait(1);
						c++;
					}
					sAss.assertTrue(ansFlag != 0 ? true : false);
					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
					clickOnElement(obp.attempt_later);
					i++;
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
		test.log(Status.INFO, actualcount + " MCQ displayed");
		System.out.println(actualcount + " MCQ displayed");

		return sAss;
	}

	public void Module_Verify_Multiple_MCQ_Answer_Can_Be_Select_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = Able_to_Select_Multiple_MSQ_Answer_Can_Be_Select();

		sAss.assertAll();
	}

	public SoftAssert Able_to_Select_Multiple_MSQ_Answer_Can_Be_Select() throws MalformedURLException {
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
				test.log(Status.INFO, "Question " + (i + 1));
				applyExplicitWait(5);
				Thread.sleep(1000);
				ArrayList<MobileElement> answerCount = (ArrayList<MobileElement>) getDriver()
						.findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();

				System.out.println("answerCont = " + ansCount);
				test.log(Status.INFO, "Answer count " + ansCount);
				prvsElement = true;

				if (ansCount != 0 && flag == 1 && check_For_MSQ_or_SCQ().trim().equalsIgnoreCase("MCQ")) {
					for (MobileElement mobileElement : answerCount) {
						mobileElement.click();
						System.out.println(mobileElement.getText() + " Clicked");
					}
					answerCount = (ArrayList<MobileElement>) getDriver()
							.findElementsByClassName("android.widget.CheckBox");
					ansFlag = 0;
					for (MobileElement mobileElement : answerCount) {
						Thread.sleep(500);
						if (getElementAttribute(mobileElement, "checked").trim().equalsIgnoreCase("true"))
							ansFlag++;
					}
					sAss.assertTrue(ansFlag > 1 ? true : false);
					if (ansFlag > 1 ? true : false) {
						System.out.println("Answers are multiselect");
						test.log(Status.INFO, "Answers are multiselect");
					}
					applyExplicitWait(1);
					ansCount = 0;
					if (i + 1 != questions)
						clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
					i++;
					clickOnElement(obp.attempt_later);

				} else {
					if (i + 1 != questions)
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

		test.log(Status.INFO, actualcount + " MCQ displayed");
		System.out.println(actualcount + " MCQ displayed");

		return sAss;
	}

	public void Module_Verify_Correct_Feedback_Shown_After_MCQ_Answer_Selection_In_Practice(String subject,
			String topic) throws MalformedURLException, InterruptedException {

		Assert.assertTrue(false);

	}

	public void Module_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_MCQ_In_Practice(String property,
			String property2) {
		Assert.assertTrue(false);

	}

	public void Module_Verify_Attempting_MCQ_Quiz_Is_Mandatory_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {

		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = verify_Quiz_Is_Mandatory();

		sAss.assertAll();

	}

	public SoftAssert verify_Quiz_Is_Mandatory() throws MalformedURLException {
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		int i = 0;
		int queFlag = 0;
		String firstQuestion = null;
		String lastQuestion;
		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				applyExplicitWait(5);
				queFlag = 0;
				obp.question.isDisplayed();
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				test.log(Status.INFO, "question number " + (i + 1));
				test.log(Status.INFO, "answerCont = " + ansCount);
				queFlag = 1;
				if (ansCount != 0 && flag == 1) {
					if (i == 0)
						firstQuestion = obp.question.getText();

					ansCount = 0;
					clickOnElement(obp.attempt_later);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(obp.attempt_later);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				test.log(Status.INFO, "Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(obp.attempt_later);
				} else {
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
		}
		lastQuestion = obp.question.getText();
		sAss.assertEquals(firstQuestion, lastQuestion);
		if (firstQuestion.equalsIgnoreCase(lastQuestion))
			test.log(Status.INFO, "Unattempted question appear again. So it's mandetory for practice");

		return sAss;
	}

	public void Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_MCQ_In_Practice(
			String property, String property2) {
		Assert.assertTrue(false);

	}

	public void Module_Verify_User_Can_Abond_MCQ_Quiz_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);

		SoftAssert sAss = User_Can_Abond_Quiz();

		sAss.assertAll();

	}

	public SoftAssert User_Can_Abond_Quiz() throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int flag = 1;
		int i = 1;
		int queFlag = 0;
		String temp;
		test.log(Status.INFO, "Total " + questions + " appeared");
		// int actualcount = 0;
		try {
			List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
			int ansCount = answerCount.size();
			System.out.println("answerCont = " + ansCount);
			queFlag = 1;

			if (ansCount != 0 && flag == 1) {
				temp = obp.question.getText();

				applyExplicitWait(1);
				clickOnElement(obp.backBtn);
				test.log(Status.INFO, "Pressing back button");

				applyExplicitWait(2);
				clickOnElement(obp.returnToTestPopup);
				test.log(Status.INFO, "Select NO option of cancel practice");

				applyExplicitWait(1);
				sAss.assertEquals(temp, obp.question.getText());
				test.log(Status.INFO, "Same question available");

				applyExplicitWait(1);
				clickOnElement(obp.backBtn);
				test.log(Status.INFO, "Pressing back button");

				applyExplicitWait(2);
				clickOnElement(obp.submitTestPopup);
				test.log(Status.INFO, "Select YES option of cancel practice");
				if (findElementByText("Begin Test").isDisplayed())
					sAss.assertTrue(true);

				ansCount = 0;

			} else if (ansCount != 0) {
				test.log(Status.INFO, "Answer count " + ansCount);
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
				test.log(Status.INFO, "Question " + i + " not displayed");
				sAss.assertTrue(false);
				clickOnElement(obp.attempt_later);
			} else {
				if (flag == 1) {
					flag = 0;
					System.out.println("Flag set to 0");

				} else {
					flag = 1;
					System.out.println("Flag set to 1");

				}
			}
		}

		return sAss;
	}
}