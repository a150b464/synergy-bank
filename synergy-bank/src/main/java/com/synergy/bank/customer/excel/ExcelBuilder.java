package com.synergy.bank.customer.excel;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

public class ExcelBuilder extends AbstractExcelView {
		 
	    @Override
	    protected void buildExcelDocument(Map<String, Object> model,
	            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        // get data model which is passed by the Spring container
	        List<PayeeDetailsForm> listPayee = (List<PayeeDetailsForm>) model.get("listPayee");
	         
	        // create a new Excel sheet
	        HSSFSheet sheet = workbook.createSheet("PAYEES");
	        sheet.setDefaultColumnWidth(30);
	         
	        // create style for header cells
	        CellStyle style = workbook.createCellStyle();
	        Font font = workbook.createFont();
	        font.setFontName("Arial");
	        style.setFillForegroundColor(HSSFColor.BLUE.index);
	        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        font.setColor(HSSFColor.WHITE.index);
	        style.setFont(font);
	         
	        // create header row
	        HSSFRow header = sheet.createRow(0);
	         
	        header.createCell(0).setCellValue("SNO");
	        header.getCell(0).setCellStyle(style);
	         
	        header.createCell(1).setCellValue("User ID");
	        header.getCell(1).setCellStyle(style);
	         
	        header.createCell(2).setCellValue("Account Number");
	        header.getCell(2).setCellStyle(style);
	         
	        header.createCell(3).setCellValue("Name");
	        header.getCell(3).setCellStyle(style);
	         
	        header.createCell(4).setCellValue("Nickname");
	        header.getCell(4).setCellStyle(style);
	        
	        header.createCell(5).setCellValue("Mobile");
	        header.getCell(5).setCellStyle(style);
	         
	        header.createCell(6).setCellValue("DOE");
	        header.getCell(6).setCellStyle(style);
	         	        
	        header.createCell(7).setCellValue("Email");
	        header.getCell(7).setCellStyle(style);
	         
	        header.createCell(8).setCellValue("Status");
	        header.getCell(8).setCellStyle(style);
	         
	        // create data rows
	        int rowCount = 1;
	         
	        for (PayeeDetailsForm payeeForm : listPayee) {
	            HSSFRow aRow = sheet.createRow(rowCount++);
	            aRow.createCell(0).setCellValue(payeeForm.getSno());
	            aRow.createCell(1).setCellValue(payeeForm.getUserid());
	            aRow.createCell(2).setCellValue(payeeForm.getPayeeAccountNo());
	            aRow.createCell(3).setCellValue(payeeForm.getPayeeName());
	            aRow.createCell(4).setCellValue(payeeForm.getPayeeNickName());
	            aRow.createCell(5).setCellValue(payeeForm.getMobile());
	            aRow.createCell(6).setCellValue(payeeForm.getDoe());
	            aRow.createCell(7).setCellValue(payeeForm.getEmail());
	            aRow.createCell(8).setCellValue(payeeForm.getStatus());
	        }
	    }
	 
	}
