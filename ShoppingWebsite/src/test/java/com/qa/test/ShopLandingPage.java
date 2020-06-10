package com.qa.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopLandingPage {
	@FindBy(id = "search_query_top")
	private WebElement searchBar;

	public void search(String searchText) {
		this.searchBar.sendKeys(searchText);
		this.searchBar.sendKeys(Keys.ENTER);
	}
}
