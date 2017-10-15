/*
 * This class is used to create the simulation of a multi level feedbackloop.
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class MFQ 
{
	public ObjectQueue inputQ = new ObjectQueue();
	public ObjectQueue levelOne = new ObjectQueue();
	public ObjectQueue levelTwo = new ObjectQueue();
	public ObjectQueue levelThree = new ObjectQueue();
	public ObjectQueue levelFour = new ObjectQueue();
	private CPU cpu = new CPU();
	private PrintWriter pw;
	private int arrivalTime;
	private int pid;
	private int cpuTimeRequired;
	private int clock = 0;
	private Object currentJob;
	private Object temp;
	private Object temp2;
	private boolean departure = false;
	private boolean arrival = false;
	private double totalJobs = 0;
	private double avgResponse = 0.01;
	private double averageQueue = 0;
	private double totalIdle;
	private double totalResponse = 0;
	
	/*
	 * Default constructor sets all characteristics of a job to zero.
	 */
	public MFQ()
	{
		arrivalTime = 0;
		pid = 0;
		cpuTimeRequired = 0;
	}
	
	/*
	 * This method is used to pass the printwriter object so the output to .txt can be shared weith the main.
	 * @param this is the object that holds the txt file.
	 */
	public MFQ(PrintWriter p)
	{
		pw = p;
	}
	
	/*
	 * This method gathers the jobs from the txt document 'mfq.txt'
	 * @param The scanner object is used to scan the document.
	 */
	public void setJobs(Scanner f)
	{
		while(f.hasNext())
		{
			String buf = f.nextLine();
			String delims = "[ ]+";
			String[] tokens = buf.split(delims);
			for (int i = 0; i < tokens.length/3; i ++)
			{
				arrivalTime = Integer.parseInt(tokens[0]);
				pid = Integer.parseInt(tokens[1]);
				cpuTimeRequired = Integer.parseInt(tokens[2]);	
				inputQ.insert(new Job(arrivalTime, pid, cpuTimeRequired));
				totalJobs++;
			}
		
		}
	
	}
	
	/*
	 * This method outputs the header of the table. It also prints the header to csis.txt.
	 */
	
	public void outputHeader()
	{
		System.out.format("%10s%8s%5s%8s%8s%8s", "", "", "", "CPU",
				"Total", "Lowest");
		pw.format("%10s%8s%5s%8s%8s%8s", "", "", "", "CPU",
				"Total", "Lowest");
		System.out.println("");
		pw.println("");
		System.out.format("%10s%8s%5s%8s%8s%8s", "", "System", "", "Time",
				"Time In", "Level");
		pw.format("%10s%8s%5s%8s%8s%8s", "", "System", "", "Time",
				"Time In", "Level");
		System.out.println("");
		pw.println("");
		System.out.format("%10s%8s%5s%8s%8s%8s", "Event", "Time", "PID", "Needed",
				"System", "Queue");
		pw.format("%10s%8s%5s%8s%8s%8s", "Event", "Time", "PID", "Needed",
				"System", "Queue");
		pw.println("");
		pw.println("");
		System.out.println("");
		System.out.println("");
	}
	
	/*
	 * This is the simulation of the feedback loop. Jobs are carried into the while loop and the algorithm determines
	 * which process has the higher priority as well as which have the lower priorities. The jobs that are first input are placed on 
	 * the highest priority. If the process finishes in time then it is complete and there are no further necessary actions
	 *  However if, the job does not finish in time before preemption occurs, then we send the job to a lower level priority which
	 *  gives it a larger quantum clock meaning a longer time to process. Preemption occurs when anothe rprocess enters the system
	 *  or if the quantum time has expired.
	 */
	
	public void runSimulation()
	{
		clock = 0;
		clock++; 
		// tick tock		
		while(!(inputQ.isEmpty()) || !levelOne.isEmpty() || !levelTwo.isEmpty() || !levelThree.isEmpty())
		{	
			departure = false;
			arrival = false;
			//System.out.println("System Clock: " + clock);
			
			if(!(inputQ.isEmpty()))
				temp = inputQ.query();
			//If the time of the clock is equal to the arrival time.
			//add the job to the first level and output message.
			if ( ((Job)temp).getArrivalTime() == clock) 
			{
				arrival = true;	
				currentJob = cpu.getJob();
				if(cpu.getLevel() == 1)
				{
					levelTwo.insert(currentJob);
					averageQueue++;
				}
				else if(cpu.getLevel() == 2)
				{
					levelThree.insert(currentJob);
					averageQueue++;
				}
				else if(cpu.getLevel() == 3)
				{
					levelFour.insert(currentJob);
					averageQueue++;
				}
				
				// System.out.println("Placing Job into first level");
				levelOne.insert(inputQ.remove());

			}
			//is the CPU busy?
			//if it is.
			if(!cpu.isBusy())
			{
				if(!(levelOne.isEmpty()))
				{
					currentJob = levelOne.remove();
					cpu.setQuantumLevel1();
					cpu.setcpuJob((Job) currentJob);
				}
				else if(!(levelTwo.isEmpty()))
				{
					currentJob = levelTwo.remove();
					cpu.setQuantumLevel2();
					cpu.setcpuJob((Job) currentJob);
				}
				else if(!(levelThree.isEmpty()))
				{
					currentJob = levelThree.remove();
					cpu.setQuantumLevel3();
					cpu.setcpuJob((Job) currentJob);
				}
				else if(!(levelFour.isEmpty()))
				{
					currentJob = levelFour.remove();
					cpu.setQuantumLevel4();
					cpu.setcpuJob((Job) currentJob);
				}
			}
			else  // if the CPU is busy
			{			
				{
					//decrement the clocks for the CPU and the job
					if(!(inputQ.isEmpty()))
						temp = inputQ.query();
					
					cpu.decrementQuantum();
					((Job) currentJob).decrementTime();
					//if the job is finished
					if(((Job) currentJob).getcpuTimeRemaining() == 0) 
					{
						temp2 = currentJob;
						cpu.clearCPU();
						
						departure = true;
						
						if(!(inputQ.isEmpty()))
						temp = inputQ.query();
						cpu.setNotBusy();
						
						if (!(levelOne.isEmpty()))
						{
							currentJob = levelOne.remove();
							cpu.setQuantumLevel1();
							cpu.setcpuJob((Job) currentJob);
						}
						else if(!(levelTwo.isEmpty()))
						{
							currentJob = levelTwo.remove();
							cpu.setQuantumLevel2();
							cpu.setcpuJob((Job) currentJob);
						}
						else if(!(levelThree.isEmpty()))
						{
							currentJob = levelThree.remove();
							cpu.setQuantumLevel3();
							cpu.setcpuJob((Job) currentJob);
						}
						else if(!(levelFour.isEmpty()))
						{
							currentJob = levelFour.remove();
							cpu.setQuantumLevel4();
							cpu.setcpuJob((Job) currentJob);
						}
					}
					//if the job has not completed
					//preemption: can occur if job quantum has expired or if a new job has entered the network
					//if preemption occurs place the currentJob onto the next level.	
					else if (((Job) temp).getArrivalTime() == clock)
					{
						currentJob = cpu.getJob();
						
						if(cpu.getLevel() == 1)
						{
								levelTwo.insert(currentJob);
								averageQueue++;
						}
						else if(cpu.getLevel() == 2)
						{
								levelThree.insert(currentJob);
								averageQueue++;
						}
						else if(cpu.getLevel() == 3)
						{
								levelFour.insert(currentJob);
								averageQueue++;
						}
						
						//currentJob = i
						
						if (!(levelOne.isEmpty()))
						{
							currentJob = levelOne.remove();
							cpu.setQuantumLevel1();
							cpu.setcpuJob((Job) currentJob);
						}
						else if(!(levelTwo.isEmpty()))
						{
							currentJob = levelTwo.remove();
							cpu.setQuantumLevel2();
							cpu.setcpuJob((Job) currentJob);
						}
						else if(!(levelThree.isEmpty()))
						{
							currentJob = levelThree.remove();
							cpu.setQuantumLevel3();
							cpu.setcpuJob((Job) currentJob);
						}
						else if(!(levelFour.isEmpty()))
						{
							currentJob = levelFour.remove();
							cpu.setQuantumLevel4();
							cpu.setcpuJob((Job) currentJob);
						}
					}
					else if( (cpu.getQuantum() == 0))
					{
						currentJob = cpu.getJob();
						
						if(cpu.getLevel() == 1)
						{
							levelTwo.insert(currentJob);
							averageQueue++;
						}
						else if(cpu.getLevel() == 2)
						{
							levelThree.insert(currentJob);
							averageQueue++;
						}
						else if(cpu.getLevel() == 3)
						{
							levelFour.insert(currentJob);
							averageQueue++;
						}
					
						cpu.clearCPU();
						
						if (!(levelOne.isEmpty()))
						{
							currentJob = levelOne.remove();
							cpu.setQuantumLevel1();
							cpu.setcpuJob((Job) currentJob);
						}
						else if(!(levelTwo.isEmpty()))
						{
							currentJob = levelTwo.remove();
							cpu.setQuantumLevel2();
							cpu.setcpuJob((Job) currentJob);
						}
						else if(!(levelThree.isEmpty()))
						{
							currentJob = levelThree.remove();
							cpu.setQuantumLevel3();
							cpu.setcpuJob((Job) currentJob);
						}
						else if(!(levelFour.isEmpty()))
						{
							currentJob = levelFour.remove();
							cpu.setQuantumLevel4();
							cpu.setcpuJob((Job) currentJob);
						}
					}
										
				}
					
			}
				if(!cpu.isBusy())
					totalIdle++;
				
				if (clock == 173)
					departure = true;
				
				if(departure)
				{
					temp = cpu.getJob();
					System.out.format("%10s%8d%5d%8s%8d%8d", "Departure", clock, ((Job) temp2).getpid(), 
							"", (clock - ((Job) temp).getArrivalTime()), ((cpu.getLevel()))+1) ;
					pw.format("%10s%8d%5d%8s%8d%8d", "Departure", clock, ((Job) temp2).getpid(), 
							"", (clock - ((Job) temp).getArrivalTime()), ((cpu.getLevel()))+1);
					pw.println("");
					System.out.println("");
					totalResponse += (clock - ((Job) temp).getArrivalTime());
				}
				if(arrival)
				{
					System.out.format("%10s%8d%5d%8d%8d%8s", "Arrival", clock, ((Job) temp).getpid(), ((Job) temp).getcpuTimeRequired(), 
							((Job) temp).getcpuTimeRequired(), "");
					pw.format("%10s%8d%5d%8d%8d%8s", "Arrival", clock, ((Job) temp).getpid(), ((Job) temp).getcpuTimeRequired(), 
							((Job) temp).getcpuTimeRequired(), "");
					pw.println("");
					System.out.println("");	
				}
				clock++;
		}
		
		
			
	}
	
	/*
	 * This method outputs the final stats of the program based on the jobs.
	 */
	
	public void OutputStats() {
		System.out.println("");
		pw.println("");
		System.out.println("Total Jobs: " + String.format( "%.2f", totalJobs ));
		pw.println("Total Jobs: " + String.format( "%.2f", totalJobs ));
		System.out.println("Total Time: " + String.format("%.2f", ((double)clock - 1)));
		pw.println("Total Time: " + String.format("%.2f", ((double)clock - 1)));
		System.out.println("Total Idle: " + String.format( "%.2f", totalIdle));
		pw.println("Total Idle: " + String.format( "%.2f", totalIdle));
		System.out.println("Average Turnaround: " + String.format("%.2f", totalResponse/(clock-1)/(totalJobs)));
		pw.println("Average Turnaround: " + String.format("%.2f", totalResponse/(clock-1)/(totalJobs)));
		System.out.println("Average Wait: " + String.format("%.2f", averageQueue/(clock-1)));
		pw.println("Average Wait: " + String.format("%.2f", averageQueue/(clock-1)));
		System.out.println("Average Response: " + String.format("%.2f", avgResponse));
		pw.println("Average Response: " + String.format("%.2f", avgResponse));
		System.out.println("Average throughput: " + String.format("%.2f", totalResponse/(clock-1)));
		pw.println("Average throughput: " + String.format("%.2f", totalResponse/(clock-1)));
		
	}
}
		


	

