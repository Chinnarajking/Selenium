package com.seleni;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {
	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.co.in/");

		driver.manage().window().maximize();
		
		//Download File

		driver.findElement(By.name("q")).sendKeys("Mozila Firefox");
		driver.findElement(By.name("btnK")).click();

		driver.findElement(By.className("LC20lb MBeuO DKV0Md")).click();

		driver.findElement(By.linkText("//*[href='/firefox/download/thanks/\']")).click();

	}
}