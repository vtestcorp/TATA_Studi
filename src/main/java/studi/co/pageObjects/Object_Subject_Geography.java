package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Object_Subject_Geography extends Object_Browse_Books{
	public Object_Subject_Geography() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
	public WebElement allChaptersHeader; 
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	public WebElement highlight; 
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup[1]")
	public WebElement chapter1; 
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.")
	public WebElement bigIdea_chapter1;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup[1]")
	public WebElement chapter2; 
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup")
	public WebElement topic1_chapter1; 
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup")
	public WebElement topic2_chapter1; 
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
	public WebElement practiceAgain_topic1_chapter1;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1")
	public WebElement beginRevision_topic1_chapter1; 
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView[1]" )
	public WebElement beginRevisionPlayIconImage;

	public WebElement getAllChaptersHeader() {
		System.out.println("Performing Operation on allChaptersHeader");
		return allChaptersHeader;
	}

	public void setAllChaptersHeader(WebElement allChaptersHeader) {
		this.allChaptersHeader = allChaptersHeader;
	}

	public WebElement getHighlight() {
		System.out.println("Performing Operation on highlight");
		return highlight;
	}

	public void setHighlight(WebElement highlight) {
		this.highlight = highlight;
	}

	public WebElement getChapter1() {
		System.out.println("Performing Operation on chapter1");
		return chapter1;
	}

	public void setChapter1(WebElement chapter1) {
		this.chapter1 = chapter1;
	}

	public WebElement getBigIdea_chapter1() {
		System.out.println("Performing Operation on bigIdea_chapter1");
		return bigIdea_chapter1;
	}

	public void setBigIdea_chapter1(WebElement bigIdea_chapter1) {
		this.bigIdea_chapter1 = bigIdea_chapter1;
	}

	public WebElement getChapter2() {
		System.out.println("Performing Operation on chapter2");
		return chapter2;
	}

	public void setChapter2(WebElement chapter2) {
		this.chapter2 = chapter2;
	}

	public WebElement getTopic1_chapter1() {
		System.out.println("Performing Operation on topic1_chapter1");
		return topic1_chapter1;
	}

	public void setTopic1_chapter1(WebElement topic1_chapter1) {
		this.topic1_chapter1 = topic1_chapter1;
	}

	public WebElement getTopic2_chapter1() {
		System.out.println("Performing Operation on topic2_chapter1");
		return topic2_chapter1;
	}

	public void setTopic2_chapter1(WebElement topic2_chapter1) {
		this.topic2_chapter1 = topic2_chapter1;
	}

	public WebElement getPracticeAgain_topic1_chapter1() {
		System.out.println("Performing Operation on practiceAgain_topic1_chapter1");
		return practiceAgain_topic1_chapter1;
	}

	public void setPracticeAgain_topic1_chapter1(WebElement practiceAgain_topic1_chapter1) {
		this.practiceAgain_topic1_chapter1 = practiceAgain_topic1_chapter1;
	}

	public WebElement getBeginRevision_topic1_chapter1() {
		System.out.println("Performing Operation on beginRevision_topic1_chapter1");
		return beginRevision_topic1_chapter1;
	}

	public void setBeginRevision_topic1_chapter1(WebElement beginRevision_topic1_chapter1) {
		this.beginRevision_topic1_chapter1 = beginRevision_topic1_chapter1;
	}

	public WebElement getBeginRevisionPlayIconImage() {
		System.out.println("Performing Operation on beginRevisionPlayIconImage");
		return beginRevisionPlayIconImage;
	}

	public void setBeginRevisionPlayIconImage(WebElement beginRevisionPlayIconImage) {
		this.beginRevisionPlayIconImage = beginRevisionPlayIconImage;
	}
	
}
