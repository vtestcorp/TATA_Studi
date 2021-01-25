package studi.co.pageModules; 
import studi.co.Base.BaseClass;
import studi.co.pageObjects.*;

public class Module_Login extends BaseClass{

	public static String homepage_title;
	
	
	public void Login_to_app() throws InterruptedException {

		Object_Login login = new Object_Login();

		login.username.clear();
		login.username.sendKeys(prop.getProperty("username"));
		login.password.clear();
		login.password.sendKeys(prop.getProperty("password"));
		login.login_button.click();
		
		Thread.sleep(5000);
		
		homepage_title = login.homepage_title.getText();
		
		if(homepage_title.equals("What would\n" + "you like to do next?"))
			System.out.println("Login successfull");
		else 
			System.out.println("Login Failed");
		
	}

}