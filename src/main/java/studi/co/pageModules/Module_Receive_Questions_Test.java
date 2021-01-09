package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Receive_Questions_Test;

public class Module_Receive_Questions_Test extends BaseClass {
	Object_Receive_Questions_Test ort = new Object_Receive_Questions_Test();
	Module_Receive_Questions_Practice rqp = new Module_Receive_Questions_Practice();
	Set<String> allQuestions = new HashSet<>();

	public void traverse_To_Begin_Test() throws MalformedURLException, InterruptedException {
		clickOnElement(ort.testUnit);
		test.log(Status.INFO, "Opening Test Unit");
		applyExplicitWait(5);
		scrollTo1("Test");
		applyExplicitWait(5);
		List<MobileElement> mobileElement = getDriver().findElementsById("com.tce.studi:id/tv_chapter_type");
		for (MobileElement mobileElement2 : mobileElement) {
			if (mobileElement2.getText().trim().equalsIgnoreCase("Test")) {
				clickOnElement(mobileElement2);
				break;
			}
		}
		test.log(Status.INFO, "Opening Test");
		Thread.sleep(3000);
	}

	private void closePopup() {
		try {
			while (getDriver().findElementById("com.tce.studi:id/tutorialDoNotShow").isDisplayed()) {
				clickOnElement(getDriver().findElementById("com.tce.studi:id/tutorialDoNotShow"));
			}
		} catch (Exception e) {
			test.log(Status.INFO, "Popup closed");
		}
	}

	private void startTest() throws MalformedURLException {
		try {
			new WebDriverWait(getDriver(), 1).ignoring(StaleElementReferenceException.class);
			clickOnElement(findElementByText("Begin Test"));
			test.log(Status.INFO, "Begin Test");
		} catch (Exception e) {
			clickOnElement(findElementByText("Test again"));
			test.log(Status.INFO, "Test Again");
		}
		applyExplicitWait(5);
	}

	public void Module_Receive_SCQ_Questions_Test(String subject) throws MalformedURLException, InterruptedException {
		
		traverse_To_Begin_Test();
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = verify_All_Questions_Are_Visible();

		sAss.assertAll();
	}

	public void Module_Receive_SCQ_Answers_In_Default_State_In_Test(String property)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Test();
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = verify_All_SCQ_Answer_In_Default_State();

		sAss.assertAll();

	}

	public void Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Test(String property)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Test();
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = verify_Multiple_Answers_Shown_For_SCQ();

		sAss.assertAll();
	}

	public void Module_Verify_SCQ_Answer_Can_Be_Slect_In_Test(String property)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Test();
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = SCQ_Answers_Can_Be_Slect();

		sAss.assertAll();

	}

	public void Module_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Test(String property)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Test();
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = Only_Single_SCQ_Answer_Can_Be_Select();

		sAss.assertAll();

	}

	public void Module_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Test(String property)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Test();
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = Correct_Feedback_Shown_After_Test_Complition();

		sAss.assertAll();
	}

	public void Module_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_In_Test(String property)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Test();
		// Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = Correct_Feedback_Shown_Under_Hamburger_Menu();

		sAss.assertAll();

	}

	public void Module_Verify_Attempting_SCQ_Quiz_Is_Not_Mandatory_In_Test(String property)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Test();
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = verify_SCQ_Quiz_Is_Not_Mandatory();

		sAss.assertAll();

	}

	public void Module_Verify_User_Should_Be_Able_To_Flag_The_Question_In_Test(String subject)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Test();
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = User_Should_Be_Able_To_Flag_The_Question();

		sAss.assertAll();
	}

	public void Module_Verify_Marks_Shown_With_SCQ_In_Test(String property)
			throws MalformedURLException, InterruptedException {
		traverse_To_Begin_Test();
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = Marks_Shown_With_SCQ();

		sAss.assertAll();

	}

	public void Module_Verify_User_Can_Abond_SCQ_Quiz_In_Test(String property) throws InterruptedException, MalformedURLException {
		traverse_To_Begin_Test();
		Thread.sleep(3000);
		startTest();
		closePopup();
		SoftAssert sAss = User_Can_Abond_SCQ_Quiz();

		sAss.assertAll();
	}

	private SoftAssert User_Can_Abond_SCQ_Quiz() throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int flag = 1;
		int i = 1;
		int queFlag = 0;
		String temp;
		// int actualcount = 0;
			try {
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;

				if (ansCount != 0 && flag == 1) {
					temp=ort.question.getText();
					
					applyExplicitWait(1);
					clickOnElement(ort.backBtn);
					
					applyExplicitWait(2);
					clickOnElement(ort.returnToTestPopup);
					
					applyExplicitWait(1);
					sAss.assertEquals(temp,ort.question.getText());
					test.log(Status.INFO, "Same question appeared");
					
					applyExplicitWait(1);
					clickOnElement(ort.backBtn);
					
					applyExplicitWait(2);
					clickOnElement(ort.returnToTestPopup);
					
					
					applyExplicitWait(2);
					clickOnElement(ort.submitTestBtn);
					
					if(findElementByText("Begin Test").isDisplayed())
						sAss.assertTrue(true);
				
					ansCount = 0;
					clickOnElement(ort.nextBtn);
					
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(ort.nextBtn);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(ort.nextBtn);
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

	private SoftAssert Marks_Shown_With_SCQ() throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
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
				ort.question.isDisplayed();
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;
				int c = 1;
				if (ansCount != 0 && flag == 1) {
					sAss.assertTrue(ort.marks.isDisplayed());
					ansCount = 0;
					clickOnElement(ort.nextBtn);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(ort.nextBtn);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(ort.nextBtn);
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

	public SoftAssert verify_All_Questions_Are_Visible() throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
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
				ort.question.isDisplayed();
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;
				int c = 1;
				if (ansCount != 0 && flag == 1) {
					for (MobileElement mobileElement : answerCount) {
						sAss.assertTrue(mobileElement.isDisplayed());
						test.log(Status.INFO, "Answer " + c++ + "  displayed");
					}
					ansCount = 0;
					clickOnElement(ort.nextBtn);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(ort.nextBtn);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(ort.nextBtn);
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
				ort.question.isDisplayed();
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;
				int c = 1;
				if (ansCount != 0 && flag == 1) {
					for (MobileElement mobileElement : answerCount) {
						sAss.assertFalse(Boolean.parseBoolean(getElementAttribute(mobileElement, "checked")));
						test.log(Status.INFO, "Answer " + c++ + "  is unchecked as default");
					}
					ansCount = 0;
					clickOnElement(ort.nextBtn);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(ort.nextBtn);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(ort.nextBtn);
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
				ort.question.isDisplayed();
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;

				if (ansCount != 0 && flag == 1) {
					sAss.assertTrue(ansCount >= 2 ? true : false);
					test.log(Status.INFO, "Multiple answers available for question " + (i + 1));
					ansCount = 0;
					clickOnElement(ort.nextBtn);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(ort.nextBtn);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(ort.nextBtn);
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
							test.log(Status.INFO, c++ + " can be select or unselect");
						applyExplicitWait(1);
					}
					sAss.assertTrue(ansFlag != 0 ? true : false);
					ansCount = 0;
					clickOnElement(ort.nextBtn);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else if (ansCount == 0 && flag == 0) {
					clickOnElement(ort.nextBtn);
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
				Thread.sleep(1000);
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();

				System.out.println("answerCont = " + ansCount);
				test.log(Status.INFO, "Answer count " + ansCount);
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
								//test.log(Status.INFO, (c - 1) + "  " + ansFlag);
							}
						}

						sAss.assertTrue(ansFlag == 1 ? true : false);
						applyExplicitWait(1);
					}
					ansCount = 0;
					clickOnElement(ort.nextBtn);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(ort.nextBtn);
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

	public SoftAssert Correct_Feedback_Shown_After_Test_Complition() throws MalformedURLException {
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
				allQuestions.add(ort.question.getText());
				queFlag = 0;
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				ort.question.isDisplayed();
				System.out.println("answerCont = " + ansCount);
				queFlag = 1;

				if (ansCount != 0 && flag == 1) {
					sAss.assertTrue(ort.selectCorrectOption(i + 1));
					ansCount = 0;
					if (++i < questions)
						clickOnElement(ort.nextBtn);

				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(ort.nextBtn);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(ort.nextBtn);
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
		clickOnElement(ort.hamburgerBtn);
		applyExplicitWait(1);

		clickOnElement(ort.submitTestBtn);
		applyExplicitWait(1);

		clickOnElement(ort.submitTestPopup);
		applyExplicitWait(1);

		sAss.assertTrue(ort.reviewAttemt.isDisplayed());
		if (ort.reviewAttemt.isDisplayed())
			clickOnElement(ort.reviewAttemt);
		sAss.assertAll();

		sAss = verify_All_Questions_Are_Visible();
		return sAss;
	}

	private SoftAssert Correct_Feedback_Shown_Under_Hamburger_Menu() throws MalformedURLException {
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		SoftAssert sAss = Correct_Feedback_Shown_After_Test_Complition();

		int i = 0;
		int j = 0;

		applyExplicitWait(5);

		clickOnElement(ort.hamburgerBtn);
		Iterator<String> it = allQuestions.iterator();
		List<MobileElement> queCount = getDriver().findElementsById("com.tce.studi:id/tvQuesId");
		String[] hList = new String[queCount.size()];
		for (MobileElement mobileElement : queCount)
			hList[j++] = mobileElement.getText();
		normal: while (i < questions) {
			try {

				{
					applyExplicitWait(1);
					clickOnElement(findElementByText(hList[i]));
					applyExplicitWait(5);
					// int index=Integer.parseInt(getElementAttribute(mobileElement, "index"))+1;
					sAss.assertTrue(it.next().equalsIgnoreCase(ort.question.getText()));
					clickOnElement(ort.hamburgerBtn);
					i++;
				}

				applyExplicitWait(1);
				if ((i + 1) != questions) {
					clickOnElement(findElementByText("Question +" + (i + 1)));
					applyExplicitWait(1);

					sAss.assertEquals((i + 1), getCurrentQuestionInPractice(questions));
				}
				i++;

			} catch (Exception e) {
				System.out.println("Exception occured");
				continue normal;
			}
		}
		clickOnElement(ort.hamburgerBtn);
		applyExplicitWait(1);

		clickOnElement(ort.submitTestBtn);
		applyExplicitWait(5);

		clickOnElement(ort.submitTestPopup);
		applyExplicitWait(1);

		// sAss.assertTrue(ort.reviewAttemt.isDisplayed());
		if (ort.reviewAttemt.isDisplayed())
			clickOnElement(ort.reviewAttemt);
		sAss.assertAll();
		j = 0;
		clickOnElement(ort.hamburgerBtn);
		queCount = getDriver().findElementsById("com.tce.studi:id/tvQuesId");
		String[] hList2 = new String[queCount.size()];
		for (MobileElement mobileElement : queCount)
			hList2[j++] = mobileElement.getText();

		applyExplicitWait(2);
		clickOnElement(findElementByText(hList[0].toString()));
		i = 0;
		while (i < questions) {
			applyExplicitWait(2);
			clickOnElement(ort.hamburgerBtn);
			applyExplicitWait(2);
			if ((i + 1) != questions)
				clickOnElement(findElementByText(hList[i]));
			applyExplicitWait(2);
			i++;
		}

		return sAss;

	}

	public SoftAssert verify_SCQ_Quiz_Is_Not_Mandatory() throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int flag = 1;
		int i = 1;
		int queFlag = 0;

		// int actualcount = 0;
		normal: while (i < questions) {
			try {
				List<MobileElement> answerCount = getDriver().findElementsByClassName("android.widget.CheckBox");
				int ansCount = answerCount.size();
				System.out.println("answerCont = " + ansCount);
				
				queFlag = 1;

				if (ansCount != 0 && flag == 1) {
					for (MobileElement mobileElement : answerCount) {
						sAss.assertFalse(Boolean.parseBoolean(getElementAttribute(mobileElement, "focused")));
					}
					ansCount = 0;
					test.log(Status.INFO, "Move to Next Question");
					clickOnElement(ort.nextBtn);
					i++;
				} else if (ansCount != 0) {
					test.log(Status.INFO, "Answer count " + ansCount);
					flag = 1;
				} else {
					clickOnElement(ort.nextBtn);
					i++;
					flag = 1;
				}

			} catch (Exception e) {
				System.out.println("Exception occured");
				if (queFlag == 0) {
					i++;
					test.log(Status.INFO, "Question " + i + " not displayed");
					sAss.assertTrue(false);
					clickOnElement(ort.nextBtn);
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
		i = 1;
		while (i < questions) {
			applyExplicitWait(2);
			test.log(Status.INFO, "Move to Previous Question");
			clickOnElement(ort.previousBtn);
			i++;
		}
		applyExplicitWait(2);
		clickOnElement(ort.hamburgerBtn);
		test.log(Status.INFO, "Opening Hamberger");
		
		applyExplicitWait(2);
		clickOnElement(ort.submitTestBtn);
		test.log(Status.INFO, "Submit Test");
		
		applyExplicitWait(2);
		clickOnElement(ort.submitTestPopup);

		sAss.assertTrue(ort.reviewAttemt.isDisplayed());
		if (ort.reviewAttemt.isDisplayed()) {
			test.log(Status.INFO, "Test submitted");
			clickOnElement(ort.reviewAttemt);
		}

		applyExplicitWait(2);
		clickOnElement(ort.hamburgerBtn);
		Thread.sleep(2000);

		return sAss;
	}

	public SoftAssert User_Should_Be_Able_To_Flag_The_Question() throws MalformedURLException {

		SoftAssert sAss = new SoftAssert();
		applyExplicitWait(5);
		int questions = getTotalQuestionsInPractice();
		int flag = 1;
		int i = 0;
		int j = 0;
		int queFlag = 0;
		applyExplicitWait(2);
		clickOnElement(ort.hamburgerBtn);
		Iterator<String> it = allQuestions.iterator();
		List<MobileElement> queCount = getDriver().findElementsById("com.tce.studi:id/tvQuesId");
		String[] hList = new String[queCount.size()];
		for (MobileElement mobileElement : queCount)
			hList[j++] = mobileElement.getText();

		applyExplicitWait(2);
		clickOnElement(findElementByText(hList[0].toString()));

		normal: while (i < questions) {
			try {

				if (flag == 1) {
					applyExplicitWait(2);
					clickOnElement(ort.queFlag);
					test.log(Status.INFO, "quesetiong flag");

					applyExplicitWait(2);
					clickOnElement(ort.hamburgerBtn);

					sAss.assertTrue(ort.hamFlag.isDisplayed());
					test.log(Status.INFO, "Hamburger flag");

					applyExplicitWait(2);

					clickOnElement(findElementByText(hList[i]));
					test.log(Status.INFO, it.toString());
					test.log(Status.INFO, "quesetion number");

					applyExplicitWait(2);
					clickOnElement(ort.queFlag);
					test.log(Status.INFO, "quesetiong flag");

					applyExplicitWait(2);
					clickOnElement(ort.hamburgerBtn);
					applyExplicitWait(2);
					if ((i + 1) != questions)
						clickOnElement(findElementByText(hList[i + 1]));
					i++;
				} else {
					clickOnElement(ort.nextBtn);
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
