package athithan;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Interview3 {
	
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.naukri.com/");
		Set<String> windows=driver.getWindowHandles();
		for(String a:windows)
		{
			driver.switchTo().window(a);
			System.out.println(driver.getTitle());
			driver.close();
		}
	}

}
