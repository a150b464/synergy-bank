package com.synergy.bank.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.synergy.bank.common.service.SecurityQuestionService;
import com.synergy.bank.common.web.controller.form.SecurityQuestionForm;

/**
 * 
 * @author naim
 *
 */
public class BankServletContextListener implements ServletContextListener{

	   /*
	    * Initiate Logger for this class
	    */
	private static final Log logger = LogFactory.getLog(BankServletContextListener.class);
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ApplicationContext applicationContext=ContextLoader.getCurrentWebApplicationContext();
	    SecurityQuestionService securityQuestionService=(SecurityQuestionService)applicationContext.getBean("SecurityQuestionServiceImpl");
		
		List<SecurityQuestionForm> secQuestionLists = findSecurityQuestions(sce.getServletContext());
		if(logger.isDebugEnabled()){
			logger.debug(secQuestionLists);
		}
		
		String res = securityQuestionService.saveSecurityQuestions(secQuestionLists);
		if(logger.isDebugEnabled()){
			logger.debug(res);
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	public List<SecurityQuestionForm> findSecurityQuestions(ServletContext sc){
		
		List<SecurityQuestionForm> securityQuestionList = new ArrayList<SecurityQuestionForm>();
		BankExcelUtil bankExcelUtil = new BankExcelUtil();		
		InputStream inputStream=sc.getResourceAsStream("/WEB-INF/files/security_questions.xlsx");
		Workbook workbook = bankExcelUtil.getWorkbook(inputStream, "security_questions.xlsx");
		
		for(int i=0; i < workbook.getNumberOfSheets(); i++){
			
			//Get the nth sheet from the workbook
            Sheet sheet = workbook.getSheetAt(i);
             
            //every sheet has rows, iterate over them
            Iterator<Row> rowIterator = sheet.iterator();
			
            while (rowIterator.hasNext())
            {
                String id = "";
                String description = "";
                 
                //Get the row object
                Row row = rowIterator.next();
                 
                //Every row has columns, get the column iterator and iterate over them
                Iterator<Cell> cellIterator = row.cellIterator();
                
                while (cellIterator.hasNext())
                {
                    //Get the Cell object
                    Cell cell = cellIterator.next();
                     
                    //check the cell type and process accordingly
                    switch(cell.getCellType()){

                    	case Cell.CELL_TYPE_STRING:
                    		
                    		if(id.equalsIgnoreCase("")){
	                        	id = cell.getStringCellValue().trim();
                    		}
                    		
                    		else if(description.equalsIgnoreCase("")){
                    			description = cell.getStringCellValue().trim();
                    		} 
                    	
                    		break;
                    }
                } //end of cell iterator
                
                SecurityQuestionForm securityQuestionForm = new SecurityQuestionForm();
                securityQuestionForm.setId(id);
                securityQuestionForm.setDescription(description);
                securityQuestionList.add(securityQuestionForm);
            } //end of rows iterator        
		} //end of sheets for loop
		
		return securityQuestionList;
	}
	
	

}
