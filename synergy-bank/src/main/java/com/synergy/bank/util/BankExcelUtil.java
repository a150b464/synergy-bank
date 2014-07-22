package com.synergy.bank.util;

import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BankExcelUtil {
	
	public Workbook getWorkbook(InputStream fis,String fileName) {
		
		Workbook workbook = null;		
		try {
            //Create the input stream from the xlsx/xls file
           // FileInputStream fis = new FileInputStream(fileName);
             
            //Create Workbook instance for xlsx/xls file input stream            
            if(fileName.toLowerCase().endsWith("xlsx")){
              workbook = new XSSFWorkbook(fis);
            }
            else if(fileName.toLowerCase().endsWith("xls")){
              workbook = new HSSFWorkbook(fis);
            }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return workbook;
	}
	
	public int getNumberOfSheet(Workbook workbook){
		return workbook.getNumberOfSheets();
	}

}
