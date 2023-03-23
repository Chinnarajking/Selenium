package com.seleni;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {
 public static void main(String[] args) {
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("--remote-allow-origins=*");
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver(options);
	 driver.get("https://www.amazon.in/");
	 
	 driver.manage().window().maximize();

	 //Windows Handling
	 
	 String parentWindowId = driver.getWindowHandle();
	 System.out.println(parentWindowId);
	 
	 WebElement textBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		textBox.sendKeys("Iphone 13");

		WebElement search = driver.findElement(By.id("nav-search-submit-button"));
		search.click();

		WebElement iphoneRed = driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]"));
		iphoneRed.click();

		Set<String> allWindowsId = driver.getWindowHandles();
		System.out.println(allWindowsId);

		for (String allWindows : allWindowsId) {
			if (!allWindows.equals(parentWindowId)) {
				
			driver.switchTo().window(allWindows);

			WebElement addtoCart = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
			addtoCart.click();
		}

	}

	}

}


