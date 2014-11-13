package com.AliensOnEarth.main;

import java.util.ArrayList;

import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfWriter;

public class PdfExporter {
	/**
	 * @brief Saving to PDF file
	 */
	public static void exportPdf(ArrayList<String> values) {
		
		try{
			//create a writer instance
			PdfWriter writer = PdfWriter.fileWriter("AlienOnEarth.pdf");
			// Create a PdfDocument instance with the PdfWriter
			PdfDocument d = new PdfDocument(writer);
			
			int x=10,y=10;
			
			for (int i =0; i<values.size();i++){
				
				d.writeText(values.get(i), 
					    x,   // x-coordinate 
					    y);	// y-coordinate
				
				y+=10;
			
			}
			
			// Write document to file
			d.write();
			// Close all I/O streams associated with the PDF writer
			writer.dispose();
			// return
			return;
		}
		catch(Exception e){
			// can catch IOExceptions here
		}
	}	
}
