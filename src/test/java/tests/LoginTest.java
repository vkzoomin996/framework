package tests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;
import org.apache.logging.log4j.*;
public class LoginTest extends Base{
	Logger	log;
	WebDriver driver;
	@Test
	public void login() throws IOException, InterruptedException {
	log= LogManager.getLogger(LoginTest.class.getName());
		

		  driver=intializerDriver();
		driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		lp.myAccountDropdown().click();	
		log.info("MyAccount is clicked");
		
		 lp.loginOption().click();
			log.info("loginoption is clicked");

		 Thread.sleep(3000);
		 LoginPage lop=new LoginPage(driver);
		 lop.emailAddress().sendKeys(prop.getProperty("email"));		
		 log.info("username is entered ");

		 lop.password().sendKeys(prop.getProperty("password"));
		 log.info("password is entered ");

		 Thread.sleep(3000);
		 lop.loginButton().click();		 log.info("click on  loginButton ");

		 AccountPage aop= new AccountPage(driver);
		 Thread.sleep(3000);
		 Assert.assertTrue(aop.editAccountInfo().isDisplayed());
		 log.info("succesfully logined to yourstore page");
	}
	@AfterMethod
public void teardown() {
	driver.quit();;
}
	}
