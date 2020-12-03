package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Object_Subject_Mathematics extends Object_Browse_Books {
	
	public Object_Subject_Mathematics() {
		PageFactory.initElements(getDriver(), this);
	}

@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")	
public WebElement allChapters_Heading; 

@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
public WebElement highlight;

@FindBy(xpath = "//android.widget.TextView[@text='1. Knowing Our Numbers']")
public WebElement chapter_1;


@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup")
public WebElement topic_1_chapter_1;

@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup")
public WebElement topic_2_chapter_1;

@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup")
public WebElement topic_3_chapter_1;

@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup")
public WebElement topic_4_chapter_1;

@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
public WebElement begin_Revision_topic_4_chapter_1;

@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
public WebElement begin_Practice_topic_4_chapter_1; 


@FindBy(xpath = "//android.widget.TextView[@text='2. Whole Numbers']")
public WebElement chapter_2; 

@FindBy(xpath = "//android.widget.TextView[@text='3. Playing With Numbers']")
public WebElement chapter_3;

@FindBy(xpath = "//android.widget.TextView[@text='4. Basic Geometrical Ideas']")
public WebElement chapter_4;

@FindBy(xpath = "//android.widget.TextView[@text='5. Understanding Elementary Shapes']")
public WebElement chapter_5;

@FindBy(xpath = "//android.widget.TextView[@text='6. Integers']")
public WebElement chapter_6;

@FindBy(xpath = "//android.widget.TextView[@text='7. Fractions']")
public WebElement chapter_7;

@FindBy(xpath = "//android.widget.TextView[@text='8. Decimals']")
public WebElement chapter_8;

@FindBy(xpath = "//android.widget.TextView[@text='9. Data Handling']")
public WebElement chapter_9;

@FindBy(xpath =" //android.widget.TextView[@text='10. Mensuration']")
public WebElement chapter_10;

@FindBy(xpath="//android.widget.TextView[@text='11. Algebra']")
public WebElement chapter_11;

@FindBy(xpath="//android.widget.TextView[@text='12. Ratio and Proportion']")
public WebElement chapter_12;

@FindBy(xpath = "//android.widget.TextView[@text='13. Symmetry']")
public WebElement chapter_13;

@FindBy(xpath = "//android.widget.TextView[@text='14. Practical Geometry']")
public WebElement chapter_14;

	
}
