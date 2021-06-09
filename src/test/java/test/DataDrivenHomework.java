package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Indeed_Homework_Page;
import utilities.BrowserUtils;
import utilities.Driver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DataDrivenHomework {
	BrowserUtils utils;
	Indeed_Homework_Page indeed;

	@Test (dataProvider= "myDataBucket")
  public void searchResults(String position, String location) throws InterruptedException {
	  Driver.getDriver().get("https://indeed.com");
	  indeed = new Indeed_Homework_Page();
	  utils= new BrowserUtils();
	  indeed.whatInput.sendKeys(position);
	  String attributeValue = indeed.whereInput.getAttribute("value");
		System.out.println(attributeValue);
		for(int i = attributeValue.length(); i >=0; i--) {
			indeed.whereInput.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}
	  indeed.whereInput.sendKeys(location);
	  indeed.searchButton.click();
	  utils.waitUntilElementIsVisible(indeed.jobsInLocation);
	 String actual = indeed.jobsInLocation.getText();
	  Assert.assertTrue(actual.contains(location));
	  Assert.assertTrue(actual.contains(position));
	  SoftAssert softassert = new SoftAssert();
	  softassert.assertAll();
	  
	  for (WebElement e: indeed.searchResultTitle ) {
		  String search = e.getText();
		  softassert.assertTrue(search.contains(position));
		  
	  }
	  softassert.assertAll();
		
  }

	@DataProvider
	public Object[] myDataBucket() {
		String[][] mydata = new String[4][2];
		mydata[0][0] = "SDET";
		mydata[0][1] = "Washington, DC";
		mydata[1][0] = "ux designer";
		mydata[1][1] = "Chicago, IL";
		mydata[2][0] = "web developer";
		mydata[2][1] = "Pittsburgh, PA";
		mydata[3][0] = "project manager";
		mydata[3][1] = "Reston, VA";

		return mydata;
	}

	@BeforeMethod
	public void beforeMethod() {
		Driver.getDriver();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		Driver.quitDriver();
	}

}
