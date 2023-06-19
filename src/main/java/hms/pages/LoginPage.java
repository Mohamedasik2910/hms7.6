package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;

public class LoginPage extends Testbase {
	
	@FindBy(css="img[src='http://triotend.com/tts/backend/images/s_logo.png']")WebElement logo;
	@FindBy(css="h3.font-white")WebElement logintitle;
	@FindBy(css="input#email")WebElement username;
	@FindBy(css="input#password")WebElement password;
	@FindBy(css="button.btn")WebElement signin;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getpagetitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean logodisplayed()
	{
		return logo.isDisplayed();
		
	}
	
	
	public String getscreentitle()
	{
		return logintitle.getText();
		
	}
	
	
   public void loginhms(String uname,String pwd)
   {
	   username.sendKeys(uname);
	   password.sendKeys(pwd);
	   signin.click();
   }

}
