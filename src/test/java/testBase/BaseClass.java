package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
/*generally test data contain two type
 * i.static data
 * 2.dynamic data-for dynamic data we use randomStringUtils*/
public class BaseClass {
	public static WebDriver driver;
	public Logger logger;//log4j
	public Properties p;//properties
    @BeforeClass(groups= {"Regression","Sanity","master","Data Driven Testing"})
    @Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException {
    	
    	//loading config file
    	FileReader file=new FileReader("./src//test//resources//config.properties");
    	//FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
    	p=new Properties();
    	p.load(file);
    	
    	logger=LogManager.getLogger(this.getClass());
    	
    	switch(br.toLowerCase()) {
    	case "chrome":driver=new ChromeDriver(); break;
    	case "firefox":driver=new FirefoxDriver();break;
    	case "edge":driver=new EdgeDriver();break;
    	default:System.out.println("invalid browser");return;
    	}
		
		driver.get(p.getProperty("appurl"));//reading url from property file
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"Regression","Sanity","master","Data Driven Testing"})
	public void tearDown() {
		driver.quit();
	}
	public String randomString() {//generate random string and random number using RandomStringUtils(predefined class) and it contain static randomalphabetic method
		String generatedString= RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	public String randomNumeric() {
		String generatedNumber=RandomStringUtils.randomNumeric(10);//generate random number
		return generatedNumber;
	}
	public String randomAlphaNumeric() {
		String generatedString= RandomStringUtils.randomAlphabetic(8);
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return(generatedString+"@"+generatedNumber);
	}
	
	//capture screen shot
	public String captureScreen(String tname) throws IOException {
		
		        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		        

		        // Take a screenshot
		        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		       File sourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);
		       
		       String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timestamp + ".png";  
		        File targetFile = new File(targetFilePath);

		        sourceFile.renameTo(targetFile);

		        return targetFilePath;
		    }
	

		       
	}

