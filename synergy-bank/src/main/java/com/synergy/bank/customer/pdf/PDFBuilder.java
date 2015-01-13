package com.synergy.bank.customer.pdf;

import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;
 
/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {
 
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<PayeeDetailsForm> listPayee = (List<PayeeDetailsForm>) model.get("listPayee");
         
        doc.add(new Paragraph("Payee List"));
         
        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 3.0f, 2.0f, 2.0f, 2.0f, 3.0f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(9);
         
        // write table header
        cell.setPhrase(new Phrase("SNO", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("User ID", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Account Number", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Nickname", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Mobile", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("DOE", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Status", font));
        table.addCell(cell);
         
        // write table row data
        for (PayeeDetailsForm payeeForm : listPayee) {
            table.addCell(String.valueOf(payeeForm.getSno()));
            table.addCell(payeeForm.getUserid());
            table.addCell(payeeForm.getPayeeAccountNo());
            table.addCell(payeeForm.getPayeeName());
            table.addCell(payeeForm.getPayeeNickName());
            table.addCell(payeeForm.getMobile());
            table.addCell(String.valueOf(payeeForm.getDoe()));
            table.addCell(payeeForm.getEmail());
            table.addCell(payeeForm.getStatus());
        }
         
        doc.add(table);
         
    }
 
}
