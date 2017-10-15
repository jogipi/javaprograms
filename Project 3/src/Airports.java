
public class Airports {
	
	private double latitude;
	private double longitude;
	private double variation;
	private double elevation;
	private String defaultAirport;
	
	public Airports()
	{
	defaultAirport = "";
	elevation = 0;
	variation = 0;
	longitude = 0;
	latitude = 0;
	}
	
	public Airports(double longCoor, double latCoor)
	{
		longitude = longCoor;
		latitude = latCoor;
	}
	

	public Airports(String location, double elev, double var, double longit, double lat)
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
	
	public double airportDistance (Airports air2)
	{
		double longitude1 = longitude;
		double latitude1 = latitude;
		double longitude2 = air2.getLongitude();
		double latitude2 = air2.getLatitude();
		
		double nauticMiles = 0;
		double changeTheta = 0;
		double radius = 10800/Math.PI;
		
		changeTheta = Math.acos((Math.sin(latitude1) * Math.sin(longitude1)) + (Math.cos(latitude1) + Math.cos(latitude2) + Math.cos(longitude1 - longitude2)));
		
		
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
		

		changeTheta = Math.acos((Math.sin(latitude1) * Math.sin(longitude1)) + (Math.cos(latitude1) + Math.cos(latitude2) + Math.cos(longitude1 - longitude2)));
		
		
		nauticMiles = radius * changeTheta;
	
				return nauticMiles;
		
	}
	

	

}

