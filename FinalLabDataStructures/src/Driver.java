/**
 * @author Jorge Sanchez
 * Date: 12/3/2015
 * ID: 011175824
 * This is the driver of the program its main function is to connect all the classes into one.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Scanner randomDoc = new Scanner(new File("getty.txt"));
		Scanner sameDoc = new Scanner(new File("getty.txt"));
		Scanner ommittedWords = new Scanner(new File("ommitted.txt"));
		Scanner s = new Scanner(System.in);
		int userChoice = 0;
		Xref x = new Xref(pw);
		Hash h = new Hash(pw);
		h.createTable(ommittedWords);

		System.out.println("\nThere are three .txt files involved.\ngetty.txt\nommitted.txt\ncsis.txt\n\n"
				+ "The files consist of the text to be evaluated, the words to be ommitted,"
				+ "and the text to be output, respectively.\nYou have the following options:\n"
				+ "1. Set Binary Tree without restricted words\n"
				+ "2. Set Binary Tree with restricted words\n"
				+ "3. Display hash table of restricted words invoked from ommitted.txt\n"
				+ "4. Display the evaluation of the current Binary Tree\n"
				+ "5. Search the currently set Binary Tree\n"
				+ "6. Description of the Hash Table and It's function\n"
				+ "7. Exit the program\n"
				+ "Choose a selection: ");
		
		pw.println("\r\nThere are three .txt files involved.\r\ngetty.txt\r\nommitted.txt\r\ncsis.txt\r\n\r\n"
				+ "The files consist of the text to be evaluated, the words to be ommitted,"
				+ "and the text to be output, respectively.\nYou have the following options:\r\n"
				+ "1. Set Binary Tree without restricted words\r\n"
				+ "2. Set Binary Tree with restricted words\r\n"
				+ "3. Display hash table of restricted words invoked from ommitted.txt\r\n"
				+ "4. Display the evaluation of the current Binary Tree\r\n"
				+ "5. Search the currently set Binary Tree\r\n"
				+ "6. Description of the Hash Table and It's function\r\n"
				+ "7. Exit the program\r\n"
				+ "Choose a selection: ");
		
		userChoice = s.nextInt();
		
		while (userChoice < 1 || userChoice > 7)
		{
			pw.println(userChoice);
			System.out.println("Invalid choice. Please choose a number between 1 and 6."
					+ "Choose a selection: ");
			pw.println("Invalid choice. Please choose a number between 1 and 6."
					+ "Choose a selection: ");
			userChoice = s.nextInt();				
		}		
		while(userChoice != 7)
		{
	            if(userChoice == 1)
	            { 
	            	pw.println(1);
	            	x.setTree(randomDoc);
	            	System.out.println("Binary Tree set...");
	            	pw.println("Binary Tree set...");
	            }
	            else if(userChoice == 2)
	            {  
	            	pw.println(2);
	            	x.setRestrictedTree(sameDoc, h.getArray());
	            	System.out.println("Restricted Binary Tree set...");
	            	pw.println("Restricted Binary Tree set...");
	            	System.out.println(h.getCollision());
	            }
	            else if(userChoice == 3)
	            {
	            	pw.println(3);
	            	h.displayTable();
	            }
	            else if(userChoice == 4)
	            {
	            	pw.println(4);
	            	x.display();
	            }
	            else if(userChoice == 5)
	            {
	            	pw.println(5);
	            	x.userSearch(pw);
	            }
	            else if(userChoice == 6)
	            {
	            	pw.println(6);
	            	h.hashTableInfo();
	            }
	            else
	            {
					System.out.println("Invalid choice. Please choose a number between 1 and 7."
							+ "Choose a selection: ");
					pw.println("Invalid choice. Please choose a number between 1 and 7."
							+ "Choose a selection: ");
	            }
	            
		
	        System.out.println("\nYou have the following options:\n"
					+ "1. Set Binary Tree without restricted words\n"
					+ "2. Set Binary Tree with restricted words\n"
					+ "3. Display hash table of ommitted words\n"
					+ "4. Display the evaluation of the current Binary Tree\n"
					+ "5. Search the currently set Binary Tree\n"
					+ "6. Description of the hash table and it's function\n"
					+ "7. Exit the program\n"
	        		+ "Choose a selection: ");
	        
	        pw.println("\nYou have the following options:\r\n"
					+ "1. Set Binary Tree without restricted words\r\n"
					+ "2. Set Binary Tree with restricted words\r\n"
					+ "3. Display hash table of ommitted words\r\n"
					+ "4. Display the evaluation of the current Binary Tree\r\n"
					+ "5. Search the currently set Binary Tree\r\n"
					+ "6. Description of the hash table and it's function\r\n"
					+ "7. Exit the program\r\n"
	        		+ "Choose a selection: ");
			userChoice = s.nextInt();
			while (userChoice < 1 || userChoice > 7)
			{
				pw.println(userChoice);
				System.out.println("Invalid choice. Please choose a number between 1 and 7."
						+ "Choose a selection: ");
				pw.println("Invalid choice. Please choose a number between 1 and 7."
						+ "Choose a selection: ");
				userChoice = s.nextInt();				
			}
		}	
		pw.close();
		return;

	}

}
