package com.qa.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class SeleniumTest2 {
	private WebDriver driver;
	private static ExtentReports extentReports;
	private ExtentTest extentTest;

	@BeforeClass
	public static void setup() {
		extentReports = new ExtentReports();
		ExtentHtmlReporter html = new ExtentHtmlReporter("test-output/html/extentReport.html");
		html.config().setAutoCreateRelativePathMedia(true);
		extentReports.attachReporter(html);
	}

	@Before
	public void init() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// implicit wait - applied to all elements
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@AfterClass
	public static void tearDownClass() {
		extentReports.flush();
	}

	@Test
	public void test() throws InterruptedException {
		final String search = "Dress";
		final String email = "person789@gmail.com";
		final String firstName = "Mel";
		final String lastName = "Potts";
		final String password = "password";
		final String address = "123 Street Street";
		final String city = "city";
		final String state = "T";
		final String zipCode = "26456";
		final String phone = "07123456789";

		driver.get("http://automationpractice.com/index.php");
		this.extentTest = extentReports.createTest("test");

		ShopLandingPage landing = PageFactory.initElements(driver, ShopLandingPage.class);
		landing.search(search);

		ShopSearchPage result = PageFactory.initElements(driver, ShopSearchPage.class);
		result.getSearchTerm();
		// assertTrue(result.toString().toLowerCase().contains("dress"));

		BuyItem item = PageFactory.initElements(driver, BuyItem.class);
		item.addToCart();

		WebElement proceedToCheckout2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		proceedToCheckout2.click();

		WebElement typeEmail = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
		typeEmail.sendKeys(email);

		WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
		createAccount.click();

		// signup form
		SignUpPage signUp = PageFactory.initElements(driver, SignUpPage.class);
		signUp.clickTitle();
		signUp.typeFName(firstName);
		signUp.typeLName(lastName);
		signUp.typePassword(password);
		signUp.typeAddress(address);
		signUp.typeCity(city);
		signUp.typeState(state);
		signUp.typeZipCode(zipCode);
		signUp.typePhone(phone);
		signUp.clickRegister();

		// continuing with payment
		WebElement proceedToCheckout3 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
		proceedToCheckout3.click();

		WebElement agreeTerms = driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
		agreeTerms.click();

		WebElement proceedToCheckout4 = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
		proceedToCheckout4.click();

		WebElement payment = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
		payment.click();

		WebElement confirm = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
		confirm.click();

		WebElement checkComplete = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong"));

		// Saves screenshot to folder
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		final String scrShotPath = "test-output/screenshots/test.png";
		File targetFile = new File(scrShotPath);
		try {
			Files.copy(srcFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertTrue(checkComplete.getText().toLowerCase().contains("complete"));
	}
}
