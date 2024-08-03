package com.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
	protected WebDriver driver;
	DesiredCapabilities capability = new DesiredCapabilities();
	ChromeOptions options=null;
	public static String browserNam;
	public static String OSdetails = "";
	
	String browserName="";
	String localBrowserPath="";
	String sel;
	Boolean selGrid = null;
	String nodeURL="";
	String os="";
	String loginurl="";
	Map<WebDriver, String> drivers = new HashMap<>();
	
	
	@Parameters({ "browserName", "selGrid", "nodeURL","os","environment"})
	@BeforeTest(alwaysRun = true)
	public void beforeMethod(ITestContext context,@Optional("chrome") String browserName,@Optional("false") Boolean selGrid,@Optional("http://172.16.6.28:5555/wd/hub") String nodeURL, 
			@Optional("Windows")String os,String environment) throws MalformedURLException, Exception
	{
		
	System.out.println("---- bASE TEST ---- ");

		loginurl= environment;
		
		browserNam=browserName;
		
		String thread = Thread.currentThread().getName();
		
		switch(os.toUpperCase()){
		
		case "WINDOWS" :
		
		switch (browserName.toUpperCase()) {

		 case "HEADLESS":
           
             WebDriverManager.chromedriver().setup();

             ChromeOptions chromeOptions = new ChromeOptions();
             chromeOptions.addArguments("--headless");
             chromeOptions.addArguments("--disable-gpu");
             chromeOptions.addArguments("--window-size=1280,1024");
             chromeOptions.addArguments("--ignore-certificate-errors");

             capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
             capability.setPlatform(Platform.ANY);

             if (selGrid) {
                 try {
                     driver = new RemoteWebDriver(new URL(nodeURL), capability);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             } else {
                 driver = new ChromeDriver(chromeOptions);
             }

             drivers.put(driver, thread);
             break;

		 case "CHROME":
             
             WebDriverManager.chromedriver().setup();
             
             ChromeOptions options = new ChromeOptions();
             options.addArguments("start-maximized");
             options.addArguments("no-default-browser-check");
             options.addArguments("--remote-debugging-port=9225");
             options.addArguments("--no-sandbox");
             options.addArguments("--disable-popup-blocking");
             options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
             capability.setCapability(ChromeOptions.CAPABILITY, options);
             capability.setCapability("acceptInsecureCerts", true);
             capability.setPlatform(Platform.ANY);

             if (selGrid) {
                 System.out.println("Inside SEL Grid Chrome block");
                 try {
                     driver = new RemoteWebDriver(new URL(nodeURL), capability);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             } else {
                 driver = new ChromeDriver(options);
             }

             drivers.put(driver, thread);
             System.out.println(driver+"base test");
             break;

		}
		
		driver.manage().window().maximize();

		driver.get(loginurl);
		System.out.println(loginurl);
		
		
		Set<String> handles = driver.getWindowHandles();
		if (handles.size() > 1) {
			Iterator<String> it = handles.iterator();
			while (it.hasNext()) {
				String parent = it.next();
				String newwin = it.next();
				driver.switchTo().window(newwin).close();
				driver.switchTo().window(parent);
			}
		}
	}
		
	}

	 @AfterTest
	   public void afterTest()
	   {
		   driver.close();
	   }
 

}

