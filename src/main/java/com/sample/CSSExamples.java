package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSExamples {

	@FindBy(xpath="usernames")
	public WebElement username;

	@Test(enabled=true)
	public void temp() throws Throwable{
		WebDriver driver = null;
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			PageFactory.initElements(driver, this);
			driver.get("https://api.tekion.xyz/parts/receiving/floats");
			Thread.sleep(5000);
			//driver.findElement(By.id("usernames")).sendKeys("Ahamed");		
			username.sendKeys("Ahamed");
		}finally {
			if(driver != null)
				driver.quit();
		}
	}
}
