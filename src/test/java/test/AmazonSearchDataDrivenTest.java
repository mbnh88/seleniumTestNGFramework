package test;

import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmazonSearchDataDrivenTest {
	BrowserUtils utils;
	AmazonHomePage amazonHP;
	  @Test (dataProvider="myDataBucket")
	  public void test(String input) {
		  Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
		  amazonHP= new AmazonHomePage();
		  amazonHP.twotabsearchtextbox.sendKeys(input);
		  amazonHP.searchButton.click();
		  utils= new BrowserUtils();
		  utils.waitUntilElementIsVisible(amazonHP.searchedItem);
		  int length = amazonHP.searchedItem.getText().length();
		 String actual= amazonHP.searchedItem.getText().substring(1,length - 1);
		 String expected= input;
		 Assert.assertEquals(actual, expected);
		  System.out.println(input);
	  }
	  
	  @DataProvider
	  public String[] myDataBucket() {
		  String[] mydata = new String[5];
		  mydata[0]= "pretty coffee mug";
		  mydata[1]= "coffee mug";
		  mydata[2]= "ugly coffee mug";
		  mydata[3]= "cute coffee mug";
		  mydata[4]= "cool coffee mug";
		  
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
