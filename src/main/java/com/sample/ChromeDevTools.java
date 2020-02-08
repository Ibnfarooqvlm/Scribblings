package com.sample;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.openqa.selenium.devtools.network.model.InterceptionStage;import org.openqa.selenium.devtools.network.model.LoadingFailed;
import org.openqa.selenium.devtools.network.model.RequestPattern;
import org.openqa.selenium.devtools.network.model.ResourceType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevTools {

	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeMethod()
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession();
	}
	
	@AfterMethod()
	public void afterMethod() {
		devTools.close();
		driver.quit();
	}
	
	@Test(enabled=true)
	public void enableNetworkOffline() {
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.send(Network.emulateNetworkConditions(true, 100, 1000, 2000, Optional.of(ConnectionType.CELLULAR3G)));
		devTools.addListener(Network.loadingFailed(), LoadingFailed -> assertEquals(LoadingFailed.getErrorText(),"net::ERR_INTERNET_DISCONNECTED"));
		
		driver.get("https://www.google.com");
	}
	
	@Test(enabled=true)
	public void interceptRequest() {
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
	}
	
	@Test(enabled=false)
    public void interceptRequestAndContinue(ChromeDriver chromeDriver, DevTools chromeDevTools) {

        //enable Network
        chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        chromeDevTools.send(Network.setBlockedURLs(Arrays.asList("*.css","*.jpg")));

        //add listener to intercept request and continue
        chromeDevTools.addListener(Network.requestIntercepted(),
                requestIntercepted -> chromeDevTools.send(
                        Network.continueInterceptedRequest(requestIntercepted.getInterceptionId(),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty(), Optional.empty(),
                                Optional.empty(),
                                Optional.empty(), Optional.empty())));
        
        chromeDevTools.addListener(Network.requestIntercepted(),null);
        
        //set request interception only for css requests
        //RequestPattern requestPattern = new RequestPattern("*.css", ResourceType.STYLESHEET, InterceptionStage.HEADERSRECEIVED);
        RequestPattern requestPattern = new RequestPattern("*", ResourceType.XHR, InterceptionStage.HEADERSRECEIVED);
        chromeDevTools.send(Network.setRequestInterception(ImmutableList.of(requestPattern)));

        chromeDriver.get("https://apache.org");

    }
}
