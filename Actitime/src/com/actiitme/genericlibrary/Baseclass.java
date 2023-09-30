package com.actiitme.genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.pom.LoginPage;

public class Baseclass {
	Filelibrary f=new Filelibrary();
	public static WebDriver driver;
	
	@BeforeSuite
		public void databaseconnection (){
			Reporter.log("data base connected",true);
		}
	@BeforeClass
	public void launchbrowser() throws IOException {
	   driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Filelibrary f=new Filelibrary();
		String link = f.reaDataFromPropertyFile("url");
		driver.get(link);
		Reporter.log("browser launch successfully ",true);
	}
	@BeforeMethod
	public void logintoActitime() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String value = f.reaDataFromPropertyFile("UN");
		lp.getUntbx().sendKeys(value);
		String PASS = f.reaDataFromPropertyFile("PSW");
		lp.getPwtbx().sendKeys(PASS);
		lp.getLgbtn().click();
		Reporter.log("login successfully",true);
	}
	@AfterMethod
	public void logoutActitime() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("log out successfully",true);
	}
	@AfterClass
	public void closebrowser() {
		driver.close();
		Reporter.log("browser is close",true);
	}
	@AfterSuite
	public void closedatabaseconnection() {
		Reporter.log("data base disconnected",true);
	}
	}


