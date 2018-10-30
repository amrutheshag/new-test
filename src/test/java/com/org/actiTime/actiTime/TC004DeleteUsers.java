package com.org.actiTime.actiTime;

import org.testng.annotations.Test;

import com.org.actiTime.testBase.TestBase;

public class TC004DeleteUsers extends TestBase
{
	@Test
    public void deleteUsers()
    {
		
		log.info("========== Started Delete Users ===========");
		String username=xllib.readDataFromExcel("Users", 1, 0);
	    LoginPage lp=new LoginPage(driver);
	    lp.loginpage(OR.getProperty("Username"), OR.getProperty("Password"));
	    HomePage hp=new HomePage(driver);
	    hp.homePage(hp.users);
    	Users users=new Users(driver);
    	users.deleteUse(username);
    	LogoutPage logout=new LogoutPage(driver);
   	    logout.logout();
    	log.info("========== Finshed Delete Users ===========");
    }
}
