package utilities;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

/*Extent Report basically what a third party report .To implement extent report we need to have some third party dependency .we need to add because this is a third party.*/
public class ExtentReport implements ITestListener{
	public static ExtentSparkReporter sparkReporter;  //ui of the report
    public static ExtentReports extentReports; //populate common info on the report
    public static ExtentTest test;//creating test case entries in report and update status of the test method
   // public static WebDriver driver;

    String repName;
    @Override
    public void onStart(ITestContext testContext) {
        // Define the report location
    	 String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//generating time stamp
    	 repName="Test-Report-"+timestamp+".html";
    	          //reportname concat with time stamp in html format and store in varaible that report store in below given path
       
        sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);//specify location of report and maintain history of reports
        sparkReporter.config().setDocumentTitle("opencart Automation Report");//title of report
        sparkReporter.config().setReportName("opencart Functional Testing");//name of report
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        
        extentReports.setSystemInfo("Application","opencart");
        extentReports.setSystemInfo("Module","Admin");
        extentReports.setSystemInfo("Sub Module","Customers");
        extentReports.setSystemInfo("User Name",System.getProperty("user.name"));//to get current user of system
        extentReports.setSystemInfo("Environment","QA");
        
        String os=testContext.getCurrentXmlTest().getParameter("os");//capture os dymanically from xml file to extent report
        extentReports.setSystemInfo("Operating System", os);
        
        String browser=testContext.getCurrentXmlTest().getParameter("browser");//capture browser dymanically from xml file to extent report
        extentReports.setSystemInfo("Browser", browser);
        
        List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();//getcurrentxml return xml file.getincludedgroup method will return /capture groups which we have specified in include section and display in report
        if(!includedGroups.isEmpty()) {//validate is there any group.if there any group then
        	extentReports.setSystemInfo("Groups", includedGroups.toString());//add group name to report
        }
        }
        
    


    @Override
    public void onTestSuccess(ITestResult result) {
    	test = extentReports.createTest(result.getTestClass().getName());//then result is trigger we get  classname from that we get name of class and creating new entry in reports
    	test.assignCategory(result.getMethod().getGroups());//to display groups in report
        test.log(Status.PASS,  result.getName()+ " got successfully executed");//update status p/f/s
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
    	test=extentReports.createTest(result.getName());
    	test.assignCategory(result.getMethod().getGroups());
    	
        test.log(Status.FAIL,  result.getName()+" got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());
        
        try {
        	String imgPath=new BaseClass().captureScreen(result.getName());//call capture screenshot method in base class.in base class these capture screenshot method return path/location in string format
        	test.addScreenCaptureFromPath(imgPath);//attach screen shot to report
        }catch(IOException e1) {//we use try and catch because if screenshot is not properly taken but still trying to attach screenshot to report in that case we get file not fount exception
        	e1.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	test=extentReports.createTest(result.getTestClass().getName());
    	test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName()+ " got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        String pathofExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;//after generating report it open automatically instead of manually
        File extentReport=new File(pathofExtentReport);
        try {
        	Desktop.getDesktop().browse(extentReport.toURI());//open report on browser automaticaly
        }catch(IOException e) {
        	e.printStackTrace();
        }
    }
    }

 