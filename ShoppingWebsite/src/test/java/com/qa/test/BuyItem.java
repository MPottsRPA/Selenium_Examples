package com.qa.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyItem {
	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	private WebElement addToCart;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	private WebElement proceedToCheckout;

	public void addToCart() {
		this.addToCart.click();
		this.proceedToCheckout.click();
	}
}
