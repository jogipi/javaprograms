/* Name: Jorge Sanchez
 * Date: 7/21/2015
 * Assignment: Project 4
 * This class holds the employee's name, number and date hired information.  If an invalid employee number is passed through the parameters an exception error is called.
 *
 */


public class Employee {
	String employeeName;
	String employeeNumber;
	String dateHired;
	private boolean validNumber = false;
     

	public Employee()
	{
		employeeName = "";
		employeeNumber = "";
		dateHired = ""; 
	}
	
	public Employee(String empname, String empnumber, String hireDate) throws InvalidEmployeeNumber {
		employeeName = empname;
		dateHired = hireDate;
				
		while (!validNumber)
        {
            if (empnumber.length()!=5)
            {
            	throw new InvalidEmployeeNumber("Invalid EmployeeNumber");
            }
            if(((!Character.isDigit(empnumber.charAt(0))) || ((!Character.isDigit(empnumber.charAt(1)))) ||
              ((!Character.isDigit(empnumber.charAt(2)))) || !(empnumber.charAt(3) =='-') ||
              ((Character.isDigit(empnumber.charAt(4)))) || (!(empnumber.charAt(4)>= 'A' && empnumber.charAt(4)<='M'))))
            	throw new InvalidEmployeeNumber("Invalid EmployeeNumber");
            else
             {
            	employeeNumber = empnumber;
                validNumber = true;               
             }
            
         }
		
		
		
	}
	
	public void setEmpName(String empname)
	{
		employeeName = empname;
	}
	
	
	public void setHireDate(String hireDate)
	{
		dateHired = hireDate; 
	}
	
	public String getEmpName()
	{
		return employeeName;
	}
	
	public String getEmpNumber()
	{
		return employeeNumber;
	}
	
	public String getHireDate()
	{
		return dateHired;
	}

	}



