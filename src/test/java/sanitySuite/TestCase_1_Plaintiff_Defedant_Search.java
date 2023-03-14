package sanitySuite;

import java.util.*;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Plaintiff_Defendant_Search;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestCase_1_Plaintiff_Defedant_Search extends TestBase {

	Plaintiff_Defendant_Search obj_google_search;

	@Test(priority = 1, description = "Open Plaintiff Defendant Search URL")
	public void open_url() {

		log.info("Open Plaintiff Defendant Search URL.");
		driver.get(data.getProperty("base.url"));

		log.info("Get input string from properties file and put it into the search box.");
		obj_google_search = new Plaintiff_Defendant_Search(driver);
		List<WebElement> searchContent = obj_google_search.get_content();
		for (WebElement suits : searchContent) {
			Pattern plaintiffPattern = Pattern.compile("Plaintiff Name: (.+?) Filing date:");
			Pattern defendantPattern = Pattern.compile("Defendant Name: (.+)");

			Matcher plaintiffMatcher = plaintiffPattern.matcher(suits.getText());
			Matcher defendantMatcher = defendantPattern.matcher(suits.getText());

			String plaintiffName = "";
			if (plaintiffMatcher.find()) {
				plaintiffName = plaintiffMatcher.group(1);
			}

			String defendantName = "";
			if (defendantMatcher.find()) {
				defendantName = defendantMatcher.group(1);
			}
			assertStrings(plaintiffName, defendantName);
			System.out.println("Plaintiff Name: " + plaintiffName + "Defendant Name: " + defendantName);
		}
	}

}
