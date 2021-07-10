//----------------------------------------------------- 
// Title: Linked list, STACK, QUEUE
// Author: Doruk Arslan
// Description: This class is uses for creating a queue which is consist of the data that scanned from the text file. Moreover, it uses for calculating the appropriate number of students to get vaccined per day by traviling around the queue object that have created.
//-----------------------------------------------------
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vaccine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// in order to hold capacity data
		 int Capacity = 0 ;
		 
		 // Since the first line of the text contains the data of the capacity, It is logical to scan it uniqely by  a boolean  variable(which is firstData)
		 boolean firstData = true;
		 myQueue<String> queue = new myQueue<>();
		 //  queue obeject type of String using Generics
		 
		 
		 // the strutcture depends on try catch statemants in order to see if a problem about scanning file will occur 
		 try {
			 
			 // Path of the file 
			File file = new File("/Users/doruk/Desktop/Academic Projects/COVID19.txt");
		    // to scan  file
			Scanner key = new Scanner(file);
		    
		    // We are controlling while statment by hasNextLine method to understand wheter the file finished or not. 
		    while (key.hasNextLine()) {
		    	
		    	
		        String data = key.nextLine();
		        if(firstData) {
		        	//the obtain Capacity
		        	Capacity = Integer.parseInt(data);
		        	firstData = false;
		        	continue;
		        }
		        
		       // after first line(capacity), we are adding all elements line by line with enqueue method to the queue that we created.
		        queue.enqueue(data);
		        
		      }
		    
		      key.close();
		 }
		 
		 catch (FileNotFoundException e){
			 // error message if file won't found
			 System.out.println("File not found");
			 
		 }
		 
		 // to collect  whole number of the students 
		 int totalVacinated = 0;
		// to collect  whole number of the days 
		 int Daycount = 0;
		 
		 
		 // We are controlling days with for loop and travel around the whole  Groups with while loop to compare the addition of the Student numbers with Capacity.
		 for(int i = 0; i<= queue.size()*2; i++) {
			
			 
			 // Since we control days with for loop we are increains daycount in every itteration.
			 Daycount ++;
			
			 // to collect daily count inside while loop. Hence, we are reseting it in every itteration(Every day)
			 int DailyCount = 0;
			 
			 String str = "" ;
			 // to collect appropriate strings in order to print
			 if(!queue.isEmpty()) {
				 
				 
				 // to collect appropriate strings in order to print

				 str += "Day"+(i+1)+": ";
				 
				 
				 
				 while(DailyCount <= Capacity && !queue.isEmpty()) {
					 	// we are get inside the while loop every time DailyCount <= Capacity operation is satisfied. Which means we are getting aditon of whole groups that do not pass the capacity
					 
						//to compare numbers with capacity we first just return and investigate it without removing.Thats why we use peek method
						 String data = queue.peek();
						
						 // Since data contains two seperate information (groupnum and sizeof students) we are dividing the data that we recieve into two parts as groupName and groupSize via split funciton. To hold those values in an array we created temp array and assigned it's values to appropriate variables. 
						 String[] temp = data.split(" ");
						
						 String groupName = temp[0];
						 int groupSize = Integer.parseInt(temp[1]);
						 
						 if(DailyCount+groupSize <= 50){
							 // To check wheter the addition of student numbers into group is passing capacity
							 // if it is we are terminating the loop with else statment 
							 // if it is not, we are removing the element from the queue and add it's information to the str variable that will be printed
							 queue.dequeue();
							 str += data + " ";
							 
							 // since we added a new group to the day we are incresing dailyCount with size of the group
							 DailyCount += groupSize;
							 
						 }
						 else {
							 

							 break;
						 }
						
					 }
				 // to print intended data of group(s) in a day
				 System.out.println(str);
				 
				 
				 // to hold total number o students we are incresing totalVacinated every day.
				 totalVacinated += DailyCount;
			 }
			 else {
				
				 
				 break;
			 }
		 }
		 // to pritnt total datas that calculated inside the loops
		 System.out.println("Total Student : "+ totalVacinated);
		 System.out.println("Total Day : "+ Daycount);
		 
		 
		 
		 
	}

}
