package com.org.actiTime.actiTime;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SelectTaskSubMenu {

	public static final Logger log=Logger.getLogger(SelectTaskSubMenu.class.getName());
	 WebDriver driver;
		public  final String openTasks = "Open Tasks";
		public  final String completedTasks = "Completed Tasks";
		public  final String projectsCustomers = "Projects & Customers";
		public  final String archives = "Archives";
		
		public SelectTaskSubMenu(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void selectTask(String stask)
		{
			 WebElement selectSubMenu = driver.findElement(By.xpath(".//a[contains(text(),'"+stask+"')]"));
			 selectSubMenu.click();
			log.info("click on sub menu:- "+stask+" and object is "+selectSubMenu.toString());
			
		}
		
		
}
