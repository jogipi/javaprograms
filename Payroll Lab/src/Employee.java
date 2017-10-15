/**
 * This class holds the employees information.
 * @author Jorge Sanchez
 */
public class Employee implements Comparable{
	private String firstName;
	private String lastName;
	private char sex;
	private int yearsWorked;
	private char wageSetting;
	private double salary;
	
	/**
	 * This is the default constructor that sets the default values for the employee's information.
	 */
	public Employee(){
		firstName = "EmptyFirst";
		lastName = "EmptyLast";
		sex = 'N';
		yearsWorked = 0;
		wageSetting = 'X';
		salary = 0.00;
	}
	
	/**
	 * This constructor sets the value for the employee's information.
	 * @param fn First name of the employee.
	 * @param ln Last name of the employee.
	 * @param s Sex of the employee.
	 * @param yrs Amount of years working for the company.
	 * @param ws Wage setting of either hourly or weekly.
	 * @param sal The salary for the employee.
	 */
	public Employee(String fn, String ln, char s, int yrs, char ws, double sal) {
		firstName = fn;
		lastName = ln;
		sex = s;
		yearsWorked = yrs;
		wageSetting = ws;
		salary = sal;
	}
	
	/**
	 * Returns the last name.
	 * @return String of last name of employee.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Returns the first name,
	 * @return String of first name of the employee.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Returns the sex.
	 * @return Character representing whether Male(M) or Female(F)
	 */
	public char getSex() {
		return sex;
	}
	
	/**
	 * Returns the amount of years worked.
	 * @return Integer of how many years worked.
	 */
	public int getYearsWorked() {
		return yearsWorked;
	}
	
	/**
	 * Gets the wage setting.
	 * @return Character representing the wage setting.
	 */
	public char getWageSetting() {
		return wageSetting;
	}
	
	/**
	 * Gets the salary.
	 * @return Double representing the employee salary.
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * Change the value of the salary of the employee.
	 * @param s double representing the salary amount.
	 */
	public void setSalary(double s) {
		salary = s;
	}

	/**
	 * Returns true if employee object meets the criteria of a higher than
	 *  $35,000/yr and worked with the company for more than 5 years.
	 *  @return Boolean representing whether or not the employee meets criteria.
	 *  @param o object to be compared.
	 */
	public boolean compareExperience(Object o) {
		Employee e = (Employee) o;
		double annualSalary = 0;
		
		if(e.getWageSetting() == 'H')
			annualSalary = (e.getSalary() * 40 * 4 * 12);
		else
			annualSalary = (e.getSalary() * 4 * 12);
		
		if(e.getYearsWorked() > 5 && annualSalary > 35000)
			return true;
		else
			return false;
	}

	/**
	 * Returns whether or not the employee is female.
	 * @return boolean determining whether or not employee is female.
	 * @param o object to be compared.
	 */
	public boolean compareIfWomen(Object o) {
		Employee e = (Employee) o;

		if(e.getSex() == 'F')
			return true;
		else
			return false;
	}
	
	/**
	 * Applying $0.75 raise to employees who make less than $10.00/hr, and 
	 * $50.00 raise for employees who make less than $350.00/week..
	 * @return boolean representing whether or not the employee needs a raise.
	 * @param o object to be compared.
	 */
	public boolean compareNeedsRaise(Object o) {
		Employee e = (Employee) o;
		boolean needsRaise = false;
		
		if(e.getWageSetting() == 'H'){
			if(e.getSalary() < 10.00){
				needsRaise = true;
				e.setSalary(e.getSalary() + 0.75);
			}
		}
		else
			if(e.getSalary() < 350.00){
				needsRaise = true;
				e.setSalary(e.getSalary() + 50.00);
			}				
		
		return needsRaise;
	}
	/**
	 * Compares the last name of the current object and the object passed.
	 * @return integer representing the difference between the characters 
	 * for alphabetical purposes.
	 * @param o object to be compared.
	 */
	public int compareTo(Object o) {
		Employee e = (Employee) o;
		return lastName.compareTo(e.getLastName());
	}


	

}
