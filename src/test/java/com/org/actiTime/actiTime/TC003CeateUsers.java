package com.org.actiTime.actiTime;



import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.actiTime.testBase.TestBase;

public class TC003CeateUsers extends TestBase
{
	@DataProvider(name ="users")
	public String[][] getTestData()
	{
    	String[][] testRecords=getData("data.xlsx", "Users");
		return testRecords;	
	}
		
    @Test(dataProvider="users")
    public void createUsers(String firstName,String midlleName,String lastName,String email,String username,String password,String timeTrack,String reporting,String taskManagement,String userManagement,String runMode)
    {
    	if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
    	
    	log.info("========== Started createUsers ===========");
    	 LoginPage lp=new LoginPage(driver);
    	 lp.loginpage(OR.getProperty("Username"), OR.getProperty("Password"));
		 HomePage hp=new HomePage(driver);
		 hp.homePage(hp.users);
    	Users users=new Users(driver);
    	users.createUser(firstName, midlleName, lastName, email, username, password, timeTrack, reporting, taskManagement, userManagement);
    	 LogoutPage logout=new LogoutPage(driver);
   	     logout.logout();
    	 log.info("========== Finshed createUsers ===========");

    }
}