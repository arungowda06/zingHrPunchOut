package com.zinghr.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.qa.generic.Base;
import com.qa.pages.ZingHrLoginPage;

public class ZingHrPunchInTest extends Base{
	@Test
	public void punchIn() {
		ZingHrLoginPage loginPage=new ZingHrLoginPage(driver);
		driver.get(prop.getProperty("zingHrURL"));
		loginPage.enterEmployCode(dataProp.getProperty("employCode"));
		loginPage.enterPassword(dataProp.getProperty("password"));
		loginPage.clickOnPunchInButton();
	}
}
