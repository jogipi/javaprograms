// programming the SJF scheduling algorithm

import java.util.*;

public class HandSimulation
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int index = 1;
    ArrayList<Task> tasks = new ArrayList<Task>(); // storage for tasks
    while (input.hasNextInt())       // read CPU burst times of tasks 
    { 
      int burst = input.nextInt();         // create a new task
      tasks.add(new Task(index, burst));   // and add it to an array
      index++;
    }    
    int numTasks = tasks.size();           // total number of tasks

    Task[] tasksA = tasks.toArray(new Task[tasks.size()]); // convert ArrayList
    Comparator<Task> c = new Comparator<Task>()            // into array
    {                                 
      public int compare(Task t1, Task t2) // comparator for sorting
      {
        return(t1.burst - t2.burst);
      }
    };
    Arrays.sort(tasksA, c);                // sort tasks by burst times

    System.out.println(numTasks + " created"); // print the schedule
    int waitingTime = 0;
    int time = 0;
    System.out.print("0");
    for (int i=0; i<tasksA.length; i++)
    {
      Task t = tasksA[i];
      time += t.burst;
      System.out.print(" - P" + t.index + " - " + time);
      if (i < tasksA.length -1)
        waitingTime += time;
    }
    System.out.println("\nAverage waiting time: " + waitingTime + "/" +
      numTasks + " = " + ((1.0*waitingTime)/numTasks));
  }
  
}


