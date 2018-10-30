package com.org.actiTime.actiTime;

import org.testng.annotations.Test;

import com.org.actiTime.testBase.TestBase;

public class TC005CreateBillingType extends TestBase
{
	@Test
    public void createBillingType()
    {
		
		log.info("========== Started createBillingType  ===========");
		String billingName=xllib.readDataFromExcel("BillingType", 1, 0);
	    LoginPage lp=new LoginPage(driver);
	    lp.loginpage(OR.getProperty("Username"), OR.getProperty("Password"));
	    BillingTypesPage billingTypePages=new BillingTypesPage(driver);
	    billingTypePages.navigateToBillingTypesPage();
	    billingTypePages.createNewBillingTypePage(billingName);
	    billingTypePages.verifyBilling("Billing type has been successfully created.");
	    LogoutPage logout=new LogoutPage(driver);
   	    logout.logout();
    	log.info("========== Finshed createBillingType  ===========");
    }
}
