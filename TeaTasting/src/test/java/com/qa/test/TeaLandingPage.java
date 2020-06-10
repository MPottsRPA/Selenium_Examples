package com.qa.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaLandingPage {
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	WebElement menuBtn;

	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/div/h1")
	WebElement menuStatus;

	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[16]/div/a/span")
	WebElement checkoutBtn;

	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[15]/div/p/span/strong")
	WebElement checkoutStatus;

	public void clickMenu() {
		this.menuBtn.click();
	}

	public String getStatus() {
		return this.menuStatus.getText();
	}

	public void clickCheckout() {
		this.checkoutBtn.click();
	}

	public String getCheckoutStatus() {
		return this.checkoutStatus.getText();
	}
}
