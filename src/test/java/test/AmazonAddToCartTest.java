package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AmazonAddToCartTest {
  @Test
  public void f() {
	  System.out.println("This is AmazonAddToCartTest  " + Thread.currentThread().getId());
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
