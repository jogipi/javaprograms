/**
 * Interface used by employee class that contains methods for making comparisons between the employee objects.
 */
public interface Comparable {

	/**
	 * Compares the last name of the current object and the object passed.
	 * @return integer representing the difference between the characters 
	 * for alphabetical purposes.
	 * @param o object to be compared.
	 */
	public int compareTo(Object o);
	/**
	 * Returns true if employee object meets the criteria of a higher than
	 *  $35,000/year and worked with the company for more than 5 years.
	 *  @return Boolean representing whether or not the employee meets criteria.
	 *  @param o object to be compared.
	 */
	public boolean compareExperience(Object o);
	/**
	 * Returns whether or not the employee is female.
	 * @return boolean determining whether or not employee is female.
	 * @param o object to be compared.
	 */
	public boolean compareIfWomen(Object o);
	/**
	 * Applying $0.75 raise to employees who make less than $10.00/hour, and 
	 * $50.00 raise for employees who make less than $350.00/week..
	 * @return boolean representing whether or not the employee needs a raise.
	 * @param o object to be compared.
	 */
	public boolean compareNeedsRaise(Object o);
}
