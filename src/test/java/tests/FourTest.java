package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base{
	public	WebDriver driver;
	@Test
	public void testfour() throws IOException, InterruptedException {
		System.out.println("Two Test");
		driver= intializerDriver();
		driver.get("http://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		 
		Assert.assertTrue(false);
		takescreenshot("FourTest",driver);

 	}
	@AfterMethod
	public void closingBrowser() {
		driver.close();
		
		
		 
		
	}

}
