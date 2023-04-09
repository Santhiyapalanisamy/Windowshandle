package windowhandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {
	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		String parentWindowId = driver.getWindowHandle();
		System.out.println(parentWindowId);
	    driver.findElement(By.id("newWindowBtn")).click();
	    
	    Set<String> allWindowsId = driver.getWindowHandles();
	    System.out.println(allWindowsId);
	    
	    for (String allWindows : allWindowsId) {
	    	if(!allWindows.equals(parentWindowId)) {
	    		driver.switchTo().window(allWindows);
	    		driver.findElement(By.id("firstName")).sendKeys("Santhiya");
	    		Thread.sleep(2000);
	    		driver.close();		
	    	}	
		}
	    driver.switchTo().window(parentWindowId);
	    WebElement text =  driver.findElement(By.xpath("//*[@id='name']"));
	    text.sendKeys("Bye Bye");
	    System.out.println(text.getAttribute("value"));
	    driver.quit();	
	}

}
