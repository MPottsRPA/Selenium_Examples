package com.qa.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopSearchPage {
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
	private WebElement searchResult;

	public void getSearchTerm() {
		this.searchResult.click();
	}
}
