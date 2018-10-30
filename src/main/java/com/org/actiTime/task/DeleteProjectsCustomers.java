package com.org.actiTime.task;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProjectsCustomers {
	public static final Logger log=Logger.getLogger(DeleteProjectsCustomers.class.getName());
	 WebDriver driver;
		
		public DeleteProjectsCustomers(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath=".//*[@value='Delete Selected']")
		WebElement deleteselected;
		
		@FindBy(id="deleteButton")
		WebElement deletebutton;
		
		@FindBy(id="SuccessMessages")
		WebElement successMessages;
		
		public void deleteCustomerAndProject(String customername)
		{
			WebElement deleteCustome = driver.findElement(By.xpath(".//a[contains(text(),'"+customername+"')]/../../../../../../td/input[@type='checkbox']"));
			deleteCustome.click();
			log.info("select custome to delete:-"+customername+"and object is "+ deleteCustome.toString());
			deleteselected.click();
			log.info("click on delete select button and object is "+ deleteselected.toString());
			deletebutton.click();
			log.info("click on delete  button and object is "+ deletebutton.toString());
			String successMessage1=successMessages.getText();
			log.info("success Message1"+successMessage1+" and object is "+ successMessages.toString());
		}
		
		public void deleteProject(String projectnamename)
		{
			WebElement deleteProject = driver.findElement(By.xpath(".//a[contains(text(),'"+projectnamename+"')]/../../../../../../td/input[@type='checkbox']"));
			deleteProject.click();
			log.info("select custome to delete:-"+projectnamename+"and object is "+ deleteProject.toString());
			deleteselected.click();
			log.info("click on delete select button and object is "+ deleteselected.toString());
			deletebutton.click();
			log.info("click on delete  button and object is "+ deletebutton.toString());
			String successMessage1=successMessages.getText();
			log.info("success Message1"+successMessage1+" and object is "+ successMessages.toString());
		}
}
