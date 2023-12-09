package ecommerce.batch8Testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class NewTest extends baseclass {
	

  @Test (groups = {"regression"})
  public void Test1() throws InterruptedException, IOException {
	  System.out.println("This is Test 1");
	  
	  Properties prop = new Properties();
	  FileInputStream fin = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\batch8Testng\\userdetails.properties");
	  prop.load(fin);
	  
	  String email = prop.getProperty("Email");
	  String password = prop.getProperty("Password");
	  
HomeAmazon ob = new HomeAmazon(driver);
     ob.enterEmail(email);
     shots_withCurrentDateTime();
	 Thread.sleep(5000);
	 ob.enterPass(password);
	 shots_withCurrentDateTime();
  }
  
  @Test (groups = {"regression"})
  public void Test2() throws InterruptedException, IOException {
	  System.out.println("This is Test 1");
	  
HomeAmazon ob = new HomeAmazon(driver);
     ob.enterEmail("abc@yahoo.com");
     shots_withCurrentDateTime();
	 Thread.sleep(5000);
	 ob.enterPass("aaaaaaa");
	 shots_withCurrentDateTime();
  }
  
  
}
