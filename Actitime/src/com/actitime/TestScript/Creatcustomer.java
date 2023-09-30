package com.actitime.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actiitme.genericlibrary.Baseclass;
import com.actiitme.genericlibrary.Filelibrary;
import com.actiitme.genericlibrary.Listenerimplementation;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskPage;
@Listeners(Listenerimplementation.class)

public class Creatcustomer extends Baseclass {
	@Test
	public void creatcustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasktb().click();
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewcust().click();
		tp.getNewcust().click();
		Filelibrary f=new Filelibrary();
		String name = f.readDataFromExcel("Sheet1", 5, 1);
		tp.getCustname().sendKeys(name);
		String desp = f.readDataFromExcel("Sheet1", 2, 2);
		tp.getCustdesp().sendKeys(desp);
		tp.getCreatcust().click();
		
		String expctedresult = name;
		String actualresult = driver.findElement(By.xpath("(//div[.='"+name+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expctedresult, actualresult);
		s.assertAll();
		
	}
	

	
}
