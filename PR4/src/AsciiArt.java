/* * @author Jorge Sanchez
 * @version CSE11 Spring 2015
 */

import java.util.Scanner;
import java.util.ArrayList;

public class AsciiArt {

	public static void main(String[] args) {
		String request = "";
		String[] parsedRequest;
		int row, column, index;
		char symbol;
		boolean triangleShape = false;
		
		Scanner scnr = new Scanner(System.in);
		AsciiShape shapeTri = new AsciiShape();
		AsciiShape shapeRect = new AsciiShape();
		AsciiGrid layoutGrid = new AsciiGrid();
		
		
		
		System.out.print("> ");
		request = scnr.nextLine();
		request = request.toLowerCase();
		parsedRequest = request.split("\\s+");
		
			
		while(!parsedRequest[0].equals("exit")) {
			
			if(parsedRequest[0].equals("triangle") || parsedRequest[0].equals("rectangle")) {
				if(parsedRequest.length != 4) {
					
					System.out.println("BAD INPUT");
				
					
				}
		
				if(parsedRequest.length == 4) {
					row = Integer.parseInt(parsedRequest[2]);
					column = Integer.parseInt(parsedRequest[3]);
					symbol = parsedRequest[1].charAt(0);
										
					if(parsedRequest[0].equals("triangle")) {
						triangleShape = true;
						shapeTri = new AsciiShape(triangleShape, row, column, symbol);
					}
					
					
					if(parsedRequest[0].equals("rectangle")) {
						triangleShape = false;
						shapeRect = new AsciiShape(triangleShape, row, column, symbol);
					}
					System.out.println("OK");
					
					
				}
			}
			
						
			System.out.print("> ");
			request = scnr.nextLine();
			request = request.toLowerCase();
			parsedRequest = request.split("\\s+");
			
			if(parsedRequest[0].equals("set")) {
				if( parsedRequest.length != 3) {
					System.out.println("BAD INPUT");
					break;
				}
				symbol = parsedRequest[1].charAt(0);
				index = Character.getNumericValue(parsedRequest[2].charAt(0));
				if(index == 0)
				{
				shapeTri.setSymbol(symbol);
				System.out.println("OK");
				}
				if(index == 1)
				{
				shapeRect.setSymbol(symbol);
				System.out.println("OK");
				}
				
			}
				
			
			if(parsedRequest[0].equals("list")) {
				String triangle = shapeTri.toString();
				String rectangle = shapeRect.toString();
															
				if (triangle.length() > 2 && rectangle.length() == 2)
				{
					System.out.print("0:\n" + triangle);
					System.out.println("OK");
				}
				
				else if (triangle.length() == 2 && rectangle.length() > 2)
				{
					System.out.print("0:\n" + rectangle);
					System.out.println("OK");
				}
				
				else  {
					System.out.print("0:\n" + triangle);
					System.out.print("1:\n" + rectangle);
					System.out.println("OK");
				}
			
			}
			
			if(parsedRequest[0].equals("new") ) {
				if(parsedRequest.length != 3)
					System.out.println("BAD INPUT");
				
				
				if (parsedRequest.length == 3) 
				{			
				
				int ruhs = Integer.parseInt(parsedRequest[1]);
				int culs = Integer.parseInt(parsedRequest[2]);
				layoutGrid = new AsciiGrid(ruhs, culs);
				System.out.println("OK");
												
				}
			
				
			}
			
			if(parsedRequest[0].equals("print") ) {
				System.out.print(layoutGrid.toString());
				System.out.println("OK");
				
			}
			
			if(parsedRequest[0].equals("clear")) {
				int ruhs = Integer.parseInt(parsedRequest[1]);
				int culs = Integer.parseInt(parsedRequest[2]);
				char[][] newArray = shapeTri.getShape();
				
				layoutGrid.clearShape(newArray,ruhs,culs);
			}
			
			if(parsedRequest[0].equals("place")) {
				int ruhs = Integer.parseInt(parsedRequest[1]);
				int culs = Integer.parseInt(parsedRequest[2]);
				int newIndex = Integer.parseInt(parsedRequest[3]);
				char[][] newArray = shapeTri.getShape();
				System.out.println("OK");
				
				
				layoutGrid.placeShape(newArray, ruhs, culs );
			}
		}
		System.out.println("OK");
	}
		
}




