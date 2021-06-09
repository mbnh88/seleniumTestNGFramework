package test;

import org.testng.annotations.Test;

import utilities.Driver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class NewTest {
  @Test (dataProvider="myDataBucket")
  public void test(String input) {
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
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

}
