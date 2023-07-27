package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZingHrLoginPage  {
	
	public ZingHrLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "txtEmpCode")
	private WebElement employCodeTextField;
	
	public void enterEmployCode(String employCode) {
		employCodeTextField.sendKeys(employCode);
	}
	
	@FindBy(id = "txtPassword")
	private WebElement passwordTextField;
	
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}
	
	@FindBy(xpath = "//span[text()='punch in']")
	private WebElement punchInButton;
	
	public void clickOnPunchInButton() {
		punchInButton.click();
	}
	
	@FindBy(xpath = "//span[text()='punch out']")
	private WebElement punchOutButton;
	
	public void clickOnPunchOutButton() {
		punchOutButton.click();
	}
}
