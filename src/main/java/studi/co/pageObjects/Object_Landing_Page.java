package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Object_Landing_Page extends Object_Login {

	public Object_Landing_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "com.tce.afs:id/textHeader")
	public WebElement textTitle;
	
	@FindBy(id = "com.tce.afs:id/signout")
	public WebElement signout_Button; 
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]")
	public WebElement browseBooks; 
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
	public WebElement assignments; 
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
	public WebElement activeplan; 
	
	@FindBy(xpath = "com.tce.afs:id/dont_like_study")
	public WebElement dontlikestudyText; 
	
}
