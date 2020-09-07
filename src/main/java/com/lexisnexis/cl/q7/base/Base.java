package com.lexisnexis.cl.q7.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.lexisnexis.cl.q7.utillity.TestUtil;
import com.lexisnexis.cl.q7.utillity.WebEventListener;

public class Base {
	public String browserName;
	public Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public Base() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\SING110\\Documents\\JAVARELATEDITEMS\\POMWorkspace\\CounselLink\\src\\main\\java\\com\\lexisnexis\\cl\\q7\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void initialization() {
		browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SING110\\Documents\\JAVARELATEDITEMS\\BrowserEXE\\Chrome85\\"
					+ "chromedriver_win32 (2)\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SING110\\Documents"
					+ "\\JAVARELATEDITEMS\\BrowserEXE\\chromedriver_win32\\firefoxdriver.exe");
			 driver = new FirefoxDriver();
		}else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\SING110\\Documents"
					+ "\\JAVARELATEDITEMS\\BrowserEXE\\chromedriver_win32\\internetexplorerdriver.exe");
			 driver = new InternetExplorerDriver();
		}else
			System.out.println("Browser is not found");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitllyWait, TimeUnit.SECONDS);
		driver.get((prop.getProperty("url")));
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		
		
		
		
		
		
	}
	
	
}
