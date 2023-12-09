package ecommerce.batch8Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomeAmazon {
	
	public static WebDriver driver;
	
	@FindBy(xpath="(//*[contains(text(),'Best Sellers')])[1]") WebElement BestSellers;
	@FindBy(xpath="(//*[contains(text(),'Amazon Basics')])[1]") WebElement AmazonBasics;
	@FindBy(xpath="(//*[contains(text(),'Connect with')])[1]") WebElement facebookActualText;
	@FindBy(xpath="//*[@name='email']") WebElement facebookEmailField;
	@FindBy(xpath="//*[@name='pass']") WebElement facebookPassField;
	
	
	public HomeAmazon(WebDriver driver) {
		HomeAmazon.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public void enterEmail(String email) {
		facebookEmailField.sendKeys(email);
	}
	
	public void enterPass(String pass) {
		facebookPassField.sendKeys(pass);
	}

	
	public void bestSellersClick() {
		BestSellers.click();
	}
	
	public void amazonBasicsClick() {
		AmazonBasics.click();
	}
	
	public void getFacebookActualTextComparison() {
	String stringfacebookActualText =	facebookActualText.getText();
//	Assert.assertEquals(stringfacebookActualText, "Connect with friends and the world99 around you on Facebook.");
	
	SoftAssert sf = new SoftAssert();
	sf.assertEquals(stringfacebookActualText, "Connect with friends and the world99 around you on Facebook.");
	System.out.println("This text is after failed assertion");
	sf.assertAll();
	}


}
