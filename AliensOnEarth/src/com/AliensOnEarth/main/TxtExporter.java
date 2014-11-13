package com.AliensOnEarth.main;

import java.io.PrintWriter;
import java.util.ArrayList;

public class TxtExporter {
	/**
	 * @brief Export to text file
	 */
	public static void exportTxt(ArrayList<String> values) {
		
		try{
		
			PrintWriter writer = new PrintWriter("AlienOnEarth.txt", "UTF-8");
		
			for (int i = 0; i<values.size();i++){

				writer.println(values.get(i));				
			}
			// Close all I/O streams associated with the PDF writer
			writer.close();
			// return
			return;
		}
		catch(Exception e){
			// can catch IOExceptions here
		}
		
	}
	
}
