package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle bundle;
	
	@BeforeClass(groups = {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setUp(String browser) {
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*");
		 */
		//the below chrome options code is used to eliminate the "Chrome is being controlled by automated test software" on the opened browser
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		logger = LogManager.getLogger(this.getClass()); // logging
		
		bundle = ResourceBundle.getBundle("config"); // Load config.properties  file
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(bundle.getString("URL"));
		
	}
	
	@AfterClass(groups = {"Master","Sanity","Regression"})
	public void tearDown() {
		
		driver.close();
	}
	
	public String randomString() {
		
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	public String randomNumber() {
		
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		
		String alpha = RandomStringUtils.randomAlphabetic(4);
		String numeric = RandomStringUtils.randomNumeric(3);
		
		return (alpha+"@"+numeric);
	}
	
	public String CaptureScreen(String tname) {
		
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); // timestamp generation
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+ tname + "-" + timestamp + ".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
