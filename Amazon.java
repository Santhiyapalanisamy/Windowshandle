package windowhandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		String parentWindowId = driver.getWindowHandle();
		System.out.println(parentWindowId);
		WebElement text = driver.findElement(By.id("twotabsearchtextbox"));
		text.sendKeys("iphone 14 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		driver.findElement(By.className("s-image")).click();
		Set<String> childWindowId = driver.getWindowHandles();
		System.out.println(childWindowId);
		
		 for (String allwindows : childWindowId) {
			 if(!allwindows.equals(parentWindowId)) {
			 driver.switchTo().window(allwindows);
			 driver.findElement(By.id("add-to-cart-button")).click();
			 driver.close();
		}
		
	
	}

}}
