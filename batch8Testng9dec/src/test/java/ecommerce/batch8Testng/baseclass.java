package ecommerce.batch8Testng;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class baseclass {
	
	public WebDriver driver;
	
	  @BeforeMethod (alwaysRun = true)
	  @Parameters({"selectedbrowser"})
	  public void beforeMethod(String selectedbrowser) throws InterruptedException, IOException {
		  System.out.println("This is before Test");
		  
		  String brow=selectedbrowser;
		  
		  if (brow.contains("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\seleniumprject1\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();  // opening browser	
		  }
		  
		  else if (brow.contains("firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\eclipse-workspace\\seleniumprject1\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();  // opening browser	
		  }
		  
		  else {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\eclipse-workspace\\seleniumprject1\\Drivers\\msedgedriver.exe");
		driver=new EdgeDriver();  // opening browser
		  }
				
		    driver.get("https://www.facebook.com/");  // Navigate to Website
		    driver.manage().window().maximize();
		    Thread.sleep(5000);
		    shots_withCurrentDateTime();
		    System.out.println("This is before Test");
	  }
	  
	  @AfterMethod (alwaysRun = true)
	  public void afterMethod() throws InterruptedException {
		  System.out.println("This is after Test");
		  Thread.sleep(5000);
		  driver.close();
	  }
	  
	  
	  public void shots() throws IOException {
		File  cap =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(cap, new File("C:\\Users\\user\\eclipse-workspace\\batch8Testng\\screenshots\\1.png"));
	  }
	  
	  public void shots_withArgs(String filename) throws IOException {
		File  cap =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(cap, new File("C:\\Users\\user\\eclipse-workspace\\batch8Testng\\screenshots\\"+ filename +".png"));
	  }
	  
	  public void shots_withCurrentDateTime() throws IOException {
		  Date dt = new Date();
		String filename =  dt.toString().replace(" ", "_").replace(":", "_");
		  
		File  cap =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(cap, new File("C:\\Users\\user\\eclipse-workspace\\batch8Testng\\screenshots\\"+ filename +".png"));
	  }
	  

}
