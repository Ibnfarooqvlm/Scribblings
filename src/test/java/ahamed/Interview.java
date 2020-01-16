package ahamed;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Interview 
{
	WebDriver driver = null;
	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test(enabled=false)
	public void temp1()
	{
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		for(int i=1;i<list.size();i++)
		{
			driver.switchTo().window(list.get(i)).close();
		}
	}

	@Test(enabled=true)
	public void temp2()
	{
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Stop Watch");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//g-button[contains(@class,'act-desktop-button')]/span[text()='Start']")).click();
		
		int num = 0;
		do {
		String text = driver.findElement(By.xpath("(//span[text()='s']/preceding-sibling::span[1])[1]")).getText();
		num = Integer.parseInt(text);
		}while(num < 5);
		
		driver.findElement(By.xpath("//g-button[contains(@class,'act-desktop-button')]/span[text()='Stop']")).click();
	}
}