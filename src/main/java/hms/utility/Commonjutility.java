package hms.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hms.base.Testbase;

public class Commonjutility extends Testbase {
	
	//Mouseclick
 public static void clickonwebelement(WebElement el)
{
	 Actions act=new Actions(driver);
	 act.click(el).build().perform();
}
	
//File upload
 public static void uploadfile(String loc)
 {
	 StringSelection sel=new StringSelection(loc);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		
		
		Robot rb;
		try {
			Thread.sleep(4000);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
 }
 
//Explicity wait
 public static void waitforelement(WebElement el)
 {
	 WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(70));
	 wt.until(ExpectedConditions.visibilityOf(el));
	 
 }
 
 //Screen shot onfail
 public static void screenshot()
 {
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 File des=new File("./src/main/java/Screenshots"+System.currentTimeMillis()+".png");
	 
	 try {
		FileHandler.copy(src, des);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 
 
 

}
