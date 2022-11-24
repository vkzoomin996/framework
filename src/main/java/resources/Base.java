package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
 
 public  WebDriver driver;
//	protected static WebDriver driver; 
 public static Logger log;
	public Properties prop;
	public WebDriver intializerDriver() throws IOException {
		
		prop=new Properties();
		String proPath =  "C:\\Users\\Veeresha K\\Downloads\\Eclipse 2022\\FrameworkProject\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis =new FileInputStream(proPath);
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
public String takescreenshot(String testMethodName,WebDriver driver) throws IOException {
	File SourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destinationFilePath="C:\\Users\\Veeresha K\\Downloads\\Eclipse 2022\\FrameworkProject\\Screenshots\\testMethodName.png";
	FileUtils.copyFile(SourceFile,new File( destinationFilePath));
	return destinationFilePath;
	
 }
}
