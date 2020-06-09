package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class FTSE100Test {
	WebDriver driver;

	@Before
	public void init() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// implicit wait - applied to all elements
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		// driver.quit();
	}

	@Test
	public void test() {
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");

		FTSEWebPage webPage = PageFactory.initElements(driver, FTSEWebPage.class);
		WebElement cookie = driver.findElement(By.xpath("/html/body/div[4]/div/a[2]"));
		cookie.click();

		webPage.clickRisers();
		WebElement largestRiser = driver
				.findElement(By.xpath("/html/body/main/div/div/div[3]/div[4]/div[1]/div[2]/table/tbody/tr[1]/td[5]"));
		System.out.println("Biggest riser = " + largestRiser.getText());

		webPage.clickFallers();
		WebElement largestFaller = driver
				.findElement(By.xpath("/html/body/main/div/div/div[3]/div[4]/div[1]/div[2]/table/tbody/tr[1]/td[5]"));
		System.out.println("Biggest faller = " + largestFaller.getText());
	}
}
