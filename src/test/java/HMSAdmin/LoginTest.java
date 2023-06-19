package HMSAdmin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.LoginPage;

public class LoginTest extends Testbase {
	
	LoginPage objlog;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilization();
		objlog=new LoginPage();
	}
	
	@Test
	public void loginhmstest()
	{
		String Expectedtitle="Smart Hospital : Hospital Management System";
		String Actualtitle=objlog.getpagetitle();
		Assert.assertEquals(Actualtitle, Expectedtitle);
		
		Assert.assertTrue(objlog.logodisplayed());
		
		String Excpectedscreentitle="Admin Login";
		String Actualscreentitle=objlog.getscreentitle();
		
		Assert.assertEquals(Actualscreentitle, Excpectedscreentitle);
		
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		
		
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
