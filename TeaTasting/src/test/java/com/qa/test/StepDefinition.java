package com.qa.test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	private WebDriver driver;
	private TeaLandingPage goToMenu;

	@Before
	public void init() {
		ChromeOptions opts = new ChromeOptions();
		opts.setHeadless(true);
		this.driver = new ChromeDriver(opts);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

	// Scenario 1
	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
		driver.get("http://www.practiceselenium.com/welcome.html");
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
		this.goToMenu = PageFactory.initElements(driver, TeaLandingPage.class);
		this.goToMenu.clickMenu();
	}

	@Then("^I can browse a list of the available products$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		assertTrue(this.goToMenu.getStatus().contains("Menu"));
	}

	// Scenario 2
	@Given("^the correct web address2$")
	public void the_correct_web_address2() throws Throwable {
		driver.get("http://www.practiceselenium.com/welcome.html");
		this.goToMenu = PageFactory.initElements(driver, TeaLandingPage.class);
		this.goToMenu.clickMenu();
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
		this.goToMenu.clickCheckout();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
		assertTrue(this.goToMenu.getCheckoutStatus().contains("Pay with Credit Card or Log In"));
	}
}
