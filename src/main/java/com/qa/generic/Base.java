package com.qa.generic;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base() {
		prop=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\qa\\config\\config.properties");
		
		dataProp=new Properties();
		File dataPropFile=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\qa\\testdata\\testdata.properties");
		
		try {
		FileInputStream dataPropFis=new FileInputStream(dataPropFile);
		dataProp.load(dataPropFis);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		try {
		FileInputStream propFis=new FileInputStream(propFile);
		prop.load(propFis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Parameters("browser")
	@BeforeMethod
	public synchronized void openBrowser(@Optional("chrome") String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
	}
	
	
	  @AfterMethod public synchronized void quitBrowser() { 
		  driver.quit(); 
	  
	  }
	 
}
