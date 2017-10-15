/*Name: Jorge Sanchez
 * Date: 6/29/2015
 * Lab 8: A first look at classes
 * This is a class that uses getter and setters to create the airports coordinates of longitude, latitude, variation, and elevation about sea level as well as input its name.
 * This class also has a method that returns the distance between two airport objects of type class Coordinates as well as Airport.
 * 
 */

import java.lang.Math;

public class Airport {
	
	private double latitude;
	private double longitude;
	private double variation;
	private double elevation;
	private String defaultAirport;
	
	public Airport()
	{
	defaultAirport = "";
	elevation = 0;
	variation = 0;
	longitude = 0;
	latitude = 0;
	}
	
	public Airport(double longCoor, double latCoor)
	{
		longitude = longCoor;
		latitude = latCoor;
	}
	
	public Airport(Coordinates a)
	{
		longitude = a.getLongitude();
		latitude = a.getLatitude();
		
	}
	
	public Airport(String location, double elev, double var, double longit, double lat)
	{
		defaultAirport = location;
		elevation  = elev;
		variation = var;
		longitude = longit;
		latitude = lat;
				
	}
	
	public void setAirport (String s)
	{
		defaultAirport = s;
	}
	
	public void setElevation (double elevate)
	{
		elevation = elevate;
	}
	
	public void setVariation (double variate)
	{
		variation = variate;
	}
	
	public void setLongitude (double longitu)
	{
		longitude = longitu;
	}
	
	public void setLatitude (double latit)
	{
		if(latit != 0)
		latitude = latit;
	}
	
	public double getElevation ()
	{
		return elevation;
	}
	
	public double getVariation ()
	{
		return variation;
	}
	
	public double getLongitude ()
	{
		return longitude;
	}

	public double getLatitude ()
	{
		return latitude;
	}
	
	public String getAirport ()
	{
		return defaultAirport;
	}
	
	public double airportDistance (Airport air2)
	{
		double longitude1 = longitude;
		double latitude1 = latitude;
		double longitude2 = air2.getLongitude();
		double latitude2 = air2.getLatitude();
		
		double nauticMiles = 0;
		double changeTheta = 0;
		double radius = 10800/Math.PI;
		
		changeTheta = Math.acos((Math.sin(latitude1) * Math.sin(latitude2)) + ((Math.cos(latitude1) * Math.cos(latitude2)) * (Math.cos(longitude1 - longitude2))));
		
		
		nauticMiles = radius * changeTheta;
		
				return nauticMiles;
		
	}
	
	public double airportDistance(double c, double d)
	{
		double longitude1 = longitude;
		double latitude1 = latitude;
		double longitude2 = c;
		double latitude2 = d;
		double nauticMiles = 0;
		double changeTheta = 0;
		double radius = 10800/Math.PI;
		

		changeTheta = Math.acos((Math.sin(latitude1) * Math.sin(latitude2)) + ((Math.cos(latitude1) * Math.cos(latitude2)) * (Math.cos(longitude1 - longitude2))));
		
		
		nauticMiles = radius * changeTheta;
	
				return nauticMiles;
		
	}
	
	public double airportDistance(Coordinates f)
	{
		double longitude1 = longitude;
		double latitude1 = latitude;
		double longitude2 = f.getLongitude();
		double latitude2 = f.getLatitude();
		double nauticMiles = 0;
		double changeTheta = 0;
		double radius = 10800/Math.PI;
		

		changeTheta = Math.acos((Math.sin(latitude1) * Math.sin(latitude2)) + ((Math.cos(latitude1) * Math.cos(latitude2)) * (Math.cos(longitude1 - longitude2))));
		
		
		nauticMiles = radius * changeTheta;
	
				return nauticMiles;
	}
	

}

