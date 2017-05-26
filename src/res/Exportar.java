package res;

import java.io.FileOutputStream;

import javax.swing.JTable;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class Exportar {
	static Document doc;
	
	public static void toPdf(JTable table) {

        try {
            doc = new Document(PageSize.A4, 0, 0, 50, 50);
            PdfWriter.getInstance(doc, new FileOutputStream(table.getName()+".pdf"));
            doc.open();
            ponTitulo(table.getName());
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            //Escribe el cabecero de la tabla
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(table.getColumnName(i));
            }
            //Escribe los datos de la tabla
            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());

                }
            }
            doc.add(pdfTable);
            doc.close();
        } catch (Exception ex) { }
    }

	private static void ponTitulo(String nombreTabla){
		Paragraph p = new Paragraph();
		p.add(new Phrase(nombreTabla.toUpperCase()));
		p.setSpacingAfter(20);
        p.setAlignment(1);		
        try {
			doc.add(p);
		} catch (DocumentException e) {}
	}
}
