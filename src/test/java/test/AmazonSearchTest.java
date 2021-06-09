package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class AmazonSearchTest { 
	BrowserUtils utils = new BrowserUtils();
	AmazonHomePage amazonHP;
  @Test
  public void amazonSearchTest() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
	  amazonHP= new AmazonHomePage();
	  amazonHP.twotabsearchtextbox.sendKeys("coffee mug");
	  amazonHP.searchButton.click();
	  Thread.sleep(1000);
  }
  @Test
  public void softAssert() throws InterruptedException {
	  SoftAssert softassert = new SoftAssert();
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
	  amazonHP=new AmazonHomePage();
	//  amazonHP.departmentsDropdown.click();
	  utils.selectByVisibleText(amazonHP.departmentsDropdown, "Alexa Skills");
	  softassert.assertTrue(false);
	  softassert.assertAll();
	  
	  Thread.sleep(1000);
  }
  @Test
  public void amazonSearchTest2() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
	  amazonHP=new AmazonHomePage();
	//  amazonHP.departmentsDropdown.click();
	  utils.selectByVisibleText(amazonHP.departmentsDropdown, "Alexa Skills");
	  
	  Thread.sleep(1000);
  }
  @Test
  public void amazonResultVerify() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
	  amazonHP=new AmazonHomePage();
	//  amazonHP.departmentsDropdown.click();
	  amazonHP.twotabsearchtextbox.sendKeys("coffee mug");
	  amazonHP.searchButton.click();
	  Thread.sleep(2000);
	  System.out.println( "num OF items" + amazonHP.itemPrices.size());
	  for(WebElement itemPrice : amazonHP.itemPrices) {
		  System.out.println(itemPrice.getText());
	  }
	  
	  
	  Thread.sleep(1000);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver();
  }

  
  
  @AfterMethod
  public void afterMethod() {
	  Driver.quitDriver();
  }

}
