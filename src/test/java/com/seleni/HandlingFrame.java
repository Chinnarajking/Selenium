package com.seleni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrame {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://netbanking.hdfcbank.com/netbanking/");

		driver.manage().window().maximize();

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		//Handling Frame

		driver.switchTo().frame(0);

		WebElement customerId = driver.findElement(By.xpath("//input[@type='text']"));
		customerId.sendKeys("HelloMaven");

		String text = customerId.getAttribute("value");
		System.out.println("Text- " + text);

	}
}