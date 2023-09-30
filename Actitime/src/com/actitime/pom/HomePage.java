package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//deceleration
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasktb;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reportstab;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement userstab;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutbtn;
	
	// initilization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	//utilization
	public WebElement getTasktb() {
		return tasktb;
	}

	public WebElement getReportstab() {
		return reportstab;
	}

	public WebElement getUserstab() {
		return userstab;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	

}
