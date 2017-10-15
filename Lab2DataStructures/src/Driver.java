/*
 * Author: Jorge Sanchez
 * Date: 9/25/2015
 * Palomar ID: 011175824
 * Lab 2: Stacks
 * Program Description: This is the main class of this project. The program take in the input of the file infix.txt line by line
 * and converts that 'infix' equation into a 'postfix' equation. The postfix equation is then evaluated.
 */

import java.io.*;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws IOException {
		
		Scanner fileScan = new Scanner(new File("infix.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		InfixToPostfix toPost = new InfixToPostfix();
		EvalPostfix evalPost = new EvalPostfix();
		
		while (fileScan.hasNext())
		{
			String buf = fileScan.nextLine();
			String buf2 = buf;
			toPost.stringInput(buf);
			System.out.print("Postfix Stack: ");
			String postString = toPost.getPostString();
			String postString2 = postString;
			System.out.print(postString);
			pw.print("Postfix Stack: ");
			pw.print(postString2) ;
			evalPost.stringInput(buf2);
			System.out.print("\nResult: ");	
			pw.print("\r\nResult: ");
			System.out.println(evalPost.getResult());
			pw.println(evalPost.getResult());
		}
		
		fileScan.close();
		pw.close();

	}

}
