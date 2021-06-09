package test;

import org.testng.annotations.Test;

import pages.SeleniumEasyAlertPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class HomeworkTest {
	BrowserUtils utils = new BrowserUtils();
	SeleniumEasyAlertPage alertPage;
	
  @Test (priority=1, description="This is first alert accept test")
  public void firstTest() {
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyURL"));
	  alertPage = new SeleniumEasyAlertPage();
	  alertPage.firstAlertButton.click();
	  
	  //calling the switch to alert function
	  utils.switchToAlert();
	  utils.waitUntilAlertIsPresent();
	  String expected = "I am an alert box!";
		String actual = utils.alertGetText();
		Assert.assertEquals(actual, expected);

		utils.acceptAlert();
  }
  @Test (priority=2, description="this is the second alert dismiss test")
	public void secondTest() {
		Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyURL"));
		alertPage = new SeleniumEasyAlertPage();
		  alertPage.secondAlertBtn.click();
		  utils.switchToAlert();
		  utils.waitUntilAlertIsPresent();
		  String expected= "Press a button!";
		  String actual = utils.alertGetText();
		  
		  Assert.assertEquals(actual, expected);
		  
		  utils.dismissAlert();
		
		}
  @Test(priority=3, description="this is the Alert sendkeys test")
  public void thirdTest() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyURL"));
	  alertPage = new SeleniumEasyAlertPage();
	  alertPage.thridAlertBtn.click();
	  utils.switchToAlert();
	  String expected="Please enter your name";
	  String actual= utils.alertGetText();
	  Assert.assertEquals(actual, expected);
	  utils.sendKeys();
	  Thread.sleep(2000);
	  utils.acceptAlert();
	  Thread.sleep(2000);
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
