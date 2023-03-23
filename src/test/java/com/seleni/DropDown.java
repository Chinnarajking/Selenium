package com.seleni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://adactinhotelapp.com/");

		driver.manage().window().maximize();

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		driver.findElement(By.id("username")).sendKeys("abinesh1990");
		driver.findElement(By.id("password")).sendKeys("Abinesh123");

		driver.findElement(By.id("login")).click();

		WebElement loc = driver.findElement(By.id("location"));

		Select s = new Select(loc);
		s.selectByVisibleText("Sydney");

		WebElement hotel = driver.findElement(By.id("hotels"));
		Select s1 = new Select(hotel);
		s.selectByVisibleText("Hotel Sunshine");

		WebElement roomType = driver.findElement(By.id("room_type"));
		Select s2 = new Select(roomType);
		s.selectByVisibleText("Standard");

		WebElement adultsPerRoom = driver.findElement(By.id("adult_room"));
		Select s3 = new Select(adultsPerRoom);
		s.selectByVisibleText("3 - Three");

		WebElement childrenPerRoom = driver.findElement(By.id("child_room"));
		Select s4 = new Select(childrenPerRoom);
		s.selectByVisibleText("1 - One");

		driver.findElement(By.id("Submit")).click();

	}
}
