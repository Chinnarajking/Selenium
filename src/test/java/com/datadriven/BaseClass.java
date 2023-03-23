package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void browserLaunch(String url) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get(url);

		driver.manage().window().maximize();
	}

	public static String stringData(int row, int cell) throws IOException {
		File loc = new File("D:\\Java new\\SeleniumProgramming\\src\\test\\resources\\DataDriven\\Selenium.xlsx");
		FileInputStream input = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(input);
		Sheet s = w.getSheet("Selenium");
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		String stringValue = c.getStringCellValue();
		return stringValue;

	}

	public static void inputText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void btnClick(WebElement element) {
		element.click();
	}
}