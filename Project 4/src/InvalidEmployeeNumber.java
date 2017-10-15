/* Name: Jorge Sanchez
 * Date: 7/21/2015
 * Assignment: Project 4
 * This class is an extension of the Exception class. A string is passed through main instructor of the class Exception which creates the string for the name of the Exception Thrown.
 */

public class InvalidEmployeeNumber extends Exception {
	
		InvalidEmployeeNumber(String NamedException) 
		{
			super(NamedException);
		}
}

