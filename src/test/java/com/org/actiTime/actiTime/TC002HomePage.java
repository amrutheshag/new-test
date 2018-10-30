package com.org.actiTime.actiTime;

import org.testng.annotations.Test;

import com.org.actiTime.testBase.TestBase;

public class TC002HomePage extends TestBase
{
	@Test
	public void homePage()
	{
		 log.info("========== Started homePage ===========");
		 LoginPage lp=new LoginPage(driver);
		 lp.loginpage(OR.getProperty("Username"), OR.getProperty("Password"));
		 log.info("========== Finshed homePage ===========");
	}
}
