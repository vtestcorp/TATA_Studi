package studi.co.pageModules;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Practice;

public class Module_Receive_MCQ_Questions_Practice extends BaseClass{
	
	public static String getQuestion, getQuestionCount;


	public void Verify_Student_Receives_MCQ_Questions_Practice() throws InterruptedException {

		Object_Receive_MCQ_Questions_Practice RMQP = new Object_Receive_MCQ_Questions_Practice();
		//Module_Login login = new Module_Login();
		
		
		//login.Login_to_app();
		RMQP.select_browse_books.click();
		Thread.sleep(1000);
		RMQP.select_subject.click();
		Thread.sleep(1000);
		RMQP.select_topic_from_chapter.click();
		Thread.sleep(2000);
		RMQP.select_begin_practice.click();
		Thread.sleep(2000);
		RMQP.click_begin_practice_button.click();
		Thread.sleep(2000);
		
		getQuestion = RMQP.get_first_question.getText();
		System.out.println(getQuestion);
		if(getQuestion.contains("Count the hats and choose the correct number"))
			System.out.println("Questions displayed successfully");
		else
			System.out.println("Display questions FAILED");
		
		getQuestionCount = RMQP.get_question_count.getText();
		System.out.println(getQuestionCount);
		if(getQuestionCount.contains("1 of 5"))
		System.out.println("Questions count shown successfully");
		else
			System.out.println("Not shown multiple questions");
		
		
		
	}

}
