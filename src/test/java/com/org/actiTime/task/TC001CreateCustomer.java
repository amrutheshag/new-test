package com.org.actiTime.task;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.actiTime.actiTime.HomePage;
import com.org.actiTime.actiTime.LoginPage;
import com.org.actiTime.actiTime.LogoutPage;
import com.org.actiTime.actiTime.SelectTaskSubMenu;
import com.org.actiTime.testBase.TestBase;

public class TC001CreateCustomer extends TestBase
{
	
	 @Test
	 public void createCustomer()
	 {
		 
		
			 LoginPage lp=new LoginPage(driver);
			    String customername=xllib.readDataFromExcel("Project", 2, 0);
		 		String description=xllib.readDataFromExcel("Project", 2, 1);
		 		log.info("========== Started create Customers ===========");
		 	    lp.loginpage(OR.getProperty("Username"), OR.getProperty("Password"));
		 	    HomePage hp=new HomePage(driver);
		 	    hp.homePage(hp.tasks);
		 		SelectTaskSubMenu selectSubMenu=new SelectTaskSubMenu(driver);
		 		selectSubMenu.selectTask(selectSubMenu.projectsCustomers);
		 	    ProjectsCustomers projectsCustomers=new ProjectsCustomers(driver);
		 	    projectsCustomers.createCustomers(customername, description);
		 	    boolean status = projectsCustomers.verifySuccessMessage();
		 	    Assert.assertEquals(true, status);
		 	    getScreenShot("verifySuccessMessageCreateCustomer");
		 	    LogoutPage logout=new LogoutPage(driver);
		   	    logout.logout();
		     	log.info("========== Finshed create Customers  ===========");
		
	 }
}
