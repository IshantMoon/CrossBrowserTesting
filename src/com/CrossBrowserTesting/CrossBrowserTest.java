package com.CrossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
	if (browser.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver", "C:\\TestingSoftware\\edgedriver_win32\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\TestingSoftware\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
	driver.manage().window().maximize();
	driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		
	}
	@Test
	public void clickOnAlert() {
		driver.findElement(By.name("alert")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
