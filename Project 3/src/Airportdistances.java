import java.util.Scanner;

public class Airportdistances {

	public static void main(String[] args) {
		int amountAirports = 0;
		Scanner input = new Scanner(System.in);
		String name;
		double longitude;
		double latitude;

		System.out.println("How many Airports are involved?");
		amountAirports = input.nextInt();
		
		for(int index = 0; index < amountAirports ; index ++)
			
		{
			Airports[] airportArray = new Airports[index+1];
			System.out.println("Please enter the name of the airport number " + (index + 1) + ": ");
			name = input.nextLine();
			
			//System.out.println(airportArray.length);
			airportArray[index].setAirport(name);
			/*System.out.println("Please enter the longitude coordinate of the" + (index + 1) + "airport: ");
			longitude = input.nextDouble();
			airportArray[index+1].setLongitude(longitude);
			System.out.println("Please enter the latitude coordinate of the" + (index + 1) + "airport: ");
			latitude = input.nextDouble();
			airportArray[index+1].setLatitude(latitude);
			*/
			name = airportArray[index].getAirport();
			System.out.println(name);
		}
		
			

	}

}
