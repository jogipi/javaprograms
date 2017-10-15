/*
 * This class holds the characteristics of the job.
 */
public class Job {
	private int pid, arrivalTime, cpuTimeRequired, 
	cpuTimeRemaining = 0;
	
	/*
	 * Default constructor to set everything to 0.
	 */
	public Job() {
		pid = 0;
		arrivalTime = 0;
		cpuTimeRequired = 0;
		cpuTimeRemaining = 0;
	}
	
	/*
	 * This method receives the parameters for the job.
	 * @param arrivalTime The time the job enters the system.
	 * @param pid the specific ID for the job.
	 * @param cpuTimeRequired the allocated time needed for the job to complete.
	 */
	
	public Job(int arrivalTime, int pid, int cpuTimeRequired){
		this.arrivalTime = arrivalTime;
		this.pid = pid;
		this.cpuTimeRequired = cpuTimeRequired;
		cpuTimeRemaining = cpuTimeRequired;
	}
	
	/*
	 * This method prints out the current stats on the job class.
	 */
	
	public void outputJobStats(){
		System.out.println(arrivalTime);
		System.out.println(pid);
		System.out.println(cpuTimeRemaining);
	}
	
	/*
	 * This method returns the arrival time.
	 * 
	 */
	public int getArrivalTime(){
		return arrivalTime;
	}
	
	/*
	 * This method returns the PID number of the job.
	 */
	
	public int getpid() {
		return pid;
	}
	
	/*
	 * This method clears the PID number.
	 */
	public void clearpid() {
		pid = 0;
	}
	
	/*
	 * This method returns how much time is left for the job in the CPU.
	 */
	
	public int getcpuTimeRemaining(){
		return cpuTimeRemaining;
	}
	
	/*
	 * This method returns how much time is takes for the job to complete originally.
	 */
	public int getcpuTimeRequired(){
		return cpuTimeRequired;
	}
	
	/*
	 * This method decreases the time counter by one.
	 */
	public void decrementTime(){
		cpuTimeRemaining--;
	}
}
