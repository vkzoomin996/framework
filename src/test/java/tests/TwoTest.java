package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base{
	@Test
	public void TwoTest() throws IOException, InterruptedException {
		System.out.println("Two Test");
		WebDriver driver= intializerDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		
		 
		
	}

}
