package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import studi.co.Base.BaseClass;

public class Object_Confirm_Syllabus_Tab extends BaseClass {

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement get_syllabus_Tab_Label;
	
	public Object_Confirm_Syllabus_Tab() {
		PageFactory.initElements(getDriver(), this);
	
}
}