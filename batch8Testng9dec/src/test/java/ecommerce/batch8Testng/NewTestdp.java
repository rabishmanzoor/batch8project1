package ecommerce.batch8Testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class NewTestdp extends baseclass {
  @Test(dataProvider = "dp")
  public void f(String email, String pass) throws InterruptedException {
	  
	  HomeAmazon ob = new HomeAmazon(driver);
	     ob.enterEmail(email); 
		 Thread.sleep(5000);
		 ob.enterPass(pass);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "abc@yahoo.com", "aaaaaaaa" },
      new Object[] { "def@yahoo.com", "bbbbbbbb" },
    };
  }
}
