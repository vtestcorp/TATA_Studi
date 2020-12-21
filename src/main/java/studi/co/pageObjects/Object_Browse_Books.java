package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Browse_Books extends Object_Landing_Page {
	
	
public Object_Browse_Books() {
	PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
}
@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\r\n")
public WebElement all_subjects;

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
public WebElement subject_Political_Science;

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
public WebElement subject_Geography;

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]")
public WebElement subject_Mathematics;

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]")
public WebElement subject_Science; 

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]")
public WebElement subject_History;

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
public WebElement yourSyllabusText;

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
public WebElement grade6Text;

public WebElement getAll_subjects() {
	System.out.println("Performing Operation on all_subjects");
	return all_subjects;
}

public void setAll_subjects(WebElement all_subjects) {
	this.all_subjects = all_subjects;
}

public WebElement getSubject_Political_Science() {
	System.out.println("Performing Operation on subject_Political_Science");
	return subject_Political_Science;
}

public void setSubject_Political_Science(WebElement subject_Political_Science) {
	this.subject_Political_Science = subject_Political_Science;
}

public WebElement getSubject_Geography() {
	System.out.println("Geography Subject is chosen");
	return subject_Geography;
}

public void setSubject_Geography(WebElement subject_Geography) {
	this.subject_Geography = subject_Geography;
}

public WebElement getSubject_Mathematics() {
	System.out.println("Mathematics Subject is chosen");
	return subject_Mathematics;
}

public void setSubject_Mathematics(WebElement subject_Mathematics) {
	this.subject_Mathematics = subject_Mathematics;
}

public WebElement getSubject_Science() {
	System.out.println("Science subject is selected");
	return subject_Science;
}

public void setSubject_Science(WebElement subject_Science) {
	this.subject_Science = subject_Science;
}

public WebElement getSubject_History() {
	System.out.println("History subject is selected");
	return subject_History;
}

public void setSubject_History(WebElement subject_History) {
	this.subject_History = subject_History;
}

public WebElement getYourSyllabusText() {
	System.out.println("Trying to access \"Your Syllabus\" at the end of the Page");
	return yourSyllabusText;
}

public void setYourSyllabusText(WebElement yourSyllabusText) {
	this.yourSyllabusText = yourSyllabusText;
}

public WebElement getGrade6Text() {
	System.out.println("Performing action on grade6Text");
	return grade6Text;
}

public void setGrade6Text(WebElement grade6Text) {
	this.grade6Text = grade6Text;
}

}