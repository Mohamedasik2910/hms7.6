package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Commonjutility;
import hms.utility.Datepicker;

public class VistorPage extends Testbase {

	@FindBy(css="h3.box-title")WebElement tabletxt;
	@FindBy(css="div.box-tools>a")WebElement addvistor;
	@FindBy(xpath="//h4[text()=' Add Visitor']")WebElement screentitle;
	
	@FindBy(css="form#formadd select[name='purpose']")WebElement purpose;
	@FindBy(css="form#formadd input[name='name']")WebElement pname;
	@FindBy(css="form#formadd input[name='contact']")WebElement phno;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement idpro;
	@FindBy(css="form#formadd input[name='pepples']")WebElement noper;
	@FindBy(css="form#formadd input[name='date']")WebElement datepicker;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='file']")WebElement upfile;
	
	@FindBy(css="button.close123")WebElement closeScreen;
	
	
	public VistorPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String gettabletitle()
	{
		return tabletxt.getText();
	}
	
	public void clickonaddvistor()
	{
		addvistor.click();
	}
	
	public String getscreentitle()
	{
		Commonjutility.waitforelement(screentitle);
		return screentitle.getText();
		
	}
	
	public void addvistordetails(String data[])
	{
		Select drp=new Select(purpose);
		drp.selectByVisibleText(data[0]);
		
		pname.sendKeys(data[1]);
		phno.sendKeys(data[2]);
		idpro.sendKeys(data[3]);
		noper.sendKeys(data[5]);
		note.sendKeys(data[6]);
		
		datepicker.click();
		Datepicker dt=new Datepicker();
		dt.datpicker(data[4]);
		Commonjutility.clickonwebelement(upfile);
		Commonjutility.uploadfile(data[7]);
		
		closeScreen.click();
		
	}
	
	
}
