package test;

import org.testng.annotations.Test;

import pages.demoqa_page;
import utilities.BrowserUtils;
import utilities.Driver;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HomeworkAssignment {
	BrowserUtils utils = new BrowserUtils();
	demoqa_page alertPage;
  @Test
  public void test1() {
	  Driver.getDriver().get("https://demoqa.com/alerts");
	  alertPage = new demoqa_page();
	  alertPage.firstAlert.click();
	  utils.switchToAlert();
	  String alertText = utils.alertGetText();
	  String expectedText= "You clicked a button";
	  Assert.assertEquals(alertText, expectedText);
	  System.out.println(alertText);
	  utils.acceptAlert();
  }
  @Test
  public void test2() {
	  Driver.getDriver().get("https://demoqa.com/alerts");
	  alertPage = new demoqa_page();
	  alertPage.secondAlert.click();
	  utils.waitUntilAlertIsPresent();
	  String alertText= utils.alertGetText();
	  String expectedText= "This alert appeared after 5 seconds";
	  Assert.assertEquals(alertText, expectedText);
	  System.out.println(alertText);
	  utils.acceptAlert();
  }
  @Test
  public void test3() {
	  Driver.getDriver().get("https://demoqa.com/alerts");
	  alertPage = new demoqa_page();
	  alertPage.thirdAlert.click();
	  String alertText = utils.alertGetText();
	  String expectedText="Do you confirm action?";
	  Assert.assertEquals(alertText, expectedText);
	  System.out.println(alertText);
	  utils.dismissAlert();
  }
  @Test
  public void test4() {
	  Driver.getDriver().get("https://demoqa.com/alerts");
	  alertPage = new demoqa_page();
	  alertPage.fourthAlert.click();
	  String alertText= utils.alertGetText();
	  String expectedText="Please enter your name";
	  Assert.assertEquals(alertText, expectedText);
	  System.out.println(alertText);
	  utils.sendKeys();
	  utils.acceptAlert();
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver();
	  Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  
  @AfterClass
  public void afterClass() {
	  Driver.quitDriver();
  }

}
