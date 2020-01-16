package com.selenium4;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.BrowserUpProxyServer;
import com.browserup.bup.client.ClientUtil;
import com.browserup.bup.proxy.CaptureType;
import com.browserup.harreader.model.Har;
import com.google.gson.Gson;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevToolsSample {

	public static void main2(String[] args) throws FileNotFoundException {
		WebDriverManager.chromedriver().setup();

		LoggingPreferences preferences = new LoggingPreferences();
		preferences.enable(LogType.BROWSER, Level.ALL);
		preferences.enable(LogType.CLIENT, Level.ALL);
		preferences.enable(LogType.DRIVER, Level.ALL);
		preferences.enable(LogType.PERFORMANCE, Level.ALL);
		preferences.enable(LogType.PROFILER, Level.ALL);
		preferences.enable(LogType.SERVER, Level.ALL);
		ChromeOptions option = new ChromeOptions();		
		option.setCapability( "goog:loggingPrefs", preferences ); // for new chrome

		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://api.tekion.xyz/vi/vehicles");

		//new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("pritesh@tst.com");
		driver.findElement(By.id("password")).sendKeys("Tekion1234");
		driver.findElement(By.xpath("//button[contains(@class,'loginButton')]")).click();
		StringBuffer sBuffer = new StringBuffer();
		LogEntries logs = driver.manage().logs().get(LogType.PERFORMANCE);		
		for (LogEntry entry : logs) {
			System.out.println(entry);
			if(entry.toString().contains("\"type\":\"XHR\"")) {	
				System.out.println(entry);
				sBuffer.append(new Date(entry.getTimestamp()) + " " + entry.toString() +" "+ System.getProperty("line.separator"));				
			}
		}
		System.out.println(sBuffer);
		driver.quit();
		System.out.println("Completed");
	}

	public static void main(String...arg)
	{
		WebDriverManager.chromedriver().setup();				

		DesiredCapabilities caps = new DesiredCapabilities();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

		Map<String, Object> perfLogPrefs = new HashMap<String, Object>();
		perfLogPrefs.put("traceCategories", "browser,devtools.timeline,devtools"); // comma-separated trace categories
		perfLogPrefs.put("enableNetwork", true);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("perfLoggingPrefs", perfLogPrefs);
		options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);		

		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), caps);
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://api.tekion.xyz/vi/vehicles");

		//new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("pritesh@tst.com");
		driver.findElement(By.id("password")).sendKeys("Tekion1234");
		driver.findElement(By.xpath("//button[contains(@class,'loginButton')]")).click();
		StringBuffer sBuffer = new StringBuffer();
		LogEntries logs = driver.manage().logs().get(LogType.PERFORMANCE);		
		for (LogEntry entry : logs) 
		{
			System.out.println("\n*********************************\n");
			Map<String, Object> map = entry.toJson();
			System.out.println(map);
			String message = (String) map.get("message");
			HashMap<String,Object> map2 = new Gson().fromJson(message, HashMap.class);
			System.out.println(map2);

			if(entry.toString().contains("\"type\":\"XHR\"")) {
				System.out.println("*****XHR*****");
				System.out.println(entry);
				sBuffer.append(new Date(entry.getTimestamp()) + " " + entry.toString() +" "+ System.getProperty("line.separator"));				
			}
		}
		System.out.println(sBuffer);
		driver.quit();
		System.out.println("Completed");
	}

	public static BrowserUpProxy proxy;	
	public static void main4(String[] args) {
		// start the proxy
		proxy = new BrowserUpProxyServer();
		proxy.start();

		// get the Selenium proxy object
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

		// configure it as a desired capability	    
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PROXY, seleniumProxy);

		// start the browser up
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		// enable more detailed HAR capture, if desired (see CaptureType for the complete list)
		proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);		

		// open yahoo.com
		driver.get("https://api.tekion.xyz/vi/vehicles");
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("pritesh@tst.com");
		driver.findElement(By.id("password")).sendKeys("Tekion1234");
		driver.findElement(By.xpath("//button[contains(@class,'loginButton')]")).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[./span[text()='Add Vehicle']]")));
		
		logProxyData();
		
		driver.findElement(By.xpath("//button[./span[text()='Add Vehicle']]")).click();
		// get the HAR data
		logProxyData();
		
		driver.quit();
		proxy.stop();
		System.out.println("Proxy stopped");
	}

	static int counter = 0;
	public static void logProxyData()
	{		
		Har har = proxy.getHar();
		int apiCount = 0;		
		
		for(int i=0;i<har.getLog().getEntries().size();i++)
		{

			String url = har.getLog().getEntries().get(i).getRequest().getUrl();
			String last3Chars = url.substring(url.length()-3, url.length());
			if(har.getLog().getEntries().get(i).getRequest().getUrl().contains("api.tekion.xyz")
					&& (last3Chars.contains("js") || last3Chars.contains("css")) == false)
			{
				apiCount++;
				System.out.println(har.getLog().getEntries().get(i).getRequest().getUrl());
				System.out.println(har.getLog().getEntries().get(i).getRequest().getMethod().toString());
				System.out.println(har.getLog().getEntries().get(i).getRequest().getComment());
				System.out.println(har.getLog().getEntries().get(i).getRequest().getHttpVersion());
				System.out.println(har.getLog().getEntries().get(i).getRequest().getBodySize());
				System.out.println(har.getLog().getEntries().get(i).getRequest().getMethod());
				//System.out.println(har.getLog().getEntries().get(i).getRequest().getPostData().getText());
				System.out.println(har.getLog().getEntries().get(i).getAdditional());

				System.out.println("Status = " + har.getLog().getEntries().get(i).getResponse().getStatus());
				System.out.println(har.getLog().getEntries().get(i).getResponse().getStatusText());
				System.out.println(har.getLog().getEntries().get(i).getResponse().getContent().getText());
				//System.out.println(har.getLog().getEntries().get(i).getResponse().getContent().toString());
				System.out.println(har.getLog().getEntries().get(i).getResponse().getAdditional());
			}
		}
		
		System.out.println("Api Count = " + apiCount);
		
		proxy.newHar("api.tekion.xyz" + counter++);
	}
}
