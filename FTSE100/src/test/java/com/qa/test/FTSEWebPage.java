package com.qa.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FTSEWebPage {
	@FindBy(xpath = "/html/body/main/div/div/div[3]/div/div[4]/div[1]/ul/li[2]/a")
	private WebElement risers;

	@FindBy(xpath = "//*[@id=\"content_div_40583\"]/ul/li[3]")
	private WebElement fallers;

	public void clickRisers() {
		risers.click();
	}

	public void clickFallers() {
		fallers.click();
	}
}
