package gopi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StopWatch 
{
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		// Open URL
		driver.get("https://www.google.com/?gws_rd=ssl");
		
		driver.findElement(By.name("q")).sendKeys("");
		
		
		

	}
}
