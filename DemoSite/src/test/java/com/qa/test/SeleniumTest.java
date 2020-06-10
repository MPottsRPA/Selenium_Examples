package com.qa.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class SeleniumTest {
	private WebDriver driver;
	private static ExtentReports report;
	private ExtentTest test;

	@BeforeClass
	public static void setup() {
		report = new ExtentReports();
		ExtentHtmlReporter html = new ExtentHtmlReporter("testoutput/extentreport.html");
		html.config().setAutoCreateRelativePathMedia(true);
		report.attachReporter(html);
	}

	@Before
	public void init() {
		ChromeOptions opts = new ChromeOptions();
		opts.setHeadless(true);
		driver = new ChromeDriver(opts);
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		final String userName = "Hello";
		final String password = "World";

		driver.get("http://thedemosite.co.uk/");
		AddAUserPage user = PageFactory.initElements(driver, AddAUserPage.class);
		user.clickAddUser();
		user.enterUserName(userName);
		user.enterPassword(password);
		user.clickSave();

		LoginPage testLogin = PageFactory.initElements(driver, LoginPage.class);
		testLogin.goToLogin();
		testLogin.typeUsername(userName);
		testLogin.typePassword(password);
		testLogin.clickTestLogin();

		// Saves screenshot to folder
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		final String scrShotPath = "test-output/screenshots/DemoSiteTest.png";
		File targetFile = new File(scrShotPath);
		try {
			Files.copy(srcFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertTrue(testLogin.getStatus().contains("Successful Login"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@AfterClass
	public static void tearDownClass() {
		report.flush();
	}
}
