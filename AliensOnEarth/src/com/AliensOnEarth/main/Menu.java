package com.AliensOnEarth.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	static Scanner scanner;
	static Boolean fContinue;
	static ArrayList<String> values;
	
	// constructor
	Menu(Scanner scanner,Boolean fContinue){
		
		Menu.scanner = scanner;
		Menu.fContinue=fContinue;
		values = new ArrayList<String>();
	}
	/**
	 * @brief create main menu
	 */
	public int createMainMenu() {
		
		// reinitialize values
		values = new ArrayList<String>();
		
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
			return registerHandler(values);
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
	public int createExportMenu() {
			
		
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
		
		case '1': return registerHandler(values);
		
		case '2': TxtExporter.exportTxt(values);
			break;
			
		case '3': PdfExporter.exportPdf(values);
			break;
			
		/**
		 * Plugin Instruction
		 * Enter your plugins class static function calls here and pass them the values String
		 */
			
		case '0': exitHandler();
			break;
			
		default:
			System.out.println("Invalid choice, please enter again");
			return 1;
		}
		return 0;
	}
	
	/**
	 * @brief Handler for accept the registration inputs
	 */
	public int registerHandler(ArrayList<String> values) {
	
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
