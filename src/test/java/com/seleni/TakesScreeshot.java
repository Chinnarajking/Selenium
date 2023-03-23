package com.seleni;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakesScreeshot {
	public static void main(String[] args) throws IOException {
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://www.facebook.com/");
		 
		 driver.manage().window().maximize();
		 
		 System.out.println(driver.getCurrentUrl());
		 System.out.println(driver.getTitle());
		 
		 //TakesScreenshot
		 
		 TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			File destination = new File("E:\\Facebook\\fbpage.jpeg"); 
			
			FileUtils.copyFile(source, destination);
		}   

		}



