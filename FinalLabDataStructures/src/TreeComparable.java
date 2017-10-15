/**
 * Interface for the Word class. Used to compare the words, printout, and operate a object. See Word for
 * detailed info on the constructors.
 * @author Jorge Sanchez
 *
 */
public interface TreeComparable {
	public int compareTo(Object o);
	public void operate(Object o);
	public void visit();
}
