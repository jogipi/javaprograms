/* Name: Jorge Sanchez
 * Date: 7/21/2015
 * Assignment: Project 4
 * This is the main method that drives the classes. Two valid test cases are used. The output of the program is the input of the Employee's Name, employee number, 
 * shift time, hourly pay, and the date of hire.
 */
public class Main {

/**
* @param args the command line arguments
*/
	public static void main(String args[]) throws InvalidEmployeeNumber, InvalidShift, InvalidPayRate {
		
		String shiftTime1 = "";
		String shiftTime2 = "";
		ProductionWorker pw1 = new ProductionWorker("Christian Gray","638-B","10/13/1988",1,55.25);

		ProductionWorker pw2 = new ProductionWorker("Joshua Ortega","425-H","11/11/2006",2,41.75);
		
		if(pw1.getShift() == 1)
		shiftTime1 = "Day";
		if (pw1.getShift() == 2)
		shiftTime1 = "Night";
		if(pw2.getShift() == 1)
		shiftTime2 = "Day";
		if (pw2.getShift() == 2)
		shiftTime2 = "Night";

		System.out.println("Name: " + pw1.getEmpName() + "\nEmployee Number: " + pw1.getEmpNumber() + "\nShift: " + shiftTime1 + "\nHourlyPay: " + pw1.getHourlyPayRate() + "\nDate Hired: " + pw1.getHireDate() + "\n");
		System.out.println("Name: " + pw2.getEmpName() + "\nEmployee Number: " + pw2.getEmpNumber() + "\nShift: " + shiftTime2 + "\nHourlyPay: " + pw2.getHourlyPayRate() + "\nDate Hired: " + pw2.getHireDate() + "\n");
	}
}
	