package com.zinghr.qa.testcases;

import java.sql.Driver;

import org.testng.annotations.Test;

import com.qa.generic.Base;
import com.qa.pages.ZingHrLoginPage;

public class ZingHrPunchOutTest extends Base {
	
	@Test
	public void punchOut() {
		ZingHrLoginPage loginPage=new ZingHrLoginPage(driver);
		driver.get(prop.getProperty("zingHrURL"));
		loginPage.enterEmployCode(dataProp.getProperty("employCode"));
		loginPage.enterPassword(dataProp.getProperty("password"));
		loginPage.clickOnPunchOutButton();
	}

}
