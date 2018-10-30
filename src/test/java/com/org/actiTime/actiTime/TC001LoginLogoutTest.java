package com.org.actiTime.actiTime;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.actiTime.testBase.TestBase;

public class TC001LoginLogoutTest extends TestBase
{
	 @DataProvider(name ="LoginTestData")
		public String[][] getTestData()
		{
	    	String[][] testRecords=getData("data.xlsx","Login");
			return testRecords;	
		}
			
	@Test(dataProvider="LoginTestData")
   public void loginTest(String username,String password,String runMode)
   {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}	
	 log.info("========== Started LoginLogoutTest ===========");
	 LoginPage lp=new LoginPage(driver);
	 lp.loginpage(username, password);
	 LogoutPage logout=new LogoutPage(driver);
	 boolean status = logout.verifyLogout();
	 Assert.assertEquals(true, status);
	 logout.logout();
	 log.info("========== Finshed LoginLogoutTest ===========");
   }
}
