package pages;

/*******************************************************************************************
 * Page Factory class Template
 * @author Shirish Kawatkar
 *******************************************************************************************/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import base.PageBase;


public class Plaintiff_Defendant_Search extends PageBase {

	public Plaintiff_Defendant_Search(WebDriver driver) {
		super(driver);
	}

	/*******************************************************************************************
	 * All WebElements are identified by @FindBy annotation
	 *******************************************************************************************/

	WebDriver driver;
	// Web Element for Google Search Box
	@FindBy(name = "q")
	WebElement searchBox;
	
	// Web Element for Google Search first option
	@FindBy(xpath = "//*[@id='tsf']/div[2]/div/div[2]/div[2]/ul/li[1]/div[1]/div/span")
	WebElement searchFirstOption;

	@FindBy(xpath = "//div[@class='equal_content']")
	List <WebElement> searchContent;

	/*******************************************************************************************
	 * All Methods for performing actions
	 * @return 
	 *******************************************************************************************/

	public void enter_text(String Search_text){
		
		log.info("Enter text to search: "+Search_text);
		searchBox.sendKeys(Search_text);
		
	}

	public List<WebElement> get_content(){
		
		log.info("Enter text to search: ");
		return searchContent;
		
	}
	

}
