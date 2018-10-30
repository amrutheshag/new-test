package com.org.actiTime.actiTime;

import org.testng.annotations.Test;

import com.org.actiTime.testBase.TestBase;

public class TC006DeleteBillingType extends TestBase
{
	@Test
    public void DeleteBillingType()
    {
		log.info("========== Started DeleteBillingType  ===========");
		String billingName=xllib.readDataFromExcel("BillingType", 1, 0);
	    LoginPage lp=new LoginPage(driver);
	    lp.loginpage(OR.getProperty("Username"), OR.getProperty("Password"));
	    BillingTypesPage billingTypePages=new BillingTypesPage(driver);
	    billingTypePages.navigateToBillingTypesPage();
	    billingTypePages.deleteBilling(billingName);
	    LogoutPage logout=new LogoutPage(driver);
   	    logout.logout();
    	log.info("========== Finshed DeleteBillingType  ===========");
    }
}
