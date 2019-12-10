package com.important;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleSample {

	static WebDriver driver;
	
	@FindBy(name = "p")
	private WebElement search2;
	
	public StaleSample(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public static void main(String...arg)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		StaleSample ss = new StaleSample(driver);
		driver.get("https://www.yahoo.com");
		driver.manage().window().maximize();
		/*By by = By.name("p");
		WebElement search = driver.findElement(by);*/
		sendKeys(ss.search2,"Ahamed");
		driver.navigate().refresh();
		ss=new StaleSample(driver);
		sendKeys(ss.search2,"Abdul");	
	}
	
	/*public static void sendKeys(WebElement element,String s)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(s);
	}*/
	
	public static void sendKeys(WebElement e,String s)
	{
		e.sendKeys(s);
	}
}
