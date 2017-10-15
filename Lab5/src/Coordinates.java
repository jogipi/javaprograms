/* Name: Jorge Sanchez
 * Date : 7/9/2015
 * Lab Assignment 8
 * This class has the longitude and latitude accessor and mutator methods.
 */
public class Coordinates {

	private double latitude;
	private double longitude;
	
	
	
	public void setLongitude (double longitu)
	{
		longitude = longitu;
	}
	
	public void setLatitude (double latit)
	{
		if(latit != 0)
		latitude = latit;
	}
	
	
	public double getLongitude ()
	{
		return longitude;
	}

	public double getLatitude ()
	{
		return latitude;
	}
	

	
}
