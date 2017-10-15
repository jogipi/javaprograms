/* Name: Jorge Sanchez
 * Date: 7/21/2015
 * Assignment: Project 4
 * This class is an extension of the employee class. The additional information in the the main constructor is whether the shift is during the day or night, as well as
 * the hourly pay. If an invalid shift, invalid employee number, or an invalid pay rate is passed through the parameters, an exception is called.
 *
 */

public class ProductionWorker extends Employee{
	private int shift;
	private double hourlyPayRate;
	
	
		public ProductionWorker()
		{
			super();
			shift = 0;
			hourlyPayRate = 0.0; 
		}
		
		public ProductionWorker(String empName, String empNumber, String hireDate, int chosenShift, double hourlyPay) throws InvalidEmployeeNumber, InvalidShift, InvalidPayRate
		{
			super(empName, empNumber, hireDate);
			if(chosenShift == 1 || chosenShift  == 2)
			{
			  shift  = chosenShift;
			}
			else
			{
			throw new InvalidShift("Invalid Shift Found");
			}

			if(hourlyPay > 0)
			{
			hourlyPayRate = hourlyPay;
			}
			else
			{
			throw new InvalidPayRate("Negative PayRate Found");
			}
			
			shift = chosenShift;
			hourlyPayRate = hourlyPay;
		}
		
		
		
		public void setShift(int s)
		{
			shift = s;
		}
		
		public void setHourlyPayRate(double rate)
		{
			hourlyPayRate = rate;
		}
		
		public int getShift()
		{
			return shift;
		}
		
		public double getHourlyPayRate()
		{
			return hourlyPayRate;
		}
		
		
		
}