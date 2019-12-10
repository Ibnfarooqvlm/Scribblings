package com.important;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleSample2 {

	@FindBy(id="login_field")
	public WebElement username;
	
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="//input[@value='Sign in']")
	public WebElement submit;
	
	public StaleSample2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://github.com/login");

		StaleSample2 lp = new StaleSample2(driver);
		lp.username.sendKeys("amod");
		lp.password.sendKeys("dsds");
		lp.submit.click();
		Thread.sleep(1000);
		lp.username.clear();
		lp.username.sendKeys("oiiu");
		lp.password.sendKeys("lklkj");
		lp.submit.click();


	}
}
