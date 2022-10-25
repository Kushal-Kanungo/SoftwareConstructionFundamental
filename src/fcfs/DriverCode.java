package fcfs;

import java.util.Scanner;

/**
 * Class: Driver Code 
 * 
 * @author Kushal
 * @since 16 Oct 2022 04:00 PM
 *
 */
public class DriverCode {
	/**
	 * This Function Will Print The Table Of Given Column 
	 * 
	 * @param columnName
	 * @param arrivalTime
	 * @param burstTime
	 * @param columnArray
	 */
	public static void printTable(String columnName,int[] arrivalTime, int[] burstTime ,int[] columnArray) {
		System.out.println("\nAT\tBT\t"+columnName);
		for (int i = 0; i < arrivalTime.length; i++) {
			System.out.println(arrivalTime[i]+"\t"+burstTime[i]+"\t"+columnArray[i]);
		}
	}
	
	/**
	 * It Displays the Menu 
	 * 
	 * @author Kushal
	 */
	public static void displayMenu() {
		System.out.println("First Come First Serve Scheduling Algorithm");
		System.out.println("-------------------------------------------");
		System.out.println(" 1 => To Find The Completion Time ");
		System.out.println(" 2 => To Find The TurnAround  Time ");
		System.out.println(" 3 => To Find The Waiting Time ");
		System.out.println(" 4 => To Find The Average Waiting Time ");
		System.out.println(" 5 => To Find The Max Waiting Time ");
		System.out.println(" 0 => TO Exit The Program ");
		System.out.println("-------------------------------------------");
		
		System.out.print("\nEnter the Option Number : ");
	}
	
	/**
	 * To Print Error Message and wait for user to Enter to proceed
	 * 
	 * @param msg
	 * @param sc
	 */
	public static void errorMessage(String msg, Scanner sc) {
		System.out.print(msg);
		sc.nextLine();
		sc.nextLine();
	}
	
	/**
	 * This is just a driver code it will make use of all the function made in FcfsSheduling Class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		FirstComeFirstServeScheduling fcfs;  
		Scanner sc = new Scanner(System.in);
		int[] arrivalTime;
		int[] burstTime;
		int option;
		
		while (true) {
			try {
				System.out.println("Enter Number OF Process");
				int n = sc.nextInt();
				System.out.println("Enter Arrival Time Seperated by Space :");
				arrivalTime = new int[n];
				burstTime = new int[n];
				for (int i = 0; i < n; i++) {
					arrivalTime[i] = sc.nextInt();
					if ((i>0) && (arrivalTime[i-1]>arrivalTime[i])){
						throw new Exception();
					}
				}
				System.out.println("Enter Burst Time Seperated by Space :");
				for (int i = 0; i < n; i++) {
					burstTime[i] = sc.nextInt();
				} 
				break;
			} catch (Exception e) {
				errorMessage("Input Was Wrong Please Enter Again..", sc);
			}
		}
		
		fcfs = new FirstComeFirstServeScheduling(arrivalTime, burstTime);
		
		loop:
		while (true) {
			try {
				displayMenu();
				option = sc.nextInt();
				switch (option) {
				case 1:
					int[] completionTime = fcfs.getCompletionTime();
					printTable("CT", arrivalTime, burstTime, completionTime);
					break;
				case 2:
					int[] turnAroundTime = fcfs.getTurnAroundTime();
					printTable("TT", arrivalTime, burstTime, turnAroundTime);
					break;
				case 3:
					int[] waitingTime = fcfs.getWaitingTime();
					printTable("WT", arrivalTime, burstTime, waitingTime);
					break;
				case 4:
					double averageTime = fcfs.getAverageWaitingTime();
					System.out.println("Average Waiting Time :" + averageTime);
					break;
				case 5:
					int maxTime = fcfs.getMaxWaitingTime();
					System.out.println("Max Waiting Time : " + maxTime);
					break;
				case 0:
					System.out.println("Exit Successfully");
					break loop;
				default:
					errorMessage("Please Enter from 0 to 5...", sc);
					continue;
				}
				errorMessage("Press Enter To Continue...", sc);
			} catch (Exception e) {
				errorMessage("You Entered An Invalid Input...", sc);
			}
		}
		sc.close();
		
	}
}
