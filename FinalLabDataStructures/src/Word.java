import java.io.PrintWriter;

/**
 * This class holds the information for each word.
 * @author Jorge Sanchez
 *
 */

public class Word implements TreeComparable {
	private String word;
	private int lineNumber;
	private int linePlacement;
	private ObjectList oblist = new ObjectList();
	private PrintWriter pw;
	/**
	 * Constructor which sets up the line number and placement within the line.
	 * @param w String which holds the word
	 * @param lineNum number of the line which the word belong
	 * @param linePlace number of the placement within the line
	 * @param p object that holds the file for output
	 */
	public Word(String w, int lineNum, int linePlace, PrintWriter p){
		word = w;
		lineNumber = lineNum;
		linePlacement = linePlace;
		oblist.addLast(new LinePosition(lineNum, linePlace, p));
		pw = p;
	}
	
	/**
	 * Compares the object sent with each word.
	 * @param o the object to be compared.
	 */
	public int compareTo(Object o) {
		Word w = (Word) o;
		return word.compareTo(w.getWord());
	}
	
	/**
	 * Adds to the linked list a new line placement
	 */
	public void operate(Object o) {
		int line = ((Word) o).getLine();
		int place = ((Word) o).getPlace();
 		oblist.addLast(new LinePosition(line, place, pw));
	}
	/**
	 * Retrieval of word in current object.
	 * @return word String of the word set in field.
	 */
	public String getWord(){
		return word;
	}
	/**
	 * Retrieval of line number of word in field
	 * @return lineNumber number of line which word belongs
	 */
	public int getLine(){
		return lineNumber;
	}
	/**
	 * Retrieval of placement of word within a line
	 * @return linePlacement is the place within a line
	 */
	public int getPlace(){
		return linePlacement;
	}
	/**
	 * Function used to output line numbers of specific word in object.
	 */
	public void visit() {
		int i = 0;
		System.out.format("%-15s", word);
		pw.format("%-15s", word);
		ObjectListNode p = oblist.getFirstNode();
		while(p != null){
			i++;
			p = p.getNext();
		}
		p = oblist.getFirstNode();
		System.out.print("\t" + i);
		pw.print("\r\t" + i);
		while(p != null){
			Object o = p.getInfo();		
			((LinePosition) o).getPositions();
			System.out.print(" ");
			pw.print(" ");
			p = p.getNext();
		}
		System.out.println();
		pw.println();
	
		return;
	}
}
