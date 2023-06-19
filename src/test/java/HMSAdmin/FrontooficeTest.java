package HMSAdmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Frontofficepage;
import hms.pages.LoginPage;

public class FrontooficeTest extends Testbase{

	LoginPage objlog;
	Frontofficepage objff;
	
	public FrontooficeTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilization();
		objlog=new LoginPage();
		objff=new Frontofficepage();
		
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	
	@Test
	public void frontofficetest()
	{
		objff.clickonfrontoffice();
		String Expectedtabletitle="Appointment Details";
		String Actualtabletitle=objff.gettabletitle();
		
		Assert.assertEquals(Expectedtabletitle, Actualtabletitle);
		
		objff.clickonvistorbook();
		
		
	}
}
