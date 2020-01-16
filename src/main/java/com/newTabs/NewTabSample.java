package com.newTabs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabSample {

	@Test
	public void newTabSample() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://api.tekion.xyz/parts/receiving/floats");
		driver.manage().window().maximize();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("pritesh@tst.com");
		driver.findElement(By.id("password")).sendKeys("Tekion1234");
		driver.findElement(By.xpath("//button[./span[.='Login']]")).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'table_spinnerWrap')]")));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'table_spinnerWrap')]")));
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window - " + parentWindow);
		scrollIntoView(driver, By.xpath("//div[@role='tabpanel' and @aria-hidden='false']//button[@id = 'ADD_TO_INVENTORY' and ./span]"));		
		jsClick(driver, By.xpath("//div[@role='tabpanel' and @aria-hidden='false']//button[@id = 'ADD_TO_INVENTORY' and ./span]"));		
		System.out.println("All windows - " + driver.getWindowHandles().toString());
		List<String> windowsList = new ArrayList<String>(driver.getWindowHandles());
		String childWindow = windowsList.get(1);
		driver.switchTo().window(childWindow);
		System.out.println("Child Window - " + childWindow);
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='partId']"))).click();
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//div[.='Receipt Transactions']")).click();
		
	}
	
	public void scrollIntoView(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public void jsClick(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
}
