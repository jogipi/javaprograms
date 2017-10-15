/*
 * This class s used to hold the characteristics of the CPU processor. 
 */
public class CPU {
	private int cpuQuantumClock = 1;
	private Job temp = new Job();
	private boolean busyFlag = false;
	private int level = 0;
	
	/*
	 * This method sets the CPU's busy flag.
	 */
	
	public void setBusy(){
		busyFlag = true;
	}
	
	/*
	 * This method set's the CPU's busy flag to false.
	 */
	public void setNotBusy(){
		busyFlag = false;
	}
	
	/*
	 * This method checks whether the CPU is busy or not.
	 */
	public boolean isBusy(){
		return busyFlag;
	}
	
	/* 
	 * This method is used to decrement the Quantum clock.
	 */
	public void decrementQuantum() {
		cpuQuantumClock--;
	}
	
	/*
	 * This method is used to set the appropriate quantum value to level 1.
	 */
	
	public void setQuantumLevel1(){
		cpuQuantumClock = 2;
		level = 1;
	}
	
	/*
	 * This method is used to set the appropriate quantum value to level 2.
	 */
	
	public void setQuantumLevel2() {
		cpuQuantumClock = 4;
		level = 2;
	}
	
	/*
	 * This method is used to set the appropriate quantum value to level 3.
	 */
	
	public void setQuantumLevel3() {
		cpuQuantumClock = 8;
		level = 3;
	}
	
	/*
	 * This method is used to set the appropriate quantum value to level 4.
	 */
	
	public void setQuantumLevel4() {
		cpuQuantumClock = 16;
		level = 4;
	}

	/*
	 * This method passes the current job to the CPU and sets the flag to busy.
	 * @param currentJob is the job object which holds the PID, CPU time remaining, and sets the busy flag.
	 */
	
	public void setcpuJob(Job currentJob) {
		temp = currentJob;
		setBusy();
	}
	
	/*
	 * This method returns the quantum clocks current value.
	 */

	public int getQuantum() {
		return cpuQuantumClock;
	}
	
	/*
	 * This method returns the object in the  CPU currently.
	 * 
	 */
	
	public Object getJob() {
		return temp;
	}
	
	/*
	 * This method returns the Quantum level the CPu is currently on.
	 */
	
	public int getLevel() {
		return level;
	}
	
	/*
	 * This method clears the quantum level.
	 */
	
	public void clearLevel() {
		level = 0;
	}
	
	/*
	 * This method clears the CPU from all characteristics.
	 */
	
	public void clearCPU() {
		level = 0;
		temp = new Job();
		busyFlag = false;
		cpuQuantumClock = 0;
	}
}
