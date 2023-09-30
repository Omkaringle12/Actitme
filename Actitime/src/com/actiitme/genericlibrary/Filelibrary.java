package com.actiitme.genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is a generic class which contains non static method to read data from property and excel file
 * @author ali
 *
 */
public class Filelibrary {
	/**
	 * this method is  a non stsic method used to read data from property file
	 */
	public String reaDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis =new FileInputStream("./Testdata/commandata.propertyfile");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		
	}
	/**
	 * this method is used to read data from excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet, int row ,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream("./Testdata/automationtestdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
}
