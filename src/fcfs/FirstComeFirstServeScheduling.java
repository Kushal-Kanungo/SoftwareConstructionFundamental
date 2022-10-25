package fcfs;


/**
 * 
 * 
 * @author Kushal
 * @since 15 Oct 2022
 */
public class FirstComeFirstServeScheduling {
	
	private int[] arrivalTime;
	private int[] burstTime;
	private int[] completionTime;
	private int[] turnAroundTime;
	private int[] waitingTime;
	private int numberOfProcesses;
	private double averageWaitingTime;
	private int maxWaitingTime;
	
	/**
	 * Constructor for FcfsScheduling Class. We calculate all the values required.
	 * Computing all the values saving us from iterating and calculation multiple time.
	 * 
	 * 
	 * @param arrivalTime
	 * @param burstTime
	 */
	public FirstComeFirstServeScheduling(int[] arrivalTime, int[] burstTime) {
		super();
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.numberOfProcesses = arrivalTime.length;
		this.maxWaitingTime = 0;
		this.completionTime =new int[this.numberOfProcesses];
		this.turnAroundTime =new int[this.numberOfProcesses];
		this.waitingTime =new int[this.numberOfProcesses];
		
		this.calcCompletionTime();
		this.calcTurnAroundTime();
		this.calcWaitingTime();
		this.calcAverageWaitingTime();
		this.calcMaxWaitingTime();
		
	}

	/**
	 * Completion Time is time taken from first arrival of process to completion of 
	 * a process
	 * 
	 * @author Kushal
	 * @return
	 */
	public void calcCompletionTime() {		
		int currentTime = 0;
		for(int index = 0; index<this.arrivalTime.length; index++) {			
			this.completionTime[index] = Math.max(this.arrivalTime[index], currentTime)+this.burstTime[index];
			currentTime = this.completionTime[index];
		}
	}
	
	/**
	 * Turn Around Time is difference between completion time and arrival time
	 * 
	 * @author Kushal
	 * @return
	 */
	public void calcTurnAroundTime () {
		for (int index = 0; index < this.numberOfProcesses; index++) {
			this.turnAroundTime[index] = this.completionTime[index]-arrivalTime[index];
		}
	}
	
	/**
	 * Waiting Time is the difference between TurnAroundTime and Burst Time
	 * 
	 * @author Kushal
	 * @return
	 */
	public void calcWaitingTime() {
		int n = arrivalTime.length;
		for (int index = 0; index < n; index++) {
			this.waitingTime[index] = this.turnAroundTime[index]-this.burstTime[index];
		}
	}
	/**
	 * Calculation of average wait time is first find waiting time and then find
	 * 
	 * @author Kushal
	 * @return
	 */
	public void calcAverageWaitingTime() {
		int totalTime = 0;
		for (int processWaitTime : this.waitingTime) {
			totalTime+= processWaitTime;
		}
		 this.averageWaitingTime = totalTime/this.numberOfProcesses;
	}
	
	/**
	 * First We find waiting time and them take out the maximum waiting time.
	 * 
	 * @author Kushal
	 * @param arrivalTime
	 * @param burstTime
	 * @return
	 */
	public void calcMaxWaitingTime() {
		for (int procesWaitTime : this.waitingTime) {
			this.maxWaitingTime = Math.max(this.maxWaitingTime, procesWaitTime);
		}
	}
	
	/**
	 * Getter from Maximum Waiting Time
	 *
	 * @author Kushal
	 * 
	 * @return
	 */
	public int getMaxWaitingTime() {
		return maxWaitingTime;
	}
	
	/**
	 * Getter from Completion Waiting Time
	 * 
	 * @return
	 */
	public int[] getCompletionTime() {
		return completionTime;
	}

	/**
	 * 
	 * 
	 * @author Kushal
	 * @return turnAroundTime Array
	 */
	public int[] getTurnAroundTime() {
		return turnAroundTime;
	}

	/**
	 * 
	 * @author Kushal
	 * @return Waiting Time Array
	 */
	public int[] getWaitingTime() {
		return waitingTime;
	}

	/**
	 * 
	 * @author Kushal
	 * @return Average Waiting Time
	 */
	public double getAverageWaitingTime() {
		return averageWaitingTime;
	}
	
	
}
