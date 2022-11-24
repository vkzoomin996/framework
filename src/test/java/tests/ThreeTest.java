package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	@Test
	public void TwoTest() throws IOException, InterruptedException {
		System.out.println("Two Test");
		WebDriver driver= intializerDriver();
		driver.get("https://www.swiggy.com/");
		Thread.sleep(3000);
		
		
		 
		
	}

}
