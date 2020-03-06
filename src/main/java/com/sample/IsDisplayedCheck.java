package com.sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsDisplayedCheck {

	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.amitrawat.tech/post/mystery-of-stale-element-reference-exception/");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Throwable {

		try {
			//WebElement element = driver.findElement(By.cssSelector("h2#refreshing-the-element-whenever-it-gets-stale"));
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-role='textarea']")));
			//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.community-name")));
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,6000)");
			//WebElement element = driver.findElement(By.cssSelector("span.comment-count"));

			/*List<WebElement> elements = driver.findElements(By.xpath("(//nav[@id='TableOfContents']/ul/li/ul)[1]/li/a"));

		for(WebElement element:elements) {
			System.out.println(element.getAttribute("innerText"));			
		}*/

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement E = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//iframe[@title='Disqus'])[1]")));						
			WebElement E1 = wait.until(ExpectedConditions.visibilityOf(E));
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].scrollIntoView()", E);			
			driver.switchTo().frame(E);
			WebElement communityName = driver.findElement(By.cssSelector("span.community-name"));
			System.out.println(communityName.isDisplayed());
		}catch(Throwable t) {
			throw t;
		}
	}

	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}


}
