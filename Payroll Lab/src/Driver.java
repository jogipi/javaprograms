/**
 * @author Jorge Sanchez
 * Date: 11/6/2015
 * ID: 011175824
 * This is the driver of the program its main function is to connect all the classes into one.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Scanner payFile = new Scanner(new File("payfile.txt"));
		Scanner hireFile = new Scanner(new File("hireFile.txt"));
		Scanner fireFile = new Scanner(new File("fireFile.txt"));
		Payroll pr = new Payroll(pw);
		
		System.out.print("The following output is the current payroll from payfile.txt");
		pw.print("The following output is the current payroll from payfile.txt");
		pr.setPayroll(payFile);
		pr.printList();
		
		pr.employeeListAmount();
		
		System.out.print("\nThe following table outputs the women on the payroll");
		pw.print("\r\nThe following table outputs the women on the payroll");
		pr.printWomen();
		
		System.out.print("\nThe following table outputs those employees who make more"
				+ " than $35,000 per year and have been with the company for at least five years.");
		pw.print("\r\nThe following table outputs those employees who make more"
				+ " than $35,000 per year and have been with the company for at least five years.");
		pr.printHigh();
		
		System.out.print("\nApplying $0.75 raise to employees who make less than $10.00/hr, and "
				+ "$50.00 raise for employees who make less than $350.00/week...");
		pw.print("\r\nApplying $0.75 raise to employees who make less than $10.00/hr, and "
				+ "$50.00 raise for employees who make less than $350.00/week...");
		pr.applyRaises();
		pr.printList();
		
		System.out.print("\nSorting list alphabetically by the last name ");
		pw.print("\r\nSorting list alphabetically by the last name ");
		pr.sortList();
		
		System.out.print("\nInserting new employees in payroll based on hireFile.txt");
		pw.print("\r\nInserting new employees in payroll based on hireFile.txt");
		pr.setHire(hireFile);
		pr.printList();
		
		System.out.print("\nRemoving employees from payroll base on fireFile.txt");
		pw.print("\r\nRemoving employees from payroll base on fireFile.txt");
		pr.setFire(fireFile);
		pr.printList();
		pw.close();
		return;

	}

}
