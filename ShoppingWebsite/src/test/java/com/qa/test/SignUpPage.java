package com.qa.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
	@FindBy(id = "id_gender2")
	WebElement title;

	@FindBy(id = "customer_firstname")
	WebElement fName;

	@FindBy(id = "customer_lastname")
	WebElement lName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "id_state")
	WebElement state;

	@FindBy(id = "postcode")
	WebElement zipCode;

	@FindBy(id = "phone_mobile")
	WebElement phone;

	@FindBy(id = "submitAccount")
	WebElement register;

	public void clickTitle() {
		this.title.click();
	}

	public void typeFName(String firstName) {
		this.fName.sendKeys(firstName);
	}

	public void typeLName(String lastName) {
		this.lName.sendKeys(lastName);
	}

	public void typePassword(String password) {
		this.password.sendKeys(password);
	}

	public void typeAddress(String address) {
		this.address.sendKeys(address);
	}

	public void typeCity(String city) {
		this.city.sendKeys(city);
	}

	public void typeState(String state) {
		this.state.sendKeys(state);
	}

	public void typeZipCode(String zipCode) {
		this.zipCode.sendKeys(zipCode);
	}

	public void typePhone(String phone) {
		this.phone.sendKeys(phone);
	}

	public void clickRegister() {
		this.register.click();
	}
}
