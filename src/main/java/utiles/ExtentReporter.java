package utiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;
public class ExtentReporter extends TestListenerAdapter{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	

	public void onStart(ITestContext testContext)
	{
		
	String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());//timestamp
	String repName="Test-Report-"+timestamp+"html";
	htmlReporter =new ExtentHtmlReporter("C:\\Users\\Veeresha K\\Downloads\\Eclipse 2022\\FrameworkProject\\test-output\\v123.html");//specify location
	//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	extent =new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Host name", "local name");
	extent.setSystemInfo("Environement ", " QA");
    extent.setSystemInfo("  user", " Veeresha k");
    
    htmlReporter.config().setDocumentTitle("Framework Project");//title of report
    htmlReporter.config().setReportName("Functional Test Report");//name of the report
    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location Of the Chart
    htmlReporter.config().setTheme(Theme.DARK);
	}
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());// create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());// create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		String screenshotPath=  System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(screenshotPath);
		if(f.exists())
		{
			try {
				logger.fail("screenshot is below" + logger.addScreenCaptureFromPath(screenshotPath));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());// create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	 
	
	}


			
			
			
			
			
			
			
			
			
			
			
	
				


	
    
    
    
    
    
    
    
    
    
    
    
    
    
