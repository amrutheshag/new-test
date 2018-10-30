package com.org.actiTime.task;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.actiTime.actiTime.HomePage;
import com.org.actiTime.actiTime.LoginPage;
import com.org.actiTime.actiTime.LogoutPage;
import com.org.actiTime.actiTime.SelectTaskSubMenu;
import com.org.actiTime.testBase.TestBase;

public class TC003CreateCustomerAndProject extends TestBase
{

	 @DataProvider(name ="Craete Customer and Project")
		public String[][] getTestData()
		{
	    	String[][] testRecords=getData("data.xlsx","Project");
			return testRecords;	
		}
			
	 @Test(dataProvider="Craete Customer and Project")
	 public void createCustomersAndProjects(String customername,String description,String projectnamename,String description1,String runMode)
	 {
	 		if(runMode.equalsIgnoreCase("n")){
	 			throw new SkipException("user marked this record as no run");
	 		}	
	 		log.info("========== Started createCustomersAndProjects ===========");
	 		 LoginPage lp=new LoginPage(driver);
	    	 lp.loginpage(OR.getProperty("Username"), OR.getProperty("Password"));
			 HomePage hp=new HomePage(driver);
			 hp.homePage(hp.tasks);
	 		SelectTaskSubMenu selectSubMenu=new SelectTaskSubMenu(driver);
	 		selectSubMenu.selectTask(selectSubMenu.projectsCustomers);
	 	    ProjectsCustomers projectsCustomers=new ProjectsCustomers(driver);
	 	    projectsCustomers.createCustomersAndProject(customername, description, projectnamename, description1);
	 	    boolean  status=projectsCustomers.verifySuccessMessage();
	 	    Assert.assertEquals(true, status);
	 	    LogoutPage logout=new LogoutPage(driver);
		   	logout.logout();
	     	log.info("========== Finshed createCustomersAndProjects ===========");
	 }
}
