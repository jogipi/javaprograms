/**
 * This class does the functions to the payroll such as setting the payroll, sorting, outputting the table, adding/removing
 * from the payroll, and giving raises.
 * @author Jorge Sanchez
 */
import java.io.PrintWriter;
import java.util.Scanner;


public class Payroll {
	
	private ObjectList oblist1 = new ObjectList();
	private ObjectList oblist2 = new ObjectList();
	private PrintWriter pw;
	
	/**
	 * Constructor for payroll.
	 * This method is used to pass the printwriter object so the output to .txt can be shared with the main.
	 * @param p this is the object that holds the txt file.
	 */
	public Payroll(PrintWriter p) {
		pw = p;
	}
	
	/**
	 * This method takes the .txt file input and adds each employee to a linked list.
	 * @param f This is the object the holds the txt file.
	 */
	public void setPayroll(Scanner f)
	{
		while(f.hasNext())
		{
			String buf = f.nextLine();
			String delims = "[ ]+";
			String[] tokens = buf.split(delims);
			for (int i = 0; i < tokens.length/6; i ++)
			{
				String firstName = tokens[0];
				String lastName = tokens[1];
				char sex = tokens[2].charAt(0);
				int companyYears = Integer.parseInt(tokens[3]);
				char wageSetting = tokens[4].charAt(0);
				double payRate = Double.parseDouble(tokens[5]);
				
				oblist1.addLast(new Employee(firstName, lastName, sex, companyYears, wageSetting, payRate));
			}
		
		}
	
	}
	
	/**
	 * Outputs the payroll table.
	 */
	public void printList() {
				
    	ObjectListNode p = oblist1.getFirstNode();
    	System.out.println("\n___________________________________________________________________________________");
    	pw.println("\r\n___________________________________________________________________________________");
    	System.out.format("| %-15s| %-15s| %-10s| %-10s| %-10s| %-10s|", "First-Name", "Last-Name", "Sex", "Years", "Wage", "Salary");
    	pw.format("| %-15s| %-15s| %-10s| %-10s| %-10s| %-10s|", "First-Name", "Last-Name", "Sex", "Years", "Wage", "Salary");
    	System.out.println("\n|=================================================================================|");
    	pw.println("\r\n|=================================================================================|");
    	while (p != null) {
    		Object o = p.getInfo();
    		System.out.format("| %-15s| %-15s|\t%-6c|    %-7d|\t%-6c| %-10.2f|" ,((Employee) o).getFirstName(), ((Employee) o).getLastName(), 
    		((Employee) o).getSex(), ((Employee) o).getYearsWorked(), ((Employee) o).getWageSetting(),
    		((Employee) o).getSalary());
        	pw.format("| %-15s| %-15s|\t%-6c|    %-7d|\t%-6c| %-10.2f|" ,((Employee) o).getFirstName(), ((Employee) o).getLastName(), 
            		((Employee) o).getSex(), ((Employee) o).getYearsWorked(), ((Employee) o).getWageSetting(),
            		((Employee) o).getSalary());
    		System.out.println("");
    		pw.println("");
    		p = p.getNext();
    	}
    	System.out.println("===================================================================================");
    	pw.println("===================================================================================");

	}
	
	/**
	 * Outputs the amount of employees.
	 */
	public void employeeListAmount() {
		
    	ObjectListNode p = oblist1.getFirstNode();
    	int count = 0;
    	while (p != null) { 
    		count++;
    		p = p.getNext();
    	}
    
    	System.out.println("Amount of Employees: " + count);
    	pw.println("Amount of Employees: " + count);
    	System.out.println("");
    	pw.println("");
	    
	}
	
	/**
	 * Outputs the part of the payroll that contain women.
	 */
	public void printWomen() {

		ObjectListNode p = oblist1.getFirstNode();
    	ObjectListNode r = p.getNext();
    	Employee a = (Employee) r.getInfo();
    	Employee o = (Employee) p.getInfo();
    	System.out.println("\n___________________________________________________________________________________");
    	pw.println("\r\n___________________________________________________________________________________");
    	System.out.format("| %-15s| %-15s| %-10s| %-10s| %-10s| %-10s|", "First-Name", "Last-Name", "Sex", "Years", "Wage", "Salary");
    	pw.format("| %-15s| %-15s| %-10s| %-10s| %-10s| %-10s|", "First-Name", "Last-Name", "Sex", "Years", "Wage", "Salary");
    	System.out.println("\n|=================================================================================|");
    	pw.println("\r\n|=================================================================================|");
    	while (p != null && r!=null) {
    		a = (Employee) r.getInfo();
    		if(o.compareIfWomen(a)) {
    			p.setNext(r);
    			System.out.format("| %-15s| %-15s|\t%-6c|    %-7d|\t%-6c| %-10.2f|" ,((Employee) a).getFirstName(), ((Employee) a).getLastName(), 
    		    		((Employee) a).getSex(), ((Employee) a).getYearsWorked(), ((Employee) a).getWageSetting(),
    		    		((Employee) a).getSalary());
    			pw.format("| %-15s| %-15s|\t%-6c|    %-7d|\t%-6c| %-10.2f|" ,((Employee) a).getFirstName(), ((Employee) a).getLastName(), 
    		    		((Employee) a).getSex(), ((Employee) a).getYearsWorked(), ((Employee) a).getWageSetting(),
    		    		((Employee) a).getSalary());
    			System.out.println("");
    			pw.println("");
    		}
    		p = p.getNext();
    		r = p.getNext();
    	}
    	System.out.println("===================================================================================");
    	pw.println("===================================================================================");

	}
	
	/**
	 * Outputs the table of employees who make more then 35,000/year and have been with the company more than 5 years.
	 */
	public void printHigh() {
		
		ObjectListNode p = oblist1.getFirstNode();
		System.out.println("\n________________________________________________");
		pw.println("\r\n________________________________________________");
		System.out.format("| %-15s| %-15s| %-10s |", "First-Name", "Last-Name", "Salary");
		pw.format("| %-15s| %-15s| %-10s |", "First-Name", "Last-Name", "Salary");
		System.out.println("\n|==============================================|");
		pw.println("\r\n|==============================================|");
    	while (p != null) {
    		Object o = p.getInfo();
    		if((((Comparable) o).compareExperience(o))){
    			System.out.format("| %-15s| %-15s| %-11.2f|", ((Employee) o).getFirstName(),((Employee) o).getLastName(), ((Employee) o).getSalary());
    			pw.format("| %-15s| %-15s| %-11.2f|", ((Employee) o).getFirstName(),((Employee) o).getLastName(), ((Employee) o).getSalary());
    			System.out.println("");
    			pw.println("");
    		}
    		p = p.getNext();
    	}
		System.out.println("================================================");
		pw.println("================================================");
	}
	
	/**
	 * Outputs a table after giving the raises to employees who meet certain conditions.
	 */
	public void applyRaises() {
		
		ObjectListNode p = oblist1.getFirstNode();
		System.out.println("\n________________________________________________");
		pw.println("\r\n________________________________________________");
		System.out.format("| %-15s| %-15s| %-10s |", "First-Name", "Last-Name", "New Salary");
		pw.format("| %-15s| %-15s| %-10s |", "First-Name", "Last-Name", "New Salary");
		System.out.println("\n|==============================================|");
		pw.println("\r\n|==============================================|");
		while (p != null) {
    		Object o = p.getInfo();
    		if(((Comparable) o).compareNeedsRaise(o)){
    			System.out.format("| %-15s| %-15s| %-11.2f|", ((Employee) o).getFirstName(),((Employee) o).getLastName(), ((Employee) o).getSalary());
    			pw.format("| %-15s| %-15s| %-11.2f|", ((Employee) o).getFirstName(),((Employee) o).getLastName(), ((Employee) o).getSalary());
    			System.out.println("");
    			pw.println("");
    		}
    		p = p.getNext();
		}
		System.out.print("================================================");
		pw.print("================================================");
	
	}
	
	/**
	 * Sorts the payroll list in order.
	 */
	public void sortList() {
		
		ObjectListNode p = oblist1.getFirstNode();
		while (p != null){
			oblist2.insert(oblist1.removeFirst());
			p = p.getNext();
		}
		
		p = oblist2.getFirstNode();
		oblist1 = oblist2;
	}  	
	
	/**
	 * Hires the employees who are contained in the hireFile.txt
	 * @param f Object that holds the txt file.
	 */
	public void setHire(Scanner f){
		while(f.hasNext()){
			String buf = f.nextLine();
			String delims = "[ ]+";
			String[] tokens = buf.split(delims);
			for (int i = 0; i < tokens.length/6; i ++) {
				String firstName = tokens[0];
				String lastName = tokens[1];
				char sex = tokens[2].charAt(0);
				int companyYears = Integer.parseInt(tokens[3]);
				char wageSetting = tokens[4].charAt(0);
				double payRate = Double.parseDouble(tokens[5]);
				
				oblist1.insert(new Employee(firstName, lastName, sex, companyYears, wageSetting, payRate));
			}
		
		}
	}
	
	/**
	 * Fire the employees who are contained in the fireFile.txt
	 * @param f Object the holds the txt file.
	 */
	public void setFire(Scanner f) {
		ObjectListNode p = oblist1.getFirstNode();
		while(f.hasNext()){
			String buf = f.nextLine();
			String delims = "[ ]+";
			String[] tokens = buf.split(delims);
			for (int i = 0; i < tokens.length; i ++)
			{
				String firstName = tokens[0];
				String lastName = tokens[1];
				char sex = tokens[2].charAt(0);
				p = oblist1.getFirstNode();
				while(p != null){
					if ((((Employee) p.getInfo()).getLastName().compareTo(lastName)== 0 && 
							(((Employee) p.getInfo()).getFirstName().compareTo(firstName) == 0))
							&& ((Employee) p.getInfo()).getSex() == sex)
						oblist1.remove(p.getInfo());
						p = p.getNext();
				}
			}
		}
	}
}
