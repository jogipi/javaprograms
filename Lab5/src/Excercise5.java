/* Name: Jorge Sanchez
 * ID: 5213188
 * Date: 7/31/2015
 * Project 5: Airport distances output into HTML
 * This program begins asking for the number of legs involved (meaning airports). The program then asks the user for the ground speed. The program will then ask the user to input the
 * longitude and latitude coordinates of each airport. It will then create a table displaying the data as well as calculating the distance between each airport in nautical miles,
 * as well as outputting the distance in time between the two airports by calculating the number of miles divided by the ground speed in minutes.
 */
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;


public class Excercise5 {

	public static void main(String[] args) throws IOException {
		
		double nauticalMiles = 0;
		double statuteMiles = 0;
		String latitudeInput1 = "";
		String legs = "";
		String groundSpeed = "";
		String airportName = "";
		String longitudeInput1 = "";
		double dlongitudeInput1 = 0;
		double dlatitudeInput1 = 0;
		double distance = 0;
		double time = 0;
		double totalDistance = 0;
		double totalTime = 0;
		
		StringBuilder sb1 = new StringBuilder();
		 sb1.append("<html>");
		    sb1.append("<head>");
		    sb1.append("<title>Airport Distance Calculations");
		    sb1.append("</title>");
		    sb1.append("</head>");
		
		
		legs = JOptionPane.showInputDialog("How many legs?");
		int dlegs = Integer.parseInt(legs);
		Airport[] airport = new Airport[(int) (dlegs + 1)];
		
		groundSpeed = JOptionPane.showInputDialog("What is the ground speed?");
		double dgroundSpeed = Double.parseDouble(groundSpeed);
		
		for(int i = 0; i < dlegs; i++) {
		airportName = JOptionPane.showInputDialog("Please enter the name of Airport " + (i+1));
			
		latitudeInput1 = JOptionPane.showInputDialog("Enter the latitude of the coordinate of the airport number " + (i+1) + ": ");
		dlatitudeInput1 = Double.parseDouble(latitudeInput1);
		
		
		longitudeInput1 = JOptionPane.showInputDialog("Enter the longitude of the coordinate of the airport number " + (i+1) + ": ");
		dlongitudeInput1 = Double.parseDouble(longitudeInput1);
		
		airport[i] = new Airport(dlongitudeInput1, dlatitudeInput1);
		airport[i].setAirport(airportName);
						
		}
		 sb1.append("<body> <table style=\"width:30%\"> <tr><th align=\"left\"><b>Leg</th>" + "<th align=\"left\">From</th>" + "<th align=\"left\">To</th>" + "<th align=\"left\">Dist</th>" + "<th align=\"left\">Time(mins)<b></th></tr>" );
		
		for(int i = 0; i < dlegs-1; i++) {
			sb1.append("<tr>");
			
			sb1.append("<td>" + (i + 1) + "</td>");
			sb1.append("<td>" + airport[i].getAirport() + "</td>");
			sb1.append("<td>" + airport[i+1].getAirport() + "</td>");
		
			sb1.append("<td>" + (int)airport[i].airportDistance(airport[i+1]) + "</td>");
		
			sb1.append("<td>" + (int)((airport[i].airportDistance(airport[i+1])/((dgroundSpeed/60)))));
			sb1.append("</td>");
			sb1.append("</tr>");
		}
		for(int i = 0; i < dlegs-1; i++) {
			totalDistance += airport[i].airportDistance(airport[i+1]);
			totalTime += (airport[i].airportDistance(airport[i+1])/(dgroundSpeed/60));
		}
		sb1.append("<tr><td>Total</td>" + "<td></td>" + "<td></td>" + "<td>"+ (int)totalDistance + "</td><td>" + (int)totalTime + "</td></table");
	
		
		  
		    sb1.append("</body>");
		    sb1.append("</html>");
		    FileWriter fstream = new FileWriter("MyHtml.html");
		    BufferedWriter out = new BufferedWriter(fstream);
		    out.write(sb1.toString());
		    out.close();
		
		/*nauticalMiles = getDistance(dlatitudeInput1, dlongitudeInput1, latitudeInput2, longitudeInput2);
		statuteMiles = nauticalMiles * 1.15;
		
		System.out.printf("\nNautical Miles = ");
		System.out.printf("%f", nauticalMiles);
		System.out.println(" NM");
		System.out.print("Statute Miles = ");
		System.out.printf("%.2f", statuteMiles);
		System.out.print(" Miles");-
		*/					
		
	}
	
	public static double getDistance(double latitude1, double longitude1, double latitude2, double longitude2)
	{
		double nauticMiles = 0;
		double changeTheta = 0;
		double radius = 10800/Math.PI;
		
		changeTheta = Math.acos((Math.sin(latitude1) * Math.sin(longitude1)) + (Math.cos(latitude1) + Math.cos(latitude2) + Math.cos(longitude1 - longitude2)));
		
		nauticMiles = radius * changeTheta;
		
				return nauticMiles;
		
	}

}
