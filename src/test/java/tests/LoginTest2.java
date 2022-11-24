package tests;
//method 2
import java.io.IOException;

 import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.aventstack.extentreports.model.Log;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;


public class LoginTest2 extends Base{
	 Logger log;
	WebDriver driver;
	@Test(dataProvider="getLoginData")
	public void login2(String email,String password,String exceptedResult ) throws IOException, InterruptedException {
		  
		LandingPage lp=new LandingPage(driver);
		lp.myAccountDropdown().click();
		log.info("clicked on on my Account dropdown");
		Thread.sleep(3000);
		 lp.loginOption().click();
			log.info("clicked on login option");

		 LoginPage lop=new LoginPage(driver);
		 lop.emailAddress().sendKeys(email);
			log.info("emailAddress  got entered");

		 lop.password().sendKeys(password);
			log.info("password  got entered");

		 Thread.sleep(3000);
		 lop.loginButton().click();
			log.info("Clicked on Login button");

		 
		 AccountPage aop= new AccountPage(driver);
		 String actualResult=null;
		 try {
			 if(aop.editAccountInfo().isDisplayed()) {
				 actualResult="succesfull";
					log.info("user  got logged in");

			 }
		 }catch(Exception e) {
				log.info("user  didn't  log in");

			 actualResult="failure";
		 }
		 Assert.assertEquals(actualResult, exceptedResult);
			log.info("login test  got passed");

	}
	@BeforeMethod
	public void openApplication() throws IOException {
	log  =   LogManager.getLogger(LoginTest2.class.getName());
		//PropertyConfigurator.configure(" C:\\Users\\Veeresha K\\Downloads\\Eclipse 2022\\FrameworkProject\\${basePath}");
		 driver = intializerDriver();
		 log.info("browser got launched");
			driver.get(prop.getProperty("url"));
			}
		
@AfterMethod
public void teardown() {
	driver.close();
	 log.info("browser got closed");

	
}
@DataProvider
public Object[][] getLoginData(){
	Object[][] data= {{"vkzoomin996@gmail.com","Veereshak@996","succesfull"},{"vkin996@gmail.com","Veereshak@2996","failure"}};
return data;	
}
	}
