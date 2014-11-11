package com.AliensOnEarth.main;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfWriter;


public class Main {
		
	private static Boolean fContinue = true;
	private static Scanner scanner;
	public static ArrayList<String> values;
	 
	// this is the main function
	public static void main(String[] args) {
		// integer to keep track of the menu being invoked
		int menuId=0;
		// values holds the registration rows details list
		values = new ArrayList<String>();
		
	    
		// creating input scanner 
	    	scanner = new Scanner(System.in);
	   
		// loop till Continue flag set false
	    	while(fContinue) {
	    		
			System.out.println("________________________________________________________");
			System.out.println("Please enter your choice.");
			
			//switch based on the menuId to invoke proper menu
			switch(menuId){
			case 0:
				// create main menu console
				menuId=createMainMenu();
		    	break;
			case 1:
				// create main menu console
		    	menuId=createExportMenu();
		    	break;
		    default:
		    	// create main menu console
		    	createMainMenu();
			}
			
		}
		
		// exit system
		System.exit(0);
	    
	}
		
	/**
	 * @brief create main menu
	 */
	private static int createMainMenu() {
		
		System.out.println("________________________________________________________");
		System.out.println("Enter your choice");
		System.out.println("1. Start Alien registeration");
		System.out.println("2. Exit");
		
		String choice = scanner.nextLine();
		
		if(choice.length()!=1){
			System.out.println("Invalid choice, please enter again");
			return 0;
		}
		
		char ch = choice.charAt(0);
		switch(ch){
		case '1':
			return registerHandler();
//			break;
		case '2':
			exitHandler();
			break;
		default:
			System.out.println("Invalid choice, please enter again");
			return 0;
		}
		return 1; 
	}

	/**
	 * @brief create export menu
	 */
	private static int createExportMenu() {
			
		
		System.out.println("________________________________________________________");
		System.out.println("Export Menu...\nEnter 0 to exit");
		
		for (int i=0;i<Utils.menuExportString.length;i++){
			
			System.out.println(String.valueOf(i+1)+". "+Utils.menuExportString[i]);
			
		}
		
		String choice = "";
		
		choice= scanner.nextLine();
		
		if(choice.length()!=1){
			System.out.println("Invalid choice, please enter again");
			return 1;
		}
		char ch = choice.charAt(0);
		
		switch(ch){
		
		case '1': return registerHandler();
		
		case '2': exportTxt(values);
			break;
			
		case '3': exportPdf(values);
			break;
			
		/**
		 * Plugin Instruction
		 * Enter your plugins class static function calls here and pass them the values String
		 */
			
		case '0': exitHandler();
			break;
			
		default:
			System.out.println("Invalid choice, please enter again");
			createExportMenu();
			break;
		}
		return 0;
	}

	/**
	 * @brief Handler for accept the registration inputs
	 */
	public static int registerHandler() {
	
		System.out.println("Welcome to the Alien Registeration.\nEntered the asked details as they are asked...\n");
	
		// put in loop for getting all the elements in a row
		String row="";

		for(int j=0;j<Utils.entries.length;j++){
			
			System.out.println(Utils.entries[j]+" :");
			row += scanner.nextLine();
			row +="\t";
		}
				
		values.add(row);
		
		System.out.println(row);
			
//		return createExportMenu();
		return 1;	
	}
	
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
	
	/**
	 * @brief Handle Menu exit
	 */
	public static void exitHandler() {
		
		// make the continue flag false
		fContinue = false;
		System.out.println("Thank you for using our registeration Service.\nPress Enter to exit...");
		scanner.nextLine();
		//exit system
		System.exit(0);
			
	}
	
}