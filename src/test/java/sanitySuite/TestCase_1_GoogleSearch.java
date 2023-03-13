package sanitySuite;

import java.util.*;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Syn_google_search;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.testng.Assert;

public class TestCase_1_GoogleSearch extends TestBase{

	Syn_google_search obj_google_search;


	@Test (priority=1, description = "Open Google Search URL")	
	public void open_url() {

		log.info("Open Google Search URL.");
		driver.get(data.getProperty("base.url"));

		log.info("Get input string from properties file and put it into the search box.");
		obj_google_search = new Syn_google_search (driver);
		List <WebElement> searchContent = obj_google_search.get_content();
		for(WebElement suits : searchContent)
		{
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
		// log.info("Assert actual searched string with expected string from properties file.");
		// assertStrings(obj_google_search.get_first_option(),data.getProperty("TestCase_1.assertString_1"));
		// for(WebElement suits : searchContent)
		// {
			// Pattern plaintiffPattern = Pattern.compile("Plaintiff Name: (.+?) Filing date:");
			// Pattern defendantPattern = Pattern.compile("Defendant Name: (.+)");
   
			// Matcher plaintiffMatcher = plaintiffPattern.matcher(suits.getText());
			// Matcher defendantMatcher = defendantPattern.matcher(suits.getText());
   
			// String plaintiffName = "";
			// if (plaintiffMatcher.find()) {
			// 	plaintiffName = plaintiffMatcher.group(1);
			// }
   
			// String defendantName = "";
			// if (defendantMatcher.find()) {
			// 	defendantName = defendantMatcher.group(1);
			// }
   
			// // Assert that the plaintiffName and defendantName values are not empty
			// Assert.assertFalse(plaintiffName.isEmpty(), "Plaintiff value should not be empty.");
			// Assert.assertFalse(defendantName.isEmpty(), "Defendant value should not be empty.");
   
			// // Assert that the plaintiffName and defendantName values are not same
			// Assert.assertNotEquals(plaintiffName, defendantName, "Plaintiff and defendantName values should not be equal.");
   
			// // Invalid case added just for negative case handling
			// Assert.assertEquals("WARREN ZINNAMON", plaintiffName, "Invalid Lawsuit");
   
			// System.out.println("Plaintiff Name: " + plaintiffName + " Defendant Name: " + defendantName);
		//	  Assert.assertTrue(obj_google_search.get_first_option().equals(getPropertyValue("TestCase_1.assertString_1")));

	}

	// @Test (priority=2, description = "Click on first search option")	
	// public void click_first_search_option() {

	// 	log.info("Click on first search option");
	// 	obj_google_search.click_on_first_search_option();

	// }

}
