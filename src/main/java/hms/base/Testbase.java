package hms.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import hms.utility.Activitycapture;

public class Testbase {

	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver eve;
	public static Activitycapture acp;
	
	public Testbase()
	{
		FileInputStream config;
		try {
			config = new FileInputStream("./src/main/java/hms/configuration\\appconfig.properties");
			prop=new Properties();
			prop.load(config);
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void initilization()
	{
		String browsername=prop.getProperty("Browser");
		if(browsername.equals("chrome"))
		{
			if(prop.getProperty("HEADLESS").equals("true"))
			{
				ChromeOptions opt=new ChromeOptions();
				 opt.addArguments("--headless,--remote-allow-origins=*");
				
				driver=new ChromeDriver(opt);
			}
			else
			{
				  ChromeOptions opt1=new ChromeOptions();
				  
				   opt1.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(opt1);
			}
		}
		else if(browsername.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(browsername.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Plz check your browser name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		driver.get(prop.getProperty("URL"));
		
		acp=new Activitycapture();
		eve=new EventFiringWebDriver(driver);
		eve.register(acp);
		driver=eve;
			
	}
	
	
	
	
	
	
	
}
