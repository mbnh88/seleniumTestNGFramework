package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AmazonCreateAccountTest {
  @Test
  public void f() {
	  System.out.println("This is AmazonCreateAccountTest" + Thread.currentThread().getId());
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
