package com.AliensOnEarth.main;


import java.util.Scanner;


public class Main {
	 
	// this is the main function
	public static void main(String[] args) {

		Boolean fContinue = true;
		Scanner scanner;
		
		// creating input scanner 
	    	scanner = new Scanner(System.in);
	    	
		// Menu creator
		Menu menu= new Menu(scanner,fContinue);
		
		// integer to keep track of the menu being invoked
		int menuId=0;		
	   
		// loop till Continue flag set false
	    	while(fContinue) {
	    		
			System.out.println("________________________________________________________");
			System.out.println("Please enter your choice.");
			
			//switch based on the menuId to invoke proper menu
			switch(menuId){
			case 0:
				// create main menu console
				menuId=menu.createMainMenu();
		    	break;
			case 1:
				// create main menu console
		    	menuId=menu.createExportMenu();
		    	break;
		    default:
		    	// create main menu console
		    	menu.createMainMenu();
			}
			
		}
		
		// exit system
		System.exit(0);
	    
	}

}