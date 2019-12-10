package com.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickSample
{

	static WebDriver driver;
	public static void main(String...arg)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	static void WebElementClick()
	{
		driver.get("https://api.tekion.xyz/ro/home");
	}
}
