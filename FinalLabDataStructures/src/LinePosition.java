/**
 * This class holds the information for a word's line position.
 */
import java.io.PrintWriter;


public class LinePosition {
	private int lineNumber;
	private int position; //word-by-word position
	private PrintWriter pw;

	/**
	 * Default constructor
	 */
	public LinePosition(){
		lineNumber = 0;
		position = 0;
	}
	
	/**
	 * Sets line position in a line of text as well as the line number
	 * @param lineNum line number
	 * @param linePos position within the line
	 * @param p object that holds the output file.
	 */
	public LinePosition(int lineNum, int linePos, PrintWriter p) {
		lineNumber = lineNum;
		position = linePos;
		pw = p;
	}
	
	/**
	 * This is for retrival of the position in string form
	 */
	public void getPositions() {
		System.out.print("\t" + lineNumber + "-" + position);
		pw.print("\r\t" + lineNumber + "-" + position);
	}
	
	/**
	 * Retrieval of the line number of a specific word.
	 * @return int of line number
	 */
	public int getLine(){
		return lineNumber;
	}
	
	/**
	 * retrieval of the position of a word within a line.
	 * @return integer value of the position of the word in the line.
	 */
	public int getPosition(){
		return position;
	}
}
