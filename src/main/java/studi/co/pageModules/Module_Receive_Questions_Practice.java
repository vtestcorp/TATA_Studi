package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Begin_Practice;
import studi.co.pageObjects.Object_Receive_Questions_Practice;
import studi.co.pageObjects.Object_Receive_Questions_Test;

public class Module_Receive_Questions_Practice extends BaseClass {
	Object_Receive_Questions_Practice RMQP = new Object_Receive_Questions_Practice();
	Object_Begin_Practice obp = new Object_Begin_Practice();
	Object_Receive_Questions_Test ort = new Object_Receive_Questions_Test();

	private void traverse_To_Begin_Practice(String subject, String topic) throws MalformedURLException {
		clickOnElement(ort.testUnit);
		applyExplicitWait(5);
		
		System.out.println(topic);
		scrollTo1("Practice");
		clickOnElement(findElementByText("Practice"));

	}

	public void Module_Receive_SCQ_Questions_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Practice"));
		
		SoftAssert sAss = verify_All_Questions_Are_Visible();
		sAss.assertAll();
	}

	public void Module_Receive_SCQ_Answers_In_Default_State_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Practice"));
		
		SoftAssert sAss = verify_All_SCQ_Answer_In_Default_State();
		sAss.assertAll();
	}

	public void Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject, topic);
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Practice"));
		
		SoftAssert sAss = verify_All_SCQ_Answer_In_Default_State();
		sAss.assertAll();
	}

	public void Module_Verify_SCQ_Answer_Can_Be_Slect_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject,topic);
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Practice"));
		
		SoftAssert sAss = verify_All_SCQ_Answer_In_Default_State();
		sAss.assertAll();
	}

	public void Module_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject,topic);
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Practice"));
		SoftAssert sAss = verify_All_SCQ_Answer_In_Default_State();
		sAss.assertAll();
	}

	public void Module_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(String subject,
			String topic) throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject,topic);
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Practice"));
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
		return sAss;
	}

	public void Module_Verify_Correct_Incorrect_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(String subject,
			String topic) throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject,topic);
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Practice"));
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

	public void Module_Verify_Attempting_SCQ_Quiz_Is_Mandatory_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject,topic);
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Practice"));
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
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;
				if (ansCount != 0 && flag == 1) {
					if (i == 0)
						firstQuestion = obp.question.getText();
					System.out.println("question number " + (i + 1));
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
			lastQuestion = obp.question.getText();
			sAss.assertEquals(firstQuestion, lastQuestion);
			if (firstQuestion.equalsIgnoreCase(lastQuestion))
				System.out.println("Unattempted question appear again. So it's mandetory for practice");
		}
		sAss.assertAll();

	}

	public void Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_SCQ_In_Practice(
			String subject, String topic) throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Practice(subject,topic);
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Practice"));
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
					applyExplicitWait(2);
					sAss.assertTrue(findElementByText("Uh-oh! Give it another shot!").isEnabled());
					if (findElementByText("Uh-oh! Give it another shot!").isEnabled())
						System.out.println("Shown correct feedback for incorrect answer");

					applyExplicitWait(2);
					sAss.assertTrue(findElementByText("TRY AGAIN").isEnabled());
					if (findElementByText("TRY AGAIN").isEnabled())
						System.out.println("Try Again button displayed");

					/*
					 * applyExplicitWait(5);
					 * sAss.assertTrue(findElementByText("I don't know").isEnabled()); if
					 * (findElementByText("I don't know").isDisplayed())
					 * System.out.println("I Don't Know(Show Answer) button displayed");
					 */
					applyExplicitWait(2);
					clickOnElement(findElementByText("TRY AGAIN"));
					getDriver().findElementById("com.tce.studi:id/tvQuestionPosition").click();

					applyExplicitWait(2);
					sAss.assertTrue(findElementByText("You have one attempt left").isEnabled());
					if (findElementByText("You have one attempt left").isEnabled())
						System.out.println("Attempts warning displayed");

					getDriver().findElementById("com.tce.studi:id/tvQuestionPosition").click();

					Thread.sleep(1);
					for (MobileElement mobileElement : answerCount) {
						// verify answers in default state
						sAss.assertFalse(Boolean.parseBoolean(getElementAttribute(mobileElement, "checked")));
					}

					obp.selectCorrectOption(i + 1);

					applyExplicitWait(2);
					sAss.assertTrue(obp.check_answer.isEnabled());
					clickOnElement(obp.check_answer);
					if (obp.check_answer.isEnabled())
						System.out.println("Check Answer Button displayed");

					applyExplicitWait(2);
					sAss.assertTrue(obp.answerCorrectMsg.isEnabled());
					if (obp.answerCorrectMsg.isEnabled())
						System.out.println("Shown correct feedback for correct answer");
					ansCount = 0;
					applyExplicitWait(2);
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

	public void Module_Verify_User_Should_Be_Able_To_Abandon_The_SCQ_In_Practice(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		
		traverse_To_Begin_Practice(subject,topic);
		Thread.sleep(3000);
		clickOnElement(findElementByText("Begin Practice"));
		// clickOnElement(findElementByText("Practice again"));
		applyExplicitWait(5);
		SoftAssert sAss = new SoftAssert();
		String actualQue, expectedQue;

		expectedQue = obp.question.getText();
		clickOnElement(obp.backBtn);
		applyExplicitWait(5);

		if (getDriver().findElementById("com.tce.studi:id/txtTitle").isEnabled())
			System.out.println("Popup message displayed");

		clickOnElement(obp.noBtn);
		actualQue = obp.question.getText();
		if (actualQue.equalsIgnoreCase(expectedQue))
			System.out.println("same question appear again");

		clickOnElement(obp.backBtn);
		applyExplicitWait(5);

		clickOnElement(obp.yesBtn);
		applyExplicitWait(5);

		if (findElementByText("Begin Practice").isDisplayed())
			System.out.println("Returned to begin practice page");
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

		return sAss;
	}

}