/*
 * This is the driver of the program its main function is to connect all the classes into one.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Driver {

	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Scanner fileScan = new Scanner(new File("mfq.txt"));
		MFQ mfq = new MFQ(pw);
		mfq.setJobs(fileScan);
		mfq.outputHeader();
		mfq.runSimulation();
		mfq.OutputStats();
		pw.close();
		return;
	}

}
