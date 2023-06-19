

package HMSAdmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Frontofficepage;
import hms.pages.LoginPage;
import hms.pages.VistorPage;
import hms.utility.ReadExcel;

public class Vistortest extends Testbase{
	
	LoginPage objlog;
	Frontofficepage objff;
	VistorPage objvis;
	
	public Vistortest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilization();
		objlog=new LoginPage();
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		
		objff=new Frontofficepage();
		objff.clickonfrontoffice();
		objff.clickonvistorbook();
		
		objvis =new VistorPage();
		
	}
	@DataProvider
	public Object[][] getvistordata()
	{
		Object[][]data=ReadExcel.getTestData("testdata");
		return data;
		
	}
	@Test(dataProvider="getvistordata")
	public void vistordetailstest(String vis[])
	{
		String Expectedtabletitle="Visitor List";
		String Actualtabletitle=objvis.gettabletitle();
		
		Assert.assertEquals(Expectedtabletitle, Actualtabletitle);
		
		objvis.clickonaddvistor();
		
		String Expectedscreentitle="Add Visitor";
		String Actualscreentitle=objvis.getscreentitle();
		
		Assert.assertEquals(Actualscreentitle, Expectedscreentitle);
		objvis.addvistordetails(vis);
	}
	

}
