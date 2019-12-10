package gopi;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Interview3 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while (it.hasNext()) {
			String string = it.next();
			driver.switchTo().window(string);
			String title =driver.getTitle();
			System.out.println(title);
			driver.close();
		}
		
		
		
	}

}
