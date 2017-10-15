/* Name: Jorge Sanchez
 * ID: 5213188
 * Date: 7/1/2015
 * Lab 7: Rainfall
 * 
 * This class takes the input of the amounts of rainfall for each month then using methods it outputs the average monthly rainfall, total rainfall,
 * the most rainfall, and the least rainfall of the 12 months.
 * 
 */

import java.util.Scanner;

public class MonthsRainfall {
	private double rainfallAmount[];


	public MonthsRainfall()
	{
		rainfallAmount = new double[12]; 
	}
	public void inputRainFall()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the amount of rainfall each month : ");
		for(int i=0;i<12;i++)
		{
			System.out.println("Rainfall of Month "+(i+1)+" : ");
			rainfallAmount[i] = input.nextDouble();
			if(rainfallAmount[i]<0)
			{
				System.out.println("Rainfall can't be negative, enter again\n");
				i--;
			}
		} 
	}
	public double totalRainFall()
	{
		double total = 0;
		for(int i=0;i<12;i++)
		{
			total += rainfallAmount[i];
		}
		return total;
	}
	public double avgMonthlyRainFall()
	{
	
		return totalRainFall()/12;
	}
	public double mostRainFall()
	{
		double most = 0;
		int month = 0;
		most = rainfallAmount[0];
		for(int i=0;i<12;i++)
		{
			if(most<rainfallAmount[i])
			{
				most = rainfallAmount[i];
				month = i;
			}
		}
		return month + 1; 
	}
	public double leastRainFall()
	{
		double least = 0;
		int month = 0;
		least = rainfallAmount[0];
		for(int i=0;i<12;i++)
		{
			if(rainfallAmount[i]<least)
			{
				least = rainfallAmount[i];
				month = i;
			}
		}
		return month + 1; 

	}

	public static void main(String args[])
	{
		MonthsRainfall rain = new MonthsRainfall();
		rain.inputRainFall();
		System.out.println("Total rainfall of the year : "+rain.totalRainFall());
		System.out.printf("Average monthly rainfall of the year : %.2f\n",rain.avgMonthlyRainFall());
		System.out.println("The month with most rain is month number: "+(int)rain.mostRainFall());
		System.out.println("The month with least rain is month number: "+(int)rain.leastRainFall());

	}
}