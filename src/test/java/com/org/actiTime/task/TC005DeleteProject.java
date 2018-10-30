package com.org.actiTime.task;

import org.testng.annotations.Test;

import com.org.actiTime.actiTime.HomePage;
import com.org.actiTime.actiTime.LoginPage;
import com.org.actiTime.actiTime.LogoutPage;
import com.org.actiTime.actiTime.SelectTaskSubMenu;
import com.org.actiTime.testBase.TestBase;

public class TC005DeleteProject extends TestBase
{
	@Test
	public void deleteProject()
	{ 
 		String projectnamename=xllib.readDataFromExcel("Project", 2, 2);
 		log.info("========== Started deleteProject ===========");
 	    LoginPage lp=new LoginPage(driver);
 	    lp.loginpage(OR.getProperty("Username"), OR.getProperty("Password"));
 	    HomePage hp=new HomePage(driver);
 	    hp.homePage(hp.tasks);
 		SelectTaskSubMenu selectSubMenu=new SelectTaskSubMenu(driver);
 		selectSubMenu.selectTask(selectSubMenu.projectsCustomers);
 		DeleteProjectsCustomers deleteProjectsCustomers=new DeleteProjectsCustomers(driver);
 		deleteProjectsCustomers.deleteProject(projectnamename);
 		LogoutPage logout=new LogoutPage(driver);
	   	logout.logout();
     	log.info("========== Finshed deleteProject  ===========");

	}

}
